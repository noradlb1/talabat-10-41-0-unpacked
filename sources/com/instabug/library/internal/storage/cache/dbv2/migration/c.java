package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51081a;

    public c(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51081a = sQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r9 = this;
            java.lang.String r0 = "IBG-Core"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r9.f51081a     // Catch:{ Exception -> 0x0070 }
            java.lang.String r3 = "SELECT name FROM sqlite_master WHERE type='table'"
            boolean r4 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0070 }
            if (r4 != 0) goto L_0x0010
            android.database.Cursor r2 = r2.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0014
        L_0x0010:
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r2, r3, r1)     // Catch:{ Exception -> 0x0070 }
        L_0x0014:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            int r4 = r2.getCount()     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
        L_0x001d:
            boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            r5 = 0
            if (r4 == 0) goto L_0x0031
            java.lang.String r4 = r2.getString(r5)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            java.lang.String r5 = "cursor.getString(0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            r3.add(r4)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            goto L_0x001d
        L_0x0031:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
        L_0x0035:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            if (r4 == 0) goto L_0x0079
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            java.lang.String r6 = "sqlite_"
            r7 = 2
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r4, r6, r5, r7, r1)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            if (r6 == 0) goto L_0x004c
            goto L_0x0035
        L_0x004c:
            android.database.sqlite.SQLiteDatabase r6 = r9.f51081a     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            java.lang.String r7 = "DROP TABLE IF EXISTS "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r4)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            boolean r8 = r6 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            if (r8 != 0) goto L_0x005c
            r6.execSQL(r7)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            goto L_0x005f
        L_0x005c:
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.execSQL(r6, r7)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
        L_0x005f:
            java.lang.String r6 = "Dropped table "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r4)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            com.instabug.library.util.InstabugSDKLogger.v(r0, r4)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            goto L_0x0035
        L_0x0069:
            r0 = move-exception
            r1 = r2
            goto L_0x007d
        L_0x006c:
            r1 = r2
            goto L_0x0070
        L_0x006e:
            r0 = move-exception
            goto L_0x007d
        L_0x0070:
            java.lang.String r2 = "error dropping DB tables"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r2)     // Catch:{ all -> 0x006e }
            if (r1 != 0) goto L_0x0078
            goto L_0x007c
        L_0x0078:
            r2 = r1
        L_0x0079:
            r2.close()
        L_0x007c:
            return
        L_0x007d:
            if (r1 != 0) goto L_0x0080
            goto L_0x0083
        L_0x0080:
            r1.close()
        L_0x0083:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.dbv2.migration.c.b():void");
    }

    public final void a() {
        SQLiteDatabase sQLiteDatabase = this.f51081a;
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bugs_table ( id TEXT PRIMARY KEY,temporary_server_token TEXT,type TEXT,message TEXT,state TEXT,bug_state TEXT,view_hierarchy TEXT,categories_list TEXT )");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS bugs_table ( id TEXT PRIMARY KEY,temporary_server_token TEXT,type TEXT,message TEXT,state TEXT,bug_state TEXT,view_hierarchy TEXT,categories_list TEXT )");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS fatal_hangs_table ( id TEXT,temporary_server_token TEXT,message TEXT,fatal_hang_state TEXT,state TEXT,main_thread_details TEXT,threads_details TEXT,last_activity TEXT,uuid TEXT DEFAULT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS fatal_hangs_table ( id TEXT,temporary_server_token TEXT,message TEXT,fatal_hang_state TEXT,state TEXT,main_thread_details TEXT,threads_details TEXT,last_activity TEXT,uuid TEXT DEFAULT NULL)");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS terminations_table ( id INTEGER,temporary_server_token TEXT,termination_state TEXT,state TEXT,uuid TEXT DEFAULT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS terminations_table ( id INTEGER,temporary_server_token TEXT,termination_state TEXT,state TEXT,uuid TEXT DEFAULT NULL)");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_table ( session_serial INTEGER PRIMARY KEY AUTOINCREMENT,session_id TEXT,foreground_start_time INTEGER,background_start_time INTEGER,nano_start_time INTEGER,duration INTEGER,user_attributes TEXT,user_events TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,users_page_enabled INTEGER,v2_session_sent INTEGER,sync_status TEXT,production_usage TEXT,stitching_state TEXT )");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS session_table ( session_serial INTEGER PRIMARY KEY AUTOINCREMENT,session_id TEXT,foreground_start_time INTEGER,background_start_time INTEGER,nano_start_time INTEGER,duration INTEGER,user_attributes TEXT,user_events TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,users_page_enabled INTEGER,v2_session_sent INTEGER,sync_status TEXT,production_usage TEXT,stitching_state TEXT )");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_experiment_table ( id INTEGER PRIMARY KEY AUTOINCREMENT,experiment_array TEXT,session_serial INTEGER UNIQUE ,experiments_dropped_count INTEGER, CONSTRAINT session_serial_foreign_key FOREIGN KEY (session_serial) REFERENCES session_table(session_serial) ON DELETE CASCADE )");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS session_experiment_table ( id INTEGER PRIMARY KEY AUTOINCREMENT,experiment_array TEXT,session_serial INTEGER UNIQUE ,experiments_dropped_count INTEGER, CONSTRAINT session_serial_foreign_key FOREIGN KEY (session_serial) REFERENCES session_table(session_serial) ON DELETE CASCADE )");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_incident ( id INTEGER,session_id TEXT,incident_id TEXT,incident_type TEXT,validation_status INTEGER DEFAULT 0 )");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS session_incident ( id INTEGER,session_id TEXT,incident_id TEXT,incident_type TEXT,validation_status INTEGER DEFAULT 0 )");
        }
    }

    public final void c() {
        try {
            DiskUtils.deleteAllStateFiles();
            b();
            a();
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-Core", "Failed running destructive migration");
        }
    }
}
