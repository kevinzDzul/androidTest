package test.com.hellogenio.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import test.com.hellogenio.tools.Constant;

/**
 * Created by kevin on 23/10/17.
 */

public class NetworkChangeReceiverUtil extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(Constant.STATUS_NETWORK));
    }
}
