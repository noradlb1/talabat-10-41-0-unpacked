package jt;

import android.view.View;
import com.talabat.restaurants.v2.adapters.viewholders.VendorViewHolder;
import datamodels.Restaurant;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorViewHolder f62204b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f62205c;

    public /* synthetic */ a(VendorViewHolder vendorViewHolder, Restaurant restaurant) {
        this.f62204b = vendorViewHolder;
        this.f62205c = restaurant;
    }

    public final void onClick(View view) {
        VendorViewHolder.m10732bind$lambda0(this.f62204b, this.f62205c, view);
    }
}
