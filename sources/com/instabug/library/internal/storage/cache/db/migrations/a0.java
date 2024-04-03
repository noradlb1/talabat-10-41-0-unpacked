package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Instrumented
public final class a0 implements c {
    private final void b(SQLiteDatabase sQLiteDatabase) {
        String format = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT NULL", Arrays.copyOf(new Object[]{InstabugDbContract.AnrEntry.TABLE_NAME, "uuid", " TEXT"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(format);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
        }
    }

    private final void c(SQLiteDatabase sQLiteDatabase) {
        String format = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT NULL", Arrays.copyOf(new Object[]{InstabugDbContract.CrashEntry.TABLE_NAME, "uuid", " TEXT"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(format);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
        }
    }

    private final void d(SQLiteDatabase sQLiteDatabase) {
        String format = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT NULL", Arrays.copyOf(new Object[]{InstabugDbContract.NDKCrashEntry.TABLE_NAME, "uuid", " TEXT"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(format);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
        }
    }

    private final Object e(SQLiteDatabase sQLiteDatabase) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.APMSessionEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionEntry.DELETE_ALL);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.APMSessionEntry.DROP_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionEntry.DROP_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.APMSessionEntry.CREATE_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMSessionEntry.CREATE_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.DROP_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.DROP_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.CREATE_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.AnrEntry.CREATE_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.DROP_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.DROP_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.CREATE_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.CrashEntry.CREATE_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.NDKCrashEntry.DROP_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NDKCrashEntry.DROP_TABLE);
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(InstabugDbContract.NDKCrashEntry.CREATE_TABLE);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.NDKCrashEntry.CREATE_TABLE);
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus("something went wrong while failing back and dropping apm data", message));
        }
        Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
        if (r03 != null) {
            String message2 = r03.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("something went wrong while failing back and dropping apm data", str), r03);
        }
        return obj;
    }

    public void a(@Nullable SQLiteDatabase sQLiteDatabase) {
        Object obj;
        if (sQLiteDatabase != null) {
            try {
                Result.Companion companion = Result.Companion;
                b(sQLiteDatabase);
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE apm_session_table ADD COLUMN core_session_version  TEXT DEFAULT 'V2'");
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
            String str = "";
            if (r12 != null) {
                String message = r12.getMessage();
                if (message == null) {
                    message = str;
                }
                InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while migrating database to 38 and adding core session version to apm session", message));
            }
            Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
            if (r13 != null) {
                String message2 = r13.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while migrating database to 38 and adding core session version to apm session", str), r13);
            }
            if (Result.m6332exceptionOrNullimpl(obj) != null) {
                Result.m6328boximpl(e(sQLiteDatabase));
            }
        }
    }
}
