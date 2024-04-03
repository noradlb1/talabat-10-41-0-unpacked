package com.instabug.library.internal.storage.cache.db.userAttribute;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.UserAttributes;
import com.instabug.library.model.l;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.filters.h;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Instrumented
public class UserAttributesDbHelper {
    @NonNull
    public static List<l> a() {
        Cursor cursor;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {"1"};
        if (!(openDatabase instanceof SQLiteDatabase)) {
            cursor = openDatabase.query(InstabugDbContract.UserAttributesEntry.TABLE_NAME, (String[]) null, "is_anonymous=? ", strArr, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, (String[]) null, "is_anonymous=? ", strArr, (String) null, (String) null, (String) null);
        }
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("value");
            int columnIndex2 = cursor.getColumnIndex("key");
            int columnIndex3 = cursor.getColumnIndex("uuid");
            int columnIndex4 = cursor.getColumnIndex("type");
            try {
                ArrayList arrayList = new ArrayList();
                if (!cursor.moveToFirst()) {
                    return arrayList;
                }
                do {
                    String string = cursor.getString(columnIndex);
                    String string2 = cursor.getString(columnIndex2);
                    String string3 = cursor.getString(columnIndex3);
                    arrayList.add(new l.a(string2, string).a(string3).a(true).a(cursor.getInt(columnIndex4)).a());
                } while (cursor.moveToNext());
                cursor.close();
                openDatabase.close();
                return arrayList;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "an exception has occurred while retrieving user attributes: " + e11.getMessage(), "IBG-Core");
            } finally {
                cursor.close();
                openDatabase.close();
            }
        }
        return Collections.emptyList();
    }

    public static synchronized void delete(String str, String str2) {
        synchronized (UserAttributesDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str, str2};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.UserAttributesEntry.TABLE_NAME, "key = ? AND uuid =?", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, "key = ? AND uuid =?", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static synchronized void deleteAll() {
        synchronized (UserAttributesDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.UserAttributesEntry.TABLE_NAME, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, (String) null, (String[]) null);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static void deleteAnonymousData() {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {"1"};
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.UserAttributesEntry.TABLE_NAME, "is_anonymous = ?", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, "is_anonymous = ?", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static synchronized void deleteType(String str, int i11) {
        synchronized (UserAttributesDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(i11), str};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.UserAttributesEntry.TABLE_NAME, "type = ? AND uuid =?", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, "type = ? AND uuid =?", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static synchronized void deleteUserAttributes(String str) {
        synchronized (UserAttributesDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.UserAttributesEntry.TABLE_NAME, "uuid = ?", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, "uuid = ?", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    @NonNull
    public static HashMap<String, String> getAll() {
        return UserAttributeCacheManager.retrieveAll();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private static ContentValues getContentValue(l lVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", lVar.b());
        contentValues.put("value", lVar.e());
        contentValues.put("uuid", lVar.d());
        contentValues.put("type", Integer.valueOf(lVar.c()));
        contentValues.put("is_anonymous", Boolean.valueOf(lVar.f()));
        return contentValues;
    }

    public static String getSDKUserAttributes() {
        HashMap hashMap = (HashMap) Filters.applyOn(getAll()).apply(h.g()).thenGet();
        if (hashMap == null || hashMap.size() == 0) {
            return "{}";
        }
        UserAttributes userAttributes = new UserAttributes();
        userAttributes.putMap(hashMap);
        return userAttributes.toString();
    }

    public static String getSDKUserAttributesAndAppendToIt(@NonNull String str, @NonNull String str2) {
        HashMap hashMap = (HashMap) Filters.applyOn(getAll()).apply(h.g()).thenGet();
        if (hashMap != null) {
            if (str != null && !str.trim().isEmpty() && str2 != null && !str2.trim().isEmpty()) {
                hashMap.put(str.trim(), str2.trim());
            }
            if (hashMap.size() != 0) {
                UserAttributes userAttributes = new UserAttributes();
                userAttributes.putMap(hashMap);
                return userAttributes.toString();
            }
        }
        return "{}";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005d, code lost:
        if (r10 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
        if (r10 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007f, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0082, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getType(java.lang.String r10, java.lang.String r11) {
        /*
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            java.lang.String r9 = "type"
            java.lang.String[] r3 = new java.lang.String[]{r9}
            java.lang.String r4 = "key LIKE ? AND uuid =? "
            r1 = 2
            java.lang.String[] r5 = new java.lang.String[r1]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "%"
            r1.append(r2)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            r1 = 0
            r5[r1] = r10
            r10 = 1
            r5[r10] = r11
            r10 = 0
            r11 = -1
            java.lang.String r2 = "user_attributes_table"
            r6 = 0
            r7 = 0
            r8 = 0
            boolean r1 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0062 }
            if (r1 != 0) goto L_0x0043
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0062 }
            goto L_0x004a
        L_0x0043:
            r1 = r0
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ Exception -> 0x0062 }
            android.database.Cursor r10 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0062 }
        L_0x004a:
            if (r10 == 0) goto L_0x005d
            int r1 = r10.getCount()     // Catch:{ Exception -> 0x0062 }
            if (r1 <= 0) goto L_0x005d
            r10.moveToFirst()     // Catch:{ Exception -> 0x0062 }
            int r1 = r10.getColumnIndex(r9)     // Catch:{ Exception -> 0x0062 }
            int r11 = r10.getInt(r1)     // Catch:{ Exception -> 0x0062 }
        L_0x005d:
            if (r10 == 0) goto L_0x0082
            goto L_0x007f
        L_0x0060:
            r11 = move-exception
            goto L_0x0086
        L_0x0062:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r2.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "Failed to get UserAttribute type due to: "
            r2.append(r3)     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x0060 }
            r2.append(r3)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "IBG-Core"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r1, r2, r3)     // Catch:{ all -> 0x0060 }
            if (r10 == 0) goto L_0x0082
        L_0x007f:
            r10.close()
        L_0x0082:
            r0.close()
            return r11
        L_0x0086:
            if (r10 == 0) goto L_0x008b
            r10.close()
        L_0x008b:
            r0.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper.getType(java.lang.String, java.lang.String):int");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized long insert(l lVar) {
        long insertWithOnConflict;
        synchronized (UserAttributesDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.UserAttributesEntry.TABLE_NAME, (String) null, getContentValue(lVar));
                if (insertWithOnConflict == -1) {
                    update(lVar);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
        return insertWithOnConflict;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void insertBulk(List<l> list) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        openDatabase.beginTransaction();
        try {
            for (l next : list) {
                if (openDatabase.insertWithOnConflict(InstabugDbContract.UserAttributesEntry.TABLE_NAME, (String) null, getContentValue(next)) == -1) {
                    update(next);
                }
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    @Nullable
    public static String retrieve(String str, String str2) {
        Cursor cursor;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {"value"};
        String[] strArr2 = {"%" + str + "%", str2};
        if (!(openDatabase instanceof SQLiteDatabase)) {
            cursor = openDatabase.query(InstabugDbContract.UserAttributesEntry.TABLE_NAME, strArr, "key LIKE ? AND uuid =? ", strArr2, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, strArr, "key LIKE ? AND uuid =? ", strArr2, (String) null, (String) null, (String) null);
        }
        if (cursor == null) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex("value");
        try {
            if (!cursor.moveToFirst()) {
                return null;
            }
            String string = cursor.getString(columnIndex);
            cursor.close();
            openDatabase.close();
            return string;
        } finally {
            cursor.close();
            openDatabase.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        if (r3 == null) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> retrieveAll(java.lang.String r12) {
        /*
            java.lang.String r0 = "value"
            java.lang.String r1 = "key"
            r2 = 0
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r3 = r3.openDatabase()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r5 = "user_attributes_table"
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch:{ Exception -> 0x0070 }
            java.lang.String r7 = "uuid =? "
            r4 = 1
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0070 }
            r4 = 0
            r8[r4] = r12     // Catch:{ Exception -> 0x0070 }
            r9 = 0
            r10 = 0
            r11 = 0
            boolean r12 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0070 }
            if (r12 != 0) goto L_0x002e
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0035
        L_0x002e:
            r4 = r3
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x0070 }
            android.database.Cursor r12 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0070 }
        L_0x0035:
            r2 = r12
            if (r2 == 0) goto L_0x006a
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x0070 }
            r12.<init>()     // Catch:{ Exception -> 0x0070 }
            int r1 = r2.getColumnIndex(r1)     // Catch:{ Exception -> 0x0070 }
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x0070 }
            boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x0070 }
            if (r4 != 0) goto L_0x0052
            r2.close()
            r3.close()
            return r12
        L_0x0052:
            java.lang.String r4 = r2.getString(r1)     // Catch:{ Exception -> 0x0070 }
            java.lang.String r5 = r2.getString(r0)     // Catch:{ Exception -> 0x0070 }
            r12.put(r4, r5)     // Catch:{ Exception -> 0x0070 }
            boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x0070 }
            if (r4 != 0) goto L_0x0052
            r2.close()
            r3.close()
            return r12
        L_0x006a:
            if (r2 == 0) goto L_0x0085
            r2.close()
            goto L_0x0085
        L_0x0070:
            r12 = move-exception
            goto L_0x0077
        L_0x0072:
            r12 = move-exception
            r3 = r2
            goto L_0x008f
        L_0x0075:
            r12 = move-exception
            r3 = r2
        L_0x0077:
            java.lang.String r0 = "IBG-Core"
            java.lang.String r1 = "an exception has occurred while retrieving user attributes"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r1, r12)     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x0083
            r2.close()
        L_0x0083:
            if (r3 == 0) goto L_0x0088
        L_0x0085:
            r3.close()
        L_0x0088:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            return r12
        L_0x008e:
            r12 = move-exception
        L_0x008f:
            if (r2 == 0) goto L_0x0094
            r2.close()
        L_0x0094:
            if (r3 == 0) goto L_0x0099
            r3.close()
        L_0x0099:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper.retrieveAll(java.lang.String):java.util.HashMap");
    }

    public static HashMap<String, String> retrieveAllSDKAttributes(String str) {
        Cursor cursor;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {"key", "value"};
        String[] strArr2 = {str};
        if (!(openDatabase instanceof SQLiteDatabase)) {
            cursor = openDatabase.query(InstabugDbContract.UserAttributesEntry.TABLE_NAME, strArr, "uuid =?  AND type = 0", strArr2, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, strArr, "uuid =?  AND type = 0", strArr2, (String) null, (String) null, (String) null);
        }
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("key");
            int columnIndex2 = cursor.getColumnIndex("value");
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                if (!cursor.moveToFirst()) {
                    return hashMap;
                }
                do {
                    hashMap.put(cursor.getString(columnIndex), cursor.getString(columnIndex2));
                } while (cursor.moveToNext());
                cursor.close();
                openDatabase.close();
                return hashMap;
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "an exception has occurred while retrieving user attributes", e11);
            } finally {
                cursor.close();
                openDatabase.close();
            }
        }
        return new HashMap<>();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private static synchronized long update(l lVar) {
        int i11;
        long j11;
        synchronized (UserAttributesDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {lVar.b(), lVar.d()};
            openDatabase.beginTransaction();
            try {
                ContentValues contentValue = getContentValue(lVar);
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    i11 = openDatabase.update(InstabugDbContract.UserAttributesEntry.TABLE_NAME, contentValue, "key = ? AND uuid=?", strArr);
                } else {
                    i11 = SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.UserAttributesEntry.TABLE_NAME, contentValue, "key = ? AND uuid=?", strArr);
                }
                j11 = (long) i11;
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
        return j11;
    }
}
