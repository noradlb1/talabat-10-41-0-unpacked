package com.instabug.library.diagnostics.nonfatals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.nonfatals.model.a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.ThreadUtils;

public abstract class b {
    public static a a(@NonNull Throwable th2, @Nullable StackTraceElement stackTraceElement, String str, int i11) {
        a aVar = new a();
        try {
            aVar.b(th2.getClass().getName());
            aVar.d(str);
            aVar.f(ThreadUtils.buildStackTraceFromElements(th2.getStackTrace(), th2.getClass().getCanonicalName()));
            aVar.b(i11);
            if (stackTraceElement != null) {
                if (stackTraceElement.getClassName() != null) {
                    aVar.a(stackTraceElement.getClassName());
                }
                if (stackTraceElement.getFileName() != null) {
                    aVar.c(stackTraceElement.getFileName());
                }
                if (stackTraceElement.getMethodName() != null) {
                    aVar.e(stackTraceElement.getMethodName());
                }
                aVar.a(stackTraceElement.getLineNumber());
            } else {
                InstabugSDKLogger.e("IBG-Core", "Incomplete non-fatal stacktrace");
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while creating non-fatal", e11);
        }
        return aVar;
    }
}
