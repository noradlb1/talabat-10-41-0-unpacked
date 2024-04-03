package com.huawei.hms.dtm.core;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.dtm.core.util.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
abstract class L implements O {
    public void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
            }
        } catch (SQLException unused) {
            Logger.warn("doExecSQL SQLException.");
        }
    }
}
