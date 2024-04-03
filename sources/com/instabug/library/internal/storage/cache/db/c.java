package com.instabug.library.internal.storage.cache.db;

import com.newrelic.agent.android.instrumentation.Instrumented;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f51032a = new c();

    private c() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0063, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(@org.jetbrains.annotations.NotNull android.database.sqlite.SQLiteDatabase r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "table"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "column"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "PRAGMA table_info('%s')"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0068 }
            r3 = 0
            r2[r3] = r6     // Catch:{ all -> 0x0068 }
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r2, r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = java.lang.String.format(r0, r6)     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ all -> 0x0068 }
            boolean r0 = r5 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ all -> 0x0068 }
            r2 = 0
            if (r0 != 0) goto L_0x0031
            android.database.Cursor r5 = r5.rawQuery(r6, r2)     // Catch:{ all -> 0x0068 }
            goto L_0x0035
        L_0x0031:
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r5, r6, r2)     // Catch:{ all -> 0x0068 }
        L_0x0035:
            if (r5 != 0) goto L_0x0038
            goto L_0x0058
        L_0x0038:
            r5.moveToFirst()     // Catch:{ all -> 0x0061 }
        L_0x003b:
            java.lang.String r6 = "name"
            int r6 = r5.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ all -> 0x0061 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0061 }
            if (r6 != 0) goto L_0x0052
            boolean r6 = r5.moveToNext()     // Catch:{ all -> 0x0061 }
            if (r6 != 0) goto L_0x003b
            r1 = r3
        L_0x0052:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0061 }
            kotlin.io.CloseableKt.closeFinally(r5, r2)     // Catch:{ all -> 0x0068 }
            r3 = r1
        L_0x0058:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0068 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0068 }
            goto L_0x0073
        L_0x0061:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch:{ all -> 0x0068 }
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0073:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            boolean r7 = kotlin.Result.m6335isFailureimpl(r5)
            if (r7 == 0) goto L_0x007c
            r5 = r6
        L_0x007c:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.db.c.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }
}
