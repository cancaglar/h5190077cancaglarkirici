package com.h5190077.can_caglar_kirici_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190077.can_caglar_kirici_final.R;
import com.h5190077.can_caglar_kirici_final.model.KitapModel;
import com.h5190077.can_caglar_kirici_final.util.Constants;
import com.h5190077.can_caglar_kirici_final.util.GlideUtil;
import com.h5190077.can_caglar_kirici_final.util.ObjectUtil;

public class KitapDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    String tasinanKitapString;
    KitapModel kitapModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_detay);

        init();
    }

    private void init(){
        tasinanKitapString = getIntent().getStringExtra(Constants.TIKLANAN_BURC_TASINANIN_BASLIGI);

        kitapModel = ObjectUtil.jsonStringToKitap(tasinanKitapString);

        imgKapak = findViewById(R.id.imgKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);



        txtBaslik.setText(kitapModel.getKitapAdi());
        txtDetay.setText(kitapModel.getKitapDetay());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),kitapModel.getBuyukLogoUrl(),imgKapak);


    }
}