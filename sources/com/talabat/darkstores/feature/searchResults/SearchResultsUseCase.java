package com.talabat.darkstores.feature.searchResults;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.data.TrackingInfo;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.model.Filters;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.model.ProductDiscount;
import com.talabat.darkstores.model.SearchResponse;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import dagger.Reusable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oj.g;
import oj.h;
import oj.i;
import oj.j;
import oj.k;
import oj.l;
import oj.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010J0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0002JF\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0011*\b\u0012\u0004\u0012\u00020#0\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fH\u0002J\u0014\u0010%\u001a\u00020 *\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002R@\u0010\r\u001a4\u00120\u0012.\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011 \u0013*\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R4\u0010\u0014\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015 \u0013*\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsUseCase;", "", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "searchRepository", "Lcom/talabat/darkstores/data/search/SearchRepository;", "searchTracker", "Lcom/talabat/darkstores/data/tracking/SearchTracker;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/darkstores/data/search/SearchRepository;Lcom/talabat/darkstores/data/tracking/SearchTracker;)V", "campaignTriggersByProduct", "Lio/reactivex/Single;", "", "", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "kotlin.jvm.PlatformType", "discountsByProduct", "Lcom/talabat/darkstores/model/ProductDiscount;", "search", "Lcom/talabat/darkstores/data/SearchResultData;", "query", "limit", "", "offset", "categoryId", "searchInternal", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "trackSearchError", "", "message", "applyDiscountsAndCampaigns", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "campaignByProduct", "trackEvent", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class SearchResultsUseCase {
    @NotNull
    private final Single<Map<String, List<CampaignTrigger>>> campaignTriggersByProduct;
    @NotNull
    private final Single<Map<String, ProductDiscount>> discountsByProduct;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final SearchRepository searchRepository;
    @NotNull
    private final SearchTracker searchTracker;

    @Inject
    public SearchResultsUseCase(@NotNull DarkstoresRepo darkstoresRepo, @NotNull DiscoveryRepo discoveryRepo2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull SearchRepository searchRepository2, @NotNull SearchTracker searchTracker2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(searchRepository2, "searchRepository");
        Intrinsics.checkNotNullParameter(searchTracker2, "searchTracker");
        this.discoveryRepo = discoveryRepo2;
        this.searchRepository = searchRepository2;
        this.searchTracker = searchTracker2;
        Single<R> onErrorReturnItem = darkstoresRepo.getDiscounts().map(new g()).onErrorReturnItem(MapsKt__MapsKt.emptyMap());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "darkstoresRepo.getDiscou…rorReturnItem(emptyMap())");
        this.discountsByProduct = SingleExtensionsKt.cacheButRetryOnError(onErrorReturnItem);
        Single single = Maybe.create(new h(iTalabatFeatureFlag)).flatMap(new i(darkstoresRepo)).map(new j()).toSingle(MapsKt__MapsKt.emptyMap());
        Intrinsics.checkNotNullExpressionValue(single, "create<Unit> { emitter -…    .toSingle(emptyMap())");
        this.campaignTriggersByProduct = SingleExtensionsKt.cacheButRetryOnError(single);
    }

    private final List<Product> applyDiscountsAndCampaigns(List<Product> list, Map<String, ProductDiscount> map, Map<String, ? extends List<CampaignTrigger>> map2) {
        float f11;
        Float f12;
        CampaignTrigger campaignTrigger;
        Iterable<Product> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Product product : iterable) {
            ProductDiscount productDiscount = map.get(product.getId());
            if (productDiscount != null) {
                f11 = productDiscount.getDiscountedPrice();
            } else {
                f11 = product.getPrice();
            }
            if (productDiscount != null) {
                f12 = Float.valueOf(productDiscount.getOriginalPrice());
            } else {
                f12 = product.getPreviousPrice();
            }
            Float f13 = f12;
            List list2 = (List) map2.get(product.getId());
            if (list2 != null) {
                campaignTrigger = (CampaignTrigger) CollectionsKt___CollectionsKt.firstOrNull(list2);
            } else {
                campaignTrigger = null;
            }
            arrayList.add(Product.copy$default(product, (String) null, (String) null, (String) null, f11, f13, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, campaignTrigger, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 2145386471, (Object) null));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-2  reason: not valid java name */
    public static final void m10085campaignTriggersByProduct$lambda2(ITalabatFeatureFlag iTalabatFeatureFlag, MaybeEmitter maybeEmitter) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "$featureFlags");
        Intrinsics.checkNotNullParameter(maybeEmitter, "emitter");
        if (iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_DARKSTORES_LISTING_PROMO_TAG, false)) {
            maybeEmitter.onSuccess(Unit.INSTANCE);
        } else {
            maybeEmitter.onComplete();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-3  reason: not valid java name */
    public static final MaybeSource m10086campaignTriggersByProduct$lambda3(DarkstoresRepo darkstoresRepo, Unit unit) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "$darkstoresRepo");
        Intrinsics.checkNotNullParameter(unit, "it");
        return darkstoresRepo.getAllCampaignsTriggers().toMaybe().onErrorComplete();
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-5  reason: not valid java name */
    public static final Map m10087campaignTriggersByProduct$lambda5(List list) {
        Intrinsics.checkNotNullParameter(list, "triggers");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : list) {
            String id2 = ((CampaignTrigger) next).getId();
            Object obj = linkedHashMap.get(id2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(id2, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: discountsByProduct$lambda-1  reason: not valid java name */
    public static final Map m10088discountsByProduct$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "discounts");
        Iterable iterable = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((ProductDiscount) next).getProductId(), next);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-10  reason: not valid java name */
    public static final SearchResultData m10089search$lambda10(SearchResultsUseCase searchResultsUseCase, SearchResultsResponse searchResultsResponse, Map map, Map map2) {
        ArrayList arrayList;
        List<Filters.Category> categories;
        SearchCategory searchCategory;
        Intrinsics.checkNotNullParameter(searchResultsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(searchResultsResponse, "searchResponse");
        Intrinsics.checkNotNullParameter(map, "discounts");
        Intrinsics.checkNotNullParameter(map2, "triggers");
        List<Product> applyDiscountsAndCampaigns = searchResultsUseCase.applyDiscountsAndCampaigns(searchResultsResponse.getProducts(), map, map2);
        int total = searchResultsResponse.getItemCounts().getTotal();
        Filters filters = searchResultsResponse.getFilters();
        if (filters == null || (categories = filters.getCategories()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Filters.Category category : categories) {
                String name2 = category.getName();
                if (name2 != null) {
                    searchCategory = new SearchCategory(category.getId(), name2);
                } else {
                    searchCategory = null;
                }
                if (searchCategory != null) {
                    arrayList2.add(searchCategory);
                }
            }
            arrayList = arrayList2;
        }
        return new SearchResultData(applyDiscountsAndCampaigns, (String) null, (String) null, total, arrayList, (TrackingInfo) null, 38, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-6  reason: not valid java name */
    public static final void m10090search$lambda6(SearchResultsUseCase searchResultsUseCase, String str, SearchResultsResponse searchResultsResponse) {
        Intrinsics.checkNotNullParameter(searchResultsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullExpressionValue(searchResultsResponse, "it");
        searchResultsUseCase.trackEvent(searchResultsResponse, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-7  reason: not valid java name */
    public static final void m10091search$lambda7(SearchResultsUseCase searchResultsUseCase, String str, Throwable th2) {
        Intrinsics.checkNotNullParameter(searchResultsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        searchResultsUseCase.trackSearchError(str, th2.getMessage());
    }

    private final Single<SearchResultsResponse> searchInternal(String str, int i11, int i12, String str2) {
        return this.searchRepository.searchProductsQCommerce(str, i11, i12, str2);
    }

    private final void trackEvent(SearchResultsResponse searchResultsResponse, String str) {
        SearchResponse.TrackingData trackingData = searchResultsResponse.getTrackingData();
        if (trackingData.isEmpty()) {
            SearchTracker.searchError$default(this.searchTracker, str, "", (String) null, 4, (Object) null);
        } else {
            this.searchTracker.searchResultsLoaded(trackingData.getProductsCount(), str, this.discoveryRepo.getLastSearchRequestId());
        }
    }

    private final void trackSearchError(String str, String str2) {
        this.searchTracker.searchError(str, "", str2);
    }

    @NotNull
    public final Single<SearchResultData> search(@NotNull String str, int i11, int i12, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Single<SearchResultData> zip = Single.zip(searchInternal(str, i11, i12, str2).doOnSuccess(new k(this, str)).doOnError(new l(this, str)), this.discountsByProduct, this.campaignTriggersByProduct, new m(this));
        Intrinsics.checkNotNullExpressionValue(zip, "zip(\n            searchI…}\n            )\n        }");
        return zip;
    }
}
