package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class p implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("ALTER TABLE crashes_table ADD COLUMN threads_details TEXT");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE crashes_table ADD COLUMN threads_details TEXT");
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error in DB migration v 26 to 27", e11);
        }
    }
}
