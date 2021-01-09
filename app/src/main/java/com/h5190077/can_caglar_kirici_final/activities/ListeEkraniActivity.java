package com.h5190077.can_caglar_kirici_final.activities;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;


import com.h5190077.can_caglar_kirici_final.R;
import com.h5190077.can_caglar_kirici_final.adaptor.KitapAdaptor;
import com.h5190077.can_caglar_kirici_final.model.KitapModel;
import com.h5190077.can_caglar_kirici_final.network.Service;
import com.h5190077.can_caglar_kirici_final.util.AlertDialogUtil;
import com.h5190077.can_caglar_kirici_final.util.Constants;
import com.h5190077.can_caglar_kirici_final.util.GlideUtil;
import com.h5190077.can_caglar_kirici_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeEkraniActivity extends AppCompatActivity {


    String tiklananKitapString;
    RecyclerView recyclerViewKitaplar;
    Intent KitapDetayIntent;
    KitapAdaptor kitapAdaptor;
    KitapModel tiklananKitap;

    ProgressDialog progressDialog;

    String alertDialogCikis;
    String alertDialogEvet;
    String alertDialogHayir;
    String progressDialogBekleyin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_ekrani);

        init();


    }



    private void init()
    {
        alertDialogCikis = getString(R.string.alertCikis);
        alertDialogEvet = getString(R.string.alertEvet);
        alertDialogHayir = getString(R.string.alertHayir);
        progressDialogBekleyin = getString(R.string.alertProgressMesaj);

        progressDialog = new ProgressDialog(ListeEkraniActivity.this);
        progressDialog.setMessage(progressDialogBekleyin);


        kitaplariGetir();


    }
    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialogGoster(this,alertDialogCikis,"",alertDialogEvet,alertDialogHayir,"");

    }
    void kitaplariGetir()
    {

        progressDialog.show();
        new Service().getServiceApi().kitaplariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KitapModel>>() {

                    List<KitapModel> kitaplar = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");

                    }

                    @Override
                    public void onNext(List<KitapModel> kitapModelList) {

                        Log.e("RETROFIT","onNext : ");
                        kitaplar = kitapModelList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                        progressDialog.cancel();
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(kitaplar.size()>0) {



                            initRecycleView(kitaplar);

                        }
                        progressDialog.cancel();
                    }
                });

    }


    private  void  initRecycleView(List<KitapModel> kitapModelList)
    {
        recyclerViewKitaplar = findViewById(R.id.rcvKitaplar);
        kitapAdaptor = new KitapAdaptor(kitapModelList, getApplicationContext(), new KitapAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                tiklananKitap = kitapModelList.get(position);
                openNextActivity(tiklananKitap);
            }
        });
        recyclerViewKitaplar.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewKitaplar.setAdapter(kitapAdaptor);
    }

    private void openNextActivity (KitapModel tiklananKitap){

        KitapDetayIntent = new Intent(getApplicationContext(),KitapDetayActivity.class);
        tiklananKitapString = ObjectUtil.kitapToJsonString(tiklananKitap);
        KitapDetayIntent.putExtra(Constants.TIKLANAN_BURC_TASINANIN_BASLIGI,tiklananKitapString);
        startActivity(KitapDetayIntent);

    }

}