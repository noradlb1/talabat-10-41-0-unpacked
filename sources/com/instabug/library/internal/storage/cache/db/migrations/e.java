package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class e implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("ALTER TABLE user_attributes_table ADD COLUMN type INTEGER DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE user_attributes_table ADD COLUMN type INTEGER DEFAULT 0");
        }
    }
}
