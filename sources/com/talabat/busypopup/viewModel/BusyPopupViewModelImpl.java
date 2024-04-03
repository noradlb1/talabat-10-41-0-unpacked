package com.talabat.busypopup.viewModel;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsFilteredByCuisine;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rf.a;
import rf.b;
import rf.c;
import rf.d;
import rf.e;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0005¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0014R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/busypopup/viewModel/BusyPopupViewModelImpl;", "Lcom/talabat/busypopup/viewModel/BusyPopupViewModel;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getVendorsFilteredByCuisine", "Lkotlin/Function1;", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsFilteredByCuisine$Params;", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function1;)V", "generateVendorsDisplayModels", "", "Ldatamodels/RestaurantListItemModel;", "restaurants", "getRestaurantListWithCuisine", "", "cuisineIdToFilter", "", "verticalType", "resultCount", "onCleared", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BusyPopupViewModelImpl extends BusyPopupViewModel {
    @NotNull
    private Function1<? super GetVendorsFilteredByCuisine.Params, ? extends Single<List<Restaurant>>> getVendorsFilteredByCuisine;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public BusyPopupViewModelImpl(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function1<? super GetVendorsFilteredByCuisine.Params, ? extends Single<List<Restaurant>>> function1) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function1, "getVendorsFilteredByCuisine");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getVendorsFilteredByCuisine = function1;
    }

    /* access modifiers changed from: private */
    public final List<RestaurantListItemModel> generateVendorsDisplayModels(List<? extends Restaurant> list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z11 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i11 = ((Restaurant) next).statusType;
            if (!(i11 == 0 || i11 == 5)) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        Iterable<Restaurant> sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(sortedWith, 10));
        for (Restaurant restaurant : sortedWith) {
            restaurant.itemPosition = list.indexOf(restaurant) + 1;
            arrayList2.add(RestaurantListItemModel.fromVendor(restaurant));
        }
        return CollectionsKt___CollectionsKt.toMutableList(arrayList2);
    }

    /* access modifiers changed from: private */
    /* renamed from: generateVendorsDisplayModels$lambda-4  reason: not valid java name */
    public static final int m9535generateVendorsDisplayModels$lambda4(Restaurant restaurant, Restaurant restaurant2) {
        List listOf = CollectionsKt__CollectionsKt.listOf(0, 5);
        return listOf.indexOf(Integer.valueOf(restaurant.statusType)) - listOf.indexOf(Integer.valueOf(restaurant2.statusType));
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantListWithCuisine$lambda-0  reason: not valid java name */
    public static final List m9536getRestaurantListWithCuisine$lambda0(int i11, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (list.size() < i11) {
            i11 = list.size();
        }
        return list.subList(0, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantListWithCuisine$lambda-1  reason: not valid java name */
    public static final void m9537getRestaurantListWithCuisine$lambda1(BusyPopupViewModelImpl busyPopupViewModelImpl, List list) {
        Intrinsics.checkNotNullParameter(busyPopupViewModelImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "restaurantListItemModels");
        if (!list.isEmpty()) {
            busyPopupViewModelImpl.getVendorList().setValue(list);
            busyPopupViewModelImpl.getShowNoResult().setValue(Boolean.FALSE);
            return;
        }
        busyPopupViewModelImpl.getShowNoResult().setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: getRestaurantListWithCuisine$lambda-2  reason: not valid java name */
    public static final void m9538getRestaurantListWithCuisine$lambda2(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LogManager.logException(th2);
    }

    public void getRestaurantListWithCuisine(int i11, int i12, int i13) {
        Disposable subscribe = ((Single) this.getVendorsFilteredByCuisine.invoke(new GetVendorsFilteredByCuisine.Params(true, GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCountryId, String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), i12, i11))).map(new b(i13)).map(new c(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e());
        Intrinsics.checkNotNullExpressionValue(subscribe, "getVendorsFilteredByCuis…ception(it)\n            }");
        getMDisposables().add(subscribe);
    }

    public void onCleared() {
        super.onCleared();
        getMDisposables();
        getMDisposables().dispose();
    }
}
