package com.talabat.adapters.restaurantslist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

class InstantSearchViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55295h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55296i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f55297j;

    public InstantSearchViewHolder(View view) {
        super(view);
        this.f55295h = (ImageView) view.findViewById(R.id.imageView_restaurantLogo);
        this.f55296i = (TextView) view.findViewById(R.id.textView_restaurantName);
        this.f55297j = (TextView) view.findViewById(R.id.textView_restaurantStatus);
    }
}
