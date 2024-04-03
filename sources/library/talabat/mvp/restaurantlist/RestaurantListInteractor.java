package library.talabat.mvp.restaurantlist;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.InforMapAddressRM;
import JsonModels.Response.McdStoresRM;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.parser.UniversalGson;
import androidx.webkit.ProxyConfig;
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
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.userandlocation.tracking.InforMapTracker;
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
import z10.a;
import z10.b;

@Instrumented
public class RestaurantListInteractor implements IRestaurantListInteractor {
    /* access modifiers changed from: private */
    public final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26817b;
    /* access modifiers changed from: private */
    public RestaurantListListener restaurantListListener;

    public RestaurantListInteractor(AppVersionProvider appVersionProvider2, RestaurantListListener restaurantListListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.restaurantListListener = restaurantListListener2;
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(Restaurant restaurant) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetBranchIdFromGrlRequestError$0(InforMapRequest inforMapRequest, VolleyError volleyError) {
        InforMapTracker.trackInformapStoreApiError("Restaurant List Screen", inforMapRequest, volleyError);
        onRequestError().onErrorResponse(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$1(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            RestaurantListListener restaurantListListener2 = this.restaurantListListener;
            if (restaurantListListener2 != null) {
                restaurantListListener2.onRequestError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            RestaurantListListener restaurantListListener3 = this.restaurantListListener;
            if (restaurantListListener3 != null) {
                restaurantListListener3.onEmptyMenuReceived(str);
            }
        } else {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = splitMenuRM.result.menu;
            menuItemsResponseModel.menu = menuItemRM;
            MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
            RestaurantListListener restaurantListListener4 = this.restaurantListListener;
            if (restaurantListListener4 != null) {
                restaurantListListener4.onOnlyMenuLoadingCompleted(splitMenuRM.result.menu);
            }
        }
    }

    private Response.Listener<MenuItemResponse> onInfoRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                MenuItemsResponseModel menuItemsResponseModel;
                Restaurant restaurant;
                if (menuItemResponse == null || (menuItemsResponseModel = menuItemResponse.result) == null || (restaurant = menuItemsResponseModel.restaurant) == null) {
                    if (menuItemResponse == null) {
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in RestaurantListInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in RestaurantListInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in RestaurantListInteractor", new HashMap());
                        }
                    }
                    if (RestaurantListInteractor.this.restaurantListListener != null) {
                        RestaurantListInteractor.this.restaurantListListener.onRequestError();
                        return;
                    }
                    return;
                }
                MenuItemsResponseModel menuItemsResponseModel3 = GlobalDataModel.JSON.menuItemsResponseModel;
                menuItemsResponseModel3.warnings = menuItemsResponseModel.warnings;
                menuItemsResponseModel3.deliveryAreas = menuItemsResponseModel.deliveryAreas;
                menuItemsResponseModel3.promotions = menuItemsResponseModel.promotions;
                menuItemsResponseModel3.restaurant = restaurant;
                menuItemsResponseModel3.upsellingItems = menuItemsResponseModel.upsellingItems;
                menuItemsResponseModel3.heroImage = menuItemsResponseModel.heroImage;
                GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel.tgoFreeDeliveryResponse;
                Restaurant restaurant2 = GlobalDataModel.SELECTED.getRestaurant();
                if (restaurant2 != null) {
                    int i11 = restaurant2.f13872id;
                    Restaurant restaurant3 = menuItemResponse.result.restaurant;
                    if (i11 == restaurant3.f13872id) {
                        restaurant3.setRecommendation(restaurant2.isRecommendation());
                        Restaurant restaurant4 = menuItemResponse.result.restaurant;
                        restaurant4.itemPosition = restaurant2.itemPosition;
                        restaurant4.swimlanePosition = restaurant2.swimlanePosition;
                        restaurant4.itemDisplayed = restaurant2.itemDisplayed;
                        restaurant4.isSponsered = restaurant2.isSponsered;
                        restaurant4.premiumType = restaurant2.premiumType;
                    }
                }
                GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
                MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemResponse.result);
                menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                if (RestaurantListInteractor.this.restaurantListListener != null) {
                    RestaurantListInteractor.this.restaurantListListener.onOnlyInfoLoadingCompleted();
                }
            }
        };
    }

    private Response.Listener<InforMapAddressRM> onInforBranchReceived() {
        return new Response.Listener<InforMapAddressRM>() {
            public void onResponse(InforMapAddressRM inforMapAddressRM) {
                if (inforMapAddressRM != null) {
                    RestaurantListInteractor.this.restaurantListListener.grlBranchIdReceived(inforMapAddressRM.result);
                } else {
                    RestaurantListInteractor.this.restaurantListListener.grlBranchIdFailed();
                }
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdBlockBranchReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (mcdStoresRM == null) {
                    RestaurantListInteractor.this.restaurantListListener.mcdBranchFailed();
                } else if (mcdStoresRM.result != null) {
                    RestaurantListInteractor.this.restaurantListListener.mcdBranchReceived(mcdStoresRM.result);
                } else {
                    RestaurantListInteractor.this.restaurantListListener.mcdBranchFailed();
                }
            }
        };
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(String str) {
        return new b(this, str);
    }

    private Response.Listener<RestuarntListResponse> onRefreshRestaurantsRecieved() {
        return new Response.Listener<RestuarntListResponse>() {
            public void onResponse(RestuarntListResponse restuarntListResponse) {
                GlobalDataModel.updateRestaurantsData(restuarntListResponse.result);
                if (RestaurantListInteractor.this.restaurantListListener != null) {
                    RestaurantListInteractor.this.restaurantListListener.onRefreshRestaurantListLoaded();
                }
            }
        };
    }

    private Response.Listener<MenuItemResponse> onResultRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                MenuItemsResponseModel menuItemsResponseModel = menuItemResponse.result;
                GlobalDataModel.JSON.menuItemsResponseModel = menuItemsResponseModel;
                GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                if (RestaurantListInteractor.this.restaurantListListener != null) {
                    RestaurantListInteractor.this.restaurantListListener.onMenuLoadingCompleted(menuItemResponse.result);
                }
            }
        };
    }

    public void getBranchIdFromBlockorLatLang(McdBranchRequest mcdBranchRequest) {
        String str;
        String str2;
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            str = AppUrls.MCD_BAHRAIN_GET_BRANCH_ID;
        } else {
            if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
                    str = AppUrls.MCD_KSA_GET_BRANCH_ID;
                } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                    str = AppUrls.MCD_JORDAN_GET_BRANCH_ID;
                }
            }
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
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdBlockBranchReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getBranchIdFromGrl(InforMapRequest inforMapRequest) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(inforMapRequest.getJson());
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.INFORMAP_ADDRESS_CONVERT_BRANCH_ID).setClazz(InforMapAddressRM.class).setRequestBody(jSONObject).setListener(onInforBranchReceived()).setErrorListener(onGetBranchIdFromGrlRequestError(inforMapRequest)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGroceryMenu(Restaurant restaurant) {
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        this.f26817b = Observable.zip(getGroceryInfoRetrofit(restaurant), getGroceryMenuRetrofit(restaurant), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
            public GroceryInfoAndMenuResponseZipped apply(MenuItemResponse menuItemResponse, SplitMenuRM splitMenuRM) throws Exception {
                return new GroceryInfoAndMenuResponseZipped(menuItemResponse, splitMenuRM);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GroceryInfoAndMenuResponseZipped>() {
            public void accept(GroceryInfoAndMenuResponseZipped groceryInfoAndMenuResponseZipped) throws Exception {
                Restaurant restaurant;
                MenuItemsResponseModel menuItemsResponseModel = groceryInfoAndMenuResponseZipped.getMenuItemResponse().result;
                MenuItemsResponseModel menuItemsResponseModel2 = GlobalDataModel.JSON.menuItemsResponseModel;
                menuItemsResponseModel2.warnings = menuItemsResponseModel.warnings;
                menuItemsResponseModel2.deliveryAreas = menuItemsResponseModel.deliveryAreas;
                menuItemsResponseModel2.promotions = menuItemsResponseModel.promotions;
                menuItemsResponseModel2.restaurant = menuItemsResponseModel.restaurant;
                menuItemsResponseModel2.upsellingItems = menuItemsResponseModel.upsellingItems;
                menuItemsResponseModel2.heroImage = menuItemsResponseModel.heroImage;
                GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel.tgoFreeDeliveryResponse;
                Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                if (restaurant2 != null && (restaurant = menuItemsResponseModel.restaurant) != null && restaurant.f13872id == restaurant2.f13872id) {
                    restaurant.setRecommendation(restaurant2.isRecommendation());
                    Restaurant restaurant3 = menuItemsResponseModel.restaurant;
                    Restaurant restaurant4 = GlobalDataModel.SELECTED.restaurant;
                    restaurant3.itemPosition = restaurant4.itemPosition;
                    restaurant3.swimlanePosition = restaurant4.swimlanePosition;
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in RestaurantListInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in RestaurantListInteractor", new HashMap());
                }
                GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                if (RestaurantListInteractor.this.restaurantListListener != null) {
                    ChoiceLoader.startChoiceLoader(RestaurantListInteractor.this.appVersionProvider);
                    RestaurantListInteractor.this.restaurantListListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    RestaurantListInteractor.this.restaurantListListener.onServerError();
                } else {
                    RestaurantListInteractor.this.restaurantListListener.onNetworkError();
                }
            }
        });
    }

    public Observable<SplitMenuRM> getGroceryMenuRetrofit(Restaurant restaurant) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_GROCERY_MENU;
        return callApi.getGroceryMenu(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + restaurant.getBranchId()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void getRestaurantInfoOnly(Restaurant restaurant) {
        String str;
        JSONObject jSONObject;
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
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.SPLIT_RESTAURANT_MENU;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + restaurant.getBranchId()})).setClazz(SplitMenuRM.class).setListener(onMenuReceived(restaurant.getName())).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onGetBranchIdFromGrlRequestError(InforMapRequest inforMapRequest) {
        return new a(this, inforMapRequest);
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && RestaurantListInteractor.this.restaurantListListener != null) {
                    RestaurantListInteractor.this.restaurantListListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && RestaurantListInteractor.this.restaurantListListener != null) {
                    RestaurantListInteractor.this.restaurantListListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && RestaurantListInteractor.this.restaurantListListener != null) {
                    RestaurantListInteractor.this.restaurantListListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        Disposable disposable = this.f26817b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26817b.dispose();
        }
        this.restaurantListListener = null;
    }
}
