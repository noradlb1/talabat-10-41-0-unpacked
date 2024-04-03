package com.deliveryhero.performance.core.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJD\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/deliveryhero/performance/core/logger/MetricLog;", "", "name", "", "value", "", "type", "start", "stop", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getName", "()Ljava/lang/String;", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStop", "getType", "getValue", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/deliveryhero/performance/core/logger/MetricLog;", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetricLog {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30360name;
    @Nullable
    private final Long start;
    @Nullable
    private final Long stop;
    @NotNull
    private final String type;
    private final long value;

    public MetricLog(@NotNull String str, long j11, @NotNull String str2, @Nullable Long l11, @Nullable Long l12) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.f30360name = str;
        this.value = j11;
        this.type = str2;
        this.start = l11;
        this.stop = l12;
    }

    public static /* synthetic */ MetricLog copy$default(MetricLog metricLog, String str, long j11, String str2, Long l11, Long l12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = metricLog.f30360name;
        }
        if ((i11 & 2) != 0) {
            j11 = metricLog.value;
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            str2 = metricLog.type;
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            l11 = metricLog.start;
        }
        Long l13 = l11;
        if ((i11 & 16) != 0) {
            l12 = metricLog.stop;
        }
        return metricLog.copy(str, j12, str3, l13, l12);
    }

    @NotNull
    public final String component1() {
        return this.f30360name;
    }

    public final long component2() {
        return this.value;
    }

    @NotNull
    public final String component3() {
        return this.type;
    }

    @Nullable
    public final Long component4() {
        return this.start;
    }

    @Nullable
    public final Long component5() {
        return this.stop;
    }

    @NotNull
    public final MetricLog copy(@NotNull String str, long j11, @NotNull String str2, @Nullable Long l11, @Nullable Long l12) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new MetricLog(str, j11, str2, l11, l12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetricLog)) {
            return false;
        }
        MetricLog metricLog = (MetricLog) obj;
        return Intrinsics.areEqual((Object) this.f30360name, (Object) metricLog.f30360name) && this.value == metricLog.value && Intrinsics.areEqual((Object) this.type, (Object) metricLog.type) && Intrinsics.areEqual((Object) this.start, (Object) metricLog.start) && Intrinsics.areEqual((Object) this.stop, (Object) metricLog.stop);
    }

    @NotNull
    public final String getName() {
        return this.f30360name;
    }

    @Nullable
    public final Long getStart() {
        return this.start;
    }

    @Nullable
    public final Long getStop() {
        return this.stop;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((((this.f30360name.hashCode() * 31) + a.a(this.value)) * 31) + this.type.hashCode()) * 31;
        Long l11 = this.start;
        int i11 = 0;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.stop;
        if (l12 != null) {
            i11 = l12.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        return "MetricLog(name=" + this.f30360name + ", value=" + this.value + ", type=" + this.type + ", start=" + this.start + ", stop=" + this.stop + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MetricLog(String str, long j11, String str2, Long l11, Long l12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, (i11 & 4) != 0 ? "Default" : str2, (i11 & 8) != 0 ? null : l11, (i11 & 16) != 0 ? null : l12);
    }
}
