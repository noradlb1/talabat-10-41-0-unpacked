package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.VisibleForTesting;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.core.InstabugCore;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f51080a = new a0();

    private a0() {
    }

    @JvmStatic
    public static final void a(@Nullable SQLiteDatabase sQLiteDatabase, int i11) {
        if (sQLiteDatabase != null) {
            try {
                f51080a.a(sQLiteDatabase).a(i11);
            } catch (Exception e11) {
                new c(sQLiteDatabase).c();
                InstabugCore.reportError(e11, Intrinsics.stringPlus("Couldn't run migration on DB version ", Integer.valueOf(i11)));
            }
        }
    }

    @JvmStatic
    public static final void b(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        new c(sQLiteDatabase).a();
    }

    @JvmStatic
    public static final void c(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        new c(sQLiteDatabase).c();
    }

    @NotNull
    @VisibleForTesting
    public final z a(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "it");
        return new z(sQLiteDatabase);
    }
}
