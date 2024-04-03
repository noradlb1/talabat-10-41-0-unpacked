package r10;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import library.talabat.mvp.login.domain.usecases.impl.SelectSavedAddressIfCanDeliverToVendorUseCaseImpl;

public final /* synthetic */ class d implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SelectSavedAddressIfCanDeliverToVendorUseCaseImpl f28169a;

    public /* synthetic */ d(SelectSavedAddressIfCanDeliverToVendorUseCaseImpl selectSavedAddressIfCanDeliverToVendorUseCaseImpl) {
        this.f28169a = selectSavedAddressIfCanDeliverToVendorUseCaseImpl;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        SelectSavedAddressIfCanDeliverToVendorUseCaseImpl.m7903selectSavedAddressIfCanDeliverToVendor$lambda3(this.f28169a, singleEmitter);
    }
}
