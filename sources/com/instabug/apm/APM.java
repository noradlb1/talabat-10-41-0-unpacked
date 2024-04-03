package com.instabug.apm;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.attributes.listeners.OnNetworkTraceListener;
import com.instabug.apm.model.ExecutionTrace;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;

public class APM {
    /* access modifiers changed from: private */
    public static final h apmImplementation = com.instabug.apm.di.a.e();
    /* access modifiers changed from: private */
    public static com.instabug.apm.logger.internal.a apmLogger = com.instabug.apm.di.a.f();

    public class a implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Looper f45091a;

        public a(Looper looper) {
            this.f45091a = looper;
        }

        public void run() {
            APM.apmImplementation.b(this.f45091a);
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnNetworkTraceListener f45092a;

        public b(OnNetworkTraceListener onNetworkTraceListener) {
            this.f45092a = onNetworkTraceListener;
        }

        public void run() {
            APM.apmImplementation.a(this.f45092a);
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnNetworkTraceListener f45093a;

        public c(OnNetworkTraceListener onNetworkTraceListener) {
            this.f45093a = onNetworkTraceListener;
        }

        public void run() {
            APM.apmImplementation.b(this.f45093a);
        }
    }

    public class d implements VoidRunnable {
        public void run() {
            APM.apmImplementation.j();
        }
    }

    public class e implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45094a;

        public e(boolean z11) {
            this.f45094a = z11;
        }

        public void run() {
            APM.apmImplementation.d(this.f45094a);
        }
    }

    public class f implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45095a;

        public f(boolean z11) {
            this.f45095a = z11;
        }

        public void run() {
            APM.apmLogger.f("APM.setAppLaunchEnabled API has been deprecated, please use setColdAppLaunchEnabled instead.");
            APM.apmImplementation.c(this.f45095a);
        }
    }

    public class g implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45096a;

        public g(boolean z11) {
            this.f45096a = z11;
        }

        public void run() {
            APM.apmImplementation.c(this.f45096a);
        }
    }

    public class h implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45097a;

        public h(boolean z11) {
            this.f45097a = z11;
        }

        public void run() {
            APM.apmImplementation.f(this.f45097a);
        }
    }

    public class i implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45098a;

        public i(boolean z11) {
            this.f45098a = z11;
        }

        public void run() {
            APM.apmImplementation.b(this.f45098a);
        }
    }

    public class j implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45099a;

        public j(boolean z11) {
            this.f45099a = z11;
        }

        public void run() {
            APM.apmImplementation.h(this.f45099a);
        }
    }

    public class k implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45100a;

        public k(boolean z11) {
            this.f45100a = z11;
        }

        public void run() {
            APM.apmImplementation.g(this.f45100a);
        }
    }

    public class l implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45101a;

        public l(int i11) {
            this.f45101a = i11;
        }

        public void run() {
            APM.apmImplementation.a(this.f45101a);
        }
    }

    public class m implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45102a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Looper f45103b;

        public m(String str, Looper looper) {
            this.f45102a = str;
            this.f45103b = looper;
        }

        public void run() {
            APM.apmImplementation.c(this.f45102a, this.f45103b);
        }
    }

    public static void addOnNetworkTraceListener(OnNetworkTraceListener onNetworkTraceListener) {
        APIChecker.checkAndRunInExecutor("APM.addOnNetworkTraceListener", new b(onNetworkTraceListener));
    }

    public static void endAppLaunch() {
        com.instabug.apm.di.a.k().b(System.nanoTime() / 1000);
        APIChecker.checkAndRunInExecutor("APM.endAppLaunch", new d());
    }

    public static <ActivityType extends Activity> void endScreenLoading(Class<ActivityType> cls) {
        APIChecker.checkAndRunInExecutor("APM.endScreenLoading", new lb.a(cls, new com.instabug.apm.model.e()));
    }

    @RequiresApi(api = 16)
    public static void endUITrace() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != Looper.getMainLooper()) {
            apmLogger.k("APM.endUITrace was called from a non-main thread. Please make sure to end Custom UI Traces from the main thread.");
        }
        APIChecker.checkAndRunInExecutor("APM.endUITrace", new a(myLooper));
    }

    public static void removeOnNetworkTraceListener(OnNetworkTraceListener onNetworkTraceListener) {
        APIChecker.checkAndRunInExecutor("APM.removeOnNetworkTraceListener", new c(onNetworkTraceListener));
    }

    @Deprecated
    public static void setAppLaunchEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setAppLaunchEnabled", new f(z11));
    }

    public static void setAutoUITraceEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setAutoUITraceEnabled", new i(z11));
    }

    public static void setColdAppLaunchEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setColdAppLaunchEnabled", new g(z11));
    }

    public static void setEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setEnabled", new e(z11));
    }

    public static void setFragmentSpansEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setFragmentSpansEnabled", new lb.b(z11));
    }

    public static void setHotAppLaunchEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setHotAppLaunchEnabled", new h(z11));
    }

    @Deprecated
    public static void setLogLevel(int i11) {
        APIChecker.checkAndRunInExecutor("APM.setLogLevel", new l(i11));
    }

    public static void setScreenLoadingEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setScreenLoadingEnabled", new k(z11));
    }

    public static void setUIHangEnabled(boolean z11) {
        APIChecker.checkAndRunInExecutor("APM.setUIHangEnabled", new j(z11));
    }

    @Nullable
    public static ExecutionTrace startExecutionTrace(@NonNull String str) {
        return apmImplementation.b(str);
    }

    @RequiresApi(api = 16)
    public static void startUITrace(@NonNull String str) {
        APIChecker.checkAndRunInExecutor("APM.startUITrace", new m(str, Looper.myLooper()));
    }
}
