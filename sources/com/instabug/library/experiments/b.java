package com.instabug.library.experiments;

import java.util.List;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f34358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f34359c;

    public b(e eVar, List list) {
        this.f34359c = eVar;
        this.f34358b = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            java.lang.Object r0 = com.instabug.library.experiments.e.f34363a
            monitor-enter(r0)
            com.instabug.library.experiments.e r1 = r6.f34359c     // Catch:{ all -> 0x0045 }
            int r1 = r1.c()     // Catch:{ all -> 0x0045 }
            com.instabug.library.experiments.e r2 = r6.f34359c     // Catch:{ all -> 0x0045 }
            java.util.List r3 = r6.f34358b     // Catch:{ all -> 0x0045 }
            java.util.List r2 = r2.c(r3)     // Catch:{ all -> 0x0045 }
            com.instabug.library.experiments.e r3 = r6.f34359c     // Catch:{ all -> 0x0045 }
            java.util.List r2 = r3.d(r2)     // Catch:{ all -> 0x0045 }
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0021
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0021:
            com.instabug.library.experiments.cache.a r3 = com.instabug.library.experiments.di.a.b()     // Catch:{ all -> 0x0045 }
            r3.a((java.util.List) r2)     // Catch:{ all -> 0x0045 }
            int r2 = r3.trimToLimit(r1)     // Catch:{ all -> 0x0045 }
            if (r2 <= 0) goto L_0x0043
            java.lang.String r2 = "Instabug"
            java.lang.String r3 = "Some old experiments were removed. Max allowed experiments reached. Please note that you can add up to %s experiments."
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0045 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0045 }
            r5 = 0
            r4[r5] = r1     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0045 }
            com.instabug.library.util.InstabugSDKLogger.w(r2, r1)     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.experiments.b.run():void");
    }
}
