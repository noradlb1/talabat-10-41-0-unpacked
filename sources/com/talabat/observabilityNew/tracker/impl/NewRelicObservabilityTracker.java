package com.talabat.observabilityNew.tracker.impl;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.newrelic.NewRelic;
import com.talabat.observabilityNew.tracker.IObservabilityTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/observabilityNew/tracker/impl/NewRelicObservabilityTracker;", "Lcom/talabat/observabilityNew/tracker/IObservabilityTracker;", "()V", "trackAttribute", "", "name", "", "value", "trackEvent", "eventType", "eventName", "attributes", "", "trackUserId", "userId", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRelicObservabilityTracker implements IObservabilityTracker {
    public void trackAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        NewRelic.INSTANCE.setAttribute(str, str2);
    }

    public void trackEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Timber.i("eventType: " + str + " eventName: " + str2 + " attributes: " + map, new Object[0]);
        NewRelic.INSTANCE.recordCustomEvent(str, str2, map);
    }

    public void trackUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        NewRelic.INSTANCE.setUserId(str);
    }
}
