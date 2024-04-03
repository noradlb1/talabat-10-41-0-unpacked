package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class q extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51098a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51099b = LazyKt__LazyJVMKt.lazy(new p(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51098a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new o(this));
    }

    @Nullable
    public b c() {
        return (b) this.f51099b.getValue();
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51098a;
    }

    public int e() {
        return 6;
    }
}
