package com.talabat.filters.domain;

import com.talabat.filters.FiltersIntegratorKt;
import datamodels.Filter;
import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.Selectables;
import datamodels.filters.SortType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0001\u0010\u0005\u001a\u00020\u00012\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072*\u0010\u000b\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000e0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072*\u0010\u000f\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a³\u0001\u0010\u001e\u001a\u00020\u001a2\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072&\u0010\u001f\u001a\"\b\u0001\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00150\fj\u0002` 0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072*\u0010!\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072,\b\u0002\u0010\"\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\fj\u0004\u0018\u0001`$0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u001b\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010(\u001a\u00020'2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a/\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fj\u0004\u0018\u0001` H@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a!\u0010,\u001a\u00020\n2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a]\u0010.\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fj\u0004\u0018\u0001` 2,\u0010/\u001a(\b\u0001\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\b\u0012\u0006\u0012\u0004\u0018\u00010\n00H@ø\u0001\u0000¢\u0006\u0002\u00101\u001a/\u00102\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fj\u0004\u0018\u0001` H@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a!\u00103\u001a\u00020\n2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010+\u001aE\u00104\u001a\u00020\n2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\f2\"\u0010/\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\b\u0012\u0006\u0012\u0004\u0018\u00010\n00H@ø\u0001\u0000¢\u0006\u0002\u00101\u001a-\u00105\u001a\f\u0012\u0004\u0012\u00020#0\fj\u0002`$2\u0006\u00106\u001a\u00020#2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u00107\u001a\u001e\u00108\u001a\u00020\u0015*\u00020\r2\u0010\u00109\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0002\u001a(\u0010:\u001a\b\u0012\u0004\u0012\u00020#0\f*\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\fj\u0004\u0018\u0001`$2\u0006\u0010;\u001a\u00020<H\u0002\u001a\f\u0010=\u001a\u00020\t*\u00020<H\u0007\u001a(\u0010>\u001a\f\u0012\u0004\u0012\u00020\u00150\fj\u0002` *\f\u0012\u0004\u0012\u00020\u00150\fj\u0002` 2\u0006\u0010?\u001a\u00020<H\u0001\u001a(\u0010@\u001a\f\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011*\f\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u00112\u0006\u0010A\u001a\u00020\u0010H\u0001\u001a1\u0010B\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020D\u0018\u00010\fj\u0004\u0018\u0001`E0C2\u0006\u0010A\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010F\u001a;\u0010G\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020D\u0018\u00010\fj\u0004\u0018\u0001`E0C2\u0006\u0010A\u001a\u00020\r2\b\u0010H\u001a\u0004\u0018\u00010<H@ø\u0001\u0000¢\u0006\u0002\u0010I\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"isCollectionsFilterOrSortTypeSelected", "", "repository", "Lcom/talabat/filters/domain/FiltersRepository;", "(Lcom/talabat/filters/domain/FiltersRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFilterOrSortTypeSelected", "requestSelectedSortType", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Ldatamodels/filters/SortType;", "", "requestSelectedFilters", "", "Ldatamodels/Filter;", "Ldatamodels/Filters;", "requestSelectablePopularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRestaurantsFilterOrSortTypeSelected", "requestAllCollectionsSelectableFilters", "Ldatamodels/filters/SelectableFilter;", "requestAllCollectionsSelectableFiltersBEFiltration", "requestAllRestaurantsSelectableFilters", "requestAllRestaurantsSelectableFiltersBEFiltration", "requestCollectionsSelectables", "Ldatamodels/filters/Selectables;", "requestCollectionsSelectablesBEFiltration", "requestRestaurantsSelectables", "requestRestaurantsSelectablesBEFiltration", "requestSelectables", "requestAllSelectableFilters", "Ldatamodels/SelectableFilters;", "requestSelectablePopularFilter", "requestAllSelectableSortTypes", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSelectedCollectionsSortType", "", "resetSelectedRestaurantsSortType", "saveSelectedCollectionsFilters", "selectableFilters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedCollectionsSortType", "selectableSortTypes", "saveSelectedFilter", "save", "Lkotlin/Function2;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSelectedRestaurantsFilters", "saveSelectedRestaurantsSortType", "saveSelectedSortType", "updateSelectedSort", "selectedSelectableSortType", "(Ldatamodels/filters/SelectableSortType;Lcom/talabat/filters/domain/FiltersRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSelectableFilter", "selectedFilters", "toSelectedSortTypes", "selectedSortType", "", "toSortType", "updateSelectedFilters", "selectedFilterId", "updateSelectedPopularFilters", "filter", "withFilterIds", "Lkotlinx/coroutines/Deferred;", "Ldatamodels/Restaurant;", "Ldatamodels/Restaurants;", "(Lkotlinx/coroutines/Deferred;Ldatamodels/Filter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withFiltersAndCollectionIds", "selectedCollectionId", "(Lkotlinx/coroutines/Deferred;Ldatamodels/Filter;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UseCasesKt {
    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object isCollectionsFilterOrSortTypeSelected(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Boolean> continuation) {
        return isFilterOrSortTypeSelected(new UseCasesKt$isCollectionsFilterOrSortTypeSelected$2(filtersRepository), new UseCasesKt$isCollectionsFilterOrSortTypeSelected$3(filtersRepository), new UseCasesKt$isCollectionsFilterOrSortTypeSelected$4(filtersRepository), continuation);
    }

    public static /* synthetic */ Object isCollectionsFilterOrSortTypeSelected$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return isCollectionsFilterOrSortTypeSelected(filtersRepository, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: datamodels.filters.SelectablePopularFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: datamodels.filters.SelectablePopularFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: datamodels.filters.SelectablePopularFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: datamodels.filters.SelectablePopularFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: datamodels.filters.SelectablePopularFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super java.util.List<datamodels.filters.SelectablePopularFilter>>, ? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super java.util.List<? extends datamodels.Filter>>, ? extends java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @com.talabat.filters.domain.InternalBusinessRule(apiVersion = 1)
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object isFilterOrSortTypeSelected(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super datamodels.filters.SortType>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super java.util.List<? extends datamodels.Filter>>, ? extends java.lang.Object> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super java.util.List<datamodels.filters.SelectablePopularFilter>>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            boolean r0 = r10 instanceof com.talabat.filters.domain.UseCasesKt$isFilterOrSortTypeSelected$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.filters.domain.UseCasesKt$isFilterOrSortTypeSelected$1 r0 = (com.talabat.filters.domain.UseCasesKt$isFilterOrSortTypeSelected$1) r0
            int r1 = r0.f59466k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59466k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.domain.UseCasesKt$isFilterOrSortTypeSelected$1 r0 = new com.talabat.filters.domain.UseCasesKt$isFilterOrSortTypeSelected$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f59465j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59466k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.f59464i
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.f59463h
            datamodels.filters.SortType r8 = (datamodels.filters.SortType) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008e
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            java.lang.Object r7 = r0.f59464i
            datamodels.filters.SortType r7 = (datamodels.filters.SortType) r7
            java.lang.Object r8 = r0.f59463h
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007c
        L_0x004b:
            java.lang.Object r7 = r0.f59464i
            r9 = r7
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r7 = r0.f59463h
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.f59463h = r8
            r0.f59464i = r9
            r0.f59466k = r5
            java.lang.Object r10 = r7.invoke(r0)
            if (r10 != r1) goto L_0x0069
            return r1
        L_0x0069:
            datamodels.filters.SortType r10 = (datamodels.filters.SortType) r10
            r0.f59463h = r9
            r0.f59464i = r10
            r0.f59466k = r4
            java.lang.Object r7 = r8.invoke(r0)
            if (r7 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r8 = r9
            r6 = r10
            r10 = r7
            r7 = r6
        L_0x007c:
            r9 = r10
            java.util.List r9 = (java.util.List) r9
            r0.f59463h = r7
            r0.f59464i = r9
            r0.f59466k = r3
            java.lang.Object r10 = r8.invoke(r0)
            if (r10 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r8 = r7
            r7 = r9
        L_0x008e:
            java.util.List r10 = (java.util.List) r10
            r9 = 0
            if (r10 == 0) goto L_0x00af
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0099:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x00ad
            java.lang.Object r0 = r10.next()
            r1 = r0
            datamodels.filters.SelectablePopularFilter r1 = (datamodels.filters.SelectablePopularFilter) r1
            boolean r1 = r1.isOn()
            if (r1 == 0) goto L_0x0099
            r9 = r0
        L_0x00ad:
            datamodels.filters.SelectablePopularFilter r9 = (datamodels.filters.SelectablePopularFilter) r9
        L_0x00af:
            datamodels.filters.SortType r10 = datamodels.filters.SortType.RECOMMENDATION
            if (r8 == r10) goto L_0x00b5
            if (r8 != 0) goto L_0x00ca
        L_0x00b5:
            java.util.Collection r7 = (java.util.Collection) r7
            r8 = 0
            if (r7 == 0) goto L_0x00c3
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r7 = r8
            goto L_0x00c4
        L_0x00c3:
            r7 = r5
        L_0x00c4:
            if (r7 == 0) goto L_0x00ca
            if (r9 == 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r5 = r8
        L_0x00ca:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt.isFilterOrSortTypeSelected(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object isRestaurantsFilterOrSortTypeSelected(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Boolean> continuation) {
        return isFilterOrSortTypeSelected(new UseCasesKt$isRestaurantsFilterOrSortTypeSelected$2(filtersRepository), new UseCasesKt$isRestaurantsFilterOrSortTypeSelected$3(filtersRepository), new UseCasesKt$isRestaurantsFilterOrSortTypeSelected$4(filtersRepository), continuation);
    }

    public static /* synthetic */ Object isRestaurantsFilterOrSortTypeSelected$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return isRestaurantsFilterOrSortTypeSelected(filtersRepository, continuation);
    }

    @InternalBusinessRule(apiVersion = 1)
    @Nullable
    public static final Object requestAllCollectionsSelectableFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectableFilter>> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new UseCasesKt$requestAllCollectionsSelectableFilters$2$1(filtersRepository, (Continuation<? super UseCasesKt$requestAllCollectionsSelectableFilters$2$1>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : (List) coroutineScope;
    }

    @InternalBusinessRule(apiVersion = 2)
    @Nullable
    public static final Object requestAllCollectionsSelectableFiltersBEFiltration(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectableFilter>> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1(filtersRepository, (Continuation<? super UseCasesKt$requestAllCollectionsSelectableFiltersBEFiltration$2$1>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : (List) coroutineScope;
    }

    @InternalBusinessRule(apiVersion = 1)
    @Nullable
    public static final Object requestAllRestaurantsSelectableFilters(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectableFilter>> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new UseCasesKt$requestAllRestaurantsSelectableFilters$2$1(filtersRepository, (Continuation<? super UseCasesKt$requestAllRestaurantsSelectableFilters$2$1>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : (List) coroutineScope;
    }

    @InternalBusinessRule(apiVersion = 2)
    @Nullable
    public static final Object requestAllRestaurantsSelectableFiltersBEFiltration(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super List<SelectableFilter>> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1(filtersRepository, (Continuation<? super UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : (List) coroutineScope;
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object requestCollectionsSelectables(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Selectables> continuation) {
        return requestSelectables$default(new UseCasesKt$requestCollectionsSelectables$2(filtersRepository), new UseCasesKt$requestCollectionsSelectables$4(filtersRepository, (Continuation<? super UseCasesKt$requestCollectionsSelectables$4>) null), new UseCasesKt$requestCollectionsSelectables$3(filtersRepository), (Function1) null, continuation, 8, (Object) null);
    }

    public static /* synthetic */ Object requestCollectionsSelectables$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return requestCollectionsSelectables(filtersRepository, continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 2)
    public static final Object requestCollectionsSelectablesBEFiltration(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Selectables> continuation) {
        return requestSelectables$default(new UseCasesKt$requestCollectionsSelectablesBEFiltration$2(filtersRepository), new UseCasesKt$requestCollectionsSelectablesBEFiltration$4(filtersRepository, (Continuation<? super UseCasesKt$requestCollectionsSelectablesBEFiltration$4>) null), new UseCasesKt$requestCollectionsSelectablesBEFiltration$3(filtersRepository), (Function1) null, continuation, 8, (Object) null);
    }

    public static /* synthetic */ Object requestCollectionsSelectablesBEFiltration$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return requestCollectionsSelectablesBEFiltration(filtersRepository, continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object requestRestaurantsSelectables(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Selectables> continuation) {
        return requestSelectables$default(new UseCasesKt$requestRestaurantsSelectables$2(filtersRepository), new UseCasesKt$requestRestaurantsSelectables$4(filtersRepository, (Continuation<? super UseCasesKt$requestRestaurantsSelectables$4>) null), new UseCasesKt$requestRestaurantsSelectables$3(filtersRepository), (Function1) null, continuation, 8, (Object) null);
    }

    public static /* synthetic */ Object requestRestaurantsSelectables$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return requestRestaurantsSelectables(filtersRepository, continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 2)
    public static final Object requestRestaurantsSelectablesBEFiltration(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Selectables> continuation) {
        return requestSelectables$default(new UseCasesKt$requestRestaurantsSelectablesBEFiltration$2(filtersRepository), new UseCasesKt$requestRestaurantsSelectablesBEFiltration$4(filtersRepository, (Continuation<? super UseCasesKt$requestRestaurantsSelectablesBEFiltration$4>) null), new UseCasesKt$requestRestaurantsSelectablesBEFiltration$3(filtersRepository), (Function1) null, continuation, 8, (Object) null);
    }

    public static /* synthetic */ Object requestRestaurantsSelectablesBEFiltration$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return requestRestaurantsSelectablesBEFiltration(filtersRepository, continuation);
    }

    @InternalBusinessRule(apiVersion = 1)
    @Nullable
    public static final Object requestSelectables(@NotNull Function1<? super Continuation<? super SortType>, ? extends Object> function1, @NotNull Function1<? super Continuation<? super List<SelectableFilter>>, ? extends Object> function12, @NotNull Function1<? super Continuation<? super List<SelectablePopularFilter>>, ? extends Object> function13, @NotNull Function1<? super Continuation<? super List<SelectableSortType>>, ? extends Object> function14, @NotNull Continuation<? super Selectables> continuation) {
        return CoroutineScopeKt.coroutineScope(new UseCasesKt$requestSelectables$3(function12, function1, function14, function13, (Continuation<? super UseCasesKt$requestSelectables$3>) null), continuation);
    }

    public static /* synthetic */ Object requestSelectables$default(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Continuation continuation, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function14 = new UseCasesKt$requestSelectables$2((Continuation<? super UseCasesKt$requestSelectables$2>) null);
        }
        return requestSelectables(function1, function12, function13, function14, continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object resetSelectedCollectionsSortType(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Unit> continuation) {
        Object saveSelectedCollectionsSortType = filtersRepository.saveSelectedCollectionsSortType(SortType.RECOMMENDATION, continuation);
        return saveSelectedCollectionsSortType == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? saveSelectedCollectionsSortType : Unit.INSTANCE;
    }

    public static /* synthetic */ Object resetSelectedCollectionsSortType$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return resetSelectedCollectionsSortType(filtersRepository, continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object resetSelectedRestaurantsSortType(@NotNull FiltersRepository filtersRepository, @NotNull Continuation<? super Unit> continuation) {
        Object saveSelectedRestaurantsSortType = filtersRepository.saveSelectedRestaurantsSortType(SortType.RECOMMENDATION, continuation);
        return saveSelectedRestaurantsSortType == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? saveSelectedRestaurantsSortType : Unit.INSTANCE;
    }

    public static /* synthetic */ Object resetSelectedRestaurantsSortType$default(FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return resetSelectedRestaurantsSortType(filtersRepository, continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object saveSelectedCollectionsFilters(@Nullable List<SelectableFilter> list, @NotNull Continuation<? super List<? extends Filter>> continuation) {
        return saveSelectedFilter(list, new UseCasesKt$saveSelectedCollectionsFilters$2((Continuation<? super UseCasesKt$saveSelectedCollectionsFilters$2>) null), continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object saveSelectedCollectionsSortType(@Nullable List<SelectableSortType> list, @NotNull Continuation<Object> continuation) {
        return saveSelectedSortType(list, new UseCasesKt$saveSelectedCollectionsSortType$2((Continuation<? super UseCasesKt$saveSelectedCollectionsSortType$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @com.talabat.filters.domain.InternalBusinessRule(apiVersion = 1)
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object saveSelectedFilter(@org.jetbrains.annotations.Nullable java.util.List<datamodels.filters.SelectableFilter> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.util.List<? extends datamodels.Filter>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends datamodels.Filter>> r7) {
        /*
            boolean r0 = r7 instanceof com.talabat.filters.domain.UseCasesKt$saveSelectedFilter$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.filters.domain.UseCasesKt$saveSelectedFilter$1 r0 = (com.talabat.filters.domain.UseCasesKt$saveSelectedFilter$1) r0
            int r1 = r0.f59543j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59543j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.domain.UseCasesKt$saveSelectedFilter$1 r0 = new com.talabat.filters.domain.UseCasesKt$saveSelectedFilter$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f59542i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59543j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f59541h
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x008b
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r5 == 0) goto L_0x008a
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0045:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r5.next()
            r4 = r2
            datamodels.filters.SelectableFilter r4 = (datamodels.filters.SelectableFilter) r4
            boolean r4 = r4.isOn()
            if (r4 == 0) goto L_0x0045
            r7.add(r2)
            goto L_0x0045
        L_0x005c:
            java.util.ArrayList r5 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r2)
            r5.<init>(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x006b:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x007f
            java.lang.Object r2 = r7.next()
            datamodels.filters.SelectableFilter r2 = (datamodels.filters.SelectableFilter) r2
            datamodels.Filter r2 = r2.getFilter()
            r5.add(r2)
            goto L_0x006b
        L_0x007f:
            r0.f59541h = r5
            r0.f59543j = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L_0x008b
            return r1
        L_0x008a:
            r5 = 0
        L_0x008b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt.saveSelectedFilter(java.util.List, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object saveSelectedRestaurantsFilters(@Nullable List<SelectableFilter> list, @NotNull Continuation<? super List<? extends Filter>> continuation) {
        return saveSelectedFilter(list, new UseCasesKt$saveSelectedRestaurantsFilters$2((Continuation<? super UseCasesKt$saveSelectedRestaurantsFilters$2>) null), continuation);
    }

    @Nullable
    @BusinessRule(apiVersion = 1)
    public static final Object saveSelectedRestaurantsSortType(@Nullable List<SelectableSortType> list, @NotNull Continuation<Object> continuation) {
        return saveSelectedSortType(list, new UseCasesKt$saveSelectedRestaurantsSortType$2((Continuation<? super UseCasesKt$saveSelectedRestaurantsSortType$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @com.talabat.filters.domain.InternalBusinessRule(apiVersion = 1)
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object saveSelectedSortType(@org.jetbrains.annotations.Nullable java.util.List<datamodels.filters.SelectableSortType> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super datamodels.filters.SortType, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            boolean r0 = r8 instanceof com.talabat.filters.domain.UseCasesKt$saveSelectedSortType$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.filters.domain.UseCasesKt$saveSelectedSortType$1 r0 = (com.talabat.filters.domain.UseCasesKt$saveSelectedSortType$1) r0
            int r1 = r0.f59551k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59551k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.domain.UseCasesKt$saveSelectedSortType$1 r0 = new com.talabat.filters.domain.UseCasesKt$saveSelectedSortType$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f59550j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59551k
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x008a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.f59549i
            datamodels.filters.SortType r6 = (datamodels.filters.SortType) r6
            java.lang.Object r7 = r0.f59548h
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0078
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 == 0) goto L_0x007b
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x004c:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0060
            java.lang.Object r8 = r6.next()
            r2 = r8
            datamodels.filters.SelectableSortType r2 = (datamodels.filters.SelectableSortType) r2
            boolean r2 = r2.isOn()
            if (r2 == 0) goto L_0x004c
            goto L_0x0061
        L_0x0060:
            r8 = r5
        L_0x0061:
            datamodels.filters.SelectableSortType r8 = (datamodels.filters.SelectableSortType) r8
            if (r8 == 0) goto L_0x007b
            datamodels.filters.SortType r6 = r8.getType()
            if (r6 == 0) goto L_0x007b
            r0.f59548h = r7
            r0.f59549i = r6
            r0.f59551k = r4
            java.lang.Object r8 = r7.invoke(r6, r0)
            if (r8 != r1) goto L_0x0078
            return r1
        L_0x0078:
            if (r6 == 0) goto L_0x007b
            goto L_0x008c
        L_0x007b:
            datamodels.filters.SortType r6 = datamodels.filters.SortType.RECOMMENDATION
            r0.f59548h = r5
            r0.f59549i = r5
            r0.f59551k = r3
            java.lang.Object r6 = r7.invoke(r6, r0)
            if (r6 != r1) goto L_0x008a
            return r1
        L_0x008a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x008c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt.saveSelectedSortType(java.util.List, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final SelectableFilter toSelectableFilter(Filter filter, List<? extends Filter> list) {
        boolean z11;
        Iterable iterable = list;
        boolean z12 = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Filter) it.next()).getId() == filter.getId()) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        z12 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return new SelectableFilter(filter, z12);
    }

    /* access modifiers changed from: private */
    public static final List<SelectableSortType> toSelectedSortTypes(List<SelectableSortType> list, int i11) {
        boolean z11;
        if (list == null) {
            return new ArrayList();
        }
        Iterable<SelectableSortType> iterable = list;
        for (SelectableSortType selectableSortType : iterable) {
            if (selectableSortType.getType().getValue() == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            selectableSortType.setOn(z11);
        }
        return (List) iterable;
    }

    @NotNull
    @BusinessRule(apiVersion = 1)
    public static final SortType toSortType(int i11) {
        if (i11 == 0) {
            return SortType.ALPHABETIC;
        }
        if (i11 == 1) {
            return SortType.RATING;
        }
        if (i11 == 3) {
            return SortType.MIN_ORDER;
        }
        if (i11 != 5) {
            return SortType.RECOMMENDATION;
        }
        return SortType.FASTEST_DELIVERY;
    }

    @NotNull
    @BusinessRule(apiVersion = 1)
    public static final List<SelectableFilter> updateSelectedFilters(@NotNull List<SelectableFilter> list, int i11) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<SelectableFilter> iterable = list;
        for (SelectableFilter selectableFilter : iterable) {
            if (selectableFilter.getFilter().getId() == i11) {
                selectableFilter.setOn(!selectableFilter.isOn());
            }
        }
        return (List) iterable;
    }

    @NotNull
    @BusinessRule(apiVersion = 1)
    public static final List<SelectablePopularFilter> updateSelectedPopularFilters(@NotNull List<SelectablePopularFilter> list, @NotNull SelectablePopularFilter selectablePopularFilter) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(selectablePopularFilter, "filter");
        Iterable<SelectablePopularFilter> iterable = list;
        for (SelectablePopularFilter selectablePopularFilter2 : iterable) {
            if (Intrinsics.areEqual((Object) selectablePopularFilter2, (Object) selectablePopularFilter)) {
                selectablePopularFilter2.setOn(!selectablePopularFilter2.isOn());
            }
        }
        return (List) iterable;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: datamodels.filters.SelectableSortType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: datamodels.filters.SelectableSortType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: datamodels.filters.SelectableSortType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: datamodels.filters.SelectableSortType} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0061 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c A[EDGE_INSN: B:39:0x008c->B:33:0x008c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    @com.talabat.filters.domain.BusinessRule(apiVersion = 1)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object updateSelectedSort(@org.jetbrains.annotations.NotNull datamodels.filters.SelectableSortType r6, @org.jetbrains.annotations.NotNull com.talabat.filters.domain.FiltersRepository r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<datamodels.filters.SelectableSortType>> r8) {
        /*
            boolean r0 = r8 instanceof com.talabat.filters.domain.UseCasesKt$updateSelectedSort$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.filters.domain.UseCasesKt$updateSelectedSort$1 r0 = (com.talabat.filters.domain.UseCasesKt$updateSelectedSort$1) r0
            int r1 = r0.f59554j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59554j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.domain.UseCasesKt$updateSelectedSort$1 r0 = new com.talabat.filters.domain.UseCasesKt$updateSelectedSort$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f59553i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59554j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f59552h
            datamodels.filters.SelectableSortType r6 = (datamodels.filters.SelectableSortType) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.f59552h = r6
            r0.f59554j = r3
            java.lang.Object r8 = r7.requestAllSelectableSortTypes(r0)
            if (r8 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r7 = r8
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r0 = r7.iterator()
        L_0x004c:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0061
            java.lang.Object r1 = r0.next()
            r4 = r1
            datamodels.filters.SelectableSortType r4 = (datamodels.filters.SelectableSortType) r4
            boolean r4 = r4.isOn()
            if (r4 == 0) goto L_0x004c
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            datamodels.filters.SelectableSortType r1 = (datamodels.filters.SelectableSortType) r1
            r0 = 0
            if (r1 != 0) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            r1.setOn(r0)
        L_0x006b:
            java.util.Iterator r7 = r7.iterator()
        L_0x006f:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008c
            java.lang.Object r1 = r7.next()
            r4 = r1
            datamodels.filters.SelectableSortType r4 = (datamodels.filters.SelectableSortType) r4
            datamodels.filters.SortType r4 = r4.getType()
            datamodels.filters.SortType r5 = r6.getType()
            if (r4 != r5) goto L_0x0088
            r4 = r3
            goto L_0x0089
        L_0x0088:
            r4 = r0
        L_0x0089:
            if (r4 == 0) goto L_0x006f
            r2 = r1
        L_0x008c:
            datamodels.filters.SelectableSortType r2 = (datamodels.filters.SelectableSortType) r2
            if (r2 != 0) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r2.setOn(r3)
        L_0x0094:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt.updateSelectedSort(datamodels.filters.SelectableSortType, com.talabat.filters.domain.FiltersRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object updateSelectedSort$default(SelectableSortType selectableSortType, FiltersRepository filtersRepository, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            filtersRepository = FiltersIntegratorKt.getRepository();
        }
        return updateSelectedSort(selectableSortType, filtersRepository, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: datamodels.Filter} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A[EDGE_INSN: B:27:0x0059->B:19:0x0059 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object withFilterIds(kotlinx.coroutines.Deferred<? extends java.util.List<? extends datamodels.Restaurant>> r4, datamodels.Filter r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof com.talabat.filters.domain.UseCasesKt$withFilterIds$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.filters.domain.UseCasesKt$withFilterIds$1 r0 = (com.talabat.filters.domain.UseCasesKt$withFilterIds$1) r0
            int r1 = r0.f59557j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59557j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.domain.UseCasesKt$withFilterIds$1 r0 = new com.talabat.filters.domain.UseCasesKt$withFilterIds$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59556i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59557j
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.f59555h
            r5 = r4
            datamodels.Filter r5 = (datamodels.Filter) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0.f59555h = r5
            r0.f59557j = r3
            java.lang.Object r6 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r4, r6, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r4 = r6 instanceof java.util.Collection
            r0 = 0
            if (r4 == 0) goto L_0x005b
            r4 = r6
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x005b
        L_0x0059:
            r3 = r0
            goto L_0x007b
        L_0x005b:
            java.util.Iterator r4 = r6.iterator()
        L_0x005f:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r4.next()
            datamodels.Restaurant r6 = (datamodels.Restaurant) r6
            java.util.ArrayList<java.lang.Integer> r6 = r6.filtersId
            int r1 = r5.getId()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            boolean r6 = r6.contains(r1)
            if (r6 == 0) goto L_0x005f
        L_0x007b:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt.withFilterIds(kotlinx.coroutines.Deferred, datamodels.Filter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: datamodels.Filter} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object withFiltersAndCollectionIds(kotlinx.coroutines.Deferred<? extends java.util.List<? extends datamodels.Restaurant>> r4, datamodels.Filter r5, java.lang.Integer r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof com.talabat.filters.domain.UseCasesKt$withFiltersAndCollectionIds$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.filters.domain.UseCasesKt$withFiltersAndCollectionIds$1 r0 = (com.talabat.filters.domain.UseCasesKt$withFiltersAndCollectionIds$1) r0
            int r1 = r0.f59561k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59561k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.domain.UseCasesKt$withFiltersAndCollectionIds$1 r0 = new com.talabat.filters.domain.UseCasesKt$withFiltersAndCollectionIds$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f59560j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59561k
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.f59559i
            r6 = r4
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.Object r4 = r0.f59558h
            r5 = r4
            datamodels.Filter r5 = (datamodels.Filter) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0050
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.f59558h = r5
            r0.f59559i = r6
            r0.f59561k = r3
            java.lang.Object r7 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r4, r7, r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x005b:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0074
            java.lang.Object r0 = r7.next()
            r1 = r0
            datamodels.Restaurant r1 = (datamodels.Restaurant) r1
            java.util.ArrayList<java.lang.Integer> r1 = r1.filtersId
            boolean r1 = r1.contains(r6)
            if (r1 == 0) goto L_0x005b
            r4.add(r0)
            goto L_0x005b
        L_0x0074:
            boolean r6 = r4.isEmpty()
            r7 = 0
            if (r6 == 0) goto L_0x007d
        L_0x007b:
            r3 = r7
            goto L_0x009d
        L_0x007d:
            java.util.Iterator r4 = r4.iterator()
        L_0x0081:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x007b
            java.lang.Object r6 = r4.next()
            datamodels.Restaurant r6 = (datamodels.Restaurant) r6
            java.util.ArrayList<java.lang.Integer> r6 = r6.filtersId
            int r0 = r5.getId()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            boolean r6 = r6.contains(r0)
            if (r6 == 0) goto L_0x0081
        L_0x009d:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt.withFiltersAndCollectionIds(kotlinx.coroutines.Deferred, datamodels.Filter, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
