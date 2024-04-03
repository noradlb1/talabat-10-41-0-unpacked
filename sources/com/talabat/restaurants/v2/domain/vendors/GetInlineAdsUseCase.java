package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.network.NetworkBuilder;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.inlineads.IAdLoader;
import com.talabat.restaurants.v2.data.vendors.AreaParams;
import com.talabat.restaurants.v2.data.vendors.VendorByIdDataSource;
import com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated;
import com.talabat.restaurants.v2.data.vendors.VendorsByIdDataSourceImpl;
import com.talabat.restaurants.v2.domain.utils.GetExternalExperimentsUseCase;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;
import pt.a;
import pt.b;
import pt.c;
import pt.d;
import pt.e;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0002`\u00060\u00030\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/GetInlineAdsUseCase;", "Lkotlin/Function1;", "", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Ldatamodels/RestaurantListItemModel;", "Lcom/talabat/restaurants/v2/domain/vendors/InlineAdsData;", "ad", "Lcom/talabat/restaurants/inlineads/IAdLoader;", "getExternalExperimentsUseCase", "Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;", "vendorByIdDataSource", "Lcom/talabat/restaurants/v2/data/vendors/VendorByIdDataSource;", "(Lcom/talabat/restaurants/inlineads/IAdLoader;Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;Lcom/talabat/restaurants/v2/data/vendors/VendorByIdDataSource;)V", "invoke", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetInlineAdsUseCase implements Function1<Integer, Single<Pair<? extends Integer, ? extends RestaurantListItemModel>>> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    private final IAdLoader f61248ad;
    @NotNull
    private final GetExternalExperimentsUseCase getExternalExperimentsUseCase;
    @NotNull
    private final VendorByIdDataSource vendorByIdDataSource;

    public GetInlineAdsUseCase(@NotNull IAdLoader iAdLoader, @NotNull GetExternalExperimentsUseCase getExternalExperimentsUseCase2, @NotNull VendorByIdDataSource vendorByIdDataSource2) {
        Intrinsics.checkNotNullParameter(iAdLoader, "ad");
        Intrinsics.checkNotNullParameter(getExternalExperimentsUseCase2, "getExternalExperimentsUseCase");
        Intrinsics.checkNotNullParameter(vendorByIdDataSource2, "vendorByIdDataSource");
        this.f61248ad = iAdLoader;
        this.getExternalExperimentsUseCase = getExternalExperimentsUseCase2;
        this.vendorByIdDataSource = vendorByIdDataSource2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8  reason: not valid java name */
    public static final SingleSource m10744invoke$lambda8(GetInlineAdsUseCase getInlineAdsUseCase, AreaParams areaParams, double d11, String str, List list) {
        Intrinsics.checkNotNullParameter(getInlineAdsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(areaParams, "$area");
        Intrinsics.checkNotNullParameter(str, "$vlDynamicRanking");
        Intrinsics.checkNotNullParameter(list, "ads");
        VendorByIdDataSource vendorByIdDataSource2 = getInlineAdsUseCase.vendorByIdDataSource;
        Iterable<AdsWrapper> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (AdsWrapper vendorId : iterable) {
            arrayList.add(Integer.valueOf(vendorId.getVendorId()));
        }
        return vendorByIdDataSource2.getVendorById(areaParams, arrayList, getInlineAdsUseCase.getExternalExperimentsUseCase.invoke(d11, str), "shop_list", GetInlineAdsUseCaseKt.HEADER_DEVICE_CTA_VALUE).flatMapMaybe(new b(list)).map(new c()).switchIfEmpty(new d());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8$lambda-5  reason: not valid java name */
    public static final MaybeSource m10745invoke$lambda8$lambda5(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "$ads");
        Intrinsics.checkNotNullParameter(list2, "vendors");
        return Maybe.fromCallable(new a(list2, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8$lambda-5$lambda-4  reason: not valid java name */
    public static final AdsWrapper m10746invoke$lambda8$lambda5$lambda4(List list, List list2) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "$vendors");
        Intrinsics.checkNotNullParameter(list2, "$ads");
        Iterable iterable = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(Integer.valueOf(((Restaurant) next).f13872id), next);
        }
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (linkedHashMap.containsKey(Integer.valueOf(((AdsWrapper) obj).getVendorId()))) {
                break;
            }
        }
        AdsWrapper adsWrapper = (AdsWrapper) obj;
        if (adsWrapper == null) {
            return null;
        }
        adsWrapper.setRestaurant((Restaurant) linkedHashMap.get(Integer.valueOf(adsWrapper.getVendorId())));
        Restaurant restaurant = adsWrapper.getRestaurant();
        if (restaurant != null) {
            restaurant.itemPosition = adsWrapper.getAdsPosition();
        }
        return adsWrapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8$lambda-6  reason: not valid java name */
    public static final Pair m10747invoke$lambda8$lambda6(AdsWrapper adsWrapper) {
        Intrinsics.checkNotNullParameter(adsWrapper, "it");
        return TuplesKt.to(Integer.valueOf(adsWrapper.getAdsPosition()), RestaurantListItemModel.fromAd(adsWrapper));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8$lambda-7  reason: not valid java name */
    public static final void m10748invoke$lambda8$lambda7(SingleObserver singleObserver) {
        Intrinsics.checkNotNullParameter(singleObserver, "it");
        singleObserver.onSuccess(TuplesKt.to(null, null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public Single<Pair<Integer, RestaurantListItemModel>> invoke(int i11) {
        AreaParams areaParams = new AreaParams(String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCountryId);
        Single<R> flatMap = this.f61248ad.loadAds(i11, areaParams.getCountryId(), String.valueOf(areaParams.getAreaId())).flatMap(new e(this, areaParams, ((Number) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_BOOST_RANKING, Double.valueOf(0.0d), (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).doubleValue(), (String) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_DYNAMIC_RANKING, "", (ITalabatExperiment) null, (Function1) null, 12, (Object) null)));
        Intrinsics.checkNotNullExpressionValue(flatMap, "ad.loadAds(verticalId, a…to null) })\n            }");
        return flatMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetInlineAdsUseCase(IAdLoader iAdLoader, GetExternalExperimentsUseCase getExternalExperimentsUseCase2, VendorByIdDataSource vendorByIdDataSource2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAdLoader, (i11 & 2) != 0 ? new GetExternalExperimentsUseCase() : getExternalExperimentsUseCase2, (i11 & 4) != 0 ? new VendorsByIdDataSourceImpl((VendorsApiPaginated) NetworkBuilder.Companion.getService(VendorEndPointProvider.INSTANCE.getBaseUrl(), VendorsApiPaginated.class)) : vendorByIdDataSource2);
    }
}
