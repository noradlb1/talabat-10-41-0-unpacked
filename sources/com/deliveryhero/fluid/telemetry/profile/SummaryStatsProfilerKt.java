package com.deliveryhero.fluid.telemetry.profile;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¨\u0006\u0005"}, d2 = {"median", "", "", "standardDeviation", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SummaryStatsProfilerKt {
    /* access modifiers changed from: private */
    public static final long median(List<Long> list) {
        List sorted = CollectionsKt___CollectionsKt.sorted(list);
        if (sorted.size() % 2 == 0) {
            return (((Number) sorted.get(sorted.size() / 2)).longValue() + ((Number) sorted.get((sorted.size() - 1) / 2)).longValue()) / ((long) 2);
        }
        return ((Number) sorted.get(sorted.size() / 2)).longValue();
    }

    /* access modifiers changed from: private */
    public static final double standardDeviation(List<Long> list) {
        Iterable<Number> iterable = list;
        double averageOfLong = CollectionsKt___CollectionsKt.averageOfLong(iterable);
        double d11 = 0.0d;
        for (Number longValue : iterable) {
            d11 += Math.pow(((double) longValue.longValue()) - averageOfLong, 2.0d);
        }
        return Math.sqrt(d11 / ((double) list.size()));
    }
}
