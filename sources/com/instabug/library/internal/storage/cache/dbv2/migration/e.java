package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51083a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51083a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new d(this));
    }

    @Nullable
    public b c() {
        return null;
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51083a;
    }

    public int e() {
        return 2;
    }
}
