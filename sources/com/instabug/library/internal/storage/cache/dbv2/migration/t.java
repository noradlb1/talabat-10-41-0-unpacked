package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class t extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51102a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51103b = LazyKt__LazyJVMKt.lazy(new s(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51102a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new r(this));
    }

    @NotNull
    public b c() {
        return (b) this.f51103b.getValue();
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51102a;
    }

    public int e() {
        return 7;
    }
}
