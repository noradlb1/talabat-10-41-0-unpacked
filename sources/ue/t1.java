package ue;

import android.view.View;
import com.talabat.CartScreen;

public final /* synthetic */ class t1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartCustomizationViewHolder f57747b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57748c;

    public /* synthetic */ t1(CartScreen.CartCustomizationViewHolder cartCustomizationViewHolder, View.OnClickListener onClickListener) {
        this.f57747b = cartCustomizationViewHolder;
        this.f57748c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57747b.lambda$bindDeliveryChargesView$7(this.f57748c, view);
    }
}
