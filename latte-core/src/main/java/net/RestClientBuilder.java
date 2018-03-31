package net;

import android.content.Context;

import net.callback.IError;
import net.callback.IFailure;
import net.callback.IRequest;
import net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import ui.LoaderStyle;

/**
 * Created by chawei on 2018/3/31.
 */

public class RestClientBuilder {

    private String mUrl=null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest=null;
    private ISuccess mISuccess=null;
    private IFailure mIFailure=null;
    private IError mIError=null;
    private RequestBody mBody=null;
    private Context mContext=null;
    private LoaderStyle mLoaderStyle=null;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext=context;
        this.mLoaderStyle=LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequest, mISuccess, mIFailure, mIError, mBody,mLoaderStyle,mContext);
    }
}
