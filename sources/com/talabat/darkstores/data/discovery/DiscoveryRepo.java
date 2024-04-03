package com.talabat.darkstores.data.discovery;

import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.data.TrackingInfo;
import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.FeedResponse;
import com.talabat.darkstores.data.discovery.model.Location;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import com.talabat.darkstores.data.discovery.model.PastOrdersResponse;
import com.talabat.darkstores.data.discovery.model.ProductListingResponse;
import com.talabat.darkstores.data.discovery.model.ProductsComponentItem;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.data.discovery.model.TagResponse;
import com.talabat.darkstores.data.discovery.model.VendorFeedResponse;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.di.LibScope;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.ProductDiscount;
import com.talabat.darkstores.model.ProductSuggestion;
import com.talabat.darkstores.model.SearchResponse;
import com.talabat.darkstores.model.SearchSuggestion;
import com.talabat.darkstores.model.SearchSuggestionsResponse;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.homescreen.network.UrlConstantsKt;
import com.talabat.mapper.ModelMapper;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import ei.a;
import ei.a0;
import ei.b;
import ei.b0;
import ei.c;
import ei.c0;
import ei.d;
import ei.d0;
import ei.e;
import ei.e0;
import ei.f;
import ei.f0;
import ei.g;
import ei.g0;
import ei.h;
import ei.h0;
import ei.i;
import ei.i0;
import ei.j;
import ei.j0;
import ei.k;
import ei.k0;
import ei.l;
import ei.l0;
import ei.m;
import ei.n;
import ei.o;
import ei.p;
import ei.q;
import ei.r;
import ei.s;
import ei.t;
import ei.u;
import ei.v;
import ei.w;
import ei.x;
import ei.y;
import ei.z;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001Be\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\u0010\u0018J\"\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001eJ$\u00101\u001a\u00020-2\f\u00102\u001a\b\u0012\u0004\u0012\u00020#0\u001e2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001eH\u0002J\u001e\u00103\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001e\u0012\u0004\u0012\u00020!040\u001aJ\u001a\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001e062\u0006\u00107\u001a\u00020(J\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001aJ\u0014\u0010:\u001a\b\u0012\u0004\u0012\u0002000\u001a2\u0006\u0010;\u001a\u00020(J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u0002000\u001a2\u0006\u0010=\u001a\u00020(J8\u0010>\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001e\u0012\u0004\u0012\u00020!040\u001a2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020!H\u0002J$\u0010B\u001a\b\u0012\u0004\u0012\u0002090\u001a2\u0006\u0010C\u001a\u00020(2\u0006\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020!J$\u0010D\u001a\b\u0012\u0004\u0012\u0002090\u001a2\u0006\u0010E\u001a\u00020(2\u0006\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020!J4\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a2\u0006\u0010G\u001a\u00020(2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\u0006\u00107\u001a\u00020!2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010(J\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L06J\u0014\u0010M\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0NH\u0002J\u001a\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u001e0\u001a2\u0006\u0010C\u001a\u00020(J\u001e\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0\u001e0\u001a2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IJ$\u0010S\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0N2\u0006\u0010T\u001a\u00020U2\u0006\u00107\u001a\u00020(H\u0002J\u001a\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\u001e0\u001a2\u0006\u0010X\u001a\u00020(J$\u0010Y\u001a\u00020-2\u0006\u0010Z\u001a\u00020(2\b\b\u0002\u0010;\u001a\u00020(2\b\b\u0002\u0010=\u001a\u00020(H\u0002J\u001a\u0010[\u001a\u00020-2\u0006\u0010X\u001a\u00020(2\b\u0010\\\u001a\u0004\u0018\u00010(H\u0002J<\u0010,\u001a\b\u0012\u0004\u0012\u0002H]0\u001a\"\b\b\u0000\u0010]*\u00020\u0001*\b\u0012\u0004\u0012\u0002H]0\u001a2\u0018\u0010>\u001a\u0014\u0012\u0004\u0012\u0002H]\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001e0^H\u0002J<\u00101\u001a\b\u0012\u0004\u0012\u0002H]0\u001a\"\b\b\u0000\u0010]*\u00020\u0001*\b\u0012\u0004\u0012\u0002H]0\u001a2\u0018\u0010>\u001a\u0014\u0012\u0004\u0012\u0002H]\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001e0^H\u0002J\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000\u001e*\b\u0012\u0004\u0012\u00020W0\u001eH\u0003¢\u0006\u0002\b_J\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000\u001e*\b\u0012\u0004\u0012\u00020`0\u001eH\u0003¢\u0006\u0002\baJ\u0014\u0010b\u001a\u00020-*\u00020c2\u0006\u0010X\u001a\u00020(H\u0002R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!XD¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001e0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b$\u0010&R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010(@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "discoveryApi", "Lcom/talabat/darkstores/data/discovery/DiscoveryApi;", "basketApi", "Lcom/talabat/darkstores/data/basket/BasketApi;", "feedApi", "Lcom/talabat/darkstores/data/discovery/FeedApi;", "productApi", "Lcom/talabat/darkstores/data/discovery/ProductApi;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "ioScheduler", "Lio/reactivex/Scheduler;", "searchTracker", "Lcom/talabat/darkstores/data/tracking/SearchTracker;", "subcategoryResultMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponse;", "Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/discovery/DiscoveryApi;Lcom/talabat/darkstores/data/basket/BasketApi;Lcom/talabat/darkstores/data/discovery/FeedApi;Lcom/talabat/darkstores/data/discovery/ProductApi;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lio/reactivex/Scheduler;Lcom/talabat/darkstores/data/tracking/SearchTracker;Lcom/talabat/mapper/ModelMapper;)V", "baseFeedRequestObservable", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "kotlin.jvm.PlatformType", "campaignTriggersObservable", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "designVariant", "", "discountsObservable", "Lcom/talabat/darkstores/model/ProductDiscount;", "isPromoTagEnabled", "", "()Z", "<set-?>", "", "lastSearchRequestId", "getLastSearchRequestId", "()Ljava/lang/String;", "applyCampaignTriggers", "", "triggers", "products", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "applyDiscounts", "discounts", "getAllProducts", "Lkotlin/Pair;", "getPastOrders", "Lio/reactivex/Maybe;", "sortingStrategy", "getPopularProducts", "Lcom/talabat/darkstores/data/SearchResultData;", "getProductDetails", "productId", "getProductDetailsBySku", "productSku", "getProducts", "request", "limit", "offset", "getProductsForCategory", "categoryId", "getProductsForTag", "productTag", "getSubcategorySwimlanes", "parentCategoryId", "pageType", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "appliedSortOption", "getSwimlane", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;", "getSwimlaneQueryMap", "", "getTagsForCategory", "Lcom/talabat/darkstores/data/discovery/model/TagResponse;", "getTopLevelCategories", "Lcom/talabat/darkstores/model/Category;", "pastOrdersQueryMap", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "search", "Lcom/talabat/darkstores/model/SearchSuggestion;", "query", "trackProductDetailsNotLoaded", "errorMessage", "trackSearchError", "message", "T", "Lkotlin/Function1;", "searchSuggestionGetAllProducts", "Lcom/talabat/darkstores/model/Swimlane;", "swimlaneGetAllProduTalabatFeatureFlagConstantscts", "trackEvent", "Lcom/talabat/darkstores/model/SearchSuggestionsResponse;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public final class DiscoveryRepo {
    @NotNull
    private final Single<FeedEndpointRequest> baseFeedRequestObservable;
    @NotNull
    private final BasketApi basketApi;
    @Nullable
    private Single<List<CampaignTrigger>> campaignTriggersObservable;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    private final int designVariant;
    @NotNull
    private final Single<List<ProductDiscount>> discountsObservable;
    @NotNull
    private final DiscoveryApi discoveryApi;
    @NotNull
    private final FeedApi feedApi;
    @NotNull
    private final Scheduler ioScheduler;
    private final boolean isPromoTagEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public String lastSearchRequestId;
    @NotNull
    private final ProductApi productApi;
    @NotNull
    private final SearchTracker searchTracker;
    @NotNull
    private final ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse> subcategoryResultMapper;

    @Inject
    public DiscoveryRepo(@NotNull ConfigurationParameters configurationParameters2, @NotNull DarkstoresRepo darkstoresRepo2, @NotNull DiscoveryApi discoveryApi2, @NotNull BasketApi basketApi2, @NotNull FeedApi feedApi2, @NotNull ProductApi productApi2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @IoScheduler @NotNull Scheduler scheduler, @NotNull SearchTracker searchTracker2, @NotNull ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse> modelMapper) {
        Single<List<CampaignTrigger>> single;
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(discoveryApi2, "discoveryApi");
        Intrinsics.checkNotNullParameter(basketApi2, "basketApi");
        Intrinsics.checkNotNullParameter(feedApi2, "feedApi");
        Intrinsics.checkNotNullParameter(productApi2, "productApi");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(searchTracker2, "searchTracker");
        Intrinsics.checkNotNullParameter(modelMapper, "subcategoryResultMapper");
        this.configurationParameters = configurationParameters2;
        this.darkstoresRepo = darkstoresRepo2;
        this.discoveryApi = discoveryApi2;
        this.basketApi = basketApi2;
        this.feedApi = feedApi2;
        this.productApi = productApi2;
        this.ioScheduler = scheduler;
        this.searchTracker = searchTracker2;
        this.subcategoryResultMapper = modelMapper;
        Single<R> map = darkstoresRepo2.getVendor().map(new p(this));
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresRepo.getVendor…d\n            )\n        }");
        this.baseFeedRequestObservable = SingleExtensionsKt.cacheButRetryOnError(map);
        this.discountsObservable = SingleExtensionsKt.cacheButRetryOnError(darkstoresRepo2.getDiscounts());
        boolean featureFlag = iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_DARKSTORES_LISTING_PROMO_TAG, false);
        this.isPromoTagEnabled = featureFlag;
        if (featureFlag) {
            single = SingleExtensionsKt.cacheButRetryOnError(darkstoresRepo2.getAllCampaignsTriggers());
        } else {
            single = null;
        }
        this.campaignTriggersObservable = single;
        this.designVariant = 2;
    }

    public static /* synthetic */ void M(DiscoveryRepo discoveryRepo, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            str3 = "";
        }
        discoveryRepo.trackProductDetailsNotLoaded(str, str2, str3);
    }

    private final <T> Single<T> applyCampaignTriggers(Single<T> single, Function1<? super T, ? extends List<Product>> function1) {
        if (!this.isPromoTagEnabled) {
            return single;
        }
        Single<R> flatMap = single.flatMap(new o(this, single, function1));
        Intrinsics.checkNotNullExpressionValue(flatMap, "{\n            flatMap {\n…s\n            }\n        }");
        return flatMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: applyCampaignTriggers$lambda-42  reason: not valid java name */
    public static final SingleSource m9681applyCampaignTriggers$lambda42(DiscoveryRepo discoveryRepo, Single single, Function1 function1, Object obj) {
        Single<R> map;
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(single, "$this_applyCampaignTriggers");
        Intrinsics.checkNotNullParameter(function1, "$getProducts");
        Intrinsics.checkNotNullParameter(obj, "it");
        Single<List<CampaignTrigger>> single2 = discoveryRepo.campaignTriggersObservable;
        if (single2 == null || (map = single2.map(new v(discoveryRepo, function1, obj))) == null) {
            return single;
        }
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: applyCampaignTriggers$lambda-42$lambda-41  reason: not valid java name */
    public static final Object m9682applyCampaignTriggers$lambda42$lambda41(DiscoveryRepo discoveryRepo, Function1 function1, Object obj, List list) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$getProducts");
        Intrinsics.checkNotNullParameter(obj, "$it");
        Intrinsics.checkNotNullParameter(list, "triggers");
        discoveryRepo.applyCampaignTriggers((List<CampaignTrigger>) list, (List<Product>) (List) function1.invoke(obj));
        return obj;
    }

    private final <T> Single<T> applyDiscounts(Single<T> single, Function1<? super T, ? extends List<Product>> function1) {
        Single<R> flatMap = single.flatMap(new c(this, function1));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap {\n            di…t\n            }\n        }");
        return flatMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: applyDiscounts$lambda-40  reason: not valid java name */
    public static final SingleSource m9683applyDiscounts$lambda40(DiscoveryRepo discoveryRepo, Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$getProducts");
        Intrinsics.checkNotNullParameter(obj, "it");
        return discoveryRepo.discountsObservable.map(new y(discoveryRepo, function1, obj));
    }

    /* access modifiers changed from: private */
    /* renamed from: applyDiscounts$lambda-40$lambda-39  reason: not valid java name */
    public static final Object m9684applyDiscounts$lambda40$lambda39(DiscoveryRepo discoveryRepo, Function1 function1, Object obj, List list) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$getProducts");
        Intrinsics.checkNotNullParameter(obj, "$it");
        Intrinsics.checkNotNullParameter(list, "discounts");
        discoveryRepo.applyDiscounts((List<ProductDiscount>) list, (List<Product>) (List) function1.invoke(obj));
        return obj;
    }

    /* access modifiers changed from: private */
    /* renamed from: baseFeedRequestObservable$lambda-0  reason: not valid java name */
    public static final FeedEndpointRequest m9685baseFeedRequestObservable$lambda0(DiscoveryRepo discoveryRepo, Vendor vendor) {
        DiscoveryRepo discoveryRepo2 = discoveryRepo;
        Intrinsics.checkNotNullParameter(discoveryRepo2, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        FeedEndpointRequest.Platform platform = FeedEndpointRequest.Platform.android;
        String vendorId = vendor.getVendorId();
        Location location = r1;
        Location location2 = new Location(discoveryRepo2.configurationParameters.getLocation(), (String) null, (String) null, 6, (DefaultConstructorMarker) null);
        return new FeedEndpointRequest((String) null, (String) null, (Boolean) null, discoveryRepo2.configurationParameters.getCountryCode(), discoveryRepo2.configurationParameters.getLanguageCode(), (String) null, "talabat", vendorId, (String) null, discoveryRepo2.configurationParameters.getCustomerId(), (String) null, (String) null, "dark_stores-config-1", (Integer) null, (Integer) null, location, (List) null, (List) null, platform, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, Boolean.TRUE, (String) null, (Boolean) null, (FeedEndpointRequest.PageType) null, 0, 0, 0, false, (Integer) null, (String) null, (String) null, -2396889, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllProducts$lambda-21  reason: not valid java name */
    public static final SingleSource m9686getAllProducts$lambda21(DiscoveryRepo discoveryRepo, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return discoveryRepo.getProducts(feedEndpointRequest, 5000, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: getPastOrders$lambda-30  reason: not valid java name */
    public static final SingleSource m9687getPastOrders$lambda30(DiscoveryRepo discoveryRepo, String str, Vendor vendor) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sortingStrategy");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return discoveryRepo.productApi.getPastOrders(vendor.getVendorId(), discoveryRepo.pastOrdersQueryMap(vendor, str)).map(new j());
    }

    /* access modifiers changed from: private */
    /* renamed from: getPastOrders$lambda-30$lambda-29  reason: not valid java name */
    public static final List m9688getPastOrders$lambda30$lambda29(PastOrdersResponse pastOrdersResponse) {
        Intrinsics.checkNotNullParameter(pastOrdersResponse, "pastOrderResponse");
        List<Product> products = pastOrdersResponse.getProducts();
        if (products == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return products;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPastOrders$lambda-33  reason: not valid java name */
    public static final MaybeSource m9689getPastOrders$lambda33(List list) {
        Intrinsics.checkNotNullParameter(list, "pastOrders");
        return Maybe.fromCallable(new i(list));
    }

    /* access modifiers changed from: private */
    /* renamed from: getPastOrders$lambda-33$lambda-32  reason: not valid java name */
    public static final List m9690getPastOrders$lambda33$lambda32(List list) {
        Intrinsics.checkNotNullParameter(list, "$pastOrders");
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductDetails$lambda-24  reason: not valid java name */
    public static final SingleSource m9691getProductDetails$lambda24(DiscoveryRepo discoveryRepo, String str, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productId");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return discoveryRepo.productApi.getProductDetails(feedEndpointRequest.getVendorId(), str, feedEndpointRequest.getBrand(), feedEndpointRequest.getCountryCode(), discoveryRepo.configurationParameters.getLanguageCode()).map(new f0());
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductDetails$lambda-24$lambda-23  reason: not valid java name */
    public static final Product m9692getProductDetails$lambda24$lambda23(ProductListingResponse productListingResponse) {
        Intrinsics.checkNotNullParameter(productListingResponse, "productListingResponse");
        Product product = productListingResponse.getProduct();
        if (product != null) {
            return product;
        }
        throw new IllegalStateException("product not found");
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductDetails$lambda-25  reason: not valid java name */
    public static final void m9693getProductDetails$lambda25(DiscoveryRepo discoveryRepo, String str, Throwable th2) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productId");
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        M(discoveryRepo, message, str, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductDetailsBySku$lambda-27  reason: not valid java name */
    public static final SingleSource m9694getProductDetailsBySku$lambda27(DiscoveryRepo discoveryRepo, String str, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productSku");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "productListingResponse");
        return discoveryRepo.productApi.getProductDetailsBySku(feedEndpointRequest.getVendorId(), str, feedEndpointRequest.getBrand(), feedEndpointRequest.getCountryCode(), discoveryRepo.configurationParameters.getLanguageCode()).map(new a());
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductDetailsBySku$lambda-27$lambda-26  reason: not valid java name */
    public static final Product m9695getProductDetailsBySku$lambda27$lambda26(ProductListingResponse productListingResponse) {
        Intrinsics.checkNotNullParameter(productListingResponse, "it");
        Product product = productListingResponse.getProduct();
        if (product != null) {
            return product;
        }
        throw new IllegalStateException("Product not found");
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductDetailsBySku$lambda-28  reason: not valid java name */
    public static final void m9696getProductDetailsBySku$lambda28(DiscoveryRepo discoveryRepo, String str, Throwable th2) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productSku");
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        M(discoveryRepo, message, (String) null, str, 2, (Object) null);
    }

    private final Single<Pair<List<Product>, Integer>> getProducts(FeedEndpointRequest feedEndpointRequest, int i11, int i12) {
        List listOf = CollectionsKt__CollectionsJVMKt.listOf(FeedEndpointRequest.ComponentTypes.products);
        Single<R> map = this.feedApi.feedGetProducts(FeedEndpointRequest.copy$default(feedEndpointRequest, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Integer.valueOf(i11), Integer.valueOf(i12), (Location) null, CollectionsKt__CollectionsJVMKt.listOf(FeedEndpointRequest.FieldsTypes.feed), listOf, (FeedEndpointRequest.Platform) null, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, (Boolean) null, (String) null, (Boolean) null, (FeedEndpointRequest.PageType) null, 0, 0, 0, false, (Integer) null, (String) null, (String) null, -221185, (Object) null)).subscribeOn(Schedulers.io()).map(new x());
        Intrinsics.checkNotNullExpressionValue(map, "feedApi.feedGetProducts(…), it.feed?.count ?: 0) }");
        return applyCampaignTriggers(applyDiscounts(map, DiscoveryRepo$getProducts$2.INSTANCE), DiscoveryRepo$getProducts$3.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: getProducts$lambda-22  reason: not valid java name */
    public static final Pair m9697getProducts$lambda22(VendorFeedResponse vendorFeedResponse) {
        List<Product> list;
        int i11;
        List<ProductsComponentItem> items;
        ProductsComponentItem productsComponentItem;
        Intrinsics.checkNotNullParameter(vendorFeedResponse, "it");
        FeedResponse feed = vendorFeedResponse.getFeed();
        if (feed == null || (items = feed.getItems()) == null || (productsComponentItem = (ProductsComponentItem) CollectionsKt___CollectionsKt.firstOrNull(items)) == null || (list = productsComponentItem.getProducts()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        FeedResponse feed2 = vendorFeedResponse.getFeed();
        if (feed2 != null) {
            i11 = feed2.getCount();
        } else {
            i11 = 0;
        }
        return new Pair(list, Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForCategory$lambda-18  reason: not valid java name */
    public static final FeedEndpointRequest m9698getProductsForCategory$lambda18(String str, FeedEndpointRequest feedEndpointRequest) {
        FeedEndpointRequest feedEndpointRequest2 = feedEndpointRequest;
        Intrinsics.checkNotNullParameter(str, "$categoryId");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return FeedEndpointRequest.copy$default(feedEndpointRequest2, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (Integer) null, (Integer) null, (Location) null, (List) null, (List) null, (FeedEndpointRequest.Platform) null, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, (Boolean) null, (String) null, (Boolean) null, (FeedEndpointRequest.PageType) null, 0, 0, 0, false, (Integer) null, (String) null, (String) null, -2049, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForCategory$lambda-20  reason: not valid java name */
    public static final SingleSource m9699getProductsForCategory$lambda20(DiscoveryRepo discoveryRepo, int i11, int i12, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return discoveryRepo.getProducts(feedEndpointRequest, i11, i12).map(new n());
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForCategory$lambda-20$lambda-19  reason: not valid java name */
    public static final SearchResultData m9700getProductsForCategory$lambda20$lambda19(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return new SearchResultData((List) pair.component1(), (String) null, (String) null, ((Number) pair.component2()).intValue(), (List) null, (TrackingInfo) null, 54, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForTag$lambda-15  reason: not valid java name */
    public static final FeedEndpointRequest m9701getProductsForTag$lambda15(String str, FeedEndpointRequest feedEndpointRequest) {
        FeedEndpointRequest feedEndpointRequest2 = feedEndpointRequest;
        Intrinsics.checkNotNullParameter(str, "$productTag");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return FeedEndpointRequest.copy$default(feedEndpointRequest2, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Location) null, (List) null, (List) null, (FeedEndpointRequest.Platform) null, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, (Boolean) null, str, (Boolean) null, (FeedEndpointRequest.PageType) null, 0, 0, 0, false, (Integer) null, (String) null, (String) null, -4194305, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForTag$lambda-17  reason: not valid java name */
    public static final SingleSource m9702getProductsForTag$lambda17(DiscoveryRepo discoveryRepo, int i11, int i12, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return discoveryRepo.getProducts(feedEndpointRequest, i11, i12).map(new b());
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductsForTag$lambda-17$lambda-16  reason: not valid java name */
    public static final SearchResultData m9703getProductsForTag$lambda17$lambda16(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return new SearchResultData((List) pair.component1(), (String) null, (String) null, ((Number) pair.component2()).intValue(), (List) null, (TrackingInfo) null, 54, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Single getSubcategorySwimlanes$default(DiscoveryRepo discoveryRepo, String str, FeedEndpointRequest.PageType pageType, int i11, String str2, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            pageType = null;
        }
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        return discoveryRepo.getSubcategorySwimlanes(str, pageType, i11, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSubcategorySwimlanes$lambda-4  reason: not valid java name */
    public static final FeedEndpointRequest m9704getSubcategorySwimlanes$lambda4(String str, FeedEndpointRequest.PageType pageType, int i11, String str2, FeedEndpointRequest feedEndpointRequest) {
        FeedEndpointRequest feedEndpointRequest2 = feedEndpointRequest;
        Intrinsics.checkNotNullParameter(str, "$parentCategoryId");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        List listOf = CollectionsKt__CollectionsJVMKt.listOf(FeedEndpointRequest.ComponentTypes.multi_list);
        return FeedEndpointRequest.copy$default(feedEndpointRequest2, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (Integer) null, (Integer) null, (Location) null, CollectionsKt__CollectionsJVMKt.listOf(FeedEndpointRequest.FieldsTypes.feed), listOf, (FeedEndpointRequest.Platform) null, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, (Boolean) null, (String) null, (Boolean) null, pageType, 0, 0, i11, false, (Integer) null, (String) null, str2, 1996290047, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSubcategorySwimlanes$lambda-5  reason: not valid java name */
    public static final SingleSource m9705getSubcategorySwimlanes$lambda5(DiscoveryRepo discoveryRepo, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return discoveryRepo.feedApi.feedGetMultiList(feedEndpointRequest);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSubcategorySwimlanes$lambda-6  reason: not valid java name */
    public static final SubcategorySwimalnesResponse m9706getSubcategorySwimlanes$lambda6(DiscoveryRepo discoveryRepo, MultiListFeedEndpointResponse multiListFeedEndpointResponse) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(multiListFeedEndpointResponse, "response");
        return discoveryRepo.subcategoryResultMapper.apply(multiListFeedEndpointResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlane$lambda-34  reason: not valid java name */
    public static final SingleSource m9707getSwimlane$lambda34(DiscoveryRepo discoveryRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return discoveryRepo.basketApi.getSwimlane(vendor.getVendorId(), discoveryRepo.getSwimlaneQueryMap());
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlane$lambda-37  reason: not valid java name */
    public static final MaybeSource m9708getSwimlane$lambda37(SwimlaneResponse swimlaneResponse) {
        Intrinsics.checkNotNullParameter(swimlaneResponse, "swimlane");
        return Maybe.fromCallable(new h0(swimlaneResponse));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlane$lambda-37$lambda-36  reason: not valid java name */
    public static final SwimlaneResponse m9709getSwimlane$lambda37$lambda36(SwimlaneResponse swimlaneResponse) {
        Intrinsics.checkNotNullParameter(swimlaneResponse, "$swimlane");
        if (!swimlaneResponse.getItems().isEmpty()) {
            return swimlaneResponse;
        }
        return null;
    }

    private final Map<String, String> getSwimlaneQueryMap() {
        ConfigurationParameters configurationParameters2 = this.configurationParameters;
        return MapsKt__MapsKt.mapOf(TuplesKt.to("customer_id", configurationParameters2.getCustomerId()), TuplesKt.to(UrlConstantsKt.PATH_COUNTRY_CODE, configurationParameters2.getCountryCode()), TuplesKt.to("language_code", configurationParameters2.getLanguageCode()), TuplesKt.to("is_darkstore", String.valueOf(!configurationParameters2.isMigrated())), TuplesKt.to("latitude", String.valueOf(configurationParameters2.getLocation().getLatitude())), TuplesKt.to("longitude", String.valueOf(configurationParameters2.getLocation().getLongitude())));
    }

    public static /* synthetic */ Single getTopLevelCategories$default(DiscoveryRepo discoveryRepo, FeedEndpointRequest.PageType pageType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pageType = null;
        }
        return discoveryRepo.getTopLevelCategories(pageType);
    }

    /* access modifiers changed from: private */
    /* renamed from: getTopLevelCategories$lambda-1  reason: not valid java name */
    public static final FeedEndpointRequest m9710getTopLevelCategories$lambda1(DiscoveryRepo discoveryRepo, FeedEndpointRequest.PageType pageType, FeedEndpointRequest feedEndpointRequest) {
        DiscoveryRepo discoveryRepo2 = discoveryRepo;
        FeedEndpointRequest feedEndpointRequest2 = feedEndpointRequest;
        Intrinsics.checkNotNullParameter(discoveryRepo2, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        return FeedEndpointRequest.copy$default(feedEndpointRequest2, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Location) null, CollectionsKt__CollectionsJVMKt.listOf(FeedEndpointRequest.FieldsTypes.category_tree), emptyList, (FeedEndpointRequest.Platform) null, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, (Boolean) null, (String) null, (Boolean) null, pageType, discoveryRepo2.designVariant, 0, 0, false, (Integer) null, (String) null, (String) null, -50528257, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getTopLevelCategories$lambda-2  reason: not valid java name */
    public static final SingleSource m9711getTopLevelCategories$lambda2(DiscoveryRepo discoveryRepo, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return discoveryRepo.feedApi.feedGetMultiList(feedEndpointRequest);
    }

    /* access modifiers changed from: private */
    /* renamed from: getTopLevelCategories$lambda-3  reason: not valid java name */
    public static final List m9712getTopLevelCategories$lambda3(MultiListFeedEndpointResponse multiListFeedEndpointResponse) {
        Intrinsics.checkNotNullParameter(multiListFeedEndpointResponse, "response");
        return multiListFeedEndpointResponse.getCategories();
    }

    private final Map<String, String> pastOrdersQueryMap(Vendor vendor, String str) {
        boolean z11 = !this.configurationParameters.isMigrated();
        Map<String, String> mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ScreenNames.SCREEN_TYPE_BRAND, "talabat"), TuplesKt.to(UrlConstantsKt.PATH_COUNTRY_CODE, this.configurationParameters.getCountryCode()), TuplesKt.to("vendor_id", vendor.getVendorId()), TuplesKt.to("customer_id", this.configurationParameters.getCustomerId()), TuplesKt.to(DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME, str), TuplesKt.to("language_code", this.configurationParameters.getLanguageCode()), TuplesKt.to("is_darkstore", String.valueOf(z11)));
        if (!z11) {
            mutableMapOf.putAll(MapsKt__MapsKt.mapOf(TuplesKt.to("locale", this.configurationParameters.getLanguageCode()), TuplesKt.to(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL, "shops"), TuplesKt.to("product_key_type", TalabatCommonUrlConstantsKt.PRODUCT_ID), TuplesKt.to("numerical_vendor_id", vendor.getVendorCode())));
        }
        return mutableMapOf;
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-11  reason: not valid java name */
    public static final SingleSource m9713search$lambda11(DiscoveryRepo discoveryRepo, String str, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "request");
        return discoveryRepo.discoveryApi.search(feedEndpointRequest).doOnSuccess(new q(discoveryRepo, str)).doOnError(new r(discoveryRepo, str)).map(new s());
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-11$lambda-10  reason: not valid java name */
    public static final List m9714search$lambda11$lambda10(SearchSuggestionsResponse searchSuggestionsResponse) {
        Intrinsics.checkNotNullParameter(searchSuggestionsResponse, "it");
        return searchSuggestionsResponse.getSuggestions().getItems();
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-11$lambda-8  reason: not valid java name */
    public static final void m9715search$lambda11$lambda8(DiscoveryRepo discoveryRepo, String str, SearchSuggestionsResponse searchSuggestionsResponse) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullExpressionValue(searchSuggestionsResponse, "it");
        discoveryRepo.trackEvent(searchSuggestionsResponse, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-11$lambda-9  reason: not valid java name */
    public static final void m9716search$lambda11$lambda9(DiscoveryRepo discoveryRepo, String str, Throwable th2) {
        Intrinsics.checkNotNullParameter(discoveryRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        discoveryRepo.trackSearchError(str, th2.getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-13  reason: not valid java name */
    public static final void m9717search$lambda13(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullExpressionValue(list, DefaultCardView.CARD_LIST);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SearchSuggestion searchSuggestion = (SearchSuggestion) it.next();
            if (!StringsKt__StringsJVMKt.isBlank(str)) {
                searchSuggestion.setOriginalSearchQuery(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-7  reason: not valid java name */
    public static final FeedEndpointRequest m9718search$lambda7(String str, FeedEndpointRequest feedEndpointRequest) {
        FeedEndpointRequest feedEndpointRequest2 = feedEndpointRequest;
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        return FeedEndpointRequest.copy$default(feedEndpointRequest2, str, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Location) null, CollectionsKt__CollectionsJVMKt.listOf(FeedEndpointRequest.FieldsTypes.suggestions), (List) null, (FeedEndpointRequest.Platform) null, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, (Boolean) null, (String) null, Boolean.FALSE, (FeedEndpointRequest.PageType) null, 0, 0, 0, false, (Integer) null, (String) null, (String) null, -8454146, (Object) null);
    }

    /* access modifiers changed from: private */
    @JvmName(name = "searchSuggestionGetAllProducts")
    public final List<Product> searchSuggestionGetAllProducts(List<? extends SearchSuggestion> list) {
        ArrayList<ProductSuggestion> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (next instanceof ProductSuggestion) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (ProductSuggestion product : arrayList) {
            arrayList2.add(product.getProduct());
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    @JvmName(name = "swimlaneGetAllProduTalabatFeatureFlagConstantscts")
    public final List<Product> swimlaneGetAllProduTalabatFeatureFlagConstantscts(List<Swimlane> list) {
        ArrayList arrayList = new ArrayList();
        for (Swimlane products : list) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, products.getProducts());
        }
        return arrayList;
    }

    private final void trackEvent(SearchSuggestionsResponse searchSuggestionsResponse, String str) {
        SearchResponse.TrackingData trackingData = searchSuggestionsResponse.getTrackingData();
        new DiscoveryRepo$trackEvent$1$2(this).set(searchSuggestionsResponse.getRequestId());
        if (trackingData.isEmpty()) {
            SearchTracker.searchError$default(this.searchTracker, str, searchSuggestionsResponse.getRequestId(), (String) null, 4, (Object) null);
            return;
        }
        this.searchTracker.searchResultsLoaded(trackingData.getProductsCount(), str, searchSuggestionsResponse.getRequestId());
    }

    private final void trackProductDetailsNotLoaded(String str, String str2, String str3) {
        NfvObservabilityHandler.INSTANCE.onProductDetailsNotLoaded(str, str2, str3);
    }

    private final void trackSearchError(String str, String str2) {
        this.searchTracker.searchError(str, "", str2);
    }

    @NotNull
    public final Single<Pair<List<Product>, Integer>> getAllProducts() {
        Single<R> flatMap = this.baseFeedRequestObservable.flatMap(new g0(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "baseFeedRequestObservabl…etProducts(it, 5000, 0) }");
        return flatMap;
    }

    @Nullable
    public final String getLastSearchRequestId() {
        return this.lastSearchRequestId;
    }

    @NotNull
    public final Maybe<List<Product>> getPastOrders(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sortingStrategy");
        Single<R> flatMap = this.darkstoresRepo.getVendor().subscribeOn(this.ioScheduler).flatMap(new t(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "darkstoresRepo.getVendor…)\n            }\n        }");
        Maybe<R> onErrorComplete = applyCampaignTriggers(applyDiscounts(flatMap, DiscoveryRepo$getPastOrders$2.INSTANCE), DiscoveryRepo$getPastOrders$3.INSTANCE).flatMapMaybe(new u()).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "darkstoresRepo.getVendor…       .onErrorComplete()");
        return onErrorComplete;
    }

    @NotNull
    public final Single<SearchResultData> getPopularProducts() {
        return getProductsForTag("basketncr", 10, 0);
    }

    @NotNull
    public final Single<Product> getProductDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Single<R> subscribeOn = this.baseFeedRequestObservable.flatMap(new k0(this, str)).doOnError(new l0(this, str)).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "baseFeedRequestObservabl…scribeOn(Schedulers.io())");
        return applyCampaignTriggers(applyDiscounts(subscribeOn, DiscoveryRepo$getProductDetails$3.INSTANCE), DiscoveryRepo$getProductDetails$4.INSTANCE);
    }

    @NotNull
    public final Single<Product> getProductDetailsBySku(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        Single<R> subscribeOn = this.baseFeedRequestObservable.flatMap(new l(this, str)).doOnError(new w(this, str)).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "baseFeedRequestObservabl…scribeOn(Schedulers.io())");
        return applyCampaignTriggers(applyDiscounts(subscribeOn, DiscoveryRepo$getProductDetailsBySku$3.INSTANCE), DiscoveryRepo$getProductDetailsBySku$4.INSTANCE);
    }

    @NotNull
    public final Single<SearchResultData> getProductsForCategory(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Single<R> flatMap = this.baseFeedRequestObservable.map(new k(str)).flatMap(new m(this, i11, i12));
        Intrinsics.checkNotNullExpressionValue(flatMap, "baseFeedRequestObservabl…          }\n            }");
        return flatMap;
    }

    @NotNull
    public final Single<SearchResultData> getProductsForTag(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, com.talabat.talabatcommon.feature.darkstores.lookingGlass.UrlConstantsKt.PRODUCT_TAG);
        Single<R> flatMap = this.baseFeedRequestObservable.map(new i0(str)).flatMap(new j0(this, i11, i12));
        Intrinsics.checkNotNullExpressionValue(flatMap, "baseFeedRequestObservabl…          }\n            }");
        return flatMap;
    }

    @NotNull
    public final Single<SubcategorySwimalnesResponse> getSubcategorySwimlanes(@NotNull String str, @Nullable FeedEndpointRequest.PageType pageType, int i11, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "parentCategoryId");
        Single<R> map = this.baseFeedRequestObservable.map(new c0(str, pageType, i11, str2)).flatMap(new d0(this)).subscribeOn(Schedulers.io()).map(new e0(this));
        Intrinsics.checkNotNullExpressionValue(map, "baseFeedRequestObservabl…y(response)\n            }");
        return applyCampaignTriggers(applyDiscounts(map, new DiscoveryRepo$getSubcategorySwimlanes$4(this)), new DiscoveryRepo$getSubcategorySwimlanes$5(this));
    }

    @NotNull
    public final Maybe<SwimlaneResponse> getSwimlane() {
        Single<R> flatMap = this.darkstoresRepo.getVendor().subscribeOn(this.ioScheduler).flatMap(new g(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "darkstoresRepo.getVendor…          )\n            }");
        Maybe<R> onErrorComplete = applyCampaignTriggers(applyDiscounts(flatMap, DiscoveryRepo$getSwimlane$2.INSTANCE), DiscoveryRepo$getSwimlane$3.INSTANCE).flatMapMaybe(new h()).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "darkstoresRepo.getVendor…      }.onErrorComplete()");
        return onErrorComplete;
    }

    @NotNull
    public final Single<List<TagResponse>> getTagsForCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Single<List<TagResponse>> subscribeOn = this.discoveryApi.getTags(str, this.configurationParameters.getLanguageCode()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "discoveryApi.getTags(cat…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    @NotNull
    public final Single<List<Category>> getTopLevelCategories(@Nullable FeedEndpointRequest.PageType pageType) {
        Single<R> map = this.baseFeedRequestObservable.map(new d(this, pageType)).flatMap(new e(this)).subscribeOn(Schedulers.io()).map(new f());
        Intrinsics.checkNotNullExpressionValue(map, "baseFeedRequestObservabl… -> response.categories }");
        return map;
    }

    public final boolean isPromoTagEnabled() {
        return this.isPromoTagEnabled;
    }

    @NotNull
    public final Single<List<SearchSuggestion>> search(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Single<R> subscribeOn = this.baseFeedRequestObservable.map(new z(str)).flatMap(new a0(this, str)).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "baseFeedRequestObservabl…scribeOn(Schedulers.io())");
        Single<R> doOnSuccess = applyCampaignTriggers(applyDiscounts(subscribeOn, new DiscoveryRepo$search$3(this)), new DiscoveryRepo$search$4(this)).doOnSuccess(new b0(str));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "fun search(query: String…    }\n            }\n    }");
        return doOnSuccess;
    }

    private final void applyDiscounts(List<ProductDiscount> list, List<Product> list2) {
        Object obj;
        for (Product product : list2) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((ProductDiscount) obj).getProductId(), (Object) product.getId())) {
                    break;
                }
            }
            ProductDiscount productDiscount = (ProductDiscount) obj;
            if (productDiscount != null) {
                product.setPrice(productDiscount.getDiscountedPrice());
                product.setPreviousPrice(Float.valueOf(productDiscount.getOriginalPrice()));
            }
        }
    }

    public final void applyCampaignTriggers(@NotNull List<CampaignTrigger> list, @NotNull List<Product> list2) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "triggers");
        Intrinsics.checkNotNullParameter(list2, "products");
        for (Product product : list2) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((CampaignTrigger) obj).getId(), (Object) product.getId())) {
                    break;
                }
            }
            CampaignTrigger campaignTrigger = (CampaignTrigger) obj;
            if (campaignTrigger != null) {
                product.setCampaignTrigger(campaignTrigger);
            }
        }
    }
}
