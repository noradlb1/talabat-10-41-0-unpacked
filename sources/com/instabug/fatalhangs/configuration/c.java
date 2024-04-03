package com.instabug.fatalhangs.configuration;

import com.google.android.exoplayer2.ExoPlayer;
import com.instabug.commons.configurations.a;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f46456a = LazyKt__LazyJVMKt.lazy(b.f46455a);

    static {
        new a((DefaultConstructorMarker) null);
    }

    private final d b() {
        return (d) this.f46456a.getValue();
    }

    private final long c(JSONObject jSONObject) {
        return jSONObject.optLong("sensitivity_ms", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    private final boolean d(JSONObject jSONObject) {
        return jSONObject.optBoolean("enabled");
    }

    public void a(@Nullable String str) {
        if (!b(str)) {
            b().a(((Boolean) com.instabug.crash.a.f46376a.c().getSecond()).booleanValue());
        }
    }

    private final boolean b(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            if (str != null) {
                JSONObject a11 = a(new JSONObject(str));
                if (a11 != null) {
                    JSONObject b11 = b(a11);
                    if (b11 != null) {
                        boolean d11 = d(b11);
                        long c11 = c(b11);
                        d b12 = b();
                        b12.a(d11);
                        b12.a(Math.max(c11, 1000));
                        return true;
                    }
                }
            }
            obj = Result.m6329constructorimpl((Object) null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        String str2 = "";
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = str2;
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus("Something went wrong while parsing Fatal hangs from features response ", message));
        }
        Throwable r62 = Result.m6332exceptionOrNullimpl(obj);
        if (r62 == null) {
            return false;
        }
        String message2 = r62.getMessage();
        if (message2 != null) {
            str2 = message2;
        }
        InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while parsing Fatal hangs from features response ", str2), r62);
        return false;
    }

    private final boolean c() {
        Pair g11 = com.instabug.crash.a.f46376a.g();
        boolean booleanValue = ((Boolean) g11.component2()).booleanValue();
        return com.instabug.commons.utils.c.f46365a.a((String) g11.component1(), booleanValue, "instabug_crash");
    }

    private final void d() {
        com.instabug.commons.utils.c.f46365a.b((String) com.instabug.crash.a.f46376a.g().getFirst(), true, "instabug_crash");
    }

    private final JSONObject a(JSONObject jSONObject) {
        return jSONObject.optJSONObject("crashes");
    }

    public void a() {
        if ((!c() ? this : null) != null) {
            d b11 = b();
            if (Instabug.getApplicationContext() != null) {
                b11.a(com.instabug.commons.utils.c.f46365a.a("FATAL_HANGSAVAIL", ((Boolean) com.instabug.crash.a.f46376a.c().getSecond()).booleanValue(), SettingsManager.INSTABUG_SHARED_PREF_NAME));
                d();
                b11.a(SettingsManager.getFatalHangsSensitivity());
            }
        }
    }

    private final JSONObject b(JSONObject jSONObject) {
        return jSONObject.optJSONObject("android_fatal_hangs");
    }
}
