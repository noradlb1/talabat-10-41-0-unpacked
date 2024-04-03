package ue;

import android.view.View;
import com.talabat.CartScreen;

public final /* synthetic */ class w1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartCustomizationViewHolder f57801b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57802c;

    public /* synthetic */ w1(CartScreen.CartCustomizationViewHolder cartCustomizationViewHolder, View.OnClickListener onClickListener) {
        this.f57801b = cartCustomizationViewHolder;
        this.f57802c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57801b.lambda$bindFees$2(this.f57802c, view);
    }
}
