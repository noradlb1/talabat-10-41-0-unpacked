package ue;

import android.view.View;
import com.talabat.CartScreen;
import datamodels.Coupon;

public final /* synthetic */ class b2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57444b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Coupon f57445c;

    public /* synthetic */ b2(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, Coupon coupon) {
        this.f57444b = cartRecyclerviewAdapter;
        this.f57445c = coupon;
    }

    public final void onClick(View view) {
        this.f57444b.lambda$onBindViewHolder$4(this.f57445c, view);
    }
}
