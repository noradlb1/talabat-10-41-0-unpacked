package library.talabat.mvp.listingmenubridge;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
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
import com.android.volley.NetworkResponse;
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
import com.talabat.observability.squads.nfv.ObservableErrorMessages;
import com.talabat.userandlocation.tracking.InforMapTracker;
import datamodels.GroceryInfoAndMenuResponseZipped;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import library.talabat.com.talabatlib.CreateApiUrl;
import n10.a;
import n10.b;
import n10.c;
import n10.d;
import n10.e;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;
import tracking.observability.VendorInfoAPIObservability;

@Instrumented
public class ListingMenuBridgeInteractor implements IListingMenuBridgeInteractor {
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26742b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26743c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26744d;
    /* access modifiers changed from: private */
    public ListingMenuBridgeListener listingMenuBridgeListener;
    private VendorInfoAPIObservability vendorInfoAPIObservability;

    public ListingMenuBridgeInteractor(AppVersionProvider appVersionProvider2, VendorInfoAPIObservability vendorInfoAPIObservability2, ListingMenuBridgePresenter listingMenuBridgePresenter) {
        this.appVersionProvider = appVersionProvider2;
        this.listingMenuBridgeListener = listingMenuBridgePresenter;
        this.vendorInfoAPIObservability = vendorInfoAPIObservability2;
    }

    /* access modifiers changed from: private */
    public void dispatchError(VolleyError volleyError) {
        ListingMenuBridgeListener listingMenuBridgeListener2 = this.listingMenuBridgeListener;
        if (listingMenuBridgeListener2 != null) {
            if (volleyError instanceof ServerError) {
                listingMenuBridgeListener2.onServerError(volleyError);
            } else if (volleyError instanceof NetworkError) {
                listingMenuBridgeListener2.onNetworkError();
            } else if (volleyError instanceof AuthFailureError) {
                listingMenuBridgeListener2.onDataError();
            }
        }
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(int i11) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + i11}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetBranchIdFromGrlRequestError$1(InforMapRequest inforMapRequest, VolleyError volleyError) {
        InforMapTracker.trackInformapStoreApiError("ListingMenuBridgeActivity", inforMapRequest, volleyError);
        onRequestError().onErrorResponse(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$0(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            ListingMenuBridgeListener listingMenuBridgeListener2 = this.listingMenuBridgeListener;
            if (listingMenuBridgeListener2 != null) {
                listingMenuBridgeListener2.onRequestError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            ListingMenuBridgeListener listingMenuBridgeListener3 = this.listingMenuBridgeListener;
            if (listingMenuBridgeListener3 != null) {
                listingMenuBridgeListener3.onEmptyMenuReceived(str);
            }
        } else {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = splitMenuRM.result.menu;
            menuItemsResponseModel.menu = menuItemRM;
            MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
            if (this.f26744d) {
                ListingMenuBridgeListener listingMenuBridgeListener4 = this.listingMenuBridgeListener;
                if (listingMenuBridgeListener4 != null) {
                    listingMenuBridgeListener4.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                    return;
                }
                return;
            }
            this.f26743c = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMigratedErrorResponse$3(VolleyError volleyError) {
        String str;
        int i11 = -1;
        if (volleyError != null) {
            str = volleyError.getMessage();
            NetworkResponse networkResponse = volleyError.networkResponse;
            if (networkResponse != null) {
                i11 = networkResponse.statusCode;
            }
        } else {
            str = "N/A";
        }
        this.vendorInfoAPIObservability.onVendorListTalabatBranchCodeAPIFailed(false, Integer.valueOf(i11), str, Integer.valueOf(GlobalDataModel.SelectedCountryId));
        dispatchError(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMigratedInfoReceived$2(DarkstoresTrackingData darkstoresTrackingData, MenuItemResponse menuItemResponse) {
        Restaurant restaurant = menuItemResponse.result.restaurant;
        if (restaurant != null) {
            this.listingMenuBridgeListener.onMigratedVendorInfoReceived(restaurant, darkstoresTrackingData);
            return;
        }
        this.vendorInfoAPIObservability.onVendorListTalabatBranchCodeAPIFailed(false, (Integer) null, ObservableErrorMessages.EMPTY_API_RESPONSE, Integer.valueOf(GlobalDataModel.SelectedCountryId));
        this.listingMenuBridgeListener.onRequestError();
    }

    private Response.Listener<MenuItemResponse> onInfoRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                MenuItemsResponseModel menuItemsResponseModel;
                Restaurant restaurant;
                if (menuItemResponse == null || (menuItemsResponseModel = menuItemResponse.result) == null || (restaurant = menuItemsResponseModel.restaurant) == null) {
                    if (menuItemResponse == null) {
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in ListingMenuBridgeInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in ListingMenuBridgeInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in ListingMenuBridgeInteractor", new HashMap());
                        }
                    }
                    if (ListingMenuBridgeInteractor.this.listingMenuBridgeListener != null) {
                        ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onRequestError();
                        return;
                    }
                    return;
                }
                MenuItemsResponseModel menuItemsResponseModel3 = GlobalDataModel.JSON.menuItemsResponseModel;
                menuItemsResponseModel3.warnings = menuItemsResponseModel.warnings;
                menuItemsResponseModel3.deliveryAreas = menuItemsResponseModel.deliveryAreas;
                menuItemsResponseModel3.promotions = menuItemsResponseModel.promotions;
                menuItemsResponseModel3.upsellingItems = menuItemsResponseModel.upsellingItems;
                menuItemsResponseModel3.heroImage = menuItemsResponseModel.heroImage;
                GlobalDataModel.JSON.tgoFreeDeliveryResponse = menuItemsResponseModel.tgoFreeDeliveryResponse;
                GlobalDataModel.JSON.menuItemsResponseModel.restaurant = restaurant;
                Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                if (restaurant2 != null) {
                    int i11 = restaurant2.f13872id;
                    Restaurant restaurant3 = menuItemsResponseModel.restaurant;
                    if (i11 == restaurant3.f13872id) {
                        restaurant3.setRecommendation(restaurant2.isRecommendation());
                        Restaurant restaurant4 = menuItemResponse.result.restaurant;
                        Restaurant restaurant5 = GlobalDataModel.SELECTED.restaurant;
                        restaurant4.itemPosition = restaurant5.itemPosition;
                        restaurant4.swimlanePosition = restaurant5.swimlanePosition;
                        restaurant4.itemDisplayed = restaurant5.itemDisplayed;
                    }
                }
                GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
                MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemResponse.result);
                menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                ListingMenuBridgeInteractor listingMenuBridgeInteractor = ListingMenuBridgeInteractor.this;
                if (!listingMenuBridgeInteractor.f26743c) {
                    listingMenuBridgeInteractor.f26744d = true;
                } else if (listingMenuBridgeInteractor.listingMenuBridgeListener != null) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        };
    }

    private Response.Listener<InforMapAddressRM> onInforBranchReceived() {
        return new Response.Listener<InforMapAddressRM>() {
            public void onResponse(InforMapAddressRM inforMapAddressRM) {
                if (inforMapAddressRM != null) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.grlBranchIdReceived(inforMapAddressRM.result);
                } else {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.grlBranchIdFailed();
                }
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdBlockBranchReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (mcdStoresRM == null) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.mcdBranchFailed();
                } else if (mcdStoresRM.result != null) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.mcdBranchReceived(mcdStoresRM.result);
                } else {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.mcdBranchFailed();
                }
            }
        };
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(String str) {
        return new c(this, str);
    }

