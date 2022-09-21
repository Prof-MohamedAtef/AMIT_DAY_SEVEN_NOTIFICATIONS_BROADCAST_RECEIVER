package mo.atef.amit.amit_dayseven.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class AirPlaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirPlaneModeOn(context.getApplicationContext())){
            //true
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
            Log.e("Receiver","Status: On");
            Log.d("Receiver","Status: On");
        }else {
            //false
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show();
            Log.e("Receiver","Status: off");
            Log.d("Receiver","Status: off");
        }
    }

    private static boolean isAirPlaneModeOn(Context context){
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
