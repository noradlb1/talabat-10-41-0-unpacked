package com.instabug.library.diagnostics.nonfatals.networking.mapping;

import com.instabug.library.diagnostics.mappers.a;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.internal.resolver.d;
import com.instabug.library.networkv2.request.RequestParameter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

public final class c implements a {
    private final com.instabug.library.diagnostics.nonfatals.settings.a b() {
        return d.a().b();
    }

    private final JSONArray c() {
        boolean z11;
        List a11;
        List list;
        e d11 = d();
        com.instabug.library.diagnostics.nonfatals.settings.a b11 = b();
        if (b11 != null && b11.d()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            d11 = null;
        }
        if (d11 == null || (a11 = d11.a()) == null || (list = CollectionsKt___CollectionsKt.toList(a11)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            List h11 = ((com.instabug.library.diagnostics.nonfatals.model.a) next).h();
            Intrinsics.checkNotNullExpressionValue(h11, "nonFatal.occurrences");
            if (!h11.isEmpty()) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        return e().a(arrayList);
    }

    private final e d() {
        return com.instabug.library.diagnostics.nonfatals.di.a.g();
    }

    private final a e() {
        a d11 = com.instabug.library.diagnostics.nonfatals.di.a.d();
        Intrinsics.checkNotNullExpressionValue(d11, "getNonFatalMapper()");
        return d11;
    }

    @NotNull
    public Pair a() {
        JSONArray jSONArray;
        boolean z11;
        JSONArray c11 = c();
        if (c11 == null) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = c11;
        }
        RequestParameter requestParameter = new RequestParameter("non_fatals", jSONArray);
        if (c11 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return TuplesKt.to(requestParameter, Boolean.valueOf(z11));
    }
}
