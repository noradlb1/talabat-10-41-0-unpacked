package com.instabug.library.diagnostics.customtraces.cache;

import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m f34224a = m.f34273b.a();

    @NotNull
    public final m a() {
        return this.f34224a;
    }

    public boolean updateAttribute(long j11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        m mVar = this.f34224a;
        IBGContentValues iBGContentValues = new IBGContentValues();
        boolean z11 = true;
        iBGContentValues.put("attribute_value", str2, true);
        if (mVar.a("custom_traces_attributes", iBGContentValues, "trace_id = ? AND attribute_key = ?", CollectionsKt__CollectionsKt.listOf(new IBGWhereArg(String.valueOf(j11), true), new IBGWhereArg(str, true))) <= 0) {
            z11 = false;
        }
        InstabugSDKLogger.v("IBG-Core", Intrinsics.stringPlus("Updated custom trace attribute with ", str));
        return z11;
    }

    public boolean a(long j11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        m mVar = this.f34224a;
        IBGContentValues iBGContentValues = new IBGContentValues();
        boolean z11 = true;
        iBGContentValues.put("trace_id", Long.valueOf(j11), true);
        iBGContentValues.put("attribute_key", str, true);
        iBGContentValues.put("attribute_value", str2, true);
        if (mVar.a("custom_traces_attributes", (String) null, iBGContentValues) == -1) {
            z11 = false;
        }
        InstabugSDKLogger.v("IBG-Core", Intrinsics.stringPlus("Added custom trace attribute with ", str));
        return z11;
    }

    public boolean a(long j11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        boolean z11 = true;
        if (this.f34224a.a("custom_traces_attributes", "trace_id = ? AND attribute_key = ?", CollectionsKt__CollectionsKt.listOf(new IBGWhereArg(String.valueOf(j11), true), new IBGWhereArg(str, true))) <= 0) {
            z11 = false;
        }
        InstabugSDKLogger.v("IBG-Core", Intrinsics.stringPlus("Deleted custom trace attribute with ", str));
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        kotlin.io.CloseableKt.closeFinally(r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.HashMap a(long r14) {
        /*
            r13 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg r1 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg
            java.lang.String r14 = java.lang.String.valueOf(r14)
            r15 = 1
            r1.<init>(r14, r15)
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r1)
            com.instabug.library.diagnostics.diagnostics_db.m r2 = r13.a()
            java.lang.String r3 = "custom_traces_attributes"
            r4 = 0
            java.lang.String r5 = "trace_id = ?"
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 242(0xf2, float:3.39E-43)
            r12 = 0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r14 = com.instabug.library.diagnostics.diagnostics_db.m.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r14 != 0) goto L_0x002a
            goto L_0x0058
        L_0x002a:
            boolean r15 = r14.moveToNext()     // Catch:{ all -> 0x0059 }
            if (r15 == 0) goto L_0x0052
            java.lang.String r15 = "attribute_key"
            int r15 = r14.getColumnIndex(r15)     // Catch:{ all -> 0x0059 }
            java.lang.String r15 = r14.getString(r15)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "it.getString(it.getColumnIndex(COLUMN_KEY))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "attribute_value"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = "it.getString(\n          …  )\n                    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0059 }
            r0.put(r15, r1)     // Catch:{ all -> 0x0059 }
            goto L_0x002a
        L_0x0052:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            r15 = 0
            kotlin.io.CloseableKt.closeFinally(r14, r15)
        L_0x0058:
            return r0
        L_0x0059:
            r15 = move-exception
            throw r15     // Catch:{ all -> 0x005b }
        L_0x005b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r14, r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.cache.b.a(long):java.util.HashMap");
    }
}
