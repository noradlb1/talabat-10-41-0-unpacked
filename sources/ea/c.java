package ea;

import com.google.firebase.installations.FirebaseInstallations;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f50611b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f50612c;

    public /* synthetic */ c(FirebaseInstallations firebaseInstallations, boolean z11) {
        this.f50611b = firebaseInstallations;
        this.f50612c = z11;
    }

    public final void run() {
        this.f50611b.lambda$getToken$2(this.f50612c);
    }
}
