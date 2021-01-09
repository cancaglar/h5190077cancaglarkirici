package com.h5190077.can_caglar_kirici_final.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;


public class AlertDialogUtil {


    public static void alertDialogGoster(Context context, String message, String title,String yes, String no, String screen )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(screen.equals("SplashActivity")){
                    context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    ((Activity)context).finish();
                }else{
                    //((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }
            }
        });
        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (screen.equals("SplashActivity")){

                    ((Activity)context).finish();
                }else{
                    dialog.cancel();
                }
            }
        });
        builder.show();
    }
}
