package com.talabat.core.tracking.domain.adjust;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/tracking/domain/adjust/AdjustTracker;", "", "trackAdjustEvent", "", "event", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Should be cleaned once migration to Flutter is done")
public interface AdjustTracker {
    void trackAdjustEvent(@NotNull Object obj);
}
