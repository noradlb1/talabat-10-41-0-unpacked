package com.instabug.apm.util;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.IBGDiagnostics;

public abstract class b {
    @SuppressLint({"ERADICATE_CONDITION_REDUNDANT_NONNULL"})
    @Nullable
    public static String a(Class cls) {
        if (cls != null) {
            try {
                if (cls.getPackage() != null) {
                    return cls.getPackage().getName();
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, e11.getMessage() + "", "IBG-APM");
            }
        }
        return null;
    }
}
