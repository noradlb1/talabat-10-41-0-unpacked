package com.talabat.darkstores.feature.main;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class DarkstoresMainActivity$showBottomCartViewError$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DarkstoresMainActivity$showBottomCartViewError$1(Object obj) {
        super(0, obj, CartFragmentViewModel.class, "onRetry", "onRetry()V", 0);
    }

    public final void invoke() {
        ((CartFragmentViewModel) this.receiver).onRetry();
    }
}
