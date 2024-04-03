package com.talabat.core.flutter.channels.domain.observability;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J,\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J$\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/observability/ObservabilityChannelCallback;", "", "endTracing", "", "traceId", "", "screenName", "screenType", "observe", "eventName", "featureName", "attributes", "", "startTracing", "trackUnexpectedScenario", "explanation", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ObservabilityChannelCallback {
    void endTracing(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void observe(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    void startTracing(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void trackUnexpectedScenario(@NotNull Map<String, String> map, @NotNull String str);
}
