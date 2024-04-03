package com.tekartik.sqflite;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;

class Database {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12860a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12861b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12862c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12863d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteDatabase f12864e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12865f;

    public Database(String str, int i11, boolean z11, int i12) {
        this.f12861b = str;
        this.f12860a = z11;
        this.f12862c = i11;
        this.f12863d = i12;
    }

    public static void a(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public String b() {
        return "[" + c() + "] ";
    }

    public String c() {
        Thread currentThread = Thread.currentThread();
        return "" + this.f12862c + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public void close() {
        this.f12864e.close();
    }

    public boolean enableWriteAheadLogging() {
        try {
            return this.f12864e.enableWriteAheadLogging();
        } catch (Exception e11) {
            Log.e(Constant.TAG, b() + "enable WAL error: " + e11);
            return false;
        }
    }

    public SQLiteDatabase getReadableDatabase() {
        return this.f12864e;
    }

    public SQLiteDatabase getWritableDatabase() {
        return this.f12864e;
    }

    public void open() {
        this.f12864e = SQLiteDatabase.openDatabase(this.f12861b, (SQLiteDatabase.CursorFactory) null, 268435456);
    }

    public void openReadOnly() {
        this.f12864e = SQLiteDatabase.openDatabase(this.f12861b, (SQLiteDatabase.CursorFactory) null, 1, new DatabaseErrorHandler() {
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            }
        });
    }
}
