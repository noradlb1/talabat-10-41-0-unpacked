package com.instabug.featuresrequest.cache;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.featuresrequest.models.d;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public abstract class a {
    public static synchronized long a(d dVar) {
        long insertWithOnConflictReplace;
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_ID, Long.valueOf(dVar.g()));
                contentValues.put("title", dVar.m());
                contentValues.put("description", dVar.e());
                contentValues.put("status", dVar.l().name());
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT, Integer.valueOf(dVar.i()));
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT, Integer.valueOf(dVar.b()));
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED, Boolean.valueOf(dVar.p()));
                contentValues.put("date", Long.valueOf(dVar.d()));
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE, dVar.a());
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME, dVar.c());
                contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED, dVar.n().name());
                insertWithOnConflictReplace = openDatabase.insertWithOnConflictReplace(InstabugDbContract.FeatureRequestEntry.TABLE_NAME, (String) null, contentValues);
                openDatabase.setTransactionSuccessful();
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception | OutOfMemoryError e11) {
                try {
                    IBGDiagnostics.reportNonFatal(e11, "Error while inserting feature-request to DB: " + e11.getMessage());
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflictReplace;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f4 A[SYNTHETIC, Splitter:B:21:0x00f4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List a() {
        /*
            java.lang.Class<com.instabug.featuresrequest.cache.a> r0 = com.instabug.featuresrequest.cache.a.class
            monitor-enter(r0)
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ all -> 0x012c }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()     // Catch:{ all -> 0x012c }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x012c }
            r11.<init>()     // Catch:{ all -> 0x012c }
            r12 = 0
            java.lang.String r3 = "feature_requests_table"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            if (r2 != 0) goto L_0x002b
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            goto L_0x0032
        L_0x002b:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
        L_0x0032:
            r12 = r2
            if (r12 == 0) goto L_0x00f2
            boolean r2 = r12.moveToFirst()     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            if (r2 == 0) goto L_0x00f2
        L_0x003b:
            com.instabug.featuresrequest.models.d r2 = new com.instabug.featuresrequest.models.d     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = com.instabug.library.user.UserManagerWrapper.getUserName()     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r4 = com.instabug.library.user.UserManagerWrapper.getUserEmail()     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r5 = com.instabug.library.core.InstabugCore.getPushNotificationToken()     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.<init>(r3, r4, r5)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            int r3 = r12.getInt(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            long r3 = (long) r3     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.b((long) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "title"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.d(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "description"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.c(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "status"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            com.instabug.featuresrequest.models.b r3 = com.instabug.featuresrequest.models.b.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.a((com.instabug.featuresrequest.models.b) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "likes_count"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            int r3 = r12.getInt(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.b((int) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "comments_count"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            int r3 = r12.getInt(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.a((int) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "liked"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            int r3 = r12.getInt(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r4 = 1
            if (r3 != r4) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            r2.a((boolean) r4)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "date"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            long r3 = r12.getLong(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.a((long) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "color_code"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.a((java.lang.String) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "creator_name"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.b((java.lang.String) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = "ib_user_vote_status"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            com.instabug.featuresrequest.models.c r3 = com.instabug.featuresrequest.models.c.valueOf(r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r2.a((com.instabug.featuresrequest.models.c) r3)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            r11.add(r2)     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            boolean r2 = r12.moveToNext()     // Catch:{ OutOfMemoryError -> 0x0100, Exception -> 0x00fe }
            if (r2 != 0) goto L_0x003b
        L_0x00f2:
            if (r12 == 0) goto L_0x00f7
            r12.close()     // Catch:{ all -> 0x012c }
        L_0x00f7:
            r1.close()     // Catch:{ all -> 0x012c }
            monitor-exit(r0)
            return r11
        L_0x00fc:
            r2 = move-exception
            goto L_0x0123
        L_0x00fe:
            r2 = move-exception
            goto L_0x0101
        L_0x0100:
            r2 = move-exception
        L_0x0101:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r3.<init>()     // Catch:{ all -> 0x00fc }
            java.lang.String r4 = "Error while getting feature requests from DB: "
            r3.append(r4)     // Catch:{ all -> 0x00fc }
            java.lang.String r4 = r2.getMessage()     // Catch:{ all -> 0x00fc }
            r3.append(r4)     // Catch:{ all -> 0x00fc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00fc }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r2, r3)     // Catch:{ all -> 0x00fc }
            if (r12 == 0) goto L_0x011e
            r12.close()     // Catch:{ all -> 0x012c }
        L_0x011e:
            r1.close()     // Catch:{ all -> 0x012c }
            monitor-exit(r0)
            return r11
        L_0x0123:
            if (r12 == 0) goto L_0x0128
            r12.close()     // Catch:{ all -> 0x012c }
        L_0x0128:
            r1.close()     // Catch:{ all -> 0x012c }
            throw r2     // Catch:{ all -> 0x012c }
        L_0x012c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.cache.a.a():java.util.List");
    }

    public static synchronized void a(String str) {
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.FeatureRequestEntry.TABLE_NAME, "_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.FeatureRequestEntry.TABLE_NAME, "_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception | OutOfMemoryError e11) {
                try {
                    IBGDiagnostics.reportNonFatal(e11, "Error while deleting feature-request: " + e11.getMessage());
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }
}
