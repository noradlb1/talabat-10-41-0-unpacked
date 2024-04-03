package com.talabat.restaurants.v1;

import JsonModels.PolygonEvents;
import android.content.Context;
import android.net.Uri;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.android.volley.VolleyError;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.v2.domain.exceptions.CollectionCategoryException;
import com.talabat.restaurants.v2.domain.swimlane.GetSwimlaneGaUseCase;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.VendorsUseCase;
import com.talabat.restaurants.v2.ui.viewmodels.CollectionTracker;
import com.talabat.restaurants.v2.ui.viewmodels.VendorListGaWrapper;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import ht.h;
import ht.i;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.homemap.HomeMapTemp;
import tracking.AppTracker;
import tracking.ShopClickedEvent;

public class RestaurantsListPresenterRefactor implements IRestaurantsListPresenterRefactor, RestaurantListListenerRefactor {

    /* renamed from: a  reason: collision with root package name */
    public PolygonEvents f61234a;

    /* renamed from: b  reason: collision with root package name */
    public CompositeDisposable f61235b = new CompositeDisposable();

    /* renamed from: c  reason: collision with root package name */
    public ITalabatExperiment f61236c;

    /* renamed from: d  reason: collision with root package name */
    public CollectionTracker f61237d;
    private GetSwimlaneGaUseCase getSwimlaneGaUseCase;
    private VendorsUseCase getVendorsUseCase;
    private IRestaurantsListInteractorRefactor mInteractor;
    private RestaurantListViewRefactor mRestaurantListView;
    private int verticalId;

    public RestaurantsListPresenterRefactor(RestaurantListViewRefactor restaurantListViewRefactor, IRestaurantsListInteractorRefactor iRestaurantsListInteractorRefactor, int i11, GetSwimlaneGaUseCase getSwimlaneGaUseCase2, VendorsUseCase vendorsUseCase, ITalabatExperiment iTalabatExperiment, CollectionTracker collectionTracker) {
        this.mRestaurantListView = restaurantListViewRefactor;
        this.mInteractor = iRestaurantsListInteractorRefactor;
        this.verticalId = i11;
        this.getSwimlaneGaUseCase = getSwimlaneGaUseCase2;
        this.getVendorsUseCase = vendorsUseCase;
        this.f61236c = iTalabatExperiment;
        this.f61237d = collectionTracker;
    }

    private HashMap<QuickFilter, ArrayList<Restaurant>> getChannelsWithRestaurants() {
        HashMap<QuickFilter, ArrayList<Restaurant>> hashMap = new HashMap<>();
        ArrayList<QuickFilter> arrayList = GlobalDataModel.collections;
        if (arrayList == null) {
            return hashMap;
        }
        Iterator<QuickFilter> it = arrayList.iterator();
        while (it.hasNext()) {
            QuickFilter next = it.next();
            ArrayList arrayList2 = new ArrayList();
            for (Restaurant restaurant : GlobalDataModel.restaurants) {
                if (restaurant.getFiltersId().contains(next.getId())) {
                    arrayList2.add(restaurant);
                }
            }
            hashMap.put(next, arrayList2);
        }
        return hashMap;
    }

