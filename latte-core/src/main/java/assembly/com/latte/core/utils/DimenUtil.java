package assembly.com.latte.core.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import assembly.com.latte.core.app.Latte;

/**
 * Created by chawei on 2018/3/31.
 */

public class DimenUtil {

    public static final int getScreenWidth(){
        final Resources resources= Latte.getApplicationContext().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static final int getScreenHeight(){
        final Resources resources= Latte.getApplicationContext().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
