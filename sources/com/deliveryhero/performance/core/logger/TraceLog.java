package com.deliveryhero.performance.core.logger;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/deliveryhero/performance/core/logger/TraceLog;", "", "name", "", "host", "start", "", "stop", "metrics", "", "Lcom/deliveryhero/performance/core/logger/MetricLog;", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/util/List;)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getMetrics", "()Ljava/util/List;", "getName", "getStart", "()J", "getStop", "()Ljava/lang/Long;", "setStop", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/util/List;)Lcom/deliveryhero/performance/core/logger/TraceLog;", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TraceLog {
    @Nullable
    private String host;
    @NotNull
    private final List<MetricLog> metrics;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f30361name;
    private final long start;
    @Nullable
    private Long stop;

    public TraceLog(@NotNull String str, @Nullable String str2, long j11, @Nullable Long l11, @NotNull List<MetricLog> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "metrics");
        this.f30361name = str;
        this.host = str2;
        this.start = j11;
        this.stop = l11;
        this.metrics = list;
    }

    public static /* synthetic */ TraceLog copy$default(TraceLog traceLog, String str, String str2, long j11, Long l11, List<MetricLog> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = traceLog.f30361name;
        }
        if ((i11 & 2) != 0) {
            str2 = traceLog.host;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            j11 = traceLog.start;
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            l11 = traceLog.stop;
        }
        Long l12 = l11;
        if ((i11 & 16) != 0) {
            list = traceLog.metrics;
        }
        return traceLog.copy(str, str3, j12, l12, list);
    }

    @NotNull
    public final String component1() {
        return this.f30361name;
    }

    @Nullable
    public final String component2() {
        return this.host;
    }

    public final long component3() {
        return this.start;
    }

    @Nullable
    public final Long component4() {
        return this.stop;
    }

    @NotNull
    public final List<MetricLog> component5() {
        return this.metrics;
    }

    @NotNull
    public final TraceLog copy(@NotNull String str, @Nullable String str2, long j11, @Nullable Long l11, @NotNull List<MetricLog> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "metrics");
        return new TraceLog(str, str2, j11, l11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TraceLog)) {
            return false;
        }
        TraceLog traceLog = (TraceLog) obj;
        return Intrinsics.areEqual((Object) this.f30361name, (Object) traceLog.f30361name) && Intrinsics.areEqual((Object) this.host, (Object) traceLog.host) && this.start == traceLog.start && Intrinsics.areEqual((Object) this.stop, (Object) traceLog.stop) && Intrinsics.areEqual((Object) this.metrics, (Object) traceLog.metrics);
    }

    @Nullable
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final List<MetricLog> getMetrics() {
        return this.metrics;
    }

    @NotNull
    public final String getName() {
        return this.f30361name;
    }

    public final long getStart() {
        return this.start;
    }

    @Nullable
    public final Long getStop() {
        return this.stop;
    }

    public int hashCode() {
        int hashCode = this.f30361name.hashCode() * 31;
        String str = this.host;
        int i11 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.start)) * 31;
        Long l11 = this.stop;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.metrics.hashCode();
    }

    public final void setHost(@Nullable String str) {
        this.host = str;
    }

    public final void setStop(@Nullable Long l11) {
        this.stop = l11;
    }

    @NotNull
    public String toString() {
        return "TraceLog(name=" + this.f30361name + ", host=" + this.host + ", start=" + this.start + ", stop=" + this.stop + ", metrics=" + this.metrics + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TraceLog(String str, String str2, long j11, Long l11, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, j11, (i11 & 8) != 0 ? null : l11, (i11 & 16) != 0 ? new ArrayList() : list);
    }
}
