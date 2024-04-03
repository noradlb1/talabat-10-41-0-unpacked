package com.instabug.library.diagnostics.customtraces.network;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import com.instabug.library.diagnostics.customtraces.settings.b;
import com.instabug.library.diagnostics.mappers.a;
import com.instabug.library.networkv2.request.RequestParameter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a f34232a = com.instabug.library.diagnostics.customtraces.di.a.f34228a.e();

    private final com.instabug.library.diagnostics.customtraces.a c() {
        return com.instabug.library.diagnostics.customtraces.di.a.d();
    }

    @NotNull
    public Pair a() {
        JSONObject b11 = b();
        return TuplesKt.to(new RequestParameter("custom_traces", b11 == null ? new JSONObject() : b11), Boolean.valueOf(b11 == null));
    }

    @VisibleForTesting
    @Nullable
    public final JSONObject b() {
        boolean z11;
        List allTraces;
        boolean z12;
        com.instabug.library.diagnostics.customtraces.a c11 = c();
        com.instabug.library.diagnostics.customtraces.settings.a b11 = b.f34237a.b();
        if (b11 != null && b11.a()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            c11 = null;
        }
        if (c11 == null || (allTraces = c11.getAllTraces()) == null) {
            return null;
        }
        if (!(!allTraces.isEmpty())) {
            allTraces = null;
        }
        if (allTraces == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : allTraces) {
            if (((IBGCustomTrace) next).getDuration() != -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                arrayList.add(next);
            }
        }
        return this.f34232a.a(arrayList);
    }
}
