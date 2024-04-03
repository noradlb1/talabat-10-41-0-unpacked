package library.talabat.mvp.branding;

import JsonModels.GoogleAreaResponse;
import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.GoogleAreaRM;
import JsonModels.Response.InforMapAddressRM;
import JsonModels.Response.McdStoresRM;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuItemsResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.RestGeoAddressRM;
import JsonModels.RestaurantFranchiseRespone;
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
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.tracking.InforMapTracker;
import datamodels.City;
import datamodels.GroceryInfoAndMenuResponseZipped;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.json.JSONException;
import org.json.JSONObject;
import service.ApiHandler;
import tracking.ScreenNames;
import z00.a;
import z00.b;

@Instrumented
public class BrandingInteractor implements IBrandingInteractor {
    /* access modifiers changed from: private */
    public final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26561b;
    /* access modifiers changed from: private */
    public BrandingListener brandingListener;
    /* access modifiers changed from: private */
    public boolean onlyInfoLoaded;
    /* access modifiers changed from: private */
    public boolean onlyMenuLoaded;

    public BrandingInteractor(AppVersionProvider appVersionProvider2, BrandingListener brandingListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.brandingListener = brandingListener2;
    }

    private Observable<MenuItemResponse> getGroceryInfoRetrofit(String str) {
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), GlobalDataModel.SelectedCountryId + "");
        return ApiHandler.callApi().getGroceryInfoWithLocation(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", "" + str}), restaurantInfoRequestModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetGrlBranchIdRequestError$1(InforMapRequest inforMapRequest, VolleyError volleyError) {
        InforMapTracker.trackInformapStoreApiError(ScreenNames.BRAND_SCREEN, inforMapRequest, volleyError);
        onRequestError().onErrorResponse(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMenuReceived$0(String str, SplitMenuRM splitMenuRM) {
        SplitMenuItemsResponse splitMenuItemsResponse;
        if (splitMenuRM == null || (splitMenuItemsResponse = splitMenuRM.result) == null) {
            BrandingListener brandingListener2 = this.brandingListener;
            if (brandingListener2 != null) {
                brandingListener2.onServerError();
            }
        } else if (splitMenuItemsResponse.menu.isEmpty()) {
            BrandingListener brandingListener3 = this.brandingListener;
            if (brandingListener3 != null) {
                brandingListener3.onEmptyMenuReceived(str);
            }
        } else if (GlobalDataModel.SELECTED.restaurant != null) {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = splitMenuRM.result.menu;
            menuItemsResponseModel.menu = menuItemRM;
            MenuResponseMapper.INSTANCE.updateMenu(menuItemRM);
            this.onlyMenuLoaded = true;
            onMenuorInfoReceived();
        }
    }

    private Response.Listener<GoogleAreaRM> onGoogleAreaReceived() {
        return new Response.Listener<GoogleAreaRM>() {
            public void onResponse(GoogleAreaRM googleAreaRM) {
                if (BrandingInteractor.this.brandingListener != null) {
                    BrandingListener d11 = BrandingInteractor.this.brandingListener;
                    GoogleAreaResponse googleAreaResponse = googleAreaRM.result;
                    d11.gpsToAddressResult(googleAreaResponse.msg, googleAreaResponse.address, googleAreaResponse.area, (City) null);
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
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in BrandingInteractor", new HashMap());
                    } else {
                        MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                        if (menuItemsResponseModel2 == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in BrandingInteractor", new HashMap());
                        } else if (menuItemsResponseModel2.restaurant == null) {
                            ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in BrandingInteractor", new HashMap());
                        }
                    }
                    if (BrandingInteractor.this.brandingListener != null) {
                        BrandingInteractor.this.brandingListener.onRequestError();
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
                GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
                menuResponseMapper.updateMenuItemsResponseModelSpecifics(menuItemResponse.result);
                menuResponseMapper.updateRestaurant(menuItemResponse.result.restaurant);
                BrandingInteractor.this.onlyInfoLoaded = true;
                BrandingInteractor.this.onMenuorInfoReceived();
            }
        };
    }

    private Response.Listener<InforMapAddressRM> onInforBrachIdReceived() {
        return new Response.Listener<InforMapAddressRM>() {
            public void onResponse(InforMapAddressRM inforMapAddressRM) {
                if (inforMapAddressRM != null) {
                    if (BrandingInteractor.this.brandingListener != null) {
                        BrandingInteractor.this.brandingListener.grlBranchIdReceived(inforMapAddressRM.result);
                    }
                } else if (BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.grlBranchIdfailed();
                }
            }
        };
    }

    private Response.Listener<McdStoresRM> onMcdBlockBranchReceived() {
        return new Response.Listener<McdStoresRM>() {
            public void onResponse(McdStoresRM mcdStoresRM) {
                if (mcdStoresRM != null) {
                    if (mcdStoresRM.result != null) {
                        if (BrandingInteractor.this.brandingListener != null) {
                            BrandingInteractor.this.brandingListener.mcdBranchReceived(mcdStoresRM.result);
                        }
                    } else if (BrandingInteractor.this.brandingListener != null) {
                        BrandingInteractor.this.brandingListener.mcdBranchFailed();
                    }
                } else if (BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.mcdBranchFailed();
                }
            }
        };
    }

    private Response.Listener<SplitMenuRM> onMenuReceived(String str) {
        return new b(this, str);
    }

    /* access modifiers changed from: private */
    public void onMenuorInfoReceived() {
        if (this.onlyMenuLoaded && this.onlyInfoLoaded && this.brandingListener != null) {
            ChoiceLoader.startChoiceLoader(this.appVersionProvider);
            this.brandingListener.onMenuLoadingCompleted();
        }
    }

    private Response.Listener<RestaurantFranchiseRespone> onRestuarantFranchiseRecieved() {
        return new Response.Listener<RestaurantFranchiseRespone>() {
            public void onResponse(RestaurantFranchiseRespone restaurantFranchiseRespone) {
                if (BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.onFrachaseLoadingCompleted(restaurantFranchiseRespone.result);
                }
            }
        };
    }

    private Response.Listener<MenuItemResponse> onResultRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                if (GlobalDataModel.SELECTED.restaurant != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
                    GlobalDataModel.JSON.menuItemsResponseModel = menuItemResponse.result;
                    if (BrandingInteractor.this.brandingListener != null) {
                        BrandingInteractor.this.brandingListener.onMenuLoadingCompleted();
                    }
                }
            }
        };
    }

    public void checkIfMigratedVendor(final int i11) {
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel("" + GlobalDataModel.SelectedAreaId, latitude + "", GlobalDataModel.LATLONGFORAPI.getLongitude() + "", GlobalDataModel.SelectedCountryId + "");
        ApiHandler.callApi().getRestaurantInfoWithLocation(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION.replace("{branchId}", i11 + ""), restaurantInfoRequestModel).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<MenuItemResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                if (BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.onResponseError();
                }
            }

            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(MenuItemResponse menuItemResponse) {
                if (menuItemResponse != null) {
                    BrandingInteractor.this.j(menuItemResponse, i11);
                }
            }
        });
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

    public void getGrlBranchId(InforMapRequest inforMapRequest) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(inforMapRequest.getJson());
        } catch (JSONException e11) {
            LogManager.logException(e11);
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.INFORMAP_ADDRESS_CONVERT_BRANCH_ID).setClazz(InforMapAddressRM.class).setRequestBody(jSONObject).setListener(onInforBrachIdReceived()).setErrorListener(onGetGrlBranchIdRequestError(inforMapRequest)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getGroceryMenu(String str) {
        this.onlyMenuLoaded = false;
        this.onlyInfoLoaded = false;
        GlobalDataModel.MENU.priceOnSelectionItemAvailable = false;
        GlobalDataModel.MENU.MenuCalledOnce = false;
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        this.f26561b = Observable.zip(getGroceryInfoRetrofit(str), getGroceryMenuRetrofit(str), new BiFunction<MenuItemResponse, SplitMenuRM, GroceryInfoAndMenuResponseZipped>() {
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
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel null in BrandingInteractor", new HashMap());
                } else if (menuItemsResponseModel.restaurant == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info api MenuItemsResponseModel.rest null in BrandingInteractor", new HashMap());
                } else if (restaurant2 == null) {
                    ObservabilityManager.trackUnExpectedScenario("grocery info global Restaurant null in BrandingInteractor", new HashMap());
                }
                if (menuItemsResponseModel != null) {
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemsResponseModel.restaurant);
                }
                BrandingInteractor.this.onlyInfoLoaded = true;
                GlobalDataModel.JSON.menuItemsResponseModel.menu = groceryInfoAndMenuResponseZipped.getSplitMenuRM().result.menu;
                BrandingInteractor.this.onlyMenuLoaded = true;
                if (BrandingInteractor.this.brandingListener != null) {
                    ChoiceLoader.startChoiceLoader(BrandingInteractor.this.appVersionProvider);
                    BrandingInteractor.this.brandingListener.onGroceryMenuLoadingCompleted(GlobalDataModel.JSON.menuItemsResponseModel);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                if (th2.getLocalizedMessage().toLowerCase().contains(ProxyConfig.MATCH_HTTP)) {
                    BrandingInteractor.this.brandingListener.onServerError();
                } else {
                    BrandingInteractor.this.brandingListener.onNetworkError();
                }
            }
        });
    }

    public Observable<SplitMenuRM> getGroceryMenuRetrofit(String str) {
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str2 = AppUrls.SPLIT_GROCERY_MENU;
        return callApi.getGroceryMenu(CreateApiUrl.createWithParameters(str2, new String[]{"{branchId}", "" + str})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void getRestaurantFranchase(int i11, int i12) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.RESTAURANT_FRANCHASE;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restaurantgroupid}", "" + i11, "{areaid}", "" + i12})).setClazz(RestaurantFranchiseRespone.class).setListener(onRestuarantFranchiseRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantInfoOnly(String str) {
        String str2;
        JSONObject jSONObject;
        this.onlyInfoLoaded = false;
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
        this.onlyInfoLoaded = false;
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION, new String[]{"{branchId}", str})).setClazz(MenuItemResponse.class).setRequestBody(jSONObject).setListener(onInfoRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void getRestaurantMenuOnly(String str, String str2) {
        this.onlyMenuLoaded = false;
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setUrl(CreateApiUrl.createWithParameters(AppUrls.SPLIT_RESTAURANT_MENU, new String[]{"{branchId}", str})).setClazz(SplitMenuRM.class).setListener(onMenuReceived(str2)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void gpsToAddress(double d11, double d12) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETAREAFROMCODINATES;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{latitude}", "" + d11, "{longitude}", "" + d12, "{countryid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(GoogleAreaRM.class).setListener(onGoogleAreaReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public boolean h(MenuItemResponse menuItemResponse) {
        MenuItemsResponseModel menuItemsResponseModel = menuItemResponse.result;
        return (menuItemsResponseModel == null || menuItemsResponseModel.restaurant == null) ? false : true;
    }

    public void i(Restaurant restaurant, int i11) {
        BrandingListener brandingListener2 = this.brandingListener;
        if (brandingListener2 == null) {
            return;
        }
        if (restaurant.isMigrated) {
            brandingListener2.onMigratedInfoSuccess(restaurant);
        } else {
            brandingListener2.onNotMigratedVendor(i11);
        }
    }

    public void j(MenuItemResponse menuItemResponse, int i11) {
        if (h(menuItemResponse)) {
            i(menuItemResponse.result.restaurant, i11);
            return;
        }
        BrandingListener brandingListener2 = this.brandingListener;
        if (brandingListener2 != null) {
            brandingListener2.onNotMigratedVendor(i11);
        }
    }

    public Response.ErrorListener onGetGrlBranchIdRequestError(InforMapRequest inforMapRequest) {
        return new a(this, inforMapRequest);
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (BrandingInteractor.this.brandingListener != null) {
                        BrandingInteractor.this.brandingListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (BrandingInteractor.this.brandingListener != null) {
                        BrandingInteractor.this.brandingListener.onNetworkError();
                    }
                } else if (!(volleyError instanceof AuthFailureError)) {
                    LogManager.logException(volleyError);
                } else if (BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.onDataError();
                }
            }
        };
    }

    public void reverseGeoCodingBasedRestaurant(RestGeoReverseCodingRequest restGeoReverseCodingRequest) {
        ApiHandler.callApi().getResBasedGeoReverseCoding(AppUrls.GET_GEO_ADDRESS_BASED_RES_BRANCH, restGeoReverseCodingRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<RestGeoAddressRM>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
                if (BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.onResponseError();
                }
            }

            public void onNext(RestGeoAddressRM restGeoAddressRM) {
                if (restGeoAddressRM != null && BrandingInteractor.this.brandingListener != null) {
                    BrandingInteractor.this.brandingListener.resBasereverseGeocodingResult(restGeoAddressRM.result);
                }
            }
        });
    }

    public void unregister() {
        this.brandingListener = null;
        Disposable disposable = this.f26561b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26561b.dispose();
        }
    }
}
