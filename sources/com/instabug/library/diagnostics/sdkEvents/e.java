package com.instabug.library.diagnostics.sdkEvents;

import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.diagnostics.f;
import com.instabug.library.diagnostics.sdkEvents.di.a;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {
    /* access modifiers changed from: private */
    public final f b() {
        return a.f34336a.j();
    }

    private final void c() {
        InstabugSDKLogger.d("IBG-Core", "SDKEvent recording is DISABLED");
    }

    private final com.instabug.library.diagnostics.sdkEvents.configurations.a a() {
        return a.f34336a.c();
    }

    public final void b(@NotNull String str, int i11, @Nullable StackTraceElement[] stackTraceElementArr) {
        Intrinsics.checkNotNullParameter(str, "key");
        com.instabug.library.diagnostics.sdkEvents.models.a aVar = new com.instabug.library.diagnostics.sdkEvents.models.a(str, i11);
        a(stackTraceElementArr, "logEventImmediately()", aVar, (Function0) new d(this, aVar));
    }

    public final void a(@NotNull String str, int i11, @Nullable StackTraceElement[] stackTraceElementArr) {
        Intrinsics.checkNotNullParameter(str, "key");
        APIChecker.checkAndRunInExecutor("SDKEvents.logSDKEvent", new zc.a(str, i11, this, stackTraceElementArr));
    }

    /* access modifiers changed from: private */
    public static final void a(String str, int i11, e eVar, StackTraceElement[] stackTraceElementArr) {
        Intrinsics.checkNotNullParameter(str, "$key");
        Intrinsics.checkNotNullParameter(eVar, "this$0");
        com.instabug.library.diagnostics.sdkEvents.models.a aVar = new com.instabug.library.diagnostics.sdkEvents.models.a(str, i11);
        eVar.a(stackTraceElementArr, "logEvent()", aVar, (Function0) new c(eVar, aVar));
    }

    private final void b(String str) {
        InstabugSDKLogger.e("IBG-Core", "recording event with key: " + str + " is not allowed");
    }

    private final void a(StackTraceElement[] stackTraceElementArr, String str, com.instabug.library.diagnostics.sdkEvents.models.a aVar, Function0 function0) {
        if (!f.b(stackTraceElementArr)) {
            a(str);
        } else if (!a().isEnabled()) {
            c();
        } else {
            Set a11 = a().a();
            boolean z11 = true;
            if (a11 != null) {
                z11 = true ^ a11.contains(aVar.b());
            }
            if (z11) {
                b(aVar.b());
                return;
            }
            a(aVar);
            function0.invoke();
        }
    }

    private final void a(String str) {
        InstabugSDKLogger.e("IBG-Core", "Please refrain from using IBGDiagnostics." + str + "() as it is a private API");
    }

    private final void a(com.instabug.library.diagnostics.sdkEvents.models.a aVar) {
        InstabugSDKLogger.v("IBG-Core", Intrinsics.stringPlus("saving sdkEvent: ", aVar));
    }
}
