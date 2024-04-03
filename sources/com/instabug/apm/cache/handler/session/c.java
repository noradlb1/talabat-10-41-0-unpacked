package com.instabug.apm.cache.handler.session;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.apm.di.a;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
class c implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f45149a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f45150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45151c;

    public c(e eVar, int i11, long j11, String str) {
        this.f45149a = i11;
        this.f45150b = j11;
        this.f45151c = str;
    }

    /* renamed from: a */
    public Integer execute() {
        DatabaseManager v11 = a.v();
        if (v11 == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.APMSessionEntry.COLUMN_TERMINATION_CODE, Integer.valueOf(this.f45149a));
        contentValues.put("duration", Long.valueOf(this.f45150b));
        SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
        try {
            String[] strArr = {this.f45151c};
            return Integer.valueOf(!(openDatabase instanceof SQLiteDatabase) ? openDatabase.update(InstabugDbContract.APMSessionEntry.TABLE_NAME, contentValues, "core_session_id = ?", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, contentValues, "core_session_id = ?", strArr));
        } finally {
            openDatabase.close();
        }
    }
}
