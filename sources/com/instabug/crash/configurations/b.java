package com.instabug.crash.configurations;

import com.instabug.commons.configurations.a;
import com.instabug.commons.utils.c;
import com.instabug.crash.di.d;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class b implements a {
    static {
        new a((DefaultConstructorMarker) null);
    }

    private final boolean b() {
        Pair f11 = com.instabug.crash.a.f46376a.f();
        boolean booleanValue = ((Boolean) f11.component2()).booleanValue();
        return c.f46365a.a((String) f11.component1(), booleanValue, "instabug_crash");
    }

    private final void c() {
        c.f46365a.b((String) com.instabug.crash.a.f46376a.f().getFirst(), true, "instabug_crash");
    }

    public void a(@Nullable String str) {
        Object obj;
        if (str != null) {
            try {
                Result.Companion companion = Result.Companion;
                boolean optBoolean = new JSONObject(str).optBoolean("crash_reporting");
                d.b().b(optBoolean);
                InstabugSDKLogger.i("IBG-CR", Intrinsics.stringPlus("Crash reporting enabled = ", Boolean.valueOf(optBoolean)));
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
            String str2 = "";
            if (r12 != null) {
                String message = r12.getMessage();
                if (message == null) {
                    message = str2;
                }
                InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while parsing crash_reporting from features response", message));
            }
            Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
            if (r13 != null) {
                String message2 = r13.getMessage();
                if (message2 != null) {
                    str2 = message2;
                }
                InstabugSDKLogger.e("IBG-CR", Intrinsics.stringPlus("Something went wrong while parsing crash_reporting from features response", str2), r13);
            }
            Result.m6328boximpl(obj);
        }
    }

    public void a() {
        if (!b() && Instabug.getApplicationContext() != null) {
            d.b().b(c.f46365a.a("CRASH_REPORTINGAVAIL", ((Boolean) com.instabug.crash.a.f46376a.b().getSecond()).booleanValue(), SettingsManager.INSTABUG_SHARED_PREF_NAME));
            c();
        }
    }
}
