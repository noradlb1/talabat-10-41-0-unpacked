package com.instabug.terminations.configuration;

import com.instabug.commons.configurations.a;
import com.instabug.commons.utils.c;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.terminations.di.d;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class b implements a {
    static {
        new a((DefaultConstructorMarker) null);
    }

    private final boolean b(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            if (str != null) {
                JSONObject c11 = c(str);
                if (c11 != null) {
                    c s11 = d.f52610a.s();
                    s11.a(a(c11));
                    s11.a(c(c11));
                    s11.a((float) b(c11));
                    return true;
                }
            }
            obj = Result.m6329constructorimpl((Object) null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = "";
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus("", message));
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 == null) {
            return false;
        }
        String message2 = r42.getMessage();
        if (message2 == null) {
            message2 = "";
        }
        InstabugSDKLogger.e("Something went wrong while parsing App terminations from features response ", Intrinsics.stringPlus("", message2), r42);
        return false;
    }

    private final JSONObject c(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(new JSONObject(str).getJSONObject("crashes").getJSONObject("android_user_termination"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (JSONObject) obj;
    }

    public void a(@Nullable String str) {
        if (!b(str)) {
            d.f52610a.s().a(((Boolean) com.instabug.crash.a.f46376a.i().getSecond()).booleanValue());
        }
    }

    private final boolean a(JSONObject jSONObject) {
        return jSONObject.optBoolean("enabled", ((Boolean) com.instabug.crash.a.f46376a.i().getSecond()).booleanValue());
    }

    public void a() {
        if ((!b() ? this : null) != null) {
            c s11 = d.f52610a.s();
            if (Instabug.getApplicationContext() != null) {
                c cVar = c.f46365a;
                com.instabug.crash.a aVar = com.instabug.crash.a.f46376a;
                s11.a(cVar.a("enabled", ((Boolean) aVar.i().getSecond()).booleanValue(), "instabug_crash"));
                s11.a(cVar.a("time_between_sessions", ((Number) aVar.k().getSecond()).longValue(), "instabug_crash"));
                s11.a(cVar.a("logs_percentage", ((Number) aVar.j().getSecond()).floatValue(), "instabug_crash"));
                c();
            }
        }
    }

    private final long c(JSONObject jSONObject) {
        return jSONObject.optLong("time_between_sessions", ((Number) com.instabug.crash.a.f46376a.k().getSecond()).longValue());
    }

    private final void c() {
        c.f46365a.b((String) com.instabug.crash.a.f46376a.h().getFirst(), true, "instabug_crash");
    }

    private final double b(JSONObject jSONObject) {
        return jSONObject.optDouble("logs_percentage", (double) ((Number) com.instabug.crash.a.f46376a.j().getSecond()).floatValue());
    }

    private final boolean b() {
        Pair h11 = com.instabug.crash.a.f46376a.h();
        boolean booleanValue = ((Boolean) h11.component2()).booleanValue();
        return c.f46365a.a((String) h11.component1(), booleanValue, "instabug_crash");
    }
}
