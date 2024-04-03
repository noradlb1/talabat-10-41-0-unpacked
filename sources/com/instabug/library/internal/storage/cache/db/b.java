package com.instabug.library.internal.storage.cache.db;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.migrations.a;
import com.instabug.library.internal.storage.cache.db.migrations.a0;
import com.instabug.library.internal.storage.cache.db.migrations.b0;
import com.instabug.library.internal.storage.cache.db.migrations.c0;
import com.instabug.library.internal.storage.cache.db.migrations.d;
import com.instabug.library.internal.storage.cache.db.migrations.e;
import com.instabug.library.internal.storage.cache.db.migrations.f;
import com.instabug.library.internal.storage.cache.db.migrations.g;
import com.instabug.library.internal.storage.cache.db.migrations.h;
import com.instabug.library.internal.storage.cache.db.migrations.i;
import com.instabug.library.internal.storage.cache.db.migrations.j;
import com.instabug.library.internal.storage.cache.db.migrations.k;
import com.instabug.library.internal.storage.cache.db.migrations.l;
import com.instabug.library.internal.storage.cache.db.migrations.m;
import com.instabug.library.internal.storage.cache.db.migrations.n;
import com.instabug.library.internal.storage.cache.db.migrations.o;
import com.instabug.library.internal.storage.cache.db.migrations.p;
import com.instabug.library.internal.storage.cache.db.migrations.q;
import com.instabug.library.internal.storage.cache.db.migrations.r;
import com.instabug.library.internal.storage.cache.db.migrations.s;
import com.instabug.library.internal.storage.cache.db.migrations.t;
import com.instabug.library.internal.storage.cache.db.migrations.u;
import com.instabug.library.internal.storage.cache.db.migrations.v;
import com.instabug.library.internal.storage.cache.db.migrations.w;
import com.instabug.library.internal.storage.cache.db.migrations.x;
import com.instabug.library.internal.storage.cache.db.migrations.y;
import com.instabug.library.internal.storage.cache.db.migrations.z;
import com.instabug.library.util.InstabugSDKLogger;

