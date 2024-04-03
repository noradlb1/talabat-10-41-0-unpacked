package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class t implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE session_table ADD COLUMN stitched_session_lead BOOLEAN DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE session_table ADD COLUMN stitched_session_lead BOOLEAN DEFAULT 0");
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiLoadingMetricEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiLoadingMetricEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMUiLoadingStageEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMUiLoadingStageEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE apm_network_log ADD COLUMN graph_ql_query_name TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE apm_network_log ADD COLUMN graph_ql_query_name TEXT");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE apm_network_log ADD COLUMN server_side_error_message TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE apm_network_log ADD COLUMN server_side_error_message TEXT");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE dangling_apm_network_log ADD COLUMN graph_ql_query_name TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE dangling_apm_network_log ADD COLUMN graph_ql_query_name TEXT");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE dangling_apm_network_log ADD COLUMN server_side_error_message TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE dangling_apm_network_log ADD COLUMN server_side_error_message TEXT");
        }
    }
}
