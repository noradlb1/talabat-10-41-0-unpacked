package com.talabat.darkstores.interactor;

import JsonModels.GeoAddressRequest;
import JsonModels.Response.CustomerAddressInfoJsonResult;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.helpers.TalabatVolley;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.repository.CustomerAddressesRepositoryKt;
import datamodels.Restaurant;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalListener;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj.a;
import rj.b;
import rj.c;
import rj.d;
import rj.e;
import rj.f;
import rj.g;
import rj.h;
import rj.i;
import rj.j;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00013BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\"\u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190#0\"H\u0002J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020 H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0'2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020+0'H\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor;", "Lcom/talabat/darkstores/interactor/IDarkstoresBridgeInteractor;", "mListener", "Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor$BridgeCallbackListener;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "discoveryConfigurationRepository", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "(Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor$BridgeCallbackListener;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "loadCustomerInfoDisposable", "Lio/reactivex/disposables/Disposable;", "getMListener", "()Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor$BridgeCallbackListener;", "setMListener", "(Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor$BridgeCallbackListener;)V", "userSelectedaddress", "Lcom/talabat/domain/address/Address;", "getDarkstore", "Ldatamodels/Restaurant;", "getLoadCustomerDetailsSingle", "Lio/reactivex/Single;", "LJsonModels/Response/CustomerAddressInfoJsonResult;", "handleMergedResult", "", "mergedResultPair", "Lkotlin/Pair;", "", "loadCustomerDetails", "loadCustomerDetailsFromMicroservice", "onAddressReceived", "Lcom/android/volley/Response$Listener;", "fromLegacy", "", "onGeoAddressRecieved", "LJsonModels/GeoAddressRequest;", "onRequestError", "Lcom/android/volley/Response$ErrorListener;", "updateAddresswithGoogleAddress", "address", "updateCartSpecialRequest", "darkstoresSpecialRequest", "", "BridgeCallbackListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DarkstoresBridgeInteractor implements IDarkstoresBridgeInteractor {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final DiscoveryConfigurationRepository discoveryConfigurationRepository;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private Disposable loadCustomerInfoDisposable;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private BridgeCallbackListener mListener;
    @NotNull
    private final Scheduler mainScheduler;
    @Nullable
    private Address userSelectedaddress;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor$BridgeCallbackListener;", "Llibrary/talabat/mvp/IGlobalListener;", "geoAddressNotReceived", "", "onCustomerinfoLoaded", "customerAddressInfoJsonResult", "LJsonModels/Response/CustomerAddressInfoJsonResult;", "onGeoAddressRecieved", "GeoAddress", "Lcom/talabat/domain/address/Address;", "UserSelectedResult", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface BridgeCallbackListener extends IGlobalListener {
        void geoAddressNotReceived();

        void onCustomerinfoLoaded(@NotNull CustomerAddressInfoJsonResult customerAddressInfoJsonResult);

        void onGeoAddressRecieved(@Nullable Address address, @Nullable Address address2);
    }

    public DarkstoresBridgeInteractor(@NotNull BridgeCallbackListener bridgeCallbackListener, @NotNull CustomerAddressesRepository customerAddressesRepository2, @NotNull CustomerRepository customerRepository2, @NotNull AppVersionProvider appVersionProvider2, @NotNull DiscoveryConfigurationRepository discoveryConfigurationRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(bridgeCallbackListener, "mListener");
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(discoveryConfigurationRepository2, "discoveryConfigurationRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        this.mListener = bridgeCallbackListener;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.appVersionProvider = appVersionProvider2;
        this.discoveryConfigurationRepository = discoveryConfigurationRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        this.loadCustomerInfoDisposable = empty;
    }

    private final Single<CustomerAddressInfoJsonResult> getLoadCustomerDetailsSingle() {
        Single<CustomerAddressInfoJsonResult> create = Single.create(new b(this));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n        val cus…omerAddressInfoReq)\n    }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: getLoadCustomerDetailsSingle$lambda-4  reason: not valid java name */
    public static final void m10099getLoadCustomerDetailsSingle$lambda4(DarkstoresBridgeInteractor darkstoresBridgeInteractor, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(darkstoresBridgeInteractor, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        GsonRequest.Builder<CustomerAddressInfoJsonResult> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", sb2.toString()})).setClazz(CustomerAddressInfoJsonResult.class).setListener(new d(singleEmitter)).setErrorListener(new e(singleEmitter));
        String appVersion = darkstoresBridgeInteractor.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    /* access modifiers changed from: private */
    public final void handleMergedResult(Pair<? extends CustomerAddressInfoJsonResult, ? extends List<Address>> pair) {
        this.customerRepository.setCustomerAddresses((List) pair.getSecond());
        onAddressReceived(false).onResponse(pair.getFirst());
    }

    private static final boolean loadCustomerDetails$canInvokeAddressMicroService(DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        return darkstoresBridgeInteractor.locationConfigRepository.config().isAddressMicroServiceEnabled() && LoggedInHelper.isLoggedIn();
    }

    private final void loadCustomerDetailsFromMicroservice() {
        Single<List<Address>> onErrorReturn = CustomerAddressesRepositoryKt.getCustomerAddressesSingle(this.customerAddressesRepository, GlobalDataModel.SelectedCountryId).onErrorReturn(new f());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "customerAddressesReposit…rorReturn { ArrayList() }");
        Disposable subscribe = Single.zip(getLoadCustomerDetailsSingle(), onErrorReturn, new g()).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "zip(\n                loa…ponse(it) }\n            }");
        this.loadCustomerInfoDisposable = subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCustomerDetailsFromMicroservice$lambda-0  reason: not valid java name */
    public static final List m10100loadCustomerDetailsFromMicroservice$lambda0(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCustomerDetailsFromMicroservice$lambda-1  reason: not valid java name */
    public static final Pair m10101loadCustomerDetailsFromMicroservice$lambda1(CustomerAddressInfoJsonResult customerAddressInfoJsonResult, List list) {
        Intrinsics.checkNotNullParameter(customerAddressInfoJsonResult, "t1");
        Intrinsics.checkNotNullParameter(list, "t2");
        return new Pair(customerAddressInfoJsonResult, list);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCustomerDetailsFromMicroservice$lambda-3  reason: not valid java name */
    public static final void m10102loadCustomerDetailsFromMicroservice$lambda3(DarkstoresBridgeInteractor darkstoresBridgeInteractor, Throwable th2) {
        VolleyError volleyError;
        Intrinsics.checkNotNullParameter(darkstoresBridgeInteractor, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            volleyError = (VolleyError) th2;
        } else {
            volleyError = null;
        }
        if (volleyError != null) {
            darkstoresBridgeInteractor.onRequestError().onErrorResponse(volleyError);
        }
    }

    private final Response.Listener<CustomerAddressInfoJsonResult> onAddressReceived(boolean z11) {
        return new c(this, z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAddressReceived$lambda-5  reason: not valid java name */
    public static final void m10103onAddressReceived$lambda5(DarkstoresBridgeInteractor darkstoresBridgeInteractor, boolean z11, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        Intrinsics.checkNotNullParameter(darkstoresBridgeInteractor, "this$0");
        if (darkstoresBridgeInteractor.mListener != null) {
            Customer instance = Customer.getInstance();
            if (z11) {
                instance.setCustomerAddress(customerAddressInfoJsonResult.result.addresses);
            }
            BridgeCallbackListener bridgeCallbackListener = darkstoresBridgeInteractor.mListener;
            Intrinsics.checkNotNullExpressionValue(customerAddressInfoJsonResult, "response");
            bridgeCallbackListener.onCustomerinfoLoaded(customerAddressInfoJsonResult);
            instance.setSavedCreditCards(customerAddressInfoJsonResult.result.tokens);
        }
    }

    private final Response.Listener<GeoAddressRequest> onGeoAddressRecieved() {
        return new a(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onGeoAddressRecieved$lambda-6  reason: not valid java name */
    public static final void m10104onGeoAddressRecieved$lambda6(DarkstoresBridgeInteractor darkstoresBridgeInteractor, GeoAddressRequest geoAddressRequest) {
        Intrinsics.checkNotNullParameter(darkstoresBridgeInteractor, "this$0");
        BridgeCallbackListener bridgeCallbackListener = darkstoresBridgeInteractor.mListener;
        if (bridgeCallbackListener == null) {
            bridgeCallbackListener.geoAddressNotReceived();
        } else if (geoAddressRequest != null) {
            Address address = geoAddressRequest.result;
            if (address != null) {
                bridgeCallbackListener.onGeoAddressRecieved(address, darkstoresBridgeInteractor.userSelectedaddress);
            }
        } else {
            bridgeCallbackListener.geoAddressNotReceived();
        }
    }

    private final Response.ErrorListener onRequestError() {
        return new j(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestError$lambda-7  reason: not valid java name */
    public static final void m10105onRequestError$lambda7(DarkstoresBridgeInteractor darkstoresBridgeInteractor, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(darkstoresBridgeInteractor, "this$0");
        if (volleyError instanceof ServerError) {
            BridgeCallbackListener bridgeCallbackListener = darkstoresBridgeInteractor.mListener;
            if (bridgeCallbackListener != null) {
                bridgeCallbackListener.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            BridgeCallbackListener bridgeCallbackListener2 = darkstoresBridgeInteractor.mListener;
            if (bridgeCallbackListener2 != null) {
                bridgeCallbackListener2.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            BridgeCallbackListener bridgeCallbackListener3 = darkstoresBridgeInteractor.mListener;
            if (bridgeCallbackListener3 != null) {
                bridgeCallbackListener3.onDataError();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    @Nullable
    public Restaurant getDarkstore() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return GlobalDataModel.SELECTED.restaurant;
        }
        return restaurant;
    }

    @NotNull
    public final BridgeCallbackListener getMListener() {
        return this.mListener;
    }

    public void loadCustomerDetails() {
        if (loadCustomerDetails$canInvokeAddressMicroService(this)) {
            loadCustomerDetailsFromMicroservice();
            return;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        GsonRequest.Builder<CustomerAddressInfoJsonResult> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", sb2.toString()})).setClazz(CustomerAddressInfoJsonResult.class).setListener(onAddressReceived(true)).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    public final void setMListener(@NotNull BridgeCallbackListener bridgeCallbackListener) {
        Intrinsics.checkNotNullParameter(bridgeCallbackListener, "<set-?>");
        this.mListener = bridgeCallbackListener;
    }

    public void updateAddresswithGoogleAddress(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.userSelectedaddress = address;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETGOOGLEADDRESSV2;
        double d11 = address.latitude;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d11);
        double d12 = address.longitude;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(d12);
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i11);
        GsonRequest.Builder<GeoAddressRequest> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", sb2.toString(), "{longitude}", sb3.toString(), "{countryid}", sb4.toString()})).setClazz(GeoAddressRequest.class).setListener(onGeoAddressRecieved()).setErrorListener(onRequestError());
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    public void updateCartSpecialRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "darkstoresSpecialRequest");
        Cart.getInstance().setGeneralRequest(str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DarkstoresBridgeInteractor(com.talabat.darkstores.interactor.DarkstoresBridgeInteractor.BridgeCallbackListener r13, com.talabat.user.address.domain.repository.CustomerAddressesRepository r14, library.talabat.mvp.login.domain.repository.CustomerRepository r15, com.talabat.configuration.discovery.AppVersionProvider r16, com.talabat.configuration.discovery.DiscoveryConfigurationRepository r17, com.talabat.configuration.location.LocationConfigurationRepository r18, io.reactivex.Scheduler r19, io.reactivex.Scheduler r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r2 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r10 = r1
            goto L_0x0013
        L_0x0011:
            r10 = r19
        L_0x0013:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0022
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r11 = r0
            goto L_0x0024
        L_0x0022:
            r11 = r20
        L_0x0024:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.interactor.DarkstoresBridgeInteractor.<init>(com.talabat.darkstores.interactor.DarkstoresBridgeInteractor$BridgeCallbackListener, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.configuration.discovery.AppVersionProvider, com.talabat.configuration.discovery.DiscoveryConfigurationRepository, com.talabat.configuration.location.LocationConfigurationRepository, io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
