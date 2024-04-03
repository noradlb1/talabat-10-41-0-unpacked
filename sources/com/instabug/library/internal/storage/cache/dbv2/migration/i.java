package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class i extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ k f51088g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(k kVar) {
        super(0);
        this.f51088g = kVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f51088g.d();
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS fatal_hangs_table ( id TEXT,temporary_server_token TEXT,message TEXT,fatal_hang_state TEXT,state TEXT,main_thread_details TEXT,threads_details TEXT,last_activity TEXT,uuid TEXT DEFAULT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS fatal_hangs_table ( id TEXT,temporary_server_token TEXT,message TEXT,fatal_hang_state TEXT,state TEXT,main_thread_details TEXT,threads_details TEXT,last_activity TEXT,uuid TEXT DEFAULT NULL)");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
