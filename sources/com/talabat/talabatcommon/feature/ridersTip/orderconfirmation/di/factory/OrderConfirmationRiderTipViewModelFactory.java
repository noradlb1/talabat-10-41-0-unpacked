package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.factory;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.module.OrderConfirmationRiderTipViewModelModule;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/di/factory/OrderConfirmationRiderTipViewModelFactory;", "", "()V", "getOrderConfirmationRiderTipViewModel", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/presentation/viewmodel/OrderConfirmationRiderTipViewModel;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderConfirmationRiderTipViewModelFactory {
    @NotNull
    public static final OrderConfirmationRiderTipViewModelFactory INSTANCE = new OrderConfirmationRiderTipViewModelFactory();

    private OrderConfirmationRiderTipViewModelFactory() {
    }

    @NotNull
    public final OrderConfirmationRiderTipViewModel getOrderConfirmationRiderTipViewModel(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        OrderConfirmationRiderTipViewModelModule orderConfirmationRiderTipViewModelModule = OrderConfirmationRiderTipViewModelModule.INSTANCE;
        return new OrderConfirmationRiderTipViewModel(orderConfirmationRiderTipViewModelModule.provideGetOrderConfirmationRiderTipEnabledUseCase(iTalabatFeatureFlag), orderConfirmationRiderTipViewModelModule.provideSetTipRiderStateUseCase());
    }
}
