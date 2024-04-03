package com.instabug.library.diagnostics.sdkEvents.cache;

import android.database.sqlite.SQLiteStatement;
import com.instabug.library.diagnostics.sdkEvents.models.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class f extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a f34329g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(a aVar) {
        super(1);
        this.f34329g = aVar;
    }

    @Nullable
    /* renamed from: a */
    public final Integer invoke(@NotNull SQLiteStatement sQLiteStatement) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "$this$execPreparedSQL");
        sQLiteStatement.bindString(1, String.valueOf(this.f34329g.a()));
        sQLiteStatement.bindString(2, String.valueOf(this.f34329g.a()));
        sQLiteStatement.bindString(3, this.f34329g.b());
        return Integer.valueOf(sQLiteStatement.executeUpdateDelete());
    }
}
