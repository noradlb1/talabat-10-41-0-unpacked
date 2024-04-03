package com.instabug.library.internal.storage.cache.dbv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.internal.storage.cache.dbv2.migration.a0;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class a extends SQLiteOpenHelper {
    public a(@Nullable Context context) {
        super(context, "instabug_encrypted.db", (SQLiteDatabase.CursorFactory) null, 9);
        getReadableDatabase();
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a0.b(sQLiteDatabase);
    }

    @WorkerThread
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        a0.c(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @WorkerThread
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        a0.a(sQLiteDatabase, i11);
    }
}
