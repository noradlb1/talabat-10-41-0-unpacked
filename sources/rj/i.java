package rj;

import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeInteractor f57378b;

    public /* synthetic */ i(DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        this.f57378b = darkstoresBridgeInteractor;
    }

    public final void accept(Object obj) {
        DarkstoresBridgeInteractor.m10102loadCustomerDetailsFromMicroservice$lambda3(this.f57378b, (Throwable) obj);
    }
}
