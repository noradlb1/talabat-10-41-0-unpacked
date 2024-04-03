package ri;

import android.view.View;
import com.talabat.darkstores.feature.cart.CartListAdapter;

public final /* synthetic */ class k1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter f57318b;

    public /* synthetic */ k1(CartListAdapter cartListAdapter) {
        this.f57318b = cartListAdapter;
    }

    public final void onClick(View view) {
        CartListAdapter.CartPartialFulfillmentViewHolder.m9828bind$lambda3$lambda0(this.f57318b, view);
    }
}
