package com.assembly.app;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import app.Latte;
import assembly.com.latte.ec.icon.FontEcModule;

/**
 * Created by chawei on 2018/3/30.
 */

public class ExampleApp extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .configure();

    }
}
