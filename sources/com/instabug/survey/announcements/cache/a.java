package com.instabug.survey.announcements.cache;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public abstract class a {
    @WorkerThread
    public static synchronized long a(long j11, long j12, String str) {
        long insertWithOnConflict;
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ID, Long.valueOf(j12));
            contentValues.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ANNOUNCE_ID, Long.valueOf(j11));
            contentValues.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_FILE_PATH, str);
            insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.AnnouncementAssetsEntry.TABLE_NAME, (String) null, contentValues);
            if (insertWithOnConflict == -1) {
                b(j11, j12, str);
            }
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
        }
        return insertWithOnConflict;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r11 != null) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092  */
    @androidx.annotation.WorkerThread
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(long r10, long r12) {
        /*
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            java.lang.String r4 = "asset_id=?  AND announcement_item_id=? "
            r1 = 2
            java.lang.String[] r5 = new java.lang.String[r1]
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13 = 0
            r5[r13] = r12
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 1
            r5[r11] = r10
            r10 = 0
            java.lang.String r2 = "announcement_assets_table"
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            boolean r11 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0068, all -> 0x0066 }
            if (r11 != 0) goto L_0x0030
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0068, all -> 0x0066 }
            goto L_0x0037
        L_0x0030:
            r1 = r0
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ Exception -> 0x0068, all -> 0x0066 }
            android.database.Cursor r11 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0068, all -> 0x0066 }
        L_0x0037:
            if (r11 == 0) goto L_0x0063
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x005e, all -> 0x0059 }
            if (r12 != 0) goto L_0x0046
            r11.close()
            r0.close()
            return r10
        L_0x0046:
            java.lang.String r12 = "asset_path"
            int r12 = r11.getColumnIndex(r12)     // Catch:{ Exception -> 0x005e, all -> 0x0059 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x005e, all -> 0x0059 }
            if (r12 == 0) goto L_0x0063
            r11.close()
            r0.close()
            return r12
        L_0x0059:
            r10 = move-exception
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x0090
        L_0x005e:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x006a
        L_0x0063:
            if (r11 == 0) goto L_0x008a
            goto L_0x0087
        L_0x0066:
            r11 = move-exception
            goto L_0x0090
        L_0x0068:
            r11 = move-exception
            r12 = r10
        L_0x006a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r13.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "Retrieving assets path for announcement failed due to: "
            r13.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r1 = r11.getMessage()     // Catch:{ all -> 0x008e }
            r13.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "IBG-Surveys"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r11, r13, r1)     // Catch:{ all -> 0x008e }
            if (r12 == 0) goto L_0x008a
            r11 = r12
        L_0x0087:
            r11.close()
        L_0x008a:
            r0.close()
            return r10
        L_0x008e:
            r11 = move-exception
            r10 = r12
        L_0x0090:
            if (r10 == 0) goto L_0x0095
            r10.close()
        L_0x0095:
            r0.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.announcements.cache.a.a(long, long):java.lang.String");
    }

    @WorkerThread
    public static synchronized void a() {
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.AnnouncementAssetsEntry.TABLE_NAME, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementAssetsEntry.TABLE_NAME, (String) null, (String[]) null);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    @WorkerThread
    public static synchronized long b(long j11, long j12, String str) {
        long update;
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(j12)};
            openDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ID, Long.valueOf(j12));
            contentValues.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ANNOUNCE_ID, Long.valueOf(j11));
            contentValues.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_FILE_PATH, str);
            update = (long) (!(openDatabase instanceof SQLiteDatabase) ? openDatabase.update(InstabugDbContract.AnnouncementAssetsEntry.TABLE_NAME, contentValues, "asset_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementAssetsEntry.TABLE_NAME, contentValues, "asset_id=? ", strArr));
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
        }
        return update;
    }
}
