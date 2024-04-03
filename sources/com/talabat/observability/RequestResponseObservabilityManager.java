package com.talabat.observability;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.observabilityNew.domain.RequestResponseObservability;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/observability/RequestResponseObservabilityManager;", "Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;", "()V", "track", "", "eventType", "", "eventName", "attributes", "", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestResponseObservabilityManager implements RequestResponseObservability {
    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.trackEvent(str2, str, map);
    }
}
