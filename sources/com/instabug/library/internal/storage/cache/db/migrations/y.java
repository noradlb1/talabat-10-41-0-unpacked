package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class y implements c {
    private final void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.CREATE_TABLE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean c(android.database.sqlite.SQLiteDatabase r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = "SELECT * FROM crashes_table LIMIT 0"
            r1 = 0
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ all -> 0x0036 }
            boolean r3 = r5 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ all -> 0x0036 }
            if (r3 != 0) goto L_0x0010
            android.database.Cursor r5 = r5.rawQuery(r0, r2)     // Catch:{ all -> 0x0036 }
            goto L_0x0014
        L_0x0010:
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r5, r0, r2)     // Catch:{ all -> 0x0036 }
        L_0x0014:
            if (r5 != 0) goto L_0x0017
            goto L_0x0026
        L_0x0017:
            java.lang.String r0 = "fingerprint"
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x002f }
            r2 = -1
            if (r0 == r2) goto L_0x0022
            r0 = 1
            r1 = r0
        L_0x0022:
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r0)     // Catch:{ all -> 0x0036 }
        L_0x0026:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0036 }
            goto L_0x0041
        L_0x002f:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r0)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0041:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.Result.m6335isFailureimpl(r5)
            if (r1 == 0) goto L_0x004a
            r5 = r0
        L_0x004a:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.db.migrations.y.c(android.database.sqlite.SQLiteDatabase):boolean");
    }

    public void a(@NotNull SQLiteDatabase sQLiteDatabase) {
        Object obj;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        if (!c(sQLiteDatabase)) {
            try {
                Result.Companion companion = Result.Companion;
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    sQLiteDatabase.execSQL("ALTER TABLE crashes_table ADD COLUMN fingerprint TEXT DEFAULT NULL;");
                } else {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE crashes_table ADD COLUMN fingerprint TEXT DEFAULT NULL;");
                }
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m6332exceptionOrNullimpl(obj) != null) {
                b(sQLiteDatabase);
            }
        }
    }
}
