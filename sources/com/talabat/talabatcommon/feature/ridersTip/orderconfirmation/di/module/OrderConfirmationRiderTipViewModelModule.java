package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.module;

import android.content.Context;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.data.impl.TipRiderStateRepositoryImpl;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipABTestVariant;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipFeatureUseCase;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetTipRiderStateUseCase;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.SetTipRiderStatusUseCase;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/di/module/OrderConfirmationRiderTipViewModelModule;", "", "()V", "provideGetOrderConfirmationRiderTipABTestVariant", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipABTestVariant;", "provideGetOrderConfirmationRiderTipEnabledUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/business/usecase/GetOrderConfirmationRiderTipEnabledUseCase;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "provideGetOrderConfirmationRiderTipFeatureUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipFeatureUseCase;", "provideGetTipRiderStateUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetTipRiderStateUseCase;", "provideSetTipRiderStateUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderConfirmationRiderTipViewModelModule {
    @NotNull
    public static final OrderConfirmationRiderTipViewModelModule INSTANCE = new OrderConfirmationRiderTipViewModelModule();

    private OrderConfirmationRiderTipViewModelModule() {
    }

    private final GetOrderConfirmationRiderTipABTestVariant provideGetOrderConfirmationRiderTipABTestVariant() {
        return new GetOrderConfirmationRiderTipABTestVariant((ITalabatExperiment) null, 1, (DefaultConstructorMarker) null);
    }

    private final GetOrderConfirmationRiderTipFeatureUseCase provideGetOrderConfirmationRiderTipFeatureUseCase(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetOrderConfirmationRiderTipFeatureUseCase(iTalabatFeatureFlag, (Function0) null, 2, (DefaultConstructorMarker) null);
    }

    private final GetTipRiderStateUseCase provideGetTipRiderStateUseCase() {
        return new GetTipRiderStateUseCase(new TipRiderStateRepositoryImpl((Context) null, 1, (DefaultConstructorMarker) null));
    }

    @NotNull
    public final GetOrderConfirmationRiderTipEnabledUseCase provideGetOrderConfirmationRiderTipEnabledUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new GetOrderConfirmationRiderTipEnabledUseCase(provideGetOrderConfirmationRiderTipFeatureUseCase(iTalabatFeatureFlag), provideGetOrderConfirmationRiderTipABTestVariant(), provideGetTipRiderStateUseCase());
    }

    @NotNull
    public final SetTipRiderStatusUseCase provideSetTipRiderStateUseCase() {
        return new SetTipRiderStatusUseCase(new TipRiderStateRepositoryImpl((Context) null, 1, (DefaultConstructorMarker) null));
    }
}
