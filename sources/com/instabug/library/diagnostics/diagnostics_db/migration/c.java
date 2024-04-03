package com.instabug.library.diagnostics.diagnostics_db.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class c extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d f34279g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(0);
        this.f34279g = dVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f34279g.d();
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS diagnostics_custom_traces ( trace_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,start_time INTEGER,started_on_bg INTEGER,ended_on_bg INTEGER,duration INTEGER default -1 )");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS diagnostics_custom_traces ( trace_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,start_time INTEGER,started_on_bg INTEGER,ended_on_bg INTEGER,duration INTEGER default -1 )");
        }
        SQLiteDatabase d12 = this.f34279g.d();
        if (!(d12 instanceof SQLiteDatabase)) {
            d12.execSQL("CREATE TABLE IF NOT EXISTS custom_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES diagnostics_custom_traces(trace_id) ON DELETE CASCADE )");
        } else {
            SQLiteInstrumentation.execSQL(d12, "CREATE TABLE IF NOT EXISTS custom_traces_attributes ( attribute_id INTEGER PRIMARY KEY AUTOINCREMENT,trace_id INTEGER,attribute_key TEXT,attribute_value TEXT,CONSTRAINT trace_id FOREIGN KEY (trace_id) REFERENCES diagnostics_custom_traces(trace_id) ON DELETE CASCADE )");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
