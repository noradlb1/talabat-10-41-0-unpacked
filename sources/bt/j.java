package bt;

import com.talabat.registration.RegistrationInteractor;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58187b;

    public /* synthetic */ j(RegistrationInteractor registrationInteractor) {
        this.f58187b = registrationInteractor;
    }

    public final void accept(Object obj) {
        this.f58187b.lambda$silentLogin$2((VerifyLoginPasswordUseCase.Result) obj);
    }
}
