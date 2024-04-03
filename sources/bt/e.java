package bt;

import com.talabat.registration.RegistrationInteractor;
import com.talabat.userandlocation.otp.domain.repo.RequestOtpRepository;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58182b;

    public /* synthetic */ e(RegistrationInteractor registrationInteractor) {
        this.f58182b = registrationInteractor;
    }

    public final void accept(Object obj) {
        this.f58182b.onRequestOtpResult((RequestOtpRepository.RequestOtpResult) obj);
    }
}
