package ke;

import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56960b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56961c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f56962d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f56963e;

    public /* synthetic */ e(String str, boolean z11, boolean z12, boolean z13) {
        this.f56960b = str;
        this.f56961c = z11;
        this.f56962d = z12;
        this.f56963e = z13;
    }

    public final void run() {
        NavigationController.lambda$popBackStack$6(this.f56960b, this.f56961c, this.f56962d, this.f56963e);
    }
}
