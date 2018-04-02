package com.assembly.app.activity;

import assembly.com.latte.core.activities.ProxyActivity;
import assembly.com.latte.core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
