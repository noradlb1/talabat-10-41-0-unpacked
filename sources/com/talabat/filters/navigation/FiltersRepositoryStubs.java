package com.talabat.filters.navigation;

import com.talabat.filters.domain.FiltersRepository;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\f\u001a\f\u0012\u0004\u0012\u00020\r0\u0004j\u0002`\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0019\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J#\u0010\u001c\u001a\u00020\u00182\u0010\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010!J#\u0010\"\u001a\u00020\u00182\u0010\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/talabat/filters/navigation/FiltersRepositoryStubs;", "Lcom/talabat/filters/domain/FiltersRepository;", "()V", "requestAllCollectionsFilters", "", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAllRestaurants", "Ldatamodels/Restaurant;", "Ldatamodels/Restaurants;", "requestAllRestaurantsFilters", "requestAllSelectableSortTypes", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "requestSelectedCollectionId", "", "()Ljava/lang/Integer;", "requestSelectedCollectionsFilters", "requestSelectedCollectionsSortType", "Ldatamodels/filters/SortType;", "requestSelectedRestaurantsFilters", "requestSelectedRestaurantsSortType", "resetSelectedCollectionsFilters", "", "resetSelectedRestaurantsFilters", "saveSelectedCollectionId", "id", "saveSelectedCollectionsFilters", "filters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedCollectionsSortType", "type", "(Ldatamodels/filters/SortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedRestaurantsFilters", "saveSelectedRestaurantsSortType", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class FiltersRepositoryStubs implements FiltersRepository {
    @NotNull
    public static final FiltersRepositoryStubs INSTANCE = new FiltersRepositoryStubs();

    private FiltersRepositoryStubs() {
    }

    @Nullable
    @FiltersDataSourceApi(version = 2)
    public Object requestAllCollectionSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation) {
        return FiltersRepository.DefaultImpls.requestAllCollectionSelectableSortTypes(this, continuation);
    }

    @Nullable
    public Object requestAllCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("AllFilters");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public Object requestAllRestaurants(@NotNull Continuation<? super List<? extends Restaurant>> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("AllRestaurants");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public Object requestAllRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("AllFilters");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public Object requestAllSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("AllSorts");
        if (obj != null) {
            return (List) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<datamodels.filters.SelectableSortType>{ datamodels.TypesAliasesKt.SelectableSortTypes }");
    }

    @Nullable
    public Integer requestSelectedCollectionId() {
        Object obj = SampleFiltersActivityKt.getCache().get("SelectedCollectionId");
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    @Nullable
    public Object requestSelectedCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("SelectedCollectionsFilters");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public Object requestSelectedCollectionsSortType(@NotNull Continuation<? super SortType> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("SelectedCollectionsSortType");
        if (obj instanceof SortType) {
            return (SortType) obj;
        }
        return null;
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestSelectedPopularCollectionsFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
        return FiltersRepository.DefaultImpls.requestSelectedPopularCollectionsFilters(this, continuation);
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestSelectedPopularFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
        return FiltersRepository.DefaultImpls.requestSelectedPopularFilters(this, continuation);
    }

    @Nullable
    public Object requestSelectedRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("SelectedRestaurantsFilters");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public Object requestSelectedRestaurantsSortType(@NotNull Continuation<? super SortType> continuation) {
        Object obj = SampleFiltersActivityKt.getCache().get("SelectedRestaurantsSortType");
        if (obj instanceof SortType) {
            return (SortType) obj;
        }
        return null;
    }

    @Nullable
    public Object resetSelectedCollectionsFilters(@NotNull Continuation<? super Unit> continuation) {
        Object remove = SampleFiltersActivityKt.getCache().remove("SelectedCollectionsFilters");
        if (remove == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return remove;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object resetSelectedRestaurantsFilters(@NotNull Continuation<? super Unit> continuation) {
        Object remove = SampleFiltersActivityKt.getCache().remove("SelectedRestaurantsFilters");
        if (remove == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return remove;
        }
        return Unit.INSTANCE;
    }

    public void saveSelectedCollectionId(int i11) {
        SampleFiltersActivityKt.getCache().put("SelectedCollectionId", Integer.valueOf(i11));
    }

    @Nullable
    public Object saveSelectedCollectionsFilters(@NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation) {
        SampleFiltersActivityKt.getCache().put("SelectedCollectionsFilters", list);
        return Unit.INSTANCE;
    }

    @Nullable
    public Object saveSelectedCollectionsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
        SampleFiltersActivityKt.getCache().put("SelectedCollectionsSortType", sortType);
        return Unit.INSTANCE;
    }

    @Nullable
    public Object saveSelectedRestaurantsFilters(@NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation) {
        SampleFiltersActivityKt.getCache().put("SelectedRestaurantsFilters", list);
        return Unit.INSTANCE;
    }

    @Nullable
    public Object saveSelectedRestaurantsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
        SampleFiltersActivityKt.getCache().put("SelectedRestaurantsSortType", sortType);
        return Unit.INSTANCE;
    }
}
