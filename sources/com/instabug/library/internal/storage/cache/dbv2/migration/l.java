package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class l extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ n f51092g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(n nVar) {
        super(0);
        this.f51092g = nVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f51092g.d();
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("DELETE FROM non_fatal_occurrence");
        } else {
            SQLiteInstrumentation.execSQL(d11, "DELETE FROM non_fatal_occurrence");
        }
        SQLiteDatabase d12 = this.f51092g.d();
        if (!(d12 instanceof SQLiteDatabase)) {
            d12.execSQL("DROP TABLE IF EXISTS non_fatal");
        } else {
            SQLiteInstrumentation.execSQL(d12, "DROP TABLE IF EXISTS non_fatal");
        }
        SQLiteDatabase d13 = this.f51092g.d();
        if (!(d13 instanceof SQLiteDatabase)) {
            d13.execSQL("CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
        } else {
            SQLiteInstrumentation.execSQL(d13, "CREATE TABLE IF NOT EXISTS non_fatal ( id INTEGER PRIMARY KEY AUTOINCREMENT,exception_type TEXT,declaring_class TEXT,file_name TEXT,method_name TEXT,message TEXT,stackTrace TEXT,line_number INTEGER,priority INTEGER DEFAULT 0)");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
