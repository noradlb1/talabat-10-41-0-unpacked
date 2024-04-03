package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class r implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("ALTER TABLE surveys_table ADD COLUMN isDismissible BOOLEAN DEFAULT 1");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE surveys_table ADD COLUMN isDismissible BOOLEAN DEFAULT 1");
        }
    }
}
