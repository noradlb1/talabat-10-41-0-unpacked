package tracking.deeplink;

import JsonModels.AreaPreoloadResponse;
import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.OrderDetailsRM;
import JsonModels.QuickFindRestaurantsResponse;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Request.RestaurantReq;
import JsonModels.Response.AppInitRM;
import JsonModels.Response.CuisinesResult;
import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.RateOrderResponse;
import JsonModels.Response.RestaurantDetailsWithDelAreasRM;
import JsonModels.Response.RestaurantSlugRM;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.Response.UserInfoResult;
import JsonModels.RestaurantDetailsWithDelAreasResponseModel;
import JsonModels.RestaurantListJM;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.City;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.squads.nfv.ObservableErrorMessages;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.repository.CustomerAddressesRepositoryKt;
import datamodels.Area;
import datamodels.Filter;
import datamodels.GemTier;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import datamodels.mappers.OldAreaToAreaMapper;
import datamodels.mappers.OldCityToCityMapper;
import datamodels.mappers.OldCountryToCountryMapper;
import g40.a;
import g40.b;
import g40.c;
import g40.d;
import g40.f;
import g40.g;
import g40.h;
import g40.i;
import g40.j;
import g40.k;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.com.talabatlib.RestuarntListResponse;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.HttpException;
import rj.e;
import service.ApiHandler;
import tracking.observability.VendorInfoAPIObservability;

@Instrumented
public class DeepLinkInteractor implements IDeepLinkInteractor {

    /* renamed from: a  reason: collision with root package name */
    public String f63517a;
    /* access modifiers changed from: private */
    public final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f63518b;
    private CityToOldCityMapper cityToOldCityMapper;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private Context context;
    private CountryToOldCountryMapper countryToOldCountryMapper;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CustomerRepository customerRepository;
    /* access modifiers changed from: private */
    public DeeplinkRequestListener deeplinkRequestListener;
    private final Scheduler ioScheduler;
    private Disposable loadAppInfoWithAddressesForCountrySpecificDisposable = Disposables.empty();
    private Disposable loadAppInfoWithAddressesForRequiredDataDisposable = Disposables.empty();
    /* access modifiers changed from: private */
    public final MutableLocationConfigurationRepository locationConfigRepository;
    private final Scheduler mainScheduler;
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    /* access modifiers changed from: private */
    public final ITalabatFeatureFlag talabatFeatureFlag;
    private VendorInfoAPIObservability vendorInfoAPIObservability;

    public DeepLinkInteractor(DeeplinkRequestListener deeplinkRequestListener2, CustomerAddressesRepository customerAddressesRepository2, CustomerRepository customerRepository2, ConfigurationLocalRepository configurationLocalRepository2, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, Scheduler scheduler, Scheduler scheduler2, MutableConfigurationLocalRepository mutableConfigurationLocalRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, ITalabatFeatureFlag iTalabatFeatureFlag, AppVersionProvider appVersionProvider2, VendorInfoAPIObservability vendorInfoAPIObservability2) {
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.deeplinkRequestListener = deeplinkRequestListener2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = mutableLocationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.appVersionProvider = appVersionProvider2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.vendorInfoAPIObservability = vendorInfoAPIObservability2;
    }

