package ri;

import android.view.View;
import com.talabat.darkstores.feature.cart.CartFragment;
import com.talabat.darkstores.feature.cart.CartSummary;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragment f57337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartSummary f57338c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57339d;

    public /* synthetic */ p(CartFragment cartFragment, CartSummary cartSummary, boolean z11) {
        this.f57337b = cartFragment;
        this.f57338c = cartSummary;
        this.f57339d = z11;
    }

    public final void onClick(View view) {
        CartFragment.m9782showCartSummary$lambda5(this.f57337b, this.f57338c, this.f57339d, view);
    }
}
