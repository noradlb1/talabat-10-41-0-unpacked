package com.talabat.darkstores.feature.cart;

import androidx.fragment.app.FragmentActivity;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragment$onCheckoutClicked$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragment f56252g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragment$onCheckoutClicked$2(CartFragment cartFragment) {
        super(0);
        this.f56252g = cartFragment;
    }

    public final void invoke() {
        CartFragmentViewModel cartFragmentViewModel = this.f56252g.getCartFragmentViewModel();
        FragmentActivity activity = this.f56252g.getActivity();
        if (activity != null) {
            CartFragmentViewModel.checkout$default(cartFragmentViewModel, (DarkstoresMainActivity) activity, (CheckoutParams) null, 2, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.feature.main.DarkstoresMainActivity");
    }
}
