package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$CartListContent;", "currentItems", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$initViewModel$4$1 extends Lambda implements Function1<CartFragmentViewModel.CartListContent, CartFragmentViewModel.CartListContent> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartSwimlane f56268g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$initViewModel$4$1(CartSwimlane cartSwimlane) {
        super(1);
        this.f56268g = cartSwimlane;
    }

    @NotNull
    public final CartFragmentViewModel.CartListContent invoke(@NotNull CartFragmentViewModel.CartListContent cartListContent) {
        Intrinsics.checkNotNullParameter(cartListContent, "currentItems");
        return CartFragmentViewModel.CartListContent.copy$default(cartListContent, (List) null, (List) null, (List) null, CollectionsKt__CollectionsJVMKt.listOf(this.f56268g), (List) null, 23, (Object) null);
    }
}
