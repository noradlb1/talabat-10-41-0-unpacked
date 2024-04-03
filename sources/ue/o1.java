package ue;

import android.view.View;
import com.talabat.CartScreen;
import library.talabat.mvp.cart.CartAdapterListener;

public final /* synthetic */ class o1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartAdapterListener f57672b;

    public /* synthetic */ o1(CartAdapterListener cartAdapterListener) {
        this.f57672b = cartAdapterListener;
    }

    public final void onClick(View view) {
        CartScreen.CartCustomizationViewHolder.lambda$bindVoucherView$9(this.f57672b, view);
    }
}
