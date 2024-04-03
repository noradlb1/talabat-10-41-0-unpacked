package com.instabug.library.diagnostics.sdkEvents.cache;

import android.database.sqlite.SQLiteStatement;
import com.instabug.library.diagnostics.sdkEvents.models.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class d extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a f34327g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(1);
        this.f34327g = aVar;
    }

    @Nullable
    /* renamed from: a */
    public final Long invoke(@NotNull SQLiteStatement sQLiteStatement) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "$this$execPreparedSQL");
        sQLiteStatement.bindString(1, this.f34327g.b());
        sQLiteStatement.bindString(2, this.f34327g.b());
        sQLiteStatement.bindString(3, String.valueOf(this.f34327g.a()));
        return Long.valueOf(sQLiteStatement.executeInsert());
    }
}
