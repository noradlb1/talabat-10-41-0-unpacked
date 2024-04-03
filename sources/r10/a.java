package r10;

import com.talabat.domain.address.Address;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.domain.model.DeliveryAreaDetailsModel;
import library.talabat.mvp.login.domain.usecases.impl.SelectSavedAddressIfCanDeliverToVendorUseCaseImpl;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectSavedAddressIfCanDeliverToVendorUseCaseImpl f28163b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f28164c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f28165d;

    public /* synthetic */ a(SelectSavedAddressIfCanDeliverToVendorUseCaseImpl selectSavedAddressIfCanDeliverToVendorUseCaseImpl, Address address, SingleEmitter singleEmitter) {
        this.f28163b = selectSavedAddressIfCanDeliverToVendorUseCaseImpl;
        this.f28164c = address;
        this.f28165d = singleEmitter;
    }

    public final void accept(Object obj) {
        SelectSavedAddressIfCanDeliverToVendorUseCaseImpl.m7904selectSavedAddressIfCanDeliverToVendor$lambda3$lambda0(this.f28163b, this.f28164c, this.f28165d, (DeliveryAreaDetailsModel) obj);
    }
}
