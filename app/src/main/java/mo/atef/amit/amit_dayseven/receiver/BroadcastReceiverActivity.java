package mo.atef.amit.amit_dayseven.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import mo.atef.amit.amit_dayseven.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    /*
    BroadcastReceiver

    actions that broadcastreceiver always triggers:
    1.android.intent.action.BATTERY_LOW (Indicates low battery condition on the device.)
    2.android.intent.action.BOOT_COMPLETED (This is broadcast once after the system has finished booting)
    3.android.intent.action.CALL (To perform a call to someone specified by the data)
    4.android.intent.action.DATE_CHANGED (Indicates that the date has changed)
    5.android.intent.action.REBOOT (Indicates that the device has been a reboot)
    6.android.net.conn.CONNECTIVITY_CHANGE (The mobile network or wifi connection is changed(or reset)
    7.android.intent.ACTION_AIRPLANE_MODE_CHANGED (This indicates that airplane mode has been switched on or off.)
     */


    AirPlaneModeReceiver airPlaneModeReceiver=new AirPlaneModeReceiver();
    WifiConnReceiver wifiConnReceiver=new WifiConnReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // airplane mode receiver
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airPlaneModeReceiver, intentFilter);

        //wifi changes receiver
        IntentFilter wifiFilter = new IntentFilter();
        wifiFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(wifiConnReceiver, wifiFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(airPlaneModeReceiver);
        unregisterReceiver(wifiConnReceiver);
    }
}