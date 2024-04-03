package com.instabug.library.diagnostics.nonfatals;

import com.instabug.library.Feature;
import com.instabug.library.diagnostics.configuration.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class d implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final com.instabug.library.internal.resolver.d f34298a;

    public d() {
        this((com.instabug.library.internal.resolver.d) null, 1, (DefaultConstructorMarker) null);
    }

    public d(@NotNull com.instabug.library.internal.resolver.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "settingsResolver");
        this.f34298a = dVar;
    }

    public void a(@Nullable JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("non_fatalsv3")) != null) {
            com.instabug.library.percentagefeatures.a.a(Feature.NON_FATAL_ERRORS.name(), optJSONObject.optDouble("enabled", 0.0d));
            this.f34298a.b(optJSONObject);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ d(com.instabug.library.internal.resolver.d r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            com.instabug.library.internal.resolver.d r1 = com.instabug.library.internal.resolver.d.a()
            java.lang.String r2 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.nonfatals.d.<init>(com.instabug.library.internal.resolver.d, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
