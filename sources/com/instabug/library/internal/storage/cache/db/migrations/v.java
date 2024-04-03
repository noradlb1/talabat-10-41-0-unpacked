package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class v implements c {
    private void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE apm_network_log ADD COLUMN client_side_error_code INTEGER DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE apm_network_log ADD COLUMN client_side_error_code INTEGER DEFAULT 0");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE apm_network_log ADD COLUMN grpc_method_name TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE apm_network_log ADD COLUMN grpc_method_name TEXT");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE dangling_apm_network_log ADD COLUMN client_side_error_code INTEGER DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE dangling_apm_network_log ADD COLUMN client_side_error_code INTEGER DEFAULT 0");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE dangling_apm_network_log ADD COLUMN grpc_method_name TEXT");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE dangling_apm_network_log ADD COLUMN grpc_method_name TEXT");
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }
}
