package com.talabat.darkstores.helper;

import com.talabat.core.navigation.domain.screen.checkout.ExitPointProduct;
import datamodels.darkstores.DarkstoresExitPointProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/darkstores/helper/DarkstoreCartItemMapper;", "", "()V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoreCartItemMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/helper/DarkstoreCartItemMapper$Companion;", "", "()V", "map", "Ldatamodels/darkstores/DarkstoresExitPointProduct;", "darkstoreProduct", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointProduct;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DarkstoresExitPointProduct map(@NotNull ExitPointProduct exitPointProduct) {
            Intrinsics.checkNotNullParameter(exitPointProduct, "darkstoreProduct");
            return new DarkstoresExitPointProduct(exitPointProduct.getId(), exitPointProduct.getName(), exitPointProduct.getProductDescription(), exitPointProduct.getThumbnail(), exitPointProduct.getQuantity(), exitPointProduct.getPrice(), Float.valueOf(exitPointProduct.getOriginalPrice()), exitPointProduct.getAbsoluteDiscount(), exitPointProduct.getSku(), exitPointProduct.getCategoryIds());
        }
    }
}
