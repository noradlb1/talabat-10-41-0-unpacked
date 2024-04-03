package library.talabat.mvp.home;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.ICustomer;
import com.android.volley.VolleyError;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.feature.bnplcore.domain.BnplObservabilityConstants;
import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Restaurant;
import h10.a;
import h10.b;
import h10.c;
import h10.d;
import h10.e;
import h10.f;
import h10.g;
import h10.h;
import h10.i;
import h10.j;
import h10.k;
import h10.l;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.RxSingleKt;
import library.talabat.mvp.address.DistanceSortedAddress;
import library.talabat.mvp.home.domain.EnableShowLocationSelectionInHomeScreenUseCase;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;
import library.talabat.mvp.home.domain.ShouldShowLocationSelectionInHomeUseCase;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.TalabatAppBoy;
import tracking.gtm.GTMCart;
import tracking.gtm.TrackingUtils;

@Instrumented
public class HomePresenter implements IHomePresenter, HomeScreenListener {
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final CoroutineDispatcher coroutineDispatcher;
    private CoroutineDispatchersFactory coroutineDispatchersFactory;
    private final ICustomer customer;
    private final CustomerRepository customerRepository;
    private final EnableShowLocationSelectionInHomeScreenUseCase enableShowLocationSelectionInHomeScreenUseCase;
    private Disposable getActiveCartInfoDisposable = Disposables.empty();
    private final GetActiveCartInfoUseCase getActiveCartInfoUseCase;
    private Disposable getEncryptedOrderIdForLastOrderDisposable = Disposables.empty();
    private Disposable getOverdueDisposable = Disposables.empty();
    private final GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase;
    private final GetOverdueUseCase getOverdueUseCase;
    private final GTMCart gtmCart;
    private HomeView homeView;
    private IHomeInteractor iHomeInteractor;
    private final Scheduler ioScheduler;
    private final IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase;
    private Disposable isOnboardingExperimentDisposable = Disposables.empty();
    private final IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase;
    private final Scheduler mainScheduler;
    private final MutableLocationConfigurationRepository mutableLocationConfigurationRepository;
    private final IObservabilityManager observabilityManager;
    private final ShouldRateLastOrderUseCase shouldRateLastOrderUseCase;
    private Disposable shouldShowLocationSelectionDisposable = Disposables.empty();
    private final ShouldShowLocationSelectionInHomeUseCase shouldShowLocationSelectionInHomeUseCase;
    private final ITalabatFeatureFlag talabatFeatureFlag;
    private Disposable updateOverdueAcknowledgeStateDisposable = Disposables.empty();
    private final UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase;

    public HomePresenter(HomeView homeView2, ShouldShowLocationSelectionInHomeUseCase shouldShowLocationSelectionInHomeUseCase2, EnableShowLocationSelectionInHomeScreenUseCase enableShowLocationSelectionInHomeScreenUseCase2, GetOverdueUseCase getOverdueUseCase2, GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase2, UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase2, Scheduler scheduler, Scheduler scheduler2, IObservabilityManager iObservabilityManager, ITalabatFeatureFlag iTalabatFeatureFlag, ICustomer iCustomer, AppVersionProvider appVersionProvider, ConfigurationLocalRepository configurationLocalRepository2, MutableLocationConfigurationRepository mutableLocationConfigurationRepository2, GetActiveCartInfoUseCase getActiveCartInfoUseCase2, GTMCart gTMCart, ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2, CoroutineDispatcher coroutineDispatcher2, CustomerRepository customerRepository2, IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase2, IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase2, CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        this.homeView = homeView2;
        this.shouldShowLocationSelectionInHomeUseCase = shouldShowLocationSelectionInHomeUseCase2;
        this.enableShowLocationSelectionInHomeScreenUseCase = enableShowLocationSelectionInHomeScreenUseCase2;
        this.getOverdueUseCase = getOverdueUseCase2;
        this.getOverdueNotificationAcknowledgeUseCase = getOverdueNotificationAcknowledgeUseCase2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.updateOverdueAcknowledgeStateUseCase = updateOverdueAcknowledgeStateUseCase2;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.observabilityManager = iObservabilityManager;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository2;
        this.shouldRateLastOrderUseCase = shouldRateLastOrderUseCase2;
        this.coroutineDispatcher = coroutineDispatcher2;
        this.customerRepository = customerRepository2;
        this.isOnboardingExperimentEnabledUseCase = isOnboardingExperimentEnabledUseCase2;
        this.iHomeInteractor = new HomeInteractor(this, iTalabatFeatureFlag, appVersionProvider);
        this.customer = iCustomer;
        this.getActiveCartInfoUseCase = getActiveCartInfoUseCase2;
        this.gtmCart = gTMCart;
        this.isNfvFlutterNavigationUsecase = isNfvFlutterNavigationUsecase2;
        try {
            Customer.getInstance().initSelectedCustomerAddressId(homeView2.getContext());
        } catch (Exception e11) {
            LogManager.error(e11, "Error selecting customer address ID");
        }
    }

