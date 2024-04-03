package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class n implements c {
    private String a() {
        return "anr_id,anr_main_thread_data,anr_rest_of_threads_data,anr_upload_state,temporary_server_token,state";
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("Alter TABLE session_table ADD COLUMN production_usage TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "Alter TABLE session_table ADD COLUMN production_usage TEXT");
        }
        a(sQLiteDatabase, "anrs_table_temp");
        a(sQLiteDatabase, InstabugDbContract.AnrEntry.TABLE_NAME, "anrs_table_temp", a());
        b(sQLiteDatabase, InstabugDbContract.AnrEntry.TABLE_NAME);
        a(sQLiteDatabase, "anrs_table_temp", InstabugDbContract.AnrEntry.TABLE_NAME);
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

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "CREATE TABLE IF NOT EXISTS " + str + " ( " + InstabugDbContract.AnrEntry.COLUMN_ID + " TEXT, " + InstabugDbContract.AnrEntry.COLUMN_ANR_MAIN_THREAD_DATA + " TEXT, " + InstabugDbContract.AnrEntry.COLUMN_ANR_REST_OF_THREADS_DATA + " TEXT, " + InstabugDbContract.AnrEntry.COLUMN_ANR_UPLOAD_STATE + " INTEGER, " + "temporary_server_token" + " TEXT, " + "state" + " TEXT, " + InstabugDbContract.AnrEntry.COLUMN_ANR_LONG_MESSAGE + " TEXT DEFAULT \"\")";
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
