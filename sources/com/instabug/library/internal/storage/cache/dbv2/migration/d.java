package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.diagnostics.nonfatals.cache.NonFatalCacheManager;
import com.instabug.library.internal.storage.DiskUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class d extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ e f51082g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
        super(0);
        this.f51082g = eVar;
    }

    public final void a() {
        DiskUtils.deleteStateFiles(NonFatalCacheManager.NON_FATAL_STATE);
        SQLiteDatabase d11 = this.f51082g.d();
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("DROP TABLE IF EXISTS non_fatal");
        } else {
            SQLiteInstrumentation.execSQL(d11, "DROP TABLE IF EXISTS non_fatal");
        }
        SQLiteDatabase d12 = this.f51082g.d();
        if (!(d12 instanceof SQLiteDatabase)) {
            d12.execSQL("DROP TABLE IF EXISTS non_fatal_occurrence");
        } else {
            SQLiteInstrumentation.execSQL(d12, "DROP TABLE IF EXISTS non_fatal_occurrence");
        }
        SQLiteDatabase d13 = this.f51082g.d();
        if (!(d13 instanceof SQLiteDatabase)) {
            d13.execSQL("CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
        } else {
            SQLiteInstrumentation.execSQL(d13, "CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
        }
        SQLiteDatabase d14 = this.f51082g.d();
        if (!(d14 instanceof SQLiteDatabase)) {
            d14.execSQL("CREATE TABLE IF NOT EXISTS non_fatal_occurrence ( id INTEGER PRIMARY KEY AUTOINCREMENT,reported_at INTEGER,state_file TEXT,non_fatal_id INTEGER, CONSTRAINT non_fatal_id, FOREIGN KEY (non_fatal_id) REFERENCES non_fatal(id) ON DELETE CASCADE )");
        } else {
            SQLiteInstrumentation.execSQL(d14, "CREATE TABLE IF NOT EXISTS non_fatal_occurrence ( id INTEGER PRIMARY KEY AUTOINCREMENT,reported_at INTEGER,state_file TEXT,non_fatal_id INTEGER, CONSTRAINT non_fatal_id, FOREIGN KEY (non_fatal_id) REFERENCES non_fatal(id) ON DELETE CASCADE )");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
