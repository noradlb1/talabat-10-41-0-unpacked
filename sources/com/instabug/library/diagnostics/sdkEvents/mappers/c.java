package com.instabug.library.diagnostics.sdkEvents.mappers;

import com.instabug.library.diagnostics.mappers.a;
import com.instabug.library.networkv2.request.RequestParameter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

public final class c implements a {
    private final JSONArray b() {
        List b11;
        boolean z11;
        com.instabug.library.diagnostics.sdkEvents.cache.a d11 = d();
        if (!c().isEnabled()) {
            d11 = null;
        }
        if (d11 == null || (b11 = d11.b()) == null) {
            return null;
        }
        if (b11.isEmpty()) {
            b11 = null;
        }
        if (b11 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : b11) {
            if (((com.instabug.library.diagnostics.sdkEvents.models.a) next).a() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return b.a((List) arrayList);
    }

    private final com.instabug.library.diagnostics.sdkEvents.configurations.a c() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.c();
    }

    private final com.instabug.library.diagnostics.sdkEvents.cache.a d() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.e();
    }

    @NotNull
    public Pair a() {
        JSONArray jSONArray;
        boolean z11;
        Pair pair;
        synchronized ("sdk_events") {
            JSONArray b11 = b();
            if (b11 == null) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = b11;
            }
            RequestParameter requestParameter = new RequestParameter("sdk_events", jSONArray);
            if (b11 == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            pair = TuplesKt.to(requestParameter, Boolean.valueOf(z11));
        }
        return pair;
    }
}
