package p10;

import com.talabat.userandlocation.otp.domain.repo.RequestOtpRepository;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28138b;

    public /* synthetic */ g(LoginInteractor loginInteractor) {
        this.f28138b = loginInteractor;
    }

    public final void accept(Object obj) {
        this.f28138b.onRequestOtpResult((RequestOtpRepository.RequestOtpResult) obj);
    }
}
