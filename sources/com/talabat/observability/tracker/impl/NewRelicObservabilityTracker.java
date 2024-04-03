package com.talabat.observability.tracker.impl;

import android.util.Log;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.newrelic.NewRelic;
import com.talabat.observability.tracker.ObservabilityTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J,\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/observability/tracker/impl/NewRelicObservabilityTracker;", "Lcom/talabat/observability/tracker/ObservabilityTracker;", "()V", "tag", "", "kotlin.jvm.PlatformType", "trackAttribute", "", "name", "value", "trackEvent", "eventType", "eventName", "attributes", "", "trackUserId", "userId", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRelicObservabilityTracker implements ObservabilityTracker {
    private final String tag = NewRelicObservabilityTracker.class.getSimpleName();

    public void trackAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        NewRelic.INSTANCE.setAttribute(str, str2);
    }

    public void trackEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        String str3 = this.tag;
        Log.i(str3, "eventType: " + str + " eventName: " + str2 + " attributes: " + map);
        NewRelic.INSTANCE.recordCustomEvent(str, str2, map);
    }

    public void trackUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        NewRelic.INSTANCE.setUserId(str);
    }
}
