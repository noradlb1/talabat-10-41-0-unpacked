package library.talabat.mvp.cart;

import JsonModels.CampaignVoucherRM;
import JsonModels.CouponsAndPromotionsResponse;
import JsonModels.GeoAddressRequest;
import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.McdBlockMapGrlUpdateRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.ParallelBin.ParallelBinRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.BIN.BinTokenResponse;
import JsonModels.Response.BinTokenRM;
import JsonModels.Response.CouponsAndPromotionsRM;
import JsonModels.Response.CustomerAddressInfoJsonResult;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.McdBlockAddressGrlUpdateRM;
import JsonModels.Response.McdStoresRM;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.ParallelBin.ParallelBinRM;
import JsonModels.Response.ParallelBin.ParallelBinResponse;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.Response.UpsellingResponse;
import JsonModels.Response.WalletCreditCardABTestResponse;
import JsonModels.RestaurantReviewResponse;
import JsonModels.parser.UniversalGson;
import a10.a;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import bt.o;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.domain.address.Address;
import com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCase;
import com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCaseKt;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.BackgroundAction;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.repository.CustomerAddressesRepositoryKt;
import datamodels.Coupon;
import datamodels.GroceryInfoAndMenuResponseZipped;
import datamodels.Promotion;
import datamodels.Restaurant;
import datamodels.mappers.AutoApplyDiscountCoupon;
import datamodels.mappers.AutoApplyDiscountMapper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;
import rj.d;
import rj.e;
import service.ApiHandler;

@Instrumented
class CartInteractor implements ICartInteractor {
    /* access modifiers changed from: private */
    public final AppVersionProvider appVersionProvider;
    private AutoApplyDiscountMapper autoApplyDiscountMapper;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26575b;

    /* renamed from: c  reason: collision with root package name */
    public GetAutoApplyDiscountsUseCase f26576c;
    /* access modifiers changed from: private */
    public CartListener cartListener;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CustomerRepository customerRepository;
    private CompositeDisposable disposables = new CompositeDisposable();
    private GetActiveSubscriptionsRxWrapper getActiveSubscriptions;
    private final Scheduler ioScheduler;
    /* access modifiers changed from: private */
    public boolean isGrlNewAddressEnabled;
    private final LocationConfigurationRepository locationConfigRepository;
    private final Scheduler mainScheduler;
    /* access modifiers changed from: private */
    public boolean onlyInfoLoaded;
    /* access modifiers changed from: private */
    public boolean onlyMenuLoaded;
    private final ITalabatFeatureFlag talabatFeatureFlag;
    /* access modifiers changed from: private */
    public ArrayList<TokenisationCreditCard> tokenisationCreditCards;
    private final UpdateAreaOfSelectedAddressIfChangedUseCase updateAreaOfSelectedAddressIfChangedUseCase;
    /* access modifiers changed from: private */
    public Address userSelectedaddress;

    public CartInteractor(CartListener cartListener2, CustomerAddressesRepository customerAddressesRepository2, CustomerRepository customerRepository2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository, UpdateAreaOfSelectedAddressIfChangedUseCase updateAreaOfSelectedAddressIfChangedUseCase2, ITalabatFeatureFlag iTalabatFeatureFlag, Scheduler scheduler, Scheduler scheduler2, GetAutoApplyDiscountsUseCase getAutoApplyDiscountsUseCase, AutoApplyDiscountMapper autoApplyDiscountMapper2, GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper, AppVersionProvider appVersionProvider2) {
        this.cartListener = cartListener2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.updateAreaOfSelectedAddressIfChangedUseCase = updateAreaOfSelectedAddressIfChangedUseCase2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.f26576c = getAutoApplyDiscountsUseCase;
        this.autoApplyDiscountMapper = autoApplyDiscountMapper2;
        this.getActiveSubscriptions = getActiveSubscriptionsRxWrapper;
        this.appVersionProvider = appVersionProvider2;
    }

    private Single<List<Address>> getCustomerAddressesFromMicroservice() {
        return CustomerAddressesRepositoryKt.getCustomerAddressesSingle(this.customerAddressesRepository, GlobalDataModel.SelectedCountryId).onErrorReturn(new e());
    }

    private void getGetActiveSubscriptions(CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        this.disposables.add(this.getActiveSubscriptions.single(new GetActiveSubscriptionsUseCase.Params(this.configurationLocalRepository.selectedCountry())).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new a(this, customerAddressInfoJsonResult), new i(this, customerAddressInfoJsonResult)));
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(Restaurant restaurant) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private Single<CustomerAddressInfoJsonResult> getLoadCustomerDetailsSingle() {
        return Single.create(new n(this));
    }

