package library.talabat.mvp.restaurantlistrefactor;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.InforMapAddressRM;
import JsonModels.Response.McdStoresRM;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.parser.UniversalGson;
import a20.a;
import a20.b;
import a20.c;
import a20.d;
import a20.e;
import a20.f;
import a20.g;
import a20.h;
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
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.tracking.InforMapTracker;
import datamodels.GroceryInfoAndMenuResponseZipped;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;

@Instrumented
public class MenuApiInteractor implements IMenuApiInteractor {
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26827b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26828c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26829d;

    public MenuApiInteractor(AppVersionProvider appVersionProvider2) {
        this.appVersionProvider = appVersionProvider2;
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(int i11) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + i11}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getGroceryMenu$0(MenuApiListener menuApiListener, GroceryInfoAndMenuResponseZipped groceryInfoAndMenuResponseZipped) throws Exception {
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
            restaurant3.isSponsered = restaurant4.isSponsered;
            restaurant3.premiumType = restaurant4.premiumType;
        } else if (menuItemsResponseModel.restaurant == null) {
            ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in MenuApiInteractor", new HashMap());
        } else if (restaurant2 == null) {
            ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in MenuApiInteractor", new HashMap());
        }
        GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
        this.f26829d = true;
        GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
        this.f26828c = true;
        if (menuApiListener != null) {
            menuApiListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetBranchIdFromGrlRequestError$2(InforMapRequest inforMapRequest, MenuApiListener menuApiListener, String str, VolleyError volleyError) {
        InforMapTracker.trackInformapStoreApiError("MenuApiInteractor", inforMapRequest, volleyError);
        onRequestError(menuApiListener, str).onErrorResponse(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onInfoRecieved$6(MenuApiListener menuApiListener, MenuItemResponse menuItemResponse) {
        MenuItemsResponseModel menuItemsResponseModel;
        Restaurant restaurant;
        if (menuItemResponse == null || (menuItemsResponseModel = menuItemResponse.result) == null || (restaurant = menuItemsResponseModel.restaurant) == null) {
            if (menuItemResponse == null) {
                ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in MenuApiInteractor", new HashMap());
            } else {
                MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                if (menuItemsResponseModel2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in MenuApiInteractor", new HashMap());
                } else if (menuItemsResponseModel2.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in MenuApiInteractor", new HashMap());
                }
            }
            if (menuApiListener != null) {
                menuApiListener.onRequestError();
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
                restaurant4.isSponsered = restaurant5.isSponsered;
                restaurant4.premiumType = restaurant5.premiumType;
            }
        }
        GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
        MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
        menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemResponse.result);
        menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
        if (!this.f26828c) {
            this.f26829d = true;
        } else if (menuApiListener != null) {
            menuApiListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onInforBranchReceived$3(MenuApiListener menuApiListener, InforMapAddressRM inforMapAddressRM) {
        if (inforMapAddressRM != null) {
            menuApiListener.grlBranchIdReceived(inforMapAddressRM.result);
        } else {
            menuApiListener.grlBranchIdFailed();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMcdBlockBranchReceived$4(MenuApiListener menuApiListener, McdStoresRM mcdStoresRM) {
        if (mcdStoresRM != null) {
            McdStoresResponse mcdStoresResponse = mcdStoresRM.result;
            if (mcdStoresResponse != null) {
                menuApiListener.mcdBranchReceived(mcdStoresResponse);
            } else {
                menuApiListener.mcdBranchFailed();
            }
        } else {
            menuApiListener.mcdBranchFailed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$5(MenuApiListener menuApiListener, String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            if (menuApiListener != null) {
                menuApiListener.onRequestError();
            }
        } else if (!splitMenuItemsResponse.menu.isEmpty()) {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = splitMenuRM.result.menu;
            menuItemsResponseModel.menu = menuItemRM;
            MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
            if (!this.f26829d) {
                this.f26828c = true;
            } else if (menuApiListener != null) {
                menuApiListener.onMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
            }
        } else if (menuApiListener != null) {
            menuApiListener.onEmptyMenuReceived(str);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRequestError$1(MenuApiListener menuApiListener, String str, VolleyError volleyError) {
        if ((volleyError instanceof ServerError) && menuApiListener != null) {
            menuApiListener.onServerError(volleyError);
        } else if ((volleyError instanceof NetworkError) && menuApiListener != null) {
            menuApiListener.logNetworkError("onRequestError " + str + " " + volleyError.getMessage());
            menuApiListener.onNetworkError();
        } else if ((volleyError instanceof AuthFailureError) && menuApiListener != null) {
            menuApiListener.onDataError();
        }
    }

    private Response.Listener<MenuItemResponse> onInfoRecieved(MenuApiListener menuApiListener) {
        return new g(this, menuApiListener);
    }

    private Response.Listener<InforMapAddressRM> onInforBranchReceived(MenuApiListener menuApiListener) {
        return new d(menuApiListener);
    }

    private Response.Listener<McdStoresRM> onMcdBlockBranchReceived(MenuApiListener menuApiListener) {
        return new f(menuApiListener);
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(MenuApiListener menuApiListener, String str) {
        return new e(this, menuApiListener, str);
    }

    public void getBranchIdFromBlockorLatLang(MenuApiListener menuApiListener, McdBranchRequest mcdBranchRequest) {
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
            TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryId}", "" + GlobalDataModel.SelectedCountryId})).setClazz(McdStoresRM.class).setRequestBody(jSONObject).setListener(onMcdBlockBranchReceived(menuApiListener)).setErrorListener(onRequestError(menuApiListener, "getBranchIdFromBlockorLatLang")).setAppVersion(this.appVersionProvider.appVersion()).build());
        } catch (JSONException unused) {
        }
    }

    public void getBranchIdFromGrl(MenuApiListener menuApiListener, InforMapRequest inforMapRequest) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(inforMapRequest.getJson());
        } catch (JSONException e11) {
            LogManager.logException(e11);
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.INFORMAP_ADDRESS_CONVERT_BRANCH_ID).setClazz(InforMapAddressRM.class).setRequestBody(jSONObject).setListener(onInforBranchReceived(menuApiListener)).setErrorListener(onGetBranchIdFromGrlRequestError(menuApiListener, "getBranchIdFromGrl", inforMapRequest)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGroceryMenu(final MenuApiListener menuApiListener, int i11) {
        this.f26828c = false;
        this.f26829d = false;
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        this.f26827b = Observable.zip(getGroceryInfoRetrofit(i11), getGroceryMenuRetrofit(i11), new b()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, menuApiListener), new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    menuApiListener.onServerError();
                    return;
                }
                MenuApiListener menuApiListener = menuApiListener;
                menuApiListener.logNetworkError("getGroceryMenu with dark store " + th2.getMessage());
                menuApiListener.onNetworkError();
            }
        });
    }

    public Observable<SplitMenuRM> getGroceryMenuRetrofit(int i11) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str = AppUrls.SPLIT_GROCERY_MENU;
        return callApi.getGroceryMenu(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + i11})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void getRestaurantInfoOnly(MenuApiListener menuApiListener, Restaurant restaurant) {
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
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + restaurant.getBranchId()})).setClazz(MenuItemResponse.class).setRequestBody(jSONObject).setListener(onInfoRecieved(menuApiListener)).setErrorListener(onRequestError(menuApiListener, "getRestaurantInfoOnly")).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantMenu(MenuApiListener menuApiListener, Restaurant restaurant) {
        this.f26828c = false;
        this.f26829d = false;
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        MenuResponseMapper.INSTANCE.clear();
        getRestaurantMenuOnly(menuApiListener, restaurant);
        getRestaurantInfoOnly(menuApiListener, restaurant);
    }

    public void getRestaurantMenuOnly(MenuApiListener menuApiListener, Restaurant restaurant) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.SPLIT_RESTAURANT_MENU;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", "" + restaurant.getBranchId()})).setClazz(SplitMenuRM.class).setListener(onMenuReceived(menuApiListener, restaurant.getName())).setErrorListener(onRequestError(menuApiListener, "getRestaurantMenuOnly")).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onGetBranchIdFromGrlRequestError(MenuApiListener menuApiListener, String str, InforMapRequest inforMapRequest) {
        return new h(this, inforMapRequest, menuApiListener, str);
    }

    public Response.ErrorListener onRequestError(MenuApiListener menuApiListener, String str) {
        return new a(menuApiListener, str);
    }

    public void unregister() {
        Disposable disposable = this.f26827b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26827b.dispose();
        }
    }

    public void getGroceryMenu(MenuApiListener menuApiListener, Restaurant restaurant) {
        getGroceryMenu(menuApiListener, restaurant.branchId);
    }
}
