package com.instabug.featuresrequest;

import com.instabug.library.Feature;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;

public class FeatureRequests {

    public class a implements VoidRunnable {
        public void run() {
            a.a();
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f46509a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f46510b;

        public b(boolean z11, int[] iArr) {
            this.f46509a = z11;
            this.f46510b = iArr;
        }

        public void run() {
            a.a(this.f46509a, this.f46510b);
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Feature.State f46511a;

        public c(Feature.State state) {
            this.f46511a = state;
        }

        public void run() {
            a.a(this.f46511a);
        }
    }

    public static void setEmailFieldRequired(boolean z11, int... iArr) {
        APIChecker.checkAndRunInExecutor("FeatureRequests.setEmailFieldRequired", new b(z11, iArr));
    }

    public static void setState(Feature.State state) {
        APIChecker.checkAndRunInExecutor("FeatureRequests.setState", new c(state));
    }

    public static void show() {
        APIChecker.checkAndRunInExecutor("FeatureRequests.show", new a());
    }
}
