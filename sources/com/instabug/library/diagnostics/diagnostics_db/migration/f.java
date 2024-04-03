package com.instabug.library.diagnostics.diagnostics_db.migration;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.core.InstabugCore;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final f f34281a = new f();

    private f() {
    }

    @JvmStatic
    public static final void a(@Nullable SQLiteDatabase sQLiteDatabase, int i11) {
        Object obj;
        if (sQLiteDatabase != null) {
            try {
                Result.Companion companion = Result.Companion;
                f34281a.a(sQLiteDatabase).a(i11);
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
            if (r12 != null) {
                e.c(sQLiteDatabase);
                InstabugCore.reportError(r12, Intrinsics.stringPlus("Couldn't run migration on DB version ", Integer.valueOf(i11)));
            }
            Result.m6328boximpl(obj);
        }
    }

    @JvmStatic
    public static final void b(@Nullable SQLiteDatabase sQLiteDatabase) {
        e.a(sQLiteDatabase);
    }

    @JvmStatic
    public static final void c(@Nullable SQLiteDatabase sQLiteDatabase) {
        e.c(sQLiteDatabase);
    }

    private final d a(SQLiteDatabase sQLiteDatabase) {
        return new d(sQLiteDatabase);
    }
}
