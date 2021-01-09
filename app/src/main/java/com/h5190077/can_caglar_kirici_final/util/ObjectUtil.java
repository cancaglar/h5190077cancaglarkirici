package com.h5190077.can_caglar_kirici_final.util;

import com.google.gson.Gson;
import com.h5190077.can_caglar_kirici_final.model.KitapModel;

public class ObjectUtil {

    public  static String kitapToJsonString(KitapModel kitapModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(kitapModel);
    }

    public  static KitapModel jsonStringToKitap(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString, KitapModel.class);
    }
}
