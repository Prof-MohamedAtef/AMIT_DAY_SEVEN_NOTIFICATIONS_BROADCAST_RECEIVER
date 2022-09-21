package mo.atef.amit.amit_dayseven.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class Util {
    public static Bitmap convertToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(600,600, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, 600,600);
        drawable.draw(canvas);
        return bitmap;
    }
}
