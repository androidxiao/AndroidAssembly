package com.assembly.app;

import android.support.multidex.MultiDexApplication;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import assembly.com.latte.core.app.Latte;
import assembly.com.latte.core.net.interceptors.DebugInterceptor;
import assembly.com.latte.ec.icon.FontEcModule;

/**
 * Created by chawei on 2018/3/30.
 */

public class ExampleApp extends MultiDexApplication{


    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();

    }
}
