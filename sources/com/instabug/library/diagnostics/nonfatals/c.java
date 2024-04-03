package com.instabug.library.diagnostics.nonfatals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.f;
import com.instabug.library.diagnostics.nonfatals.model.a;
import com.instabug.library.settings.e;
import com.instabug.library.util.InstabugSDKLogger;
import yc.b;

public abstract class c {
    public static void a(@NonNull Throwable th2, @NonNull String str, int i11) {
        if (!f.a(th2.getStackTrace())) {
            InstabugSDKLogger.e("IBG-Core", "Please refrain from using NonFatals.reportNonFatal as it is a private API");
        } else if (!a()) {
            InstabugSDKLogger.v("IBG-Core", "NonFatals disabled temporarily");
        } else {
            APIChecker.checkAndRunInExecutor("NonFatals.reportNonFatal", new b(e(th2.getStackTrace()), th2, str, i11));
        }
    }

    private static void b(a aVar) {
        com.instabug.library.diagnostics.nonfatals.di.a.i().execute(new yc.a(aVar));
    }

    @VisibleForTesting
    @Nullable
    public static StackTraceElement e(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement.getClassName().startsWith("com.instabug.") && !stackTraceElement.getMethodName().equals("reportError") && !stackTraceElement.getMethodName().equals("reportNonFatal")) {
                return stackTraceElement;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(StackTraceElement stackTraceElement, Throwable th2, String str, int i11) throws Exception {
        if (InstabugCore.getFeatureState(Feature.NON_FATAL_ERRORS) == Feature.State.DISABLED) {
            InstabugSDKLogger.d("IBG-Core", "NonFatals reporting is DISABLED");
            return;
        }
        if (stackTraceElement != null) {
            g.a(stackTraceElement.getFileName());
        }
        a(th2, stackTraceElement, str, i11);
    }

    public static void a(@NonNull Throwable th2, @NonNull String str, int i11, @NonNull String str2) {
        if (!f.a(th2.getStackTrace())) {
            InstabugSDKLogger.e("IBG-Core", "Please refrain from using NonFatals.reportNonFatal as it is a private API");
        } else if (!a()) {
            InstabugSDKLogger.v("IBG-Core", "NonFatals disabled temporarily");
        } else {
            StackTraceElement e11 = e(th2.getStackTrace());
            if (InstabugCore.getFeatureState(Feature.NON_FATAL_ERRORS) == Feature.State.DISABLED) {
                InstabugSDKLogger.d("IBG-Core", "NonFatals reporting is DISABLED");
                return;
            }
            if (e11 != null) {
                g.a(e11.getFileName());
            }
            a(th2, e11, str, i11);
            InstabugSDKLogger.e(str2, str);
        }
    }

    private static void a(@NonNull Throwable th2, @Nullable StackTraceElement stackTraceElement, @NonNull String str, int i11) {
        try {
            InstabugSDKLogger.v("IBG-Core", "parsing nonfatal: " + th2.getClass().getCanonicalName());
            b(b.a(th2, stackTraceElement, str, i11));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "parsing nonfatal error ", e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar) {
        e g11 = com.instabug.library.diagnostics.nonfatals.di.a.g();
        if (g11 != null) {
            g11.saveNonFatal(aVar);
        }
    }

    private static boolean a() {
        return !e.j().F();
    }
}
