package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.DiskUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class x extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ z f51108g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(z zVar) {
        super(0);
        this.f51108g = zVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f51108g.d();
        boolean z11 = d11 instanceof SQLiteDatabase;
        if (!z11) {
            d11.execSQL("DROP TABLE IF EXISTS terminations_table");
        } else {
            SQLiteInstrumentation.execSQL(d11, "DROP TABLE IF EXISTS terminations_table");
        }
        DiskUtils.deleteAppTerminationsStateFiles();
        if (!z11) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS terminations_table ( id INTEGER,temporary_server_token TEXT,termination_state TEXT,state TEXT,uuid TEXT DEFAULT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS terminations_table ( id INTEGER,temporary_server_token TEXT,termination_state TEXT,state TEXT,uuid TEXT DEFAULT NULL)");
        }
        if (!z11) {
            d11.execSQL("DROP TABLE IF EXISTS non_fatal");
        } else {
            SQLiteInstrumentation.execSQL(d11, "DROP TABLE IF EXISTS non_fatal");
        }
        if (!z11) {
            d11.execSQL("DROP TABLE IF EXISTS non_fatal_occurrence");
        } else {
            SQLiteInstrumentation.execSQL(d11, "DROP TABLE IF EXISTS non_fatal_occurrence");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
