package com.talabat.collectiondetails.ui.quickfilter;

import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import datamodels.filters.SelectablePopularFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&J\u001a\u0010\u0013\u001a\u00020\r2\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\rH&J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH&J\b\u0010\u001d\u001a\u00020\rH&J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H&¨\u0006 "}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "getAllCollectionRestaurants", "Ljava/util/ArrayList;", "Ldatamodels/Restaurant;", "Lkotlin/collections/ArrayList;", "getChannelIndex", "", "quickFilter", "Ldatamodels/QuickFilter;", "getCurrentCollectionRestaurants", "Ldatamodels/RestaurantListModel;", "getDarkStoresInfo", "", "getTerms", "collectionId", "", "handleCuisineSelection", "handleFilterCancel", "handleFilterSelection", "selectablePopularFilters", "", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "isComingFromMenu", "", "onSearchClick", "onStart", "filter", "updateCuisines", "updateSelectedRestaurant", "restaurant", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IQuickFilterRestaurantsPresenter extends IGlobalPresenter {
    @Nullable
    ArrayList<Restaurant> getAllCollectionRestaurants();

    @NotNull
    String getChannelIndex(@Nullable QuickFilter quickFilter);

    @Nullable
    RestaurantListModel getCurrentCollectionRestaurants();

    void getDarkStoresInfo();

    void getTerms(int i11);

    void handleCuisineSelection();

    void handleFilterCancel();

    void handleFilterSelection(@NotNull List<SelectablePopularFilter> list);

    boolean isComingFromMenu();

    void onSearchClick();

    void onStart(@Nullable QuickFilter quickFilter);

    void updateCuisines();

    void updateSelectedRestaurant(@Nullable Restaurant restaurant);
}
