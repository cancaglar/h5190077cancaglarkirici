package com.h5190077.can_caglar_kirici_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KitapModel {
    @SerializedName("KitapAdi")
    @Expose
    private String kitapAdi;
    @SerializedName("YazarAdi")
    @Expose
    private String yazarAdi;
    @SerializedName("SeriSirasi")
    @Expose
    private String seriSirasi;
    @SerializedName("BasimTarihi")
    @Expose
    private String basimTarihi;
    @SerializedName("KitapDetay")
    @Expose
    private String kitapDetay;
    @SerializedName("KucukLogoUrl")
    @Expose
    private String kucukLogoUrl;
    @SerializedName("BuyukLogoUrl")
    @Expose
    private String buyukLogoUrl;

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getSeriSirasi() {
        return seriSirasi;
    }

    public void setSeriSirasi(String seriSirasi) {
        this.seriSirasi = seriSirasi;
    }

    public String getBasimTarihi() {
        return basimTarihi;
    }

    public void setBasimTarihi(String basimTarihi) {
        this.basimTarihi = basimTarihi;
    }

    public String getKitapDetay() {
        return kitapDetay;
    }

    public void setKitapDetay(String kitapDetay) {
        this.kitapDetay = kitapDetay;
    }

    public String getKucukLogoUrl() {
        return kucukLogoUrl;
    }

    public void setKucukLogoUrl(String kucukLogoUrl) {
        this.kucukLogoUrl = kucukLogoUrl;
    }

    public String getBuyukLogoUrl() {
        return buyukLogoUrl;
    }

    public void setBuyukLogoUrl(String buyukLogoUrl) {
        this.buyukLogoUrl = buyukLogoUrl;
    }

}
