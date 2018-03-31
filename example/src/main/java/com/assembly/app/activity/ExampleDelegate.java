package com.assembly.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.assembly.app.R;

import net.RestClient;
import net.callback.IError;
import net.callback.IFailure;
import net.callback.ISuccess;

import delegates.LatteDelegate;

/**
 * Created by chawei on 2018/3/31.
 */

public class ExampleDelegate extends LatteDelegate {


    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
        Log.d("ez", "onBindView: 1111111111111");
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.d("ez", "onFailure: ");
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Log.d("ez", "onFailure: " + message + " --->" + code);

                    }
                })
                .build()
                .get();
    }
}
