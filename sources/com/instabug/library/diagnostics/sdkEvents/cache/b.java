package com.instabug.library.diagnostics.sdkEvents.cache;

import com.instabug.library.diagnostics.sdkEvents.h;
import com.instabug.library.diagnostics.sdkEvents.models.a;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final c f34325a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final h f34326b;

    public b(@NotNull c cVar, @NotNull h hVar) {
        Intrinsics.checkNotNullParameter(cVar, "dbHelper");
        Intrinsics.checkNotNullParameter(hVar, "validator");
        this.f34325a = cVar;
        this.f34326b = hVar;
    }

    public void a(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "event");
        h hVar = this.f34326b;
        if (hVar.a(aVar) && hVar.a(aVar.b())) {
            this.f34325a.a(aVar);
            return;
        }
        InstabugSDKLogger.d("IBG-Core", "Event: " + aVar + " is invalid");
    }

    @Nullable
    public List b() {
        return this.f34325a.b();
    }

    public void clearCache() {
        this.f34325a.c();
    }

    public void a(@Nullable Collection collection) {
        this.f34325a.a(collection);
    }

    public void a() {
        this.f34325a.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@org.jetbrains.annotations.NotNull java.util.List r4) {
        /*
            r3 = this;
            java.lang.String r0 = "sdkEvents"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0010
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0010
            goto L_0x002e
        L_0x0010:
            java.util.Iterator r0 = r4.iterator()
        L_0x0014:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            com.instabug.library.diagnostics.sdkEvents.models.a r1 = (com.instabug.library.diagnostics.sdkEvents.models.a) r1
            com.instabug.library.diagnostics.sdkEvents.h r2 = r3.f34326b
            java.lang.String r1 = r1.b()
            boolean r1 = r2.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x0014
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            if (r0 == 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r4 = 0
        L_0x0033:
            if (r4 != 0) goto L_0x0036
            goto L_0x003b
        L_0x0036:
            com.instabug.library.diagnostics.sdkEvents.cache.c r0 = r3.f34325a
            r0.a((java.util.List) r4)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.sdkEvents.cache.b.a(java.util.List):void");
    }
}
