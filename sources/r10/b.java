package r10;

import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.domain.usecases.impl.SelectSavedAddressIfCanDeliverToVendorUseCaseImpl;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectSavedAddressIfCanDeliverToVendorUseCaseImpl f28166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f28167c;

    public /* synthetic */ b(SelectSavedAddressIfCanDeliverToVendorUseCaseImpl selectSavedAddressIfCanDeliverToVendorUseCaseImpl, SingleEmitter singleEmitter) {
        this.f28166b = selectSavedAddressIfCanDeliverToVendorUseCaseImpl;
        this.f28167c = singleEmitter;
    }

    public final void accept(Object obj) {
        SelectSavedAddressIfCanDeliverToVendorUseCaseImpl.m7905selectSavedAddressIfCanDeliverToVendor$lambda3$lambda1(this.f28166b, this.f28167c, (Throwable) obj);
    }
}