    /* access modifiers changed from: private */
    public void handleMergedResultForBackgroundUpdate(Pair<CustomerAddressInfoJsonResult, List<Address>> pair) {
        if (!Cart.getInstance().getRestaurant().isGlrEnabled) {
            this.customerRepository.setCustomerAddresses(pair.getSecond());
        }
        onBackGroundAddressReceived(false).onResponse(pair.getFirst());
    }

    /* access modifiers changed from: private */
    public void handleMergedResultForLoadCustomer(Pair<CustomerAddressInfoJsonResult, List<Address>> pair) {
        this.customerRepository.setCustomerAddresses(pair.getSecond());
        onAddressReceived(false).onResponse(pair.getFirst());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkForSelectedAddressAreaUpdate$10(Function0 function0, Throwable th2) throws Exception {
        LogManager.logException(th2);
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$getCustomerAddressesFromMicroservice$5(Throwable th2) throws Exception {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getGetActiveSubscriptions$13(CustomerAddressInfoJsonResult customerAddressInfoJsonResult, Subscription subscription) throws Exception {
        this.cartListener.onCustomerinfoLoadedBackGround(customerAddressInfoJsonResult, subscription);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getGetActiveSubscriptions$14(CustomerAddressInfoJsonResult customerAddressInfoJsonResult, Throwable th2) throws Exception {
        this.cartListener.onCustomerinfoLoadedBackGround(customerAddressInfoJsonResult, (Subscription) null);
        LogManager.logException(th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getLoadCustomerDetailsSingle$7(SingleEmitter singleEmitter) throws Exception {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        GsonRequest.Builder<CustomerAddressInfoJsonResult> clazz = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class);
        Objects.requireNonNull(singleEmitter);
        TalabatVolley.addToRequestQueue(clazz.setListener(new d(singleEmitter)).setErrorListener(new e(singleEmitter)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCouponsAndPromotions$1(int i11, float f11, Throwable th2) throws Exception {
        observeAPIError("Auto-Applied Discounts Api error in CartInteractor", th2);
        onAADFailed(i11, f11, th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCustomerDetailsFromMicroservice$4(Throwable th2) throws Exception {
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            onRequestError().onErrorResponse((VolleyError) th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUserInfoBackgroundFromMicroservice$6(Throwable th2) throws Exception {
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            onRequestError().onErrorResponse((VolleyError) th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddressReceived$11(boolean z11, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        if (this.cartListener != null) {
            Customer instance = Customer.getInstance();
            if (z11) {
                instance.setCustomerAddress(customerAddressInfoJsonResult.result.addresses);
            }
            this.cartListener.onCustomerinfoLoaded(customerAddressInfoJsonResult);
            instance.setSavedCreditCards(customerAddressInfoJsonResult.result.tokens);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAllBinResponse$8(ParallelBinRM parallelBinRM) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (this.cartListener == null) {
            return;
        }
        if (!TalabatUtils.isNullOrEmpty(parallelBinRM.result.msg)) {
            GlobalDataModel.PARALLELBIN.notAvailable = false;
            ParallelBinResponse parallelBinResponse = parallelBinRM.result;
            String str2 = parallelBinResponse.msg;
            if (!TalabatUtils.isNullOrEmpty(parallelBinResponse.iconUrl)) {
                str = parallelBinRM.result.iconUrl;
            } else {
                str = "";
            }
            if (parallelBinRM.result.areMoreBinModelsAvailable()) {
                arrayList.addAll(Arrays.asList(parallelBinRM.result.moreBinModels));
            }
            new GlobalDataModel.PARALLELBIN(str2, str, arrayList);
            this.cartListener.onParallelBinAvailable();
            return;
        }
        GlobalDataModel.PARALLELBIN.notAvailable = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackGroundAddressReceived$12(boolean z11, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        if (this.cartListener != null) {
            Customer instance = Customer.getInstance();
            if (z11 && !Cart.getInstance().getRestaurant().isGlrEnabled) {
                instance.setCustomerAddress(customerAddressInfoJsonResult.result.addresses);
            }
            getGetActiveSubscriptions(customerAddressInfoJsonResult);
            instance.setSavedCreditCards(customerAddressInfoJsonResult.result.tokens);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCouponsAndPromotionsError$2(AutoApplyDiscount[] autoApplyDiscountArr, float f11, VolleyError volleyError) {
        observeAPIError("Legacy coupons API failure", volleyError);
        if (autoApplyDiscountArr == null || autoApplyDiscountArr.length == 0) {
            onRequestError().onErrorResponse(volleyError);
        } else {
            updatedCouponsAndPromotionsSelectionLogic((Promotion[]) null, (Coupon[]) null, autoApplyDiscountArr, f11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCouponsAndPromotionsReceived$3(AutoApplyDiscount[] autoApplyDiscountArr, float f11, CouponsAndPromotionsRM couponsAndPromotionsRM) {
        CouponsAndPromotionsResponse couponsAndPromotionsResponse = couponsAndPromotionsRM.result;
        updatedCouponsAndPromotionsSelectionLogic(couponsAndPromotionsResponse.promotions, couponsAndPromotionsResponse.coupons, autoApplyDiscountArr, f11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$9(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            CartListener cartListener2 = this.cartListener;
            if (cartListener2 != null) {
                cartListener2.onRequestError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            CartListener cartListener3 = this.cartListener;
            if (cartListener3 != null) {
                cartListener3.onEmptyMenuReceived(str);
            }
        } else if (GlobalDataModel.SELECTED.restaurant != null) {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = splitMenuRM.result.menu;
            menuItemsResponseModel.menu = menuItemRM;
            MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
            this.onlyMenuLoaded = true;
            onMenuOrInfoLoaded();
        }
    }

    private void loadCustomerDetailsFromMicroservice() {
        Single<List<Address>> customerAddressesFromMicroservice = getCustomerAddressesFromMicroservice();
        this.disposables.add(Single.zip(getLoadCustomerDetailsSingle(), customerAddressesFromMicroservice, new o()).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new l(this), new m(this)));
    }

    private void loadLegacyCoupons(int i11, float f11, @Nullable AutoApplyDiscount[] autoApplyDiscountArr) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETQUALIFIEDCOUPONS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + i11, "{areaId}", "" + GlobalDataModel.SelectedAreaId, "{total}", "" + f11})).setClazz(CouponsAndPromotionsRM.class).setListener(onCouponsAndPromotionsReceived(autoApplyDiscountArr, f11)).setErrorListener(onCouponsAndPromotionsError(autoApplyDiscountArr, f11)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    private void onAADFailed(int i11, float f11, Throwable th2) {
        LogManager.debug("AAD onFailed() called with: throwable = [" + th2 + "]");
        loadLegacyCoupons(i11, f11, (AutoApplyDiscount[]) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAADSuccessResult */
    public void lambda$loadCouponsAndPromotions$0(int i11, float f11, AutoApplyDiscount[] autoApplyDiscountArr) {
        LogManager.debug("AAD onSuccessResult() called with: autoApplyDiscounts = [" + autoApplyDiscountArr + "]");
        loadLegacyCoupons(i11, f11, autoApplyDiscountArr);
    }

    private Response.Listener<CustomerAddressInfoJsonResult> onAddressReceived(boolean z11) {
        return new j(this, z11);
    }

    private Response.ErrorListener onAllBinRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                GlobalDataModel.PARALLELBIN.notAvailable = true;
            }
        };
    }

    private Response.Listener<ParallelBinRM> onAllBinResponse() {
        return new g(this);
    }

    private Response.Listener<CustomerAddressInfoJsonResult> onBackGroundAddressReceived(boolean z11) {
        return new d(this, z11);
    }

    private Response.Listener<BinTokenRM> onBinTokenResponseReceived() {
        return new Response.Listener<BinTokenRM>() {
            public void onResponse(BinTokenRM binTokenRM) {
                if (binTokenRM != null) {
                    GlobalDataModel.BIN.handled = true;
                    BinTokenResponse[] binTokenResponseArr = binTokenRM.result;
                    if (binTokenResponseArr != null && binTokenResponseArr.length > 0) {
                        CartInteractor.this.tokenisationCreditCards = Customer.getInstance().getSavedCards();
                        if (CartInteractor.this.tokenisationCreditCards != null && CartInteractor.this.tokenisationCreditCards.size() > 0) {
                            boolean z11 = false;
                            for (BinTokenResponse binTokenResponse : binTokenRM.result) {
                                Iterator it = CartInteractor.this.tokenisationCreditCards.iterator();
                                while (it.hasNext()) {
                                    TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) it.next();
                                    if (tokenisationCreditCard.token.equals(binTokenResponse.token)) {
                                        boolean z12 = binTokenResponse.isBinDiscountValid;
                                        tokenisationCreditCard.isBinDiscountValid = z12;
                                        tokenisationCreditCard.binNumber = binTokenResponse.binNumber;
                                        tokenisationCreditCard.message = binTokenResponse.chkOutMesg;
                                        if (!z11 && z12 && !TalabatUtils.isNullOrEmpty(binTokenResponse.menuMesg)) {
                                            z11 = true;
                                        }
                                    }
                                }
                            }
                        }
                        if (CartInteractor.this.tokenisationCreditCards == null) {
                            CartInteractor.this.tokenisationCreditCards = new ArrayList();
                        }
                        GlobalDataModel.BIN.tokensModified = true;
                        Customer.getInstance().setSavedCreditCards((TokenisationCreditCard[]) CartInteractor.this.tokenisationCreditCards.toArray(new TokenisationCreditCard[CartInteractor.this.tokenisationCreditCards.size()]));
                        ArrayList<TokenisationCreditCard> arrayList = GlobalDataModel.BIN.savedTokens;
                        if (arrayList != null && arrayList.size() > 0) {
                            GlobalDataModel.BIN.savedTokens.clear();
                        }
                        GlobalDataModel.BIN.savedTokens = Customer.getInstance().getSavedCards();
                    }
                }
            }
        };
    }

    private Response.Listener<CampaignVoucherRM> onCampaignDetailsRecieved() {
        return new Response.Listener<CampaignVoucherRM>() {
            public void onResponse(CampaignVoucherRM campaignVoucherRM) {
                if (CartInteractor.this.cartListener != null) {
                    CartInteractor.this.cartListener.onCustomVoucherRecived(campaignVoucherRM.result);
                }
            }
        };
    }

    private Response.ErrorListener onCouponsAndPromotionsError(@Nullable AutoApplyDiscount[] autoApplyDiscountArr, float f11) {
        return new o(this, autoApplyDiscountArr, f11);
    }

    private Response.Listener<CouponsAndPromotionsRM> onCouponsAndPromotionsReceived(AutoApplyDiscount[] autoApplyDiscountArr, float f11) {
        return new k(this, autoApplyDiscountArr, f11);
    }

    private Response.Listener<GeoAddressRequest> onGeoAddressRecieved() {
        return new Response.Listener<GeoAddressRequest>() {
            public void onResponse(GeoAddressRequest geoAddressRequest) {
                if (CartInteractor.this.cartListener == null) {
                    return;
                }
                if (geoAddressRequest == null) {
                    CartInteractor.this.cartListener.geoAddressNotReceived();
                } else if (geoAddressRequest.result != null) {
                    CartInteractor.this.cartListener.onGeoAddressRecieved(geoAddressRequest.result, CartInteractor.this.userSelectedaddress);
                }
            }
        };
    }

    private Response.Listener<McdBlockAddressGrlUpdateRM> onGrlUpdatedinAddress() {
        return new Response.Listener<McdBlockAddressGrlUpdateRM>() {
            public void onResponse(McdBlockAddressGrlUpdateRM mcdBlockAddressGrlUpdateRM) {
            }
        };
    }

    private Response.Listener<MenuItemResponse> onInfoRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                MenuItemsResponseModel menuItemsResponseModel;
                Restaurant restaurant;
                if (menuItemResponse == null || (menuItemsResponseModel = menuItemResponse.result) == null || (restaurant = menuItemsResponseModel.restaurant) == null) {
                    if (menuItemResponse == null) {
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in CartInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in CartInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in CartInteractor", new HashMap());
                        }
                    }
                    if (CartInteractor.this.cartListener != null) {
                        CartInteractor.this.cartListener.onRequestError();
                        return;
                    }
                    return;
                }
                GlobalDataModel.SELECTED.updateRestaurant(restaurant);
                MenuItemsResponseModel menuItemsResponseModel3 = GlobalDataModel.JSON.menuItemsResponseModel;
                MenuItemsResponseModel menuItemsResponseModel4 = menuItemResponse.result;
                menuItemsResponseModel3.warnings = menuItemsResponseModel4.warnings;
                menuItemsResponseModel3.deliveryAreas = menuItemsResponseModel4.deliveryAreas;
                menuItemsResponseModel3.promotions = menuItemsResponseModel4.promotions;
                menuItemsResponseModel3.restaurant = menuItemsResponseModel4.restaurant;
                menuItemsResponseModel3.heroImage = menuItemsResponseModel4.heroImage;
                GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel4.tgoFreeDeliveryResponse;
                MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemsResponseModel4);
                menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                CartInteractor.this.onlyInfoLoaded = true;
                CartInteractor.this.onMenuOrInfoLoaded();
            }
        };
    }

    private Response.Listener<LoyaltyVoucherRM> onLoyaltyVoucherInfoReceived() {
        return new Response.Listener<LoyaltyVoucherRM>() {
            public void onResponse(LoyaltyVoucherRM loyaltyVoucherRM) {
                if (CartInteractor.this.cartListener == null) {
                    return;
                }
                if (loyaltyVoucherRM == null) {
                    CartInteractor.this.cartListener.onLoyaltyVoucherError();
                } else if (loyaltyVoucherRM.result != null) {
                    CartInteractor.this.cartListener.onLoyaltyVoucherInfoReceived(loyaltyVoucherRM);
                } else {
                    CartInteractor.this.cartListener.onLoyaltyVoucherError();
                }
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdStoresReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (CartInteractor.this.cartListener == null) {
                    return;
                }
                if (mcdStoresRM == null) {
                    CartInteractor.this.cartListener.mcdBranchFailed();
                } else if (mcdStoresRM.result != null) {
                    CartInteractor.this.cartListener.mcdBranchReceived(mcdStoresRM.result, CartInteractor.this.isGrlNewAddressEnabled);
                } else {
                    CartInteractor.this.cartListener.mcdBranchFailed();
                }
            }
        };
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(String str) {
        return new h(this, str);
    }

    private Response.Listener<RestaurantReviewResponse> onReviewReceived() {
        return new Response.Listener<RestaurantReviewResponse>() {
            public void onResponse(RestaurantReviewResponse restaurantReviewResponse) {
                if (CartInteractor.this.cartListener == null) {
                    return;
                }
                if (restaurantReviewResponse != null) {
                    CartInteractor.this.cartListener.onReviewLoadingCompleted(restaurantReviewResponse);
                } else {
                    CartInteractor.this.onRequestError();
                }
            }
        };
    }

    private Response.Listener<UpsellingResponse> onUpsellingItemsReceived() {
        return new Response.Listener<UpsellingResponse>() {
            public void onResponse(UpsellingResponse upsellingResponse) {
                if (CartInteractor.this.cartListener != null) {
                    if (upsellingResponse != null) {
                        Cart.getInstance().setUpsellingItem(upsellingResponse.result.upsellingItems);
                    }
                    CartInteractor.this.cartListener.onUpsellingItemsReceived(upsellingResponse);
                }
            }
        };
    }

    public void checkForSelectedAddressAreaUpdate(Function0<Unit> function0) {
        CompositeDisposable compositeDisposable = this.disposables;
        Completable observeOn = UpdateAreaOfSelectedAddressIfChangedUseCaseKt.updateAreaOfSelectedAddressIfChangedCompletable(this.updateAreaOfSelectedAddressIfChangedUseCase).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler);
        Objects.requireNonNull(function0);
        compositeDisposable.add(observeOn.subscribe(new a(function0), new f(function0)));
    }

    public void fetchPaymentOptionABTestUserStatus() {
        ApiHandler.callApi().getWalletABTestResponse(AppUrls.WALLET_CREDIT_CARD_AB_TEST_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<WalletCreditCardABTestResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                CartInteractor.this.cartListener.onWalletCreditCardABTestStatusResponse(false);
            }

            public void onNext(WalletCreditCardABTestResponse walletCreditCardABTestResponse) {
                try {
                    CartInteractor.this.cartListener.onWalletCreditCardABTestStatusResponse(walletCreditCardABTestResponse.result.userExists);
                } catch (Exception unused) {
                    CartInteractor.this.cartListener.onWalletCreditCardABTestStatusResponse(false);
                }
            }
        });
    }

    public void getAllBinOffers() {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        ParallelBinRequest parallelBinRequest = new ParallelBinRequest(Cart.getInstance().getRestaurant().getId(), GlobalDataModel.SelectedAreaId);
        GlobalDataModel.PARALLELBIN.reset();
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) parallelBinRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) parallelBinRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_ALL_BINS).setClazz(ParallelBinRM.class).setRequestBody(jSONObject).setListener(onAllBinResponse()).setErrorListener(onAllBinRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getCampaignVoucher(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.CUSTOMVOUCHER;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restaurantid}", "" + i11})).setClazz(CampaignVoucherRM.class).setListener(onCampaignDetailsRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getCustomerTokensForBin() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_BIN_TOKENS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{payProvider}", "" + TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigRepository).tokenisationProvider, "{countryId}", "" + GlobalDataModel.SelectedCountryId, "{restaurantId}", "" + Cart.getInstance().getRestaurant().f13872id, "{branchId}", "" + Cart.getInstance().getRestaurant().branchId, "{areaId}", GlobalDataModel.SelectedAreaId + ""})).setClazz(BinTokenRM.class).setListener(onBinTokenResponseReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGroceryMenu(Restaurant restaurant) {
        this.onlyMenuLoaded = false;
        this.onlyInfoLoaded = false;
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        this.f26575b = Observable.zip(getGroceryInfoRetrofit(restaurant), getGroceryMenuRetrofit(restaurant), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
            public GroceryInfoAndMenuResponseZipped apply(MenuItemResponse menuItemResponse, SplitMenuRM splitMenuRM) throws Exception {
                return new GroceryInfoAndMenuResponseZipped(menuItemResponse, splitMenuRM);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GroceryInfoAndMenuResponseZipped>() {
            public void accept(GroceryInfoAndMenuResponseZipped groceryInfoAndMenuResponseZipped) throws Exception {
                Restaurant restaurant;
                MenuItemsResponseModel menuItemsResponseModel = groceryInfoAndMenuResponseZipped.getMenuItemResponse().result;
                if (menuItemsResponseModel != null) {
                    MenuItemsResponseModel menuItemsResponseModel2 = GlobalDataModel.JSON.menuItemsResponseModel;
                    menuItemsResponseModel2.warnings = menuItemsResponseModel.warnings;
                    menuItemsResponseModel2.deliveryAreas = menuItemsResponseModel.deliveryAreas;
                    menuItemsResponseModel2.promotions = menuItemsResponseModel.promotions;
                    menuItemsResponseModel2.restaurant = menuItemsResponseModel.restaurant;
                    menuItemsResponseModel2.upsellingItems = menuItemsResponseModel.upsellingItems;
                    menuItemsResponseModel2.heroImage = menuItemsResponseModel.heroImage;
                    GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel.tgoFreeDeliveryResponse;
                }
                Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                if (restaurant2 != null && menuItemsResponseModel != null && (restaurant = menuItemsResponseModel.restaurant) != null && restaurant.f13872id == restaurant2.f13872id) {
                    restaurant.setRecommendation(restaurant2.isRecommendation());
                    Restaurant restaurant3 = menuItemsResponseModel.restaurant;
                    Restaurant restaurant4 = GlobalDataModel.SELECTED.restaurant;
                    restaurant3.itemPosition = restaurant4.itemPosition;
                    restaurant3.swimlanePosition = restaurant4.swimlanePosition;
                } else if (menuItemsResponseModel == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in CartInteractor", new HashMap());
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in CartInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in CartInteractor", new HashMap());
                }
                if (menuItemsResponseModel != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                }
                CartInteractor.this.onlyInfoLoaded = true;
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                CartInteractor.this.onlyMenuLoaded = true;
                if (CartInteractor.this.cartListener != null) {
                    ChoiceLoader.startChoiceLoader(CartInteractor.this.appVersionProvider);
                    CartInteractor.this.cartListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    CartInteractor.this.cartListener.onServerError();
                } else {
                    CartInteractor.this.cartListener.onNetworkError();
                }
            }
        });
    }

    public Observable<SplitMenuRM> getGroceryMenuRetrofit(Restaurant restaurant) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_GROCERY_MENU;
        return callApi.getGroceryMenu(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + restaurant.getBranchId()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void getMcdLatLngStoresCheck(McdBranchRequest mcdBranchRequest, boolean z11) {
        String str;
        String str2;
        this.isGrlNewAddressEnabled = z11;
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            str = AppUrls.MCD_KSA_GET_BRANCH_ID;
        } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
            str = AppUrls.MCD_JORDAN_GET_BRANCH_ID;
        } else {
            str = "";
        }
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) mcdBranchRequest);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) mcdBranchRequest);
            }
            JSONObject jSONObject = new JSONObject(str2);
            GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdStoresReceived()).setErrorListener(onMcdStoreCheckRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getRestaurantInfoOnly(Restaurant restaurant) {
        String str;
        JSONObject jSONObject;
        this.onlyInfoLoaded = false;
        Gson gson = UniversalGson.INSTANCE.gson;
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) restaurantInfoRequestModel);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) restaurantInfoRequestModel);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()})).setClazz(MenuItemResponse.class).setRequestBody(jSONObject).setListener(onInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantMenuOnly(Restaurant restaurant) {
        this.onlyMenuLoaded = false;
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.SPLIT_RESTAURANT_MENU;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + restaurant.getBranchId()})).setClazz(SplitMenuRM.class).setListener(onMenuReceived(restaurant.getName())).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Observable<ShopStatusResponse> getShopStatus(String str, String str2, String str3, boolean z11) {
        return ApiHandler.callApi().getShopStatus(AppUrls.GET_SHOP_STATUS, str, str2, str3, z11);
    }

    public void getVoucherDetalsForLoyaltyVoucher(String str, String str2) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str3 = AppUrls.GET_LOYALTY_VOUCHER_INFO;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str3, new String[]{"{loyaltyVoucherId}", "" + str, "{brandId}", str2})).setClazz(LoyaltyVoucherRM.class).setListener(onLoyaltyVoucherInfoReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadCouponsAndPromotions(int i11, float f11, Restaurant restaurant) {
        this.disposables.add(this.f26576c.invoke(new AutoApplyDiscountsRequest(GlobalDataModel.SelectedCountryId, GlobalDataModel.SelectedAreaId, restaurant.f13872id, i11, (double) f11, Cart.getInstance().getOrderDeliveryMode())).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new b(this, i11, f11), new c(this, i11, f11)));
    }

    public void loadCustomerDetails() {
        if (z().booleanValue()) {
            loadCustomerDetailsFromMicroservice();
            return;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class).setListener(onAddressReceived(true)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadRestaurantReview(int i11, int i12) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.RESTAURANT_REVIEWS_PAGE;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchid}", "" + i11, "{pageNumber}", "" + i12})).setClazz(RestaurantReviewResponse.class).setListener(onReviewReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadUpSellingItems(Restaurant restaurant) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_UPSELLITEMS;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restautandid}", "" + restaurant.getId(), "{branchid}", "" + restaurant.getBranchId()})).setClazz(UpsellingResponse.class).setListener(onUpsellingItemsReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void loadUserInfoBackgroundFromMicroservice() {
        Single<List<Address>> customerAddressesFromMicroservice = getCustomerAddressesFromMicroservice();
        this.disposables.add(Single.zip(getLoadCustomerDetailsSingle(), customerAddressesFromMicroservice, new o()).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new p(this), new q(this)));
    }

    @VisibleForTesting
    public void observeAPIError(String str, Throwable th2) {
        String str2;
        int i11;
        if (th2.getMessage() != null) {
            str2 = th2.getMessage();
        } else {
            str2 = "";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Customer.getInstance().getCustomerInfo() != null) {
            i11 = Customer.getInstance().getCustomerInfo().f13850id;
        } else {
            i11 = -1;
        }
        linkedHashMap.put("customerId", String.valueOf(i11));
        linkedHashMap.put("errorMessage", str2);
        ObservabilityManager.trackUnExpectedScenario(str, linkedHashMap);
    }

    @VisibleForTesting
    public void observeAvailableCouponsAndAADs(@Nullable Coupon[] couponArr, @Nullable AutoApplyDiscount[] autoApplyDiscountArr, @Nullable Coupon[] couponArr2, @Nullable Coupon coupon, boolean z11, float f11) {
        String str;
        int i11;
        String str2;
        String str3;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        if (couponArr != null) {
            for (Coupon logValues : couponArr) {
                sb2.append(logValues.logValues());
            }
        }
        if (autoApplyDiscountArr != null) {
            for (AutoApplyDiscount logValues2 : autoApplyDiscountArr) {
                sb3.append(logValues2.logValues());
            }
        }
        String str4 = "none";
        if (couponArr2 == null || couponArr2.length <= 0) {
            str = str4;
        } else {
            AutoApplyDiscountCoupon autoApplyDiscountCoupon = couponArr2[0];
            if (autoApplyDiscountCoupon instanceof AutoApplyDiscountCoupon) {
                str = autoApplyDiscountCoupon.aadCampaignId;
            } else {
                str = String.valueOf(autoApplyDiscountCoupon.f13847id);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("state", "aggregator");
        if (Customer.getInstance().getCustomerInfo() != null) {
            i11 = Customer.getInstance().getCustomerInfo().f13850id;
        } else {
            i11 = -1;
        }
        linkedHashMap.put("customerId", String.valueOf(i11));
        linkedHashMap.put("isAADFlagEnabled", String.valueOf(z11));
        linkedHashMap.put("cartTotal", String.valueOf(f11));
        linkedHashMap.put("bestValueCouponId", str);
        if (sb2.toString().isEmpty()) {
            str2 = str4;
        } else {
            str2 = sb2.toString();
        }
        linkedHashMap.put("availableCoupons", str2);
        if (sb3.toString().isEmpty()) {
            str3 = str4;
        } else {
            str3 = sb3.toString();
        }
        linkedHashMap.put("availableAutoAppliedDiscounts", str3);
        if (coupon != null) {
            str4 = coupon.logValues();
        }
        linkedHashMap.put("selectCouponInCart", str4);
        ObservabilityManager.trackEvent(BackgroundAction.MENU_DISCOUNTS_EVENTS, (Map<String, String>) linkedHashMap);
    }

    public Response.ErrorListener onMcdStoreCheckRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (CartInteractor.this.cartListener != null) {
                        CartInteractor.this.cartListener.mcdBranchFailed();
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (CartInteractor.this.cartListener != null) {
                        CartInteractor.this.cartListener.mcdBranchFailed();
                    }
                } else if (!(volleyError instanceof AuthFailureError)) {
                    CartInteractor.this.cartListener.mcdBranchFailed();
                } else if (CartInteractor.this.cartListener != null) {
                    CartInteractor.this.cartListener.mcdBranchFailed();
                }
            }
        };
    }

    public void onMenuOrInfoLoaded() {
        if (this.onlyInfoLoaded && this.onlyMenuLoaded && this.cartListener != null) {
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            this.cartListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
        }
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && CartInteractor.this.cartListener != null) {
                    CartInteractor.this.cartListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && CartInteractor.this.cartListener != null) {
                    CartInteractor.this.cartListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && CartInteractor.this.cartListener != null) {
                    CartInteractor.this.cartListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.disposables.dispose();
        this.cartListener = null;
        Disposable disposable = this.f26575b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26575b.dispose();
        }
    }

    public void updateAddresswithGoogleAddress(Address address) {
        String str;
        this.userSelectedaddress = address;
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESSV2;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", "" + address.latitude, "{longitude}", "" + address.longitude, "{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(GeoAddressRequest.class).setListener(onGeoAddressRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void updateSelectedAddressGrl(McdBlockMapGrlUpdateRequest mcdBlockMapGrlUpdateRequest) {
        String str;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) mcdBlockMapGrlUpdateRequest);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) mcdBlockMapGrlUpdateRequest);
            }
            TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.MCD_BAHRAIN_ADDRESS_GRL_UPDATE).setClazz(McdBlockAddressGrlUpdateRM.class).setRequestBody(new JSONObject(str)).setListener(onGrlUpdatedinAddress()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void updateUserInfoBackground() {
        if (z().booleanValue()) {
            loadUserInfoBackgroundFromMicroservice();
            return;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class).setListener(onBackGroundAddressReceived(true)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    @VisibleForTesting
    public void updatedCouponsAndPromotionsSelectionLogic(@Nullable Promotion[] promotionArr, @Nullable Coupon[] couponArr, @Nullable AutoApplyDiscount[] autoApplyDiscountArr, float f11) {
        Coupon[] couponArr2;
        Coupon[] couponArr3;
        Promotion[] promotionArr2;
        if (promotionArr != null) {
            Cart instance = Cart.getInstance();
            if (promotionArr.length > 0) {
                promotionArr2 = promotionArr;
            } else {
                promotionArr2 = null;
            }
            instance.setPromotions(promotionArr2);
        }
        boolean z11 = false;
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(OrderingFeatureFlagsKeys.INCENTIVE_AUTO_APPLY_DISCOUNTS_ENABLED, false);
        if (featureFlag) {
            couponArr3 = this.autoApplyDiscountMapper.getBestMenuDiscountValue(autoApplyDiscountArr, couponArr, f11);
            couponArr2 = couponArr3;
        } else {
            couponArr2 = null;
            couponArr3 = couponArr;
        }
        Cart.getInstance().setCoupons(couponArr3);
        CartListener cartListener2 = this.cartListener;
        if (cartListener2 != null) {
            if (!(couponArr3 == null && promotionArr == null)) {
                z11 = true;
            }
            cartListener2.onCouponsAndPromotionsLoaded(z11);
        }
        observeAvailableCouponsAndAADs(couponArr, autoApplyDiscountArr, couponArr2, Cart.getInstance().selectedCoupon, featureFlag, f11);
    }

    @VisibleForTesting
    public Boolean z() {
        boolean z11;
        try {
            if (!this.locationConfigRepository.config().isAddressMicroServiceEnabled() || !LoggedInHelper.isLoggedIn()) {
                z11 = false;
            } else {
                z11 = true;
            }
            return Boolean.valueOf(z11);
        } catch (Exception e11) {
            LogManager.error(e11, "Fail to get isAddressMicroServiceEnabled()");
            return Boolean.FALSE;
        }
    }
}
