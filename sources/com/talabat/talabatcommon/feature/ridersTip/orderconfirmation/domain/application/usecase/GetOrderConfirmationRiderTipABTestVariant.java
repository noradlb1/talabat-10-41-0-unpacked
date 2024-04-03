package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipABTestVariant;", "", "isOrderConfirmationRiderTipExperimentRepo", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "invoke", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOrderConfirmationRiderTipABTestVariant {
    @NotNull
    private final ITalabatExperiment isOrderConfirmationRiderTipExperimentRepo;

    public GetOrderConfirmationRiderTipABTestVariant() {
        this((ITalabatExperiment) null, 1, (DefaultConstructorMarker) null);
    }

    public GetOrderConfirmationRiderTipABTestVariant(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "isOrderConfirmationRiderTipExperimentRepo");
        this.isOrderConfirmationRiderTipExperimentRepo = iTalabatExperiment;
    }

    public final boolean invoke() {
        return ITalabatExperiment.DefaultImpls.getBooleanVariant$default(this.isOrderConfirmationRiderTipExperimentRepo, TalabatExperimentConstants.ENABLE_TIP_RIDER_ON_THANK_YOU_EXPERIMENT, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetOrderConfirmationRiderTipABTestVariant(ITalabatExperiment iTalabatExperiment, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TalabatExperiment.INSTANCE : iTalabatExperiment);
    }
}
