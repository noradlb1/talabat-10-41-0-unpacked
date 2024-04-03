package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class q implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.DanglingNetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.DanglingNetworkTracesAttributesEntry.CREATE_TABLE_QUERY);
        }
    }
}
