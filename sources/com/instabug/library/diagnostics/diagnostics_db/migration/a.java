package com.instabug.library.diagnostics.diagnostics_db.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class a extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ b f34277g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(0);
        this.f34277g = bVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f34277g.d();
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
        }
        SQLiteDatabase d12 = this.f34277g.d();
        if (!(d12 instanceof SQLiteDatabase)) {
            d12.execSQL("CREATE TABLE IF NOT EXISTS non_fatal_occurrence ( id INTEGER PRIMARY KEY AUTOINCREMENT,reported_at INTEGER,state_file TEXT,non_fatal_id INTEGER, CONSTRAINT non_fatal_id, FOREIGN KEY (non_fatal_id) REFERENCES non_fatal(id) ON DELETE CASCADE )");
        } else {
            SQLiteInstrumentation.execSQL(d12, "CREATE TABLE IF NOT EXISTS non_fatal_occurrence ( id INTEGER PRIMARY KEY AUTOINCREMENT,reported_at INTEGER,state_file TEXT,non_fatal_id INTEGER, CONSTRAINT non_fatal_id, FOREIGN KEY (non_fatal_id) REFERENCES non_fatal(id) ON DELETE CASCADE )");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
