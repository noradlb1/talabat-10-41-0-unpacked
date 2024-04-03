package com.huawei.hms.dtm.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class N extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private O f48365a = new S();

    /* renamed from: b  reason: collision with root package name */
    private O f48366b = new P();

    /* renamed from: c  reason: collision with root package name */
    private volatile SQLiteDatabase f48367c;

    public N(Context context) {
        super(context, "dtm_report.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public SQLiteDatabase getWritableDatabase() {
        if (this.f48367c == null) {
            this.f48367c = super.getWritableDatabase();
        }
        return this.f48367c;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f48365a.b(sQLiteDatabase);
        this.f48366b.b(sQLiteDatabase);
        this.f48365a.a(sQLiteDatabase);
        this.f48366b.a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
