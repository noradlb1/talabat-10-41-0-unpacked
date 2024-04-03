package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class r extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ t f51100g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(t tVar) {
        super(0);
        this.f51100g = tVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f51100g.d();
        boolean z11 = d11 instanceof SQLiteDatabase;
        if (!z11) {
            d11.execSQL("DROP TABLE IF EXISTS fatal_hangs_table");
        } else {
            SQLiteInstrumentation.execSQL(d11, "DROP TABLE IF EXISTS fatal_hangs_table");
        }
        if (!z11) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS fatal_hangs_table ( id TEXT,temporary_server_token TEXT,message TEXT,fatal_hang_state TEXT,state TEXT,main_thread_details TEXT,threads_details TEXT,last_activity TEXT,uuid TEXT DEFAULT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS fatal_hangs_table ( id TEXT,temporary_server_token TEXT,message TEXT,fatal_hang_state TEXT,state TEXT,main_thread_details TEXT,threads_details TEXT,last_activity TEXT,uuid TEXT DEFAULT NULL)");
        }
        if (!z11) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS session_table ( session_serial INTEGER PRIMARY KEY AUTOINCREMENT,session_id TEXT,foreground_start_time INTEGER,background_start_time INTEGER,nano_start_time INTEGER,duration INTEGER,user_attributes TEXT,user_events TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,users_page_enabled INTEGER,v2_session_sent INTEGER,sync_status TEXT,production_usage TEXT,stitching_state TEXT )");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS session_table ( session_serial INTEGER PRIMARY KEY AUTOINCREMENT,session_id TEXT,foreground_start_time INTEGER,background_start_time INTEGER,nano_start_time INTEGER,duration INTEGER,user_attributes TEXT,user_events TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,users_page_enabled INTEGER,v2_session_sent INTEGER,sync_status TEXT,production_usage TEXT,stitching_state TEXT )");
        }
        if (!z11) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS session_experiment_table ( id INTEGER PRIMARY KEY AUTOINCREMENT,experiment_array TEXT,session_serial INTEGER UNIQUE ,experiments_dropped_count INTEGER, CONSTRAINT session_serial_foreign_key FOREIGN KEY (session_serial) REFERENCES session_table(session_serial) ON DELETE CASCADE )");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS session_experiment_table ( id INTEGER PRIMARY KEY AUTOINCREMENT,experiment_array TEXT,session_serial INTEGER UNIQUE ,experiments_dropped_count INTEGER, CONSTRAINT session_serial_foreign_key FOREIGN KEY (session_serial) REFERENCES session_table(session_serial) ON DELETE CASCADE )");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
