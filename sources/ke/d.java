package ke;

import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f56956b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56957c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f56958d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f56959e;

    public /* synthetic */ d(int i11, boolean z11, boolean z12, boolean z13) {
        this.f56956b = i11;
        this.f56957c = z11;
        this.f56958d = z12;
        this.f56959e = z13;
    }

    public final void run() {
        NavigationController.lambda$popBackStack$5(this.f56956b, this.f56957c, this.f56958d, this.f56959e);
    }
}
