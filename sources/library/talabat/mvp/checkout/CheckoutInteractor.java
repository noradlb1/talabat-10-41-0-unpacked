package library.talabat.mvp.checkout;

import JsonModels.BinRM;
import JsonModels.CampaignVoucherRM;
import JsonModels.DeliveryTimesResponse;
import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.OrderDetailsRM;
import JsonModels.Request.BIN.BinOfferRequest;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.Cashback.CashBackRequest;
import JsonModels.Request.ParallelBin.ParallelBinRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Request.RestaurantReq;
import JsonModels.Request.VisaCheckoutRequest.DecryptionRequest;
import JsonModels.Request.VisaCheckoutRequest.PurchaseRequest;
import JsonModels.Response.BIN.BinOffersResponse;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.BIN.BinTokenResponse;
import JsonModels.Response.BinOffersRM;
import JsonModels.Response.BinTokenRM;
import JsonModels.Response.Cashback.CashbackRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.ParallelBin.ParallelBinRM;
import JsonModels.Response.ParallelBin.ParallelBinResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.Response.VisaCheckoutResponse.DecryptionResponse;
import JsonModels.Response.VisaCheckoutResponse.PurchaseResponse;
import JsonModels.parser.UniversalGson;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import b10.a;
import b10.b;
import b10.c;
import b10.d;
import b10.e;
import b10.f;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentWithErrorHandlingUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.PostSubscriptionPaymentRxWrapper;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import datamodels.CardInformation;
import datamodels.DeliveryTiming;
import datamodels.GemTier;
import datamodels.GroceryInfoAndMenuResponseZipped;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;
import ue.m0;

@Instrumented
public class CheckoutInteractor implements ICheckoutInteractor {
    /* access modifiers changed from: private */
    public final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26662b;

    /* renamed from: c  reason: collision with root package name */
    public PostSubscriptionPaymentRxWrapper f26663c;
    /* access modifiers changed from: private */
    public CheckoutListener checkoutListener;
    private final ConfigurationLocalRepository configurationLocalRepository;

    /* renamed from: d  reason: collision with root package name */
    public GetActiveSubscriptionsRxWrapper f26664d;
    private CompositeDisposable disposables = new CompositeDisposable();

    /* renamed from: e  reason: collision with root package name */
    public ISubscriptionStatusRepository f26665e;
    private final LocationConfigurationRepository locationConfigRepository;
    /* access modifiers changed from: private */
    public boolean onlyInfoLoaded;
    /* access modifiers changed from: private */
    public boolean onlyMenuLoaded;
    private final PaymentConfigurationRepository paymentConfigurationRepository;

