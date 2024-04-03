package com.instabug.apm.cache.handler.networklog;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.apm.logger.internal.a;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Map;

@Instrumented
@WorkerThread
public class b implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f45138a;

    /* renamed from: b  reason: collision with root package name */
    private final a f45139b = com.instabug.apm.di.a.f();

    public b(@Nullable DatabaseManager databaseManager) {
        this.f45138a = databaseManager;
    }

    private void a(long j11, String str) {
        if (this.f45138a != null) {
            String str2 = "delete from dangling_apm_network_traces_attributes where trace_id = " + j11 + " and " + "attribute_key" + " = \"" + str + "\"";
            SQLiteDatabaseWrapper openDatabase = this.f45138a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(str2);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, str2);
            }
        }
    }

    private void a(long j11, @NonNull String str, @NonNull String str2) {
        if (this.f45138a != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trace_id", Long.valueOf(j11));
            contentValues.put("attribute_key", str);
            if (str2 != null) {
                contentValues.put("attribute_value", str2);
            }
            SQLiteDatabaseWrapper openDatabase = this.f45138a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.insert(InstabugDbContract.DanglingNetworkTracesAttributesEntry.TABLE_NAME, (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.DanglingNetworkTracesAttributesEntry.TABLE_NAME, (String) null, contentValues);
            }
        }
    }

    private void b(long j11, String str, String str2) {
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("attribute_value", str2);
            String[] strArr = {j11 + "", str};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.DanglingNetworkTracesAttributesEntry.TABLE_NAME, contentValues, "trace_id = ? AND attribute_key= ?", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.DanglingNetworkTracesAttributesEntry.TABLE_NAME, contentValues, "trace_id = ? AND attribute_key= ?", strArr);
            }
        }
    }

    private ContentValues c(APMNetworkLog aPMNetworkLog) {
        ContentValues contentValues = new ContentValues();
        if (aPMNetworkLog.getStartTime() != null) {
            contentValues.put("start_time", aPMNetworkLog.getStartTime());
        }
        if (aPMNetworkLog.getUrl() != null) {
            contentValues.put("url", aPMNetworkLog.getUrl());
        }
        if (aPMNetworkLog.getMethod() != null) {
            contentValues.put("method", aPMNetworkLog.getMethod());
        }
        if (aPMNetworkLog.getRequestHeaders() != null) {
            contentValues.put("request_headers", aPMNetworkLog.getRequestHeaders());
        }
        if (aPMNetworkLog.getRequestContentType() != null) {
            contentValues.put("request_content_type", aPMNetworkLog.getRequestContentType());
        }
        if (aPMNetworkLog.getResponseHeaders() != null) {
            contentValues.put("response_headers", aPMNetworkLog.getResponseHeaders());
        }
        if (aPMNetworkLog.getResponseContentType() != null) {
            contentValues.put("response_content_type", aPMNetworkLog.getResponseContentType());
        }
        String graphQlQueryName = aPMNetworkLog.getGraphQlQueryName();
        if (graphQlQueryName != null) {
            contentValues.put("graph_ql_query_name", graphQlQueryName);
        }
        String serverSideErrorMessage = aPMNetworkLog.getServerSideErrorMessage();
        if (serverSideErrorMessage != null) {
            contentValues.put("server_side_error_message", serverSideErrorMessage);
        }
        String grpcMethodName = aPMNetworkLog.getGrpcMethodName();
        if (grpcMethodName != null) {
            contentValues.put("grpc_method_name", grpcMethodName);
        }
        contentValues.put("duration", Long.valueOf(aPMNetworkLog.getTotalDuration()));
        contentValues.put("response_code", Integer.valueOf(aPMNetworkLog.getResponseCode()));
        contentValues.put("client_side_error_code", Integer.valueOf(aPMNetworkLog.getClientErrorCode()));
        contentValues.put("request_body_size", Long.valueOf(aPMNetworkLog.getRequestBodySize()));
        contentValues.put("response_body_size", Long.valueOf(aPMNetworkLog.getResponseBodySize()));
        if (aPMNetworkLog.getErrorMessage() != null) {
            contentValues.put("error_message", aPMNetworkLog.getErrorMessage());
        }
        if (aPMNetworkLog.getRadio() != null) {
            contentValues.put("radio", aPMNetworkLog.getRadio());
        }
        if (aPMNetworkLog.getCarrier() != null) {
            contentValues.put("carrier", aPMNetworkLog.getCarrier());
        }
        contentValues.put("executed_on_background", Boolean.valueOf(aPMNetworkLog.executedInBackground()));
        return contentValues;
    }

    @VisibleForTesting
    public APMNetworkLog a(Cursor cursor) {
        APMNetworkLog aPMNetworkLog = new APMNetworkLog();
        aPMNetworkLog.setId((long) cursor.getInt(cursor.getColumnIndex("log_id")));
        aPMNetworkLog.setMethod(cursor.getString(cursor.getColumnIndex("method")));
        aPMNetworkLog.setCarrier(cursor.getString(cursor.getColumnIndex("carrier")));
        aPMNetworkLog.setErrorMessage(cursor.getString(cursor.getColumnIndex("error_message")));
        aPMNetworkLog.setRadio(cursor.getString(cursor.getColumnIndex("radio")));
        aPMNetworkLog.setRequestBodySize((long) cursor.getInt(cursor.getColumnIndex("request_body_size")));
        aPMNetworkLog.setRequestContentType(cursor.getString(cursor.getColumnIndex("request_content_type")));
        aPMNetworkLog.setRequestHeaders(cursor.getString(cursor.getColumnIndex("request_headers")));
        aPMNetworkLog.setResponseBodySize((long) cursor.getInt(cursor.getColumnIndex("response_body_size")));
        aPMNetworkLog.setResponseCode(cursor.getInt(cursor.getColumnIndex("response_code")));
        aPMNetworkLog.setClientErrorCode(cursor.getInt(cursor.getColumnIndex("client_side_error_code")));
        aPMNetworkLog.setResponseContentType(cursor.getString(cursor.getColumnIndex("response_content_type")));
        aPMNetworkLog.setResponseHeaders(cursor.getString(cursor.getColumnIndex("response_headers")));
        aPMNetworkLog.setStartTime(Long.valueOf(cursor.getLong(cursor.getColumnIndex("start_time"))));
        aPMNetworkLog.setTotalDuration((long) cursor.getInt(cursor.getColumnIndex("duration")));
        aPMNetworkLog.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        boolean z11 = true;
        if (cursor.getInt(cursor.getColumnIndex("executed_on_background")) != 1) {
            z11 = false;
        }
        aPMNetworkLog.setExecutedInBackground(z11);
        aPMNetworkLog.setGraphQlQueryName(cursor.getString(cursor.getColumnIndex("graph_ql_query_name")));
        aPMNetworkLog.setGrpcMethodName(cursor.getString(cursor.getColumnIndex("grpc_method_name")));
        aPMNetworkLog.setServerSideErrorMessage(cursor.getString(cursor.getColumnIndex("server_side_error_message")));
        return aPMNetworkLog;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.util.Map, android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        if (r1 != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        if (r1 == 0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a0, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map a(long r11) {
        /*
            r10 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = r10.f45138a
            r1 = 0
            if (r0 == 0) goto L_0x00aa
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.lang.String r5 = "trace_id = ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            java.lang.String r11 = ""
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r12 = 0
            r6[r12] = r11
            com.instabug.library.internal.storage.cache.db.DatabaseManager r11 = r10.f45138a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r2 = r11.openDatabase()
            java.lang.String r3 = "dangling_apm_network_traces_attributes"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r11 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ RuntimeException -> 0x006b }
            if (r11 != 0) goto L_0x003c
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ RuntimeException -> 0x006b }
            goto L_0x0042
        L_0x003c:
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ RuntimeException -> 0x006b }
            android.database.Cursor r11 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ RuntimeException -> 0x006b }
        L_0x0042:
            r1 = r11
            if (r1 == 0) goto L_0x0066
        L_0x0045:
            boolean r11 = r1.moveToNext()     // Catch:{ RuntimeException -> 0x006b }
            if (r11 == 0) goto L_0x0063
            java.lang.String r11 = "attribute_key"
            int r11 = r1.getColumnIndex(r11)     // Catch:{ RuntimeException -> 0x006b }
            java.lang.String r11 = r1.getString(r11)     // Catch:{ RuntimeException -> 0x006b }
            java.lang.String r12 = "attribute_value"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ RuntimeException -> 0x006b }
            java.lang.String r12 = r1.getString(r12)     // Catch:{ RuntimeException -> 0x006b }
            r0.put(r11, r12)     // Catch:{ RuntimeException -> 0x006b }
            goto L_0x0045
        L_0x0063:
            r1.close()     // Catch:{ RuntimeException -> 0x006b }
        L_0x0066:
            if (r1 == 0) goto L_0x00a3
            goto L_0x00a0
        L_0x0069:
            r11 = move-exception
            goto L_0x00a4
        L_0x006b:
            r11 = move-exception
            com.instabug.apm.logger.internal.a r12 = r10.f45139b     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r2.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = "Failed to get attributes: "
            r2.append(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r11.getMessage()     // Catch:{ all -> 0x0069 }
            r2.append(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0069 }
            r12.a(r2, r11)     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r12.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "Failed to get attributes due to: "
            r12.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r11.getMessage()     // Catch:{ all -> 0x0069 }
            r12.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0069 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r11, r12)     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x00a3
        L_0x00a0:
            r1.close()
        L_0x00a3:
            return r0
        L_0x00a4:
            if (r1 == 0) goto L_0x00a9
            r1.close()
        L_0x00a9:
            throw r11
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.networklog.b.a(long):java.util.Map");
    }

    public void a() {
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from dangling_apm_network_log");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from dangling_apm_network_log");
            }
            openDatabase.close();
        }
    }

    public void a(int i11) {
        if (this.f45138a != null) {
            String str = "delete from dangling_apm_network_log where log_id in (select log_id from dangling_apm_network_log limit " + i11 + ")";
            SQLiteDatabaseWrapper openDatabase = this.f45138a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, str);
            }
            openDatabase.close();
        }
    }

    public void a(long j11, @NonNull String str, @NonNull String str2, @Nullable String str3) {
        if (str3 == null) {
            a(j11, str2);
            return;
        }
        Map a11 = a(j11);
        if (a11 == null || a11.get(str2) == null) {
            int I = com.instabug.apm.di.a.c().I();
            if (a11 == null || a11.size() != I) {
                a(j11, str2, str3);
                return;
            }
            String replace = "Trace attribute \"$s1\" wasn't added to \"$s2\". Max allowed trace attributes reached. Please note that you can add up to \"$s3\" attributes to the same trace.".replace("$s1", str2).replace("$s2", str);
            this.f45139b.e(replace.replace("$s3", I + ""));
            return;
        }
        b(j11, str2, str3);
    }

    public void a(APMNetworkLog aPMNetworkLog) {
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            ContentValues c11 = c(aPMNetworkLog);
            String[] strArr = {String.valueOf(aPMNetworkLog.getId())};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.DanglingAPMNetworkLogEntry.TABLE_NAME, c11, "log_id = ?", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.DanglingAPMNetworkLogEntry.TABLE_NAME, c11, "log_id = ?", strArr);
            }
            openDatabase.close();
        }
    }

    public long b(APMNetworkLog aPMNetworkLog) {
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager == null) {
            return -1;
        }
        SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
        ContentValues c11 = c(aPMNetworkLog);
        long insert = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.DanglingAPMNetworkLogEntry.TABLE_NAME, (String) null, c11) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.DanglingAPMNetworkLogEntry.TABLE_NAME, (String) null, c11);
        openDatabase.close();
        return insert;
    }

    public void b() {
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from dangling_apm_network_log where response_code = 0 and error_message is NULL");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from dangling_apm_network_log where response_code = 0 and error_message is NULL");
            }
            openDatabase.close();
        }
    }

    public void b(long j11) {
        if (this.f45138a != null) {
            String str = "delete from dangling_apm_network_log where log_id not in ( select log_id from dangling_apm_network_log order by log_id desc limit " + j11 + " )";
            SQLiteDatabaseWrapper openDatabase = this.f45138a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, str);
            }
            openDatabase.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List c(long r7) {
        /*
            r6 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r6.f45138a
            r2 = 0
            if (r1 == 0) goto L_0x0095
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "select * from dangling_apm_network_log limit "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r8 = r6.f45138a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r8 = r8.openDatabase()
            boolean r3 = r8 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            if (r3 != 0) goto L_0x002c
            android.database.Cursor r7 = r8.rawQuery(r7, r2)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            goto L_0x0033
        L_0x002c:
            r3 = r8
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.database.Cursor r7 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r3, r7, r2)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
        L_0x0033:
            if (r7 == 0) goto L_0x004c
        L_0x0035:
            boolean r3 = r7.moveToNext()     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            if (r3 == 0) goto L_0x004c
            com.instabug.apm.model.APMNetworkLog r3 = r6.a((android.database.Cursor) r7)     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            r1.add(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            goto L_0x0035
        L_0x0043:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto L_0x008f
        L_0x0047:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0059
        L_0x004c:
            r8.close()     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            if (r7 == 0) goto L_0x0054
            r7.close()
        L_0x0054:
            return r1
        L_0x0055:
            r7 = move-exception
            goto L_0x008f
        L_0x0057:
            r7 = move-exception
            r8 = r2
        L_0x0059:
            com.instabug.apm.logger.internal.a r1 = r6.f45139b     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r3.<init>()     // Catch:{ all -> 0x008d }
            r3.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r4 = r7.getMessage()     // Catch:{ all -> 0x008d }
            r3.append(r4)     // Catch:{ all -> 0x008d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008d }
            r1.a(r3, r7)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r1.<init>()     // Catch:{ all -> 0x008d }
            r1.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r7.getMessage()     // Catch:{ all -> 0x008d }
            r1.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x008d }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r7, r0)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0095
            r8.close()
            goto L_0x0095
        L_0x008d:
            r7 = move-exception
            r2 = r8
        L_0x008f:
            if (r2 == 0) goto L_0x0094
            r2.close()
        L_0x0094:
            throw r7
        L_0x0095:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.networklog.b.c(long):java.util.List");
    }

    public void d() {
        SQLiteDatabaseWrapper openDatabase;
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager != null && (openDatabase = databaseManager.openDatabase()) != null) {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("UPDATE dangling_apm_network_log SET graph_ql_query_name = NULL,server_side_error_message = NULL WHERE graph_ql_query_name IS NOT NULL");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "UPDATE dangling_apm_network_log SET graph_ql_query_name = NULL,server_side_error_message = NULL WHERE graph_ql_query_name IS NOT NULL");
            }
            openDatabase.close();
        }
    }

    public void e() {
        SQLiteDatabaseWrapper openDatabase;
        DatabaseManager databaseManager = this.f45138a;
        if (databaseManager != null && (openDatabase = databaseManager.openDatabase()) != null) {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.DanglingAPMNetworkLogEntry.TABLE_NAME, "grpc_method_name IS NOT NULL", (String[]) null);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.DanglingAPMNetworkLogEntry.TABLE_NAME, "grpc_method_name IS NOT NULL", (String[]) null);
            }
            openDatabase.close();
        }
    }
}