    private void DistanceSortedAddressSelected(Address address) {
        GlobalDataModel.SelectedAreaId = address.areaId;
        GlobalDataModel.SelectedAreaName = address.areaName;
        int i11 = address.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, this.configurationLocalRepository, this.mutableLocationConfigurationRepository);
        SharedPreferences.Editor edit = this.homeView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, GlobalDataModel.SelectedCityName);
        edit.apply();
        Customer.getInstance().setSelectedCustomerAddress(this.homeView.getContext(), address.f58343id, address.areaId);
        Customer.getInstance().setBrandScreenLocalAddress();
        TalabatAppBoy.onLastSearchedLocation(this.homeView.getContext(), address.latitude, address.longitude);
    }

    private boolean checkSelectedAddressAndSortedAddress(Customer customer2, Address address) {
        if (!TalabatUtils.isNullOrEmpty(customer2.getSelectedCustomerAddressId())) {
            return !address.f58343id.equals(customer2.getSelectedCustomerAddressId());
        }
        return true;
    }

    private void clearCart() {
        if (Cart.getInstance() != null && Cart.getInstance().hasItems()) {
            Cart.getInstance().clearCart(this.homeView.getContext());
        }
    }

    private void fetchCurrentLocationBasedAddress(LatLng latLng) {
        this.iHomeInteractor.fetchAddressBasedOnLatLng(latLng);
    }

    private void getBnplOverdue() {
        if (this.customer.isLoggedIn()) {
            this.getOverdueDisposable = this.getOverdueNotificationAcknowledgeUseCase.invoke().flatMap(new h(this)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new i(this), new j(this));
        }
    }

    @NonNull
    private Object getEncryptedOrderIdForLastOrder(Continuation<? super String> continuation) {
        Object encryptedOrderIdForLastOrder = this.shouldRateLastOrderUseCase.getEncryptedOrderIdForLastOrder(continuation);
        if (encryptedOrderIdForLastOrder != null) {
            return encryptedOrderIdForLastOrder;
        }
        return "";
    }

    private void handleMapRedirection(boolean z11, boolean z12) {
        if (z11) {
            this.homeView.redirectToHomeMapScreen(false, "", true);
        } else if (z12) {
            resetLocationAfterCountrySelection();
        }
    }

    private void handleNFVNavigation(int i11, String str, List<Integer> list) {
        if (this.isNfvFlutterNavigationUsecase.invoke()) {
            navigateToGroceryHome(i11, str, list);
        } else {
            this.homeView.navigateToVendorListScreen(false);
        }
    }

    /* access modifiers changed from: private */
    public void handleRatingBottomSheetError(Throwable th2) {
        LogManager.error(th2, "FlutterHome: Could not show Rating Bottom Sheet");
        HashMap hashMap = new HashMap();
        hashMap.put("error_message", th2.getMessage());
        hashMap.put("error_stacktrace", ExceptionUtils.getStackTrace(th2));
        this.observabilityManager.trackUnExpectedScenario("home_screen_rating_bottom_sheet_error", hashMap);
    }

    private boolean hasSelectedArea() {
        return !TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName) || GlobalDataModel.SelectedAreaId > 0;
    }

    private boolean isCartContainsItem() {
        return Cart.getInstance().hasItems();
    }

    private boolean isTempHomeMapAddressAvailable() {
        if (GlobalDataModel.SelectedAreaId <= 0 || HomeMapTemp.INSTANCE.getHomeMapSavedLatLng() == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$checkOnboardingFlowExperiement$4(CoroutineScope coroutineScope, Continuation continuation) {
        return this.isOnboardingExperimentEnabledUseCase.invoke(continuation);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkOnboardingFlowExperiement$5(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.homeView.showNotificationPermissionDialog();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$getBnplOverdue$0(OverdueAcknowledgeState overdueAcknowledgeState) throws Exception {
        if (overdueAcknowledgeState.isUnAcknowledged()) {
            return this.getOverdueUseCase.invoke();
        }
        return Single.just(GetOverdueUseCase.OverdueResult.NoOverdue.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setCartView$2(ActiveCartInfo activeCartInfo) throws Exception {
        this.homeView.showCartView(activeCartInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setCartView$3(Throwable th2) throws Exception {
        this.homeView.hideCartView();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showLocationSelectionScreen$8(ShouldShowLocationSelectionInHomeUseCase.Result result) throws Exception {
        if (result instanceof ShouldShowLocationSelectionInHomeUseCase.Result.ShouldShow) {
            toolbarLocationSelection();
            return;
        }
        LogManager logManager = LogManager.INSTANCE;
        LogManager.info("Got " + result.toString() + " for shouldShowLocationSelection");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$showRatingBottomSheet$6(CoroutineScope coroutineScope, Continuation continuation) {
        return getEncryptedOrderIdForLastOrder(continuation);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showRatingBottomSheet$7(String str) throws Exception {
        if (!Strings.isEmptyOrWhitespace(str)) {
            this.homeView.showRatingBottomSheetForLastOrder(str);
        }
    }

    private void navigateToGroceryHome(int i11, String str, List<Integer> list) {
        this.homeView.loadGroceryHomeScreen(i11, str, list);
    }

    private void redirectToMapOrAddressSelection() {
        ICustomer iCustomer = this.customer;
        if (iCustomer == null || !iCustomer.isLoggedIn() || !iCustomer.hasAddresses()) {
            this.homeView.redirectToHomeMapScreen(shouldIgnoreLocation(iCustomer), "", true);
            return;
        }
        this.homeView.redirectToChooseSavedAddressScreen(true);
    }

    private void redirectToVendorList(int i11, String str, List<Integer> list) {
        boolean z11 = true;
        if (i11 != 1) {
            if (i11 == 2 || i11 == 3) {
                handleNFVNavigation(i11, str, list);
                return;
            } else if (i11 != 10) {
                HomeView homeView2 = this.homeView;
                if (i11 != 0) {
                    z11 = false;
                }
                homeView2.navigateToVendorListScreen(z11);
                return;
            }
        }
        navigateToGroceryHome(i11, str, list);
    }

    private void redirectToVendorListOrAddressSelection(int i11, String str, List<Integer> list) {
        if (isTempHomeMapAddressAvailable()) {
            redirectToVendorListWithTracking(i11, str, list);
        } else {
            this.homeView.redirectToChooseSavedAddressScreen(false);
        }
    }

    private void redirectToVendorListOrMap(int i11, String str, List<Integer> list) {
        if (isTempHomeMapAddressAvailable()) {
            redirectToVendorListWithTracking(i11, str, list);
        } else {
            this.homeView.redirectToHomeMapScreen(hasSelectedArea(), "", false);
        }
    }

    private void redirectToVendorListWithTracking(int i11, String str, List<Integer> list) {
        HomeMapTemp.INSTANCE.setHomeMapRedirect(true, this.homeView.getContext());
        redirectToVendorList(i11, str, list);
    }

    private void resetLocationFromOtherCountry() {
        GlobalDataModel.RECENT_LATLONG.latitude = 0.0d;
        GlobalDataModel.RECENT_LATLONG.longitude = 0.0d;
        Customer instance = Customer.getInstance();
        if (instance == null) {
            return;
        }
        if (!instance.isLoggedIn()) {
            HomeMapTemp.INSTANCE.resetPref(this.homeView.getContext());
        } else if (instance.getSelectedCustomerAddress() != null) {
            instance.deselectCustomerAddress();
        }
    }

    private void sendCartClickedEvent(Restaurant restaurant) {
        String screenName = this.homeView.getScreenName();
        GTMCart gTMCart = this.gtmCart;
        String screenType = ScreenNames.getScreenType(screenName);
        String valueOf = String.valueOf(restaurant.f13872id);
        String str = restaurant.f13873name;
        if (str == null) {
            str = "";
        }
        gTMCart.cartClicked(screenName, screenType, valueOf, str, GlobalDataModel.ShopClickOrigin, restaurant.getShopType());
    }

    private void setReverseGeoAddress(Address address, LatLng latLng) {
        GlobalDataModel.SelectedAreaId = address.areaId;
        GlobalDataModel.SelectedAreaName = address.areaName;
        int i11 = address.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, this.configurationLocalRepository, this.mutableLocationConfigurationRepository);
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = 18.0f;
        GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION = 0;
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.setHomeMapLatLng(latLng, this.homeView.getContext());
        homeMapTemp.setHomeMapZoomeLevel(Float.valueOf(18.0f));
        homeMapTemp.setTempAreaId(address.areaId);
        String str = address.street;
        if (str != null) {
            homeMapTemp.setStreetName(str);
        }
        homeMapTemp.settempAddress(address);
        SharedPreferences.Editor edit = this.homeView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, "" + latLng.latitude + "," + latLng.longitude);
        edit.putFloat(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM, 18.0f);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, address.areaId);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, address.street);
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, storeTempAddress(address));
        edit.apply();
        Customer.getInstance().deselectCustomerAddress(this.homeView.getContext());
        homeMapTemp.setHomeMapRedirect(true, this.homeView.getContext());
    }

    private void setupAccountTab() {
        this.homeView.setupAccountTab(this.customerRepository.isTPro());
    }

    private boolean shouldIgnoreLocation(@Nullable ICustomer iCustomer) {
        if (iCustomer == null) {
            return hasSelectedArea();
        }
        if (iCustomer.isLoggedIn() || HomeMapTemp.INSTANCE.getHomeMapSavedLatLng() == null) {
            return false;
        }
        return true;
    }

    private void showLocationSelectionScreen(boolean z11) {
        if (z11) {
            this.enableShowLocationSelectionInHomeScreenUseCase.enableShowLocationSelectionInHomeScreen();
        }
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SELECT_ADDRESS_ON_HOME, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.shouldShowLocationSelectionDisposable = this.shouldShowLocationSelectionInHomeUseCase.shouldShowLocationSelection().subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).delaySubscription(1, TimeUnit.SECONDS).subscribe(new a(this), new xq.a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotification */
    public void lambda$getBnplOverdue$1(GetOverdueUseCase.OverdueResult overdueResult) {
        if (!this.homeView.isAccountSelected() && (overdueResult instanceof GetOverdueUseCase.OverdueResult.Overdue)) {
            this.homeView.showOverdueNotification();
        } else if (overdueResult instanceof GetOverdueUseCase.OverdueResult.NoOverdue) {
            this.homeView.checkVouchersState();
        }
    }

    private void showRatingBottomSheet() {
        this.getEncryptedOrderIdForLastOrderDisposable = RxSingleKt.rxSingle(this.coroutineDispatcher, new k(this)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new l(this), new b(this));
    }

    @Deprecated
    private Address sortAddressBasedOnLocation(LatLng latLng, ArrayList<Address> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<Address> it = arrayList.iterator();
        while (it.hasNext()) {
            Address next = it.next();
            double d11 = next.latitude;
            if (d11 > 0.0d) {
                double d12 = next.longitude;
                if (d12 > 0.0d) {
                    Double valueOf = Double.valueOf(HomeMapUtils.INSTANCE.distanceBetweenTwoCordinatesbet(latLng.latitude, latLng.longitude, d11, d12));
                    if (valueOf.doubleValue() < 480.0d) {
                        arrayList2.add(new DistanceSortedAddress(valueOf.doubleValue(), next));
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, new Comparator<DistanceSortedAddress>() {
                public int compare(DistanceSortedAddress distanceSortedAddress, DistanceSortedAddress distanceSortedAddress2) {
                    return Double.compare(distanceSortedAddress.distance, distanceSortedAddress2.distance);
                }
            });
        } else {
            this.homeView.resetAddressName();
        }
        if (arrayList2.size() > 0) {
            return ((DistanceSortedAddress) arrayList2.get(0)).address;
        }
        return null;
    }

    private String storeTempAddress(Address address) {
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            return gson.toJson((Object) address);
        }
        return GsonInstrumentation.toJson(gson, (Object) address);
    }

    private void trackAddressGpsSnapping(String str, double d11, double d12, double d13) {
        String str2;
        Context context = this.homeView.getContext();
        if (d11 == 0.0d) {
            str2 = TrackingUtils.INSTANCE.getTrackingDataNotAvail();
        } else {
            str2 = "" + d11;
        }
        AppTracker.onSnappingGpsInfo(context, str, str2, "" + d12, "" + d13);
    }

    /* access modifiers changed from: private */
    public void trackUnExpectedScenario(Throwable th2) {
        String str;
        HashMap hashMap = new HashMap();
        if (th2.getMessage() != null) {
            str = th2.getMessage();
        } else {
            str = "";
        }
        hashMap.put("errorMessage", str);
        this.observabilityManager.trackUnExpectedScenario(BnplObservabilityConstants.EXPLANATION_BNPL_OVERDUES_NOTIFICATION_EXCEPTION, hashMap);
    }

    public void LocationBasedAddressSelection(LatLng latLng) {
        double d11;
        double d12;
        String str;
        double d13;
        double d14;
        LatLng latLng2 = latLng;
        Customer instance = Customer.getInstance();
        double d15 = 0.0d;
        if (latLng2 != null) {
            double d16 = latLng2.latitude;
            if (d16 > 0.0d && latLng2.longitude > 0.0d) {
                HomeMapTemp.INSTANCE.setUserCurrentLocation(Double.valueOf(d16), Double.valueOf(latLng2.longitude));
            }
        } else {
            latLng2 = new LatLng(0.0d, 0.0d);
        }
        String trackingDataNotAvail = TrackingUtils.INSTANCE.getTrackingDataNotAvail();
        if (!isCartContainsItem()) {
            if (!instance.isLoggedIn()) {
                fetchCurrentLocationBasedAddress(latLng2);
                d11 = 0.0d;
                str = trackingDataNotAvail;
                d12 = 0.0d;
            } else if (!instance.hasAddresses()) {
                str = TrackingUtils.TrackAddressSnappingCases.SnapAddressToCurrentLocation.getValue();
                d12 = latLng2.latitude;
                d11 = latLng2.longitude;
                fetchCurrentLocationBasedAddress(latLng2);
            } else if (instance.getCustomerAddress() == null || instance.getCustomerAddress().size() <= 0) {
                str = TrackingUtils.TrackAddressSnappingCases.SnapAddressToCurrentLocation.getValue();
                d12 = latLng2.latitude;
                d11 = latLng2.longitude;
                fetchCurrentLocationBasedAddress(latLng2);
            } else {
                Address sortAddressBasedOnLocation = sortAddressBasedOnLocation(latLng2, instance.getCustomerAddress());
                if (sortAddressBasedOnLocation != null) {
                    if (checkSelectedAddressAndSortedAddress(instance, sortAddressBasedOnLocation)) {
                        clearCart();
                    }
                    str = TrackingUtils.TrackAddressSnappingCases.SnapToSavedAddressBasedOnCurrentLocation.getValue();
                    d15 = HomeMapUtils.INSTANCE.distanceBetweenTwoCordinatesbet(latLng2.latitude, latLng2.longitude, sortAddressBasedOnLocation.latitude, sortAddressBasedOnLocation.longitude);
                    d14 = sortAddressBasedOnLocation.latitude;
                    d13 = sortAddressBasedOnLocation.longitude;
                    DistanceSortedAddressSelected(sortAddressBasedOnLocation);
                    this.homeView.setToolBarAddressLocationTitle(sortAddressBasedOnLocation.profileName + " (" + sortAddressBasedOnLocation.areaName + ")");
                    this.homeView.resetCurrentLocationObserver();
                } else {
                    str = TrackingUtils.TrackAddressSnappingCases.SnapToCurrentLocataionNotSortedAddressFound.getValue();
                    this.homeView.showLocationFetching();
                    d14 = latLng2.latitude;
                    d13 = latLng2.longitude;
                    fetchCurrentLocationBasedAddress(latLng2);
                }
                d12 = d14;
                d11 = d13;
            }
            trackAddressGpsSnapping(str, d15, d12, d11);
        }
    }

    public void basketSelection(ActiveCartInfo activeCartInfo) {
        if (activeCartInfo instanceof ActiveCartInfo.FoodCart) {
            sendCartClickedEvent(((ActiveCartInfo.FoodCart) activeCartInfo).getRestaurant());
            this.homeView.openFoodBasketScreen();
        } else if (activeCartInfo instanceof ActiveCartInfo.QcommerceCart) {
            ActiveCartInfo.QcommerceCart qcommerceCart = (ActiveCartInfo.QcommerceCart) activeCartInfo;
            sendCartClickedEvent(qcommerceCart.getRestaurant());
            this.homeView.openQCommerceBasketScreen(qcommerceCart.getRestaurant());
        } else if (activeCartInfo instanceof ActiveCartInfo.MultipleCarts) {
            this.homeView.openBasketListScreen();
        }
    }

    public void checkOnboardingFlowExperiement() {
        this.isOnboardingExperimentDisposable = RxSingleKt.rxSingle(this.coroutineDispatchersFactory.io(), new d(this)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new e(this), new xq.a());
    }

    public void fetchUserCurrentLocationFromAppStart(boolean z11) {
        if (z11) {
            this.homeView.setCurrentLocationFromBeginning();
        }
    }

    public boolean ifShouldTrackHomeScreenValue(boolean z11, boolean z12, boolean z13) {
        return !z11 && !z12 && !z13;
    }

    public void onCreate(boolean z11, boolean z12, boolean z13) {
        handleMapRedirection(z11, z12);
        showLocationSelectionScreen(z13);
        getBnplOverdue();
    }

    public void onDataError() {
        this.homeView.onDataError();
    }

    public void onDestroy() {
        this.shouldShowLocationSelectionDisposable.dispose();
        this.getOverdueDisposable.dispose();
        this.updateOverdueAcknowledgeStateDisposable.dispose();
        this.getActiveCartInfoDisposable.dispose();
        this.getEncryptedOrderIdForLastOrderDisposable.dispose();
        this.isOnboardingExperimentDisposable.dispose();
        this.homeView = null;
        IHomeInteractor iHomeInteractor2 = this.iHomeInteractor;
        if (iHomeInteractor2 != null) {
            iHomeInteractor2.unregister();
        }
        this.iHomeInteractor = null;
    }

    public void onFlutterHomeAttached() {
        showRatingBottomSheet();
        setupAccountTab();
    }

    public void onGeoAddressReceieved(Address address, LatLng latLng) {
        String str;
        clearCart();
        this.homeView.resetCurrentLocationObserver();
        if (address == null) {
            this.homeView.resetAddressName();
        } else if (address.countyId == GlobalDataModel.SelectedCountryId) {
            setReverseGeoAddress(address, latLng);
            HomeView homeView2 = this.homeView;
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (!TalabatUtils.isNullOrEmpty(homeMapTemp.getHomeMapStreetName())) {
                str = homeMapTemp.getHomeMapStreetName() + " ";
            } else {
                str = GlobalDataModel.SelectedAreaName;
            }
            homeView2.setToolBarAddressLocationTitle(str);
        } else {
            resetLocationFromOtherCountry();
            this.homeView.outSideCountry(address.countyId);
        }
        this.homeView.refreshHomeScreen();
    }

    public void onNetworkError() {
        this.homeView.onNetworkError();
    }

    public void onReverseGeoAddressError() {
        this.homeView.stopLodingPopup();
        this.homeView.resetAddressName();
        this.homeView.resetCurrentLocationObserver();
    }

    public void onServerError(VolleyError volleyError) {
        this.homeView.onServerError(volleyError);
    }

    public void onUserAccountTabClicked() {
        if (this.customer.isLoggedIn() && this.homeView.isOverdueNotificationVisible()) {
            Completable observeOn = this.updateOverdueAcknowledgeStateUseCase.invoke(OverdueAcknowledgeState.ACKNOWLEDGED).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler);
            HomeView homeView2 = this.homeView;
            Objects.requireNonNull(homeView2);
            this.updateOverdueAcknowledgeStateDisposable = observeOn.subscribe(new c(homeView2), new j(this));
        }
    }

    public void onVerticalClicked(int i11, String str, List<Integer> list) {
        ICustomer iCustomer = this.customer;
        if (iCustomer == null || !iCustomer.isLoggedIn() || !iCustomer.hasAddresses()) {
            redirectToVendorListOrMap(i11, str, list);
            return;
        }
        Address selectedCustomerAddress = iCustomer.getSelectedCustomerAddress();
        if (selectedCustomerAddress == null || !AddressesKt.isValid(selectedCustomerAddress)) {
            redirectToVendorListOrAddressSelection(i11, str, list);
        } else {
            redirectToVendorList(i11, str, list);
        }
    }

    public void resetLocationAfterCountrySelection() {
        redirectToMapOrAddressSelection();
    }

    public void resetToolBarLocationTitle() {
        this.homeView.setToolBarAddressLocationTitle("");
    }

    public void setCartView() {
        this.getActiveCartInfoDisposable = this.getActiveCartInfoUseCase.invoke().toSingle().subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new f(this), new g(this));
    }

    public void setToolBarLocation() {
        String str;
        Customer instance = Customer.getInstance();
        if (!instance.isLoggedIn() || instance.getSelectedCustomerAddress() == null) {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (!TalabatUtils.isNullOrEmpty(homeMapTemp.getHomeMapStreetName())) {
                str = homeMapTemp.getHomeMapStreetName() + " " + GlobalDataModel.SelectedAreaName;
            } else {
                str = GlobalDataModel.SelectedAreaName;
            }
        } else {
            str = instance.getSelectedCustomerAddress().profileName + " (" + instance.getSelectedCustomerAddress().areaName + ")";
        }
        this.homeView.setToolBarAddressLocationTitle(str);
    }

    public void toolbarLocationSelection() {
        redirectToMapOrAddressSelection();
    }

    public void toolbarSearchSelection() {
        this.homeView.redirectToSearchScreen();
    }

    public void trackAddressSnappingWithoutGps() {
        if (Customer.getInstance().getSelectedCustomerAddress() != null || isTempHomeMapAddressAvailable()) {
            Context context = this.homeView.getContext();
            String value = TrackingUtils.TrackAddressSnappingCases.SnapAddressWithNoGps.getValue();
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            AppTracker.onSnappingGpsInfo(context, value, trackingUtils.getTrackingDataNotAvail(), trackingUtils.getTrackingDataNotAvail(), trackingUtils.getTrackingDataNotAvail());
        }
    }
}
