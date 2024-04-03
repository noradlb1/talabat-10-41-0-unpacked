package com.instabug.bug.configurations;

import com.instabug.library.core.InstabugCore;
import kotlin.Lazy;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f45629a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f45630b = LazyKt__LazyJVMKt.lazy(b.f45628a);

    private c() {
    }

    private final d a() {
        return (d) f45630b.getValue();
    }

    private final void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("product_usage_exceeded");
        boolean z11 = false;
        if (optJSONObject != null) {
            z11 = optJSONObject.optBoolean("bug_reporting", false);
        }
        a().a(z11);
    }

    public boolean a(@Nullable String str) {
        if (str == null) {
            return false;
        }
        try {
            a(new JSONObject(str));
            Unit unit = Unit.INSTANCE;
            return true;
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "couldn't parse bug reporting feature flags ");
            return false;
        }
    }
}
