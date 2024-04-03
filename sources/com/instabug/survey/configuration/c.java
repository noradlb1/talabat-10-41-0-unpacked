package com.instabug.survey.configuration;

import com.instabug.library.core.InstabugCore;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f52374a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f52375b = LazyKt__LazyJVMKt.lazy(b.f52373a);

    private c() {
    }

    private final d a() {
        return (d) f52375b.getValue();
    }

    private final JSONObject a(JSONObject jSONObject) {
        a().b(jSONObject.optBoolean("announcements", false));
        return jSONObject;
    }

    private final JSONObject b(JSONObject jSONObject) {
        a().a(jSONObject.optBoolean("surveys", false));
        return jSONObject;
    }

    private final JSONObject c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("product_usage_exceeded");
        boolean z11 = false;
        if (optJSONObject != null) {
            z11 = optJSONObject.optBoolean("surveys", false);
        }
        a().c(z11);
        return jSONObject;
    }

    public boolean a(@Nullable String str) {
        if (str == null) {
            return false;
        }
        try {
            JSONObject b11 = b(new JSONObject(str));
            if (b11 == null) {
                return false;
            }
            JSONObject a11 = a(b11);
            if (a11 == null) {
                return false;
            }
            return c(a11) != null;
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "couldn't parse surveys feature flags ");
            return false;
        }
    }
}
