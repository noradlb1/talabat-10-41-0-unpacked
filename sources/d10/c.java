package d10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.choosesavedaddress.ChooseSavedAddressInteractor;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressInteractor f24316b;

    public /* synthetic */ c(ChooseSavedAddressInteractor chooseSavedAddressInteractor) {
        this.f24316b = chooseSavedAddressInteractor;
    }

    public final void accept(Object obj) {
        ChooseSavedAddressInteractor.m7876loadAppinitCountrySpecficData$lambda1(this.f24316b, (Throwable) obj);
    }
}
