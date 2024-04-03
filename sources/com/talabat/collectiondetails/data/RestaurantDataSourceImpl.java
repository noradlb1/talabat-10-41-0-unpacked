package com.talabat.collectiondetails.data;

import buisnessmodels.FilterEngine;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u000eH\u0016J&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u000e2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u000eH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000eH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00102\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0010H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0010H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006!"}, d2 = {"Lcom/talabat/collectiondetails/data/RestaurantDataSourceImpl;", "Lcom/talabat/collectiondetails/data/RestaurantsDataSource;", "()V", "clearCollectionCuisines", "", "clearCollectionFilterEngine", "getAllCuisines", "", "Ldatamodels/Cuisine;", "restaurants", "", "Ldatamodels/Restaurant;", "([Ldatamodels/Restaurant;)Ljava/util/List;", "getFilteredRestaurants", "Lio/reactivex/Single;", "getFilteredRestaurantsForCuisine", "", "getFilters", "Ldatamodels/Filter;", "getRestaurants", "getSelectedCuisine", "hasCollectionFilterEngine", "", "sort", "updateCollectionCuisines", "cuisines", "updateGlobalDataCollectionFilters", "filters", "updateGlobalDataCollectionRestaurants", "filteredRestaurants", "updateGlobalDataCollectionSearchRestaurants", "updateSelectedRestaurant", "restaurant", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantDataSourceImpl implements RestaurantsDataSource {
    public void clearCollectionCuisines() {
        GlobalDataModel.collectionCuisines = null;
    }

    public void clearCollectionFilterEngine() {
        GlobalDataModel.collectionFilterEngine = null;
    }

    @NotNull
    public List<Cuisine> getAllCuisines(@NotNull Restaurant[] restaurantArr) {
        Intrinsics.checkNotNullParameter(restaurantArr, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        ArrayList<Cuisine> cuisineNames = FilterEngine.getCuisineNames(restaurantArr);
        Intrinsics.checkNotNullExpressionValue(cuisineNames, "getCuisineNames(restaurants)");
        return cuisineNames;
    }

    @NotNull
    public Single<List<Restaurant>> getFilteredRestaurants() {
        ArrayList<Restaurant> arrayList = GlobalDataModel.TEMP.collectionFilteredRestaurants;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Single<List<Restaurant>> just = Single.just(arrayList);
        Intrinsics.checkNotNullExpressionValue(just, "just(\n            if (Gl…lse ArrayList()\n        )");
        return just;
    }

    @NotNull
    public Single<List<Restaurant>> getFilteredRestaurantsForCuisine(@Nullable List<? extends Restaurant> list) {
        Single<List<Restaurant>> just = Single.just(GlobalDataModel.collectionFilterEngine.filterRestaurants(list));
        Intrinsics.checkNotNullExpressionValue(just, "just(\n            Global…ts(restaurants)\n        )");
        return just;
    }

    @NotNull
    public Single<List<Filter>> getFilters() {
        ArrayList<Filter> arrayList = GlobalDataModel.filters;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Single<List<Filter>> just = Single.just(arrayList);
        Intrinsics.checkNotNullExpressionValue(just, "just(\n            if (Gl…lse ArrayList()\n        )");
        return just;
    }

    @NotNull
    public Single<Restaurant[]> getRestaurants() {
        Restaurant[] restaurantArr = GlobalDataModel.restaurants;
        if (restaurantArr == null) {
            restaurantArr = new Restaurant[0];
        }
        Single<Restaurant[]> just = Single.just(restaurantArr);
        Intrinsics.checkNotNullExpressionValue(just, "just(\n            if (Gl… else arrayOf()\n        )");
        return just;
    }

    @Nullable
    public Cuisine getSelectedCuisine() {
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (filterEngine == null || filterEngine.getSelectedCuisines() == null || GlobalDataModel.collectionFilterEngine.getSelectedCuisines().size() <= 0) {
            return null;
        }
        return GlobalDataModel.collectionFilterEngine.getSelectedCuisines().valueAt(0);
    }

    public boolean hasCollectionFilterEngine() {
        return GlobalDataModel.collectionFilterEngine != null;
    }

    @Nullable
    public List<Restaurant> sort(@Nullable List<? extends Restaurant> list) {
        if (GlobalDataModel.collectionFilterEngine.getIsSortApplied()) {
            return GlobalDataModel.collectionFilterEngine.sortRestaurant((ArrayList) list);
        }
        return list;
    }

    public void updateCollectionCuisines(@Nullable List<Cuisine> list) {
        if (list != null && GlobalDataModel.collectionCuisines == null) {
            Object[] array = list.toArray(new Cuisine[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            GlobalDataModel.collectionCuisines = (Cuisine[]) array;
        }
    }

    public void updateGlobalDataCollectionFilters(@Nullable List<? extends Filter> list) {
        GlobalDataModel.collectionFilters = (ArrayList) list;
    }

    public void updateGlobalDataCollectionRestaurants(@Nullable List<? extends Restaurant> list) {
        GlobalDataModel.collectionRestaurants = (ArrayList) list;
    }

    public void updateGlobalDataCollectionSearchRestaurants(@Nullable List<? extends Restaurant> list) {
        GlobalDataModel.backFromMenuToList = true;
        GlobalDataModel.collectionSearchRestaurants = (ArrayList) list;
    }

    public void updateSelectedRestaurant(@Nullable Restaurant restaurant) {
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
    }
}
