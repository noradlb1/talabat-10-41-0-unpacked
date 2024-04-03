package com.instabug.library.diagnostics.diagnostics_db.migration;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.diagnostics_db.o;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Instrumented
public abstract class e {
    private static final void a(String str, SQLiteDatabase sQLiteDatabase) {
        String stringPlus = Intrinsics.stringPlus("DROP TABLE IF EXISTS ", str);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(stringPlus);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, stringPlus);
        }
        InstabugSDKLogger.v("DBDestructiveMigration", Intrinsics.stringPlus("Dropped table ", str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Result b(@org.jetbrains.annotations.Nullable android.database.sqlite.SQLiteDatabase r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0005
            goto L_0x0092
        L_0x0005:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "SELECT name FROM sqlite_master WHERE type='table'"
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r7, r1, r0)     // Catch:{ all -> 0x0055 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004e }
            int r3 = r1.getCount()     // Catch:{ all -> 0x004e }
            r2.<init>(r3)     // Catch:{ all -> 0x004e }
        L_0x0016:
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x004e }
            r4 = 0
            if (r3 == 0) goto L_0x0025
            java.lang.String r3 = r1.getString(r4)     // Catch:{ all -> 0x004e }
            r2.add(r3)     // Catch:{ all -> 0x004e }
            goto L_0x0016
        L_0x0025:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x004e }
        L_0x0029:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x004e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x004e }
            java.lang.String r5 = "sqlite_"
            r6 = 2
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r3, r5, r4, r6, r0)     // Catch:{ all -> 0x004e }
            if (r5 != 0) goto L_0x0029
            a(r3, r7)     // Catch:{ all -> 0x004e }
            goto L_0x0029
        L_0x0042:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004e }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0055 }
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)     // Catch:{ all -> 0x0055 }
            goto L_0x0060
        L_0x004e:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r7)     // Catch:{ all -> 0x0055 }
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r7 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m6329constructorimpl(r7)
        L_0x0060:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r7)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0069
            goto L_0x0077
        L_0x0069:
            java.lang.String r2 = r0.getMessage()
            if (r2 != 0) goto L_0x0070
            r2 = r1
        L_0x0070:
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            com.instabug.library.core.InstabugCore.reportError(r0, r2)
        L_0x0077:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r7)
            if (r0 != 0) goto L_0x007e
            goto L_0x008e
        L_0x007e:
            java.lang.String r2 = r0.getMessage()
            if (r2 != 0) goto L_0x0085
            r2 = r1
        L_0x0085:
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            java.lang.String r2 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r1, r0)
        L_0x008e:
            kotlin.Result r0 = kotlin.Result.m6328boximpl(r7)
        L_0x0092:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.diagnostics_db.migration.e.b(android.database.sqlite.SQLiteDatabase):kotlin.Result");
    }

    public static final void c(@Nullable SQLiteDatabase sQLiteDatabase) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DiskUtils.deleteNonfatalStateFiles();
            b(sQLiteDatabase);
            a(sQLiteDatabase);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            InstabugSDKLogger.e("IBG-Core", "Failed running destructive migration");
        }
    }

    public static final void a(@Nullable SQLiteDatabase sQLiteDatabase) {
        Object obj;
        if (sQLiteDatabase != null) {
            try {
                Result.Companion companion = Result.Companion;
                SQLiteInstrumentation.execSQL(sQLiteDatabase, o.f34283a.c());
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS diagnostics_custom_traces ( trace_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,start_time INTEGER,started_on_bg INTEGER,ended_on_bg INTEGER,duration INTEGER default -1 )");
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS custom_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES diagnostics_custom_traces(trace_id) ON DELETE CASCADE )");
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS non_fatal_occurrence ( id INTEGER PRIMARY KEY AUTOINCREMENT,reported_at INTEGER,state_file TEXT,non_fatal_id INTEGER, CONSTRAINT non_fatal_id, FOREIGN KEY (non_fatal_id) REFERENCES non_fatal(id) ON DELETE CASCADE )");
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
            if (r02 != null) {
                String message = r02.getMessage();
                if (message == null) {
                    message = "";
                }
                InstabugCore.reportError(r02, Intrinsics.stringPlus("", message));
            }
            Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
            if (r03 != null) {
                String message2 = r03.getMessage();
                if (message2 == null) {
                    message2 = "";
                }
                InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("", message2), r03);
            }
            Result.m6328boximpl(obj);
        }
    }
}
