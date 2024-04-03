package ri;

import android.view.View;
import com.talabat.darkstores.feature.cart.CartListAdapter;

public final /* synthetic */ class l1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter f57321b;

    public /* synthetic */ l1(CartListAdapter cartListAdapter) {
        this.f57321b = cartListAdapter;
    }

    public final void onClick(View view) {
        CartListAdapter.CartPartialFulfillmentViewHolder.m9829bind$lambda3$lambda1(this.f57321b, view);
    }
}
