package unmsm.com.logingooglelap.Util;

import android.graphics.drawable.GradientDrawable;
import android.widget.Button;

/**
 * Created by Luis on 10/11/2017.
 */
/*
* Esta clase sirve para darle formato a las celdas de una tabla de forma programatica.
* */


public class Util {

    public static void bordecolorboton(Button b, int color, int radio){
        if (b!=null){
            GradientDrawable gd = new GradientDrawable();
            if (color!=0){
                gd.setColor(color);
            }
            gd.setCornerRadius(radio);
            // gd.setStroke(1, 0xFF011580);
            b.setBackground(gd);
        }
    }
}