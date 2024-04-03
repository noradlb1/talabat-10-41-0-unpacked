package com.talabat.restaurants.v1;

import JsonModels.RestaurantListJM;
import androidx.annotation.VisibleForTesting;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.v2.domain.swimlane.RequestSwimlanesUseCase;
import com.talabat.restaurants.v2.domain.vendorinfo.RequestVendorInfoUseCase;
import com.talabat.restaurants.v2.domain.vendors.RequestVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.ShouldUsePolygonApiUseCase;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.GemTier;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.WrapperRestaurantRecommendation;
import ht.d;
import ht.e;
import ht.f;
import ht.g;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import library.talabat.SharedPreferencesManager;
import library.talabat.com.talabatlib.RestuarntListResponse;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;

public class RestaurantsListInteractorRefactor implements IRestaurantsListInteractorRefactor {

    /* renamed from: b  reason: collision with root package name */
    public Disposable f61229b;

    /* renamed from: c  reason: collision with root package name */
    public RequestVendorInfoUseCase f61230c;

    /* renamed from: d  reason: collision with root package name */
    public RequestSwimlanesUseCase f61231d;

    /* renamed from: e  reason: collision with root package name */
    public RequestVendorsUseCase f61232e;

    /* renamed from: f  reason: collision with root package name */
    public ShouldUsePolygonApiUseCase f61233f;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public RestaurantsListInteractorRefactor(RequestVendorInfoUseCase requestVendorInfoUseCase, RequestSwimlanesUseCase requestSwimlanesUseCase, RequestVendorsUseCase requestVendorsUseCase, ShouldUsePolygonApiUseCase shouldUsePolygonApiUseCase, ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.f61230c = requestVendorInfoUseCase;
        this.f61231d = requestSwimlanesUseCase;
        this.f61232e = requestVendorsUseCase;
        this.f61233f = shouldUsePolygonApiUseCase;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private List<Integer> covertToIntArray(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String parseInt : list) {
            arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
        }
        return arrayList;
    }

    private ArrayList<Restaurant> filterRestaurants(boolean z11, int i11, Restaurant[] restaurantArr) {
        List<Integer> list;
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        for (Restaurant restaurant : restaurantArr) {
            if (!z11 || (list = restaurant.verticals) == null) {
                if (restaurant.shopType == i11) {
                    arrayList.add(restaurant);
                }
            } else if (list.contains(Integer.valueOf(i11))) {
                arrayList.add(restaurant);
            }
        }
        return arrayList;
    }

    private Observable<SwimlaneResponse> getRecommendationRestaurants(int i11, String str, String str2, int i12, int i13) {
        try {
            return this.f61231d.invoke(str, str2, i11, i12, i13).subscribeOn(Schedulers.io()).onErrorReturn(new d()).toObservable();
        } catch (IllegalArgumentException e11) {
            LogManager.logException(e11);
            return Observable.just(new SwimlaneResponse());
        }
    }

