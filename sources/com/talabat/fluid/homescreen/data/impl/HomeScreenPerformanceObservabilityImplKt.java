package com.talabat.fluid.homescreen.data.impl;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"EVENT_TYPE", "", "retrieveInstance", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$Companion;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getPerseusClientId", "Lkotlin/Function0;", "getPerseusSessionId", "timestampProvider", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenPerformanceObservabilityImplKt {
    @NotNull
    private static final String EVENT_TYPE = "HomeScreenPerformanceObservability";

    @NotNull
    public static final HomeScreenPerformanceObservability retrieveInstance(@NotNull HomeScreenPerformanceObservability.Companion companion, @NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function0<String> function0, @NotNull Function0<String> function02, @NotNull Function0<String> function03) throws HomeScreenPerformanceObservability.HomeScreenPerformanceObservabilityAccessException {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function0, "getPerseusClientId");
        Intrinsics.checkNotNullParameter(function02, "getPerseusSessionId");
        Intrinsics.checkNotNullParameter(function03, "timestampProvider");
        if (companion.getInstance$com_talabat_NewArchi_Homescreen_Homescreen() == null) {
            companion.setInstance$com_talabat_NewArchi_Homescreen_Homescreen(new HomeScreenPerformanceObservabilityImpl(iObservabilityManager, iTalabatFeatureFlag, function0, function02, function03));
        }
        HomeScreenPerformanceObservability instance$com_talabat_NewArchi_Homescreen_Homescreen = companion.getInstance$com_talabat_NewArchi_Homescreen_Homescreen();
        if (instance$com_talabat_NewArchi_Homescreen_Homescreen != null) {
            return instance$com_talabat_NewArchi_Homescreen_Homescreen;
        }
        throw new HomeScreenPerformanceObservability.HomeScreenPerformanceObservabilityAccessException("HomeScreenPerformanceObservability.instance was null!");
    }
}
