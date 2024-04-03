package com.instabug.apm.cache.handler.executiontraces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.apm.configuration.c;
import com.instabug.library.model.common.Session;
import java.util.List;
import java.util.concurrent.Executor;

public class f implements e {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final c f45123a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f45124b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final c f45125c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final com.instabug.apm.cache.handler.session.f f45126d;

    public f(@NonNull c cVar, @NonNull a aVar, @NonNull c cVar2, @NonNull Executor executor, @Nullable com.instabug.apm.cache.handler.session.f fVar) {
        this.f45123a = cVar;
        this.f45124b = aVar;
        this.f45125c = cVar2;
        this.f45126d = fVar;
    }

    @VisibleForTesting
    @Nullable
    public List a(long j11) {
        return this.f45124b.a(j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull com.instabug.library.model.common.Session r7, @androidx.annotation.NonNull com.instabug.library.model.common.Session r8) {
        /*
            r6 = this;
            com.instabug.apm.configuration.c r0 = r6.f45125c
            long r0 = r0.k()
        L_0x0006:
            java.util.List r2 = r6.a(r0)
            if (r2 == 0) goto L_0x002d
            java.util.Iterator r3 = r2.iterator()
        L_0x0010:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()
            com.instabug.apm.cache.model.c r4 = (com.instabug.apm.cache.model.c) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.executiontraces.f.a(com.instabug.library.model.common.Session, com.instabug.library.model.common.Session):void");
    }

    @VisibleForTesting
    public void b(@NonNull com.instabug.apm.cache.model.c cVar, @NonNull Session session) {
        if (this.f45126d != null) {
            this.f45123a.a(session.getId(), cVar);
            this.f45126d.h(session.getId(), 1);
        }
    }

    @VisibleForTesting
    public void c(@NonNull List list) {
        this.f45124b.b((long) list.size());
    }

    @VisibleForTesting
    public boolean d(@NonNull com.instabug.apm.cache.model.c cVar) {
        return (!cVar.g() && cVar.a()) || (!cVar.g() && !cVar.a());
    }
}
