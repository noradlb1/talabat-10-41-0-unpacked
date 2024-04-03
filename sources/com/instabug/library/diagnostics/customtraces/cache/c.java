package com.instabug.library.diagnostics.customtraces.cache;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import com.instabug.library.diagnostics.customtraces.settings.a;
import com.instabug.library.diagnostics.customtraces.settings.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c implements CustomTracesCacheManager {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d f34225a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final a f34226b;

    public c(@NotNull d dVar, @NotNull a aVar) {
        Intrinsics.checkNotNullParameter(dVar, "tracesDBHelper");
        Intrinsics.checkNotNullParameter(aVar, "attributesDBHelper");
        this.f34225a = dVar;
        this.f34226b = aVar;
    }

    @NotNull
    @VisibleForTesting
    public final a a() {
        return this.f34226b;
    }

    @NotNull
    @VisibleForTesting
    public final d b() {
        return this.f34225a;
    }

    @NotNull
    @VisibleForTesting
    public final a c() {
        a b11 = b.f34237a.b();
        return b11 == null ? new a(false, 0, false, false, 15, (DefaultConstructorMarker) null) : b11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Long} */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearSyncedTraces(@org.jetbrains.annotations.NotNull java.util.List r9) {
        /*
            r8 = this;
            java.lang.String r0 = "traces"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x000e:
            boolean r1 = r9.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r9.next()
            com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace r1 = (com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace) r1
            long r4 = r8.getTraceId(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            long r4 = r1.longValue()
            r6 = -1
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r3 = 0
        L_0x0030:
            if (r3 == 0) goto L_0x0033
            r2 = r1
        L_0x0033:
            if (r2 != 0) goto L_0x0036
            goto L_0x000e
        L_0x0036:
            long r1 = r2.longValue()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.add(r1)
            goto L_0x000e
        L_0x0042:
            boolean r9 = r0.isEmpty()
            r9 = r9 ^ r3
            if (r9 == 0) goto L_0x004a
            r2 = r8
        L_0x004a:
            if (r2 != 0) goto L_0x004d
            goto L_0x0054
        L_0x004d:
            com.instabug.library.diagnostics.customtraces.cache.d r9 = r8.b()
            r9.a((java.util.List) r0)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.cache.c.clearSyncedTraces(java.util.List):void");
    }

    public void clearTracesByName(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tracesNames");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            i11++;
            arrayList.add('\'' + str + '\'');
        }
        b().b(arrayList);
    }

    public void deleteAll() {
        this.f34225a.a();
    }

    public boolean endTrace(long j11, long j12, boolean z11) {
        return this.f34225a.endTrace(j11, j12, z11);
    }

    @NotNull
    public List getAllTraces() {
        List<IBGCustomTrace> allTraces = this.f34225a.getAllTraces();
        for (IBGCustomTrace iBGCustomTrace : allTraces) {
            iBGCustomTrace.setAttributes(a().a(iBGCustomTrace.getId()));
        }
        return allTraces;
    }

    public long getTraceId(@NotNull IBGCustomTrace iBGCustomTrace) {
        Intrinsics.checkNotNullParameter(iBGCustomTrace, "trace");
        return this.f34225a.getTraceId(iBGCustomTrace);
    }

    public void logTrace(@NotNull String str, long j11, long j12, boolean z11) {
        boolean z12;
        boolean z13 = z11;
        Intrinsics.checkNotNullParameter(str, "traceName");
        IBGCustomTrace iBGCustomTrace = r0;
        IBGCustomTrace iBGCustomTrace2 = new IBGCustomTrace(0, str, 0, 0, j12, z13, z11, (HashMap) null, j11, Opcodes.F2D, (DefaultConstructorMarker) null);
        Long valueOf = Long.valueOf(this.f34225a.a(iBGCustomTrace));
        if (valueOf.longValue() != -1) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.longValue();
            b().trimToLimit(c().b());
        }
    }

    public void removeUnEndedTraces() {
        this.f34225a.removeUnEndedTraces();
    }

    public boolean setAttribute(long j11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (str2 == null) {
            return false;
        }
        return a().a(j11, str, str2);
    }

    public long startTrace(@NotNull IBGCustomTrace iBGCustomTrace) {
        boolean z11;
        Intrinsics.checkNotNullParameter(iBGCustomTrace, "trace");
        Long valueOf = Long.valueOf(this.f34225a.a(iBGCustomTrace));
        if (valueOf.longValue() != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            valueOf = null;
        }
        if (valueOf == null) {
            return -1;
        }
        valueOf.longValue();
        b().trimToLimit(c().b());
        return valueOf.longValue();
    }

    public boolean updateAttribute(long j11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (str2 == null) {
            return this.f34226b.a(j11, str);
        }
        return this.f34226b.updateAttribute(j11, str, str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(d dVar, a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? com.instabug.library.diagnostics.customtraces.di.a.f34228a.h() : dVar, (i11 & 2) != 0 ? com.instabug.library.diagnostics.customtraces.di.a.f34228a.a() : aVar);
    }
}
