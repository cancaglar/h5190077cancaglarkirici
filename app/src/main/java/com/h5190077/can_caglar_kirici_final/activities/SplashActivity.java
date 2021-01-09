package com.h5190077.can_caglar_kirici_final.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;

import com.h5190077.can_caglar_kirici_final.R;
import com.h5190077.can_caglar_kirici_final.util.AlertDialogUtil;
import com.h5190077.can_caglar_kirici_final.util.Constants;
import com.h5190077.can_caglar_kirici_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    Intent listeEkraniIntent;
    CountDownTimer splashEkraniCountDownTimer;

    String alertDialogBaslik;
    String alertDialogMesaj;
    String alertDialogKapat;
    String alertDialogInternetAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();

    }
    private void init(){
        alertDialogBaslik = getString(R.string.alertInternetBaslik);
        alertDialogMesaj = getString(R.string.alertInternetMesaj);
        alertDialogInternetAc = getString(R.string.alertInternetAc);
        alertDialogKapat = getString(R.string.alertKapat);

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
            AlertDialogUtil.alertDialogGoster(this, alertDialogMesaj, alertDialogBaslik,alertDialogInternetAc,alertDialogKapat,"SplashActivity");
        }
    }
    private void ekranGecisiYap(){
        listeEkraniIntent = new Intent(getApplicationContext(),ListeEkraniActivity.class);
        startActivity(listeEkraniIntent);
        finish();

    }

}