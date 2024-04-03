package ke;

import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f56970b;

    public /* synthetic */ h(boolean z11) {
        this.f56970b = z11;
    }

    public final void run() {
        NavigationController.lambda$navigateUp$3(this.f56970b);
    }
}
