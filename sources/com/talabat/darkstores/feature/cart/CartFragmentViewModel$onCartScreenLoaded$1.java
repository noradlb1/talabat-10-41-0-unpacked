package com.talabat.darkstores.feature.cart;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cartSwimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$onCartScreenLoaded$1 extends Lambda implements Function1<CartSwimlane, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56270g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$onCartScreenLoaded$1(CartFragmentViewModel cartFragmentViewModel) {
        super(1);
        this.f56270g = cartFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CartSwimlane) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CartSwimlane cartSwimlane) {
        Intrinsics.checkNotNullParameter(cartSwimlane, "cartSwimlane");
        this.f56270g.getCartSwimlaneSubject$com_talabat_NewArchi_darkstores_darkstores().onNext(cartSwimlane);
    }
}
