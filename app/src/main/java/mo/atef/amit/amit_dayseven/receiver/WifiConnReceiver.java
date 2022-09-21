package mo.atef.amit.amit_dayseven.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

public class WifiConnReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            boolean connected = info.isConnected();
            if (connected) {
                Toast.makeText(context.getApplicationContext(), "Wifi connected", Toast.LENGTH_SHORT).show();
                Log.e("Wifi:", "Status: Connected");
                Log.d("Wifi:", "Status: Connected");
            } else {
                Toast.makeText(context.getApplicationContext(), "Wifi connection lost", Toast.LENGTH_SHORT).show();
                Log.e("Wifi:", "Status: Connection Lost");
                Log.d("Wifi:", "Status: Connection Lost");
            }
        }
    }
}