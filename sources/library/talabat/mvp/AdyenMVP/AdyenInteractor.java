package library.talabat.mvp.AdyenMVP;

import JsonModels.BinRM;
import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.OrderDetailsRM;
import JsonModels.Request.AdyenRequestModels.AdyenPurchaseRequest;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Request.RestaurantReq;
import JsonModels.Response.AdyenResponse.AdyenPurchaseResponse;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.parser.UniversalGson;
import androidx.webkit.ProxyConfig;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.BASEURLS;
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
import w00.a;

@Instrumented
public class AdyenInteractor implements IAdyenInteractor {
    /* access modifiers changed from: private */
    public AdyenListener adyenListener;
    /* access modifiers changed from: private */
    public AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26533b;
    /* access modifiers changed from: private */
    public boolean onlyInfoLoaded;
    /* access modifiers changed from: private */
    public boolean onlyMenuLoaded;

    public AdyenInteractor(AdyenListener adyenListener2, AppVersionProvider appVersionProvider2) {
        this.adyenListener = adyenListener2;
        this.appVersionProvider = appVersionProvider2;
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(Restaurant restaurant) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$0(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            AdyenListener adyenListener2 = this.adyenListener;
            if (adyenListener2 != null) {
                adyenListener2.onRequestError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            AdyenListener adyenListener3 = this.adyenListener;
            if (adyenListener3 != null) {
                adyenListener3.onEmptyMenuReceived(str);
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
                AdyenListener unused = AdyenInteractor.this.adyenListener;
            }
        };
    }

    private Response.Listener<BinRM> onBinResponse() {
        return new Response.Listener<BinRM>() {
            public void onResponse(BinRM binRM) {
                BinResponse binResponse;
                if (AdyenInteractor.this.adyenListener != null && binRM != null && (binResponse = binRM.result) != null) {
                    if (binResponse.isValid && binResponse.binDiscount > 0.0f) {
                        AdyenInteractor.this.adyenListener.onBinVoucherAvailable(binRM.result);
                    } else if (binResponse.onlyShowMessage) {
                        AdyenListener b11 = AdyenInteractor.this.adyenListener;
                        BinResponse binResponse2 = binRM.result;
                        b11.onMinimumOrderConditionFailed(binResponse2.message, binResponse2.binNum);
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
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in AdyenInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in AdyenInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in AdyenInteractor", new HashMap());
                        }
                    }
                    if (AdyenInteractor.this.adyenListener != null) {
                        AdyenInteractor.this.adyenListener.onRequestError();
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
                if (menuItemsResponseModel4.upsellingItems != null) {
                    Cart.getInstance().setUpsellingItem(menuItemResponse.result.upsellingItems);
                }
                MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemResponse.result);
                menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                AdyenInteractor.this.onlyInfoLoaded = true;
                AdyenInteractor.this.onMenuOrInfoLoaded();
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
                if (AdyenInteractor.this.adyenListener != null) {
                    AdyenInteractor.this.adyenListener.onMenuLoadingCompleted(menuItemResponse.result);
                }
            }
        };
    }

    private Response.Listener<OrderDetailsRM> onOrderDetailsResultRecieved() {
        return new Response.Listener<OrderDetailsRM>() {
            public void onResponse(OrderDetailsRM orderDetailsRM) {
                if (AdyenInteractor.this.adyenListener == null) {
                    return;
                }
                if (orderDetailsRM.result != null) {
                    AdyenInteractor.this.adyenListener.onOrderDetailsRecieved(orderDetailsRM.result);
                } else {
                    AdyenInteractor.this.onRequestError();
                }
            }
        };
    }

    private Response.Listener<AdyenPurchaseResponse> onRequestResponse() {
        return new Response.Listener<AdyenPurchaseResponse>() {
            public void onResponse(AdyenPurchaseResponse adyenPurchaseResponse) {
                if (AdyenInteractor.this.adyenListener == null) {
                    return;
                }
                if (!adyenPurchaseResponse.isValid) {
                    AdyenInteractor.this.adyenListener.onAdyenFailed(adyenPurchaseResponse.message);
                } else if (!TalabatUtils.isNullOrEmpty(adyenPurchaseResponse.redirectUrl) && adyenPurchaseResponse.verificationCode == 1) {
                    AdyenInteractor.this.adyenListener.onRedirectToPaymentWebViewWithAdyen(adyenPurchaseResponse);
                } else if (adyenPurchaseResponse.verificationCode == 0) {
                    AdyenInteractor.this.adyenListener.onSuccessfulAdyen();
                }
            }
        };
    }

    private Response.Listener<RestuarntListResponse> onRestaurantsRecieved() {
        return new Response.Listener<RestuarntListResponse>() {
            public void onResponse(RestuarntListResponse restuarntListResponse) {
                GemTier gemTier;
                if (restuarntListResponse != null) {
                    if (restuarntListResponse.result == null && AdyenInteractor.this.adyenListener != null) {
                        AdyenInteractor.this.adyenListener.onNullResponseReceived();
                    }
                    GlobalDataModel.updateRestaurantsData(restuarntListResponse.result);
                    GemTier[] gemTierArr = restuarntListResponse.result.gemTiers;
                    if (!(gemTierArr == null || gemTierArr.length <= 0 || (gemTier = gemTierArr[0]) == null)) {
                        GlobalDataModel.GEMCONSTANTS.GemTiers = gemTier;
                    }
                    if (AdyenInteractor.this.adyenListener != null) {
                        AdyenInteractor.this.adyenListener.onRestaurantListLoaded();
                    }
                } else if (AdyenInteractor.this.adyenListener != null) {
                    AdyenInteractor.this.adyenListener.onNullResponseReceived();
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
        this.f26533b = Observable.zip(getGroceryInfoRetrofit(restaurant), getGroceryMenuRetrofit(restaurant), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
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
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in AdyenInteractor", new HashMap());
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in AdyenInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in AdyenInteractor", new HashMap());
                }
                if (menuItemsResponseModel != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                }
                AdyenInteractor.this.onlyInfoLoaded = true;
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                AdyenInteractor.this.onlyMenuLoaded = true;
                if (AdyenInteractor.this.adyenListener != null) {
                    ChoiceLoader.startChoiceLoader(AdyenInteractor.this.appVersionProvider);
                    AdyenInteractor.this.adyenListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    AdyenInteractor.this.adyenListener.onServerError();
                } else {
                    AdyenInteractor.this.adyenListener.onNetworkError();
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
        if (this.onlyInfoLoaded && this.onlyMenuLoaded && this.adyenListener != null) {
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            this.adyenListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
        }
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((!(volleyError instanceof ClientError) || volleyError.networkResponse.statusCode != 403) && AdyenInteractor.this.adyenListener != null) {
                    AdyenInteractor.this.adyenListener.enableButtonOnError();
                }
                if ((volleyError instanceof ServerError) && AdyenInteractor.this.adyenListener != null) {
                    AdyenInteractor.this.adyenListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && AdyenInteractor.this.adyenListener != null) {
                    AdyenInteractor.this.adyenListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && AdyenInteractor.this.adyenListener != null) {
                    AdyenInteractor.this.adyenListener.onDataError();
                }
            }
        };
    }

    public void proceedPayment(AdyenPurchaseRequest adyenPurchaseRequest) {
        String str;
        JSONObject jSONObject;
        Gson create = new GsonBuilder().disableHtmlEscaping().create();
        if (!(create instanceof Gson)) {
            str = create.toJson((Object) adyenPurchaseRequest);
        } else {
            str = GsonInstrumentation.toJson(create, (Object) adyenPurchaseRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addPaymentRequestToQueue(new GsonRequest.Builder().setMethod(1).setUrl(BASEURLS.getCheckoutBaseUrl() + GlobalDataModel.ADYENCONSTANTS.adyenPayUrl).setClazz(AdyenPurchaseResponse.class).setRequestBody(jSONObject).setListener(onRequestResponse()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void unregister() {
        Disposable disposable = this.f26533b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26533b.dispose();
        }
        this.adyenListener = null;
    }
}
