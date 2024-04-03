package com.instabug.apm.cache.handler.uitrace;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.i;
import com.instabug.apm.cache.model.j;
import com.instabug.apm.di.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Iterator;
import java.util.List;

@Instrumented
public class d implements c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private DatabaseManager f45160a = a.v();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.logger.internal.a f45161b = a.f();

    /* renamed from: c  reason: collision with root package name */
    private a f45162c = a.e0();

    private j a(Cursor cursor) {
        j jVar = new j();
        jVar.b((long) cursor.getInt(cursor.getColumnIndex("id")));
        jVar.c(cursor.getString(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_NAME)));
        jVar.e(cursor.getString(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_SCREEN_TITLE)));
        jVar.a((long) cursor.getInt(cursor.getColumnIndex("duration")));
        jVar.d((long) cursor.getInt(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_SMALL_DROPS_DURATION)));
        jVar.c((long) cursor.getInt(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_LARGE_DROPS_DURATION)));
        jVar.a(cursor.getInt(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_BATTERY_LEVEL)));
        boolean z11 = false;
        jVar.a(Boolean.valueOf(cursor.getInt(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_POWER_SAVE_MODE)) == 1));
        jVar.b(cursor.getInt(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_REFRESH_RATE)));
        jVar.e(cursor.getLong(cursor.getColumnIndex("start_time")));
        jVar.a(cursor.getString(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_CONTAINER_NAME)));
        jVar.b(cursor.getString(cursor.getColumnIndex("module_name")));
        jVar.d(cursor.getString(cursor.getColumnIndex("orientation")));
        if (cursor.getInt(cursor.getColumnIndex(InstabugDbContract.APMUiTraceEntry.COLUMN_USER_DEFINED)) == 1) {
            z11 = true;
        }
        jVar.a(z11);
        return jVar;
    }

    private void a(@NonNull List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                i a11 = this.f45162c.a(jVar.d());
                if (a11 != null) {
                    jVar.a(a11);
                }
            }
        }
    }

    private ContentValues b(j jVar) {
        ContentValues contentValues = new ContentValues();
        if (jVar.g() != null) {
            contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_NAME, jVar.g());
        }
        if (jVar.l() != null) {
            contentValues.put("session_id", jVar.l());
        }
        contentValues.put("duration", Long.valueOf(jVar.c()));
        contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_SMALL_DROPS_DURATION, Long.valueOf(jVar.m()));
        contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_LARGE_DROPS_DURATION, Long.valueOf(jVar.e()));
        contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_BATTERY_LEVEL, Integer.valueOf(jVar.a()));
        contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_USER_DEFINED, Boolean.valueOf(jVar.t()));
        contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_REFRESH_RATE, Integer.valueOf(jVar.j()));
        contentValues.put("start_time", Long.valueOf(jVar.n()));
        if (jVar.k() != null) {
            contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_SCREEN_TITLE, jVar.k());
        }
        if (jVar.i() != null) {
            contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_POWER_SAVE_MODE, jVar.i());
        }
        if (jVar.b() != null) {
            contentValues.put(InstabugDbContract.APMUiTraceEntry.COLUMN_CONTAINER_NAME, jVar.b());
        }
        if (jVar.f() != null) {
            contentValues.put("module_name", jVar.f());
        }
        if (jVar.h() != null) {
            contentValues.put("orientation", jVar.h());
        }
        return contentValues;
    }

    private void b() {
        DatabaseManager databaseManager = this.f45160a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("DELETE FROM apm_ui_traces WHERE (small_drops_duration = -1 OR large_drop_duration = -1) AND id NOT IN (SELECT ui_trace_id FROM apm_ui_loading ) ");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "DELETE FROM apm_ui_traces WHERE (small_drops_duration = -1 OR large_drop_duration = -1) AND id NOT IN (SELECT ui_trace_id FROM apm_ui_loading ) ");
            }
            openDatabase.close();
        }
    }

    public int a(String str, long j11) {
        if (this.f45160a == null) {
            return -1;
        }
        String str2 = "session_id = ? AND id NOT IN (" + "SELECT id FROM apm_ui_traces where session_id = ? ORDER BY id DESC LIMIT ?" + ")";
        String[] strArr = {str, str, String.valueOf(j11)};
        SQLiteDatabaseWrapper openDatabase = this.f45160a.openDatabase();
        int delete = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.delete(InstabugDbContract.APMUiTraceEntry.TABLE_NAME, str2, strArr) : SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMUiTraceEntry.TABLE_NAME, str2, strArr);
        openDatabase.close();
        return delete;
    }

    public long a(j jVar) {
        DatabaseManager databaseManager;
        a aVar;
        if (jVar == null || (databaseManager = this.f45160a) == null) {
            return -1;
        }
        SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
        ContentValues b11 = b(jVar);
        long insert = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.APMUiTraceEntry.TABLE_NAME, (String) null, b11) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.APMUiTraceEntry.TABLE_NAME, (String) null, b11);
        openDatabase.close();
        i p11 = jVar.p();
        if (!(p11 == null || insert == -1 || (aVar = this.f45162c) == null)) {
            aVar.a(p11, insert);
        }
        return insert;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(@androidx.annotation.NonNull java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            r1 = 0
            if (r14 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.instabug.library.internal.storage.cache.db.DatabaseManager r2 = r13.f45160a
            if (r2 == 0) goto L_0x009b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = r13.f45160a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r3 = r3.openDatabase()
            java.lang.String r7 = "session_id = ?"
            r4 = 1
            java.lang.String[] r8 = new java.lang.String[r4]
            r4 = 0
            r8[r4] = r14
            java.lang.String r5 = "apm_ui_traces"
            r6 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            boolean r14 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            if (r14 != 0) goto L_0x0031
            r6 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            android.database.Cursor r14 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            goto L_0x0038
        L_0x0031:
            r4 = r3
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            android.database.Cursor r14 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
        L_0x0038:
            if (r14 == 0) goto L_0x0051
        L_0x003a:
            boolean r4 = r14.moveToNext()     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            if (r4 == 0) goto L_0x0051
            com.instabug.apm.cache.model.j r4 = r13.a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            r2.add(r4)     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            goto L_0x003a
        L_0x0048:
            r0 = move-exception
            r1 = r14
            r14 = r0
            goto L_0x0095
        L_0x004c:
            r2 = move-exception
            r12 = r2
            r2 = r14
            r14 = r12
            goto L_0x005f
        L_0x0051:
            r3.close()     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
            if (r14 == 0) goto L_0x0059
            r14.close()
        L_0x0059:
            r1 = r2
            goto L_0x009b
        L_0x005b:
            r14 = move-exception
            goto L_0x0095
        L_0x005d:
            r14 = move-exception
            r2 = r1
        L_0x005f:
            com.instabug.apm.logger.internal.a r3 = r13.f45161b     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r4.<init>()     // Catch:{ all -> 0x0093 }
            r4.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = r14.getMessage()     // Catch:{ all -> 0x0093 }
            r4.append(r5)     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0093 }
            r3.a(r4, r14)     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r3.<init>()     // Catch:{ all -> 0x0093 }
            r3.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r14.getMessage()     // Catch:{ all -> 0x0093 }
            r3.append(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0093 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r14, r0)     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x009b
            r2.close()
            goto L_0x009b
        L_0x0093:
            r14 = move-exception
            r1 = r2
        L_0x0095:
            if (r1 == 0) goto L_0x009a
            r1.close()
        L_0x009a:
            throw r14
        L_0x009b:
            if (r1 == 0) goto L_0x00a0
            r13.a((java.util.List) r1)
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.uitrace.d.a(java.lang.String):java.util.List");
    }

    public void a() {
        DatabaseManager databaseManager = this.f45160a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.APMUiTraceEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.APMUiTraceEntry.DELETE_ALL);
            }
            openDatabase.close();
        }
    }

    public void b(long j11) {
        if (this.f45160a != null) {
            String str = "id NOT IN (" + " SELECT id FROM apm_ui_traces ORDER BY id DESC LIMIT ?" + ")";
            String[] strArr = {String.valueOf(j11)};
            SQLiteDatabaseWrapper openDatabase = this.f45160a.openDatabase();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.APMUiTraceEntry.TABLE_NAME, str, strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMUiTraceEntry.TABLE_NAME, str, strArr);
                }
            } catch (Exception e11) {
                this.f45161b.a("DB execution a sql failed: " + e11.getMessage(), e11);
                IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed: " + e11.getMessage());
                if (openDatabase == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (openDatabase != null) {
                    openDatabase.close();
                }
                throw th2;
            }
            openDatabase.close();
        }
    }

    public void c() {
        DatabaseManager databaseManager = this.f45160a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("UPDATE apm_ui_traces SET small_drops_duration = -1, large_drop_duration = -1");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "UPDATE apm_ui_traces SET small_drops_duration = -1, large_drop_duration = -1");
            }
            openDatabase.close();
            b();
        }
    }

    public void e() {
        a aVar = this.f45162c;
        if (aVar != null) {
            aVar.a();
            b();
        }
    }
}
