package com.talabat.adapters.restaurantslist;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

class SearchDishViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f55319h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f55320i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f55321j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f55322k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f55323l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f55324m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f55325n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f55326o;

    public SearchDishViewHolder(View view) {
        super(view);
        this.f55319h = (ProgressBar) view.findViewById(R.id.progressBar);
        this.f55320i = (ImageView) view.findViewById(R.id.imageView_itemImage);
        this.f55321j = (TextView) view.findViewById(R.id.textView_dishName);
        this.f55322k = (TextView) view.findViewById(R.id.textView_restaurantName);
        this.f55323l = (TextView) view.findViewById(R.id.textView_itemPrice);
        this.f55324m = (TextView) view.findViewById(R.id.textView_dishSimilar);
        this.f55325n = (LinearLayout) view.findViewById(R.id.linearLayout_similarContainer);
        this.f55326o = (TextView) view.findViewById(R.id.textView_restaurantStatus);
    }
}