abstract class b {
    private static void A(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 21:
                new a(new k(), new l(), new m()).a(sQLiteDatabase);
                return;
            case 22:
                new a(new l(), new m()).a(sQLiteDatabase);
                return;
            case 23:
                new m().a(sQLiteDatabase);
                break;
        }
        a(sQLiteDatabase, i11, i12);
    }

    private static void B(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 22:
                new a(new l(), new m(), new n()).a(sQLiteDatabase);
                return;
            case 23:
                new a(new m(), new n()).a(sQLiteDatabase);
                return;
            case 24:
                new n().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void C(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r()).a(sQLiteDatabase2);
                return;
            case 28:
                new r().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void a(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        InstabugSDKLogger.e("IBG-Core", "Did not migrate from v" + i11 + " to v" + i12 + ". Falling back to destructive migration");
        new com.instabug.library.internal.storage.cache.db.migrations.b().a(sQLiteDatabase);
    }

    public static void b(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        a(sQLiteDatabase, i11, i12);
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 >= 17 || i12 > 17) {
            try {
                InstabugSDKLogger.d("IBG-Core", "Migrating database from v" + i11 + " to v" + i12);
                switch (i12) {
                    case 14:
                        r(sQLiteDatabase, i11, i12);
                        return;
                    case 15:
                        s(sQLiteDatabase, i11, i12);
                        return;
                    case 16:
                        t(sQLiteDatabase, i11, i12);
                        return;
                    case 18:
                        u(sQLiteDatabase, i11, i12);
                        return;
                    case 19:
                        v(sQLiteDatabase, i11, i12);
                        return;
                    case 20:
                        w(sQLiteDatabase, i11, i12);
                        return;
                    case 21:
                        x(sQLiteDatabase, i11, i12);
                        return;
                    case 22:
                        y(sQLiteDatabase, i11, i12);
                        return;
                    case 23:
                        z(sQLiteDatabase, i11, i12);
                        return;
                    case 24:
                        A(sQLiteDatabase, i11, i12);
                        return;
                    case 25:
                        B(sQLiteDatabase, i11, i12);
                        return;
                    case 26:
                        o(sQLiteDatabase, i11, i12);
                        return;
                    case 27:
                        p(sQLiteDatabase, i11, i12);
                        return;
                    case 28:
                        q(sQLiteDatabase, i11, i12);
                        return;
                    case 29:
                        C(sQLiteDatabase, i11, i12);
                        return;
                    case 30:
                        d(sQLiteDatabase, i11, i12);
                        return;
                    case 31:
                        e(sQLiteDatabase, i11, i12);
                        return;
                    case 32:
                        f(sQLiteDatabase, i11, i12);
                        return;
                    case 33:
                        g(sQLiteDatabase, i11, i12);
                        return;
                    case 34:
                        h(sQLiteDatabase, i11, i12);
                        return;
                    case 35:
                        i(sQLiteDatabase, i11, i12);
                        return;
                    case 36:
                        j(sQLiteDatabase, i11, i12);
                        return;
                    case 37:
                        k(sQLiteDatabase, i11, i12);
                        return;
                    case 38:
                        l(sQLiteDatabase, i11, i12);
                        return;
                    case 39:
                        m(sQLiteDatabase, i11, i12);
                        return;
                    case 40:
                        n(sQLiteDatabase, i11, i12);
                        return;
                    default:
                        a(sQLiteDatabase, i11, i12);
                        return;
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", e11.getClass().getSimpleName(), e11);
                IBGDiagnostics.reportNonFatal(e11, "Error while running database migration from version: " + i11 + " to version: " + i12);
                a(sQLiteDatabase, i11, i12);
            }
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r(), new s()).a(sQLiteDatabase2);
                return;
            case 28:
                new a(new r(), new s()).a(sQLiteDatabase2);
                return;
            case 29:
                new s().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void e(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 28:
                new a(new r(), new s(), new t()).a(sQLiteDatabase2);
                return;
            case 29:
                new a(new s(), new t()).a(sQLiteDatabase2);
                return;
            case 30:
                new t().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void f(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 28:
                new a(new r(), new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 29:
                new a(new s(), new t(), new u()).a(sQLiteDatabase2);
                return;
            case 30:
                new a(new t(), new u()).a(sQLiteDatabase2);
                return;
            case 31:
                new u().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void g(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 28:
                new a(new r(), new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 29:
                new a(new s(), new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 30:
                new a(new t(), new u(), new v()).a(sQLiteDatabase2);
                return;
            case 31:
                new a(new u(), new v()).a(sQLiteDatabase2);
                return;
            case 32:
                new v().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void h(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 28:
                new a(new r(), new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 29:
                new a(new s(), new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 30:
                new a(new t(), new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 31:
                new a(new u(), new v(), new w()).a(sQLiteDatabase2);
                return;
            case 32:
                new a(new v(), new w()).a(sQLiteDatabase2);
                return;
            case 33:
                new w().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void i(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 27:
                new a(new q(), new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 28:
                new a(new r(), new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 29:
                new a(new s(), new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 30:
                new a(new t(), new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 31:
                new a(new u(), new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 32:
                new a(new v(), new w(), new x()).a(sQLiteDatabase2);
                return;
            case 33:
                new a(new w(), new x()).a(sQLiteDatabase2);
                return;
            case 34:
                new a(new x()).a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void j(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 >= 12 && i11 <= 34) {
            i(sQLiteDatabase, i11, i12);
            new y().a(sQLiteDatabase);
        } else if (i11 == 35) {
            new y().a(sQLiteDatabase);
        } else {
            a(sQLiteDatabase, i11, i12);
        }
    }

    private static void k(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 >= 12 && i11 <= 35) {
            j(sQLiteDatabase, i11, i12);
            new z().a(sQLiteDatabase);
        } else if (i11 == 36) {
            new z().a(sQLiteDatabase);
        } else {
            a(sQLiteDatabase, i11, i12);
        }
    }

    private static void l(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 >= 12 && i11 <= 36) {
            k(sQLiteDatabase, i11, i12);
            new a0().a(sQLiteDatabase);
        } else if (i11 == 37) {
            new a0().a(sQLiteDatabase);
        } else {
            a(sQLiteDatabase, i11, i12);
        }
    }

    private static void m(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 >= 12 && i11 <= 37) {
            l(sQLiteDatabase, i11, i12);
            new b0().a(sQLiteDatabase);
        } else if (i11 == 38) {
            new b0().a(sQLiteDatabase);
        } else {
            a(sQLiteDatabase, i11, i12);
        }
    }

    private static void n(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 >= 12 && i11 <= 37) {
            l(sQLiteDatabase, i11, i12);
            new b0().a(sQLiteDatabase);
        } else if (i11 == 39) {
            new c0().a(sQLiteDatabase);
        } else {
            a(sQLiteDatabase, i11, i12);
        }
    }

    private static void o(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 23:
                new a(new m(), new n(), new o()).a(sQLiteDatabase);
                return;
            case 24:
                new a(new n(), new o()).a(sQLiteDatabase);
                return;
            case 25:
                new o().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void p(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p()).a(sQLiteDatabase2);
                return;
            case 26:
                new p().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void q(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 20:
                new a(new j(), new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 21:
                new a(new k(), new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 22:
                new a(new l(), new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 23:
                new a(new m(), new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 24:
                new a(new n(), new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 25:
                new a(new o(), new p(), new q()).a(sQLiteDatabase2);
                return;
            case 26:
                new a(new p(), new q()).a(sQLiteDatabase2);
                return;
            case 27:
                new q().a(sQLiteDatabase2);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void r(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 == 12) {
            new d().a(sQLiteDatabase);
        } else {
            a(sQLiteDatabase, i11, i12);
        }
    }

    private static void s(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 == 12) {
            new a(new d(), new e()).a(sQLiteDatabase);
        } else if (i11 != 14) {
            a(sQLiteDatabase, i11, i12);
        } else {
            new e().a(sQLiteDatabase);
        }
    }

    private static void t(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 == 12) {
            new a(new d(), new e(), new f()).a(sQLiteDatabase);
        } else if (i11 == 14) {
            new a(new e(), new f()).a(sQLiteDatabase);
        } else if (i11 != 15) {
            a(sQLiteDatabase, i11, i12);
        } else {
            new f().a(sQLiteDatabase);
        }
    }

    private static void u(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 == 12) {
            new a(new d(), new e(), new f(), new g()).a(sQLiteDatabase);
        } else if (i11 == 17) {
            new g().a(sQLiteDatabase);
        } else if (i11 == 14) {
            new a(new e(), new f(), new g()).a(sQLiteDatabase);
        } else if (i11 != 15) {
            a(sQLiteDatabase, i11, i12);
        } else {
            new a(new f(), new g()).a(sQLiteDatabase);
        }
    }

    private static void v(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h()).a(sQLiteDatabase);
                return;
            case 18:
                new h().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void w(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i()).a(sQLiteDatabase);
                return;
            case 19:
                new i().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void x(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i(), new j()).a(sQLiteDatabase);
                return;
            case 19:
                new a(new i(), new j()).a(sQLiteDatabase);
                return;
            case 20:
                new j().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void y(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k()).a(sQLiteDatabase);
                return;
            case 19:
                new a(new i(), new j(), new k()).a(sQLiteDatabase);
                return;
            case 20:
                new a(new j(), new k()).a(sQLiteDatabase);
                return;
            case 21:
                new k().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }

    private static void z(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        switch (i11) {
            case 12:
                new a(new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 14:
                new a(new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 15:
                new a(new f(), new g(), new h(), new i(), new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 17:
                new a(new g(), new h(), new i(), new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 18:
                new a(new h(), new i(), new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 19:
                new a(new i(), new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 20:
                new a(new j(), new k(), new l()).a(sQLiteDatabase);
                return;
            case 21:
                new a(new k(), new l()).a(sQLiteDatabase);
                return;
            case 22:
                new l().a(sQLiteDatabase);
                return;
            default:
                a(sQLiteDatabase, i11, i12);
                return;
        }
    }
}
