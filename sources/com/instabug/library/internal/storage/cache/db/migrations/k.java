package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class k implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.CREATE_TABLE);
        }
    }
}
