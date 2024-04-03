package com.deliveryhero.performance.core.logger;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"getMetricType", "", "json", "Lcom/deliveryhero/performance/core/logger/TraceLog;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LoggerTrackerKt {
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        return "duration";
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getMetricType(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2051433076: goto L_0x0023;
                case -1035111496: goto L_0x001a;
                case -1005262529: goto L_0x0011;
                case -863634500: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x002f
        L_0x0008:
            java.lang.String r0 = "tti_ms"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002c
            goto L_0x002f
        L_0x0011:
            java.lang.String r0 = "ttfl_ms"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002c
            goto L_0x002f
        L_0x001a:
            java.lang.String r0 = "nts_ms"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002c
            goto L_0x002f
        L_0x0023:
            java.lang.String r0 = "sntr_ms"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            java.lang.String r1 = "duration"
            goto L_0x0031
        L_0x002f:
            java.lang.String r1 = "default"
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.performance.core.logger.LoggerTrackerKt.getMetricType(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static final String json(TraceLog traceLog) {
        PerformanceJsonSerializer serializer = JsonSerializerProvider.INSTANCE.getSerializer();
        if (serializer != null) {
            return serializer.serialize(traceLog);
        }
        throw new IllegalStateException("Json serializer must be added for Performance SDK".toString());
    }
}
