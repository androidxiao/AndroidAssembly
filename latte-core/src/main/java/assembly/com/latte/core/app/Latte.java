package assembly.com.latte.core.app;

import android.content.Context;
import android.os.Handler;

import java.util.WeakHashMap;

/**
 * Created by chawei on 2018/3/30.
 */

public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
//        getConfigurations().put("APPLICATION_CONTEXT", context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static WeakHashMap<Object,Object> getConfigurations(){
        return getConfigurator().getLatteConfigs();
    }

    public static Context getApplicationContext(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }

}
