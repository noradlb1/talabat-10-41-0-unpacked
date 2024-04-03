package p10;

import datamodels.RegistrationRM;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class i implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28140a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationRM f28141b;

    public /* synthetic */ i(LoginInteractor loginInteractor, RegistrationRM registrationRM) {
        this.f28140a = loginInteractor;
        this.f28141b = registrationRM;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        this.f28140a.lambda$faceBookLoginWithResult$2(this.f28141b, singleEmitter);
    }
}
