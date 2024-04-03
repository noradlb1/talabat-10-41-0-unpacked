package com.talabat.splash.presentation.ui;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/splash/presentation/ui/BackendExperimentsHelper;", "", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "fetchBackendExperimentsIfApplicable", "", "fetchExperiments", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackendExperimentsHelper {
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public BackendExperimentsHelper(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatExperiment = iTalabatExperiment;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public final void fetchExperiments() {
        for (TalabatExperimentConstants talabatExperimentConstants : CollectionsKt__CollectionsKt.listOf(TalabatExperimentConstants.BE_TEST_1, TalabatExperimentConstants.BE_TEST_2, TalabatExperimentConstants.BE_TEST_3, TalabatExperimentConstants.VIP_QUEUE)) {
            this.talabatExperiment.getStringVariant((FWFKey) talabatExperimentConstants, "control", false, TalabatExperimentDataSourceStrategy.FWF, (Function1<? super String, Unit>) new BackendExperimentsHelper$fetchExperiments$1$1(talabatExperimentConstants));
        }
    }

    public final void fetchBackendExperimentsIfApplicable() {
        this.talabatFeatureFlag.getFeatureFlag((FWFKey) TalabatFeatureFlagConstants.ENABLE_FWF_TRACKING_ON_APP, false, false, (Function1<? super Boolean, Unit>) new BackendExperimentsHelper$fetchBackendExperimentsIfApplicable$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackendExperimentsHelper(ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TalabatExperiment.INSTANCE : iTalabatExperiment, iTalabatFeatureFlag);
    }
}
