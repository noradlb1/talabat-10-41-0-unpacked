package com.instabug.apm.cache.handler.networklog;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.apm.di.a;
import com.instabug.apm.model.APMNetworkLog;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Map;

@Instrumented
@WorkerThread
public class d implements c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private DatabaseManager f45140a = a.v();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.logger.internal.a f45141b = a.f();

    private void a(long j11, String str) {
        if (this.f45140a != null) {
            String str2 = "delete from apm_network_traces_attributes where trace_id = " + j11 + " and " + "attribute_key" + " = \"" + str + "\"";
            SQLiteDatabaseWrapper openDatabase = this.f45140a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(str2);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, str2);
            }
        }
    }

    private void a(long j11, @NonNull String str, @NonNull String str2) {
        if (this.f45140a != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trace_id", Long.valueOf(j11));
            contentValues.put("attribute_key", str);
            if (str2 != null) {
                contentValues.put("attribute_value", str2);
            }
            SQLiteDatabaseWrapper openDatabase = this.f45140a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.insert(InstabugDbContract.NetworkTracesAttributesEntry.TABLE_NAME, (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.NetworkTracesAttributesEntry.TABLE_NAME, (String) null, contentValues);
            }
        }
    }

    private ContentValues b(APMNetworkLog aPMNetworkLog) {
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
        if (aPMNetworkLog.getRequestContentType() != null) {
            contentValues.put("request_content_type", aPMNetworkLog.getRequestContentType());
        }
        if (aPMNetworkLog.getResponseContentType() != null) {
            contentValues.put("response_content_type", aPMNetworkLog.getResponseContentType());
        }
        if (aPMNetworkLog.getErrorMessage() != null) {
            contentValues.put("error_message", aPMNetworkLog.getErrorMessage());
        }
        if (aPMNetworkLog.getRadio() != null) {
            contentValues.put("radio", aPMNetworkLog.getRadio());
        }
        if (aPMNetworkLog.getCarrier() != null) {
            contentValues.put("carrier", aPMNetworkLog.getCarrier());
        }
        String graphQlQueryName = aPMNetworkLog.getGraphQlQueryName();
        if (graphQlQueryName != null) {
            contentValues.put("graph_ql_query_name", graphQlQueryName);
        }
        String grpcMethodName = aPMNetworkLog.getGrpcMethodName();
        if (grpcMethodName != null) {
            contentValues.put("grpc_method_name", grpcMethodName);
        }
        String serverSideErrorMessage = aPMNetworkLog.getServerSideErrorMessage();
        if (serverSideErrorMessage != null) {
            contentValues.put("server_side_error_message", serverSideErrorMessage);
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
        contentValues.put("executed_on_background", Integer.valueOf(aPMNetworkLog.executedInBackground() ? 1 : 0));
        return contentValues;
    }

    private void b(long j11, String str, String str2) {
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("attribute_value", str2);
            String[] strArr = {j11 + "", str};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.NetworkTracesAttributesEntry.TABLE_NAME, contentValues, "trace_id = ? AND attribute_key= ?", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.NetworkTracesAttributesEntry.TABLE_NAME, contentValues, "trace_id = ? AND attribute_key= ?", strArr);
            }
        }
    }

    public int a(String str, long j11) {
        if (this.f45140a == null) {
            return -1;
        }
        String str2 = "session_id = ? AND log_id NOT IN (" + "SELECT log_id FROM apm_network_log where session_id = ? ORDER BY log_id DESC LIMIT ?" + ")";
        String[] strArr = {str, str, String.valueOf(j11)};
        SQLiteDatabaseWrapper openDatabase = this.f45140a.openDatabase();
        int delete = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.delete(InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, str2, strArr) : SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, str2, strArr);
        openDatabase.close();
        return delete;
    }

    public long a(String str, APMNetworkLog aPMNetworkLog) {
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager == null) {
            return -1;
        }
        SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
        ContentValues b11 = b(aPMNetworkLog);
        b11.put("session_id", str);
        long insert = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, (String) null, b11) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, (String) null, b11);
        openDatabase.close();
        return insert;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v10, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0177, code lost:
        if (r5 != null) goto L_0x019f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01a5  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.instabug.apm.cache.model.a a(android.database.Cursor r5) {
        /*
            r4 = this;
            com.instabug.apm.cache.model.a r0 = new com.instabug.apm.cache.model.a
            r0.<init>()
            java.lang.String r1 = "log_id"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            long r1 = (long) r1
            r0.a((long) r1)
            java.lang.String r1 = "method"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.e(r1)
            java.lang.String r1 = "carrier"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.a((java.lang.String) r1)
            java.lang.String r1 = "error_message"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.b((java.lang.String) r1)
            java.lang.String r1 = "radio"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.f(r1)
            java.lang.String r1 = "request_body_size"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            long r1 = (long) r1
            r0.b((long) r1)
            java.lang.String r1 = "request_content_type"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.g(r1)
            java.lang.String r1 = "request_headers"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.h(r1)
            java.lang.String r1 = "response_body_size"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            long r1 = (long) r1
            r0.c((long) r1)
            java.lang.String r1 = "response_code"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            r0.b((int) r1)
            java.lang.String r1 = "client_side_error_code"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            r0.a((int) r1)
            java.lang.String r1 = "response_content_type"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.i(r1)
            java.lang.String r1 = "response_headers"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.j(r1)
            java.lang.String r1 = "start_time"
            int r1 = r5.getColumnIndex(r1)
            long r1 = r5.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.a((java.lang.Long) r1)
            java.lang.String r1 = "duration"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            long r1 = (long) r1
            r0.d((long) r1)
            java.lang.String r1 = "url"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.l(r1)
            java.lang.String r1 = "executed_on_background"
            int r1 = r5.getColumnIndex(r1)
            int r1 = r5.getInt(r1)
            r2 = 1
            if (r1 != r2) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r2 = 0
        L_0x00ec:
            r0.a((boolean) r2)
            java.lang.String r1 = "graph_ql_query_name"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.c((java.lang.String) r1)
            java.lang.String r1 = "grpc_method_name"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r1 = r5.getString(r1)
            r0.d((java.lang.String) r1)
            java.lang.String r1 = "server_side_error_message"
            int r1 = r5.getColumnIndex(r1)
            java.lang.String r5 = r5.getString(r1)
            r0.k(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "select* from apm_network_traces_attributes where trace_id = "
            r5.append(r1)
            long r1 = r0.g()
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r4.f45140a
            if (r1 == 0) goto L_0x01a9
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            r2 = 0
            boolean r3 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ RuntimeException -> 0x017c }
            if (r3 != 0) goto L_0x013d
            android.database.Cursor r5 = r1.rawQuery(r5, r2)     // Catch:{ RuntimeException -> 0x017c }
            goto L_0x0143
        L_0x013d:
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ RuntimeException -> 0x017c }
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r1, r5, r2)     // Catch:{ RuntimeException -> 0x017c }
        L_0x0143:
            if (r5 == 0) goto L_0x0177
        L_0x0145:
            boolean r1 = r5.moveToNext()     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            if (r1 == 0) goto L_0x016b
            if (r2 != 0) goto L_0x0153
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            r1.<init>()     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            r2 = r1
        L_0x0153:
            java.lang.String r1 = "attribute_key"
            int r1 = r5.getColumnIndex(r1)     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            java.lang.String r1 = r5.getString(r1)     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            java.lang.String r3 = "attribute_value"
            int r3 = r5.getColumnIndex(r3)     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            r2.put(r1, r3)     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            goto L_0x0145
        L_0x016b:
            r0.a((java.util.Map) r2)     // Catch:{ RuntimeException -> 0x0173, all -> 0x016f }
            goto L_0x0177
        L_0x016f:
            r0 = move-exception
            r2 = r5
            r5 = r0
            goto L_0x01a3
        L_0x0173:
            r1 = move-exception
            r2 = r5
            r5 = r1
            goto L_0x017d
        L_0x0177:
            if (r5 == 0) goto L_0x01a9
            goto L_0x019f
        L_0x017a:
            r5 = move-exception
            goto L_0x01a3
        L_0x017c:
            r5 = move-exception
        L_0x017d:
            com.instabug.apm.logger.internal.a r1 = r4.f45141b     // Catch:{ all -> 0x017a }
            java.lang.String r3 = "Failed to read attributes of a trace"
            r1.a(r3, r5)     // Catch:{ all -> 0x017a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            r1.<init>()     // Catch:{ all -> 0x017a }
            java.lang.String r3 = "DB execution a sql failed: "
            r1.append(r3)     // Catch:{ all -> 0x017a }
            java.lang.String r3 = r5.getMessage()     // Catch:{ all -> 0x017a }
            r1.append(r3)     // Catch:{ all -> 0x017a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017a }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r5, r1)     // Catch:{ all -> 0x017a }
            if (r2 == 0) goto L_0x01a9
            r5 = r2
        L_0x019f:
            r5.close()
            goto L_0x01a9
        L_0x01a3:
            if (r2 == 0) goto L_0x01a8
            r2.close()
        L_0x01a8:
            throw r5
        L_0x01a9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.networklog.d.a(android.database.Cursor):com.instabug.apm.cache.model.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0098  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r13.f45140a
            r2 = 0
            if (r1 == 0) goto L_0x009c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = r13.f45140a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r3 = r3.openDatabase()
            java.lang.String r7 = "session_id = ? AND duration > ?"
            r4 = 2
            java.lang.String[] r8 = new java.lang.String[r4]
            r4 = 0
            r8[r4] = r14
            r14 = 1
            java.lang.String r4 = "0"
            r8[r14] = r4
            java.lang.String r5 = "apm_network_log"
            r6 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            boolean r14 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            if (r14 != 0) goto L_0x0033
            r6 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            android.database.Cursor r14 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            goto L_0x003a
        L_0x0033:
            r4 = r3
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            android.database.Cursor r14 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
        L_0x003a:
            if (r14 == 0) goto L_0x0053
        L_0x003c:
            boolean r4 = r14.moveToNext()     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            if (r4 == 0) goto L_0x0053
            com.instabug.apm.cache.model.a r4 = r13.a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            r1.add(r4)     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            goto L_0x003c
        L_0x004a:
            r0 = move-exception
            r2 = r14
            r14 = r0
            goto L_0x0096
        L_0x004e:
            r1 = move-exception
            r12 = r1
            r1 = r14
            r14 = r12
            goto L_0x0060
        L_0x0053:
            r3.close()     // Catch:{ Exception -> 0x004e, all -> 0x004a }
            if (r14 == 0) goto L_0x005b
            r14.close()
        L_0x005b:
            return r1
        L_0x005c:
            r14 = move-exception
            goto L_0x0096
        L_0x005e:
            r14 = move-exception
            r1 = r2
        L_0x0060:
            com.instabug.apm.logger.internal.a r3 = r13.f45141b     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r4.<init>()     // Catch:{ all -> 0x0094 }
            r4.append(r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r5 = r14.getMessage()     // Catch:{ all -> 0x0094 }
            r4.append(r5)     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0094 }
            r3.a(r4, r14)     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r3.<init>()     // Catch:{ all -> 0x0094 }
            r3.append(r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r14.getMessage()     // Catch:{ all -> 0x0094 }
            r3.append(r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0094 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r14, r0)     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x009c
            r1.close()
            goto L_0x009c
        L_0x0094:
            r14 = move-exception
            r2 = r1
        L_0x0096:
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            throw r14
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.networklog.d.a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0065, code lost:
        if (r10 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008a, code lost:
        if (r10 == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008c, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008f, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map a(long r10) {
        /*
            r9 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = r9.f45140a
            if (r0 == 0) goto L_0x0096
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.lang.String r4 = "trace_id = ?"
            r1 = 1
            java.lang.String[] r5 = new java.lang.String[r1]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r10 = ""
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r11 = 0
            r5[r11] = r10
            com.instabug.library.internal.storage.cache.db.DatabaseManager r10 = r9.f45140a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r10.openDatabase()
            r10 = 0
            java.lang.String r2 = "apm_network_traces_attributes"
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            boolean r11 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ RuntimeException -> 0x006a }
            if (r11 != 0) goto L_0x003c
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x006a }
            goto L_0x0042
        L_0x003c:
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ RuntimeException -> 0x006a }
            android.database.Cursor r10 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x006a }
        L_0x0042:
            if (r10 == 0) goto L_0x0065
        L_0x0044:
            boolean r11 = r10.moveToNext()     // Catch:{ RuntimeException -> 0x006a }
            if (r11 == 0) goto L_0x0062
            java.lang.String r11 = "attribute_key"
            int r11 = r10.getColumnIndex(r11)     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r1 = "attribute_value"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ RuntimeException -> 0x006a }
            r0.put(r11, r1)     // Catch:{ RuntimeException -> 0x006a }
            goto L_0x0044
        L_0x0062:
            r10.close()     // Catch:{ RuntimeException -> 0x006a }
        L_0x0065:
            if (r10 == 0) goto L_0x008f
            goto L_0x008c
        L_0x0068:
            r11 = move-exception
            goto L_0x0090
        L_0x006a:
            r11 = move-exception
            com.instabug.apm.logger.internal.a r1 = r9.f45141b     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = "Failed to get attributes"
            r1.a(r2, r11)     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r1.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = "DB execution a sql failed: "
            r1.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r11.getMessage()     // Catch:{ all -> 0x0068 }
            r1.append(r2)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0068 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r11, r1)     // Catch:{ all -> 0x0068 }
            if (r10 == 0) goto L_0x008f
        L_0x008c:
            r10.close()
        L_0x008f:
            return r0
        L_0x0090:
            if (r10 == 0) goto L_0x0095
            r10.close()
        L_0x0095:
            throw r11
        L_0x0096:
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.networklog.d.a(long):java.util.Map");
    }

    public void a() {
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from apm_network_log");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from apm_network_log");
            }
            openDatabase.close();
        }
    }

    @SuppressLint({"RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE"})
    public void a(long j11, @NonNull String str, @NonNull String str2, @Nullable String str3) {
        if (str3 == null) {
            a(j11, str2);
            return;
        }
        Map a11 = a(j11);
        if (a11 == null || a11.get(str2) == null) {
            int I = a.c().I();
            if (a11 == null || a11.size() != I) {
                a(j11, str2, str3);
                return;
            }
            String replace = "Trace attribute \"$s1\" wasn't added to \"$s2\". Max allowed trace attributes reached. Please note that you can add up to \"$s3\" attributes to the same trace.".replace("$s1", str2).replace("$s2", str);
            this.f45141b.e(replace.replace("$s3", I + ""));
            return;
        }
        b(j11, str2, str3);
    }

    public void a(long j11, String str, @Nullable Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a(j11, str, (String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public void a(APMNetworkLog aPMNetworkLog) {
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            ContentValues b11 = b(aPMNetworkLog);
            String[] strArr = {String.valueOf(aPMNetworkLog.getId())};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, b11, "log_id = ?", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, b11, "log_id = ?", strArr);
            }
            openDatabase.close();
        }
    }

    public void b() {
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from apm_network_log where response_code = 0 and grpc_method_name is NULL and error_message is NULL");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from apm_network_log where response_code = 0 and grpc_method_name is NULL and error_message is NULL");
            }
            openDatabase.close();
        }
    }

    public void b(long j11) {
        if (this.f45140a != null) {
            String str = "delete from apm_network_log where log_id not in ( select log_id from apm_network_log order by log_id desc limit " + j11 + " )";
            SQLiteDatabaseWrapper openDatabase = this.f45140a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, str);
            }
            openDatabase.close();
        }
    }

    public void d() {
        SQLiteDatabaseWrapper openDatabase;
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager != null && (openDatabase = databaseManager.openDatabase()) != null) {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("UPDATE apm_network_log SET graph_ql_query_name = NULL,server_side_error_message = NULL WHERE graph_ql_query_name IS NOT NULL");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "UPDATE apm_network_log SET graph_ql_query_name = NULL,server_side_error_message = NULL WHERE graph_ql_query_name IS NOT NULL");
            }
            openDatabase.close();
        }
    }

    public void e() {
        SQLiteDatabaseWrapper openDatabase;
        DatabaseManager databaseManager = this.f45140a;
        if (databaseManager != null && (openDatabase = databaseManager.openDatabase()) != null) {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, "grpc_method_name IS NOT NULL", (String[]) null);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMNetworkLogEntry.TABLE_NAME, "grpc_method_name IS NOT NULL", (String[]) null);
            }
            openDatabase.close();
        }
    }
}
