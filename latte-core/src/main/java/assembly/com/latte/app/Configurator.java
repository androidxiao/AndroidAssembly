package assembly.com.latte.app;

import java.util.WeakHashMap;

/**
 * Created by chawei on 2018/3/30.
 * <p>
 * 配置文件的存储以及获取
 */

public class Configurator {

    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    private static class Holder{
        private static final Configurator INSTANCCE = new Configurator();
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }
}
