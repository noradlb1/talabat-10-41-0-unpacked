package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class a implements b {
    public a(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
    }

    private final boolean b(int i11) {
        return e() > i11;
    }

    public abstract void a();

    public final void a(int i11) {
        if (b(i11)) {
            b c11 = c();
            if (c11 != null) {
                c11.a(i11);
            }
            a();
        }
    }

    @Nullable
    public abstract b c();

    public abstract int e();

    public final void b(@NotNull Function0 function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function0, "logic");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(function0.invoke());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            String format = String.format("Error while migrating to DB version: %d}", Arrays.copyOf(new Object[]{Integer.valueOf(e())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            InstabugSDKLogger.e("IBG-Core", format, r52);
            throw r52;
        }
    }
}
