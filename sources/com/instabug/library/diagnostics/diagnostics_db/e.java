package com.instabug.library.diagnostics.diagnostics_db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class e extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34247g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1 f34248h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, Function1 function1) {
        super(1);
        this.f34247g = str;
        this.f34248h = function1;
    }

    @Nullable
    /* renamed from: a */
    public final Object invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(this.f34247g);
        if (compileStatement == null) {
            return null;
        }
        return this.f34248h.invoke(compileStatement);
    }
}
