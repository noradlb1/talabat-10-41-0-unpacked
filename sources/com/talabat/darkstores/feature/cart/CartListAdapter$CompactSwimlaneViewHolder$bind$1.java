package com.talabat.darkstores.feature.cart;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "lastVisiblePosition", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartListAdapter$CompactSwimlaneViewHolder$bind$1 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter f56280g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CartSwimlane f56281h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartListAdapter$CompactSwimlaneViewHolder$bind$1(CartListAdapter cartListAdapter, CartSwimlane cartSwimlane) {
        super(1);
        this.f56280g = cartListAdapter;
        this.f56281h = cartSwimlane;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        this.f56280g.cartFragmentViewModel.trackSwimlaneSwiped(this.f56281h, i11);
    }
}
