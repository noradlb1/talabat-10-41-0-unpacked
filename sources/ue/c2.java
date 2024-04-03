package ue;

import android.view.View;
import com.talabat.CartScreen;
import datamodels.Coupon;

public final /* synthetic */ class c2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57460b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Coupon f57461c;

    public /* synthetic */ c2(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, Coupon coupon) {
        this.f57460b = cartRecyclerviewAdapter;
        this.f57461c = coupon;
    }

    public final void onClick(View view) {
        this.f57460b.lambda$onBindViewHolder$5(this.f57461c, view);
    }
}
