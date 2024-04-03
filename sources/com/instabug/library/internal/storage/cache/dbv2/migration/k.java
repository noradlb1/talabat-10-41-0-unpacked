package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class k extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51090a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51091b = LazyKt__LazyJVMKt.lazy(new j(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51090a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new i(this));
    }

    @Nullable
    public b c() {
        return (b) this.f51091b.getValue();
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51090a;
    }

    public int e() {
        return 4;
    }
}
