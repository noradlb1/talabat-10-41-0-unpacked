package com.instabug.library.diagnostics.diagnostics_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.WorkerThread;
import com.facebook.appevents.UserDataStore;
import com.instabug.library.diagnostics.diagnostics_db.migration.f;
import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
public final class b extends SQLiteOpenHelper {
    static {
        new a((DefaultConstructorMarker) null);
    }

    public b(@Nullable Context context) {
        super(context, "ibg_diagnostics.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    public void onConfigure(@Nullable SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        if (sQLiteDatabase != null) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
        }
    }

    public void onCreate(@Nullable SQLiteDatabase sQLiteDatabase) {
        f.b(sQLiteDatabase);
    }

    @WorkerThread
    public void onDowngrade(@Nullable SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        f.c(sQLiteDatabase);
    }

    public void onOpen(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        super.onOpen(sQLiteDatabase);
    }

    @WorkerThread
    public void onUpgrade(@Nullable SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        f.a(sQLiteDatabase, i11);
    }
}
