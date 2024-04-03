package com.talabat.flutter.utils;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.menu.MenuExperimentsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/flutter/utils/FlutterMenuBasketSavingFeatureGate;", "", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "canShowBasketSavingInMenu", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterMenuBasketSavingFeatureGate {
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    public FlutterMenuBasketSavingFeatureGate(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.talabatExperiment = iTalabatExperiment;
    }

    public final boolean canShowBasketSavingInMenu() {
        return !Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(MenuExperimentsKeys.IS_COMMUNICATE_SAVINGS_ON_MENU_ENABLED, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control");
    }

    @NotNull
    public final ITalabatExperiment getTalabatExperiment() {
        return this.talabatExperiment;
    }
}
