package com.instabug.library.logging;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.NetworkLog;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryGuard;
import com.instabug.library.util.memory.predicate.StringMemoryAvailablePredicate;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public abstract class d {
    private static long a() {
        return 2000000;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized long a(NetworkLog networkLog) {
        synchronized (d.class) {
            InstabugSDKLogger.d("IBG-Core", "inserting network log");
            SQLiteDatabaseWrapper databaseWrapper = CoreServiceLocator.getDatabaseWrapper();
            if (databaseWrapper == null) {
                return -1;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", networkLog.getUrl());
                contentValues.put("request", networkLog.getRequest());
                contentValues.put("method", networkLog.getMethod());
                contentValues.put("response", networkLog.getResponse());
                contentValues.put("status", "" + networkLog.getResponseCode());
                contentValues.put("date", networkLog.getDate());
                contentValues.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, networkLog.getRequestHeaders());
                contentValues.put("response_headers", networkLog.getResponseHeaders());
                contentValues.put(InstabugDbContract.NetworkLogEntry.COLUMN_NETWORK_TIME, Long.valueOf(networkLog.getTotalDuration()));
                contentValues.put(InstabugDbContract.NetworkLogEntry.COLUMN_USER_MODIFIED, Boolean.valueOf(networkLog.isUserModified()));
                long insert = !(databaseWrapper instanceof SQLiteDatabase) ? databaseWrapper.insert(InstabugDbContract.NetworkLogEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) databaseWrapper, InstabugDbContract.NetworkLogEntry.TABLE_NAME, (String) null, contentValues);
                databaseWrapper.close();
                return insert;
            } catch (Exception e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "Error while inserting network logs to DB: " + e11.getMessage(), "IBG-Core");
                    return -1;
                } finally {
                    databaseWrapper.close();
                }
            }
        }
    }

    public static synchronized void b() {
        synchronized (d.class) {
            InstabugSDKLogger.d("IBG-Core", "trimming network log");
            SQLiteDatabaseWrapper databaseWrapper = CoreServiceLocator.getDatabaseWrapper();
            if (databaseWrapper != null) {
                try {
                    if (databaseWrapper.queryNumEntries(InstabugDbContract.NetworkLogEntry.TABLE_NAME) > 100) {
                        if (!(databaseWrapper instanceof SQLiteDatabase)) {
                            databaseWrapper.execSQL(InstabugDbContract.NetworkLogEntry.DELETE_ALL_EXCEPT_THE_LATEST_100_ENTRY);
                        } else {
                            SQLiteInstrumentation.execSQL((SQLiteDatabase) databaseWrapper, InstabugDbContract.NetworkLogEntry.DELETE_ALL_EXCEPT_THE_LATEST_100_ENTRY);
                        }
                    }
                    databaseWrapper.close();
                } catch (SQLiteFullException e11) {
                    try {
                        if (!(databaseWrapper instanceof SQLiteDatabase)) {
                            databaseWrapper.execSQL(InstabugDbContract.NetworkLogEntry.SQL_DELETE_ENTRIES);
                        } else {
                            SQLiteInstrumentation.execSQL((SQLiteDatabase) databaseWrapper, InstabugDbContract.NetworkLogEntry.SQL_DELETE_ENTRIES);
                        }
                        if (!(databaseWrapper instanceof SQLiteDatabase)) {
                            databaseWrapper.execSQL(InstabugDbContract.NetworkLogEntry.SQL_CREATE_NETWORK_LOGS);
                        } else {
                            SQLiteInstrumentation.execSQL((SQLiteDatabase) databaseWrapper, InstabugDbContract.NetworkLogEntry.SQL_CREATE_NETWORK_LOGS);
                        }
                        InstabugSDKLogger.e("IBG-Core", "Trimming network logs got error", e11);
                    } finally {
                        databaseWrapper.close();
                    }
                }
            }
        }
    }

    @Nullable
    public static synchronized String a(MemoryGuard memoryGuard, float f11) {
        String str;
        synchronized (d.class) {
            String[] strArr = {null};
            memoryGuard.withPredicate(new StringMemoryAvailablePredicate(a())).forOperation("retrieving network logs").doAction(new c(strArr, f11));
            str = strArr[0];
        }
        return str;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0110, code lost:
        if (r13 == null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0148, code lost:
        if (r13 == null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x014d, code lost:
        r1.close();
        r14 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0155, code lost:
        return r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(float r14) {
        /*
            java.lang.Class<com.instabug.library.logging.d> r0 = com.instabug.library.logging.d.class
            monitor-enter(r0)
            java.lang.String r1 = "IBG-Core"
            java.lang.String r2 = "retrieveNetworkLogs"
            com.instabug.library.util.InstabugSDKLogger.d(r1, r2)     // Catch:{ all -> 0x015f }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getDatabaseWrapper()     // Catch:{ all -> 0x015f }
            r2 = 1120403456(0x42c80000, float:100.0)
            float r14 = r14 * r2
            int r14 = java.lang.Math.round(r14)     // Catch:{ all -> 0x015f }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x015f }
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ all -> 0x015f }
            r12.<init>()     // Catch:{ all -> 0x015f }
            if (r1 != 0) goto L_0x0026
            java.lang.String r14 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r12)     // Catch:{ all -> 0x015f }
            monitor-exit(r0)
            return r14
        L_0x0026:
            r13 = 0
            java.lang.String r4 = "network_logs"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "_id DESC"
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0115 }
            if (r2 != 0) goto L_0x0040
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r1
            r11 = r14
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0115 }
            goto L_0x004f
        L_0x0040:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0115 }
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r14
            android.database.Cursor r14 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0115 }
        L_0x004f:
            r13 = r14
            if (r13 == 0) goto L_0x0110
            boolean r14 = r13.moveToFirst()     // Catch:{ Exception -> 0x0115 }
            if (r14 == 0) goto L_0x0110
        L_0x0058:
            com.instabug.library.model.NetworkLog r14 = new com.instabug.library.model.NetworkLog     // Catch:{ Exception -> 0x0115 }
            r14.<init>()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "request"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            byte[] r3 = r13.getBlob(r2)     // Catch:{ Exception -> 0x0115 }
            if (r3 == 0) goto L_0x0070
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setRequest(r2)     // Catch:{ Exception -> 0x0115 }
        L_0x0070:
            java.lang.String r2 = "response"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            byte[] r3 = r13.getBlob(r2)     // Catch:{ Exception -> 0x0115 }
            if (r3 == 0) goto L_0x0083
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setResponse(r2)     // Catch:{ Exception -> 0x0115 }
        L_0x0083:
            java.lang.String r2 = "method"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setMethod(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "url"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setUrl(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "status"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            int r2 = r13.getInt(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setResponseCode(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "date"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setDate(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "headers"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setRequestHeaders(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "response_headers"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x0115 }
            r14.setResponseHeaders(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "response_time"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            int r2 = r13.getInt(r2)     // Catch:{ Exception -> 0x0115 }
            long r2 = (long) r2     // Catch:{ Exception -> 0x0115 }
            r14.setTotalDuration(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "user_modified"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x0115 }
            int r2 = r13.getInt(r2)     // Catch:{ Exception -> 0x0115 }
            r3 = 1
            if (r2 != r3) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            r14.setUserModified(r3)     // Catch:{ Exception -> 0x0115 }
            org.json.JSONObject r14 = r14.toJsonObject()     // Catch:{ Exception -> 0x00fc }
            r12.put((java.lang.Object) r14)     // Catch:{ Exception -> 0x00fc }
            goto L_0x010a
        L_0x00fc:
            r14 = move-exception
            java.lang.String r2 = r14.getMessage()     // Catch:{ Exception -> 0x0115 }
            if (r2 == 0) goto L_0x010a
            java.lang.String r2 = "IBG-Core"
            java.lang.String r3 = "Error while retireving network logs"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r14)     // Catch:{ Exception -> 0x0115 }
        L_0x010a:
            boolean r14 = r13.moveToNext()     // Catch:{ Exception -> 0x0115 }
            if (r14 != 0) goto L_0x0058
        L_0x0110:
            if (r13 == 0) goto L_0x014d
            goto L_0x014a
        L_0x0113:
            r14 = move-exception
            goto L_0x0156
        L_0x0115:
            r14 = move-exception
            java.lang.String r2 = "IBG-Core"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r3.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = "Failed to get NetworkLogs type due to: "
            r3.append(r4)     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = r14.getMessage()     // Catch:{ all -> 0x0113 }
            r3.append(r4)     // Catch:{ all -> 0x0113 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0113 }
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r14)     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r2.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r3 = "Failed to get NetworkLogs type due to: "
            r2.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r3 = r14.getMessage()     // Catch:{ all -> 0x0113 }
            r2.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0113 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r14, r2)     // Catch:{ all -> 0x0113 }
            if (r13 == 0) goto L_0x014d
        L_0x014a:
            r13.close()     // Catch:{ all -> 0x015f }
        L_0x014d:
            r1.close()     // Catch:{ all -> 0x015f }
            java.lang.String r14 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r12)     // Catch:{ all -> 0x015f }
            monitor-exit(r0)
            return r14
        L_0x0156:
            if (r13 == 0) goto L_0x015b
            r13.close()     // Catch:{ all -> 0x015f }
        L_0x015b:
            r1.close()     // Catch:{ all -> 0x015f }
            throw r14     // Catch:{ all -> 0x015f }
        L_0x015f:
            r14 = move-exception
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.d.a(float):java.lang.String");
    }
}