    private Response.ErrorListener onMigratedErrorResponse() {
        return new a(this);
    }

    private Response.Listener<MenuItemResponse> onMigratedInfoReceived(DarkstoresTrackingData darkstoresTrackingData) {
        return new b(this, darkstoresTrackingData);
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

    public void getDarkstoreInfo() {
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
                ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onDarkstoreError();
            }

            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(DarkStoresEntryPointResponse darkStoresEntryPointResponse) {
                if (darkStoresEntryPointResponse == null || darkStoresEntryPointResponse.getResult() == null) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onDarkstoreError();
                } else {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onDarkStoresEntrySuccess(darkStoresEntryPointResponse.getResult(), darkstoresTrackingData);
                }
            }
        });
    }

    public void getGroceryMenu(int i11) {
        this.f26743c = false;
        this.f26744d = false;
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        this.f26742b = Observable.zip(getGroceryInfoRetrofit(i11), getGroceryMenuRetrofit(i11), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
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
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in ListingMenuBridgeInteractor", new HashMap());
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in ListingMenuBridgeInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in ListingMenuBridgeInteractor", new HashMap());
                }
                if (menuItemsResponseModel != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                }
                ListingMenuBridgeInteractor.this.f26744d = true;
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                ListingMenuBridgeInteractor listingMenuBridgeInteractor = ListingMenuBridgeInteractor.this;
                listingMenuBridgeInteractor.f26743c = true;
                if (listingMenuBridgeInteractor.listingMenuBridgeListener != null) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onServerError();
                } else {
                    ListingMenuBridgeInteractor.this.listingMenuBridgeListener.onNetworkError();
                }
            }
        });
    }

    public Observable<SplitMenuRM> getGroceryMenuRetrofit(int i11) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_GROCERY_MENU;
        return callApi.getGroceryMenu(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + i11})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void getMigratedVendorInfo(int i11) {
        String str;
        JSONObject jSONObject;
        DarkstoresTrackingData darkstoresTrackingData = new DarkstoresTrackingData(System.currentTimeMillis());
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
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + i11})).setClazz(MenuItemResponse.class).setRequestBody(jSONObject).setListener(onMigratedInfoReceived(darkstoresTrackingData)).setErrorListener(onMigratedErrorResponse()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantInfoOnly(int i11) {
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
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + i11})).setClazz(MenuItemResponse.class).setRequestBody(jSONObject).setListener(onInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantMenu(int i11, String str) {
        this.f26743c = false;
        this.f26744d = false;
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        MenuResponseMapper.INSTANCE.clear();
        getRestaurantMenuOnly(i11, str);
        getRestaurantInfoOnly(i11);
    }

    public void getRestaurantMenuOnly(int i11, String str) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str2 = AppUrls.SPLIT_RESTAURANT_MENU;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{branchId}", "" + i11})).setClazz(SplitMenuRM.class).setListener(onMenuReceived(str)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onGetBranchIdFromGrlRequestError(InforMapRequest inforMapRequest) {
        return new d(this, inforMapRequest);
    }

    public Response.ErrorListener onRequestError() {
        return new e(this);
    }

    public void unregister() {
        this.listingMenuBridgeListener = null;
    }
}
