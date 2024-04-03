package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.feature.cart.model.CartProductViewType;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/cart/CartListAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragment$adapter$2 extends Lambda implements Function0<CartListAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragment f56249g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragment$adapter$2(CartFragment cartFragment) {
        super(0);
        this.f56249g = cartFragment;
    }

    @NotNull
    public final CartListAdapter invoke() {
        CartFragmentViewModel cartFragmentViewModel = this.f56249g.getCartFragmentViewModel();
        AnonymousClass1 r32 = new Function1<Product, Unit>(this.f56249g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Product) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Product product) {
                Intrinsics.checkNotNullParameter(product, "p0");
                ((CartFragment) this.receiver).onProductClicked(product);
            }
        };
        AnonymousClass2 r42 = new Function1<String, Unit>(this.f56249g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "p0");
                ((CartFragment) this.receiver).onSpecialRequestChanged(str);
            }
        };
        AnonymousClass3 r52 = new Function0<Unit>(this.f56249g) {
            public final void invoke() {
                ((CartFragment) this.receiver).onPartialFulfillmentClicked();
            }
        };
        CartProductViewType cartProductViewType = this.f56249g.getCartFragmentViewModel().getCartProductViewType();
        final CartFragment cartFragment = this.f56249g;
        return new CartListAdapter(cartFragmentViewModel, r32, r42, r52, new Function0<Unit>() {
            public final void invoke() {
                cartFragment.getCartFragmentViewModel().trackCheckoutAlertVisibility(cartFragment.getScreenName(), cartFragment.getEventOriginType().getTrackingName());
            }
        }, cartProductViewType);
    }
}
