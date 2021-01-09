package com.h5190077.can_caglar_kirici_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    private static ConnectivityManager connectivityManager;
    private static  NetworkInfo networkInfo;

    public static boolean internetVarMi(Context context){
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }
}
