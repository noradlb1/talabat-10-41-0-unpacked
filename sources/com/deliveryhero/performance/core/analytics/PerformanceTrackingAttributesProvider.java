package com.deliveryhero.performance.core.analytics;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "", "getAttributes", "", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PerformanceTrackingAttributesProvider {
    @NotNull
    Map<String, String> getAttributes();
}
