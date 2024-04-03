package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class f extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h f51084g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(h hVar) {
        super(0);
        this.f51084g = hVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f51084g.d();
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS bugs_table ( id TEXT PRIMARY KEY,temporary_server_token TEXT,type TEXT,message TEXT,state TEXT,bug_state TEXT,view_hierarchy TEXT,categories_list TEXT )");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS bugs_table ( id TEXT PRIMARY KEY,temporary_server_token TEXT,type TEXT,message TEXT,state TEXT,bug_state TEXT,view_hierarchy TEXT,categories_list TEXT )");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
