package com.tekartik.sqflite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.tekartik.sqflite.dev.Debug;
import com.tekartik.sqflite.operation.BatchOperation;
import com.tekartik.sqflite.operation.ExecuteOperation;
import com.tekartik.sqflite.operation.MethodCallOperation;
import com.tekartik.sqflite.operation.Operation;
import com.tekartik.sqflite.operation.SqlErrorInfo;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Instrumented
public class SqflitePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static boolean QUERY_AS_MAP_LIST = false;
    private static int THREAD_PRIORITY = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f12867b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static int f12868c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static String f12869d;
    /* access modifiers changed from: private */
    public static int databaseId = 0;
    /* access modifiers changed from: private */
    public static final Object databaseMapLocker = new Object();
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: e  reason: collision with root package name */
    public static final Map<Integer, Database> f12870e = new HashMap();
    private static Handler handler;
    private static HandlerThread handlerThread;
    /* access modifiers changed from: private */
    public static final Object openCloseLocker = new Object();
    private Context context;
    private MethodChannel methodChannel;

    public class BgResult implements MethodChannel.Result {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f12907a;
        /* access modifiers changed from: private */
        public final MethodChannel.Result result;

        public void error(final String str, final String str2, final Object obj) {
            this.f12907a.post(new Runnable() {
                public void run() {
                    BgResult.this.result.error(str, str2, obj);
                }
            });
        }

        public void notImplemented() {
            this.f12907a.post(new Runnable() {
                public void run() {
                    BgResult.this.result.notImplemented();
                }
            });
        }

        public void success(final Object obj) {
            this.f12907a.post(new Runnable() {
                public void run() {
                    BgResult.this.result.success(obj);
                }
            });
        }

        private BgResult(MethodChannel.Result result2) {
            this.f12907a = new Handler(Looper.getMainLooper());
            this.result = result2;
        }
    }

    public SqflitePlugin() {
    }

    /* access modifiers changed from: private */
    public void closeDatabase(Database database) {
        try {
            if (LogLevel.b(database.f12863d)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(database.b());
                sb2.append("closing database ");
                sb2.append(handlerThread);
            }
            database.close();
        } catch (Exception e11) {
            Log.e(Constant.TAG, "error " + e11 + " while closing database " + databaseId);
        }
        synchronized (databaseMapLocker) {
            if (f12870e.isEmpty() && handler != null) {
                if (LogLevel.b(database.f12863d)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(database.b());
                    sb3.append("stopping thread");
                    sb3.append(handlerThread);
                }
                handlerThread.quit();
                handlerThread = null;
                handler = null;
            }
        }
    }

    private static List<Object> cursorRowToList(Cursor cursor, int i11) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            Object cursorValue = cursorValue(cursor, i12);
            if (Debug.EXTRA_LOGV) {
                if (cursorValue == null) {
                    str = null;
                } else if (cursorValue.getClass().isArray()) {
                    str = "array(" + cursorValue.getClass().getComponentType().getName() + ")";
                } else {
                    str = cursorValue.getClass().getName();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(i12);
                sb2.append(" ");
                sb2.append(cursor.getType(i12));
                sb2.append(": ");
                sb2.append(cursorValue);
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = " (" + str + ")";
                }
                sb2.append(str2);
            }
            arrayList.add(cursorValue);
        }
        return arrayList;
    }

    private static Map<String, Object> cursorRowToMap(Cursor cursor) {
        HashMap hashMap = new HashMap();
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (Debug.EXTRA_LOGV) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(i11);
                sb2.append(" ");
                sb2.append(cursor.getType(i11));
            }
            int type = cursor.getType(i11);
            if (type == 0) {
                hashMap.put(columnNames[i11], (Object) null);
            } else if (type == 1) {
                hashMap.put(columnNames[i11], Long.valueOf(cursor.getLong(i11)));
            } else if (type == 2) {
                hashMap.put(columnNames[i11], Double.valueOf(cursor.getDouble(i11)));
            } else if (type == 3) {
                hashMap.put(columnNames[i11], cursor.getString(i11));
            } else if (type == 4) {
                hashMap.put(columnNames[i11], cursor.getBlob(i11));
            }
        }
        return hashMap;
    }

    private static Object cursorValue(Cursor cursor, int i11) {
        int type = cursor.getType(i11);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i11));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i11));
        }
        if (type == 3) {
            return cursor.getString(i11);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i11);
    }

    /* access modifiers changed from: private */
    public boolean execute(Database database, Operation operation) {
        if (!executeOrError(database, operation)) {
            return false;
        }
        operation.success((Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public Database executeOrError(Database database, MethodCall methodCall, MethodChannel.Result result) {
        if (executeOrError(database, new ExecuteOperation(result, getSqlCommand(methodCall), (Boolean) methodCall.argument(Constant.PARAM_IN_TRANSACTION)))) {
            return database;
        }
        return null;
    }

    private static Map<String, Object> fixMap(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = fixMap((Map) value);
            } else {
                obj = toString(value);
            }
            hashMap.put(toString(next.getKey()), obj);
        }
        return hashMap;
    }

    private Context getContext() {
        return this.context;
    }

    private Database getDatabase(int i11) {
        return f12870e.get(Integer.valueOf(i11));
    }

    private Database getDatabaseOrError(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        Database database = getDatabase(intValue);
        if (database != null) {
            return database;
        }
        result.error("sqlite_error", "database_closed " + intValue, (Object) null);
        return null;
    }

    private SqlCommand getSqlCommand(MethodCall methodCall) {
        return new SqlCommand((String) methodCall.argument(Constant.PARAM_SQL), (List) methodCall.argument(Constant.PARAM_SQL_ARGUMENTS));
    }

    /* access modifiers changed from: private */
    public void handleException(Exception exc, Operation operation, Database database) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            operation.error("sqlite_error", "open_failed " + database.f12861b, (Object) null);
        } else if (exc instanceof SQLException) {
            operation.error("sqlite_error", exc.getMessage(), SqlErrorInfo.getMap(operation));
        } else {
            operation.error("sqlite_error", exc.getMessage(), SqlErrorInfo.getMap(operation));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean insert(com.tekartik.sqflite.Database r9, com.tekartik.sqflite.operation.Operation r10) {
        /*
            r8 = this;
            boolean r0 = r8.executeOrError(r9, r10)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r10.getNoResult()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            r10.success(r2)
            return r3
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x00bf }
            boolean r4 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00bf }
            java.lang.String r5 = "SELECT changes(), last_insert_rowid()"
            if (r4 != 0) goto L_0x0023
            android.database.Cursor r0 = r0.rawQuery(r5, r2)     // Catch:{ Exception -> 0x00bf }
            goto L_0x0027
        L_0x0023:
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r0, r5, r2)     // Catch:{ Exception -> 0x00bf }
        L_0x0027:
            if (r0 == 0) goto L_0x0092
            int r4 = r0.getCount()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r4 <= 0) goto L_0x0092
            boolean r4 = r0.moveToFirst()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r4 == 0) goto L_0x0092
            int r4 = r0.getInt(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r4 != 0) goto L_0x0067
            int r4 = r9.f12863d     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            boolean r4 = com.tekartik.sqflite.LogLevel.b(r4)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r4 == 0) goto L_0x0060
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r4.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = r9.b()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = "no changes (id was "
            r4.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            long r5 = r0.getLong(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
        L_0x0060:
            r10.success(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r0.close()
            return r3
        L_0x0067:
            long r4 = r0.getLong(r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            int r2 = r9.f12863d     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r2 == 0) goto L_0x0087
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r2.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r6 = r9.b()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r2.append(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r6 = "inserted "
            r2.append(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r2.append(r4)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
        L_0x0087:
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r10.success(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r0.close()
            return r3
        L_0x0092:
            java.lang.String r4 = "Sqflite"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r5.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r6 = r9.b()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r5.append(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            r10.success(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
            if (r0 == 0) goto L_0x00b4
            r0.close()
        L_0x00b4:
            return r3
        L_0x00b5:
            r9 = move-exception
            r2 = r0
            goto L_0x00c9
        L_0x00b8:
            r2 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x00c0
        L_0x00bd:
            r9 = move-exception
            goto L_0x00c9
        L_0x00bf:
            r0 = move-exception
        L_0x00c0:
            r8.handleException(r0, r10, r9)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00c8
            r2.close()
        L_0x00c8:
            return r1
        L_0x00c9:
            if (r2 == 0) goto L_0x00ce
            r2.close()
        L_0x00ce:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.insert(com.tekartik.sqflite.Database, com.tekartik.sqflite.operation.Operation):boolean");
    }

    public static boolean k(String str) {
        if (str == null || str.equals(":memory:")) {
            return true;
        }
        return false;
    }

    public static Map l(int i11, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i11));
        if (z11) {
            hashMap.put(Constant.PARAM_RECOVERED, Boolean.TRUE);
        }
        if (z12) {
            hashMap.put(Constant.PARAM_RECOVERED_IN_TRANSACTION, Boolean.TRUE);
        }
        return hashMap;
    }

    private void onBatchCall(final MethodCall methodCall, MethodChannel.Result result) {
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            final BgResult bgResult = new BgResult(result);
            handler.post(new Runnable() {
                public void run() {
                    MethodCallOperation methodCallOperation = new MethodCallOperation(methodCall, bgResult);
                    boolean noResult = methodCallOperation.getNoResult();
                    boolean continueOnError = methodCallOperation.getContinueOnError();
                    ArrayList arrayList = new ArrayList();
                    for (Map batchOperation : (List) methodCall.argument("operations")) {
                        BatchOperation batchOperation2 = new BatchOperation(batchOperation, noResult);
                        String method = batchOperation2.getMethod();
                        method.hashCode();
                        char c11 = 65535;
                        switch (method.hashCode()) {
                            case -1319569547:
                                if (method.equals(Constant.METHOD_EXECUTE)) {
                                    c11 = 0;
                                    break;
                                }
                                break;
                            case -1183792455:
                                if (method.equals(Constant.METHOD_INSERT)) {
                                    c11 = 1;
                                    break;
                                }
                                break;
                            case -838846263:
                                if (method.equals(Constant.METHOD_UPDATE)) {
                                    c11 = 2;
                                    break;
                                }
                                break;
                            case 107944136:
                                if (method.equals("query")) {
                                    c11 = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c11) {
                            case 0:
                                if (SqflitePlugin.this.execute(databaseOrError, batchOperation2)) {
                                    batchOperation2.handleSuccess(arrayList);
                                    break;
                                } else if (continueOnError) {
                                    batchOperation2.handleErrorContinue(arrayList);
                                    break;
                                } else {
                                    batchOperation2.handleError(bgResult);
                                    return;
                                }
                            case 1:
                                if (SqflitePlugin.this.insert(databaseOrError, batchOperation2)) {
                                    batchOperation2.handleSuccess(arrayList);
                                    break;
                                } else if (continueOnError) {
                                    batchOperation2.handleErrorContinue(arrayList);
                                    break;
                                } else {
                                    batchOperation2.handleError(bgResult);
                                    return;
                                }
                            case 2:
                                if (SqflitePlugin.this.update(databaseOrError, batchOperation2)) {
                                    batchOperation2.handleSuccess(arrayList);
                                    break;
                                } else if (continueOnError) {
                                    batchOperation2.handleErrorContinue(arrayList);
                                    break;
                                } else {
                                    batchOperation2.handleError(bgResult);
                                    return;
                                }
                            case 3:
                                if (SqflitePlugin.this.query(databaseOrError, batchOperation2)) {
                                    batchOperation2.handleSuccess(arrayList);
                                    break;
                                } else if (continueOnError) {
                                    batchOperation2.handleErrorContinue(arrayList);
                                    break;
                                } else {
                                    batchOperation2.handleError(bgResult);
                                    return;
                                }
                            default:
                                BgResult bgResult = bgResult;
                                bgResult.error("bad_param", "Batch method '" + method + "' not supported", (Object) null);
                                return;
                        }
                    }
                    if (noResult) {
                        bgResult.success((Object) null);
                    } else {
                        bgResult.success(arrayList);
                    }
                }
            });
        }
    }

    private void onCloseDatabaseCall(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            if (LogLevel.b(databaseOrError.f12863d)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(databaseOrError.b());
                sb2.append("closing ");
                sb2.append(intValue);
                sb2.append(" ");
                sb2.append(databaseOrError.f12861b);
            }
            String str = databaseOrError.f12861b;
            synchronized (databaseMapLocker) {
                f12870e.remove(Integer.valueOf(intValue));
                if (databaseOrError.f12860a) {
                    f12867b.remove(str);
                }
            }
            final BgResult bgResult = new BgResult(result);
            handler.post(new Runnable() {
                public void run() {
                    synchronized (SqflitePlugin.openCloseLocker) {
                        SqflitePlugin.this.closeDatabase(databaseOrError);
                    }
                    bgResult.success((Object) null);
                }
            });
        }
    }

    private void onDebugCall(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        if ("get".equals((String) methodCall.argument("cmd"))) {
            int i11 = f12868c;
            if (i11 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i11));
            }
            Map<Integer, Database> map = f12870e;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    Database database = (Database) next.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", database.f12861b);
                    hashMap3.put("singleInstance", Boolean.valueOf(database.f12860a));
                    int i12 = database.f12863d;
                    if (i12 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i12));
                    }
                    hashMap2.put(((Integer) next.getKey()).toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        result.success(hashMap);
    }

    private void onDebugModeCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean z11;
        Debug.LOGV = Boolean.TRUE.equals(methodCall.arguments());
        if (!Debug._EXTRA_LOGV || !Debug.LOGV) {
            z11 = false;
        } else {
            z11 = true;
        }
        Debug.EXTRA_LOGV = z11;
        if (!Debug.LOGV) {
            f12868c = 0;
        } else if (Debug.EXTRA_LOGV) {
            f12868c = 2;
        } else if (Debug.LOGV) {
            f12868c = 1;
        }
        result.success((Object) null);
    }

    private void onDeleteDatabaseCall(MethodCall methodCall, MethodChannel.Result result) {
        final Database database;
        Map<Integer, Database> map;
        String str;
        final String str2 = (String) methodCall.argument("path");
        synchronized (databaseMapLocker) {
            if (LogLevel.c(f12868c)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Look for ");
                sb2.append(str2);
                sb2.append(" in ");
                sb2.append(f12867b.keySet());
            }
            Map<String, Integer> map2 = f12867b;
            Integer num = map2.get(str2);
            if (num == null || (database = map.get(num)) == null || !database.f12864e.isOpen()) {
                database = null;
            } else {
                if (LogLevel.c(f12868c)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(database.b());
                    sb3.append("found single instance ");
                    if (database.f12865f) {
                        str = "(in transaction) ";
                    } else {
                        str = "";
                    }
                    sb3.append(str);
                    sb3.append(num);
                    sb3.append(" ");
                    sb3.append(str2);
                }
                (map = f12870e).remove(num);
                map2.remove(str2);
            }
        }
        final BgResult bgResult = new BgResult(result);
        AnonymousClass8 r102 = new Runnable() {
            public void run() {
                synchronized (SqflitePlugin.openCloseLocker) {
                    Database database = database;
                    if (database != null) {
                        SqflitePlugin.this.closeDatabase(database);
                    }
                    try {
                        if (LogLevel.c(SqflitePlugin.f12868c)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("delete database ");
                            sb2.append(str2);
                        }
                        Database.a(str2);
                    } catch (Exception e11) {
                        Log.e(Constant.TAG, "error " + e11 + " while closing database " + SqflitePlugin.databaseId);
                    }
                }
                bgResult.success((Object) null);
            }
        };
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.post(r102);
        } else {
            r102.run();
        }
    }

    private void onExecuteCall(final MethodCall methodCall, MethodChannel.Result result) {
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            final BgResult bgResult = new BgResult(result);
            handler.post(new Runnable() {
                public void run() {
                    if (SqflitePlugin.this.executeOrError(databaseOrError, methodCall, bgResult) != null) {
                        bgResult.success((Object) null);
                    }
                }
            });
        }
    }

    private void onInsertCall(final MethodCall methodCall, MethodChannel.Result result) {
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            final BgResult bgResult = new BgResult(result);
            handler.post(new Runnable() {
                public void run() {
                    boolean unused = SqflitePlugin.this.insert(databaseOrError, new MethodCallOperation(methodCall, bgResult));
                }
            });
        }
    }

    private void onOpenDatabaseCall(MethodCall methodCall, MethodChannel.Result result) {
        final boolean z11;
        final int i11;
        Database database;
        String str;
        final String str2 = (String) methodCall.argument("path");
        final Boolean bool = (Boolean) methodCall.argument("readOnly");
        final boolean k11 = k(str2);
        if (Boolean.FALSE.equals(methodCall.argument("singleInstance")) || k11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            synchronized (databaseMapLocker) {
                if (LogLevel.c(f12868c)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Look for ");
                    sb2.append(str2);
                    sb2.append(" in ");
                    sb2.append(f12867b.keySet());
                }
                Integer num = f12867b.get(str2);
                if (!(num == null || (database = f12870e.get(num)) == null)) {
                    if (database.f12864e.isOpen()) {
                        if (LogLevel.c(f12868c)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(database.b());
                            sb3.append("re-opened single instance ");
                            if (database.f12865f) {
                                str = "(in transaction) ";
                            } else {
                                str = "";
                            }
                            sb3.append(str);
                            sb3.append(num);
                            sb3.append(" ");
                            sb3.append(str2);
                        }
                        result.success(l(num.intValue(), true, database.f12865f));
                        return;
                    } else if (LogLevel.c(f12868c)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(database.b());
                        sb4.append("single instance database of ");
                        sb4.append(str2);
                        sb4.append(" not opened");
                    }
                }
            }
        }
        Object obj = databaseMapLocker;
        synchronized (obj) {
            i11 = databaseId + 1;
            databaseId = i11;
        }
        final Database database2 = new Database(str2, i11, z11, f12868c);
        final BgResult bgResult = new BgResult(result);
        synchronized (obj) {
            if (handler == null) {
                HandlerThread handlerThread2 = new HandlerThread(Constant.TAG, THREAD_PRIORITY);
                handlerThread = handlerThread2;
                handlerThread2.start();
                handler = new Handler(handlerThread.getLooper());
                if (LogLevel.b(database2.f12863d)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(database2.b());
                    sb5.append("starting thread");
                    sb5.append(handlerThread);
                    sb5.append(" priority ");
                    sb5.append(THREAD_PRIORITY);
                }
            }
            if (LogLevel.b(database2.f12863d)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(database2.b());
                sb6.append("opened ");
                sb6.append(i11);
                sb6.append(" ");
                sb6.append(str2);
            }
            final MethodCall methodCall2 = methodCall;
            handler.post(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
                    r5.success(com.tekartik.sqflite.SqflitePlugin.l(r10, false, false));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ba, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
                    com.tekartik.sqflite.SqflitePlugin.h(r5.f12899j, r1, new com.tekartik.sqflite.operation.MethodCallOperation(r8, r5), r7);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d0, code lost:
                    return;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        java.lang.Object r0 = com.tekartik.sqflite.SqflitePlugin.openCloseLocker
                        monitor-enter(r0)
                        boolean r1 = r3     // Catch:{ all -> 0x00d1 }
                        if (r1 != 0) goto L_0x0048
                        java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00d1 }
                        java.lang.String r2 = r4     // Catch:{ all -> 0x00d1 }
                        r1.<init>(r2)     // Catch:{ all -> 0x00d1 }
                        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00d1 }
                        java.lang.String r1 = r1.getParent()     // Catch:{ all -> 0x00d1 }
                        r2.<init>(r1)     // Catch:{ all -> 0x00d1 }
                        boolean r1 = r2.exists()     // Catch:{ all -> 0x00d1 }
                        if (r1 != 0) goto L_0x0048
                        boolean r1 = r2.mkdirs()     // Catch:{ all -> 0x00d1 }
                        if (r1 != 0) goto L_0x0048
                        boolean r1 = r2.exists()     // Catch:{ all -> 0x00d1 }
                        if (r1 != 0) goto L_0x0048
                        com.tekartik.sqflite.SqflitePlugin$BgResult r1 = r5     // Catch:{ all -> 0x00d1 }
                        java.lang.String r2 = "sqlite_error"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
                        r3.<init>()     // Catch:{ all -> 0x00d1 }
                        java.lang.String r4 = "open_failed "
                        r3.append(r4)     // Catch:{ all -> 0x00d1 }
                        java.lang.String r4 = r4     // Catch:{ all -> 0x00d1 }
                        r3.append(r4)     // Catch:{ all -> 0x00d1 }
                        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d1 }
                        r4 = 0
                        r1.error(r2, r3, r4)     // Catch:{ all -> 0x00d1 }
                        monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
                        return
                    L_0x0048:
                        java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00be }
                        java.lang.Boolean r2 = r6     // Catch:{ Exception -> 0x00be }
                        boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00be }
                        if (r1 == 0) goto L_0x0058
                        com.tekartik.sqflite.Database r1 = r7     // Catch:{ Exception -> 0x00be }
                        r1.openReadOnly()     // Catch:{ Exception -> 0x00be }
                        goto L_0x005d
                    L_0x0058:
                        com.tekartik.sqflite.Database r1 = r7     // Catch:{ Exception -> 0x00be }
                        r1.open()     // Catch:{ Exception -> 0x00be }
                    L_0x005d:
                        java.lang.Object r1 = com.tekartik.sqflite.SqflitePlugin.databaseMapLocker     // Catch:{ all -> 0x00d1 }
                        monitor-enter(r1)     // Catch:{ all -> 0x00d1 }
                        boolean r2 = r9     // Catch:{ all -> 0x00bb }
                        if (r2 == 0) goto L_0x0073
                        java.util.Map<java.lang.String, java.lang.Integer> r2 = com.tekartik.sqflite.SqflitePlugin.f12867b     // Catch:{ all -> 0x00bb }
                        java.lang.String r3 = r4     // Catch:{ all -> 0x00bb }
                        int r4 = r10     // Catch:{ all -> 0x00bb }
                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00bb }
                        r2.put(r3, r4)     // Catch:{ all -> 0x00bb }
                    L_0x0073:
                        java.util.Map<java.lang.Integer, com.tekartik.sqflite.Database> r2 = com.tekartik.sqflite.SqflitePlugin.f12870e     // Catch:{ all -> 0x00bb }
                        int r3 = r10     // Catch:{ all -> 0x00bb }
                        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00bb }
                        com.tekartik.sqflite.Database r4 = r7     // Catch:{ all -> 0x00bb }
                        r2.put(r3, r4)     // Catch:{ all -> 0x00bb }
                        monitor-exit(r1)     // Catch:{ all -> 0x00bb }
                        com.tekartik.sqflite.Database r1 = r7     // Catch:{ all -> 0x00d1 }
                        int r1 = r1.f12863d     // Catch:{ all -> 0x00d1 }
                        boolean r1 = com.tekartik.sqflite.LogLevel.b(r1)     // Catch:{ all -> 0x00d1 }
                        if (r1 == 0) goto L_0x00ad
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
                        r1.<init>()     // Catch:{ all -> 0x00d1 }
                        com.tekartik.sqflite.Database r2 = r7     // Catch:{ all -> 0x00d1 }
                        java.lang.String r2 = r2.b()     // Catch:{ all -> 0x00d1 }
                        r1.append(r2)     // Catch:{ all -> 0x00d1 }
                        java.lang.String r2 = "opened "
                        r1.append(r2)     // Catch:{ all -> 0x00d1 }
                        int r2 = r10     // Catch:{ all -> 0x00d1 }
                        r1.append(r2)     // Catch:{ all -> 0x00d1 }
                        java.lang.String r2 = " "
                        r1.append(r2)     // Catch:{ all -> 0x00d1 }
                        java.lang.String r2 = r4     // Catch:{ all -> 0x00d1 }
                        r1.append(r2)     // Catch:{ all -> 0x00d1 }
                    L_0x00ad:
                        monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
                        com.tekartik.sqflite.SqflitePlugin$BgResult r0 = r5
                        int r1 = r10
                        r2 = 0
                        java.util.Map r1 = com.tekartik.sqflite.SqflitePlugin.l(r1, r2, r2)
                        r0.success(r1)
                        return
                    L_0x00bb:
                        r2 = move-exception
                        monitor-exit(r1)     // Catch:{ all -> 0x00bb }
                        throw r2     // Catch:{ all -> 0x00d1 }
                    L_0x00be:
                        r1 = move-exception
                        com.tekartik.sqflite.operation.MethodCallOperation r2 = new com.tekartik.sqflite.operation.MethodCallOperation     // Catch:{ all -> 0x00d1 }
                        io.flutter.plugin.common.MethodCall r3 = r8     // Catch:{ all -> 0x00d1 }
                        com.tekartik.sqflite.SqflitePlugin$BgResult r4 = r5     // Catch:{ all -> 0x00d1 }
                        r2.<init>(r3, r4)     // Catch:{ all -> 0x00d1 }
                        com.tekartik.sqflite.SqflitePlugin r3 = com.tekartik.sqflite.SqflitePlugin.this     // Catch:{ all -> 0x00d1 }
                        com.tekartik.sqflite.Database r4 = r7     // Catch:{ all -> 0x00d1 }
                        r3.handleException(r1, r2, r4)     // Catch:{ all -> 0x00d1 }
                        monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
                        return
                    L_0x00d1:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.AnonymousClass6.run():void");
                }
            });
        }
    }

    private void onQueryCall(final MethodCall methodCall, MethodChannel.Result result) {
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            final BgResult bgResult = new BgResult(result);
            handler.post(new Runnable() {
                public void run() {
                    boolean unused = SqflitePlugin.this.query(databaseOrError, new MethodCallOperation(methodCall, bgResult));
                }
            });
        }
    }

    private void onUpdateCall(final MethodCall methodCall, MethodChannel.Result result) {
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            final BgResult bgResult = new BgResult(result);
            handler.post(new Runnable() {
                public void run() {
                    boolean unused = SqflitePlugin.this.update(databaseOrError, new MethodCallOperation(methodCall, bgResult));
                }
            });
        }
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.util.Map, java.util.HashMap] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        if (r3 != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        r3 = new java.util.ArrayList();
        r5 = new java.util.HashMap();
        r6 = r0.getColumnCount();
        r5.put("columns", java.util.Arrays.asList(r0.getColumnNames()));
        r5.put("rows", r3);
        r10 = r5;
        r5 = r3;
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0093, code lost:
        r5.add(cursorRowToList(r0, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a1, code lost:
        if (r3 != null) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a3, code lost:
        r3 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        r13.success(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0043, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean query(com.tekartik.sqflite.Database r12, com.tekartik.sqflite.operation.Operation r13) {
        /*
            r11 = this;
            com.tekartik.sqflite.SqlCommand r0 = r13.getSqlCommand()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r12.f12863d
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)
            if (r2 == 0) goto L_0x0020
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r12.b()
            r2.append(r3)
            r2.append(r0)
        L_0x0020:
            boolean r2 = QUERY_AS_MAP_LIST
            r3 = 0
            r4 = 0
            com.tekartik.sqflite.SqlCommand r0 = r0.sanitizeForQuery()     // Catch:{ Exception -> 0x00b9 }
            android.database.sqlite.SQLiteDatabase r5 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r6 = r0.getSql()     // Catch:{ Exception -> 0x00b9 }
            java.lang.String[] r0 = r0.getQuerySqlArguments()     // Catch:{ Exception -> 0x00b9 }
            boolean r7 = r5 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00b9 }
            if (r7 != 0) goto L_0x003d
            android.database.Cursor r0 = r5.rawQuery(r6, r0)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x0041
        L_0x003d:
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r5, r6, r0)     // Catch:{ Exception -> 0x00b9 }
        L_0x0041:
            r5 = r3
            r6 = r4
        L_0x0043:
            boolean r7 = r0.moveToNext()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r7 == 0) goto L_0x009b
            if (r2 == 0) goto L_0x006e
            java.util.Map r7 = cursorRowToMap(r0)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            int r8 = r12.f12863d     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            boolean r8 = com.tekartik.sqflite.LogLevel.b(r8)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r8 == 0) goto L_0x006a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r8.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r9 = r12.b()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r8.append(r9)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r9 = toString(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r8.append(r9)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        L_0x006a:
            r1.add(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            goto L_0x0043
        L_0x006e:
            if (r3 != 0) goto L_0x0093
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r3.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r5.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            int r6 = r0.getColumnCount()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r7 = "columns"
            java.lang.String[] r8 = r0.getColumnNames()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r5.put(r7, r8)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r7 = "rows"
            r5.put(r7, r3)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r10 = r5
            r5 = r3
            r3 = r10
        L_0x0093:
            java.util.List r7 = cursorRowToList(r0, r6)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r5.add(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            goto L_0x0043
        L_0x009b:
            if (r2 == 0) goto L_0x00a1
            r13.success(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            goto L_0x00ab
        L_0x00a1:
            if (r3 != 0) goto L_0x00a8
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            r3.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        L_0x00a8:
            r13.success(r3)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
        L_0x00ab:
            r0.close()
            r12 = 1
            return r12
        L_0x00b0:
            r12 = move-exception
            r3 = r0
            goto L_0x00c3
        L_0x00b3:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x00ba
        L_0x00b7:
            r12 = move-exception
            goto L_0x00c3
        L_0x00b9:
            r0 = move-exception
        L_0x00ba:
            r11.handleException(r0, r13, r12)     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x00c2
            r3.close()
        L_0x00c2:
            return r4
        L_0x00c3:
            if (r3 == 0) goto L_0x00c8
            r3.close()
        L_0x00c8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.query(com.tekartik.sqflite.Database, com.tekartik.sqflite.operation.Operation):boolean");
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SqflitePlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    private static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return fixMap((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean update(com.tekartik.sqflite.Database r8, com.tekartik.sqflite.operation.Operation r9) {
        /*
            r7 = this;
            boolean r0 = r7.executeOrError(r8, r9)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r9.getNoResult()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r9.success(r3)
            return r2
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r8.getWritableDatabase()     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = "SELECT changes()"
            boolean r5 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x008c }
            if (r5 != 0) goto L_0x0023
            android.database.Cursor r0 = r0.rawQuery(r4, r3)     // Catch:{ Exception -> 0x008c }
            goto L_0x0027
        L_0x0023:
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r0, r4, r3)     // Catch:{ Exception -> 0x008c }
        L_0x0027:
            if (r0 == 0) goto L_0x0060
            int r4 = r0.getCount()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            if (r4 <= 0) goto L_0x0060
            boolean r4 = r0.moveToFirst()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            if (r4 == 0) goto L_0x0060
            int r3 = r0.getInt(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            int r4 = r8.f12863d     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            boolean r4 = com.tekartik.sqflite.LogLevel.b(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            if (r4 == 0) goto L_0x0055
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r4.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r5 = r8.b()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r4.append(r5)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r5 = "changed "
            r4.append(r5)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r4.append(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
        L_0x0055:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r9.success(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r0.close()
            return r2
        L_0x0060:
            java.lang.String r4 = "Sqflite"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r5.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r6 = r8.b()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r5.append(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r6 = "fail to read changes for Update/Delete"
            r5.append(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r9.success(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            if (r0 == 0) goto L_0x0082
            r0.close()
        L_0x0082:
            return r2
        L_0x0083:
            r8 = move-exception
            r3 = r0
            goto L_0x0096
        L_0x0086:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x008d
        L_0x008a:
            r8 = move-exception
            goto L_0x0096
        L_0x008c:
            r0 = move-exception
        L_0x008d:
            r7.handleException(r0, r9, r8)     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0095
            r3.close()
        L_0x0095:
            return r1
        L_0x0096:
            if (r3 == 0) goto L_0x009b
            r3.close()
        L_0x009b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.update(com.tekartik.sqflite.Database, com.tekartik.sqflite.operation.Operation):boolean");
    }

    public void m(MethodCall methodCall, MethodChannel.Result result) {
        if (f12869d == null) {
            f12869d = this.context.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(f12869d);
    }

    public void n(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("queryAsMapList");
        if (argument != null) {
            QUERY_AS_MAP_LIST = Boolean.TRUE.equals(argument);
        }
        Object argument2 = methodCall.argument("androidThreadPriority");
        if (argument2 != null) {
            THREAD_PRIORITY = ((Integer) argument2).intValue();
        }
        Integer a11 = LogLevel.a(methodCall);
        if (a11 != null) {
            f12868c = a11.intValue();
        }
        result.success((Object) null);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.context = null;
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1319569547:
                if (str.equals(Constant.METHOD_EXECUTE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1253581933:
                if (str.equals(Constant.METHOD_CLOSE_DATABASE)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1249474914:
                if (str.equals("options")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals(Constant.METHOD_INSERT)) {
                    c11 = 3;
                    break;
                }
                break;
            case -838846263:
                if (str.equals(Constant.METHOD_UPDATE)) {
                    c11 = 4;
                    break;
                }
                break;
            case -263511994:
                if (str.equals(Constant.METHOD_DELETE_DATABASE)) {
                    c11 = 5;
                    break;
                }
                break;
            case -198450538:
                if (str.equals(Constant.METHOD_DEBUG_MODE)) {
                    c11 = 6;
                    break;
                }
                break;
            case -17190427:
                if (str.equals(Constant.METHOD_OPEN_DATABASE)) {
                    c11 = 7;
                    break;
                }
                break;
            case 93509434:
                if (str.equals(Constant.METHOD_BATCH)) {
                    c11 = 8;
                    break;
                }
                break;
            case 95458899:
                if (str.equals("debug")) {
                    c11 = 9;
                    break;
                }
                break;
            case 107944136:
                if (str.equals("query")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals(Constant.METHOD_GET_PLATFORM_VERSION)) {
                    c11 = 11;
                    break;
                }
                break;
            case 1863829223:
                if (str.equals(Constant.METHOD_GET_DATABASES_PATH)) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                onExecuteCall(methodCall, result);
                return;
            case 1:
                onCloseDatabaseCall(methodCall, result);
                return;
            case 2:
                n(methodCall, result);
                return;
            case 3:
                onInsertCall(methodCall, result);
                return;
            case 4:
                onUpdateCall(methodCall, result);
                return;
            case 5:
                onDeleteDatabaseCall(methodCall, result);
                return;
            case 6:
                onDebugModeCall(methodCall, result);
                return;
            case 7:
                onOpenDatabaseCall(methodCall, result);
                return;
            case 8:
                onBatchCall(methodCall, result);
                return;
            case 9:
                onDebugCall(methodCall, result);
                return;
            case 10:
                onQueryCall(methodCall, result);
                return;
            case 11:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 12:
                m(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public SqflitePlugin(Context context2) {
        this.context = context2.getApplicationContext();
    }

    private void onAttachedToEngine(Context context2, BinaryMessenger binaryMessenger) {
        this.context = context2;
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "com.tekartik.sqflite");
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
    }

    private boolean executeOrError(Database database, Operation operation) {
        SqlCommand sqlCommand = operation.getSqlCommand();
        if (LogLevel.b(database.f12863d)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(database.b());
            sb2.append(sqlCommand);
        }
        Boolean inTransaction = operation.getInTransaction();
        try {
            SQLiteDatabase writableDatabase = database.getWritableDatabase();
            String sql = sqlCommand.getSql();
            Object[] sqlArguments = sqlCommand.getSqlArguments();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL(sql, sqlArguments);
            } else {
                SQLiteInstrumentation.execSQL(writableDatabase, sql, sqlArguments);
            }
            if (Boolean.TRUE.equals(inTransaction)) {
                database.f12865f = true;
            }
            if (Boolean.FALSE.equals(inTransaction)) {
                database.f12865f = false;
            }
            return true;
        } catch (Exception e11) {
            handleException(e11, operation, database);
            if (Boolean.FALSE.equals(inTransaction)) {
                database.f12865f = false;
            }
            return false;
        } catch (Throwable th2) {
            if (Boolean.FALSE.equals(inTransaction)) {
                database.f12865f = false;
            }
            throw th2;
        }
    }
}
