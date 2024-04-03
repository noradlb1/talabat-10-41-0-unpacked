package com.instabug.library.internal.storage.cache.db.migrations;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class w implements c {
    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public void a(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        if (sQLiteDatabase != null) {
            try {
                query = SQLiteInstrumentation.query(sQLiteDatabase, InstabugDbContract.BugEntry.TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
                if (query != null) {
                    if (query.getCount() > 0) {
                        query.close();
                        return;
                    }
                }
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.BugEntry.DROP_TABLE);
                if (query != null) {
                    query.close();
                    return;
                }
                return;
            } catch (Exception unused) {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.BugEntry.DROP_TABLE);
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            return;
        }
        throw th;
    }
}
