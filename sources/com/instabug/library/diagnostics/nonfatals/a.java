package com.instabug.library.diagnostics.nonfatals;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;

public abstract class a {
    public static boolean a(com.instabug.library.diagnostics.nonfatals.model.a aVar, @Nullable Set set) {
        if (aVar == null || aVar.b() == null) {
            return false;
        }
        if (b(aVar.b())) {
            return true;
        }
        if (set == null) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (a((com.instabug.library.diagnostics.nonfatals.model.a) it.next(), aVar)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public static boolean b(String str) {
        if (str.startsWith("java.net") || str.startsWith("javax.net") || str.startsWith("com.instabug.library.networkv2")) {
            return true;
        }
        return false;
    }

    private static boolean a(com.instabug.library.diagnostics.nonfatals.model.a aVar, com.instabug.library.diagnostics.nonfatals.model.a aVar2) {
        String c11 = aVar.c();
        String a11 = aVar.a();
        String g11 = aVar.g();
        String b11 = aVar.b();
        boolean z11 = b11 != null && b11.equals(aVar2.b());
        boolean z12 = a11 == null || a11.equals(aVar2.a());
        boolean z13 = c11 == null || c11.equals(aVar2.c());
        boolean z14 = g11 == null || g11.equals(aVar2.g());
        if (!z11 || !z12 || !z13 || !z14) {
            return false;
        }
        return true;
    }
}
