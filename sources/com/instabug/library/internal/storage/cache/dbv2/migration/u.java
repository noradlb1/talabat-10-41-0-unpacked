package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Instrumented
final class u extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ w f51104g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(w wVar) {
        super(0);
        this.f51104g = wVar;
    }

    public final void a() {
        SQLiteDatabase d11 = this.f51104g.d();
        w wVar = this.f51104g;
        wVar.a(d11);
        wVar.b(d11);
        if (!(d11 instanceof SQLiteDatabase)) {
            d11.execSQL("CREATE TABLE IF NOT EXISTS session_incident ( id INTEGER,session_id TEXT,incident_id TEXT,incident_type TEXT,validation_status INTEGER DEFAULT 0 )");
        } else {
            SQLiteInstrumentation.execSQL(d11, "CREATE TABLE IF NOT EXISTS session_incident ( id INTEGER,session_id TEXT,incident_id TEXT,incident_type TEXT,validation_status INTEGER DEFAULT 0 )");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
