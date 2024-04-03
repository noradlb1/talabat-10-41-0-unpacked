package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.c;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class b0 implements c {
    private final void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkLogEntry.SQL_DELETE_ENTRIES);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkLogEntry.SQL_DELETE_ENTRIES);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.NetworkLogEntry.SQL_CREATE_NETWORK_LOGS);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NetworkLogEntry.SQL_CREATE_NETWORK_LOGS);
        }
    }

    public void a(@NotNull SQLiteDatabase sQLiteDatabase) {
        Object obj;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        if (!c.f51032a.a(sQLiteDatabase, InstabugDbContract.NetworkLogEntry.TABLE_NAME, InstabugDbContract.NetworkLogEntry.COLUMN_USER_MODIFIED)) {
            try {
                Result.Companion companion = Result.Companion;
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    sQLiteDatabase.execSQL("ALTER TABLE network_logs ADD COLUMN user_modified  BOOLEAN DEFAULT 0");
                } else {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE network_logs ADD COLUMN user_modified  BOOLEAN DEFAULT 0");
                }
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m6332exceptionOrNullimpl(obj) != null) {
                b(sQLiteDatabase);
            }
        }
    }
}
