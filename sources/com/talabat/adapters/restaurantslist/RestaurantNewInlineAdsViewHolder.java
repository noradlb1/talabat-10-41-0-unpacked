package com.talabat.adapters.restaurantslist;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class RestaurantNewInlineAdsViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f55302h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f55303i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f55304j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f55305k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f55306l;

    /* renamed from: m  reason: collision with root package name */
    public View f55307m;

    public RestaurantNewInlineAdsViewHolder(View view) {
        super(view);
        this.f55302h = (ProgressBar) view.findViewById(R.id.progressBar);
        this.f55303i = (ImageView) view.findViewById(R.id.imageView_restaurantLogo);
        this.f55304j = (TextView) view.findViewById(R.id.textView_restaurantName);
        this.f55305k = (TextView) view.findViewById(R.id.textView_cuisines);
        this.f55306l = (ImageView) view.findViewById(R.id.imageView_adImage);
        this.f55307m = view.findViewById(R.id.layout_preOrder);
    }
}
