package rj;

import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class b implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeInteractor f57372a;

    public /* synthetic */ b(DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        this.f57372a = darkstoresBridgeInteractor;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        DarkstoresBridgeInteractor.m10099getLoadCustomerDetailsSingle$lambda4(this.f57372a, singleEmitter);
    }
}
