package com.talabat.core.fwf.domain.events;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/fwf/domain/events/BackendExperimentObservabilityEvent;", "", "experimentKey", "", "experimentVariation", "(Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_fwf_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BackendExperimentObservabilityEvent {
    @NotNull
    private final String experimentKey;
    @NotNull
    private final String experimentVariation;

    public BackendExperimentObservabilityEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "experimentKey");
        Intrinsics.checkNotNullParameter(str2, "experimentVariation");
        this.experimentKey = str;
        this.experimentVariation = str2;
    }

    private final String component1() {
        return this.experimentKey;
    }

    private final String component2() {
        return this.experimentVariation;
    }

    public static /* synthetic */ BackendExperimentObservabilityEvent copy$default(BackendExperimentObservabilityEvent backendExperimentObservabilityEvent, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = backendExperimentObservabilityEvent.experimentKey;
        }
        if ((i11 & 2) != 0) {
            str2 = backendExperimentObservabilityEvent.experimentVariation;
        }
        return backendExperimentObservabilityEvent.copy(str, str2);
    }

    @NotNull
    public final Map<String, String> attributes() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("flagName", this.experimentKey), TuplesKt.to("eventName", "ab_test_participated"), TuplesKt.to("eventVariation", this.experimentVariation), TuplesKt.to("module", "FunWithFlags"), TuplesKt.to("reason", "ExpTracking"));
    }

    @NotNull
    public final BackendExperimentObservabilityEvent copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "experimentKey");
        Intrinsics.checkNotNullParameter(str2, "experimentVariation");
        return new BackendExperimentObservabilityEvent(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackendExperimentObservabilityEvent)) {
            return false;
        }
        BackendExperimentObservabilityEvent backendExperimentObservabilityEvent = (BackendExperimentObservabilityEvent) obj;
        return Intrinsics.areEqual((Object) this.experimentKey, (Object) backendExperimentObservabilityEvent.experimentKey) && Intrinsics.areEqual((Object) this.experimentVariation, (Object) backendExperimentObservabilityEvent.experimentVariation);
    }

    public int hashCode() {
        return (this.experimentKey.hashCode() * 31) + this.experimentVariation.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.experimentKey;
        String str2 = this.experimentVariation;
        return "BackendExperimentObservabilityEvent(experimentKey=" + str + ", experimentVariation=" + str2 + ")";
    }
}
