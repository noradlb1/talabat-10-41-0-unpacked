package bt;

import com.talabat.registration.RegistrationInteractor;
import com.talabat.registration.RegistrationListener;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationListener f58183b;

    public /* synthetic */ f(RegistrationListener registrationListener) {
        this.f58183b = registrationListener;
    }

    public final void accept(Object obj) {
        RegistrationInteractor.lambda$requestOtp$0(this.f58183b, (Throwable) obj);
    }
}
