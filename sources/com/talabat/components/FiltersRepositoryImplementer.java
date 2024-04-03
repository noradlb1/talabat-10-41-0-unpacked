package com.talabat.components;

import buisnessmodels.FilterEngine;
import com.talabat.filters.domain.FiltersRepository;
import com.talabat.filters.domain.UseCasesKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import datamodels.Filter;
import datamodels.Restaurant;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@FiltersIntegrationDsl
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004j\u0004\u0018\u0001`\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00130\u0004j\u0002`\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004j\u0004\u0018\u0001`\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004j\u0004\u0018\u0001`\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004j\u0004\u0018\u0001`\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0011\u0010\u001d\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0011\u0010\u001e\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u001f\u001a\u00020\f2\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\u000f0\u0004j\u0002`\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010$J#\u0010%\u001a\u00020\f2\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\u000f0\u0004j\u0002`\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010$R\u0018\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/talabat/components/FiltersRepositoryImplementer;", "Lcom/talabat/filters/domain/FiltersRepository;", "()V", "_popularSelectedFilters", "", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "popularSelectedCollectionsFilters", "popularSelectedFilters", "getPopularSelectedFilters", "()Ljava/util/List;", "clearPopularCollectionsFilters", "", "clearPopularFilters", "requestAllCollectionsFilters", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAllRestaurants", "Ldatamodels/Restaurant;", "Ldatamodels/Restaurants;", "requestAllRestaurantsFilters", "requestSelectedCollectionsFilters", "requestSelectedCollectionsSortType", "Ldatamodels/filters/SortType;", "requestSelectedPopularCollectionsFilters", "requestSelectedPopularFilters", "requestSelectedRestaurantsFilters", "requestSelectedRestaurantsSortType", "resetSelectedCollectionsFilters", "resetSelectedRestaurantsFilters", "saveSelectedCollectionsFilters", "filters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedCollectionsSortType", "type", "(Ldatamodels/filters/SortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedRestaurantsFilters", "saveSelectedRestaurantsSortType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersRepositoryImplementer implements FiltersRepository {
    @NotNull
    public static final FiltersRepositoryImplementer INSTANCE = new FiltersRepositoryImplementer();
    @NotNull
    private static List<SelectablePopularFilter> _popularSelectedFilters = PopularFilterFactoryKt.makePopularFilters(Integration.getAppContext());
    @NotNull
    private static List<SelectablePopularFilter> popularSelectedCollectionsFilters = PopularFilterFactoryKt.makePopularFilters(Integration.getAppContext());

    private FiltersRepositoryImplementer() {
    }

    private final void clearPopularCollectionsFilters() {
        popularSelectedCollectionsFilters = PopularFilterFactoryKt.makePopularFilters(Integration.getAppContext());
    }

    private final void clearPopularFilters() {
        _popularSelectedFilters = PopularFilterFactoryKt.makePopularFilters(Integration.getAppContext());
    }

    @NotNull
    public final List<SelectablePopularFilter> getPopularSelectedFilters() {
        return _popularSelectedFilters;
    }

    @Nullable
    @FiltersDataSourceApi(version = 2)
    public Object requestAllCollectionSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation) {
        return FiltersRepository.DefaultImpls.requestAllCollectionSelectableSortTypes(this, continuation);
    }

    @Nullable
    public Object requestAllCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return GlobalDataModel.collectionFilters;
    }

    @Nullable
    public Object requestAllRestaurants(@NotNull Continuation<? super List<? extends Restaurant>> continuation) {
        List mutableListOf;
        Restaurant[] restaurantArr = GlobalDataModel.restaurants;
        if (restaurantArr == null || (mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(restaurantArr, restaurantArr.length))) == null) {
            return new ArrayList();
        }
        return mutableListOf;
    }

    @Nullable
    public Object requestAllRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return GlobalDataModel.filters;
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Object requestAllSelectableSortTypes(@NotNull Continuation<? super List<SelectableSortType>> continuation) {
        return FiltersRepository.DefaultImpls.requestAllSelectableSortTypes(this, continuation);
    }

    @Nullable
    @FiltersDataSourceApi(version = 1)
    public Integer requestSelectedCollectionId() {
        return FiltersRepository.DefaultImpls.requestSelectedCollectionId(this);
    }

    @Nullable
    public Object requestSelectedCollectionsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return FilterEngine.getInstance(1).getSelectedFiltersList();
    }

    @Nullable
    public Object requestSelectedCollectionsSortType(@NotNull Continuation<? super SortType> continuation) {
        return UseCasesKt.toSortType(FilterEngine.getInstance(1).getSelectedSortBy());
    }

    @Nullable
    public Object requestSelectedPopularCollectionsFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
        return popularSelectedCollectionsFilters;
    }

    @Nullable
    public Object requestSelectedPopularFilters(@NotNull Continuation<? super List<SelectablePopularFilter>> continuation) {
        return _popularSelectedFilters;
    }

    @Nullable
    public Object requestSelectedRestaurantsFilters(@NotNull Continuation<? super List<? extends Filter>> continuation) {
        return FilterEngine.getInstance(0).getSelectedFiltersList();
    }

    @Nullable
    public Object requestSelectedRestaurantsSortType(@NotNull Continuation<? super SortType> continuation) {
        return UseCasesKt.toSortType(FilterEngine.getInstance(0).getSelectedSortBy());
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
        FiltersRepository.DefaultImpls.saveSelectedCollectionId(this, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object saveSelectedCollectionsFilters(@org.jetbrains.annotations.NotNull java.util.List<? extends datamodels.Filter> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.components.FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.components.FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1 r0 = (com.talabat.components.FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1) r0
            int r1 = r0.f55694k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55694k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.components.FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1 r0 = new com.talabat.components.FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f55692i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55694k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55691h
            buisnessmodels.FilterEngine r5 = (buisnessmodels.FilterEngine) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            buisnessmodels.FilterEngine r6 = buisnessmodels.FilterEngine.getInstance(r3)
            r6.setSelectedFilter((java.util.List<datamodels.Filter>) r5)
            buisnessmodels.FilterEngine r5 = buisnessmodels.FilterEngine.getInstance(r3)
            r0.f55691h = r5
            r0.f55694k = r3
            java.lang.Object r6 = r4.requestAllRestaurants(r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r5 = r5.filterRestaurants(r6)
            com.talabat.helpers.GlobalDataModel.TEMP.collectionFilteredRestaurants = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.components.FiltersRepositoryImplementer.saveSelectedCollectionsFilters(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object saveSelectedCollectionsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
        FilterEngine.getInstance(1).setSelectedSortBy(sortType.getValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object saveSelectedRestaurantsFilters(@org.jetbrains.annotations.NotNull java.util.List<? extends datamodels.Filter> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.components.FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.components.FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1 r0 = (com.talabat.components.FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1) r0
            int r1 = r0.f55698k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55698k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.components.FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1 r0 = new com.talabat.components.FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f55696i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55698k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55695h
            buisnessmodels.FilterEngine r5 = (buisnessmodels.FilterEngine) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 0
            buisnessmodels.FilterEngine r2 = buisnessmodels.FilterEngine.getInstance(r6)
            r2.setSelectedFilter((java.util.List<datamodels.Filter>) r5)
            buisnessmodels.FilterEngine r5 = buisnessmodels.FilterEngine.getInstance(r6)
            r0.f55695h = r5
            r0.f55698k = r3
            java.lang.Object r6 = r4.requestAllRestaurants(r0)
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r5 = r5.filterRestaurants(r6)
            com.talabat.helpers.GlobalDataModel.TEMP.filteredRestaurants = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.components.FiltersRepositoryImplementer.saveSelectedRestaurantsFilters(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object saveSelectedRestaurantsSortType(@NotNull SortType sortType, @NotNull Continuation<? super Unit> continuation) {
        FilterEngine.getInstance(0).setSelectedSortBy(sortType.getValue());
        return Unit.INSTANCE;
    }
}
