package com.instabug.fatalhangs;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.models.Incident;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.commons.threading.a;
import com.instabug.commons.threading.e;
import com.instabug.fatalhangs.model.b;
import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import ic.c;
import ic.d;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public final class i extends Thread {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Function1 f46474a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f46475b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f46476c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f46477d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Function0 f46478e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f46479f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i(kotlin.jvm.functions.Function1 r1, android.os.Looper r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            java.lang.String r3 = "getMainLooper()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.fatalhangs.i.<init>(kotlin.jvm.functions.Function1, android.os.Looper, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final Handler c() {
        return (Handler) this.f46479f.getValue();
    }

    /* access modifiers changed from: private */
    public final AtomicLong d() {
        return (AtomicLong) this.f46476c.getValue();
    }

    private final void e() {
        c().post(new c(this.f46478e));
    }

    private final void f() {
        a aVar = new a(e.f46356a, new com.instabug.commons.threading.c((String) null, (String) null, 3, (DefaultConstructorMarker) null), (Thread) null, (Set) null, 0, 0, 60, (DefaultConstructorMarker) null);
        ThreadPoolExecutor f11 = com.instabug.fatalhangs.di.c.f46466a.f();
        if (f11 != null) {
            f11.execute(new d(this, aVar));
        }
    }

    public void interrupt() {
        this.f46475b = true;
        super.interrupt();
    }

    public void run() {
        boolean z11;
        Object obj;
        setName("Instabug Fatal Hang detector thread");
        while (!this.f46475b) {
            Long valueOf = Long.valueOf(d().getAndAdd(500));
            if (valueOf.longValue() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.longValue();
                e();
            }
            try {
                Result.Companion companion = Result.Companion;
                Thread.sleep(500);
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            com.instabug.commons.logging.a.a(obj, "Can't detect Fatal Hangs because the app went to the background.", false);
            if (d().get() >= b() && !a().get() && !Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
                com.instabug.commons.logging.a.b("Fatal hang detected");
                f();
                a().set(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public final AtomicBoolean a() {
        return (AtomicBoolean) this.f46477d.getValue();
    }

    private final long b() {
        return SettingsManager.getFatalHangsSensitivity();
    }

    public i(@NotNull Function1 function1, @NotNull Looper looper) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Intrinsics.checkNotNullParameter(looper, "targetThreadLooper");
        this.f46474a = function1;
        this.f46476c = LazyKt__LazyJVMKt.lazy(g.f46472a);
        this.f46477d = LazyKt__LazyJVMKt.lazy(e.f46470a);
        this.f46478e = new h(this);
        this.f46479f = LazyKt__LazyJVMKt.lazy(new f(looper));
    }

    /* access modifiers changed from: private */
    public static final void a(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void a(i iVar, a aVar) {
        Intrinsics.checkNotNullParameter(iVar, "this$0");
        Intrinsics.checkNotNullParameter(aVar, "$detailsSnapshot");
        com.instabug.fatalhangs.model.c a11 = iVar.a(aVar);
        if (a11 != null) {
            CommonsLocator.getSessionLinker().a((Incident) a11, 1);
            iVar.f46474a.invoke(a11);
        }
    }

    @WorkerThread
    private final com.instabug.fatalhangs.model.c a(a aVar) {
        b bVar = b.f46480a;
        Context applicationContext = Instabug.getApplicationContext();
        long fatalHangsSensitivity = SettingsManager.getFatalHangsSensitivity();
        JSONObject a11 = aVar.a();
        JSONArray b11 = aVar.b();
        String jSONArray = !(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11);
        Intrinsics.checkNotNullExpressionValue(jSONArray, "detailsSnapshot.threadsDetails.toString()");
        return bVar.a(applicationContext, fatalHangsSensitivity, a11, jSONArray, IncidentMetadata.Factory.create$default((String) null, 1, (Object) null));
    }
}
