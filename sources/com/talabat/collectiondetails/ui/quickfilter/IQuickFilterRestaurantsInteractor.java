package com.talabat.collectiondetails.ui.quickfilter;

import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import datamodels.filters.SelectablePopularFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J(\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00150\u001cH&J\u001a\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u001e\u0010\u001f\u001a\u00020\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00150\u001cH&J\u001e\u0010 \u001a\u00020\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00150\u001cH&J0\u0010!\u001a\u00020\u00152\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00020#0\u0003j\u0002`$2\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00150\u001cH&J\b\u0010%\u001a\u00020\u0015H&J\b\u0010&\u001a\u00020\u0015H&J\b\u0010'\u001a\u00020\u0015H&J\u0012\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0004H&R\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;", "", "allCollectionRestaurants", "", "Ldatamodels/Restaurant;", "getAllCollectionRestaurants", "()Ljava/util/List;", "isComingFromMenu", "", "()Z", "isFromMenuToList", "isNewListingSearch", "restaurantsModel", "Ldatamodels/RestaurantListModel;", "getRestaurantsModel", "()Ldatamodels/RestaurantListModel;", "selectedCuisineId", "", "getSelectedCuisineId", "()Ljava/lang/Integer;", "clearEngineData", "", "getDarkStoresInfo", "listener", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListener;", "getRestaurantsForCollection", "quickFilter", "Ldatamodels/QuickFilter;", "Lkotlin/Function1;", "getTerms", "collectionId", "handleCuisineSelection", "handleFilterCancel", "handleFilterSelection", "selectablePopularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "handleSearchClick", "unregister", "updateCuisines", "updateSelectedRestaurant", "restaurant", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IQuickFilterRestaurantsInteractor {
    void clearEngineData();

    @Nullable
    List<Restaurant> getAllCollectionRestaurants();

    void getDarkStoresInfo(@Nullable QuickFilterRestaurantsListener quickFilterRestaurantsListener);

    void getRestaurantsForCollection(@Nullable QuickFilter quickFilter, @NotNull Function1<? super RestaurantListModel, Unit> function1);

    @Nullable
    RestaurantListModel getRestaurantsModel();

    @Nullable
    Integer getSelectedCuisineId();

    void getTerms(int i11, @Nullable QuickFilterRestaurantsListener quickFilterRestaurantsListener);

    void handleCuisineSelection(@NotNull Function1<? super RestaurantListModel, Unit> function1);

    void handleFilterCancel(@NotNull Function1<? super RestaurantListModel, Unit> function1);

    void handleFilterSelection(@NotNull List<SelectablePopularFilter> list, @NotNull Function1<? super RestaurantListModel, Unit> function1);

    void handleSearchClick();

    boolean isComingFromMenu();

    boolean isFromMenuToList();

    boolean isNewListingSearch();

    void unregister();

    void updateCuisines();

    void updateSelectedRestaurant(@Nullable Restaurant restaurant);
}
