package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;", "", "isBasketBasedDeliveryFeeEnabled", "", "isTro", "basketDeliveryFeeTiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryDeliveryFeeTierFeatureFlagUseCase {
    boolean isBasketBasedDeliveryFeeEnabled(boolean z11, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo);
}
