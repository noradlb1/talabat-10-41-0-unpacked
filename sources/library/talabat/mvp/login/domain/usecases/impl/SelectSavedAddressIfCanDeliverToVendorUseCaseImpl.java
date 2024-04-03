package library.talabat.mvp.login.domain.usecases.impl;

import buisnessmodels.Cart;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.domain.address.Address;
import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.data.HomeMapCache;
import library.talabat.mvp.homemap.domain.AddressSortHelper;
import library.talabat.mvp.login.domain.model.DeliveryAreaDetailsModel;
import library.talabat.mvp.login.domain.repository.DeliveryAreaDetailsRepository;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import org.jetbrains.annotations.NotNull;
import r10.a;
import r10.b;
import r10.c;
import r10.d;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J.\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J.\u0010\"\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150%H\u0016J\b\u0010&\u001a\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/impl/SelectSavedAddressIfCanDeliverToVendorUseCaseImpl;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase;", "homeMapCache", "Llibrary/talabat/mvp/homemap/data/HomeMapCache;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "addressSortHelper", "Llibrary/talabat/mvp/homemap/domain/AddressSortHelper;", "deliveryAreaDetailsRepository", "Llibrary/talabat/mvp/login/domain/repository/DeliveryAreaDetailsRepository;", "cart", "Lbuisnessmodels/Cart;", "(Llibrary/talabat/mvp/homemap/data/HomeMapCache;Lcom/talabat/customer/domain/CustomerRepository;Llibrary/talabat/mvp/homemap/domain/AddressSortHelper;Llibrary/talabat/mvp/login/domain/repository/DeliveryAreaDetailsRepository;Lbuisnessmodels/Cart;)V", "vendorId", "", "getVendorId", "()J", "emitSelectAddressManually", "", "emitter", "Lio/reactivex/SingleEmitter;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "getCurrentLocationAsPair", "Lkotlin/Pair;", "", "getHomeMapSavedLocationPair", "handleResultAvailable", "deliveryAreaDetailsModel", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel$Available;", "selectedAddress", "Lcom/talabat/domain/address/Address;", "hasCurrentLocation", "", "hasHomeMapSavedLocation", "onSuccessApiCall", "Llibrary/talabat/mvp/login/domain/model/DeliveryAreaDetailsModel;", "selectSavedAddressIfCanDeliverToVendor", "Lio/reactivex/Single;", "setHomeMapRedirectToFalse", "setSelectedAddress", "sortedAddress", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectSavedAddressIfCanDeliverToVendorUseCaseImpl implements SelectSavedAddressIfCanDeliverToVendorUseCase {
    @NotNull
    private final AddressSortHelper addressSortHelper;
    @NotNull
    private final Cart cart;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final DeliveryAreaDetailsRepository deliveryAreaDetailsRepository;
    @NotNull
    private final HomeMapCache homeMapCache;

    public SelectSavedAddressIfCanDeliverToVendorUseCaseImpl(@NotNull HomeMapCache homeMapCache2, @NotNull CustomerRepository customerRepository2, @NotNull AddressSortHelper addressSortHelper2, @NotNull DeliveryAreaDetailsRepository deliveryAreaDetailsRepository2, @NotNull Cart cart2) {
        Intrinsics.checkNotNullParameter(homeMapCache2, "homeMapCache");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(addressSortHelper2, "addressSortHelper");
        Intrinsics.checkNotNullParameter(deliveryAreaDetailsRepository2, "deliveryAreaDetailsRepository");
        Intrinsics.checkNotNullParameter(cart2, "cart");
        this.homeMapCache = homeMapCache2;
        this.customerRepository = customerRepository2;
        this.addressSortHelper = addressSortHelper2;
        this.deliveryAreaDetailsRepository = deliveryAreaDetailsRepository2;
        this.cart = cart2;
    }

    private final void emitSelectAddressManually(SingleEmitter<SelectSavedAddressIfCanDeliverToVendorUseCase.Result> singleEmitter) {
        setHomeMapRedirectToFalse();
        singleEmitter.onSuccess(SelectSavedAddressIfCanDeliverToVendorUseCase.Result.ShouldSelectAddressManually.INSTANCE);
    }

    private final Pair<Double, Double> getCurrentLocationAsPair() {
        double d11;
        Double currentLocPlaceOrderLat = this.homeMapCache.getCurrentLocPlaceOrderLat();
        double d12 = 0.0d;
        if (currentLocPlaceOrderLat != null) {
            d11 = currentLocPlaceOrderLat.doubleValue();
        } else {
            d11 = 0.0d;
        }
        Double valueOf = Double.valueOf(d11);
        Double currentLocPlaceOrderLong = this.homeMapCache.getCurrentLocPlaceOrderLong();
        if (currentLocPlaceOrderLong != null) {
            d12 = currentLocPlaceOrderLong.doubleValue();
        }
        return new Pair<>(valueOf, Double.valueOf(d12));
    }

    private final Pair<Double, Double> getHomeMapSavedLocationPair() {
        LatLng homeMapSavedLatLng = this.homeMapCache.getHomeMapSavedLatLng();
        if (homeMapSavedLatLng != null) {
            return new Pair<>(Double.valueOf(homeMapSavedLatLng.latitude), Double.valueOf(homeMapSavedLatLng.longitude));
        }
        return new Pair<>(Double.valueOf(0.0d), Double.valueOf(0.0d));
    }

    private final long getVendorId() {
        return (long) this.cart.getRestaurant().branchId;
    }

    private final void handleResultAvailable(DeliveryAreaDetailsModel.Available available, long j11, Address address, SingleEmitter<SelectSavedAddressIfCanDeliverToVendorUseCase.Result> singleEmitter) {
        if (available.getVendorId() == j11) {
            setSelectedAddress(address);
            singleEmitter.onSuccess(SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Successful.INSTANCE);
            return;
        }
        emitSelectAddressManually(singleEmitter);
    }

    private final boolean hasCurrentLocation() {
        if (this.homeMapCache.getCurrentLocPlaceOrderLat() == null || this.homeMapCache.getCurrentLocPlaceOrderLong() == null) {
            return false;
        }
        return true;
    }

    private final boolean hasHomeMapSavedLocation() {
        return this.homeMapCache.getHomeMapSavedLatLng() != null;
    }

    private final void onSuccessApiCall(DeliveryAreaDetailsModel deliveryAreaDetailsModel, long j11, Address address, SingleEmitter<SelectSavedAddressIfCanDeliverToVendorUseCase.Result> singleEmitter) {
        if (deliveryAreaDetailsModel instanceof DeliveryAreaDetailsModel.Available) {
            handleResultAvailable((DeliveryAreaDetailsModel.Available) deliveryAreaDetailsModel, j11, address, singleEmitter);
        } else if (deliveryAreaDetailsModel instanceof DeliveryAreaDetailsModel.Error) {
            emitSelectAddressManually(singleEmitter);
        } else if (Intrinsics.areEqual((Object) deliveryAreaDetailsModel, (Object) DeliveryAreaDetailsModel.Unavailable.INSTANCE)) {
            emitSelectAddressManually(singleEmitter);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfCanDeliverToVendor$lambda-3  reason: not valid java name */
    public static final void m7903selectSavedAddressIfCanDeliverToVendor$lambda3(SelectSavedAddressIfCanDeliverToVendorUseCaseImpl selectSavedAddressIfCanDeliverToVendorUseCaseImpl, SingleEmitter singleEmitter) {
        Pair<Double, Double> pair;
        Intrinsics.checkNotNullParameter(selectSavedAddressIfCanDeliverToVendorUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        boolean hasAddresses = selectSavedAddressIfCanDeliverToVendorUseCaseImpl.customerRepository.hasAddresses();
        if (hasAddresses && selectSavedAddressIfCanDeliverToVendorUseCaseImpl.hasHomeMapSavedLocation()) {
            pair = selectSavedAddressIfCanDeliverToVendorUseCaseImpl.getHomeMapSavedLocationPair();
        } else if (!hasAddresses || !selectSavedAddressIfCanDeliverToVendorUseCaseImpl.hasCurrentLocation()) {
            pair = null;
        } else {
            pair = selectSavedAddressIfCanDeliverToVendorUseCaseImpl.getCurrentLocationAsPair();
        }
        if (pair != null) {
            Address firstAddressSortedWithLocationOrNull = selectSavedAddressIfCanDeliverToVendorUseCaseImpl.addressSortHelper.getFirstAddressSortedWithLocationOrNull(pair, selectSavedAddressIfCanDeliverToVendorUseCaseImpl.customerRepository.getCustomerAddress(), 500);
            if (firstAddressSortedWithLocationOrNull != null) {
                Disposable subscribe = selectSavedAddressIfCanDeliverToVendorUseCaseImpl.deliveryAreaDetailsRepository.getDeliveryAreaDetails(selectSavedAddressIfCanDeliverToVendorUseCaseImpl.getVendorId(), firstAddressSortedWithLocationOrNull.latitude, firstAddressSortedWithLocationOrNull.longitude).subscribe(new a(selectSavedAddressIfCanDeliverToVendorUseCaseImpl, firstAddressSortedWithLocationOrNull, singleEmitter), new b(selectSavedAddressIfCanDeliverToVendorUseCaseImpl, singleEmitter));
                Intrinsics.checkNotNullExpressionValue(subscribe, "deliveryAreaDetailsRepos…  }\n                    )");
                singleEmitter.setCancellable(new c(subscribe));
                return;
            }
            selectSavedAddressIfCanDeliverToVendorUseCaseImpl.emitSelectAddressManually(singleEmitter);
        } else if (hasAddresses) {
            selectSavedAddressIfCanDeliverToVendorUseCaseImpl.emitSelectAddressManually(singleEmitter);
        } else {
            singleEmitter.onSuccess(new SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Failed("No address or location exists"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfCanDeliverToVendor$lambda-3$lambda-0  reason: not valid java name */
    public static final void m7904selectSavedAddressIfCanDeliverToVendor$lambda3$lambda0(SelectSavedAddressIfCanDeliverToVendorUseCaseImpl selectSavedAddressIfCanDeliverToVendorUseCaseImpl, Address address, SingleEmitter singleEmitter, DeliveryAreaDetailsModel deliveryAreaDetailsModel) {
        Intrinsics.checkNotNullParameter(selectSavedAddressIfCanDeliverToVendorUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "$emitter");
        Intrinsics.checkNotNullExpressionValue(deliveryAreaDetailsModel, "it");
        selectSavedAddressIfCanDeliverToVendorUseCaseImpl.onSuccessApiCall(deliveryAreaDetailsModel, selectSavedAddressIfCanDeliverToVendorUseCaseImpl.getVendorId(), address, singleEmitter);
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfCanDeliverToVendor$lambda-3$lambda-1  reason: not valid java name */
    public static final void m7905selectSavedAddressIfCanDeliverToVendor$lambda3$lambda1(SelectSavedAddressIfCanDeliverToVendorUseCaseImpl selectSavedAddressIfCanDeliverToVendorUseCaseImpl, SingleEmitter singleEmitter, Throwable th2) {
        Intrinsics.checkNotNullParameter(selectSavedAddressIfCanDeliverToVendorUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "$emitter");
        selectSavedAddressIfCanDeliverToVendorUseCaseImpl.emitSelectAddressManually(singleEmitter);
        LogManager.error$default(th2, (String) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: selectSavedAddressIfCanDeliverToVendor$lambda-3$lambda-2  reason: not valid java name */
    public static final void m7906selectSavedAddressIfCanDeliverToVendor$lambda3$lambda2(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "$disposable");
        disposable.dispose();
    }

    private final void setHomeMapRedirectToFalse() {
        this.homeMapCache.setHomeMapRedirectEnabled(false);
    }

    private final void setSelectedAddress(Address address) {
        setHomeMapRedirectToFalse();
        this.customerRepository.setSelectedCustomerAddress(address.f58343id, address.areaId);
    }

    @NotNull
    public Single<SelectSavedAddressIfCanDeliverToVendorUseCase.Result> selectSavedAddressIfCanDeliverToVendor() {
        Single<SelectSavedAddressIfCanDeliverToVendorUseCase.Result> create = Single.create(new d(this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …        }\n        }\n    }");
        return create;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SelectSavedAddressIfCanDeliverToVendorUseCaseImpl(library.talabat.mvp.homemap.data.HomeMapCache r8, com.talabat.customer.domain.CustomerRepository r9, library.talabat.mvp.homemap.domain.AddressSortHelper r10, library.talabat.mvp.login.domain.repository.DeliveryAreaDetailsRepository r11, buisnessmodels.Cart r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            if (r14 == 0) goto L_0x000b
            library.talabat.mvp.homemap.domain.impl.AddressSortHelperImpl r10 = new library.talabat.mvp.homemap.domain.impl.AddressSortHelperImpl
            r14 = 1
            r0 = 0
            r10.<init>(r0, r14, r0)
        L_0x000b:
            r4 = r10
            r10 = r13 & 16
            if (r10 == 0) goto L_0x0019
            buisnessmodels.Cart r12 = buisnessmodels.Cart.getInstance()
            java.lang.String r10 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r10)
        L_0x0019:
            r6 = r12
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.login.domain.usecases.impl.SelectSavedAddressIfCanDeliverToVendorUseCaseImpl.<init>(library.talabat.mvp.homemap.data.HomeMapCache, com.talabat.customer.domain.CustomerRepository, library.talabat.mvp.homemap.domain.AddressSortHelper, library.talabat.mvp.login.domain.repository.DeliveryAreaDetailsRepository, buisnessmodels.Cart, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
