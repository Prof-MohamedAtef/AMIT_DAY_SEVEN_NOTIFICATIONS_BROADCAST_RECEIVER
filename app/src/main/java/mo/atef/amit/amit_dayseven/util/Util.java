package mo.atef.amit.amit_dayseven.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.net.URL;

public class Util {
    public static Bitmap convertToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(600,600, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, 600,600);
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap urlToBitmap(String url){
        try {
            URL url_ = new URL(url);
            return BitmapFactory.decodeStream(url_.openConnection().getInputStream());
        } catch(IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
