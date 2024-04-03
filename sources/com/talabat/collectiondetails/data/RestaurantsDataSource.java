package com.talabat.collectiondetails.data;

import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH&¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rH&J&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006H&J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\rH&J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\rH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0014\u001a\u00020\u0015H&J$\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00062\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006H&J\u0018\u0010\u0017\u001a\u00020\u00032\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH&J\u0018\u0010\u0019\u001a\u00020\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006H&J\u001a\u0010\u001b\u001a\u00020\u00032\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006H&J\u001a\u0010\u001d\u001a\u00020\u00032\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0006H&J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\nH&¨\u0006 "}, d2 = {"Lcom/talabat/collectiondetails/data/RestaurantsDataSource;", "", "clearCollectionCuisines", "", "clearCollectionFilterEngine", "getAllCuisines", "", "Ldatamodels/Cuisine;", "restaurants", "", "Ldatamodels/Restaurant;", "([Ldatamodels/Restaurant;)Ljava/util/List;", "getFilteredRestaurants", "Lio/reactivex/Single;", "", "getFilteredRestaurantsForCuisine", "getFilters", "Ldatamodels/Filter;", "getRestaurants", "getSelectedCuisine", "hasCollectionFilterEngine", "", "sort", "updateCollectionCuisines", "cuisines", "updateGlobalDataCollectionFilters", "filters", "updateGlobalDataCollectionRestaurants", "filteredRestaurants", "updateGlobalDataCollectionSearchRestaurants", "updateSelectedRestaurant", "restaurant", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RestaurantsDataSource {
    void clearCollectionCuisines();

    void clearCollectionFilterEngine();

    @NotNull
    List<Cuisine> getAllCuisines(@NotNull Restaurant[] restaurantArr);

    @NotNull
    Single<List<Restaurant>> getFilteredRestaurants();

    @NotNull
    Single<List<Restaurant>> getFilteredRestaurantsForCuisine(@Nullable List<? extends Restaurant> list);

    @NotNull
    Single<List<Filter>> getFilters();

    @NotNull
    Single<Restaurant[]> getRestaurants();

    @Nullable
    Cuisine getSelectedCuisine();

    boolean hasCollectionFilterEngine();

    @Nullable
    List<Restaurant> sort(@Nullable List<? extends Restaurant> list);

    void updateCollectionCuisines(@Nullable List<Cuisine> list);

    void updateGlobalDataCollectionFilters(@Nullable List<? extends Filter> list);

    void updateGlobalDataCollectionRestaurants(@Nullable List<? extends Restaurant> list);

    void updateGlobalDataCollectionSearchRestaurants(@Nullable List<? extends Restaurant> list);

    void updateSelectedRestaurant(@Nullable Restaurant restaurant);
}
