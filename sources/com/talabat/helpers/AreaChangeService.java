package com.talabat.helpers;

import JsonModels.Request.RestaurantReq;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.RestaurantRefreshRM;
import JsonModels.RestaurantListJM;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import buisnessmodels.Cart;
import buisnessmodels.FilterEngine;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.di.ApiContainer;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.com.talabatlib.RestuarntListResponse;

public class AreaChangeService extends Service {
    private AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public boolean refreshMenuCompleted = false;
    /* access modifiers changed from: private */
    public boolean refreshRestaurantCompleted = false;
    /* access modifiers changed from: private */
    public boolean refreshRestaurantListCompleted = false;
    /* access modifiers changed from: private */
    public int startId;

    /* access modifiers changed from: private */
    public void dataFetchComplete() {
        if (this.refreshMenuCompleted && this.refreshRestaurantCompleted && this.refreshRestaurantListCompleted) {
            stopSelf(this.startId);
        }
    }

    private Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                AreaChangeService areaChangeService = AreaChangeService.this;
                areaChangeService.stopSelf(areaChangeService.startId);
            }
        };
    }

    private Response.Listener<RestaurantRefreshRM> onRestaurantRecieved() {
        return new Response.Listener<RestaurantRefreshRM>() {
            public void onResponse(RestaurantRefreshRM restaurantRefreshRM) {
                if (restaurantRefreshRM.result != null) {
                    Cart.getInstance().refreshRestaurant(restaurantRefreshRM.result, AreaChangeService.this.getApplicationContext(), GlobalDataModel.SelectedAreaId);
                }
                AreaChangeService.this.refreshRestaurantCompleted = true;
                AreaChangeService.this.dataFetchComplete();
            }
        };
    }

    private Response.Listener<MenuItemResponse> onResultRecieved() {
        return new Response.Listener<MenuItemResponse>() {
            public void onResponse(MenuItemResponse menuItemResponse) {
                GlobalDataModel.JSON.menuItemsResponseModel = menuItemResponse.result;
                AreaChangeService.this.refreshMenuCompleted = true;
                AreaChangeService.this.dataFetchComplete();
            }
        };
    }

    private void refreshRestaurantList() {
        FilterEngine.resetFilter();
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.GETRESTANTS).setClazz(RestuarntListResponse.class).setListener(restaurantListLoaded()).setErrorListener(onRequestError()).setRequestBody(new RestaurantReq(GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCountryId).getJsonBody()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    private void refreshSelectedRestaurantDetails() {
        if (GlobalDataModel.SELECTED.restaurant != null) {
            GsonRequest.Builder builder = new GsonRequest.Builder();
            String str = AppUrls.RESTAURANT_DETAILS;
            TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{restaurantid}", "" + GlobalDataModel.SELECTED.restaurant, "{areaid}", "" + GlobalDataModel.SelectedAreaId, "{branchid}", "" + GlobalDataModel.SELECTED.restaurant.branchId})).setClazz(RestaurantRefreshRM.class).setListener(onRestaurantRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        }
    }

    private void refreshSelectedRestaurantMenu() {
        if (GlobalDataModel.SELECTED.restaurant != null) {
            GsonRequest.Builder builder = new GsonRequest.Builder();
            String str = AppUrls.GETMENUSECTIONSWITHHEROIMAGE;
            TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{Branchid}", "" + GlobalDataModel.SELECTED.restaurant.getBranchId(), "{areaid}", "" + GlobalDataModel.SelectedAreaId})).setClazz(MenuItemResponse.class).setListener(onResultRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
        }
    }

    private Response.Listener<RestuarntListResponse> restaurantListLoaded() {
        return new Response.Listener<RestuarntListResponse>() {
            public void onResponse(RestuarntListResponse restuarntListResponse) {
                RestaurantListJM restaurantListJM = restuarntListResponse.result;
                if (restaurantListJM.restaurants != null) {
                    GlobalDataModel.updateRestaurantsData(restaurantListJM);
                    GlobalDataModel.REFRESHFLAGS.isRestaurantListRefreshed = true;
                }
                AreaChangeService.this.refreshRestaurantListCompleted = true;
                AreaChangeService.this.dataFetchComplete();
            }
        };
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.appVersionProvider = ((ConfigurationRemoteCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationRemoteCoreLibApi.class)).getAppVersionProvider();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        this.startId = i12;
        refreshSelectedRestaurantMenu();
        refreshSelectedRestaurantDetails();
        refreshRestaurantList();
        return super.onStartCommand(intent, i11, i12);
    }
}
