package ke;

import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f56953b;

    public /* synthetic */ b(boolean z11) {
        this.f56953b = z11;
    }

    public final void run() {
        NavigationController.lambda$popBackStack$7(this.f56953b);
    }
}
