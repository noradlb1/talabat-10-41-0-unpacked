package com.talabat.darkstores.feature.cart;

import androidx.fragment.app.Fragment;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$onCheckoutClicked$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56271g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Fragment f56272h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$onCheckoutClicked$1(CartFragmentViewModel cartFragmentViewModel, Fragment fragment) {
        super(0);
        this.f56271g = cartFragmentViewModel;
        this.f56272h = fragment;
    }

    public final void invoke() {
        CartFragmentViewModel.checkout$default(this.f56271g, (DarkstoresMainActivity) this.f56272h.requireActivity(), (CheckoutParams) null, 2, (Object) null);
    }
}
