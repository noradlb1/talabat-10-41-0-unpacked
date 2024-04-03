package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class h implements c {
    @VisibleForTesting
    public String a() {
        return "session_id,started_at,duration,user_events,user_attributes,user_events_keys,user_attributes_keys,user_email,uuid,user_name,os,app_token,device,sdk_version,app_version,crash_reporting_enabled,users_page_enabled,sync_status";
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "session_table_temp");
        a(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, "session_table_temp", a());
        b(sQLiteDatabase, InstabugDbContract.SessionEntry.TABLE_NAME);
        a(sQLiteDatabase, "session_table_temp", InstabugDbContract.SessionEntry.TABLE_NAME);
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
    public void a(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str) {
        String str2 = "CREATE TABLE IF NOT EXISTS " + str + " ( " + "session_id" + " TEXT" + "," + "started_at" + " INTEGER" + "," + "duration" + " INTEGER" + "," + "user_events" + " TEXT" + "," + "user_attributes" + " TEXT" + "," + InstabugDbContract.SessionEntry.COLUMN_USER_ATTRIBUTES_KEYS + " TEXT" + "," + InstabugDbContract.SessionEntry.COLUMN_USER_EVENTS_KEYS + " TEXT" + "," + InstabugDbContract.SessionEntry.COLUMN_USER_EMAIL + " TEXT" + "," + "uuid" + " TEXT" + "," + InstabugDbContract.SessionEntry.COLUMN_USER_NAME + " TEXT" + "," + "os" + " TEXT" + "," + InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN + " TEXT" + "," + "device" + " TEXT" + "," + "sdk_version" + " TEXT" + "," + "app_version" + " TEXT" + "," + "crash_reporting_enabled" + " INTEGER" + "," + InstabugDbContract.SessionEntry.COLUMN_USERS_PAGE_ENABLED + " INTEGER" + "," + "sync_status" + " INTEGER" + " )";
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
    }

    @VisibleForTesting
    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        String str4 = "INSERT INTO " + str2 + " SELECT " + str3 + " FROM " + str;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str4);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str4);
        }
    }

    @VisibleForTesting
    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String str3 = "ALTER TABLE " + str + " RENAME TO " + str2;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str3);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str3);
        }
    }
}
