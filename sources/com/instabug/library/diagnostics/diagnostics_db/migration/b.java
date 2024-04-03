package com.instabug.library.diagnostics.diagnostics_db.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.internal.storage.cache.dbv2.migration.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f34278a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f34278a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new a(this));
    }

    @Nullable
    public com.instabug.library.internal.storage.cache.dbv2.migration.b c() {
        return null;
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f34278a;
    }

    public int e() {
        return 2;
    }
}
