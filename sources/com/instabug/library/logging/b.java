package com.instabug.library.logging;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Instrumented
abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static PublishSubject f51446a;

    /* renamed from: b  reason: collision with root package name */
    private static Disposable f51447b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static List f51448c = new ArrayList();

    /* access modifiers changed from: private */
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void b(List list) {
        synchronized (b.class) {
            InstabugSDKLogger.d("IBG-Core", "inserting InstabugLogs to DB");
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    InstabugLog.h hVar = (InstabugLog.h) it.next();
                    if (hVar != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(InstabugDbContract.InstabugLogEntry.COLUMN_LOG_MESSAGE, hVar.e());
                        if (hVar.g() != null) {
                            contentValues.put(InstabugDbContract.InstabugLogEntry.COLUMN_LOG_LEVEL, hVar.g().toString());
                        }
                        contentValues.put(InstabugDbContract.InstabugLogEntry.COLUMN_LOG_DATE, String.valueOf(hVar.f()));
                        if (!(openDatabase instanceof SQLiteDatabase)) {
                            openDatabase.insert(InstabugDbContract.InstabugLogEntry.TABLE_NAME, (String) null, contentValues);
                        } else {
                            SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.InstabugLogEntry.TABLE_NAME, (String) null, contentValues);
                        }
                    }
                }
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.execSQL(InstabugDbContract.InstabugLogEntry.DELETE_ALL_EXCEPT_THE_LATEST_1000_ENTRY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.InstabugLogEntry.DELETE_ALL_EXCEPT_THE_LATEST_1000_ENTRY);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "Error while inserting instabug logs to DB", "IBG-Core");
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.endTransaction();
            openDatabase.close();
            f();
        }
    }

    private static synchronized void c() {
        synchronized (b.class) {
            InstabugSDKLogger.d("IBG-Core", "forceInsertSuspendedLogs");
            f();
            ArrayList arrayList = new ArrayList(f51448c);
            f51448c.clear();
            b((List) arrayList);
        }
    }

    private static void d() {
        f51447b = (Disposable) f51446a.debounce(1, TimeUnit.SECONDS).observeOn(Schedulers.io()).subscribeWith(new a());
    }

    public static void e() {
        InstabugSDKLogger.d("IBG-Core", "clearing instabug logs");
        c();
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.InstabugLogEntry.TABLE_NAME, (String) null, (String[]) null);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.InstabugLogEntry.TABLE_NAME, (String) null, (String[]) null);
            }
            openDatabase.setTransactionSuccessful();
        } catch (Exception e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("IBG-Core", e11.getMessage(), e11);
            }
            IBGDiagnostics.reportNonFatal(e11, "Couldn't clear SDK logs due to: " + e11.getMessage());
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
        openDatabase.endTransaction();
        openDatabase.close();
    }

    private static void f() {
        Disposable disposable = f51447b;
        if (disposable != null && !disposable.isDisposed()) {
            f51447b.dispose();
        }
    }

    public static void g() {
        InstabugSDKLogger.d("IBG-Core", "trimming instabug logs in DB");
        c();
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.InstabugLogEntry.TRIM_INSTABUG_LOG_SQL_QUERY);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.InstabugLogEntry.TRIM_INSTABUG_LOG_SQL_QUERY);
            }
            openDatabase.setTransactionSuccessful();
        } catch (Exception e11) {
            if (e11.getMessage() != null) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't trim SDK logs due to: " + e11.getMessage(), e11);
            }
            IBGDiagnostics.reportNonFatal(e11, "Couldn't trim SDK logs due to: " + e11.getMessage());
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
        openDatabase.endTransaction();
        openDatabase.close();
    }

    public static synchronized void c(InstabugLog.h hVar) {
        synchronized (b.class) {
            InstabugSDKLogger.d("IBG-Core", "inserting instabug logs to DB");
            if (f51446a == null) {
                f51446a = PublishSubject.create();
                d();
            } else if (f51447b.isDisposed()) {
                d();
            }
            f51448c.add(hVar);
            f51446a.onNext(new ArrayList(f51448c));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c5, code lost:
        if (r3.isClosed() == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ec, code lost:
        if (r3.isClosed() == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ee, code lost:
        r3.close();
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray b(float r8) {
        /*
            java.lang.String r0 = "retrieving instabug logs from DB"
            java.lang.String r1 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.d(r1, r0)
            c()
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r2 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r2 = r2.openDatabase()
            r2.beginTransaction()
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r8 = r8 * r3
            int r8 = java.lang.Math.round(r8)
            java.util.Locale r3 = java.util.Locale.US
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5 = 0
            r4[r5] = r8
            java.lang.String r8 = "SELECT * FROM instabug_logs ORDER  BY log_date DESC LIMIT %d"
            java.lang.String r8 = java.lang.String.format(r3, r8, r4)
            r3 = 0
            boolean r4 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00ca }
            if (r4 != 0) goto L_0x003d
            android.database.Cursor r8 = r2.rawQuery(r8, r3)     // Catch:{ Exception -> 0x00ca }
            goto L_0x0044
        L_0x003d:
            r4 = r2
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x00ca }
            android.database.Cursor r8 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r4, r8, r3)     // Catch:{ Exception -> 0x00ca }
        L_0x0044:
            r3 = r8
            if (r3 == 0) goto L_0x00b9
            boolean r8 = r3.moveToFirst()     // Catch:{ Exception -> 0x00ca }
            if (r8 == 0) goto L_0x00b9
        L_0x004d:
            java.lang.String r8 = "log_message"
            int r8 = r3.getColumnIndexOrThrow(r8)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r8 = r3.getString(r8)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r4 = "log_level"
            int r4 = r3.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r5 = "log_date"
            int r5 = r3.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ca }
            com.instabug.library.logging.InstabugLog$h r6 = new com.instabug.library.logging.InstabugLog$h     // Catch:{ Exception -> 0x00ca }
            r6.<init>()     // Catch:{ Exception -> 0x00ca }
            com.instabug.library.logging.InstabugLog$h r8 = r6.c(r8)     // Catch:{ Exception -> 0x00ca }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00ca }
            java.lang.String r4 = r4.toUpperCase(r7)     // Catch:{ Exception -> 0x00ca }
            com.instabug.library.logging.InstabugLog$g r4 = com.instabug.library.logging.InstabugLog.g.valueOf(r4)     // Catch:{ Exception -> 0x00ca }
            r8.b(r4)     // Catch:{ Exception -> 0x00ca }
            boolean r8 = com.instabug.library.util.StringUtility.isNumeric(r5)     // Catch:{ Exception -> 0x00ca }
            if (r8 == 0) goto L_0x008f
            long r4 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x00ca }
            r6.a(r4)     // Catch:{ Exception -> 0x00ca }
            goto L_0x00ac
        L_0x008f:
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x00a6 }
            java.lang.String r4 = "MM-dd HH:mm:ss.SSS"
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ ParseException -> 0x00a6 }
            r8.<init>(r4, r7)     // Catch:{ ParseException -> 0x00a6 }
            java.util.Date r8 = r8.parse(r5)     // Catch:{ ParseException -> 0x00a6 }
            if (r8 == 0) goto L_0x00ac
            long r4 = r8.getTime()     // Catch:{ ParseException -> 0x00a6 }
            r6.a(r4)     // Catch:{ ParseException -> 0x00a6 }
            goto L_0x00ac
        L_0x00a6:
            r8 = move-exception
            java.lang.String r4 = "Couldn't parse instabug logs"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r4, r8)     // Catch:{ Exception -> 0x00ca }
        L_0x00ac:
            org.json.JSONObject r8 = r6.d()     // Catch:{ Exception -> 0x00ca }
            r0.put((java.lang.Object) r8)     // Catch:{ Exception -> 0x00ca }
            boolean r8 = r3.moveToNext()     // Catch:{ Exception -> 0x00ca }
            if (r8 != 0) goto L_0x004d
        L_0x00b9:
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x00ca }
            r2.endTransaction()
            if (r3 == 0) goto L_0x00f4
            boolean r8 = r3.isClosed()
            if (r8 != 0) goto L_0x00f4
            goto L_0x00ee
        L_0x00c8:
            r8 = move-exception
            goto L_0x00f5
        L_0x00ca:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r4.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r5 = "Couldn't get SDK logs due to: "
            r4.append(r5)     // Catch:{ all -> 0x00c8 }
            java.lang.String r5 = r8.getMessage()     // Catch:{ all -> 0x00c8 }
            r4.append(r5)     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00c8 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r8, r4, r1)     // Catch:{ all -> 0x00c8 }
            r2.endTransaction()
            if (r3 == 0) goto L_0x00f4
            boolean r8 = r3.isClosed()
            if (r8 != 0) goto L_0x00f4
        L_0x00ee:
            r3.close()
            r2.close()
        L_0x00f4:
            return r0
        L_0x00f5:
            r2.endTransaction()
            if (r3 == 0) goto L_0x0106
            boolean r0 = r3.isClosed()
            if (r0 != 0) goto L_0x0106
            r3.close()
            r2.close()
        L_0x0106:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.b.b(float):org.json.JSONArray");
    }
}
