package com.talabat.collectiondetails.ui.quickfilter;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.collectiondetails.data.CollectionsDataSource;
import com.talabat.collectiondetails.data.FiltersDataSource;
import com.talabat.collectiondetails.data.RestaurantsDataSource;
import com.talabat.collectiondetails.helpers.PopularFilterHelper;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import datamodels.filters.SelectablePopularFilter;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CuisinesContainer;
import library.talabat.com.talabatlib.FiltersContainer;
import library.talabat.com.talabatlib.Sort;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wf.a;
import wf.b;
import wf.c;
import wf.d;
import wf.e;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J(\u0010\u0018\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J\u001e\u0010\u001d\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J0\u0010\u001e\u001a\u00020\u00192\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020!0 j\u0002`\"2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J4\u0010#\u001a\u00020\u00192\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0018\u00010 j\u0004\u0018\u0001`\"2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0018\u00010 j\u0004\u0018\u0001`\"H\u0002J\b\u0010&\u001a\u00020\u0019H\u0016R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterBEFiltrationInteractor;", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsInteractor;", "termsDataSource", "Lcom/talabat/collectiondetails/data/TermsDataSource;", "restaurantsDatasource", "Lcom/talabat/collectiondetails/data/RestaurantsDataSource;", "abDatasource", "Lcom/talabat/collectiondetails/data/AbDataSource;", "menuDataSource", "Lcom/talabat/collectiondetails/data/MenuDataSource;", "filtersDataSource", "Lcom/talabat/collectiondetails/data/FiltersDataSource;", "collectionsDataSource", "Lcom/talabat/collectiondetails/data/CollectionsDataSource;", "quickFilter", "Ldatamodels/QuickFilter;", "io", "Lio/reactivex/Scheduler;", "main", "(Lcom/talabat/collectiondetails/data/TermsDataSource;Lcom/talabat/collectiondetails/data/RestaurantsDataSource;Lcom/talabat/collectiondetails/data/AbDataSource;Lcom/talabat/collectiondetails/data/MenuDataSource;Lcom/talabat/collectiondetails/data/FiltersDataSource;Lcom/talabat/collectiondetails/data/CollectionsDataSource;Ldatamodels/QuickFilter;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "collection", "cuisines", "", "Ldatamodels/Cuisine;", "getRestaurantsForCollection", "", "listener", "Lkotlin/Function1;", "Ldatamodels/RestaurantListModel;", "handleCuisineSelection", "handleFilterSelection", "selectablePopularFilters", "", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "handleFiltering", "makeAllSelectedFilters", "", "updateCuisines", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuickFilterBEFiltrationInteractor extends QuickFilterRestaurantsInteractor {
    @Nullable
    private QuickFilter collection;
    @NotNull
    private CollectionsDataSource collectionsDataSource;
    @NotNull
    private List<Cuisine> cuisines;
    @NotNull
    private final FiltersDataSource filtersDataSource;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuickFilterBEFiltrationInteractor(com.talabat.collectiondetails.data.TermsDataSource r14, com.talabat.collectiondetails.data.RestaurantsDataSource r15, com.talabat.collectiondetails.data.AbDataSource r16, com.talabat.collectiondetails.data.MenuDataSource r17, com.talabat.collectiondetails.data.FiltersDataSource r18, com.talabat.collectiondetails.data.CollectionsDataSource r19, datamodels.QuickFilter r20, io.reactivex.Scheduler r21, io.reactivex.Scheduler r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0011
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r2 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r11 = r1
            goto L_0x0013
        L_0x0011:
            r11 = r21
        L_0x0013:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0022
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r12 = r0
            goto L_0x0024
        L_0x0022:
            r12 = r22
        L_0x0024:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterBEFiltrationInteractor.<init>(com.talabat.collectiondetails.data.TermsDataSource, com.talabat.collectiondetails.data.RestaurantsDataSource, com.talabat.collectiondetails.data.AbDataSource, com.talabat.collectiondetails.data.MenuDataSource, com.talabat.collectiondetails.data.FiltersDataSource, com.talabat.collectiondetails.data.CollectionsDataSource, datamodels.QuickFilter, io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsForCollection$lambda-0  reason: not valid java name */
    public static final Pair m9543getRestaurantsForCollection$lambda0(List list, VendorTagsResponse vendorTagsResponse) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        Intrinsics.checkNotNullParameter(vendorTagsResponse, "vendorTags");
        return new Pair(list, vendorTagsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsForCollection$lambda-3  reason: not valid java name */
    public static final void m9544getRestaurantsForCollection$lambda3(QuickFilterBEFiltrationInteractor quickFilterBEFiltrationInteractor, Function1 function1, Pair pair) {
        ArrayList<Filter> arrayList;
        List list;
        ArrayList<Filter> popular;
        ArrayList<Filter> popular2;
        ArrayList<Cuisine> all;
        Intrinsics.checkNotNullParameter(quickFilterBEFiltrationInteractor, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$listener");
        RestaurantsDataSource x11 = quickFilterBEFiltrationInteractor.x();
        FiltersContainer filters = ((VendorTagsResponse) pair.getSecond()).getFilters();
        if (filters != null) {
            arrayList = filters.getAll();
        } else {
            arrayList = null;
        }
        x11.updateGlobalDataCollectionFilters(arrayList);
        quickFilterBEFiltrationInteractor.cuisines.clear();
        CuisinesContainer cuisines2 = ((VendorTagsResponse) pair.getSecond()).getCuisines();
        if (!(cuisines2 == null || (all = cuisines2.getAll()) == null)) {
            quickFilterBEFiltrationInteractor.cuisines.addAll(all);
        }
        RestaurantListModel restaurantListModel = new RestaurantListModel();
        restaurantListModel.setIsCollection(true);
        FiltersDataSource filtersDataSource2 = quickFilterBEFiltrationInteractor.filtersDataSource;
        List<Sort> sorting = ((VendorTagsResponse) pair.getSecond()).getSorting();
        if (sorting == null) {
            sorting = CollectionsKt__CollectionsKt.emptyList();
        }
        filtersDataSource2.saveCollectionsSortingTypes(sorting);
        FiltersContainer filters2 = ((VendorTagsResponse) pair.getSecond()).getFilters();
        if (!(filters2 == null || (popular2 = filters2.getPopular()) == null)) {
            for (Filter filter : popular2) {
                filter.setName(PopularFilterHelper.Companion.getTranslatedFilterName(filter));
            }
        }
        FiltersDataSource filtersDataSource3 = quickFilterBEFiltrationInteractor.filtersDataSource;
        FiltersContainer filters3 = ((VendorTagsResponse) pair.getSecond()).getFilters();
        if (filters3 == null || (popular = filters3.getPopular()) == null || (list = CollectionsKt___CollectionsKt.toList(popular)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        filtersDataSource3.saveCollectionsPopularFilters(list);
        restaurantListModel.createNewRestautantList((List) pair.getFirst());
        quickFilterBEFiltrationInteractor.y(restaurantListModel);
        quickFilterBEFiltrationInteractor.z(restaurantListModel.getAllRestaurants());
        function1.invoke(restaurantListModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsForCollection$lambda-4  reason: not valid java name */
    public static final void m9545getRestaurantsForCollection$lambda4(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        function1.invoke(null);
    }

    private final void handleFiltering(List<SelectablePopularFilter> list, Function1<? super RestaurantListModel, Unit> function1) {
        int i11;
        Integer id2;
        CompositeDisposable u11 = u();
        CollectionsDataSource collectionsDataSource2 = this.collectionsDataSource;
        QuickFilter quickFilter = this.collection;
        if (quickFilter == null || (id2 = quickFilter.getId()) == null) {
            i11 = 0;
        } else {
            i11 = id2.intValue();
        }
        ArrayList<Cuisine> selectedCuisines = this.filtersDataSource.getSelectedCuisines();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedCuisines, 10));
        for (Cuisine cuisine : selectedCuisines) {
            arrayList.add(Integer.valueOf(cuisine.f13848id));
        }
        u11.add(collectionsDataSource2.applyFilteringAndSorting(i11, arrayList, makeAllSelectedFilters(list), this.filtersDataSource.getSorting()).subscribeOn(v()).observeOn(w()).subscribe(new a(function1), new b(function1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFiltering$lambda-6  reason: not valid java name */
    public static final void m9546handleFiltering$lambda6(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        RestaurantListModel restaurantListModel = new RestaurantListModel();
        restaurantListModel.setIsCollection(true);
        restaurantListModel.createNewRestautantList(list);
        function1.invoke(restaurantListModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFiltering$lambda-7  reason: not valid java name */
    public static final void m9547handleFiltering$lambda7(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        function1.invoke(null);
    }

    private final List<Integer> makeAllSelectedFilters(List<SelectablePopularFilter> list) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        List<Filter> selectedFilters = this.filtersDataSource.getSelectedFilters();
        if (selectedFilters != null) {
            for (Filter id2 : selectedFilters) {
                arrayList.add(Integer.valueOf(id2.getId()));
            }
        }
        if (list != null) {
            ArrayList<SelectablePopularFilter> arrayList2 = new ArrayList<>();
            for (Object next : list) {
                if (((SelectablePopularFilter) next).getFilter().getId() != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    arrayList2.add(next);
                }
            }
            for (SelectablePopularFilter filter : arrayList2) {
                arrayList.add(Integer.valueOf(filter.getFilter().getId()));
            }
        }
        return arrayList;
    }

    public void getRestaurantsForCollection(@Nullable QuickFilter quickFilter, @NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Integer num;
        int i11;
        Integer id2;
        Integer id3;
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (quickFilter != null) {
            num = quickFilter.getId();
        } else {
            num = null;
        }
        if (num != null) {
            z(new ArrayList());
            this.collection = quickFilter;
            CompositeDisposable u11 = u();
            CollectionsDataSource collectionsDataSource2 = this.collectionsDataSource;
            QuickFilter quickFilter2 = this.collection;
            int i12 = 0;
            if (quickFilter2 == null || (id3 = quickFilter2.getId()) == null) {
                i11 = 0;
            } else {
                i11 = id3.intValue();
            }
            Single<List<Restaurant>> allVendorsForCollection = collectionsDataSource2.getAllVendorsForCollection(i11);
            CollectionsDataSource collectionsDataSource3 = this.collectionsDataSource;
            QuickFilter quickFilter3 = this.collection;
            if (!(quickFilter3 == null || (id2 = quickFilter3.getId()) == null)) {
                i12 = id2.intValue();
            }
            u11.add(Single.zip(allVendorsForCollection, collectionsDataSource3.getVendorTagsForCollection(i12), new c()).subscribeOn(v()).observeOn(w()).subscribe(new d(this, function1), new e(function1)));
        }
    }

    public void handleCuisineSelection(@NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        handleFiltering((List<SelectablePopularFilter>) null, function1);
    }

    public void handleFilterSelection(@NotNull List<SelectablePopularFilter> list, @NotNull Function1<? super RestaurantListModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "selectablePopularFilters");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        handleFiltering(list, function1);
    }

    public void updateCuisines() {
        x().updateCollectionCuisines(this.cuisines);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QuickFilterBEFiltrationInteractor(@org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.TermsDataSource r17, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.RestaurantsDataSource r18, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.AbDataSource r19, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.MenuDataSource r20, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.FiltersDataSource r21, @org.jetbrains.annotations.NotNull com.talabat.collectiondetails.data.CollectionsDataSource r22, @org.jetbrains.annotations.NotNull datamodels.QuickFilter r23, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r24, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r25) {
        /*
            r16 = this;
            r13 = r16
            r14 = r21
            r15 = r22
            java.lang.String r0 = "termsDataSource"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "restaurantsDatasource"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "abDatasource"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "menuDataSource"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "filtersDataSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "collectionsDataSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "quickFilter"
            r5 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "io"
            r6 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "main"
            r7 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 896(0x380, float:1.256E-42)
            r12 = 0
            r0 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.filtersDataSource = r14
            r13.collectionsDataSource = r15
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13.cuisines = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.collectiondetails.ui.quickfilter.QuickFilterBEFiltrationInteractor.<init>(com.talabat.collectiondetails.data.TermsDataSource, com.talabat.collectiondetails.data.RestaurantsDataSource, com.talabat.collectiondetails.data.AbDataSource, com.talabat.collectiondetails.data.MenuDataSource, com.talabat.collectiondetails.data.FiltersDataSource, com.talabat.collectiondetails.data.CollectionsDataSource, datamodels.QuickFilter, io.reactivex.Scheduler, io.reactivex.Scheduler):void");
    }
}
