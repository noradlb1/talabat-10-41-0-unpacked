package com.instabug.library.diagnostics.customtraces.settings;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.diagnostics.customtraces.di.a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.settings.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f34237a = new b();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static a f34238b;

    private b() {
    }

    @VisibleForTesting
    public final void a(@Nullable a aVar) {
        f34238b = aVar;
    }

    @Nullable
    public final a b() {
        boolean z11;
        boolean z12;
        if (f34238b == null) {
            f s11 = f.s();
            boolean z13 = false;
            if (s11 == null) {
                z11 = false;
            } else {
                z11 = s11.a("custom_traces", false);
            }
            int customTracesCount = SettingsManager.getInstance().getCustomTracesCount();
            f s12 = f.s();
            if (s12 == null) {
                z12 = false;
            } else {
                z12 = s12.a("record_sdk_launch_trace", false);
            }
            f s13 = f.s();
            if (s13 != null) {
                z13 = s13.a("record_sdk_feature_trace", false);
            }
            f34238b = new a(z11, customTracesCount, z12, z13);
        }
        a aVar = f34238b;
        if (aVar == null) {
            return new a(false, 0, false, false, 15, (DefaultConstructorMarker) null);
        }
        return aVar;
    }

    public final void c() {
        int i11;
        f34238b = new a(false, 0, false, false, 15, (DefaultConstructorMarker) null);
        f s11 = f.s();
        if (s11 != null) {
            s11.b("custom_traces", false);
        }
        f s12 = f.s();
        if (s12 != null) {
            s12.b("record_sdk_launch_trace", false);
        }
        f s13 = f.s();
        if (s13 != null) {
            s13.b("record_sdk_feature_trace", false);
        }
        SettingsManager instance = SettingsManager.getInstance();
        a b11 = b();
        if (b11 == null) {
            i11 = 15;
        } else {
            i11 = b11.b();
        }
        instance.saveCustomTracesCount(i11);
    }

    public final void a(@Nullable JSONObject jSONObject) {
        boolean z11;
        boolean z12;
        if (jSONObject != null) {
            b bVar = f34237a;
            f s11 = f.s();
            boolean z13 = false;
            if (s11 == null) {
                z11 = false;
            } else {
                z11 = s11.a("custom_traces", false);
            }
            int i11 = 15;
            int optInt = jSONObject.optInt("max_count", 15);
            f s12 = f.s();
            if (s12 == null) {
                z12 = false;
            } else {
                z12 = s12.a("record_sdk_launch_trace", false);
            }
            f s13 = f.s();
            if (s13 != null) {
                z13 = s13.a("record_sdk_feature_trace", false);
            }
            bVar.a(new a(z11, optInt, z12, z13));
            SettingsManager instance = SettingsManager.getInstance();
            a b11 = bVar.b();
            if (b11 != null) {
                i11 = b11.b();
            }
            instance.saveCustomTracesCount(i11);
            bVar.a();
        }
    }

    private final void a() {
        a b11 = b();
        boolean z11 = false;
        if (!(b11 != null && b11.a())) {
            a.d().clearCache();
        }
        a b12 = b();
        if (!(b12 != null && b12.c())) {
            a.d().a("record_sdk_feature_trace");
        }
        a b13 = b();
        if (b13 != null && b13.d()) {
            z11 = true;
        }
        if (!z11) {
            a.d().a("record_sdk_launch_trace");
        }
    }
}
