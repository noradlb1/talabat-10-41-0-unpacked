package com.deliveryhero.performance.core.screentracker;

import com.deliveryhero.performance.core.analytics.TraceAttribute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/deliveryhero/performance/core/screentracker/ScreenTraceAttribute;", "Lcom/deliveryhero/performance/core/analytics/TraceAttribute;", "()V", "attValue", "", "name", "getName", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenTraceAttribute implements TraceAttribute {
    @NotNull
    public static final ScreenTraceAttribute INSTANCE = new ScreenTraceAttribute();
    @NotNull
    public static final String attValue = "0:%s;1:%s";

    private ScreenTraceAttribute() {
    }

    @NotNull
    public String getName() {
        return "screen";
    }
}
