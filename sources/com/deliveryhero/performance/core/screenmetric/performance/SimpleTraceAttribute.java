package com.deliveryhero.performance.core.screenmetric.performance;

import com.deliveryhero.performance.core.analytics.TraceAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/SimpleTraceAttribute;", "Lcom/deliveryhero/performance/core/analytics/TraceAttribute;", "keyName", "", "(Ljava/lang/String;)V", "getKeyName", "()Ljava/lang/String;", "name", "getName", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SimpleTraceAttribute implements TraceAttribute {
    @NotNull
    private final String keyName;

    public SimpleTraceAttribute(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "keyName");
        this.keyName = str;
    }

    @NotNull
    public final String getKeyName() {
        return this.keyName;
    }

    @NotNull
    public String getName() {
        return this.keyName;
    }
}
