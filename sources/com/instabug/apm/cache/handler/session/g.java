package com.instabug.apm.cache.handler.session;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
@WorkerThread
public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f45156a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final a f45157b = com.instabug.apm.di.a.f();

    private void a(SQLiteDatabaseWrapper sQLiteDatabaseWrapper, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", str);
        sQLiteDatabaseWrapper.insertWithOnConflict(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, (String) null, contentValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r16, java.lang.String r17, java.lang.String r18, int r19) {
        /*
            r15 = this;
            r0 = r16
            r9 = r17
            r10 = r18
            java.lang.String r11 = "DB execution a sql failed: "
            java.lang.String r12 = "session_id = ?"
            r1 = 1
            java.lang.String[] r13 = new java.lang.String[r1]
            r1 = 0
            r13[r1] = r9
            r14 = 0
            java.lang.String r2 = "apm_session_meta_data"
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            boolean r1 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            if (r1 != 0) goto L_0x0028
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r16
            r4 = r12
            r5 = r13
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            goto L_0x0031
        L_0x0028:
            r1 = r0
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r4 = r12
            r5 = r13
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
        L_0x0031:
            r14 = r1
            if (r14 == 0) goto L_0x0067
            boolean r1 = r14.moveToFirst()     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            if (r1 == 0) goto L_0x0067
            int r1 = r14.getColumnIndex(r10)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            int r1 = r14.getInt(r1)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r14.close()     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            int r1 = r1 + r19
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r2.<init>()     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.lang.String r3 = "session_id"
            r2.put(r3, r9)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            r2.put(r10, r1)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            java.lang.String r1 = "apm_session_meta_data"
            boolean r3 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            if (r3 != 0) goto L_0x0062
            r0.update(r1, r2, r12, r13)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            goto L_0x0067
        L_0x0062:
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0     // Catch:{ Exception -> 0x006e, all -> 0x006b }
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.update(r0, r1, r2, r12, r13)     // Catch:{ Exception -> 0x006e, all -> 0x006b }
        L_0x0067:
            r1 = r15
            if (r14 == 0) goto L_0x00a3
            goto L_0x00a0
        L_0x006b:
            r0 = move-exception
            r1 = r15
            goto L_0x00a5
        L_0x006e:
            r0 = move-exception
            r1 = r15
            com.instabug.apm.logger.internal.a r2 = r1.f45157b     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r3.<init>()     // Catch:{ all -> 0x00a4 }
            r3.append(r11)     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x00a4 }
            r3.append(r4)     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a4 }
            r2.a(r3, r0)     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r2.<init>()     // Catch:{ all -> 0x00a4 }
            r2.append(r11)     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00a4 }
            r2.append(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a4 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r2)     // Catch:{ all -> 0x00a4 }
            if (r14 == 0) goto L_0x00a3
        L_0x00a0:
            r14.close()
        L_0x00a3:
            return
        L_0x00a4:
            r0 = move-exception
        L_0x00a5:
            if (r14 == 0) goto L_0x00aa
            r14.close()
        L_0x00aa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.session.g.a(com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper, java.lang.String, java.lang.String, int):void");
    }

    private void b(SQLiteDatabaseWrapper sQLiteDatabaseWrapper, String str, String str2, int i11) {
        String[] strArr = {str};
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("session_id", str);
            contentValues.put(str2, Integer.valueOf(i11));
            if (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase)) {
                sQLiteDatabaseWrapper.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, "session_id = ?", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, "session_id = ?", strArr);
            }
        } catch (Exception e11) {
            a aVar = this.f45157b;
            aVar.a("DB execution a sql failed: " + e11.getMessage(), e11);
            IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed: " + e11.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x011c  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.instabug.apm.cache.model.g a(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.apm.di.a.v()
            r2 = 0
            if (r1 == 0) goto L_0x0120
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.String r6 = "session_id = ?"
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            r7[r3] = r13
            java.lang.String r4 = "apm_session_meta_data"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r13 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00e2, all -> 0x00e0 }
            if (r13 != 0) goto L_0x0029
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r1
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00e2, all -> 0x00e0 }
            goto L_0x0030
        L_0x0029:
            r3 = r1
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x00e2, all -> 0x00e0 }
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00e2, all -> 0x00e0 }
        L_0x0030:
            if (r13 == 0) goto L_0x00cd
            boolean r3 = r13.moveToNext()     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            if (r3 == 0) goto L_0x00cd
            com.instabug.apm.cache.model.g r3 = new com.instabug.apm.cache.model.g     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.<init>()     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "app_launch_total_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.d(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "traces_total_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.f(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "network_logs_total_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.k(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "ui_traces_total_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.m(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "app_launch_dropped_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.c(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "traces_dropped_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.e(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "network_logs_dropped_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.j(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "ui_traces_dropped_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.l(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "experiments_total_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.g(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "fragment_spans_total_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.i(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            java.lang.String r4 = "fragment_spans_dropped_count"
            int r4 = r13.getColumnIndex(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            int r4 = r13.getInt(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            r3.h(r4)     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            goto L_0x00ce
        L_0x00cd:
            r3 = r2
        L_0x00ce:
            r1.close()     // Catch:{ Exception -> 0x00db, all -> 0x00d7 }
            if (r13 == 0) goto L_0x00d6
            r13.close()
        L_0x00d6:
            return r3
        L_0x00d7:
            r0 = move-exception
            r2 = r13
            r13 = r0
            goto L_0x011a
        L_0x00db:
            r1 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x00e4
        L_0x00e0:
            r13 = move-exception
            goto L_0x011a
        L_0x00e2:
            r13 = move-exception
            r1 = r2
        L_0x00e4:
            com.instabug.apm.logger.internal.a r3 = r12.f45157b     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r4.<init>()     // Catch:{ all -> 0x0118 }
            r4.append(r0)     // Catch:{ all -> 0x0118 }
            java.lang.String r5 = r13.getMessage()     // Catch:{ all -> 0x0118 }
            r4.append(r5)     // Catch:{ all -> 0x0118 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0118 }
            r3.a(r4, r13)     // Catch:{ all -> 0x0118 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0118 }
            r3.<init>()     // Catch:{ all -> 0x0118 }
            r3.append(r0)     // Catch:{ all -> 0x0118 }
            java.lang.String r0 = r13.getMessage()     // Catch:{ all -> 0x0118 }
            r3.append(r0)     // Catch:{ all -> 0x0118 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0118 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r13, r0)     // Catch:{ all -> 0x0118 }
            if (r1 == 0) goto L_0x0120
            r1.close()
            goto L_0x0120
        L_0x0118:
            r13 = move-exception
            r2 = r1
        L_0x011a:
            if (r2 == 0) goto L_0x011f
            r2.close()
        L_0x011f:
            throw r13
        L_0x0120:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.session.g.a(java.lang.String):com.instabug.apm.cache.model.g");
    }

    public void a() {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_UI_TRACES_TOTAL_COUNT, 0);
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_UI_TRACES_DROPPED_COUNT, 0);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                }
                openDatabase.close();
            }
        }
    }

    public void a(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_UI_TRACES_TOTAL_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void b() {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_EXECUTION_TRACES_TOTAL_COUNT, 0);
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_EXECUTION_TRACES_DROPPED_COUNT, 0);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                }
                openDatabase.close();
            }
        }
    }

    public void b(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_EXECUTION_TRACES_DROPPED_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void c() {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_NETWORK_LOGS_TOTAL_COUNT, 0);
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_NETWORK_LOGS_DROPPED_COUNT, 0);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                }
                openDatabase.close();
            }
        }
    }

    public void c(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_APP_LAUNCH_TOTAL_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void d() {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_FRAGMENT_SPANS_COUNT, 0);
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_FRAGMENT_SPANS_DROPPED_COUNT, 0);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                }
            }
        }
    }

    public void d(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_NETWORK_LOGS_TOTAL_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void e() {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_EXPERIMENTS_COUNT, 0);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                }
            }
        }
    }

    public void e(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_FRAGMENT_SPANS_DROPPED_COUNT, i11);
            }
        }
    }

    public void f() {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_APP_LAUNCH_TOTAL_COUNT, 0);
                contentValues.put(InstabugDbContract.APMSessionMetaDataEntry.COLUMN_APP_LAUNCH_DROPPED_COUNT, 0);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, contentValues, (String) null, (String[]) null);
                }
                openDatabase.close();
            }
        }
    }

    public void f(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_FRAGMENT_SPANS_COUNT, i11);
            }
        }
    }

    public void g(String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_UI_TRACES_DROPPED_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void h(@NonNull String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_EXECUTION_TRACES_TOTAL_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void i(String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str);
                b(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_EXPERIMENTS_COUNT, i11);
            }
        }
    }

    public void j(String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_APP_LAUNCH_DROPPED_COUNT, i11);
                openDatabase.close();
            }
        }
    }

    public void k(String str, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            synchronized (this.f45156a) {
                SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
                a(openDatabase, str, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_NETWORK_LOGS_DROPPED_COUNT, i11);
                openDatabase.close();
            }
        }
    }
}