    private String getQueryValue(String str, String str2) throws CollectionCategoryException {
        if (str == null || str.isEmpty()) {
            throw new CollectionCategoryException("Query: " + str2 + " deeplink is null or empty");
        }
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (queryParameter != null && !queryParameter.isEmpty()) {
            return queryParameter;
        }
        throw new CollectionCategoryException("Query: " + str2 + " deeplinkType is null or empty");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:9|10|11|12|13|14|25|15|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getStringValue(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            if (r10 == 0) goto L_0x0009
            java.lang.String r0 = "&"
            java.lang.String[] r9 = r9.split(r0)
            goto L_0x000a
        L_0x0009:
            r9 = 0
        L_0x000a:
            java.lang.String r0 = ""
            if (r9 == 0) goto L_0x0042
            int r1 = r9.length     // Catch:{ Exception -> 0x0042 }
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0042 }
            int r3 = r9.length     // Catch:{ Exception -> 0x0042 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0042 }
            r4 = 0
            r5 = r4
        L_0x0016:
            int r6 = r9.length     // Catch:{ Exception -> 0x0042 }
            if (r5 >= r6) goto L_0x0030
            r6 = r9[r5]     // Catch:{ Exception -> 0x0042 }
            java.lang.String r7 = "="
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ Exception -> 0x0042 }
            r7 = r6[r4]     // Catch:{ Exception -> 0x0042 }
            r2[r5] = r7     // Catch:{ Exception -> 0x0042 }
            r7 = 1
            r6 = r6[r7]     // Catch:{ Exception -> 0x002b }
            r3[r5] = r6     // Catch:{ Exception -> 0x002b }
            goto L_0x002d
        L_0x002b:
            r3[r5] = r0     // Catch:{ Exception -> 0x0042 }
        L_0x002d:
            int r5 = r5 + 1
            goto L_0x0016
        L_0x0030:
            r9 = r0
        L_0x0031:
            if (r4 >= r1) goto L_0x0040
            r5 = r2[r4]     // Catch:{ Exception -> 0x0042 }
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x0042 }
            if (r5 == 0) goto L_0x003d
            r9 = r3[r4]     // Catch:{ Exception -> 0x0042 }
        L_0x003d:
            int r4 = r4 + 1
            goto L_0x0031
        L_0x0040:
            r0 = r9
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v1.RestaurantsListPresenterRefactor.getStringValue(java.lang.String, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendGaOnRestaurantListLoaded$1(Boolean bool, String str, String str2, ShopClickedEvent.EventOriginSource eventOriginSource, String str3, VendorListGaWrapper vendorListGaWrapper) throws Exception {
        String str4;
        String str5;
        String str6;
        String str7 = str;
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        for (Restaurant next : vendorListGaWrapper.getVendorList()) {
            if (next.statusType == 0) {
                arrayList.add(next);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() >= 30) {
            for (int i11 = 0; i11 < 30; i11++) {
                if (sb2.length() == 0) {
                    sb2.append(((Restaurant) arrayList.get(i11)).getId());
                } else {
                    sb2.append(",");
                    sb2.append(((Restaurant) arrayList.get(i11)).getId());
                }
            }
        } else {
            for (Restaurant restaurant : arrayList) {
                if (sb2.length() == 0) {
                    sb2.append(restaurant.getId());
                } else {
                    sb2.append(",");
                    sb2.append(restaurant.getId());
                }
            }
        }
        String channelIndex = getChannelIndex();
        GlobalDataModel.POLYGON_TRACKING.polygonEvents = this.f61234a;
        boolean booleanValue = bool.booleanValue();
        String str8 = StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT;
        if (booleanValue) {
            Context context = this.mRestaurantListView.getContext();
            ArrayList arrayList2 = new ArrayList(vendorListGaWrapper.getVendorList());
            if (str7 == null || str7.equalsIgnoreCase("home_restaurants")) {
                str5 = str8;
            } else {
                str5 = getVerticalTypeForAnalytics(str7);
            }
            int size = arrayList.size();
            String sb3 = sb2.toString();
            PolygonEvents polygonEvents = this.f61234a;
            if (SharedPreferencesManager.getInstance(this.mRestaurantListView.getContext()).isCardViewFavStyle(Boolean.FALSE)) {
                str6 = "card_view";
            } else {
                str6 = "list_view";
            }
            AppTracker.onRestaurantListUpdated(context, arrayList2, str5, channelIndex, "", str2, true, 0, size, false, sb3, polygonEvents, str6, vendorListGaWrapper.getSwimlaneGa(), eventOriginSource, str3);
            return;
        }
        Context context2 = this.mRestaurantListView.getContext();
        ArrayList arrayList3 = new ArrayList(vendorListGaWrapper.getVendorList());
        if (str7 != null && !str7.equalsIgnoreCase("home_restaurants")) {
            str8 = getVerticalTypeForAnalytics(str7);
        }
        String str9 = str8;
        if (str7 == null) {
            str7 = "home_restaurants";
        }
        int size2 = arrayList.size();
        String sb4 = sb2.toString();
        PolygonEvents polygonEvents2 = this.f61234a;
        SharedPreferencesManager instance = SharedPreferencesManager.getInstance(this.mRestaurantListView.getContext());
        Boolean bool2 = Boolean.FALSE;
        if (instance.isCardViewFavStyle(bool2)) {
            str4 = "card_view";
        } else {
            str4 = "list_view";
        }
        Boolean bool3 = bool2;
        AppTracker.onRestaurantListLoaded(context2, arrayList3, str9, channelIndex, "", str7, true, 0, size2, sb4, polygonEvents2, str4, vendorListGaWrapper.getSwimlaneGa(), str3, bool3);
    }

    public boolean canShowCollectionsTitle() {
        if (this.verticalId != 1 || !this.f61236c.getBooleanVariant(TalabatExperimentConstants.GROCERY_COLLECTION_TITLE, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            return false;
        }
        return true;
    }

    public void clearFilterEngine() {
        FilterEngine.resetFilter();
    }

    public String getChannelIndex() {
        StringBuilder sb2 = new StringBuilder();
        HashMap<QuickFilter, ArrayList<Restaurant>> channelsWithRestaurants = getChannelsWithRestaurants();
        if (channelsWithRestaurants != null && channelsWithRestaurants.size() > 0) {
            Iterator<Map.Entry<QuickFilter, ArrayList<Restaurant>>> it = channelsWithRestaurants.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (sb2.length() == 0) {
                    sb2.append(((QuickFilter) next.getKey()).getSlug());
                    sb2.append(CertificateUtil.DELIMITER);
                    sb2.append(((ArrayList) next.getValue()).size());
                } else {
                    sb2.append(",");
                    sb2.append(((QuickFilter) next.getKey()).getSlug());
                    sb2.append(CertificateUtil.DELIMITER);
                    sb2.append(((ArrayList) next.getValue()).size());
                }
                it.remove();
            }
        }
        return sb2.toString();
    }

    public int getRestaurantIdFromDeepLink(String str) {
        try {
            return Integer.parseInt(getStringValue(str, "v"));
        } catch (Exception unused) {
            return -1;
        }
    }

    public void getRestuarnts() {
        double d11;
        double d12;
        LogManager.debug("[ALOVvl]: get restaurants init");
        this.mRestaurantListView.showLoadingFragment();
        Customer instance = Customer.getInstance();
        if (instance == null || !instance.isLoggedIn() || instance.getSelectedCustomerAddress() == null) {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (homeMapTemp.getHomeMapSavedLatLng() != null) {
                d12 = homeMapTemp.getHomeMapSavedLatLng().latitude;
                d11 = homeMapTemp.getHomeMapSavedLatLng().longitude;
            } else {
                d12 = 0.0d;
                d11 = 0.0d;
            }
        } else {
            d12 = instance.getSelectedCustomerAddress().latitude;
            d11 = instance.getSelectedCustomerAddress().longitude;
        }
        if (d11 == 0.0d || d12 == 0.0d || GlobalDataModel.SelectedAreaId == 0) {
            LogManager.logException(new Exception("Wrong address latitude and longitude areaId = " + d12 + "," + d11 + "," + GlobalDataModel.SelectedAreaId));
            this.mRestaurantListView.showCoordinationsError();
            return;
        }
        this.mInteractor.getRestaurantsAndRecommendation(this, GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCityId, String.valueOf(d12), String.valueOf(d11), GlobalDataModel.SelectedCountryId, this.verticalId);
    }

    public Single<HashMap<String, String>> getSwimlanesGa() {
        return this.getSwimlaneGaUseCase.invoke(false, String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCountryId, this.verticalId);
    }

    public String getTMartCategoryId(String str) throws CollectionCategoryException {
        return getQueryValue(str, "i");
    }

    public String getTMartScreenTitle(String str) throws CollectionCategoryException {
        return getQueryValue(str, "n");
    }

    public int getTMartScreenType(String str) throws CollectionCategoryException {
        try {
            return Integer.parseInt(getQueryValue(str, "t"));
        } catch (NumberFormatException unused) {
            throw new CollectionCategoryException("tmart screen type is not number");
        }
    }

    public String getVerticalTypeForAnalytics(String str) {
        if (str == null) {
            return StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT;
        }
        return str.replace("home_", "");
    }

    public boolean isCategoryCollection(QuickFilter quickFilter) {
        if (quickFilter == null || quickFilter.getDeepLink() == null) {
            return false;
        }
        return quickFilter.getDeepLink().matches("talabat://\\?s=ds&(.*)");
    }

    public void logNetworkError(String str) {
        this.mRestaurantListView.logNetworkError(str);
    }

    public void onAreaSelected(int i11, String str) {
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
        if (Customer.getInstance().isLoggedIn()) {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            if (selectedCustomerAddress == null || selectedCustomerAddress.areaId != i11) {
                Customer.getInstance().deselectCustomerAddress(this.mRestaurantListView.getContext());
                this.mRestaurantListView.setAreaName(str, false);
                return;
            }
            RestaurantListViewRefactor restaurantListViewRefactor = this.mRestaurantListView;
            restaurantListViewRefactor.setAreaName(selectedCustomerAddress.profileName + " (" + selectedCustomerAddress.areaName + ")", true);
            return;
        }
        this.mRestaurantListView.setAreaName(str, false);
    }

    public void onDataError() {
        this.mRestaurantListView.onDataError();
    }

    public void onDestroy() {
        this.mRestaurantListView = null;
        IRestaurantsListInteractorRefactor iRestaurantsListInteractorRefactor = this.mInteractor;
        if (iRestaurantsListInteractorRefactor != null) {
            iRestaurantsListInteractorRefactor.unregister();
        }
        this.mInteractor = null;
    }

    public void onNetworkError() {
        this.mRestaurantListView.onNetworkError();
    }

    public void onRequestError() {
        RestaurantListViewRefactor restaurantListViewRefactor = this.mRestaurantListView;
        if (restaurantListViewRefactor != null) {
            restaurantListViewRefactor.onRequestError();
        }
    }

    public void onRestaurantListLoaded(boolean z11, PolygonEvents polygonEvents, boolean z12) {
        this.f61234a = polygonEvents;
        if (z11) {
            this.mRestaurantListView.showAreaSplitAlert();
            return;
        }
        SharedPreferencesManager.getInstance(this.mRestaurantListView.getContext()).getLastFavVerticalId();
        this.mRestaurantListView.showRestaurantsFragment(polygonEvents, z12);
    }

    public void onServerError() {
        this.mRestaurantListView.onServerError();
    }

    public void selectedAreaDropDown() {
        boolean z11 = false;
        if (Customer.getInstance() != null) {
            Customer instance = Customer.getInstance();
            if (!instance.isLoggedIn()) {
                this.mRestaurantListView.redirectoHomeMapScreen(false, "");
            } else if (instance.hasAddresses()) {
                this.mRestaurantListView.redirectoChooseSavedAddressScreen(instance.getSelectedCustomerAddress());
            } else {
                this.mRestaurantListView.redirectoHomeMapScreen(false, "");
            }
        } else {
            RestaurantListViewRefactor restaurantListViewRefactor = this.mRestaurantListView;
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName) || GlobalDataModel.SelectedAreaId > 0) {
                z11 = true;
            }
            restaurantListViewRefactor.redirectoHomeMapScreen(z11, "");
        }
    }

    public void sendCollectionClickEvent(QuickFilter quickFilter) {
        Pair<String, Map<String, String>> collectionCategoryClickEvent = this.f61237d.getCollectionCategoryClickEvent(quickFilter);
        this.mRestaurantListView.sendEvent(collectionCategoryClickEvent.getFirst(), collectionCategoryClickEvent.getSecond());
    }

    public void sendGaOnRestaurantListLoaded(String str, Boolean bool, String str2, String str3, ShopClickedEvent.EventOriginSource eventOriginSource) {
        this.f61235b.add(Single.zip((SingleSource) this.getVendorsUseCase.invoke(new GetVendorsUseCase.Params(false, GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCountryId, String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), this.verticalId)), getSwimlanesGa(), new BiFunction<List<? extends Restaurant>, HashMap<String, String>, VendorListGaWrapper>() {
            public VendorListGaWrapper apply(List<? extends Restaurant> list, HashMap<String, String> hashMap) throws Exception {
                return new VendorListGaWrapper(list, hashMap);
            }
        }).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).onErrorReturn(new h()).subscribe(new i(this, bool, str, str2, eventOriginSource, str3)));
    }

    public boolean showTmartBanner(int i11) {
        return this.verticalId == 1 && i11 >= 21;
    }

    public void onServerError(VolleyError volleyError) {
        this.mRestaurantListView.onServerError(volleyError);
    }
}
