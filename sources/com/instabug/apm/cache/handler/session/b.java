package com.instabug.apm.cache.handler.session;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.apm.cache.model.f;
import com.instabug.apm.di.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
class b implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f45147a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f45148b;

    public b(e eVar, f fVar) {
        this.f45148b = eVar;
        this.f45147a = fVar;
    }

    /* renamed from: a */
    public Integer execute() {
        DatabaseManager v11 = a.v();
        if (v11 != null) {
            ContentValues g11 = this.f45148b.b(this.f45147a);
            SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
            try {
                String[] strArr = {this.f45147a.getId()};
                return Integer.valueOf(!(openDatabase instanceof SQLiteDatabase) ? openDatabase.update(InstabugDbContract.APMSessionEntry.TABLE_NAME, g11, "session_id = ?", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, g11, "session_id = ?", strArr));
            } catch (Exception e11) {
                com.instabug.apm.logger.internal.a i11 = this.f45148b.f45155b;
                i11.a("DB execution a sql failed: " + e11.getMessage(), e11);
                IBGDiagnostics.reportNonFatal(e11, "Error while updating session: " + e11.getMessage());
            } finally {
                openDatabase.close();
            }
        }
        return 0;
    }
}
