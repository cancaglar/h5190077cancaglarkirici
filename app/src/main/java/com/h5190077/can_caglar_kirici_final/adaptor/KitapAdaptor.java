package com.h5190077.can_caglar_kirici_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190077.can_caglar_kirici_final.R;
import com.h5190077.can_caglar_kirici_final.model.KitapModel;
import com.h5190077.can_caglar_kirici_final.util.GlideUtil;

import java.util.List;

public class KitapAdaptor extends RecyclerView.Adapter<KitapViewHolder> {


    List<KitapModel> kitaplar;
    Context context;
    OnItemClickListener listener;
    View itemView;
    public interface OnItemClickListener {

        void onClik(int position);

    }

    public KitapAdaptor(List<KitapModel> kitaplar, Context context, OnItemClickListener listener) {
        this.kitaplar = kitaplar;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public KitapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_kitap,parent,false);

        return new KitapViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull KitapViewHolder viewHolder, int position) {

        viewHolder.txtIsim.setText(kitaplar.get(position).getKitapAdi());
        viewHolder.txtYazarAdi.setText(kitaplar.get(position).getYazarAdi());
        viewHolder.txtBasimTarihi.setText(kitaplar.get(position).getBasimTarihi());
        viewHolder.txtSeriSirasi.setText(kitaplar.get(position).getSeriSirasi());
        GlideUtil.resmiIndiripGoster(context,kitaplar.get(position).getKucukLogoUrl(),viewHolder.imgKitap);

    }

    @Override
    public int getItemCount() {
        return kitaplar.size();
    }
}