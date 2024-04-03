package com.talabat.core.fwf.domain.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/fwf/domain/events/BackendExperimentEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "experimentKey", "", "experimentVariation", "(Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_core_fwf_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackendExperimentEvent extends TalabatEvent {
    @NotNull
    private final String experimentKey;
    @NotNull
    private final String experimentVariation;

    public BackendExperimentEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "experimentKey");
        Intrinsics.checkNotNullParameter(str2, "experimentVariation");
        this.experimentKey = str;
        this.experimentVariation = str2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("experiment_name", this.experimentKey), TuplesKt.to("experimentVariation", this.experimentVariation), TuplesKt.to("platform", "Android"));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EventConstantsKt.BACKEND_EXPERIMENT_FEATURE_NAME;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "ab_test_participated";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
