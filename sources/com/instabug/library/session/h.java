package com.instabug.library.session;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.session.SessionLocalEntity;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import io.reactivex.Completable;
import java.util.Iterator;
import java.util.List;

@Instrumented
public class h {
    public Completable a(@NonNull SessionLocalEntity sessionLocalEntity) {
        return Completable.create(new f(this, sessionLocalEntity));
    }

    @WorkerThread
    public h b(@NonNull List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b((String) it.next());
        }
        return this;
    }

    @WorkerThread
    public void a() {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", 1);
        try {
            openDatabase.beginTransaction();
            String[] strArr = {String.valueOf(0)};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "sync_status = ? ", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "sync_status = ? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public void b(String str) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", 2);
        try {
            String[] strArr = {str};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "session_id = ? ", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "session_id = ? ", strArr);
            }
        } finally {
            openDatabase.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x020c  */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List b() {
        /*
            r33 = this;
            java.lang.String r0 = "stitched_session_lead"
            java.lang.String r1 = "production_usage"
            java.lang.String r2 = "users_page_enabled"
            java.lang.String r3 = "sync_status"
            java.lang.String r4 = "crash_reporting_enabled"
            java.lang.String r5 = "app_version"
            java.lang.String r6 = "sdk_version"
            java.lang.String r7 = "device"
            java.lang.String r8 = "os"
            java.lang.String r9 = "app_token"
            java.lang.String r10 = "uuid"
            java.lang.String r11 = "user_name"
            java.lang.String r12 = "user_email"
            java.lang.String r13 = "user_events_keys"
            java.lang.String r14 = "user_attributes_keys"
            java.lang.String r15 = "user_events"
            r16 = r0
            java.lang.String r0 = "user_attributes"
            r17 = r1
            java.lang.String r1 = "duration"
            r18 = r2
            java.lang.String r2 = "started_at"
            r19 = r3
            java.lang.String r3 = "session_id"
            r20 = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r21 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            r30 = r4
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r4 = r21.openDatabase()
            r21 = r5
            r5 = 1
            r31 = r6
            java.lang.String[] r6 = new java.lang.String[r5]
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r22 = 0
            r6[r22] = r5
            java.lang.String r23 = "session_table"
            r24 = 0
            java.lang.String r25 = "sync_status =? "
            r27 = 0
            r28 = 0
            r29 = 0
            boolean r5 = r4 instanceof android.database.sqlite.SQLiteDatabase
            if (r5 != 0) goto L_0x0075
            r22 = r4
            r26 = r6
            android.database.Cursor r5 = r22.query(r23, r24, r25, r26, r27, r28, r29)
            goto L_0x0087
        L_0x0075:
            r22 = r4
            android.database.sqlite.SQLiteDatabase r22 = (android.database.sqlite.SQLiteDatabase) r22
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r26 = r6
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x0087:
            if (r5 == 0) goto L_0x0206
            boolean r6 = r5.moveToFirst()     // Catch:{ Exception -> 0x01d8, all -> 0x01d4 }
            if (r6 == 0) goto L_0x0206
        L_0x008f:
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x01d8, all -> 0x01d4 }
            r6.<init>()     // Catch:{ Exception -> 0x01d8, all -> 0x01d4 }
            r22 = r4
            int r4 = r5.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r3, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x01d2 }
            long r23 = r5.getLong(r4)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Long r4 = java.lang.Long.valueOf(r23)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r2, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x01d2 }
            long r23 = r5.getLong(r4)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Long r4 = java.lang.Long.valueOf(r23)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r1, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r0, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r15, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r14)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r14, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r13, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r12, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r11)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r11, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r10)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r10, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r9, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r8)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r8, r4)     // Catch:{ Exception -> 0x01d2 }
            int r4 = r5.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r7, r4)     // Catch:{ Exception -> 0x01d2 }
            r23 = r0
            r4 = r31
            int r0 = r5.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r4, r0)     // Catch:{ Exception -> 0x01d2 }
            r0 = r21
            r21 = r1
            int r1 = r5.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r1 = r5.getString(r1)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x01d2 }
            r1 = r20
            r20 = r0
            int r0 = r5.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x01d2 }
            int r0 = r5.getInt(r0)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r1, r0)     // Catch:{ Exception -> 0x01d2 }
            r0 = r19
            r19 = r1
            int r1 = r5.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x01d2 }
            int r1 = r5.getInt(r1)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x01d2 }
            r1 = r18
            r18 = r0
            int r0 = r5.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x01d2 }
            int r0 = r5.getInt(r0)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r1, r0)     // Catch:{ Exception -> 0x01d2 }
            r0 = r17
            r17 = r1
            int r1 = r5.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r1 = r5.getString(r1)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x01d2 }
            r1 = r16
            r16 = r0
            int r0 = r5.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x01d2 }
            int r0 = r5.getInt(r0)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01d2 }
            r6.put(r1, r0)     // Catch:{ Exception -> 0x01d2 }
            com.instabug.library.model.session.SessionLocalEntity r0 = com.instabug.library.model.session.SessionMapper.toLocalEntity(r6)     // Catch:{ Exception -> 0x01d2 }
            r6 = r30
            r6.add(r0)     // Catch:{ Exception -> 0x01d0 }
            boolean r0 = r5.moveToNext()     // Catch:{ Exception -> 0x01d0 }
            if (r0 != 0) goto L_0x01b6
            goto L_0x020a
        L_0x01b6:
            r31 = r4
            r30 = r6
            r4 = r22
            r0 = r23
            r32 = r16
            r16 = r1
            r1 = r21
            r21 = r20
            r20 = r19
            r19 = r18
            r18 = r17
            r17 = r32
            goto L_0x008f
        L_0x01d0:
            r0 = move-exception
            goto L_0x01dd
        L_0x01d2:
            r0 = move-exception
            goto L_0x01db
        L_0x01d4:
            r0 = move-exception
            r22 = r4
            goto L_0x01ff
        L_0x01d8:
            r0 = move-exception
            r22 = r4
        L_0x01db:
            r6 = r30
        L_0x01dd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fe }
            r1.<init>()     // Catch:{ all -> 0x01fe }
            java.lang.String r2 = "Retrieve ready for sync sessions failed: "
            r1.append(r2)     // Catch:{ all -> 0x01fe }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x01fe }
            r1.append(r2)     // Catch:{ all -> 0x01fe }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01fe }
            java.lang.String r2 = "IBG-Core"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r0, r1, r2)     // Catch:{ all -> 0x01fe }
            r5.close()
            r22.close()
            goto L_0x0212
        L_0x01fe:
            r0 = move-exception
        L_0x01ff:
            r5.close()
            r22.close()
            throw r0
        L_0x0206:
            r22 = r4
            r6 = r30
        L_0x020a:
            if (r5 == 0) goto L_0x020f
            r5.close()
        L_0x020f:
            r22.close()
        L_0x0212:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.session.h.b():java.util.List");
    }

    public Completable a(@NonNull String str, @NonNull String str2) {
        return Completable.create(new g(this, str2, str));
    }

    public void a(@NonNull List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a((String) it.next());
        }
    }

    public void a(String str) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.SessionEntry.TABLE_NAME, "session_id = ? ", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, "session_id = ? ", strArr);
            }
        } finally {
            openDatabase.close();
        }
    }
}
