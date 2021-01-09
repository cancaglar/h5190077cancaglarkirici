package com.h5190077.can_caglar_kirici_final.network;

import com.h5190077.can_caglar_kirici_final.model.KitapModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
public interface ServiceApi {

    @GET("kitaplar.json")
    Observable<List<KitapModel>> kitaplariGetir();
}
