package r10;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import library.talabat.mvp.login.domain.usecases.impl.SelectSavedAddressIfCanDeliverToVendorUseCaseImpl;

public final /* synthetic */ class c implements Cancellable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Disposable f28168a;

    public /* synthetic */ c(Disposable disposable) {
        this.f28168a = disposable;
    }

    public final void cancel() {
        SelectSavedAddressIfCanDeliverToVendorUseCaseImpl.m7906selectSavedAddressIfCanDeliverToVendor$lambda3$lambda2(this.f28168a);
    }
}
