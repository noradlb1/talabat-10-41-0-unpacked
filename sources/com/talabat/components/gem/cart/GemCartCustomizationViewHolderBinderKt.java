package com.talabat.components.gem.cart;

import buisnessmodels.Cart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¨\u0006\u0007"}, d2 = {"updateWithDiscount", "", "Lbuisnessmodels/Cart;", "newGemOfferAmount", "", "onDiscountUpdated", "Lkotlin/Function0;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemCartCustomizationViewHolderBinderKt {
    public static final void updateWithDiscount(@Nullable Cart cart, float f11, @NotNull Function0<Unit> function0) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "onDiscountUpdated");
        if (cart != null) {
            if (f11 == cart.getGemOfferAmount()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                cart.setGemOfferAmount(f11);
                cart.recalcualteTotal();
                function0.invoke();
            }
        }
    }
}
