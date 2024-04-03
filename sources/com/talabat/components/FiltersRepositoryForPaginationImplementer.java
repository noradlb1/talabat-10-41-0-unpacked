package com.talabat.components;

import buisnessmodels.FilterEngine;
import com.talabat.filters.domain.FiltersRepository;
import com.talabat.filters.storage.FiltersInMemoryCache;
import datamodels.Filter;
import datamodels.Restaurant;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@FiltersIntegrationDsl
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rHAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010HAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rHAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001b\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rHAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018HAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0007j\u0004\u0018\u0001`\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0007j\u0004\u0018\u0001`\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rHAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0018HAø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u001f\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010 \u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0014H\u0001J#\u0010#\u001a\u00020\u00042\u0010\u0010$\u001a\f\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\rH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0018HAø\u0001\u0000¢\u0006\u0002\u0010(J#\u0010)\u001a\u00020\u00042\u0010\u0010$\u001a\f\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\rH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0018HAø\u0001\u0000¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/talabat/components/FiltersRepositoryForPaginationImplementer;", "Lcom/talabat/filters/domain/FiltersRepository;", "()V", "clearPopularCollectionsFilters", "", "clearPopularFilters", "requestAllCollectionSelectableSortTypes", "", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAllCollectionsFilters", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "requestAllRestaurants", "Ldatamodels/Restaurant;", "Ldatamodels/Restaurants;", "requestAllRestaurantsFilters", "requestAllSelectableSortTypes", "requestSelectedCollectionId", "", "()Ljava/lang/Integer;", "requestSelectedCollectionsFilters", "requestSelectedCollectionsSortType", "Ldatamodels/filters/SortType;", "requestSelectedPopularCollectionsFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "requestSelectedPopularFilters", "requestSelectedRestaurantsFilters", "requestSelectedRestaurantsSortType", "resetSelectedCollectionsFilters", "resetSelectedRestaurantsFilters", "saveSelectedCollectionId", "id", "saveSelectedCollectionsFilters", "filters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedCollectionsSortType", "type", "(Ldatamodels/filters/SortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedRestaurantsFilters", "saveSelectedRestaurantsSortType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersRepositoryForPaginationImplementer implements FiltersRepository {
    @NotNull
    public static final FiltersRepositoryForPaginationImplementer INSTANCE = new FiltersRepositoryForPaginationImplementer();
    private final /* synthetic */ FiltersRepositoryImplementer $$delegate_0 = FiltersRepositoryImplementer.INSTANCE;

    private FiltersRepositoryForPaginationImplementer() {
    }

    private final void clearPopularCollectionsFilters() {
        List<SelectablePopularFilter> collectionPopularFilters = FiltersInMemoryCache.INSTANCE.getCollectionPopularFilters();
        if (collectionPopularFilters != null) {
            for (SelectablePopularFilter on2 : collectionPopularFilters) {
                on2.setOn(false);
            }
        }
    }

    private final void clearPopularFilters() {
        List<SelectablePopularFilter> restaurantsPopularFilters = FiltersInMemoryCache.INSTANCE.getRestaurantsPopularFilters();
        if (restaurantsPopularFilters != null) {
            for (SelectablePopularFilter on2 : restaurantsPopularFilters) {
                on2.setOn(false);
            }
        }
    }

    @Nullable
    public Object requestAllCollectionSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation) {
        List<SelectableSortType> collectionSortingTypes = FiltersInMemoryCache.INSTANCE.getCollectionSortingTypes();
        return collectionSortingTypes == null ? FiltersRepository.DefaultImpls.requestAllCollectionSelectableSortTypes(this, continuation) : collectionSortingTypes;
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestAllCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return this.$$delegate_0.requestAllCollectionsFilters(continuation);
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestAllRestaurants(@NotNull Continuation<? super List<? extends Restaurant>> continuation) {
        return this.$$delegate_0.requestAllRestaurants(continuation);
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestAllRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return this.$$delegate_0.requestAllRestaurantsFilters(continuation);
    }

    @Nullable
    public Object requestAllSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation) {
        List<SelectableSortType> restaurantsSortingTypes = FiltersInMemoryCache.INSTANCE.getRestaurantsSortingTypes();
        return restaurantsSortingTypes == null ? FiltersRepository.DefaultImpls.requestAllSelectableSortTypes(this, continuation) : restaurantsSortingTypes;
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Integer requestSelectedCollectionId() {
        return this.$$delegate_0.requestSelectedCollectionId();
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestSelectedCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return this.$$delegate_0.requestSelectedCollectionsFilters(continuation);
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestSelectedCollectionsSortType(@NotNull Continuation<? super SortType> continuation) {
        return this.$$delegate_0.requestSelectedCollectionsSortType(continuation);
    }

    @Nullable
    public Object requestSelectedPopularCollectionsFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
        return FiltersInMemoryCache.INSTANCE.getCollectionPopularFilters();
    }

    @Nullable
    public Object requestSelectedPopularFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
        return FiltersInMemoryCache.INSTANCE.getRestaurantsPopularFilters();
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestSelectedRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return this.$$delegate_0.requestSelectedRestaurantsFilters(continuation);
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestSelectedRestaurantsSortType(@NotNull Continuation<? super SortType> continuation) {
        return this.$$delegate_0.requestSelectedRestaurantsSortType(continuation);
    }

    @Nullable
    public Object resetSelectedCollectionsFilters(@NotNull Continuation<? super Unit> continuation) {
        FilterEngine.resetFilter(FilterEngine.getInstance(1), false);
        clearPopularCollectionsFilters();
        return Unit.INSTANCE;
    }

    @Nullable
    public Object resetSelectedRestaurantsFilters(@NotNull Continuation<? super Unit> continuation) {
        FilterEngine.resetFilter(FilterEngine.getInstance(0), false);
        clearPopularFilters();
        return Unit.INSTANCE;
    }

    @FiltersDataSourceApi(version = 1)
    public void saveSelectedCollectionId(int i11) {
        this.$$delegate_0.saveSelectedCollectionId(i11);
    }

    @Nullable
    public Object saveSelectedCollectionsFilters(@NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation) {
        FilterEngine.getInstance(1).setSelectedFilter((List<Filter>) list);
        return Unit.INSTANCE;
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object saveSelectedCollectionsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
        return this.$$delegate_0.saveSelectedCollectionsSortType(sortType, continuation);
    }

    @Nullable
    public Object saveSelectedRestaurantsFilters(@NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation) {
        FilterEngine.getInstance(0).setSelectedFilter((List<Filter>) list);
        return Unit.INSTANCE;
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object saveSelectedRestaurantsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
        return this.$$delegate_0.saveSelectedRestaurantsSortType(sortType, continuation);
    }
}
