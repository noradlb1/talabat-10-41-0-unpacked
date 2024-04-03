package com.instabug.apm.cache.handler.networklog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.apm.configuration.c;
import com.instabug.apm.logger.internal.a;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.library.model.common.Session;
import java.util.List;

public class f implements e {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final c f45142a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f45143b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final c f45144c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final com.instabug.apm.cache.handler.session.f f45145d;

    /* renamed from: e  reason: collision with root package name */
    private a f45146e = com.instabug.apm.di.a.f();

    public f(@NonNull c cVar, @NonNull a aVar, @NonNull c cVar2, @Nullable com.instabug.apm.cache.handler.session.f fVar) {
        this.f45142a = cVar;
        this.f45143b = aVar;
        this.f45144c = cVar2;
        this.f45145d = fVar;
    }

    @VisibleForTesting
    @Nullable
    public List a(long j11) {
        return this.f45143b.c(j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull com.instabug.library.model.common.Session r7, @androidx.annotation.NonNull com.instabug.library.model.common.Session r8) {
        /*
            r6 = this;
            com.instabug.apm.configuration.c r0 = r6.f45144c
            long r0 = r0.j()
        L_0x0006:
            java.util.List r2 = r6.a(r0)
            if (r2 == 0) goto L_0x002d
            java.util.Iterator r3 = r2.iterator()
        L_0x0010:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()
            com.instabug.apm.model.APMNetworkLog r4 = (com.instabug.apm.model.APMNetworkLog) r4
            boolean r5 = r6.d(r4)
            if (r5 == 0) goto L_0x0026
            r6.b(r4, r8)
            goto L_0x0010
        L_0x0026:
            r6.b(r4, r7)
            goto L_0x0010
        L_0x002a:
            r6.c(r2)
        L_0x002d:
            if (r2 == 0) goto L_0x0035
            int r2 = r2.size()
            if (r2 > 0) goto L_0x0006
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.networklog.f.a(com.instabug.library.model.common.Session, com.instabug.library.model.common.Session):void");
    }

    @VisibleForTesting
    public void b(@NonNull APMNetworkLog aPMNetworkLog, @NonNull Session session) {
        if (this.f45145d != null) {
            long a11 = this.f45142a.a(session.getId(), aPMNetworkLog);
            if (a11 != -1) {
                this.f45142a.a(a11, "[" + aPMNetworkLog.getMethod() + "] " + aPMNetworkLog.getUrl(), this.f45143b.a(aPMNetworkLog.getId()));
            }
            a aVar = this.f45146e;
            aVar.a("Migrated network request: " + aPMNetworkLog.getUrl());
            if (a11 > 0) {
                this.f45145d.d(session.getId(), 1);
                int a12 = this.f45142a.a(session.getId(), this.f45144c.j());
                if (a12 > 0) {
                    this.f45145d.k(session.getId(), a12);
                }
                this.f45142a.b(this.f45144c.Z());
            }
        }
    }

    @VisibleForTesting
    public void c(@NonNull List list) {
        this.f45143b.a(list.size());
    }

    @VisibleForTesting
    public boolean d(@NonNull APMNetworkLog aPMNetworkLog) {
        return !aPMNetworkLog.executedInBackground();
    }
}
