package com.instabug.crash.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.WorkerThread;
import com.instabug.crash.models.a;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.model.Attachment;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.io.IOException;

@Instrumented
public abstract class b {
    public static synchronized long a(a aVar, SQLiteDatabaseWrapper sQLiteDatabaseWrapper) {
        long insert;
        synchronized (b.class) {
            sQLiteDatabaseWrapper.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                if (aVar.b() != null) {
                    contentValues.put(InstabugDbContract.CrashEntry.COLUMN_CRASH_MESSAGE, aVar.b());
                }
                contentValues.put("crash_state", aVar.c().name());
                contentValues.put(InstabugDbContract.CrashEntry.COLUMN_HANDLED, Boolean.valueOf(aVar.k()));
                if (!(aVar.h() == null || aVar.h().getUri() == null)) {
                    contentValues.put("state", aVar.h().getUri().toString());
                }
                if (aVar.i() != null) {
                    contentValues.put("temporary_server_token", aVar.i());
                }
                if (aVar.j() != null) {
                    contentValues.put(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS, aVar.j());
                }
                if (aVar.d() != null) {
                    contentValues.put("fingerprint", aVar.d());
                }
                if (aVar.f() != null) {
                    contentValues.put("level", Integer.valueOf(aVar.f().getSeverity()));
                }
                if (aVar.e() != null) {
                    contentValues.put(InstabugDbContract.CrashEntry.COLUMN_ID, aVar.e());
                    for (Attachment attachment : aVar.a()) {
                        attachment.setId(AttachmentsDbHelper.insert(attachment, aVar.e()));
                    }
                }
                if (aVar.getMetadata().getUuid() != null) {
                    contentValues.put("uuid", aVar.getMetadata().getUuid());
                }
                insert = !(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.insert(InstabugDbContract.CrashEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.CrashEntry.TABLE_NAME, (String) null, contentValues);
                sQLiteDatabaseWrapper.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-CR", "crash inserted to db successfully");
                sQLiteDatabaseWrapper.endTransaction();
                sQLiteDatabaseWrapper.close();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e("IBG-CR", "Error:" + e11.getMessage() + "while inserting crash ");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error while inserting crash");
                    sb2.append(e11.getMessage());
                    IBGDiagnostics.reportNonFatal(e11, sb2.toString());
                    return -1;
                } finally {
                    sQLiteDatabaseWrapper.endTransaction();
                    sQLiteDatabaseWrapper.close();
                }
            }
        }
        return insert;
    }

    public static synchronized int b() {
        int queryNumEntries;
        synchronized (b.class) {
            InstabugSDKLogger.v("IBG-CR", "getting Crashes Count");
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                queryNumEntries = (int) openDatabase.queryNumEntries(InstabugDbContract.CrashEntry.TABLE_NAME);
                openDatabase.close();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e("IBG-CR", "Error while getting crashes count: " + e11.getMessage(), e11);
                    IBGDiagnostics.reportNonFatal(e11, "Error while getting crashes count: " + e11.getMessage());
                    return 0;
                } finally {
                    openDatabase.close();
                }
            }
        }
        return queryNumEntries;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        r2.close();
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List c() {
        /*
            java.lang.String r0 = "state"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.content.Context r2 = com.instabug.library.Instabug.getApplicationContext()
            if (r2 == 0) goto L_0x006b
            r2 = 0
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ Exception -> 0x0057 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r4 = r3.openDatabase()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = "crashes_table"
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
            if (r2 == 0) goto L_0x006b
            goto L_0x0061
        L_0x0055:
            r0 = move-exception
            goto L_0x0065
        L_0x0057:
            r0 = move-exception
            java.lang.String r3 = "IBG-CR"
            java.lang.String r4 = "Error while getting crash state files"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r0)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x006b
        L_0x0061:
            r2.close()
            goto L_0x006b
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.close()
        L_0x006a:
            throw r0
        L_0x006b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.crash.cache.b.c():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ee, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011d A[SYNTHETIC, Splitter:B:62:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012c A[SYNTHETIC, Splitter:B:70:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized long b(com.instabug.crash.models.a r23) {
        /*
            java.lang.Class<com.instabug.crash.cache.b> r1 = com.instabug.crash.cache.b.class
            monitor-enter(r1)
            java.lang.String r0 = "IBG-CR"
            java.lang.String r2 = "Inserting crash to DB"
            com.instabug.library.util.InstabugSDKLogger.d(r0, r2)     // Catch:{ all -> 0x0135 }
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ all -> 0x0135 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()     // Catch:{ all -> 0x0135 }
            r11 = 0
            java.lang.String r3 = "crashes_table"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r2 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00fa, all -> 0x00f7 }
            if (r2 != 0) goto L_0x002d
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = r0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00fa, all -> 0x00f7 }
            goto L_0x0034
        L_0x002d:
            r2 = r0
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x00fa, all -> 0x00f7 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00fa, all -> 0x00f7 }
        L_0x0034:
            r12 = r2
            if (r12 == 0) goto L_0x00dd
            int r2 = r12.getCount()     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r12.close()     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r13 = r11
            r11 = r2
        L_0x0040:
            r2 = 100
            if (r11 < r2) goto L_0x00d9
            java.lang.String r2 = "IBG-CR"
            java.lang.String r3 = "Crashes reached limit, trimming"
            com.instabug.library.util.InstabugSDKLogger.w(r2, r3)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r15 = "crashes_table"
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            java.lang.String r21 = "crash_id ASC"
            java.lang.String r22 = "1"
            boolean r2 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            if (r2 != 0) goto L_0x006f
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r0
            r3 = r15
            r9 = r21
            r10 = r22
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            goto L_0x0076
        L_0x006f:
            r14 = r0
            android.database.sqlite.SQLiteDatabase r14 = (android.database.sqlite.SQLiteDatabase) r14     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
        L_0x0076:
            r13 = r2
            if (r13 == 0) goto L_0x0040
            boolean r2 = r13.moveToFirst()     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = "uuid"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            com.instabug.crash.models.a r3 = new com.instabug.crash.models.a     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            com.instabug.commons.models.IncidentMetadata r2 = com.instabug.commons.models.IncidentMetadata.Factory.create(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r2 = "crash_id"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            r3.c(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r2 = r3.e()     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            if (r2 == 0) goto L_0x00b0
            java.lang.String r2 = r3.e()     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.util.ArrayList r2 = com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve((java.lang.String) r2, (com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r0)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            r3.a((java.util.List) r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
        L_0x00b0:
            java.lang.String r2 = "state"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            b((android.net.Uri) r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            c(r3)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            java.lang.String r2 = r3.e()     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = r3.e()     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
            a((java.lang.String) r2)     // Catch:{ Exception -> 0x00d7, all -> 0x00d5 }
        L_0x00d1:
            int r11 = r11 + -1
            goto L_0x0040
        L_0x00d5:
            r0 = move-exception
            goto L_0x00f1
        L_0x00d7:
            r0 = move-exception
            goto L_0x00f5
        L_0x00d9:
            r2 = r23
            r11 = r13
            goto L_0x00df
        L_0x00dd:
            r2 = r23
        L_0x00df:
            long r2 = a((com.instabug.crash.models.a) r2, (com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r0)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            if (r12 == 0) goto L_0x00e8
            r12.close()     // Catch:{ all -> 0x0135 }
        L_0x00e8:
            if (r11 == 0) goto L_0x00ed
            r11.close()     // Catch:{ all -> 0x0135 }
        L_0x00ed:
            monitor-exit(r1)
            return r2
        L_0x00ef:
            r0 = move-exception
            r13 = r11
        L_0x00f1:
            r11 = r12
            goto L_0x012a
        L_0x00f3:
            r0 = move-exception
            r13 = r11
        L_0x00f5:
            r11 = r12
            goto L_0x00fc
        L_0x00f7:
            r0 = move-exception
            r13 = r11
            goto L_0x012a
        L_0x00fa:
            r0 = move-exception
            r13 = r11
        L_0x00fc:
            java.lang.String r2 = "IBG-CR"
            java.lang.String r3 = "Error while inserting crash to DB "
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r0)     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r2.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = "trimAndInsert crashes throwed an error: "
            r2.append(r3)     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0129 }
            r2.append(r3)     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0129 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r2)     // Catch:{ all -> 0x0129 }
            if (r11 == 0) goto L_0x0120
            r11.close()     // Catch:{ all -> 0x0135 }
        L_0x0120:
            if (r13 == 0) goto L_0x0125
            r13.close()     // Catch:{ all -> 0x0135 }
        L_0x0125:
            monitor-exit(r1)
            r0 = -1
            return r0
        L_0x0129:
            r0 = move-exception
        L_0x012a:
            if (r11 == 0) goto L_0x012f
            r11.close()     // Catch:{ all -> 0x0135 }
        L_0x012f:
            if (r13 == 0) goto L_0x0134
            r13.close()     // Catch:{ all -> 0x0135 }
        L_0x0134:
            throw r0     // Catch:{ all -> 0x0135 }
        L_0x0135:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.crash.cache.b.b(com.instabug.crash.models.a):long");
    }

    public static synchronized void c(a aVar) {
        synchronized (b.class) {
            for (Attachment attachment : aVar.a()) {
                if (!(attachment.getLocalPath() == null || attachment.getName() == null)) {
                    new File(attachment.getLocalPath()).delete();
                    if (attachment.getId() != -1) {
                        AttachmentsDbHelper.delete(attachment.getId());
                    } else if (aVar.e() != null) {
                        AttachmentsDbHelper.delete(attachment.getName(), aVar.e());
                    } else {
                        InstabugSDKLogger.e("IBG-CR", "Couldn't delete attachments: crash.getId() is null");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c3, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        com.instabug.library.core.InstabugCore.reportError(r5, "retrieving crash state throwed an error");
        com.instabug.library.util.InstabugSDKLogger.e("IBG-CR", "Retrieving crash state throws an exception: " + r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e6, code lost:
        if (r4 >= 3) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e8, code lost:
        b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ef, code lost:
        if (r3.e() != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f1, code lost:
        c(r3);
        a(r3.e());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fd, code lost:
        com.instabug.library.util.InstabugSDKLogger.e("IBG-CR", "Couldn't delete crash attachments: crash id was null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0182, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0183, code lost:
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0188, code lost:
        if (r2 != null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0182 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d9 A[SYNTHETIC, Splitter:B:67:0x01d9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List a(android.content.Context r13) {
        /*
            java.lang.Class<com.instabug.crash.cache.b> r0 = com.instabug.crash.cache.b.class
            monitor-enter(r0)
            java.lang.String r1 = "IBG-CR"
            java.lang.String r2 = "retrieving cached crashes"
            com.instabug.library.util.InstabugSDKLogger.v(r1, r2)     // Catch:{ all -> 0x01e0 }
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ all -> 0x01e0 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()     // Catch:{ all -> 0x01e0 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x01e0 }
            r11.<init>()     // Catch:{ all -> 0x01e0 }
            r12 = 0
            java.lang.String r3 = "crashes_table"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "crash_id ASC"
            r10 = 0
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x018d }
            if (r2 != 0) goto L_0x0032
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r2 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x018d }
            goto L_0x0039
        L_0x0032:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x018d }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x018d }
        L_0x0039:
            if (r2 == 0) goto L_0x0188
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r3 == 0) goto L_0x0188
        L_0x0041:
            java.lang.String r3 = "crash_id"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r3 != 0) goto L_0x0056
            java.lang.String r3 = "IBG-CR"
            java.lang.String r4 = "Couldn't add crash to retrieved list: crash id is null"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            goto L_0x017b
        L_0x0056:
            java.lang.String r4 = "uuid"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            com.instabug.crash.models.a$b r5 = new com.instabug.crash.models.a$b     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r5.<init>()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            com.instabug.commons.models.IncidentMetadata r4 = com.instabug.commons.models.IncidentMetadata.Factory.create(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            com.instabug.crash.models.a r3 = r5.a(r3, r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "crash_message"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "handled"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r5 = 1
            if (r4 == 0) goto L_0x0089
            r4 = r5
            goto L_0x008a
        L_0x0089:
            r4 = 0
        L_0x008a:
            r3.a((boolean) r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "retry_count"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r6 = r3.e()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r6 == 0) goto L_0x00a8
            java.lang.String r6 = r3.e()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.util.ArrayList r6 = com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve((java.lang.String) r6, (com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r1)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.a((java.util.List) r6)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
        L_0x00a8:
            java.lang.String r6 = "state"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r6 == 0) goto L_0x00b9
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            goto L_0x00ba
        L_0x00b9:
            r6 = r12
        L_0x00ba:
            int r4 = r4 + r5
            com.instabug.library.model.State r5 = com.instabug.library.model.State.getState((android.content.Context) r13, (android.net.Uri) r6)     // Catch:{ OutOfMemoryError -> 0x00c5, Exception -> 0x00c3, all -> 0x0182 }
            r3.a((com.instabug.library.model.State) r5)     // Catch:{ OutOfMemoryError -> 0x00c5, Exception -> 0x00c3, all -> 0x0182 }
            goto L_0x0105
        L_0x00c3:
            r5 = move-exception
            goto L_0x00c6
        L_0x00c5:
            r5 = move-exception
        L_0x00c6:
            java.lang.String r7 = "retrieving crash state throwed an error"
            com.instabug.library.core.InstabugCore.reportError(r5, r7)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r7 = "IBG-CR"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r8.<init>()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r9 = "Retrieving crash state throws an exception: "
            r8.append(r9)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r8.append(r5)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            com.instabug.library.util.InstabugSDKLogger.e(r7, r5)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r5 = 3
            if (r4 < r5) goto L_0x0105
            b((android.net.Uri) r6)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = r3.e()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r4 == 0) goto L_0x00fd
            c(r3)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r3 = r3.e()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            a((java.lang.String) r3)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            goto L_0x017b
        L_0x00fd:
            java.lang.String r3 = "IBG-CR"
            java.lang.String r4 = "Couldn't delete crash attachments: crash id was null"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            goto L_0x017b
        L_0x0105:
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r5.<init>()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r6 = "retry_count"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r6 = r3.e()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r6 == 0) goto L_0x0120
            java.lang.String r6 = r3.e()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            a((java.lang.String) r6, (android.content.ContentValues) r5)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
        L_0x0120:
            r3.b((int) r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "crash_state"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.Class<com.instabug.crash.models.a$a> r5 = com.instabug.crash.models.a.C0057a.class
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.Enum r4 = java.lang.Enum.valueOf(r5, r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            com.instabug.crash.models.a$a r4 = (com.instabug.crash.models.a.C0057a) r4     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.a((com.instabug.crash.models.a.C0057a) r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "temporary_server_token"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.d(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "threads_details"
            int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.e(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "fingerprint"
            int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.b((java.lang.String) r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            java.lang.String r4 = "level"
            int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            boolean r4 = r2.isNull(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r4 != 0) goto L_0x0178
            java.lang.String r4 = "level"
            int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            r3.a((int) r4)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
        L_0x0178:
            r11.add(r3)     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
        L_0x017b:
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0185, all -> 0x0182 }
            if (r3 != 0) goto L_0x0041
            goto L_0x0188
        L_0x0182:
            r13 = move-exception
            r12 = r2
            goto L_0x01d7
        L_0x0185:
            r13 = move-exception
            r12 = r2
            goto L_0x018e
        L_0x0188:
            if (r2 == 0) goto L_0x01b3
            goto L_0x01b0
        L_0x018b:
            r13 = move-exception
            goto L_0x01d7
        L_0x018d:
            r13 = move-exception
        L_0x018e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018b }
            r2.<init>()     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "Error: "
            r2.append(r3)     // Catch:{ all -> 0x018b }
            java.lang.String r3 = r13.getMessage()     // Catch:{ all -> 0x018b }
            r2.append(r3)     // Catch:{ all -> 0x018b }
            java.lang.String r3 = " while retreiving crashes"
            r2.append(r3)     // Catch:{ all -> 0x018b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "IBG-CR"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r13, r2, r3)     // Catch:{ all -> 0x018b }
            if (r12 == 0) goto L_0x01b3
            r2 = r12
        L_0x01b0:
            r2.close()     // Catch:{ all -> 0x01e0 }
        L_0x01b3:
            r1.close()     // Catch:{ all -> 0x01e0 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r13.<init>()     // Catch:{ all -> 0x01e0 }
            java.lang.String r1 = "retrieved "
            r13.append(r1)     // Catch:{ all -> 0x01e0 }
            int r1 = r11.size()     // Catch:{ all -> 0x01e0 }
            r13.append(r1)     // Catch:{ all -> 0x01e0 }
            java.lang.String r1 = " crashes from DB"
            r13.append(r1)     // Catch:{ all -> 0x01e0 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01e0 }
            java.lang.String r1 = "IBG-CR"
            com.instabug.library.util.InstabugSDKLogger.v(r1, r13)     // Catch:{ all -> 0x01e0 }
            monitor-exit(r0)
            return r11
        L_0x01d7:
            if (r12 == 0) goto L_0x01dc
            r12.close()     // Catch:{ all -> 0x01e0 }
        L_0x01dc:
            r1.close()     // Catch:{ all -> 0x01e0 }
            throw r13     // Catch:{ all -> 0x01e0 }
        L_0x01e0:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.crash.cache.b.a(android.content.Context):java.util.List");
    }

    @WorkerThread
    public static void b(Uri uri) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            try {
                DiskUtils.with(applicationContext).deleteOperation(new DeleteUriDiskOperation(uri)).execute();
            } catch (IOException unused) {
            }
        }
    }

    public static synchronized void a(String str, ContentValues contentValues) {
        synchronized (b.class) {
            InstabugSDKLogger.v("IBG-CR", "Updating crash " + str);
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.CrashEntry.TABLE_NAME, contentValues, "crash_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.CrashEntry.TABLE_NAME, contentValues, "crash_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static synchronized void a(String str) {
        synchronized (b.class) {
            InstabugSDKLogger.v("IBG-CR", "delete crash: " + str);
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.CrashEntry.TABLE_NAME, "crash_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.CrashEntry.TABLE_NAME, "crash_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static synchronized void a() {
        synchronized (b.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.CrashEntry.TABLE_NAME, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.CrashEntry.TABLE_NAME, (String) null, (String[]) null);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "deleteAll crashes throwed an error: " + e11.getMessage(), "IBG-CR");
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
