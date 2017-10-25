package test.com.hellogenio.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import test.com.hellogenio.tools.Constant;

/**
 * Created by kevin on 23/10/17.
 */

public class NetworkUtil {


    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return Constant.TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return Constant.TYPE_MOBILE;
        }
        return Constant.TYPE_NOT_CONNECTED;
    }

    public static int getConnectivityStatusString(Context context) {
        int conn = NetworkUtil.getConnectivityStatus(context);
        int status = 0;
        if (conn == Constant.TYPE_WIFI) {
            status = Constant.TYPE_WIFI; //status = "Wifi enabled";
        } else if (conn == Constant.TYPE_MOBILE) {
            status = Constant.TYPE_MOBILE;//status = "Mobile data enabled";
        } else if (conn == Constant.TYPE_NOT_CONNECTED) {
            status = Constant.TYPE_NOT_CONNECTED;//status = "Not connected to Internet";
        }
        return status;
    }
}