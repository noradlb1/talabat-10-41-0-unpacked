package ea;

import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f50610b;

    public /* synthetic */ b(FirebaseInstallations firebaseInstallations) {
        this.f50610b = firebaseInstallations;
    }

    public final Object call() {
        return this.f50610b.deleteFirebaseInstallationId();
    }
}
