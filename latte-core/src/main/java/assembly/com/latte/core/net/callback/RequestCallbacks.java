package assembly.com.latte.core.net.callback;

import android.os.Handler;

import assembly.com.latte.core.app.ConfigType;
import assembly.com.latte.core.app.Latte;
import assembly.com.latte.core.ui.LatteLoader;
import assembly.com.latte.core.ui.LoaderStyle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chawei on 2018/3/31.
 */

public class RequestCallbacks implements Callback<String>{

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = Latte.getHandler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error,LoaderStyle loaderStyle) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE=loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        }else{
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        stopLoadingView();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }

        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        stopLoadingView();
    }

    private void stopLoadingView() {
        final long delayed = Latte.getConfiguration(ConfigType.LOADER_DELAYED);
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            },delayed);
        }
    }
}
