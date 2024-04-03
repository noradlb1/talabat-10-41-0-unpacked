package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class u implements c {
    private String a() {
        return "session_id,started_at,duration,user_events,user_attributes,user_events_keys,user_attributes_keys,user_email,uuid,user_name,os,app_token,device,sdk_version,app_version,crash_reporting_enabled,users_page_enabled,sync_status,stitched_session_lead";
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            if (!a(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE)) {
                a(sQLiteDatabase, "session_table_temp");
                a(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, "session_table_temp", a());
                b(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME);
                b(sQLiteDatabase, "session_table_temp", InstabugDbContract.SessionEntry.TABLE_NAME);
            }
        } catch (Exception unused) {
            b(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME);
            a(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME);
        }
    }

    @VisibleForTesting
    public void b(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "DROP TABLE IF EXISTS " + str;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
    }

    @VisibleForTesting
    public void b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String str3 = "ALTER TABLE " + str + " RENAME TO " + str2;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str3);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str3);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "CREATE TABLE IF NOT EXISTS " + str + " ( " + "session_id" + " TEXT, " + "started_at" + " INTEGER, " + "duration" + " INTEGER, " + "user_events" + " TEXT, " + "user_attributes" + " TEXT, " + InstabugDbContract.SessionEntry.COLUMN_USER_ATTRIBUTES_KEYS + " TEXT, " + InstabugDbContract.SessionEntry.COLUMN_USER_EVENTS_KEYS + " TEXT, " + InstabugDbContract.SessionEntry.COLUMN_USER_EMAIL + " TEXT, " + "uuid" + " TEXT, " + InstabugDbContract.SessionEntry.COLUMN_USER_NAME + " TEXT, " + "os" + " TEXT, " + InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN + " TEXT, " + "device" + " TEXT, " + "sdk_version" + " TEXT, " + "app_version" + " TEXT, " + "crash_reporting_enabled" + " INTEGER, " + InstabugDbContract.SessionEntry.COLUMN_USERS_PAGE_ENABLED + " INTEGER, " + "sync_status" + " INTEGER, " + InstabugDbContract.SessionEntry.COLUMN_PRODUCTION_USAGE + " TEXT DEFAULT \"\", " + "stitched_session_lead" + " INTEGER )";
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
    }

    @VisibleForTesting
    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        String str4 = "INSERT INTO " + str2 + "(" + str3 + ") SELECT " + str3 + " FROM " + str;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str4);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r1 == null) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.database.sqlite.SQLiteDatabase r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            r2.<init>()     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            r2.append(r6)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            java.lang.String r6 = " LIMIT 0"
            r2.append(r6)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            boolean r3 = r5 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            if (r3 != 0) goto L_0x0023
            android.database.Cursor r5 = r5.rawQuery(r6, r2)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            goto L_0x0027
        L_0x0023:
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r5, r6, r2)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
        L_0x0027:
            r1 = r5
            int r5 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0039, all -> 0x0032 }
            r6 = -1
            if (r5 == r6) goto L_0x003b
            r5 = 1
            r0 = r5
            goto L_0x003b
        L_0x0032:
            r5 = move-exception
            if (r1 == 0) goto L_0x0038
            r1.close()
        L_0x0038:
            throw r5
        L_0x0039:
            if (r1 == 0) goto L_0x003e
        L_0x003b:
            r1.close()
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.db.migrations.u.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }
}
