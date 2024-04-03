package com.talabat.core.tracking.data.adjust;

import com.adjust.sdk.AdjustEvent;
import com.talabat.core.tracking.domain.adjust.AdjustTracker;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AdjustManager;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/tracking/data/adjust/AdjustTrackerImpl;", "Lcom/talabat/core/tracking/domain/adjust/AdjustTracker;", "()V", "trackAdjustEvent", "", "event", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Should be cleaned once migration to Flutter is done")
public final class AdjustTrackerImpl implements AdjustTracker {
    public void trackAdjustEvent(@NotNull Object obj) {
        AdjustEvent adjustEvent;
        Intrinsics.checkNotNullParameter(obj, "event");
        if (obj instanceof AdjustEvent) {
            adjustEvent = (AdjustEvent) obj;
        } else {
            adjustEvent = null;
        }
        if (adjustEvent != null) {
            AdjustManager.INSTANCE.trackAdjustEvent(adjustEvent);
        }
    }
}
