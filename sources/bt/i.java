package bt;

import com.talabat.registration.RegistrationInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58186b;

    public /* synthetic */ i(RegistrationInteractor registrationInteractor) {
        this.f58186b = registrationInteractor;
    }

    public final void accept(Object obj) {
        this.f58186b.lambda$silentLogin$5((Throwable) obj);
    }
}
