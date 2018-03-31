package utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import app.Latte;

/**
 * Created by chawei on 2018/3/31.
 */

public class DimenUtil {

    public static final int getScreenWidth(){
        final Resources resources= Latte.getApplication().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static final int getScreenHeight(){
        final Resources resources= Latte.getApplication().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
