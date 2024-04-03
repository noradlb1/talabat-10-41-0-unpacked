package ea;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;

public final /* synthetic */ class e implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f50614a;

    public /* synthetic */ e(FirebaseApp firebaseApp) {
        this.f50614a = firebaseApp;
    }

    public final Object get() {
        return FirebaseInstallations.lambda$new$0(this.f50614a);
    }
}
