package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class m implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(InstabugDbContract.ExperimentsEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.ExperimentsEntry.CREATE_TABLE_QUERY);
        }
    }
}
