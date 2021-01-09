package com.h5190077.can_caglar_kirici_final.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;

import com.h5190077.can_caglar_kirici_final.R;
import com.h5190077.can_caglar_kirici_final.util.Constants;
import com.h5190077.can_caglar_kirici_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    Intent listeEkraniIntent;
    CountDownTimer splashEkraniCountDownTimer;
    AlertDialog.Builder splashEkraniDialogbuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();

    }
    private void init(){
        timeriBaslat();
    }
    private void timeriBaslat()
    {
        splashEkraniCountDownTimer = new
                CountDownTimer(Constants.INTERVAL,Constants.MILISECOND) {
                    @Override
                    public void onTick(long l) {
                    }
                    @Override
                    public void onFinish() {
                        internetKontrol();
                    }
                };
        splashEkraniCountDownTimer.start();
    }


    private void internetKontrol(){
        if (NetworkUtil.internetVarMi(getApplicationContext())){
            ekranGecisiYap();
        }else{
            splashEkraniDialogbuilder = new AlertDialog.Builder(SplashActivity.this);
            splashEkraniDialogbuilder.setTitle("İnternet Bağlantınız Yok");
            splashEkraniDialogbuilder.setMessage("Uygulamayı kullanmak için internete bağlayın.");
            splashEkraniDialogbuilder.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            splashEkraniDialogbuilder.setPositiveButton("İnterneti Aç", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            });
            splashEkraniDialogbuilder.show();
        }
    }
    private void ekranGecisiYap(){
        listeEkraniIntent = new Intent(getApplicationContext(),ListeEkraniActivity.class);
        startActivity(listeEkraniIntent);
        finish();

    }

}