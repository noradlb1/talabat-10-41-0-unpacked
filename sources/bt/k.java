package bt;

import com.talabat.registration.RegistrationInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58188b;

    public /* synthetic */ k(RegistrationInteractor registrationInteractor) {
        this.f58188b = registrationInteractor;
    }

    public final void accept(Object obj) {
        this.f58188b.lambda$silentLogin$3((Throwable) obj);
    }
}
