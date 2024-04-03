package bt;

import com.talabat.registration.RegistrationInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58179b;

    public /* synthetic */ c(RegistrationInteractor registrationInteractor) {
        this.f58179b = registrationInteractor;
    }

    public final void accept(Object obj) {
        this.f58179b.lambda$loadCustomerDetails$8((Throwable) obj);
    }
}