    private Boolean canInvokeAddressMicroService() {
        boolean z11;
        if (!this.locationConfigRepository.config().isAddressMicroServiceEnabled() || !LoggedInHelper.isLoggedIn()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    private Single<AppInitRM> getAppInfoSingle() {
        return Single.create(new a(this));
    }

    private Single<List<Address>> getCustomerAddressesFromMicroservice() {
        return CustomerAddressesRepositoryKt.getCustomerAddressesSingle(this.customerAddressesRepository, GlobalDataModel.SelectedCountryId).onErrorReturn(new j());
    }

    private void getRestaurantWithNewApi(int i11, int i12) {
        GlobalDataModel.SELECTED.updateRestaurant((Restaurant) null);
        this.f63518b = Observable.zip(getVendorsApi(i11, i12), getRestaurantsInfoApi(i11, i12), new BiFunction<RestuarntListResponse, RestuarntListResponse, RestuarntListResponse>() {
            public RestuarntListResponse apply(RestuarntListResponse restuarntListResponse, RestuarntListResponse restuarntListResponse2) throws Exception {
                RestaurantListJM restaurantListJM = restuarntListResponse2.result;
                RestaurantListJM restaurantListJM2 = restuarntListResponse.result;
                restaurantListJM.showCollections = restaurantListJM2.showCollections;
                restaurantListJM.restaurants = restaurantListJM2.restaurants;
                return restuarntListResponse2;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<RestuarntListResponse>() {
            public void accept(RestuarntListResponse restuarntListResponse) {
                DeepLinkInteractor.this.onRestaurantsRecieved(restuarntListResponse);
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                DeepLinkInteractor.this.onRequestError();
            }
        });
    }

    private Observable<RestuarntListResponse> getRestaurantsInfoApi(int i11, int i12) {
        return ApiHandler.getInstance().getServices().getRestaurantsInfo(AppUrls.GETRESTANTS_INFO, new RestaurantReq(i11, i12, GlobalDataModel.SelectedCountryId)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<RestuarntListResponse> getVendorsApi(int i11, int i12) {
        return ApiHandler.getInstance().getServices().getNewRestaurantsApi(AppUrls.GETRESTANTS_V2, new RestaurantReq(i11, i12, GlobalDataModel.SelectedCountryId)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public void handleRequiredDataZippedResult(Pair<AppInitRM, List<Address>> pair) {
        this.customerRepository.setCustomerAddresses(pair.getSecond());
        onRequiredDataReceived(false).onResponse(pair.getFirst());
    }

    /* access modifiers changed from: private */
    public void handleZippedResultForCountrySpecificData(Pair<AppInitRM, List<Address>> pair) {
        this.customerRepository.setCustomerAddresses(pair.getSecond());
        onAppinitCountrySpecifiedDataReceived(false).onResponse(pair.getFirst());
    }

    private void initialiseCountryPreferences() {
        List<Country> countries = this.locationConfigRepository.countries();
        datamodels.Country country = null;
        if (this.configurationLocalRepository.selectedCountry().getCountryId() > 0) {
            Iterator<Country> it = countries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Country next = it.next();
                if (next.getCountry().getCountryId() == this.configurationLocalRepository.selectedCountry().getCountryId()) {
                    country = this.countryToOldCountryMapper.apply(next);
                    break;
                }
            }
        } else {
            int countryId = this.locationConfigRepository.config().getCountry().getCountryId();
            if (countryId > 0) {
                Iterator<Country> it2 = countries.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Country next2 = it2.next();
                    if (next2.getCountry().getCountryId() == countryId) {
                        country = this.countryToOldCountryMapper.apply(next2);
                        this.mutableConfigurationLocalRepository.setSelectedCountry(next2.getCountry().getCountryId());
                        GlobalDataModel.SelectedCountryName = next2.getCountry().getCountryName();
                        break;
                    }
                }
            }
        }
        if (country != null) {
            TalabatFormatter.getInstance().setFormat(country.currencySymbol, country.numOfDecimalPlaces, country.f13845id);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getAppInfoSingle$3(SingleEmitter singleEmitter) throws Exception {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        GsonRequest.Builder<AppInitRM> clazz = builder.setUrl(AppUrls.GETAPPINFOV2 + GlobalDataModel.SelectedCountryId).setClazz(AppInitRM.class);
        Objects.requireNonNull(singleEmitter);
        TalabatVolley.addToRequestQueue(clazz.setListener(new h(singleEmitter)).setErrorListener(new e(singleEmitter)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$getCustomerAddressesFromMicroservice$2(Throwable th2) throws Exception {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAppinitCountrySpecifiedDataReceived$6(boolean z11, AppInitRM appInitRM) {
        GlobalDataModel.countries = appInitRM.result.countries;
        OldCountryToCountryMapper oldCountryToCountryMapper = new OldCountryToCountryMapper(new OldCityToCityMapper());
        ArrayList arrayList = new ArrayList();
        for (datamodels.Country apply : appInitRM.result.countries) {
            arrayList.add(oldCountryToCountryMapper.apply(apply));
        }
        LocationConfig config = this.locationConfigRepository.config();
        this.locationConfigRepository.setConfig(config.copy(config.getAddresses(), config.getAreas(), config.getCountry(), arrayList, config.isAddressMicroServiceEnabled(), config.getMetersOfLocationAwareness()));
        List<Country> countries = this.locationConfigRepository.countries();
        LogManager.debug("[ALOVx]: appinfo #4: response=" + appInitRM.result.countries + " config=" + this.locationConfigRepository.config() + " countriesFromConfig=" + this.locationConfigRepository.countries());
        boolean z12 = true;
        boolean z13 = GlobalDataModel.SelectedCountryId > 0;
        if (GlobalDataModel.SelectedCityId <= 0) {
            z12 = false;
        }
        if (z13) {
            Iterator<Country> it = countries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Country next = it.next();
                if (next.getCountry().getCountryId() == this.configurationLocalRepository.selectedCountry().getCountryId()) {
                    GlobalDataModel.SelectedCountryName = next.getCountry().getCountryName();
                    if (z12) {
                        Iterator<City> it2 = next.getCities().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            City next2 = it2.next();
                            if (next2.getId() == GlobalDataModel.SelectedCityId) {
                                GlobalDataModel.SelectedCityName = next2.getName();
                                break;
                            }
                        }
                    }
                }
            }
        }
        initialiseCountryPreferences();
        GlobalDataModel.imageBaseUrl = appInitRM.baseUrl;
        if (this.talabatFeatureFlag.getFeatureFlag(LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false)) {
            LocationConfig config2 = this.locationConfigRepository.config();
            OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
            ArrayList arrayList2 = new ArrayList();
            for (Area apply2 : appInitRM.result.areas) {
                arrayList2.add(oldAreaToAreaMapper.apply(apply2));
            }
            this.locationConfigRepository.setConfig(config2.copy(config2.getAddresses(), arrayList2, config2.getCountry(), config2.getCountries(), config2.isAddressMicroServiceEnabled(), config2.getMetersOfLocationAwareness()));
        } else {
            GlobalDataModel.areas = appInitRM.result.areas;
        }
        GlobalDataModel.CHECKOUTDOTCOM.publicKey = appInitRM.result.publicKey;
        Customer instance = Customer.getInstance();
        if (z11) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.locationConfigRepository.addresses());
            instance.setCustomerAddress((ArrayList<Address>) arrayList3);
        }
        instance.setSavedCreditCards(obtainTokenizedBandCards(appInitRM));
        requestCompleted();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$0(SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null || splitMenuItemsResponse.menu.isEmpty()) {
            DeeplinkRequestListener deeplinkRequestListener2 = this.deeplinkRequestListener;
            if (deeplinkRequestListener2 != null) {
                deeplinkRequestListener2.redirectToHome();
                return;
            }
            return;
        }
        MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
        MenuItemRM menuItemRM = splitMenuRM.result.menu;
        menuItemsResponseModel.menu = menuItemRM;
        MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
        onMenuOrInfoLoaded();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequiredDataReceived$4(boolean z11, AppInitRM appInitRM) {
        GlobalDataModel.countries = appInitRM.result.countries;
        OldCountryToCountryMapper oldCountryToCountryMapper = new OldCountryToCountryMapper(new OldCityToCityMapper());
        ArrayList arrayList = new ArrayList();
        for (datamodels.Country apply : appInitRM.result.countries) {
            arrayList.add(oldCountryToCountryMapper.apply(apply));
        }
        LocationConfig config = this.locationConfigRepository.config();
        this.locationConfigRepository.setConfig(config.copy(config.getAddresses(), config.getAreas(), config.getCountry(), arrayList, config.isAddressMicroServiceEnabled(), config.getMetersOfLocationAwareness()));
        List<Country> countries = this.locationConfigRepository.countries();
        LogManager.debug("[ALOVx]: appinfo #3: response=" + appInitRM.result.countries + " config=" + this.locationConfigRepository.config() + " countriesFromConfig=" + this.locationConfigRepository.countries());
        boolean z12 = true;
        boolean z13 = GlobalDataModel.SelectedCountryId > 0;
        if (GlobalDataModel.SelectedCityId <= 0) {
            z12 = false;
        }
        if (z13) {
            Iterator<Country> it = countries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Country next = it.next();
                if (next.getCountry().getCountryId() == this.configurationLocalRepository.selectedCountry().getCountryId()) {
                    GlobalDataModel.SelectedCountryName = next.getCountry().getCountryName();
                    if (z12) {
                        Iterator<City> it2 = next.getCities().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            City next2 = it2.next();
                            if (next2.getId() == GlobalDataModel.SelectedCityId) {
                                GlobalDataModel.SelectedCityName = next2.getName();
                                break;
                            }
                        }
                    }
                }
            }
        }
        GlobalDataModel.imageBaseUrl = appInitRM.baseUrl;
        if (this.talabatFeatureFlag.getFeatureFlag(LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false)) {
            LocationConfig config2 = this.locationConfigRepository.config();
            OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
            ArrayList arrayList2 = new ArrayList();
            for (Area apply2 : appInitRM.result.areas) {
                arrayList2.add(oldAreaToAreaMapper.apply(apply2));
            }
            this.locationConfigRepository.setConfig(config2.copy(config2.getAddresses(), arrayList2, config2.getCountry(), config2.getCountries(), config2.isAddressMicroServiceEnabled(), config2.getMetersOfLocationAwareness()));
        } else {
            GlobalDataModel.areas = appInitRM.result.areas;
        }
        GlobalDataModel.CHECKOUTDOTCOM.publicKey = appInitRM.result.publicKey;
        int countryId = this.locationConfigRepository.config().getCountry().getCountryId();
        if (Customer.getInstance().isLoggedIn() && countryId > 0) {
            List<Address> addresses = this.locationConfigRepository.addresses();
            Customer instance = Customer.getInstance();
            if (addresses.size() > 0 && z11) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.locationConfigRepository.addresses());
                instance.setCustomerAddress(this.context, arrayList3);
            }
            instance.setSavedCreditCards(obtainTokenizedBandCards(appInitRM));
        }
        this.deeplinkRequestListener.onCountryReceived();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$zipAppInfoAndAddressesForCountrySpecificData$5(Throwable th2) throws Exception {
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            onRequestError().onErrorResponse((VolleyError) th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$zipAppInfoAndAddressesForRequiredData$1(Throwable th2) throws Exception {
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            onRequestError().onErrorResponse((VolleyError) th2);
        }
    }

    private TokenisationCreditCard[] obtainTokenizedBandCards(AppInitRM appInitRM) {
        if (!this.talabatFeatureFlag.getFeatureFlag(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAYMENT_REPO_REAL_CARD_TOKENS, false)) {
            return appInitRM.result.tokens;
        }
        TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper = new TokenizedBankCardToOldTokenizedBankCardMapper();
        List<TokenizedBankCard> tokenizedBankCards = this.paymentConfigurationRepository.walletConfig().getTokenizedBankCards();
        TokenisationCreditCard[] tokenisationCreditCardArr = new TokenisationCreditCard[tokenizedBankCards.size()];
        for (int i11 = 0; i11 < tokenizedBankCards.size(); i11++) {
            tokenisationCreditCardArr[i11] = tokenizedBankCardToOldTokenizedBankCardMapper.apply(tokenizedBankCards.get(i11));
        }
        return tokenisationCreditCardArr;
    }

    private Response.Listener<AppInitRM> onAppinitCountrySpecifiedDataReceived(boolean z11) {
        return new g(this, z11);
    }

    private Response.Listener<CuisinesResult> onCuisinesLoaded() {
        return new Response.Listener<CuisinesResult>() {
            public void onResponse(CuisinesResult cuisinesResult) {
                GlobalDataModel.cuisines = cuisinesResult.result;
                DeepLinkInteractor.this.deeplinkRequestListener.onCuisinesRecieved();
            }
        };
    }

    private Response.Listener<MenuItemResponse> onInfoRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                MenuItemsResponseModel menuItemsResponseModel;
                Restaurant restaurant;
                if (menuItemResponse != null && (menuItemsResponseModel = menuItemResponse.result) != null && (restaurant = menuItemsResponseModel.restaurant) != null) {
                    GlobalDataModel.JSON.menuItemsResponseModel.restaurant = restaurant;
                    int i11 = restaurant.shopType;
                    if (i11 == 1) {
                        GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
                        DeepLinkInteractor deepLinkInteractor = DeepLinkInteractor.this;
                        deepLinkInteractor.getGroceryMenuRetrofit(deepLinkInteractor.f63517a);
                    } else if (i11 == 0) {
                        DeepLinkInteractor deepLinkInteractor2 = DeepLinkInteractor.this;
                        deepLinkInteractor2.getRestaurantMenuOnly(deepLinkInteractor2.f63517a);
                    }
                    Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                    if (restaurant2 != null) {
                        int i12 = restaurant2.f13872id;
                        Restaurant restaurant3 = menuItemResponse.result.restaurant;
                        if (i12 == restaurant3.f13872id) {
                            restaurant3.setRecommendation(restaurant2.isRecommendation());
                            Restaurant restaurant4 = menuItemResponse.result.restaurant;
                            Restaurant restaurant5 = GlobalDataModel.SELECTED.restaurant;
                            restaurant4.itemPosition = restaurant5.itemPosition;
                            restaurant4.swimlanePosition = restaurant5.swimlanePosition;
                        }
                    }
                    GlobalDataModel.SELECTED.updateRestaurant(restaurant);
                    MenuItemsResponseModel menuItemsResponseModel2 = GlobalDataModel.JSON.menuItemsResponseModel;
                    MenuItemsResponseModel menuItemsResponseModel3 = menuItemResponse.result;
                    menuItemsResponseModel2.warnings = menuItemsResponseModel3.warnings;
                    menuItemsResponseModel2.deliveryAreas = menuItemsResponseModel3.deliveryAreas;
                    menuItemsResponseModel2.promotions = menuItemsResponseModel3.promotions;
                    menuItemsResponseModel2.upsellingItems = menuItemsResponseModel3.upsellingItems;
                    menuItemsResponseModel2.heroImage = menuItemsResponseModel3.heroImage;
                    GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel3.tgoFreeDeliveryResponse;
                    MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                    menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemsResponseModel3);
                    menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                } else if (DeepLinkInteractor.this.deeplinkRequestListener != null) {
                    DeepLinkInteractor.this.deeplinkRequestListener.redirectToHome();
                }
            }
        };
    }

    private void onMenuOrInfoLoaded() {
        if (this.deeplinkRequestListener != null) {
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            this.deeplinkRequestListener.onRestaurantMenuLoaded();
        }
    }

    private Response.Listener<SplitMenuRM> onMenuReceived() {
        return new i(this);
    }

    private Response.Listener<OrderDetailsRM> onOrderDetailsResultRecieved() {
        return new Response.Listener<OrderDetailsRM>() {
            public void onResponse(OrderDetailsRM orderDetailsRM) {
                if (orderDetailsRM.result != null) {
                    DeepLinkInteractor.this.deeplinkRequestListener.onOrderDetailsRecieved(orderDetailsRM.result);
                } else {
                    DeepLinkInteractor.this.onRequestError();
                }
            }
        };
    }

    private Response.Listener<AreaPreoloadResponse> onPreloadAreaRecieved() {
        return new Response.Listener<AreaPreoloadResponse>() {
            public void onResponse(AreaPreoloadResponse areaPreoloadResponse) {
                if (DeepLinkInteractor.this.talabatFeatureFlag.getFeatureFlag(LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false)) {
                    LocationConfig config = DeepLinkInteractor.this.locationConfigRepository.config();
                    OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
                    ArrayList arrayList = new ArrayList();
                    for (Area apply : areaPreoloadResponse.result) {
                        arrayList.add(oldAreaToAreaMapper.apply(apply));
                    }
                    DeepLinkInteractor.this.locationConfigRepository.setConfig(config.copy(config.getAddresses(), arrayList, config.getCountry(), config.getCountries(), config.isAddressMicroServiceEnabled(), config.getMetersOfLocationAwareness()));
                } else {
                    GlobalDataModel.areas = areaPreoloadResponse.result;
                }
                DeepLinkInteractor.this.deeplinkRequestListener.onAreasRecieved();
            }
        };
    }

    private Response.Listener<RateOrderResponse> onRateOrderRecieved() {
        return new Response.Listener<RateOrderResponse>() {
            public void onResponse(RateOrderResponse rateOrderResponse) {
                DeepLinkInteractor.this.deeplinkRequestListener.onRateOrderDataRecieved(rateOrderResponse.result);
            }
        };
    }

    private Response.Listener<AppInitRM> onRequiredDataReceived(boolean z11) {
        return new f(this, z11);
    }

    private Response.Listener<RestaurantSlugRM> onRestaurantIdReceived() {
        return new Response.Listener<RestaurantSlugRM>() {
            public void onResponse(RestaurantSlugRM restaurantSlugRM) {
                DeepLinkInteractor.this.deeplinkRequestListener.onRestaurantSlugDetailsLoaded(restaurantSlugRM);
            }
        };
    }

    private Response.Listener<RestaurantDetailsWithDelAreasRM> onRestaurantInfoRecieved() {
        return new Response.Listener<RestaurantDetailsWithDelAreasRM>() {
            public void onResponse(RestaurantDetailsWithDelAreasRM restaurantDetailsWithDelAreasRM) {
                DeeplinkRequestListener k11 = DeepLinkInteractor.this.deeplinkRequestListener;
                RestaurantDetailsWithDelAreasResponseModel restaurantDetailsWithDelAreasResponseModel = restaurantDetailsWithDelAreasRM.result;
                k11.onRestaurantDetailsLoaded(restaurantDetailsWithDelAreasResponseModel.restaurant, restaurantDetailsWithDelAreasResponseModel.areas, restaurantDetailsWithDelAreasResponseModel.cities);
            }
        };
    }

    /* access modifiers changed from: private */
    public void onRestaurantsRecieved(RestuarntListResponse restuarntListResponse) {
        GemTier gemTier;
        GlobalDataModel.updateRestaurantsData(restuarntListResponse.result);
        GlobalDataModel.cuisines = restuarntListResponse.result.cuisines;
        ArrayList<Filter> arrayList = new ArrayList<>();
        RestaurantListJM restaurantListJM = restuarntListResponse.result;
        ArrayList<Filter> arrayList2 = restaurantListJM.filters;
        if (!(arrayList2 == null || restaurantListJM.restaurants == null)) {
            Iterator<Filter> it = arrayList2.iterator();
            while (it.hasNext()) {
                Filter next = it.next();
                Restaurant[] restaurantArr = restuarntListResponse.result.restaurants;
                int length = restaurantArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (restaurantArr[i11].getFiltersId().contains(Integer.valueOf(next.getId()))) {
                        arrayList.add(next);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        ArrayList<QuickFilter> arrayList3 = new ArrayList<>();
        RestaurantListJM restaurantListJM2 = restuarntListResponse.result;
        ArrayList<QuickFilter> arrayList4 = restaurantListJM2.collections;
        if (!(arrayList4 == null || restaurantListJM2.restaurants == null)) {
            Iterator<QuickFilter> it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                QuickFilter next2 = it2.next();
                Restaurant[] restaurantArr2 = restuarntListResponse.result.restaurants;
                int length2 = restaurantArr2.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        break;
                    } else if (restaurantArr2[i12].getFiltersId().contains(next2.getId())) {
                        arrayList3.add(next2);
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        GlobalDataModel.filters = arrayList;
        GlobalDataModel.collections = arrayList3;
        GemTier[] gemTierArr = restuarntListResponse.result.gemTiers;
        if (!(gemTierArr == null || gemTierArr.length <= 0 || (gemTier = gemTierArr[0]) == null)) {
            GlobalDataModel.GEMCONSTANTS.GemTiers = gemTier;
        }
        this.deeplinkRequestListener.onRestaurantListLoaded();
    }

    private Response.Listener<QuickFindRestaurantsResponse> onResultRecieved() {
        return new Response.Listener<QuickFindRestaurantsResponse>() {
            public void onResponse(QuickFindRestaurantsResponse quickFindRestaurantsResponse) {
                DeepLinkInteractor.this.deeplinkRequestListener.onRestaurantListLoaded(quickFindRestaurantsResponse.result);
            }
        };
    }

    private Response.Listener<UserInfoResult> onUserInfoRecived() {
        return new Response.Listener<UserInfoResult>() {
            public void onResponse(UserInfoResult userInfoResult) {
                GlobalDataModel.JSON.sideMenuSectionLinks = userInfoResult.result.linkmenusection;
                DeepLinkInteractor.this.deeplinkRequestListener.onUserInfoRecieved();
            }
        };
    }

    private void requestCompleted() {
        this.deeplinkRequestListener.onCountryRedirectionCompleted();
    }

    /* access modifiers changed from: private */
    public void trackVendorListTalabatBranchCodeAPIFailed(Throwable th2) {
        int i11;
        if (th2 instanceof HttpException) {
            i11 = ((HttpException) th2).code();
        } else {
            i11 = 0;
        }
        this.vendorInfoAPIObservability.onVendorListTalabatBranchCodeAPIFailed(true, Integer.valueOf(i11), th2.getMessage(), Integer.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId()));
    }

    private void zipAppInfoAndAddressesForCountrySpecificData() {
        this.loadAppInfoWithAddressesForCountrySpecificDisposable = Single.zip(getAppInfoSingle(), getCustomerAddressesFromMicroservice(), new c()).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new k(this), new b(this));
    }

    private void zipAppInfoAndAddressesForRequiredData() {
        this.loadAppInfoWithAddressesForRequiredDataDisposable = Single.zip(getAppInfoSingle(), getCustomerAddressesFromMicroservice(), new c()).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new d(this), new g40.e(this));
    }

    public ArrayList<Restaurant> getAllRestaurantsForCountry(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.QUICKFINDRESTAURANTS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(QuickFindRestaurantsResponse.class).setListener(onResultRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        return null;
    }

    public void getAreas() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETCOUNTRYAREAS + GlobalDataModel.SelectedCountryId).setClazz(AreaPreoloadResponse.class).setListener(onPreloadAreaRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getDarkstoresAvailability() {
        final DarkstoresTrackingData darkstoresTrackingData = new DarkstoresTrackingData(System.currentTimeMillis());
        int i11 = GlobalDataModel.SelectedAreaId;
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
        ApiHandler.Services services = ApiHandler.getInstance().getServices();
        String str = AppUrls.DARKSTORES_URL;
        services.getDarkStoresInfo(CreateApiUrl.createWithParameters(str, new String[]{"{areaId}", "" + i11, "{latitude}", "" + latitude, "{longitude}", "" + longitude})).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<DarkStoresEntryPointResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                DeepLinkInteractor.this.trackVendorListTalabatBranchCodeAPIFailed(th2);
                DeepLinkInteractor.this.deeplinkRequestListener.redirectToHome();
            }

            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(DarkStoresEntryPointResponse darkStoresEntryPointResponse) {
                DeepLinkInteractor.this.q(darkStoresEntryPointResponse, darkstoresTrackingData);
            }
        });
    }

    public void getGroceryMenuRetrofit(String str) {
        ApiHandler.callApi().getGroceryMenu(CreateApiUrl.createWithParameters(AppUrls.SPLIT_GROCERY_MENU, new String[]{"{branchId}", str})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<SplitMenuRM>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                DeepLinkInteractor.this.deeplinkRequestListener.redirectToHome();
            }

            public void onNext(SplitMenuRM splitMenuRM) {
                GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.TRUE);
                MenuItemRM menuItemRM = splitMenuRM.result.menu;
                if (menuItemRM.menuSection.length > 0) {
                    GlobalDataModel.JSON.menuItemsResponseModel.menu = menuItemRM;
                    if (DeepLinkInteractor.this.deeplinkRequestListener != null) {
                        ChoiceLoader.startChoiceLoader(DeepLinkInteractor.this.appVersionProvider);
                        DeepLinkInteractor.this.deeplinkRequestListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                        return;
                    }
                    return;
                }
                DeepLinkInteractor.this.deeplinkRequestListener.redirectToHome();
            }
        });
    }

    public void getMigratedVendorInfo(int i11) {
        final DarkstoresTrackingData darkstoresTrackingData = new DarkstoresTrackingData(System.currentTimeMillis());
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, latitude + "", GlobalDataModel.LATLONGFORAPI.getLongitude() + "", GlobalDataModel.SelectedCountryId + "");
        ApiHandler.callApi().getRestaurantInfoWithLocation(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION.replace("{branchId}", i11 + ""), restaurantInfoRequestModel).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<MenuItemResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                DeepLinkInteractor.this.deeplinkRequestListener.redirectToHome();
            }

            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(MenuItemResponse menuItemResponse) {
                if (menuItemResponse != null) {
                    DeepLinkInteractor.this.r(menuItemResponse, darkstoresTrackingData);
                }
            }
        });
    }

    public void getOrderDetails(String str) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.ORDERDETAILSTALABAT, new String[]{"{transactionId}", str})).setClazz(OrderDetailsRM.class).setListener(onOrderDetailsResultRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRequiredData(Context context2) {
        this.context = context2;
        if (canInvokeAddressMicroService().booleanValue()) {
            zipAppInfoAndAddressesForRequiredData();
            return;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETAPPINFOV2 + GlobalDataModel.SelectedCountryId).setClazz(AppInitRM.class).setListener(onRequiredDataReceived(true)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantDetails(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.RESTAURANT_DETAILS_WITH_DELAREAS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restaurantid}", "" + i11})).setClazz(RestaurantDetailsWithDelAreasRM.class).setListener(onRestaurantInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantIdFromSlug(String str, String str2) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.RESTAURANTSLUGURL, new String[]{"{countrySlug}", str, "{restaurantSlug}", str2})).setClazz(RestaurantSlugRM.class).setListener(onRestaurantIdReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantInfoOnly(String str) {
        String str2;
        JSONObject jSONObject;
        this.f63517a = str;
        Gson gson = UniversalGson.INSTANCE.gson;
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        if (!(gson instanceof Gson)) {
            str2 = gson.toJson((Object) restaurantInfoRequestModel);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) restaurantInfoRequestModel);
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", str})).setClazz(MenuItemResponse.class).setRequestBody(jSONObject).setListener(onInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantMenuOnly(String str) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_MENU, new String[]{"{branchId}", str})).setClazz(SplitMenuRM.class).setListener(onMenuReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurants(int i11, int i12, int i13) {
        getRestaurantWithNewApi(i11, i12);
    }

    public void getUserInfo() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETAPPINFO + GlobalDataModel.SelectedCountryId).setClazz(UserInfoResult.class).setListener(onUserInfoRecived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadAppinitCountrySpecficData(int i11) {
        if (canInvokeAddressMicroService().booleanValue()) {
            zipAppInfoAndAddressesForCountrySpecificData();
            return;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETAPPINFOV2 + i11).setClazz(AppInitRM.class).setListener(onAppinitCountrySpecifiedDataReceived(true)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadCuisines() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(AppUrls.GETCUISINES + GlobalDataModel.SelectedCountryId).setClazz(CuisinesResult.class).setListener(onCuisinesLoaded()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                DeepLinkInteractor.this.deeplinkRequestListener.redirectToHome();
            }
        };
    }

    public boolean p(MenuItemResponse menuItemResponse) {
        MenuItemsResponseModel menuItemsResponseModel = menuItemResponse.result;
        return (menuItemsResponseModel == null || menuItemsResponseModel.restaurant == null) ? false : true;
    }

    public void q(DarkStoresEntryPointResponse darkStoresEntryPointResponse, DarkstoresTrackingData darkstoresTrackingData) {
        if (darkStoresEntryPointResponse == null || darkStoresEntryPointResponse.getResult() == null) {
            trackVendorListTalabatBranchCodeAPIFailed(new Throwable(ObservableErrorMessages.EMPTY_API_RESPONSE));
            this.deeplinkRequestListener.showDarkstoresErrorMessage();
            this.deeplinkRequestListener.redirectToHome();
            return;
        }
        this.deeplinkRequestListener.onDarkStoresEntrySuccess(darkStoresEntryPointResponse.getResult(), darkstoresTrackingData);
    }

    public void r(MenuItemResponse menuItemResponse, DarkstoresTrackingData darkstoresTrackingData) {
        if (p(menuItemResponse)) {
            this.deeplinkRequestListener.onMigratedInfoSuccess(menuItemResponse.result.restaurant, darkstoresTrackingData);
        } else {
            this.deeplinkRequestListener.redirectToHome();
        }
    }

    public void rateOrder(String str) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.RATEORDER, new String[]{"{encryptedOrderId}", str})).setClazz(RateOrderResponse.class).setListener(onRateOrderRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }
}
