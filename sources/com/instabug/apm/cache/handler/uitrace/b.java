package com.instabug.apm.cache.handler.uitrace;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.i;
import com.instabug.apm.di.a;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.HashMap;
import java.util.Map;

@Instrumented
public class b implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f45158a = a.v();

    /* renamed from: b  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45159b = a.f();

    private ContentValues a(String str, Long l11, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.APMUiLoadingStageEntry.COLUMN_UI_LOADING_METRIC_ID, Long.valueOf(j11));
        contentValues.put(InstabugDbContract.APMUiLoadingStageEntry.COLUMN_STAGE_NAME, str);
        contentValues.put("duration", l11);
        return contentValues;
    }

    @Nullable
    private Map a(@NonNull Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        while (cursor.moveToNext()) {
            hashMap.put(cursor.getString(cursor.getColumnIndex(InstabugDbContract.APMUiLoadingStageEntry.COLUMN_STAGE_NAME)), Long.valueOf(cursor.getLong(cursor.getColumnIndex("duration"))));
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    private void a(SQLiteDatabaseWrapper sQLiteDatabaseWrapper, Map map, long j11) {
        if (sQLiteDatabaseWrapper != null && map != null) {
            for (Map.Entry entry : map.entrySet()) {
                ContentValues a11 = a((String) entry.getKey(), (Long) entry.getValue(), j11);
                if (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase)) {
                    sQLiteDatabaseWrapper.insert(InstabugDbContract.APMUiLoadingStageEntry.TABLE_NAME, (String) null, a11);
                } else {
                    SQLiteInstrumentation.insert((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.APMUiLoadingStageEntry.TABLE_NAME, (String) null, a11);
                }
            }
        }
    }

    private ContentValues b(i iVar, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.APMUiLoadingMetricEntry.COLUMN_UI_TRACE_ID, Long.valueOf(j11));
        contentValues.put(InstabugDbContract.APMUiLoadingMetricEntry.COLUMN_DURATION, Long.valueOf(iVar.b()));
        contentValues.put(InstabugDbContract.APMUiLoadingMetricEntry.COLUMN_START_TIME, Long.valueOf(iVar.e()));
        contentValues.put("type", iVar.f());
        return contentValues;
    }

    @Nullable
    private i b(@NonNull Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        i iVar = new i();
        iVar.b(cursor.getLong(cursor.getColumnIndex("id")));
        iVar.a(cursor.getLong(cursor.getColumnIndex(InstabugDbContract.APMUiLoadingMetricEntry.COLUMN_DURATION)));
        iVar.c(cursor.getLong(cursor.getColumnIndex(InstabugDbContract.APMUiLoadingMetricEntry.COLUMN_START_TIME)));
        iVar.a(cursor.getString(cursor.getColumnIndex("type")));
        return iVar;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r13 != null) goto L_0x0069;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map b(long r13) {
        /*
            r12 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = r12.f45158a
            r1 = 0
            if (r0 == 0) goto L_0x007b
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r14 = 0
            r7[r14] = r13
            java.lang.String r4 = "apm_ui_loading_stages"
            r5 = 0
            java.lang.String r6 = "ui_loading_metric_id = ?"
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r13 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            if (r13 != 0) goto L_0x002e
            r13 = 0
            r14 = 0
            r8 = 0
            r9 = 0
            r2 = r0
            r3 = r4
            r4 = r13
            r5 = r6
            r6 = r7
            r7 = r14
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            goto L_0x0035
        L_0x002e:
            r3 = r0
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
        L_0x0035:
            if (r13 == 0) goto L_0x0045
            java.util.Map r1 = r12.a((android.database.Cursor) r13)     // Catch:{ Exception -> 0x0040, all -> 0x003c }
            goto L_0x0045
        L_0x003c:
            r14 = move-exception
            r1 = r13
            r13 = r14
            goto L_0x0072
        L_0x0040:
            r14 = move-exception
            r11 = r14
            r14 = r13
            r13 = r11
            goto L_0x004c
        L_0x0045:
            if (r13 == 0) goto L_0x006c
            goto L_0x0069
        L_0x0048:
            r13 = move-exception
            goto L_0x0072
        L_0x004a:
            r13 = move-exception
            r14 = r1
        L_0x004c:
            com.instabug.apm.logger.internal.a r2 = r12.f45159b     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r3.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "DB execution a sql failed: "
            r3.append(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r13.getMessage()     // Catch:{ all -> 0x0070 }
            r3.append(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0070 }
            r2.a(r3, r13)     // Catch:{ all -> 0x0070 }
            if (r14 == 0) goto L_0x006c
            r13 = r14
        L_0x0069:
            r13.close()
        L_0x006c:
            r0.close()
            goto L_0x007b
        L_0x0070:
            r13 = move-exception
            r1 = r14
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()
        L_0x0077:
            r0.close()
            throw r13
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.uitrace.b.b(long):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.instabug.apm.cache.model.i} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r13 != null) goto L_0x0069;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.instabug.apm.cache.model.i c(long r13) {
        /*
            r12 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = r12.f45158a
            r1 = 0
            if (r0 == 0) goto L_0x007b
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r14 = 0
            r7[r14] = r13
            java.lang.String r4 = "apm_ui_loading"
            r5 = 0
            java.lang.String r6 = "ui_trace_id = ?"
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r13 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            if (r13 != 0) goto L_0x002e
            r13 = 0
            r14 = 0
            r8 = 0
            r9 = 0
            r2 = r0
            r3 = r4
            r4 = r13
            r5 = r6
            r6 = r7
            r7 = r14
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            goto L_0x0035
        L_0x002e:
            r3 = r0
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
        L_0x0035:
            if (r13 == 0) goto L_0x0045
            com.instabug.apm.cache.model.i r1 = r12.b((android.database.Cursor) r13)     // Catch:{ Exception -> 0x0040, all -> 0x003c }
            goto L_0x0045
        L_0x003c:
            r14 = move-exception
            r1 = r13
            r13 = r14
            goto L_0x0072
        L_0x0040:
            r14 = move-exception
            r11 = r14
            r14 = r13
            r13 = r11
            goto L_0x004c
        L_0x0045:
            if (r13 == 0) goto L_0x006c
            goto L_0x0069
        L_0x0048:
            r13 = move-exception
            goto L_0x0072
        L_0x004a:
            r13 = move-exception
            r14 = r1
        L_0x004c:
            com.instabug.apm.logger.internal.a r2 = r12.f45159b     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r3.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "DB execution a sql failed: "
            r3.append(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r13.getMessage()     // Catch:{ all -> 0x0070 }
            r3.append(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0070 }
            r2.a(r3, r13)     // Catch:{ all -> 0x0070 }
            if (r14 == 0) goto L_0x006c
            r13 = r14
        L_0x0069:
            r13.close()
        L_0x006c:
            r0.close()
            goto L_0x007b
        L_0x0070:
            r13 = move-exception
            r1 = r14
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()
        L_0x0077:
            r0.close()
            throw r13
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.uitrace.b.c(long):com.instabug.apm.cache.model.i");
    }

    /* JADX INFO: finally extract failed */
    public long a(i iVar, long j11) {
        DatabaseManager databaseManager;
        if (iVar == null || (databaseManager = this.f45158a) == null) {
            return -1;
        }
        SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
        ContentValues b11 = b(iVar, j11);
        try {
            long insert = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.APMUiLoadingMetricEntry.TABLE_NAME, (String) null, b11) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.APMUiLoadingMetricEntry.TABLE_NAME, (String) null, b11);
            Map d11 = iVar.d();
            if (!(d11 == null || d11.isEmpty() || insert == -1)) {
                a(openDatabase, d11, insert);
            }
            openDatabase.close();
            return insert;
        } catch (Throwable th2) {
            openDatabase.close();
            throw th2;
        }
    }

    @Nullable
    public i a(long j11) {
        i c11 = c(j11);
        if (c11 != null) {
            c11.a(b(c11.c()));
        }
        return c11;
    }

    public void a() {
        DatabaseManager databaseManager = this.f45158a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.execSQL(InstabugDbContract.APMUiLoadingMetricEntry.DELETE_ALL);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.APMUiLoadingMetricEntry.DELETE_ALL);
                }
            } catch (Exception e11) {
                com.instabug.apm.logger.internal.a aVar = this.f45159b;
                aVar.a("DB execution a sql failed: " + e11.getMessage(), e11);
            } catch (Throwable th2) {
                openDatabase.close();
                throw th2;
            }
            openDatabase.close();
        }
    }
}
