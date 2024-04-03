package d10;

import io.reactivex.functions.Action;
import library.talabat.mvp.choosesavedaddress.ChooseSavedAddressInteractor;

public final /* synthetic */ class b implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressInteractor f24315b;

    public /* synthetic */ b(ChooseSavedAddressInteractor chooseSavedAddressInteractor) {
        this.f24315b = chooseSavedAddressInteractor;
    }

    public final void run() {
        ChooseSavedAddressInteractor.m7875loadAppinitCountrySpecficData$lambda0(this.f24315b);
    }
}
