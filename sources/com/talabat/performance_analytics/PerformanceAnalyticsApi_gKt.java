package com.talabat.performance_analytics;

import android.util.Log;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, d2 = {"wrapError", "", "", "exception", "", "wrapResult", "result", "performance_analytics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsApi_gKt {
    /* access modifiers changed from: private */
    public static final List<Object> wrapError(Throwable th2) {
        if (th2 instanceof FlutterError) {
            return CollectionsKt__CollectionsKt.listOf(((FlutterError) th2).getCode(), th2.getMessage(), ((FlutterError) th2).getDetails());
        }
        return CollectionsKt__CollectionsKt.listOf(th2.getClass().getSimpleName(), th2.toString(), "Cause: " + th2.getCause() + ", Stacktrace: " + Log.getStackTraceString(th2));
    }

    private static final List<Object> wrapResult(Object obj) {
        return CollectionsKt__CollectionsJVMKt.listOf(obj);
    }
}