    private Observable<RestuarntListResponse> getRestaurantsInfoApi(String str, String str2, int i11) {
        return this.f61230c.invoke(str, str2, i11).subscribeOn(Schedulers.io()).toObservable();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ WrapperRestaurantRecommendation lambda$getRestaurantsAndRecommendation$0(RestuarntListResponse restuarntListResponse, RestuarntListResponse restuarntListResponse2, SwimlaneResponse swimlaneResponse) throws Exception {
        WrapperRestaurantRecommendation wrapperRestaurantRecommendation = new WrapperRestaurantRecommendation();
        wrapperRestaurantRecommendation.setRestaurantListInfoResponse(restuarntListResponse2);
        wrapperRestaurantRecommendation.setRestuarntListResponse(restuarntListResponse);
        return wrapperRestaurantRecommendation;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getRestaurantsAndRecommendation$1(RestaurantListListenerRefactor restaurantListListenerRefactor, int i11, WrapperRestaurantRecommendation wrapperRestaurantRecommendation) throws Exception {
        onRestaurantsRecieved(restaurantListListenerRefactor, wrapperRestaurantRecommendation.getRestuarntListResponse(), wrapperRestaurantRecommendation.getRestaurantListInfoResponse(), i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRestaurantsAndRecommendation$2(RestaurantListListenerRefactor restaurantListListenerRefactor, Throwable th2) throws Exception {
        restaurantListListenerRefactor.logNetworkError("getRestaurantsAndRecommendation with dark store " + th2.getMessage());
        restaurantListListenerRefactor.onNetworkError();
    }

    private Observable<RestuarntListResponse> requestVendors(String str, String str2, int i11) {
        List arrayList = new ArrayList();
        if (this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.LAUNCHER_ENABLE_TILES, false)) {
            arrayList = covertToIntArray(Arrays.asList(SharedPreferencesManager.getInstance().getMoreTileVerticalsId()));
        } else {
            arrayList.add(Integer.valueOf(i11));
        }
        return this.f61232e.invoke(new RequestVendorsUseCase.Params(true, GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCountryId, str, str2, arrayList)).subscribeOn(Schedulers.io()).toObservable();
    }

    @VisibleForTesting
    public void addCuisineOnlyIfApplicable(Cuisine cuisine, Restaurant[] restaurantArr, ArrayList<Cuisine> arrayList) {
        for (Restaurant cuisines : restaurantArr) {
            for (Cuisine cuisine2 : cuisines.getCuisines()) {
                if (cuisine2.f13848id == cuisine.f13848id) {
                    arrayList.add(cuisine);
                    return;
                }
            }
        }
    }

    public void getRestaurantsAndRecommendation(@NotNull RestaurantListListenerRefactor restaurantListListenerRefactor, int i11, int i12, @NotNull String str, @NotNull String str2, int i13, int i14) {
        GlobalDataModel.SELECTED.updateRestaurant((Restaurant) null);
        this.f61229b = Observable.zip(requestVendors(str, str2, i14), getRestaurantsInfoApi(str, str2, i14), getRecommendationRestaurants(i11, str, str2, i13, i14), new e()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, restaurantListListenerRefactor, i14), new g(restaurantListListenerRefactor));
    }

    @VisibleForTesting
    public void onRestaurantsRecieved(RestaurantListListenerRefactor restaurantListListenerRefactor, RestuarntListResponse restuarntListResponse, RestuarntListResponse restuarntListResponse2, int i11) {
        GemTier gemTier;
        TimeTrackerKt.getTimeTracker().startTracking("MAPPING_VENDORS_TO_FILTERS");
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        if (!this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.LAUNCHER_ENABLE_TILES, false) && i11 != 0) {
            Restaurant[] restaurantArr = restuarntListResponse.result.restaurants;
            if (restaurantArr.length > 0) {
                arrayList = filterRestaurants(true, i11, restaurantArr);
            }
            if (arrayList.size() > 0) {
                restuarntListResponse.result.restaurants = (Restaurant[]) arrayList.toArray(new Restaurant[arrayList.size()]);
            } else {
                restuarntListResponse.result.restaurants = new Restaurant[0];
            }
        }
        GlobalDataModel.updateRestaurantsData(restuarntListResponse.result);
        ArrayList arrayList2 = new ArrayList();
        Cuisine[] cuisineArr = restuarntListResponse2.result.cuisines;
        if (!(cuisineArr == null || restuarntListResponse.result.restaurants == null)) {
            for (Cuisine addCuisineOnlyIfApplicable : cuisineArr) {
                addCuisineOnlyIfApplicable(addCuisineOnlyIfApplicable, restuarntListResponse.result.restaurants, arrayList2);
            }
        }
        GlobalDataModel.cuisines = (Cuisine[]) arrayList2.toArray(new Cuisine[0]);
        GlobalDataModel.popularCuisinesIds = restuarntListResponse2.result.popularCuisines;
        ArrayList<Filter> arrayList3 = new ArrayList<>();
        ArrayList<Filter> arrayList4 = restuarntListResponse2.result.filters;
        if (!(arrayList4 == null || restuarntListResponse.result.restaurants == null)) {
            Iterator<Filter> it = arrayList4.iterator();
            while (it.hasNext()) {
                Filter next = it.next();
                Restaurant[] restaurantArr2 = restuarntListResponse.result.restaurants;
                int length = restaurantArr2.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (restaurantArr2[i12].getFiltersId().contains(Integer.valueOf(next.getId()))) {
                        arrayList3.add(next);
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        ArrayList<QuickFilter> arrayList5 = new ArrayList<>();
        ArrayList<QuickFilter> arrayList6 = restuarntListResponse2.result.collections;
        if (!(arrayList6 == null || restuarntListResponse.result.restaurants == null)) {
            Iterator<QuickFilter> it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                QuickFilter next2 = it2.next();
                Restaurant[] restaurantArr3 = restuarntListResponse.result.restaurants;
                int length2 = restaurantArr3.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length2) {
                        break;
                    } else if (restaurantArr3[i13].getFiltersId().contains(next2.getId())) {
                        arrayList5.add(next2);
                        break;
                    } else {
                        i13++;
                    }
                }
            }
        }
        GlobalDataModel.filters = arrayList3;
        GlobalDataModel.collections = arrayList5;
        RestaurantListJM restaurantListJM = restuarntListResponse2.result;
        GemTier[] gemTierArr = restaurantListJM.gemTiers;
        if (!(gemTierArr == null || gemTierArr.length <= 0 || (gemTier = gemTierArr[0]) == null)) {
            GlobalDataModel.GEMCONSTANTS.GemTiers = gemTier;
        }
        if (restaurantListListenerRefactor != null) {
            restaurantListListenerRefactor.onRestaurantListLoaded(restaurantListJM.isAreaSplitted, restaurantListJM.activePolygonEvent, true);
        }
        TimeTrackerKt.getTimeTracker().stopTracking("MAPPING_VENDORS_TO_FILTERS");
    }

    public void unregister() {
        Disposable disposable = this.f61229b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f61229b.dispose();
        }
    }
}
