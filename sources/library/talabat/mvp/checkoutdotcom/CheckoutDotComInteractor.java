package library.talabat.mvp.checkoutdotcom;

import JsonModels.BinRM;
import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.OrderDetailsRM;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.PurchaseRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Request.RestaurantReq;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.CheckoutDotComResponse.PurchaseResponse;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.parser.UniversalGson;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import c10.a;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import datamodels.GemTier;
import datamodels.GroceryInfoAndMenuResponseZipped;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;

@Instrumented
public class CheckoutDotComInteractor implements ICheckoutDotComInteractor {
    /* access modifiers changed from: private */
    public final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26687b;
    /* access modifiers changed from: private */
    public CheckoutDotComListener checkoutDotComListener;
    /* access modifiers changed from: private */
    public boolean onlyInfoLoaded;
    /* access modifiers changed from: private */
    public boolean onlyMenuLoaded;
    private final PaymentConfigurationRepository paymentConfigurationRepository;

    public CheckoutDotComInteractor(AppVersionProvider appVersionProvider2, PaymentConfigurationRepository paymentConfigurationRepository2, CheckoutDotComListener checkoutDotComListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.checkoutDotComListener = checkoutDotComListener2;
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(Restaurant restaurant) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$0(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            CheckoutDotComListener checkoutDotComListener2 = this.checkoutDotComListener;
            if (checkoutDotComListener2 != null) {
                checkoutDotComListener2.onServerError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            CheckoutDotComListener checkoutDotComListener3 = this.checkoutDotComListener;
            if (checkoutDotComListener3 != null) {
                checkoutDotComListener3.onEmptyMenuReceived(str);
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

    private Response.ErrorListener onBinRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                CheckoutDotComListener unused = CheckoutDotComInteractor.this.checkoutDotComListener;
            }
        };
    }

    private Response.Listener<BinRM> onBinResponse() {
        return new Response.Listener<BinRM>() {
            public void onResponse(BinRM binRM) {
                BinResponse binResponse;
                if (CheckoutDotComInteractor.this.checkoutDotComListener != null && binRM != null && (binResponse = binRM.result) != null) {
                    if (binResponse.isValid && binResponse.binDiscount > 0.0f) {
                        CheckoutDotComInteractor.this.checkoutDotComListener.onBinVoucherAvailable(binRM.result);
                    } else if (binResponse.onlyShowMessage) {
                        CheckoutDotComListener c11 = CheckoutDotComInteractor.this.checkoutDotComListener;
                        BinResponse binResponse2 = binRM.result;
                        c11.onMinimumOrderConditionFailed(binResponse2.message, binResponse2.binNum);
                    }
                    if (!TalabatUtils.isNullOrEmpty(binRM.result.publicKey)) {
                        BinResponse binResponse3 = binRM.result;
                        GlobalDataModel.CHECKOUTDOTCOM.routingEnabledPublicKey = binResponse3.publicKey;
                        GlobalDataModel.CHECKOUTDOTCOM.bankId = binResponse3.bankId;
                    }
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
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in CheckoutDotComInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in CheckoutDotComInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in CheckoutDotComInteractor", new HashMap());
                        }
                    }
                    if (CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                        CheckoutDotComInteractor.this.checkoutDotComListener.onServerError();
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
                CheckoutDotComInteractor.this.onlyInfoLoaded = true;
                CheckoutDotComInteractor.this.onMenuOrInfoLoaded();
            }
        };
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(String str) {
        return new a(this, str);
    }

    private Response.Listener<MenuItemResponse> onMenuRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
                MenuItemsResponseModel menuItemsResponseModel = menuItemResponse.result;
                GlobalDataModel.JSON.menuItemsResponseModel = menuItemsResponseModel;
                if (!(menuItemsResponseModel == null || menuItemsResponseModel.upsellingItems == null)) {
                    Cart.getInstance().setUpsellingItem(menuItemResponse.result.upsellingItems);
                }
                if (CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onMenuLoadingCompleted(menuItemResponse.result);
                }
            }
        };
    }

    private Response.Listener<OrderDetailsRM> onOrderDetailsResultRecieved() {
        return new Response.Listener<OrderDetailsRM>() {
            public void onResponse(OrderDetailsRM orderDetailsRM) {
                if (CheckoutDotComInteractor.this.checkoutDotComListener == null) {
                    return;
                }
                if (orderDetailsRM.result != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onOrderDetailsRecieved(orderDetailsRM.result);
                } else {
                    CheckoutDotComInteractor.this.onRequestError();
                }
            }
        };
    }

    private Response.Listener<PurchaseResponse> onRequestResponse() {
        return new Response.Listener<PurchaseResponse>() {
            public void onResponse(PurchaseResponse purchaseResponse) {
                if (CheckoutDotComInteractor.this.checkoutDotComListener == null) {
                    return;
                }
                if (!purchaseResponse.isValid) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onCheckoutDotComFailed(purchaseResponse.message);
                } else if (!TalabatUtils.isNullOrEmpty(purchaseResponse.redirectUrl) && purchaseResponse.verificationCode == 1) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onRedirectToPaymentWebViewWithCheckoutDotCom(purchaseResponse);
                } else if (purchaseResponse.verificationCode == 0) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onSuccessfulCheckoutDotCom();
                }
            }
        };
    }

    private Response.Listener<RestuarntListResponse> onRestaurantsRecieved() {
        return new Response.Listener<RestuarntListResponse>() {
            public void onResponse(RestuarntListResponse restuarntListResponse) {
                GemTier gemTier;
                if (restuarntListResponse != null) {
                    if (restuarntListResponse.result == null && CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                        CheckoutDotComInteractor.this.checkoutDotComListener.onNullResponseReceived();
                    }
                    GlobalDataModel.updateRestaurantsData(restuarntListResponse.result);
                    GemTier[] gemTierArr = restuarntListResponse.result.gemTiers;
                    if (!(gemTierArr == null || gemTierArr.length <= 0 || (gemTier = gemTierArr[0]) == null)) {
                        GlobalDataModel.GEMCONSTANTS.GemTiers = gemTier;
                    }
                    if (CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                        CheckoutDotComInteractor.this.checkoutDotComListener.onRestaurantListLoaded();
                    }
                } else if (CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onNullResponseReceived();
                }
            }
        };
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
        GlobalDataModel.CHECKOUTDOTCOM.routingEnabledPublicKey = "";
        GlobalDataModel.CHECKOUTDOTCOM.bankId = -1;
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GET_BIN_VOUCHER).setClazz(BinRM.class).setRequestBody(jSONObject).setListener(onBinResponse()).setErrorListener(onBinRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
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
        this.f26687b = Observable.zip(getGroceryInfoRetrofit(restaurant), getGroceryMenuRetrofit(restaurant), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
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
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in CheckoutDotComInteractor", new HashMap());
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in CheckoutDotComInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in CheckoutDotComInteractor", new HashMap());
                }
                if (menuItemsResponseModel != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                }
                CheckoutDotComInteractor.this.onlyInfoLoaded = true;
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                CheckoutDotComInteractor.this.onlyMenuLoaded = true;
                if (CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    ChoiceLoader.startChoiceLoader(CheckoutDotComInteractor.this.appVersionProvider);
                    CheckoutDotComInteractor.this.checkoutDotComListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onServerError();
                } else {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onNetworkError();
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

    @VisibleForTesting
    public String getPayUrl() {
        String checkoutBaseUrl = this.paymentConfigurationRepository.config().getCheckoutBaseUrl();
        String checkoutPayUrl = this.paymentConfigurationRepository.config().getCheckoutPayUrl();
        return checkoutBaseUrl + checkoutPayUrl;
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

    public void onMenuOrInfoLoaded() {
        if (this.onlyInfoLoaded && this.onlyMenuLoaded && this.checkoutDotComListener != null) {
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            this.checkoutDotComListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
        }
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((!(volleyError instanceof ClientError) || volleyError.networkResponse.statusCode != 403) && CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.enableButtonOnError();
                }
                if ((volleyError instanceof ServerError) && CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && CheckoutDotComInteractor.this.checkoutDotComListener != null) {
                    CheckoutDotComInteractor.this.checkoutDotComListener.onDataError();
                }
            }
        };
    }

    public void proceedPayment(PurchaseRequest purchaseRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) purchaseRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) purchaseRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addPaymentRequestToQueue(new GsonRequest.Builder().setMethod(1).setUrl(getPayUrl()).setClazz(PurchaseResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        Disposable disposable = this.f26687b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26687b.dispose();
        }
        this.checkoutDotComListener = null;
    }
}