    public CheckoutInteractor(AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository, PaymentConfigurationRepository paymentConfigurationRepository2, CheckoutListener checkoutListener2, PostSubscriptionPaymentRxWrapper postSubscriptionPaymentRxWrapper, GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.checkoutListener = checkoutListener2;
        this.f26663c = postSubscriptionPaymentRxWrapper;
        this.f26664d = getActiveSubscriptionsRxWrapper;
        this.f26665e = iSubscriptionStatusRepository;
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(Restaurant restaurant) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getGetActiveSubscriptions$2(Function1 function1, Subscription subscription) throws Exception {
        this.f26665e.setTProSubscriptionInfo(subscription);
        if (function1 != null) {
            this.checkoutListener.onSubscriptionPlansLoaded(function1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getGetActiveSubscriptions$3(Function1 function1, Throwable th2) throws Exception {
        this.checkoutListener.showSubscriptionErrorDialog();
        if (function1 != null) {
            this.checkoutListener.onSubscriptionPlansLoaded(function1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAllBinResponse$4(boolean z11, ParallelBinRM parallelBinRM) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (this.checkoutListener == null) {
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
            this.checkoutListener.onParallelBinAvailable(z11);
            return;
        }
        GlobalDataModel.PARALLELBIN.notAvailable = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$5(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            CheckoutListener checkoutListener2 = this.checkoutListener;
            if (checkoutListener2 != null) {
                checkoutListener2.onRequestError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            CheckoutListener checkoutListener3 = this.checkoutListener;
            if (checkoutListener3 != null) {
                checkoutListener3.onEmptyMenuReceived(str);
            }
        } else {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = splitMenuRM.result.menu;
            menuItemsResponseModel.menu = menuItemRM;
            MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
            this.onlyMenuLoaded = true;
            onMenuOrInfoLoaded();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postSubscriptionPayment$0(SubscriptionPaymentStatus subscriptionPaymentStatus) throws Exception {
        if (subscriptionPaymentStatus.getError().isEmpty() || m0.a(subscriptionPaymentStatus.getError())) {
            this.checkoutListener.usePaymentResult(subscriptionPaymentStatus);
            getGetActiveSubscriptions((Function1<Boolean, Unit>) null);
            return;
        }
        this.checkoutListener.showSubscriptionErrorDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postSubscriptionPayment$1(Throwable th2) throws Exception {
        this.checkoutListener.showSubscriptionErrorDialog();
    }

    private Response.ErrorListener onAllBinRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                GlobalDataModel.PARALLELBIN.notAvailable = true;
            }
        };
    }

    private Response.Listener<ParallelBinRM> onAllBinResponse(boolean z11) {
        return new b(this, z11);
    }

    private Response.Listener<BinOffersRM> onBinOffersResponseReceived() {
        return new Response.Listener<BinOffersRM>() {
            public void onResponse(BinOffersRM binOffersRM) {
                if (CheckoutInteractor.this.checkoutListener != null) {
                    BinOffersResponse binOffersResponse = binOffersRM.result;
                    if (!binOffersResponse.isValid || TalabatUtils.isNullOrEmpty(binOffersResponse.notificationMesage)) {
                        CheckoutInteractor.this.checkoutListener.hideBinAvailableNotification();
                    } else {
                        CheckoutInteractor.this.checkoutListener.showBinAvailableNotification(binOffersRM.result.notificationMesage);
                    }
                }
            }
        };
    }

    private Response.ErrorListener onBinRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onBinNotAvailable("");
                }
            }
        };
    }

    private Response.Listener<BinRM> onBinResponse() {
        return new Response.Listener<BinRM>() {
            public void onResponse(BinRM binRM) {
                BinResponse binResponse;
                if (CheckoutInteractor.this.checkoutListener != null && binRM != null && (binResponse = binRM.result) != null) {
                    if (binResponse.isValid && binResponse.binDiscount > 0.0f) {
                        CheckoutInteractor.this.checkoutListener.onBinVoucherAvailable(binRM.result);
                    } else if (binResponse.onlyShowMessage) {
                        CheckoutInteractor.this.checkoutListener.onMinimumOrderConditionFailed(binRM.result.binNum);
                    } else {
                        CheckoutInteractor.this.checkoutListener.onBinNotAvailable(binRM.result.status);
                    }
                }
            }
        };
    }

    private Response.Listener<BinTokenRM> onBinTokenResponseReceived() {
        return new Response.Listener<BinTokenRM>() {
            public void onResponse(BinTokenRM binTokenRM) {
                if (binTokenRM != null) {
                    GlobalDataModel.BIN.handled = true;
                    BinTokenResponse[] binTokenResponseArr = binTokenRM.result;
                    if (binTokenResponseArr != null) {
                        int length = binTokenResponseArr.length;
                    }
                }
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onBinResponseReceived(binTokenRM);
                }
            }
        };
    }

    private Response.Listener<CampaignVoucherRM> onCampaignDetailsRecieved() {
        return new Response.Listener<CampaignVoucherRM>() {
            public void onResponse(CampaignVoucherRM campaignVoucherRM) {
                boolean z11 = campaignVoucherRM.result.isVoucherAvailable;
            }
        };
    }

    private Response.ErrorListener onCashbackRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onCashbackResponseError();
                }
            }
        };
    }

    private Response.Listener<CashbackRM> onCashbackResponseReceived() {
        return new Response.Listener<CashbackRM>() {
            public void onResponse(CashbackRM cashbackRM) {
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onCashbackResponseReceived(cashbackRM);
                }
            }
        };
    }

    private Response.Listener<DecryptionResponse> onDecryptionResponse() {
        return new Response.Listener<DecryptionResponse>() {
            public void onResponse(DecryptionResponse decryptionResponse) {
                if (CheckoutInteractor.this.checkoutListener != null && decryptionResponse != null) {
                    if (decryptionResponse.isValid) {
                        CheckoutInteractor.this.checkoutListener.onDecryptionDataReceived(decryptionResponse);
                    } else {
                        CheckoutInteractor.this.checkoutListener.onDecryptionErrorOccurred(decryptionResponse.displayMessage);
                    }
                }
            }
        };
    }

    private Response.Listener<DeliveryTimesResponse> onDeliveryTimesRecived() {
        return new Response.Listener<DeliveryTimesResponse>() {
            public void onResponse(DeliveryTimesResponse deliveryTimesResponse) {
                ArrayList arrayList = new ArrayList();
                for (DeliveryTiming deliveryTiming : deliveryTimesResponse.result.deliveryTimings) {
                    arrayList.add(deliveryTiming.val);
                }
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onDeliveryTimesLoaded(arrayList);
                }
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
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in CheckoutInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in CheckoutInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in CheckoutInteractor", new HashMap());
                        }
                    }
                    if (CheckoutInteractor.this.checkoutListener != null) {
                        CheckoutInteractor.this.checkoutListener.onRequestError();
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
                menuItemsResponseModel3.upsellingItems = menuItemsResponseModel4.upsellingItems;
                menuItemsResponseModel3.heroImage = menuItemsResponseModel4.heroImage;
                GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel4.tgoFreeDeliveryResponse;
                MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemsResponseModel4);
                menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                if (menuItemResponse.result.upsellingItems != null) {
                    Cart.getInstance().setUpsellingItem(menuItemResponse.result.upsellingItems);
                }
                CheckoutInteractor.this.onlyInfoLoaded = true;
                CheckoutInteractor.this.onMenuOrInfoLoaded();
            }
        };
    }

    private Response.Listener<LoyaltyVoucherRM> onLoyaltyVoucherInfoReceived() {
        return new Response.Listener<LoyaltyVoucherRM>() {
            public void onResponse(LoyaltyVoucherRM loyaltyVoucherRM) {
                if (CheckoutInteractor.this.checkoutListener == null) {
                    return;
                }
                if (loyaltyVoucherRM == null) {
                    CheckoutInteractor.this.checkoutListener.onLoyaltyVoucherError();
                } else if (loyaltyVoucherRM.result != null) {
                    CheckoutInteractor.this.checkoutListener.onLoyaltyVoucherInfoReceived(loyaltyVoucherRM);
                } else {
                    CheckoutInteractor.this.checkoutListener.onLoyaltyVoucherError();
                }
            }
        };
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(String str) {
        return new a(this, str);
    }

    private Response.Listener<OrderDetailsRM> onOrderDetailsResultRecieved() {
        return new Response.Listener<OrderDetailsRM>() {
            public void onResponse(OrderDetailsRM orderDetailsRM) {
                if (CheckoutInteractor.this.checkoutListener == null) {
                    return;
                }
                if (orderDetailsRM.result != null) {
                    CheckoutInteractor.this.checkoutListener.onOrderDetailsRecieved(orderDetailsRM.result);
                } else {
                    CheckoutInteractor.this.onRequestError();
                }
            }
        };
    }

    private Response.Listener<PurchaseResponse> onRequestResponse() {
        return new Response.Listener<PurchaseResponse>() {
            public void onResponse(PurchaseResponse purchaseResponse) {
                if (CheckoutInteractor.this.checkoutListener != null && purchaseResponse != null) {
                    if (purchaseResponse.isValid) {
                        if (TalabatUtils.isNullOrEmpty(purchaseResponse.redirectUrl)) {
                            return;
                        }
                        if (purchaseResponse.redirectUrl.toLowerCase().contains(AppUrls.TRANSACTION_THANK_YOU_SEGMENT)) {
                            CheckoutInteractor.this.checkoutListener.redirectToThankyouPage();
                        } else {
                            CheckoutInteractor.this.checkoutListener.onRedirectToPaymentWebViewWithVisaCheckout(purchaseResponse);
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(purchaseResponse.redirectUrl) || !TalabatUtils.isNullOrEmpty(purchaseResponse.message)) {
                        CheckoutInteractor.this.checkoutListener.onVisaCheckoutPaymentErrorWebview(purchaseResponse.message);
                    }
                }
            }
        };
    }

    private Response.Listener<RestuarntListResponse> onRestaurantsRecieved() {
        return new Response.Listener<RestuarntListResponse>() {
            public void onResponse(RestuarntListResponse restuarntListResponse) {
                GemTier gemTier;
                if (restuarntListResponse != null) {
                    if (restuarntListResponse.result == null) {
                        ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in RestaurantListInteractor", new HashMap());
                        if (CheckoutInteractor.this.checkoutListener != null) {
                            CheckoutInteractor.this.checkoutListener.onNullResponseReceived();
                        }
                    }
                    GlobalDataModel.updateRestaurantsData(restuarntListResponse.result);
                    GemTier[] gemTierArr = restuarntListResponse.result.gemTiers;
                    if (!(gemTierArr == null || gemTierArr.length <= 0 || (gemTier = gemTierArr[0]) == null)) {
                        GlobalDataModel.GEMCONSTANTS.GemTiers = gemTier;
                    }
                    if (CheckoutInteractor.this.checkoutListener != null) {
                        CheckoutInteractor.this.checkoutListener.onRestaurantListLoaded();
                    }
                } else if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onNullResponseReceived();
                }
            }
        };
    }

    private Response.Listener<MenuItemResponse> onResultRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
                MenuItemsResponseModel menuItemsResponseModel = menuItemResponse.result;
                GlobalDataModel.JSON.menuItemsResponseModel = menuItemsResponseModel;
                if (!(menuItemsResponseModel == null || menuItemsResponseModel.upsellingItems == null)) {
                    Cart.getInstance().setUpsellingItem(menuItemResponse.result.upsellingItems);
                }
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onMenuLoadingCompleted(menuItemResponse.result);
                }
            }
        };
    }

    public void callCashBackApi(float f11) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        CashBackRequest cashBackRequest = new CashBackRequest(f11 + "", GlobalDataModel.SelectedCountryId + "");
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) cashBackRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) cashBackRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.TALABAT_CREDIT_CASHBACK).setClazz(CashbackRM.class).setRequestBody(jSONObject).setListener(onCashbackResponseReceived()).setErrorListener(onCashbackRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void checkForBinVoucher(BinRequest binRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) binRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) binRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_BIN_VOUCHER).setClazz(BinRM.class).setRequestBody(jSONObject).setListener(onBinResponse()).setErrorListener(onBinRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getAllBinOffers(boolean z11) {
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
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_ALL_BINS).setClazz(ParallelBinRM.class).setRequestBody(jSONObject).setListener(onAllBinResponse(z11)).setErrorListener(onAllBinRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getBinOfferDetails(int i11, boolean z11, boolean z12, boolean z13, String str, int i12) {
        String str2;
        JSONObject jSONObject;
        BinOfferRequest binOfferRequest = new BinOfferRequest(i11, z11, z12, z13, str, GlobalDataModel.SelectedAreaId, i12);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str2 = gson.toJson((Object) binOfferRequest);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) binOfferRequest);
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_BIN_DETAILS).setClazz(BinOffersRM.class).setRequestBody(jSONObject).setListener(onBinOffersResponseReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
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

    public void getDeliveryTimeIntervals(int i11, int i12, String str) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.GETRESTAURANT_DELIVERY_TIMES;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{Branchid}", "" + i11, "{areaid}", "" + i12, "{restaurantstatus}", "" + str})).setClazz(DeliveryTimesResponse.class).setListener(onDeliveryTimesRecived()).setErrorListener(onDeliveryTimeRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGetActiveSubscriptions(Function1<Boolean, Unit> function1) {
        this.f26664d.single(new GetActiveSubscriptionsUseCase.Params(this.configurationLocalRepository.selectedCountry())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, function1), new d(this, function1));
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
        this.f26662b = Observable.zip(getGroceryInfoRetrofit(restaurant), getGroceryMenuRetrofit(restaurant), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
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
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in CheckoutInteractor", new HashMap());
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in CheckoutInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in CheckoutInteractor", new HashMap());
                }
                if (menuItemsResponseModel != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                }
                CheckoutInteractor.this.onlyInfoLoaded = true;
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                CheckoutInteractor.this.onlyMenuLoaded = true;
                if (CheckoutInteractor.this.checkoutListener != null) {
                    ChoiceLoader.startChoiceLoader(CheckoutInteractor.this.appVersionProvider);
                    CheckoutInteractor.this.checkoutListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    CheckoutInteractor.this.checkoutListener.onServerError();
                } else {
                    CheckoutInteractor.this.checkoutListener.onNetworkError();
                }
            }
        });
    }

    public Observable<SplitMenuRM> getGroceryMenuRetrofit(Restaurant restaurant) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_GROCERY_MENU;
        return callApi.getGroceryMenu(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + restaurant.getBranchId()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void getOrderDetails(String str) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.ORDERDETAILSTALABAT, new String[]{"{transactionId}", str})).setClazz(OrderDetailsRM.class).setListener(onOrderDetailsResultRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Observable<MenuItemResponse> getRestaurantInfo(int i11, double d11, double d12) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, d11 + "", d12 + "", GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getRestaurantInfoWithLocation(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION.replace("{branchId}", i11 + ""), restaurantInfoRequestModel);
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

    public void getRestaurants(int i11, int i12, int i13) {
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GETRESTANTS).setClazz(RestuarntListResponse.class).setRequestBody(new RestaurantReq(i11, i12, GlobalDataModel.SelectedCountryId).getJsonBody()).setListener(onRestaurantsRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    @VisibleForTesting
    public String getVisaPayUrl() {
        String checkoutBaseUrl = this.paymentConfigurationRepository.config().getCheckoutBaseUrl();
        return checkoutBaseUrl + GlobalDataModel.VISACHECKOUT.visaCheckoutPayUrl;
    }

    public void getVoucherDetalsForLoyaltyVoucher(String str, String str2) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str3 = AppUrls.GET_LOYALTY_VOUCHER_INFO;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str3, new String[]{"{loyaltyVoucherId}", "" + str, "{brandId}", str2})).setClazz(LoyaltyVoucherRM.class).setListener(onLoyaltyVoucherInfoReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onDeliveryTimeRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onDeliveryTimesNotavailable();
                }
            }
        };
    }

    public void onMenuOrInfoLoaded() {
        if (this.onlyInfoLoaded && this.onlyMenuLoaded && this.checkoutListener != null) {
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            this.checkoutListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
        }
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onDataError();
                }
                if (CheckoutInteractor.this.checkoutListener != null) {
                    CheckoutInteractor.this.checkoutListener.onHideLoader();
                }
            }
        };
    }

    public void postSubscriptionPayment(CardInformation cardInformation) {
        this.disposables.add(this.f26663c.single(new GetSubscriptionPaymentWithErrorHandlingUseCase.Params(cardInformation.getPlanId(), cardInformation.getCardTokenId(), cardInformation.getCard4Digits(), cardInformation.getCardType(), Integer.valueOf(cardInformation.getPaymentMethod()), cardInformation.getCardExpiryMonth(), cardInformation.getCardExpiryYear())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this)));
    }

    public void proceedForVisaCheckout(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.transactionId = str;
        purchaseRequest.callId = str2;
        purchaseRequest.language = GlobalDataModel.SelectedLanguage;
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) purchaseRequest);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) purchaseRequest);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addPaymentRequestToQueue(new GsonRequest.Builder().setMethod(1).setUrl(getVisaPayUrl()).setClazz(PurchaseResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void sendDecryptRequest(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        DecryptionRequest decryptionRequest = new DecryptionRequest(str, str2);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) decryptionRequest);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) decryptionRequest);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.DECRYPTION_URL).setClazz(DecryptionResponse.class).setRequestBody(jSONObject).setListener(onDecryptionResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        this.disposables.dispose();
        Disposable disposable = this.f26662b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26662b.dispose();
        }
        this.checkoutListener = null;
    }
}
