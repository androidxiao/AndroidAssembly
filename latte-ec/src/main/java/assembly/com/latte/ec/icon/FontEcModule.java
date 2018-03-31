package assembly.com.latte.ec.icon;

import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by chawei on 2018/3/30.
 */

public class FontEcModule implements IconFontDescriptor {


    @Override
    public String ttfFileName() {
        return "iconfont";
    }

    @Override
    public com.joanzapata.iconify.Icon[] characters() {
        return EcIcons.values();
    }
}
