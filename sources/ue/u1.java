package ue;

import android.view.View;
import com.talabat.CartScreen;

public final /* synthetic */ class u1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartCustomizationViewHolder f57765b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57766c;

    public /* synthetic */ u1(CartScreen.CartCustomizationViewHolder cartCustomizationViewHolder, View.OnClickListener onClickListener) {
        this.f57765b = cartCustomizationViewHolder;
        this.f57766c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57765b.lambda$bindFees$0(this.f57766c, view);
    }
}
