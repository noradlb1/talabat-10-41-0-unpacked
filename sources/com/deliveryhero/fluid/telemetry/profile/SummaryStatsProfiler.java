package com.deliveryhero.fluid.telemetry.profile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tJ)\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/SummaryStatsProfiler;", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "()V", "tracesByTag", "", "", "", "", "getStats", "", "Lcom/deliveryhero/fluid/telemetry/profile/SummaryStatsProfiler$Stats;", "trace", "ResultT", "tag", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Stats", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SummaryStatsProfiler implements Profiler {
    @NotNull
    private final Map<String, List<Long>> tracesByTag = new LinkedHashMap();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/SummaryStatsProfiler$Stats;", "", "minimum", "", "median", "standardDeviation", "", "maximum", "(JJDJ)V", "getMaximum", "()J", "getMedian", "getMinimum", "getStandardDeviation", "()D", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Stats {
        private final long maximum;
        private final long median;
        private final long minimum;
        private final double standardDeviation;

        public Stats(long j11, long j12, double d11, long j13) {
            this.minimum = j11;
            this.median = j12;
            this.standardDeviation = d11;
            this.maximum = j13;
        }

        public static /* synthetic */ Stats copy$default(Stats stats, long j11, long j12, double d11, long j13, int i11, Object obj) {
            Stats stats2 = stats;
            return stats.copy((i11 & 1) != 0 ? stats2.minimum : j11, (i11 & 2) != 0 ? stats2.median : j12, (i11 & 4) != 0 ? stats2.standardDeviation : d11, (i11 & 8) != 0 ? stats2.maximum : j13);
        }

        public final long component1() {
            return this.minimum;
        }

        public final long component2() {
            return this.median;
        }

        public final double component3() {
            return this.standardDeviation;
        }

        public final long component4() {
            return this.maximum;
        }

        @NotNull
        public final Stats copy(long j11, long j12, double d11, long j13) {
            return new Stats(j11, j12, d11, j13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Stats)) {
                return false;
            }
            Stats stats = (Stats) obj;
            return this.minimum == stats.minimum && this.median == stats.median && Intrinsics.areEqual((Object) Double.valueOf(this.standardDeviation), (Object) Double.valueOf(stats.standardDeviation)) && this.maximum == stats.maximum;
        }

        public final long getMaximum() {
            return this.maximum;
        }

        public final long getMedian() {
            return this.median;
        }

        public final long getMinimum() {
            return this.minimum;
        }

        public final double getStandardDeviation() {
            return this.standardDeviation;
        }

        public int hashCode() {
            return (((((a.a(this.minimum) * 31) + a.a(this.median)) * 31) + Double.doubleToLongBits(this.standardDeviation)) * 31) + a.a(this.maximum);
        }

        @NotNull
        public String toString() {
            return "Stats(minimum=" + this.minimum + ", median=" + this.median + ", standardDeviation=" + this.standardDeviation + ", maximum=" + this.maximum + ')';
        }
    }

    @NotNull
    public final Map<String, Stats> getStats() {
        long j11;
        long j12;
        Map<String, List<Long>> map = this.tracesByTag;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            Iterable iterable = list;
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                while (true) {
                    j11 = longValue;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        longValue = ((Number) it.next()).longValue();
                        if (j11 > longValue) {
                        }
                    }
                }
                long access$median = SummaryStatsProfilerKt.median(list);
                double access$standardDeviation = SummaryStatsProfilerKt.standardDeviation(list);
                Iterator it2 = iterable.iterator();
                if (it2.hasNext()) {
                    long longValue2 = ((Number) it2.next()).longValue();
                    while (true) {
                        j12 = longValue2;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            longValue2 = ((Number) it2.next()).longValue();
                            if (j12 < longValue2) {
                            }
                        }
                    }
                    linkedHashMap.put(key, new Stats(j11, access$median, access$standardDeviation, j12));
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        return linkedHashMap;
    }

    public <ResultT> ResultT trace(@NotNull String str, @NotNull Function0<? extends ResultT> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "block");
        Clock clock = Clock.INSTANCE;
        long uptimeMillis = clock.uptimeMillis();
        ResultT invoke = function0.invoke();
        long uptimeMillis2 = clock.uptimeMillis() - uptimeMillis;
        Map<String, List<Long>> map = this.tracesByTag;
        List<Long> list = map.get(str);
        if (list == null) {
            list = new ArrayList<>();
            map.put(str, list);
        }
        list.add(Long.valueOf(uptimeMillis2));
        return invoke;
    }
}
