package com.talabat.observabilityNew.tracker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/observabilityNew/tracker/TimeTrackingData;", "", "startTimestamp", "", "endTimestamp", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getEndTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartTimestamp", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/talabat/observabilityNew/tracker/TimeTrackingData;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimeTrackingData {
    @Nullable
    private final Long endTimestamp;
    @Nullable
    private final Long startTimestamp;

    public TimeTrackingData() {
        this((Long) null, (Long) null, 3, (DefaultConstructorMarker) null);
    }

    public TimeTrackingData(@Nullable Long l11, @Nullable Long l12) {
        this.startTimestamp = l11;
        this.endTimestamp = l12;
    }

    public static /* synthetic */ TimeTrackingData copy$default(TimeTrackingData timeTrackingData, Long l11, Long l12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = timeTrackingData.startTimestamp;
        }
        if ((i11 & 2) != 0) {
            l12 = timeTrackingData.endTimestamp;
        }
        return timeTrackingData.copy(l11, l12);
    }

    @Nullable
    public final Long component1() {
        return this.startTimestamp;
    }

    @Nullable
    public final Long component2() {
        return this.endTimestamp;
    }

    @NotNull
    public final TimeTrackingData copy(@Nullable Long l11, @Nullable Long l12) {
        return new TimeTrackingData(l11, l12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeTrackingData)) {
            return false;
        }
        TimeTrackingData timeTrackingData = (TimeTrackingData) obj;
        return Intrinsics.areEqual((Object) this.startTimestamp, (Object) timeTrackingData.startTimestamp) && Intrinsics.areEqual((Object) this.endTimestamp, (Object) timeTrackingData.endTimestamp);
    }

    @Nullable
    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Nullable
    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public int hashCode() {
        Long l11 = this.startTimestamp;
        int i11 = 0;
        int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        Long l12 = this.endTimestamp;
        if (l12 != null) {
            i11 = l12.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Long l11 = this.startTimestamp;
        Long l12 = this.endTimestamp;
        return "TimeTrackingData(startTimestamp=" + l11 + ", endTimestamp=" + l12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeTrackingData(Long l11, Long l12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : l11, (i11 & 2) != 0 ? null : l12);
    }
}
