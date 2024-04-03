package com.instabug.commons.diagnostics.configurations;

import com.instabug.commons.configurations.a;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class c implements a {
    public void a() {
    }

    public void a(@Nullable String str) {
        Object obj;
        if (str != null) {
            try {
                Result.Companion companion = Result.Companion;
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("crashes");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("exit_info");
                    if (optJSONObject2 != null) {
                        a(Boolean.valueOf(optJSONObject2.optBoolean("enabled")).booleanValue());
                    }
                }
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            com.instabug.commons.logging.a.a(obj, "Something went wrong parsing crash diagnostics response", false, 2, (Object) null);
        }
    }

    private final void a(boolean z11) {
        DiagnosticsLocator.getConfigProvider().a(z11);
    }
}
