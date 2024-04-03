package bt;

import com.talabat.registration.RegistrationInteractor;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import datamodels.RegistrationRM;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RegistrationRM f58185c;

    public /* synthetic */ h(RegistrationInteractor registrationInteractor, RegistrationRM registrationRM) {
        this.f58184b = registrationInteractor;
        this.f58185c = registrationRM;
    }

    public final void accept(Object obj) {
        this.f58184b.lambda$silentLogin$4(this.f58185c, (VerifyLoginPasswordUseCase.Result) obj);
    }
}
