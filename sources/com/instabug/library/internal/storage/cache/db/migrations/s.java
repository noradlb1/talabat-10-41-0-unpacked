package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class s implements c {
    private void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.BugEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.BugEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.CREATE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NDKCrashEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NDKCrashEntry.CREATE_TABLE);
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.BugEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.BugEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NDKCrashEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NDKCrashEntry.DROP_TABLE);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
        b(sQLiteDatabase);
        a();
    }

    private void a() {
        DiskUtils.deleteCrashStateFiles();
    }
}
