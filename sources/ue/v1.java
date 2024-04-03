package ue;

import android.view.View;
import com.talabat.CartScreen;

public final /* synthetic */ class v1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartCustomizationViewHolder f57788b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57789c;

    public /* synthetic */ v1(CartScreen.CartCustomizationViewHolder cartCustomizationViewHolder, View.OnClickListener onClickListener) {
        this.f57788b = cartCustomizationViewHolder;
        this.f57789c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57788b.lambda$bindFees$1(this.f57789c, view);
    }
}
