package com.instabug.library.diagnostics.diagnostics_db.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.internal.storage.cache.dbv2.migration.a;
import com.instabug.library.internal.storage.cache.dbv2.migration.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f34280a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f34280a = sQLiteDatabase;
    }

    public void a() {
        b((Function0) new c(this));
    }

    @Nullable
    public b c() {
        return new b(d());
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f34280a;
    }

    public int e() {
        return 3;
    }
}
