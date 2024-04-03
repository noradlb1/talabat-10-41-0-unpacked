package com.instabug.library.logging;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public abstract class e {
    public static long a(@NonNull String str, int i11, @NonNull String str2, boolean z11) {
        long c11 = c(str, i11, str2, z11);
        return c11 < 1 ? e(str, i11, str2, z11) : c11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        if (r11 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        if (r11 == null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0074, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(@androidx.annotation.NonNull java.lang.String r11, @androidx.annotation.NonNull java.lang.String r12) {
        /*
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            java.lang.String r9 = "event_logging_count"
            java.lang.String[] r3 = new java.lang.String[]{r9}
            java.lang.String r4 = "event_identifier = ? AND uuid = ? "
            r1 = 2
            java.lang.String[] r5 = new java.lang.String[r1]
            r10 = 0
            r5[r10] = r11
            r11 = 1
            r5[r11] = r12
            r11 = 0
            java.lang.String r2 = "user_events_logs"
            r6 = 0
            r7 = 0
            r8 = 0
            boolean r12 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x004c }
            if (r12 != 0) goto L_0x002d
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x004c }
            goto L_0x0034
        L_0x002d:
            r1 = r0
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ Exception -> 0x004c }
            android.database.Cursor r11 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x004c }
        L_0x0034:
            if (r11 == 0) goto L_0x0047
            int r12 = r11.getCount()     // Catch:{ Exception -> 0x004c }
            if (r12 <= 0) goto L_0x0047
            r11.moveToFirst()     // Catch:{ Exception -> 0x004c }
            int r12 = r11.getColumnIndex(r9)     // Catch:{ Exception -> 0x004c }
            int r10 = r11.getInt(r12)     // Catch:{ Exception -> 0x004c }
        L_0x0047:
            if (r11 == 0) goto L_0x0071
            goto L_0x006e
        L_0x004a:
            r12 = move-exception
            goto L_0x0075
        L_0x004c:
            r12 = move-exception
            java.lang.String r1 = "IBG-Core"
            java.lang.String r2 = "retrieve occurrences count failed: "
            com.instabug.library.util.InstabugSDKLogger.e(r1, r2, r12)     // Catch:{ all -> 0x004a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r1.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "retrieve user events occurrences count failed: "
            r1.append(r2)     // Catch:{ all -> 0x004a }
            java.lang.String r2 = r12.getMessage()     // Catch:{ all -> 0x004a }
            r1.append(r2)     // Catch:{ all -> 0x004a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004a }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r12, r1)     // Catch:{ all -> 0x004a }
            if (r11 == 0) goto L_0x0071
        L_0x006e:
            r11.close()
        L_0x0071:
            r0.close()
            return r10
        L_0x0075:
            if (r11 == 0) goto L_0x007a
            r11.close()
        L_0x007a:
            r0.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.e.b(java.lang.String, java.lang.String):int");
    }

    /* JADX INFO: finally extract failed */
    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static long c(String str, int i11, String str2, boolean z11) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        try {
            ContentValues d11 = d(str, i11, str2, z11);
            openDatabase.beginTransaction();
            long insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.UserEventEntry.TABLE_NAME, (String) null, d11);
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
            return insertWithOnConflict;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Inserting user events failed due to: " + e11.getMessage());
            IBGDiagnostics.reportNonFatal(e11, "Inserting user events failed due to: " + e11.getMessage());
            openDatabase.endTransaction();
            openDatabase.close();
            return -1;
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static ContentValues d(String str, int i11, String str2, boolean z11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.UserEventEntry.COLUMN_EVENT_IDENTIFIER, str);
        contentValues.put(InstabugDbContract.UserEventEntry.COLUMN_EVENT_LOGGING_COUNT, Integer.valueOf(i11));
        contentValues.put("uuid", str2);
        contentValues.put("is_anonymous", Boolean.valueOf(z11));
        return contentValues;
    }

    /* JADX INFO: finally extract failed */
    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static long e(String str, int i11, String str2, boolean z11) {
        int i12;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str, str2};
        try {
            openDatabase.beginTransaction();
            ContentValues d11 = d(str, i11, str2, z11);
            if (!(openDatabase instanceof SQLiteDatabase)) {
                i12 = openDatabase.update(InstabugDbContract.UserEventEntry.TABLE_NAME, d11, "event_identifier=? AND uuid=?", strArr);
            } else {
                i12 = SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.UserEventEntry.TABLE_NAME, d11, "event_identifier=? AND uuid=?", strArr);
            }
            long j11 = (long) i12;
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
            return j11;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Updating user event failed due to: " + e11.getMessage());
            IBGDiagnostics.reportNonFatal(e11, "Updating user event failed due to: " + e11.getMessage());
            openDatabase.endTransaction();
            openDatabase.close();
            return -1;
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
    }

    public static void a(String str) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        try {
            openDatabase.beginTransaction();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.UserEventEntry.TABLE_NAME, "uuid=?", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserEventEntry.TABLE_NAME, "uuid=?", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Deleting user events failed due to: " + e11.getMessage());
            IBGDiagnostics.reportNonFatal(e11, "Deleting user events failed due to: " + e11.getMessage());
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
        openDatabase.endTransaction();
        openDatabase.close();
    }

    public static void a() {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {"1"};
        try {
            openDatabase.beginTransaction();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.UserEventEntry.TABLE_NAME, "is_anonymous = ? ", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserEventEntry.TABLE_NAME, "is_anonymous = ? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Deleting anonymous user events failed due to: " + e11.getMessage());
            IBGDiagnostics.reportNonFatal(e11, "Deleting anonymous user events failed due to: " + e11.getMessage());
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
        openDatabase.endTransaction();
        openDatabase.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        if (r13 != null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0095, code lost:
        if (r13 == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009a, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009d, code lost:
        return r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map b() {
        /*
            java.lang.String r0 = "Retrieving anonymous user events failed due to: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.String r10 = "event_identifier"
            java.lang.String r11 = "event_logging_count"
            java.lang.String[] r4 = new java.lang.String[]{r10, r11}
            java.lang.String r5 = "is_anonymous = ? "
            java.lang.String r2 = "1"
            java.lang.String[] r6 = new java.lang.String[]{r2}
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r13 = 0
            java.lang.String r3 = "user_events_logs"
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0066 }
            if (r2 != 0) goto L_0x0033
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0066 }
            goto L_0x003a
        L_0x0033:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0066 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0066 }
        L_0x003a:
            r13 = r2
            if (r13 == 0) goto L_0x0061
            int r2 = r13.getCount()     // Catch:{ Exception -> 0x0066 }
            if (r2 <= 0) goto L_0x0061
            int r2 = r13.getColumnIndex(r10)     // Catch:{ Exception -> 0x0066 }
            int r3 = r13.getColumnIndex(r11)     // Catch:{ Exception -> 0x0066 }
        L_0x004b:
            boolean r4 = r13.moveToNext()     // Catch:{ Exception -> 0x0066 }
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = r13.getString(r2)     // Catch:{ Exception -> 0x0066 }
            int r5 = r13.getInt(r3)     // Catch:{ Exception -> 0x0066 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0066 }
            r12.put(r4, r5)     // Catch:{ Exception -> 0x0066 }
            goto L_0x004b
        L_0x0061:
            if (r13 == 0) goto L_0x009a
            goto L_0x0097
        L_0x0064:
            r0 = move-exception
            goto L_0x009e
        L_0x0066:
            r2 = move-exception
            java.lang.String r3 = "IBG-Core"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r4.<init>()     // Catch:{ all -> 0x0064 }
            r4.append(r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = r2.getMessage()     // Catch:{ all -> 0x0064 }
            r4.append(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0064 }
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4)     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            r3.append(r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = r2.getMessage()     // Catch:{ all -> 0x0064 }
            r3.append(r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0064 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r2, r0)     // Catch:{ all -> 0x0064 }
            if (r13 == 0) goto L_0x009a
        L_0x0097:
            r13.close()
        L_0x009a:
            r1.close()
            return r12
        L_0x009e:
            if (r13 == 0) goto L_0x00a3
            r13.close()
        L_0x00a3:
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.e.b():java.util.Map");
    }

    public static boolean a(@NonNull String str, @NonNull String str2) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {InstabugDbContract.UserEventEntry.COLUMN_EVENT_LOGGING_COUNT};
        boolean z11 = false;
        String[] strArr2 = {str, str2};
        Cursor cursor = null;
        try {
            Cursor query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.UserEventEntry.TABLE_NAME, strArr, "event_identifier = ? AND uuid = ? ", strArr2, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.UserEventEntry.TABLE_NAME, strArr, "event_identifier = ? AND uuid = ? ", strArr2, (String) null, (String) null, (String) null);
            if (query != null && query.getCount() > 0) {
                z11 = true;
            }
            if (query != null) {
                query.close();
            }
            openDatabase.close();
            return z11;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Retrieving user events failed due to: " + e11.getMessage());
            IBGDiagnostics.reportNonFatal(e11, "Retrieving user events failed due to: " + e11.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            return false;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
            throw th2;
        }
    }
}
