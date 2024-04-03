package com.talabat.filters.domain;

import datamodels.Filter;
import datamodels.Restaurant;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003j\u0004\u0018\u0001`\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003j\u0004\u0018\u0001`\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003j\u0004\u0018\u0001`\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0011\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0011\u0010\u001d\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0010H\u0017J#\u0010 \u001a\u00020\u001c2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010%J#\u0010&\u001a\u00020\u001c2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010'\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010%\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/talabat/filters/domain/FiltersRepository;", "", "requestAllCollectionSelectableSortTypes", "", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAllCollectionsFilters", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "requestAllRestaurants", "Ldatamodels/Restaurant;", "Ldatamodels/Restaurants;", "requestAllRestaurantsFilters", "requestAllSelectableSortTypes", "requestSelectedCollectionId", "", "()Ljava/lang/Integer;", "requestSelectedCollectionsFilters", "requestSelectedCollectionsSortType", "Ldatamodels/filters/SortType;", "requestSelectedPopularCollectionsFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "requestSelectedPopularFilters", "requestSelectedRestaurantsFilters", "requestSelectedRestaurantsSortType", "resetSelectedCollectionsFilters", "", "resetSelectedRestaurantsFilters", "saveSelectedCollectionId", "id", "saveSelectedCollectionsFilters", "filters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedCollectionsSortType", "type", "(Ldatamodels/filters/SortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedRestaurantsFilters", "saveSelectedRestaurantsSortType", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FiltersRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        @FiltersDataSourceApi(version = 2)
        public static Object requestAllCollectionSelectableSortTypes(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectableSortType>> continuation) {
            return CollectionsKt__CollectionsKt.listOf(new SelectableSortType(SortType.RECOMMENDATION, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.MIN_ORDER, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.FASTEST_DELIVERY, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.ALPHABETIC, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.RATING, false, (String) null, 4, (DefaultConstructorMarker) null));
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestAllCollectionsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<? extends Filter>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestAllRestaurants(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<? extends Restaurant>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestAllRestaurantsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<? extends Filter>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestAllSelectableSortTypes(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectableSortType>> continuation) {
            return CollectionsKt__CollectionsKt.listOf(new SelectableSortType(SortType.RECOMMENDATION, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.MIN_ORDER, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.FASTEST_DELIVERY, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.ALPHABETIC, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.RATING, false, (String) null, 4, (DefaultConstructorMarker) null));
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Integer requestSelectedCollectionId(@NotNull FiltersRepository filtersRepository) {
            Object obj = FiltersRepositoryKt.getCache().get("KEY_SELECTED_COLLECTION_ID");
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestSelectedCollectionsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<? extends Filter>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestSelectedCollectionsSortType(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super SortType> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestSelectedPopularCollectionsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestSelectedPopularFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestSelectedRestaurantsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<? extends Filter>> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object requestSelectedRestaurantsSortType(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super SortType> continuation) {
            return null;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object resetSelectedCollectionsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object resetSelectedRestaurantsFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @FiltersDataSourceApi(version = 1)
        public static void saveSelectedCollectionId(@NotNull FiltersRepository filtersRepository, int i11) {
            FiltersRepositoryKt.getCache().put("KEY_SELECTED_COLLECTION_ID", Integer.valueOf(i11));
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object saveSelectedCollectionsFilters(@NotNull FiltersRepository filtersRepository, @NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object saveSelectedCollectionsSortType(@NotNull FiltersRepository filtersRepository, @NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object saveSelectedRestaurantsFilters(@NotNull FiltersRepository filtersRepository, @NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Nullable
        @FiltersDataSourceApi(version = 1)
        public static Object saveSelectedRestaurantsSortType(@NotNull FiltersRepository filtersRepository, @NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    }

    @Nullable
    @FiltersDataSourceApi(version = 2)
    Object requestAllCollectionSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestAllCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestAllRestaurants(@NotNull Continuation<? super List<? extends Restaurant>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestAllRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestAllSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Integer requestSelectedCollectionId();

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestSelectedCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestSelectedCollectionsSortType(@NotNull Continuation<? super SortType> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestSelectedPopularCollectionsFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestSelectedPopularFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestSelectedRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object requestSelectedRestaurantsSortType(@NotNull Continuation<? super SortType> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object resetSelectedCollectionsFilters(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object resetSelectedRestaurantsFilters(@NotNull Continuation<? super Unit> continuation);

    @FiltersDataSourceApi(version = 1)
    void saveSelectedCollectionId(int i11);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object saveSelectedCollectionsFilters(@NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object saveSelectedCollectionsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object saveSelectedRestaurantsFilters(@NotNull List<? extends Filter> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    @FiltersDataSourceApi(version = 1)
    Object saveSelectedRestaurantsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation);
}
