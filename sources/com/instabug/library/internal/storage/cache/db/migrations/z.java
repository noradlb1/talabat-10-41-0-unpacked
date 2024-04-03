package com.instabug.library.internal.storage.cache.db.migrations;

import android.content.ContentValues;
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
public final class z implements c {
    private final void b(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.DROP_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.DROP_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.CREATE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.CREATE_TABLE);
        }
    }

    public void a(@NotNull SQLiteDatabase sQLiteDatabase) {
        Object obj;
        int i11;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        if (!c.f51032a.a(sQLiteDatabase, InstabugDbContract.CrashEntry.TABLE_NAME, "level")) {
            try {
                Result.Companion companion = Result.Companion;
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    sQLiteDatabase.execSQL("ALTER TABLE crashes_table ADD COLUMN level INTEGER DEFAULT NULL");
                } else {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE crashes_table ADD COLUMN level INTEGER DEFAULT NULL");
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("level", 2);
                Unit unit = Unit.INSTANCE;
                String[] strArr = {"1"};
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    i11 = sQLiteDatabase.update(InstabugDbContract.CrashEntry.TABLE_NAME, contentValues, "handled = ?", strArr);
                } else {
                    i11 = SQLiteInstrumentation.update(sQLiteDatabase, InstabugDbContract.CrashEntry.TABLE_NAME, contentValues, "handled = ?", strArr);
                }
                obj = Result.m6329constructorimpl(Integer.valueOf(i11));
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
