package nv;

import android.view.View;
import com.talabat.talabatcommon.views.grocery.GroceryVendorViewHolder;
import datamodels.Restaurant;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryVendorViewHolder f24002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f24003c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24004d;

    public /* synthetic */ a(GroceryVendorViewHolder groceryVendorViewHolder, Restaurant restaurant, int i11) {
        this.f24002b = groceryVendorViewHolder;
        this.f24003c = restaurant;
        this.f24004d = i11;
    }

    public final void onClick(View view) {
        GroceryVendorViewHolder.m5767bind$lambda0(this.f24002b, this.f24003c, this.f24004d, view);
    }
}
