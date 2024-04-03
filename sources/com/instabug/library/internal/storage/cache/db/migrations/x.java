package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.jetbrains.annotations.Nullable;

@Instrumented
public final class x implements c {
    public void a(@Nullable SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMExperimentEntry.CREATE_TABLE_QUERY);
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE apm_session_meta_data ADD COLUMN experiments_total_count  INTEGER DEFAULT 0");
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SDKApiEntry.DROP_TABLE);
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.SDKEventEntry.DROP_TABLE);
        }
    }
}
