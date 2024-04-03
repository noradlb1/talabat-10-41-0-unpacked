package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class h extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51086a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51087b = LazyKt__LazyJVMKt.lazy(new g(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51086a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new f(this));
    }

    @Nullable
    public b c() {
        return (b) this.f51087b.getValue();
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51086a;
    }

    public int e() {
        return 3;
    }
}
