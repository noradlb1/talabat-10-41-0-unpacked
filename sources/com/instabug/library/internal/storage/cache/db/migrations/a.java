package com.instabug.library.internal.storage.cache.db.migrations;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f51033a;

    public a(@NonNull c... cVarArr) {
        this.f51033a = cVarArr;
    }

    public void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        c[] cVarArr = this.f51033a;
        if (cVarArr.length == 0) {
            new b().a(sQLiteDatabase);
            return;
        }
        for (c a11 : cVarArr) {
            a11.a(sQLiteDatabase);
        }
    }
}
