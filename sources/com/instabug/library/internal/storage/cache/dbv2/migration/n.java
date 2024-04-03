package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class n extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51094a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51095b = LazyKt__LazyJVMKt.lazy(new m(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51094a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new l(this));
    }

    @Nullable
    public b c() {
        return (b) this.f51095b.getValue();
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51094a;
    }

    public int e() {
        return 5;
    }
}
