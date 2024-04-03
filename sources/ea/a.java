package ea;

import com.google.firebase.installations.FirebaseInstallations;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f50608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f50609c;

    public /* synthetic */ a(FirebaseInstallations firebaseInstallations, boolean z11) {
        this.f50608b = firebaseInstallations;
        this.f50609c = z11;
    }

    public final void run() {
        this.f50608b.lambda$doRegistrationOrRefresh$3(this.f50609c);
    }
}
