package com.talabat.restaurants.v1;

import JsonModels.PolygonEvents;
import JsonModels.RestaurantListJM;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.collectiondetails.helpers.PopularFilterHelper;
import com.talabat.filters.storage.FiltersInMemoryCache;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.v2.data.vendors.FilterParams;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCase;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import ht.a;
import ht.b;
import ht.c;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CuisinesContainer;
import library.talabat.com.talabatlib.FiltersContainer;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import library.talabat.com.talabatlib.Sort;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00124\u0010\u0004\u001a0\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005j\u0002`\u000b\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rj\u0002`\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J@\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0016J.\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J$\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\t2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0016R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rj\u0002`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R<\u0010\u0004\u001a0\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/restaurants/v1/RestaurantListInteractorPaginated;", "Lcom/talabat/restaurants/v1/IRestaurantsListInteractorRefactor;", "pagedUsedCase", "Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "vendorTagsUseCase", "Lkotlin/Function4;", "", "", "", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "Lcom/talabat/talabatcommon/feature/vendorTags/domain/RequestVendorTagsUseCaseInterface;", "getVerticalsUseCase", "Lkotlin/Function1;", "", "Lcom/talabat/restaurants/v2/domain/utils/GetVerticalsUseCaseInterface;", "io", "Lio/reactivex/Scheduler;", "main", "(Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "getRestaurantsAndRecommendation", "", "listener", "Lcom/talabat/restaurants/v1/RestaurantListListenerRefactor;", "areaId", "cityId", "latitude", "longitude", "countryId", "verticalId", "getRestaurantsInfoApi", "onRestaurantsReceived", "vendorsResponse", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "vendorTags", "requestVendors", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantListInteractorPaginated implements IRestaurantsListInteractorRefactor {
    @Nullable
    private Disposable disposable;
    @NotNull
    private final Function1<Integer, List<Integer>> getVerticalsUseCase;
    @NotNull

    /* renamed from: io  reason: collision with root package name */
    private final Scheduler f61228io;
    @NotNull
    private final Scheduler main;
    @NotNull
    private final PagedUsedCase pagedUsedCase;
    @NotNull
    private final Function4<String, String, List<Integer>, Integer, Single<VendorTagsResponse>> vendorTagsUseCase;

    public RestaurantListInteractorPaginated(@NotNull PagedUsedCase pagedUsedCase2, @NotNull Function4<? super String, ? super String, ? super List<Integer>, ? super Integer, ? extends Single<VendorTagsResponse>> function4, @NotNull Function1<? super Integer, ? extends List<Integer>> function1, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(pagedUsedCase2, "pagedUsedCase");
        Intrinsics.checkNotNullParameter(function4, "vendorTagsUseCase");
        Intrinsics.checkNotNullParameter(function1, "getVerticalsUseCase");
        Intrinsics.checkNotNullParameter(scheduler, "io");
        Intrinsics.checkNotNullParameter(scheduler2, "main");
        this.pagedUsedCase = pagedUsedCase2;
        this.vendorTagsUseCase = function4;
        this.getVerticalsUseCase = function1;
        this.f61228io = scheduler;
        this.main = scheduler2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsAndRecommendation$lambda-0  reason: not valid java name */
    public static final Pair m10729getRestaurantsAndRecommendation$lambda0(RestaurantListResponsePaginated restaurantListResponsePaginated, VendorTagsResponse vendorTagsResponse) {
        return new Pair(restaurantListResponsePaginated, vendorTagsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsAndRecommendation$lambda-1  reason: not valid java name */
    public static final void m10730getRestaurantsAndRecommendation$lambda1(RestaurantListInteractorPaginated restaurantListInteractorPaginated, RestaurantListListenerRefactor restaurantListListenerRefactor, Pair pair) {
        Intrinsics.checkNotNullParameter(restaurantListInteractorPaginated, "this$0");
        Intrinsics.checkNotNullParameter(restaurantListListenerRefactor, "$listener");
        restaurantListInteractorPaginated.onRestaurantsReceived(restaurantListListenerRefactor, (RestaurantListResponsePaginated) pair.getFirst(), (VendorTagsResponse) pair.getSecond());
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantsAndRecommendation$lambda-2  reason: not valid java name */
    public static final void m10731getRestaurantsAndRecommendation$lambda2(RestaurantListListenerRefactor restaurantListListenerRefactor, Throwable th2) {
        Intrinsics.checkNotNullParameter(restaurantListListenerRefactor, "$listener");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        String message = th2.getMessage();
        restaurantListListenerRefactor.logNetworkError("failed with " + message);
        restaurantListListenerRefactor.onNetworkError();
    }

    private final Single<VendorTagsResponse> getRestaurantsInfoApi(String str, String str2, int i11, int i12) {
        return this.vendorTagsUseCase.invoke(str, str2, this.getVerticalsUseCase.invoke(Integer.valueOf(i11)), Integer.valueOf(i12));
    }

    private final void onRestaurantsReceived(RestaurantListListenerRefactor restaurantListListenerRefactor, RestaurantListResponsePaginated restaurantListResponsePaginated, VendorTagsResponse vendorTagsResponse) {
        Restaurant[] restaurantArr;
        Cuisine[] cuisineArr;
        Integer[] numArr;
        ArrayList<Filter> arrayList;
        ArrayList<QuickFilter> arrayList2;
        List<Sort> list;
        List list2;
        FiltersContainer filters;
        FiltersContainer filters2;
        ArrayList<Filter> popular;
        FiltersContainer filters3;
        CuisinesContainer cuisines;
        ArrayList<Cuisine> popular2;
        CuisinesContainer cuisines2;
        ArrayList<Cuisine> all;
        List<Restaurant> vendors;
        RestaurantListJM restaurantListJM = new RestaurantListJM();
        if (restaurantListResponsePaginated == null || (vendors = restaurantListResponsePaginated.getVendors()) == null) {
            restaurantArr = null;
        } else {
            Object[] array = vendors.toArray(new Restaurant[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            restaurantArr = (Restaurant[]) array;
        }
        restaurantListJM.restaurants = restaurantArr;
        GlobalDataModel.updateRestaurantsData(restaurantListJM);
        if (vendorTagsResponse == null || (cuisines2 = vendorTagsResponse.getCuisines()) == null || (all = cuisines2.getAll()) == null) {
            cuisineArr = null;
        } else {
            Object[] array2 = all.toArray(new Cuisine[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            cuisineArr = (Cuisine[]) array2;
        }
        GlobalDataModel.cuisines = cuisineArr;
        if (vendorTagsResponse == null || (cuisines = vendorTagsResponse.getCuisines()) == null || (popular2 = cuisines.getPopular()) == null) {
            numArr = null;
        } else {
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(popular2, 10));
            for (Cuisine cuisine : popular2) {
                arrayList3.add(Integer.valueOf(cuisine.f13848id));
            }
            Object[] array3 = arrayList3.toArray(new Integer[0]);
            Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            numArr = (Integer[]) array3;
        }
        GlobalDataModel.popularCuisinesIds = numArr;
        if (vendorTagsResponse == null || (filters3 = vendorTagsResponse.getFilters()) == null) {
            arrayList = null;
        } else {
            arrayList = filters3.getAll();
        }
        GlobalDataModel.filters = arrayList;
        if (vendorTagsResponse != null) {
            arrayList2 = vendorTagsResponse.getCollections();
        } else {
            arrayList2 = null;
        }
        GlobalDataModel.collections = arrayList2;
        FiltersInMemoryCache filtersInMemoryCache = FiltersInMemoryCache.INSTANCE;
        if (vendorTagsResponse == null || (list = vendorTagsResponse.getSorting()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        filtersInMemoryCache.saveRestaurantsSortingTypes(list);
        if (!(vendorTagsResponse == null || (filters2 = vendorTagsResponse.getFilters()) == null || (popular = filters2.getPopular()) == null)) {
            for (Filter filter : popular) {
                filter.setName(PopularFilterHelper.Companion.getTranslatedFilterName(filter));
            }
        }
        FiltersInMemoryCache filtersInMemoryCache2 = FiltersInMemoryCache.INSTANCE;
        if (vendorTagsResponse == null || (filters = vendorTagsResponse.getFilters()) == null || (list2 = filters.getPopular()) == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        filtersInMemoryCache2.saveRestaurantsPopularFilters(list2);
        restaurantListListenerRefactor.onRestaurantListLoaded(false, (PolygonEvents) null, true);
    }

    private final Single<RestaurantListResponsePaginated> requestVendors(int i11) {
        return this.pagedUsedCase.getAllVendorsPaginated(true, (FilterParams) null, this.getVerticalsUseCase.invoke(Integer.valueOf(i11)), 1);
    }

    @Nullable
    public final Disposable getDisposable() {
        return this.disposable;
    }

    public void getRestaurantsAndRecommendation(@NotNull RestaurantListListenerRefactor restaurantListListenerRefactor, int i11, int i12, @NotNull String str, @NotNull String str2, int i13, int i14) {
        Intrinsics.checkNotNullParameter(restaurantListListenerRefactor, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        GlobalDataModel.SELECTED.updateRestaurant((Restaurant) null);
        this.disposable = Single.zip(requestVendors(i14), getRestaurantsInfoApi(str, str2, i14, i13), new a()).subscribeOn(this.f61228io).observeOn(this.main).subscribe(new b(this, restaurantListListenerRefactor), new c(restaurantListListenerRefactor));
    }

    public final void setDisposable(@Nullable Disposable disposable2) {
        this.disposable = disposable2;
    }

    public void unregister() {
        Disposable disposable2 = this.disposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RestaurantListInteractorPaginated(com.talabat.restaurants.v2.domain.vendors.PagedUsedCase r7, kotlin.jvm.functions.Function4 r8, kotlin.jvm.functions.Function1 r9, io.reactivex.Scheduler r10, io.reactivex.Scheduler r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 8
            if (r13 == 0) goto L_0x000d
            io.reactivex.Scheduler r10 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r13 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
        L_0x000d:
            r4 = r10
            r10 = r12 & 16
            if (r10 == 0) goto L_0x001b
            io.reactivex.Scheduler r11 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r10 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r10)
        L_0x001b:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v1.RestaurantListInteractorPaginated.<init>(com.talabat.restaurants.v2.domain.vendors.PagedUsedCase, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function1, io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
