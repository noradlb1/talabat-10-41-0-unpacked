package com.talabat.observabilityNew.tracker;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J.\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/talabat/observabilityNew/tracker/IObservabilityTracker;", "", "trackAttribute", "", "name", "", "value", "trackEvent", "eventType", "eventName", "attributes", "", "trackUserId", "userId", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IObservabilityTracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void trackEvent$default(IObservabilityTracker iObservabilityTracker, String str, String str2, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                iObservabilityTracker.trackEvent(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }
    }

    void trackAttribute(@NotNull String str, @NotNull String str2);

    void trackEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    void trackUserId(@NotNull String str);
}
