package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static z0 f48957a;

    private static synchronized z0 a() {
        z0 z0Var;
        synchronized (a.class) {
            if (f48957a == null) {
                f48957a = q.c().b();
            }
            z0Var = f48957a;
        }
        return z0Var;
    }

    public static void a(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() != null && q1.b().a()) {
            if (i11 == 1 || i11 == 0) {
                f48957a.a(i11, str, linkedHashMap);
                return;
            }
            v.d("hmsSdk", "Data type no longer collects range.type: " + i11);
        }
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f48957a.a(context, str, str2);
        }
    }

    public static void b(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() != null && q1.b().a()) {
            if (i11 == 1 || i11 == 0) {
                f48957a.b(i11, str, linkedHashMap);
                return;
            }
            v.d("hmsSdk", "Data type no longer collects range.type: " + i11);
        }
    }

    public static boolean b() {
        return q.c().a();
    }

    public static void c() {
        if (a() != null && q1.b().a()) {
            f48957a.a(-1);
        }
    }
}
