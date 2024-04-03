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
public final class c0 implements c {
    private final void b(SQLiteDatabase sQLiteDatabase) {
        String format = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT 0", Arrays.copyOf(new Object[]{InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_FRAGMENT_SPANS_COUNT, " INTEGER"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(format);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
        }
        String format2 = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT 0", Arrays.copyOf(new Object[]{InstabugDbContract.APMSessionMetaDataEntry.TABLE_NAME, InstabugDbContract.APMSessionMetaDataEntry.COLUMN_FRAGMENT_SPANS_DROPPED_COUNT, " INTEGER"}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        if (!z11) {
            sQLiteDatabase.execSQL(format2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format2);
        }
    }

    private final void c(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMFragmentEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMFragmentEntry.CREATE_TABLE_QUERY);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(InstabugDbContract.APMFragmentEventsEntry.CREATE_TABLE_QUERY);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, InstabugDbContract.APMFragmentEventsEntry.CREATE_TABLE_QUERY);
        }
    }

    public void a(@Nullable SQLiteDatabase sQLiteDatabase) {
        Object obj;
        if (sQLiteDatabase != null) {
            try {
                Result.Companion companion = Result.Companion;
                c(sQLiteDatabase);
                b(sQLiteDatabase);
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
                InstabugCore.reportError(r02, Intrinsics.stringPlus("Something went wrong while migrating to db version 39", message));
            }
            Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
            if (r03 != null) {
                String message2 = r03.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while migrating to db version 39", str), r03);
            }
            Result.m6328boximpl(obj);
        }
    }
}
