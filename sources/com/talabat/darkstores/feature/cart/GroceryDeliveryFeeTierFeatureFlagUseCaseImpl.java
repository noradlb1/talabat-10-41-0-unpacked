package com.talabat.darkstores.feature.cart;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCaseImpl;", "Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "isBasketBasedDeliveryFeeEnabled", "", "isTro", "basketDeliveryFeeTiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDeliveryFeeTierFeatureFlagUseCaseImpl implements GroceryDeliveryFeeTierFeatureFlagUseCase {
    @NotNull
    private final ITalabatFeatureFlag featureFlag;

    @Inject
    public GroceryDeliveryFeeTierFeatureFlagUseCaseImpl(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.featureFlag = iTalabatFeatureFlag;
    }

    public boolean isBasketBasedDeliveryFeeEnabled(boolean z11, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo) {
        return !z11 && basketDeliveryFeeTiersInfo != null && this.featureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.BASKET_BASED_DELIVERY_FEE, false);
    }
}
