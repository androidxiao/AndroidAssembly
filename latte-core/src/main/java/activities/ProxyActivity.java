package activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import assembly.com.latte.R;
import delegates.LatteDelegate;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by chawei on 2018/3/30.
 */

public abstract class ProxyActivity extends SupportActivity{

    public abstract LatteDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //因为是单Activity，多Fragment架构，所以这里可以调用垃圾回收机制。虽然不一定执行，但该做的还得做。
        System.gc();
        System.runFinalization();
    }
}
