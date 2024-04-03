package com.talabat.core.tracking.domain;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH&J.\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0006\u0010\u000f\u001a\u00020\bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/tracking/domain/TestingUtils;", "", "isAutomationProcess", "", "()Z", "isLiveAutomation", "isLoggingEnabled", "loggingKey", "", "setLogEventForAutomation", "", "eventName", "attributes", "", "updateEventsTracker", "eventLog", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TestingUtils {
    boolean isAutomationProcess();

    boolean isLiveAutomation();

    boolean isLoggingEnabled();

    @NotNull
    String loggingKey();

    void setLogEventForAutomation(@NotNull String str, @NotNull Map<String, ? extends Object> map);

    void updateEventsTracker(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull String str2);
}
