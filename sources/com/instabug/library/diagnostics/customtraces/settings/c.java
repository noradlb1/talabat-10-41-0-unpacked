package com.instabug.library.diagnostics.customtraces.settings;

import com.instabug.library.diagnostics.configuration.a;
import com.instabug.library.settings.f;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f34239a = new c();

    private c() {
    }

    public void a(@Nullable JSONObject jSONObject) {
        Unit unit;
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("custom_traces")) == null) {
            unit = null;
        } else {
            com.instabug.library.percentagefeatures.a.a("custom_traces", optJSONObject.optDouble("enabled", 0.0d));
            com.instabug.library.percentagefeatures.a.a("record_sdk_launch_trace", optJSONObject.optDouble("record_sdk_launch_trace", 0.0d));
            com.instabug.library.percentagefeatures.a.a("record_sdk_feature_trace", optJSONObject.optDouble("record_sdk_feature_trace", 0.0d));
            b.f34237a.a(optJSONObject);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            f s11 = f.s();
            if (s11 != null) {
                s11.a("custom_traces");
            }
            f s12 = f.s();
            if (s12 != null) {
                s12.a("record_sdk_launch_trace");
            }
            f s13 = f.s();
            if (s13 != null) {
                s13.a("record_sdk_feature_trace");
            }
            b.f34237a.c();
            com.instabug.library.diagnostics.customtraces.di.a.d().clearCache();
        }
    }
}
