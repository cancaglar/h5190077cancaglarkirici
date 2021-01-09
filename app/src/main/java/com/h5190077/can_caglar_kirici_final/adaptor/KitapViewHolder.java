package com.h5190077.can_caglar_kirici_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190077.can_caglar_kirici_final.R;

public class KitapViewHolder extends RecyclerView.ViewHolder {

    ImageView imgKitap;
    TextView txtIsim;
    TextView txtYazarAdi;
    TextView txtSeriSirasi;
    TextView txtBasimTarihi;

    public KitapViewHolder(@NonNull View cardView, KitapAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgKitap = itemView.findViewById(R.id.imgKitap);
        txtIsim = itemView.findViewById(R.id.txtKitapAdi);
        txtYazarAdi = itemView.findViewById(R.id.txtYazarAdi);
        txtSeriSirasi = itemView.findViewById(R.id.txtSeriSirasi);
        txtBasimTarihi = itemView.findViewById(R.id.txtBasimTarihiGoster);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClik((getAdapterPosition()));
            }
        });
    }
}