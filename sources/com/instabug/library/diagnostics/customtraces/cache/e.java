package com.instabug.library.diagnostics.customtraces.cache;

import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.extenstions.a;
import com.instabug.library.util.extenstions.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public final class e implements d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m f34227a = m.f34273b.a();

    public long a(@NotNull IBGCustomTrace iBGCustomTrace) {
        Intrinsics.checkNotNullParameter(iBGCustomTrace, "trace");
        m mVar = this.f34227a;
        IBGContentValues iBGContentValues = new IBGContentValues();
        iBGContentValues.put("name", iBGCustomTrace.getName(), true);
        iBGContentValues.put("start_time", Long.valueOf(iBGCustomTrace.getStartTime()), true);
        iBGContentValues.put("started_on_bg", Integer.valueOf(a.a(Boolean.valueOf(iBGCustomTrace.getStartedInBG()))), true);
        iBGContentValues.put("ended_on_bg", Integer.valueOf(a.a(Boolean.valueOf(iBGCustomTrace.getEndedInBG()))), true);
        iBGContentValues.put("duration", Long.valueOf(iBGCustomTrace.getDuration()), true);
        long a11 = mVar.a("diagnostics_custom_traces", (String) null, iBGContentValues);
        InstabugSDKLogger.v("IBG-Core", "Started custom trace " + iBGCustomTrace.getName() + " with id: " + a11);
        return a11;
    }

    public void b(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "tracesNames");
        m.a(this.f34227a, "diagnostics_custom_traces", Intrinsics.stringPlus("name in ", CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, "(", ")", 0, (CharSequence) null, (Function1) null, 57, (Object) null)), (List) null, 4, (Object) null);
    }

    public boolean endTrace(long j11, long j12, boolean z11) {
        m mVar = this.f34227a;
        IBGContentValues iBGContentValues = new IBGContentValues();
        boolean z12 = true;
        iBGContentValues.put("duration", Long.valueOf(j12), true);
        iBGContentValues.put("ended_on_bg", Integer.valueOf(a.a(Boolean.valueOf(z11))), true);
        if (mVar.a("diagnostics_custom_traces", iBGContentValues, "trace_id = ? AND duration = -1", CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg(String.valueOf(j11), true))) <= 0) {
            z12 = false;
        }
        InstabugSDKLogger.v("IBG-Core", "Custom trace with id " + j11 + " has ended");
        return z12;
    }

    @NotNull
    public List getAllTraces() {
        Throwable th2;
        ArrayList arrayList = new ArrayList();
        IBGCursor a11 = m.a(this.f34227a, "diagnostics_custom_traces", (String[]) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 254, (Object) null);
        if (a11 != null) {
            while (a11.moveToNext()) {
                try {
                    long j11 = a11.getLong(a11.getColumnIndex("trace_id"));
                    String string = a11.getString(a11.getColumnIndex("name"));
                    long j12 = a11.getLong(a11.getColumnIndex("start_time"));
                    long j13 = a11.getLong(a11.getColumnIndex("duration"));
                    boolean a12 = c.a(a11.getInt(a11.getColumnIndex("started_on_bg")));
                    boolean a13 = c.a(a11.getInt(a11.getColumnIndex("ended_on_bg")));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(cursor.getColumnIndex(COLUMN_NAME))");
                    arrayList.add(new IBGCustomTrace(j11, string, 0, 0, j13, a12, a13, (HashMap) null, j12, Opcodes.F2L, (DefaultConstructorMarker) null));
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    CloseableKt.closeFinally(a11, th2);
                    throw th4;
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(a11, (Throwable) null);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006c, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getTraceId(@org.jetbrains.annotations.NotNull com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace r13) {
        /*
            r12 = this;
            java.lang.String r0 = "trace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.instabug.library.diagnostics.diagnostics_db.m r1 = r12.f34227a
            r0 = 3
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg[] r0 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg[r0]
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg r2 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg
            java.lang.String r3 = r13.getName()
            r4 = 1
            r2.<init>(r3, r4)
            r3 = 0
            r0[r3] = r2
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg r2 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg
            long r5 = r13.getStartTime()
            java.lang.String r3 = java.lang.String.valueOf(r5)
            r2.<init>(r3, r4)
            r0[r4] = r2
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg r2 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg
            long r5 = r13.getDuration()
            java.lang.String r13 = java.lang.String.valueOf(r5)
            r2.<init>(r13, r4)
            r13 = 2
            r0[r13] = r2
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r0)
            java.lang.String r13 = "trace_id"
            java.lang.String[] r3 = new java.lang.String[]{r13}
            java.lang.String r2 = "diagnostics_custom_traces"
            java.lang.String r4 = "name = ? AND start_time = ? AND duration = ?"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 240(0xf0, float:3.36E-43)
            r11 = 0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r0 = com.instabug.library.diagnostics.diagnostics_db.m.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = -1
            if (r0 != 0) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            boolean r3 = r0.moveToFirst()     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0062
            int r13 = r0.getColumnIndex(r13)     // Catch:{ all -> 0x0069 }
            long r1 = r0.getLong(r13)     // Catch:{ all -> 0x0069 }
        L_0x0062:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0069 }
            r13 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r13)
        L_0x0068:
            return r1
        L_0x0069:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x006b }
        L_0x006b:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r13)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.cache.e.getTraceId(com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace):long");
    }

    public void removeUnEndedTraces() {
        m.a(this.f34227a, "diagnostics_custom_traces", "duration = -1", (List) null, 4, (Object) null);
    }

    public void trimToLimit(int i11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IBGWhereArg("-1", true));
        arrayList.add(new IBGWhereArg(String.valueOf(i11), true));
        this.f34227a.a("diagnostics_custom_traces", "rowid IN (" + "SELECT rowid FROM diagnostics_custom_traces ORDER BY rowid DESC LIMIT ? OFFSET ?" + ')', (List) arrayList);
    }

    public void a() {
        m.a(this.f34227a, "diagnostics_custom_traces", (String) null, (List) null, 6, (Object) null);
    }

    public void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        m.a(this.f34227a, "diagnostics_custom_traces", Intrinsics.stringPlus("trace_id in ", CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, "(", ")", 0, (CharSequence) null, (Function1) null, 57, (Object) null)), (List) null, 4, (Object) null);
    }
}
