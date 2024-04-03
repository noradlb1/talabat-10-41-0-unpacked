package com.instabug.anr.cache;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.anr.model.b;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.Attachment;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public abstract class a {
    public static synchronized long a(b bVar) {
        long insert;
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ANR_MAIN_THREAD_DATA, bVar.e());
                contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ANR_REST_OF_THREADS_DATA, bVar.f());
                contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ANR_UPLOAD_STATE, Integer.valueOf(bVar.a()));
                if (!(bVar.g() == null || bVar.g().getUri() == null)) {
                    contentValues.put("state", bVar.g().getUri().toString());
                }
                contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ID, bVar.c());
                contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ANR_LONG_MESSAGE, bVar.d());
                if (bVar.getMetadata().getUuid() != null) {
                    contentValues.put("uuid", bVar.getMetadata().getUuid());
                }
                for (Attachment attachment : bVar.b()) {
                    long insert2 = AttachmentsDbHelper.insert(attachment, bVar.c());
                    if (insert2 != -1) {
                        attachment.setId(insert2);
                    }
                }
                insert = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.AnrEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.AnrEntry.TABLE_NAME, (String) null, contentValues);
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
        return insert;
    }

    public static int b() {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        int queryNumEntries = (int) openDatabase.queryNumEntries(InstabugDbContract.AnrEntry.TABLE_NAME);
        openDatabase.close();
        return queryNumEntries;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00dd, code lost:
        if (r2 != null) goto L_0x0105;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010f A[SYNTHETIC, Splitter:B:44:0x010f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List a(android.content.Context r13) {
        /*
            java.lang.Class<com.instabug.anr.cache.a> r0 = com.instabug.anr.cache.a.class
            monitor-enter(r0)
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ all -> 0x0116 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()     // Catch:{ all -> 0x0116 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0116 }
            r11.<init>()     // Catch:{ all -> 0x0116 }
            r12 = 0
            java.lang.String r3 = "anrs_table"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "anr_id ASC"
            r10 = 0
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00e2 }
            if (r2 != 0) goto L_0x002b
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r2 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x0032
        L_0x002b:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x00e2 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00e2 }
        L_0x0032:
            if (r2 == 0) goto L_0x00dd
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            if (r3 == 0) goto L_0x00dd
        L_0x003a:
            java.lang.String r3 = "uuid"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            com.instabug.anr.model.b r4 = new com.instabug.anr.model.b     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            com.instabug.commons.models.IncidentMetadata r3 = com.instabug.commons.models.IncidentMetadata.Factory.create(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "anr_id"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "anr_main_thread_data"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.c(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "anr_rest_of_threads_data"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.d(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "anr_upload_state"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            int r3 = r2.getInt(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.a((int) r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "temporary_server_token"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.e(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "long_message"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.b(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r4.c()     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.util.ArrayList r3 = com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve((java.lang.String) r3, (com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r1)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            r4.a((java.util.List) r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = "state"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            if (r3 == 0) goto L_0x00b7
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            goto L_0x00b8
        L_0x00b7:
            r3 = r12
        L_0x00b8:
            com.instabug.library.model.State r3 = com.instabug.library.model.State.getState((android.content.Context) r13, (android.net.Uri) r3)     // Catch:{ OutOfMemoryError -> 0x00c0 }
            r4.a((com.instabug.library.model.State) r3)     // Catch:{ OutOfMemoryError -> 0x00c0 }
            goto L_0x00cd
        L_0x00c0:
            r3 = move-exception
            java.lang.String r5 = "Retrieving ANR state throws OOM"
            com.instabug.library.core.InstabugCore.reportError(r3, r5)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            java.lang.String r5 = "IBG-CR"
            java.lang.String r6 = "Retrieving ANR state throws OOM"
            com.instabug.library.util.InstabugSDKLogger.e(r5, r6, r3)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
        L_0x00cd:
            r11.add(r4)     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x00da, all -> 0x00d7 }
            if (r3 != 0) goto L_0x003a
            goto L_0x00dd
        L_0x00d7:
            r13 = move-exception
            r12 = r2
            goto L_0x010d
        L_0x00da:
            r13 = move-exception
            r12 = r2
            goto L_0x00e3
        L_0x00dd:
            if (r2 == 0) goto L_0x0108
            goto L_0x0105
        L_0x00e0:
            r13 = move-exception
            goto L_0x010d
        L_0x00e2:
            r13 = move-exception
        L_0x00e3:
            java.lang.String r2 = "IBG-CR"
            java.lang.String r3 = "Retrieve ANRs failed: "
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r13)     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r2.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r3 = " retrieve ANRs failed: "
            r2.append(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.String r3 = r13.getMessage()     // Catch:{ all -> 0x00e0 }
            r2.append(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e0 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r13, r2)     // Catch:{ all -> 0x00e0 }
            if (r12 == 0) goto L_0x0108
            r2 = r12
        L_0x0105:
            r2.close()     // Catch:{ all -> 0x0116 }
        L_0x0108:
            r1.close()     // Catch:{ all -> 0x0116 }
            monitor-exit(r0)
            return r11
        L_0x010d:
            if (r12 == 0) goto L_0x0112
            r12.close()     // Catch:{ all -> 0x0116 }
        L_0x0112:
            r1.close()     // Catch:{ all -> 0x0116 }
            throw r13     // Catch:{ all -> 0x0116 }
        L_0x0116:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.anr.cache.a.a(android.content.Context):java.util.List");
    }

    public static void a(String str, ContentValues contentValues) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.AnrEntry.TABLE_NAME, contentValues, "anr_id=? ", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.AnrEntry.TABLE_NAME, contentValues, "anr_id=? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static void a(String str) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.AnrEntry.TABLE_NAME, "anr_id=? ", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AnrEntry.TABLE_NAME, "anr_id=? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        if (r2 == null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (r2 == null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r2.close();
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List a() {
        /*
            java.lang.String r0 = "state"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.content.Context r2 = com.instabug.library.Instabug.getApplicationContext()
            if (r2 == 0) goto L_0x006a
            r2 = 0
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ Exception -> 0x0057 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r4 = r3.openDatabase()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = "anrs_table"
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0057 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            boolean r3 = r4 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0057 }
            if (r3 != 0) goto L_0x0032
            r3 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r5 = r6
            r6 = r7
            r7 = r3
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0039
        L_0x0032:
            r5 = r4
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5     // Catch:{ Exception -> 0x0057 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0057 }
        L_0x0039:
            if (r2 == 0) goto L_0x0052
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0057 }
            if (r3 == 0) goto L_0x0052
        L_0x0041:
            int r3 = r2.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0057 }
            r1.add(r3)     // Catch:{ Exception -> 0x0057 }
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0057 }
            if (r3 != 0) goto L_0x0041
        L_0x0052:
            if (r2 == 0) goto L_0x006a
            goto L_0x0060
        L_0x0055:
            r0 = move-exception
            goto L_0x0064
        L_0x0057:
            java.lang.String r0 = "IBG-CR"
            java.lang.String r3 = "Error while getting ANRs state files"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r3)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x006a
        L_0x0060:
            r2.close()
            goto L_0x006a
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            throw r0
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.anr.cache.a.a():java.util.List");
    }
}
