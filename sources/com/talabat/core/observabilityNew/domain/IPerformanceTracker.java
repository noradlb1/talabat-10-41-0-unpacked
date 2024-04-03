package com.talabat.core.observabilityNew.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J!\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f\"\u00020\u0005H&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;", "", "addAppFlowTraceAttribute", "", "traceName", "", "attrValue", "addTraceCounter", "traceCounterName", "initialize", "listenToAppStartUp", "traces", "", "([Ljava/lang/String;)V", "startTrace", "stopTrace", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPerformanceTracker {
    void addAppFlowTraceAttribute(@NotNull String str, @NotNull String str2);

    void addTraceCounter(@NotNull String str, @NotNull String str2);

    void initialize();

    void listenToAppStartUp(@NotNull String... strArr);

    void startTrace(@NotNull String str);

    void stopTrace(@NotNull String str);
}
