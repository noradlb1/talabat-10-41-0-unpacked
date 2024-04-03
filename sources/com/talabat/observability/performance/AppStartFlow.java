package com.talabat.observability.performance;

import com.deliveryhero.performance.core.analytics.TraceAttribute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/observability/performance/AppStartFlow;", "Lcom/deliveryhero/performance/core/analytics/TraceAttribute;", "()V", "name", "", "getName", "()Ljava/lang/String;", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppStartFlow implements TraceAttribute {
    @NotNull
    public static final AppStartFlow INSTANCE = new AppStartFlow();
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private static final String f61095name = "Flow";

    private AppStartFlow() {
    }

    @NotNull
    public String getName() {
        return f61095name;
    }
}
