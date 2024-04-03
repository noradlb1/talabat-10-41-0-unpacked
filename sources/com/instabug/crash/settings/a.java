package com.instabug.crash.settings;

import android.content.Context;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class a {
    static {
        new a();
    }

    private a() {
    }

    @JvmStatic
    public static final void a(@Nullable String str) {
        if (str != null) {
            try {
                boolean optBoolean = new JSONObject(str).optBoolean("an_crash_early_capture", false);
                Context applicationContext = Instabug.getApplicationContext();
                if (applicationContext != null) {
                    new f(applicationContext).a(optBoolean);
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "Couldn't parse crashes in features response");
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "low memory while parsing crashes in features response");
            }
        }
    }
}
