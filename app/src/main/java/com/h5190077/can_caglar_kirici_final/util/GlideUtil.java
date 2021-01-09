package com.h5190077.can_caglar_kirici_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190077.can_caglar_kirici_final.R;

public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.ic_book_of_black_cover_closed)
                .centerCrop()
                .into(img);
    }
}
