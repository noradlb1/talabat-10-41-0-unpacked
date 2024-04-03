package ke;

import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56964b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56965c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f56966d;

    public /* synthetic */ f(String str, boolean z11, boolean z12) {
        this.f56964b = str;
        this.f56965c = z11;
        this.f56966d = z12;
    }

    public final void run() {
        NavigationController.lambda$popBackStack$default$4(this.f56964b, this.f56965c, this.f56966d);
    }
}
