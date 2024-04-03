package com.talabat.darkstores.data.search;

import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceRemoteConfigurationsKeys;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.darkstores.model.SearchConfig;
import com.talabat.darkstores.data.search.model.QCommerceSearchResultsResponse;
import com.talabat.darkstores.data.search.model.SearchCategoryRequest;
import com.talabat.darkstores.data.search.model.SearchCategoryResponse;
import com.talabat.darkstores.data.search.model.SearchResultsRequest;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import li.a;
import li.b;
import li.c;
import li.d;
import li.e;
import li.f;
import li.g;
import li.h;
import li.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J<\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00142\u0006\u0010\u0017\u001a\u00020\u0016J0\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010(\u001a\u00020 H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/talabat/darkstores/data/search/SearchRepository;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "remoteConfigDataSource", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "searchApi", "Lcom/talabat/darkstores/data/search/SearchApi;", "qcGroceryCategorySearchApi", "Lcom/talabat/darkstores/data/search/QCommerceGroceryApi;", "qCommerceSearchApi", "Lcom/talabat/darkstores/data/search/QCommerceSearchApi;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/search/SearchApi;Lcom/talabat/darkstores/data/search/QCommerceGroceryApi;Lcom/talabat/darkstores/data/search/QCommerceSearchApi;Lio/reactivex/Scheduler;)V", "baseRequest", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest;", "createBaseSearchRequestWithVendorId", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "query", "limit", "", "offset", "categoryId", "getConfig", "getSearchCategoryRequest", "Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest;", "search", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "searchCategory", "Lcom/talabat/darkstores/data/search/model/SearchCategoryResponse;", "searchProductsQCommerce", "trackEmptyResponse", "", "vendorId", "trackIfEmptyResponse", "response", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchRepository {
    @NotNull
    @Deprecated
    public static final String BRAND = "talabat";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int DEFAULT_FILTER_VARIANT = 2;
    @NotNull
    private final SearchResultsRequest baseRequest;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final QCommerceSearchApi qCommerceSearchApi;
    @NotNull
    private final QCommerceGroceryApi qcGroceryCategorySearchApi;
    @NotNull
    private final IRemoteConfigurationDataSource remoteConfigDataSource;
    @NotNull
    private final SearchApi searchApi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/search/SearchRepository$Companion;", "", "()V", "BRAND", "", "DEFAULT_FILTER_VARIANT", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SearchRepository(@NotNull ConfigurationParameters configurationParameters2, @NotNull IRemoteConfigurationDataSource iRemoteConfigurationDataSource, @NotNull DarkstoresRepo darkstoresRepo2, @NotNull SearchApi searchApi2, @NotNull QCommerceGroceryApi qCommerceGroceryApi, @NotNull QCommerceSearchApi qCommerceSearchApi2, @IoScheduler @NotNull Scheduler scheduler) {
        ConfigurationParameters configurationParameters3 = configurationParameters2;
        IRemoteConfigurationDataSource iRemoteConfigurationDataSource2 = iRemoteConfigurationDataSource;
        DarkstoresRepo darkstoresRepo3 = darkstoresRepo2;
        SearchApi searchApi3 = searchApi2;
        QCommerceGroceryApi qCommerceGroceryApi2 = qCommerceGroceryApi;
        QCommerceSearchApi qCommerceSearchApi3 = qCommerceSearchApi2;
        Scheduler scheduler2 = scheduler;
        Intrinsics.checkNotNullParameter(configurationParameters3, "configurationParameters");
        Intrinsics.checkNotNullParameter(iRemoteConfigurationDataSource2, "remoteConfigDataSource");
        Intrinsics.checkNotNullParameter(darkstoresRepo3, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(searchApi3, "searchApi");
        Intrinsics.checkNotNullParameter(qCommerceGroceryApi2, "qcGroceryCategorySearchApi");
        Intrinsics.checkNotNullParameter(qCommerceSearchApi3, "qCommerceSearchApi");
        Intrinsics.checkNotNullParameter(scheduler2, "ioScheduler");
        this.configurationParameters = configurationParameters3;
        this.remoteConfigDataSource = iRemoteConfigurationDataSource2;
        this.darkstoresRepo = darkstoresRepo3;
        this.searchApi = searchApi3;
        this.qcGroceryCategorySearchApi = qCommerceGroceryApi2;
        this.qCommerceSearchApi = qCommerceSearchApi3;
        this.ioScheduler = scheduler2;
        this.baseRequest = new SearchResultsRequest("talabat", getConfig(), configurationParameters2.getCountryCode(), true, configurationParameters2.getLanguageCode(), (List) null, (SearchResultsRequest.Filters) null, (Integer) null, (Integer) null, (String) null, configurationParameters2.getCustomerId(), (String) null, 3040, (DefaultConstructorMarker) null);
    }

    private final Single<Pair<SearchResultsRequest, String>> createBaseSearchRequestWithVendorId(String str, int i11, int i12, String str2) {
        Single<R> map = this.darkstoresRepo.getVendor().map(new c(this, str2, i11, i12, str));
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresRepo.getVendor…or.vendorId\n            }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: createBaseSearchRequestWithVendorId$lambda-6  reason: not valid java name */
    public static final Pair m9733createBaseSearchRequestWithVendorId$lambda6(SearchRepository searchRepository, String str, int i11, int i12, String str2, Vendor vendor) {
        SearchRepository searchRepository2 = searchRepository;
        Intrinsics.checkNotNullParameter(searchRepository2, "this$0");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "$query");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return TuplesKt.to(SearchResultsRequest.copy$default(searchRepository2.baseRequest, (String) null, (String) null, (String) null, false, (String) null, (List) null, new SearchResultsRequest.Filters(CollectionsKt__CollectionsKt.listOfNotNull(str), 2), Integer.valueOf(i11), Integer.valueOf(i12), str3, (String) null, (String) null, 3135, (Object) null), vendor.getVendorId());
    }

    private final String getConfig() {
        return ((SearchConfig) this.remoteConfigDataSource.getRemoteConfiguration(QCommerceRemoteConfigurationsKeys.DARKSTORES_SEARCH_CONFIG, new SearchConfig((String) null, 1, (DefaultConstructorMarker) null), SearchConfig.class)).getSearchConfiguration();
    }

    private final SearchCategoryRequest getSearchCategoryRequest() {
        return new SearchCategoryRequest(getConfig(), (String) null, (List) null, this.configurationParameters.getCountryCode(), "talabat", true, this.configurationParameters.getLanguageCode(), 6, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Single search$default(SearchRepository searchRepository, String str, int i11, int i12, String str2, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            str2 = null;
        }
        return searchRepository.search(str, i11, i12, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-0  reason: not valid java name */
    public static final Pair m9734search$lambda0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        String str = (String) pair.component2();
        List listOf = CollectionsKt__CollectionsJVMKt.listOf(new SearchResultsRequest.Vendor(str));
        return TuplesKt.to(SearchResultsRequest.copy$default((SearchResultsRequest) pair.component1(), (String) null, (String) null, (String) null, false, (String) null, listOf, (SearchResultsRequest.Filters) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, 4063, (Object) null), str);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-2  reason: not valid java name */
    public static final SingleSource m9735search$lambda2(SearchRepository searchRepository, String str, Pair pair) {
        Intrinsics.checkNotNullParameter(searchRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return searchRepository.searchApi.search((SearchResultsRequest) pair.component1()).doOnSuccess(new d(searchRepository, (String) pair.component2(), str)).subscribeOn(searchRepository.ioScheduler);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-2$lambda-1  reason: not valid java name */
    public static final void m9736search$lambda2$lambda1(SearchRepository searchRepository, String str, String str2, SearchResultsResponse searchResultsResponse) {
        Intrinsics.checkNotNullParameter(searchRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$vendorId");
        Intrinsics.checkNotNullParameter(str2, "$query");
        Intrinsics.checkNotNullExpressionValue(searchResultsResponse, "response");
        searchRepository.trackIfEmptyResponse(str, str2, searchResultsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchCategory$lambda-7  reason: not valid java name */
    public static final SearchCategoryRequest m9737searchCategory$lambda7(SearchRepository searchRepository, String str, Vendor vendor) {
        Intrinsics.checkNotNullParameter(searchRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return SearchCategoryRequest.copy$default(searchRepository.getSearchCategoryRequest(), (String) null, str, CollectionsKt__CollectionsJVMKt.listOf(new SearchCategoryRequest.Vendor(vendor.getVendorId())), (String) null, (String) null, false, (String) null, 121, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchCategory$lambda-8  reason: not valid java name */
    public static final SingleSource m9738searchCategory$lambda8(SearchRepository searchRepository, SearchCategoryRequest searchCategoryRequest) {
        Intrinsics.checkNotNullParameter(searchRepository, "this$0");
        Intrinsics.checkNotNullParameter(searchCategoryRequest, "searchCategoryRequest");
        return searchRepository.qcGroceryCategorySearchApi.searchCategory(searchCategoryRequest).subscribeOn(searchRepository.ioScheduler);
    }

    public static /* synthetic */ Single searchProductsQCommerce$default(SearchRepository searchRepository, String str, int i11, int i12, String str2, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            str2 = null;
        }
        return searchRepository.searchProductsQCommerce(str, i11, i12, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchProductsQCommerce$lambda-5  reason: not valid java name */
    public static final SingleSource m9739searchProductsQCommerce$lambda5(SearchRepository searchRepository, String str, Pair pair) {
        Intrinsics.checkNotNullParameter(searchRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        String str2 = (String) pair.component2();
        return searchRepository.qCommerceSearchApi.searchProducts(str2, (SearchResultsRequest) pair.component1()).map(new h(SearchRepository$searchProductsQCommerce$1$1.INSTANCE)).doOnSuccess(new i(searchRepository, str2, str)).subscribeOn(searchRepository.ioScheduler);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchProductsQCommerce$lambda-5$lambda-3  reason: not valid java name */
    public static final SearchResultsResponse m9740searchProductsQCommerce$lambda5$lambda3(KProperty1 kProperty1, QCommerceSearchResultsResponse qCommerceSearchResultsResponse) {
        Intrinsics.checkNotNullParameter(kProperty1, "$tmp0");
        return (SearchResultsResponse) kProperty1.invoke(qCommerceSearchResultsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchProductsQCommerce$lambda-5$lambda-4  reason: not valid java name */
    public static final void m9741searchProductsQCommerce$lambda5$lambda4(SearchRepository searchRepository, String str, String str2, SearchResultsResponse searchResultsResponse) {
        Intrinsics.checkNotNullParameter(searchRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$vendorId");
        Intrinsics.checkNotNullParameter(str2, "$query");
        Intrinsics.checkNotNullExpressionValue(searchResultsResponse, "response");
        searchRepository.trackIfEmptyResponse(str, str2, searchResultsResponse);
    }

    private final void trackEmptyResponse(String str, String str2) {
        NfvObservabilityHandler.INSTANCE.onDarkstoresEmptySearchResults(str, str2);
    }

    private final void trackIfEmptyResponse(String str, String str2, SearchResultsResponse searchResultsResponse) {
        if (searchResultsResponse.getItemCounts().getReturned() <= 0) {
            trackEmptyResponse(str, str2);
        }
    }

    @NotNull
    public final Single<SearchResultsResponse> search(@NotNull String str, int i11, int i12, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Single<R> flatMap = createBaseSearchRequestWithVendorId(str, i11, i12, str2).map(new e()).flatMap(new f(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "createBaseSearchRequestW…oScheduler)\n            }");
        return flatMap;
    }

    @NotNull
    public final Single<SearchCategoryResponse> searchCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Single<R> flatMap = this.darkstoresRepo.getVendor().map(new a(this, str)).flatMap(new b(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "darkstoresRepo.getVendor…On(ioScheduler)\n        }");
        return flatMap;
    }

    @NotNull
    public final Single<SearchResultsResponse> searchProductsQCommerce(@NotNull String str, int i11, int i12, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Single<R> flatMap = createBaseSearchRequestWithVendorId(str, i11, i12, str2).flatMap(new g(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "createBaseSearchRequestW…oScheduler)\n            }");
        return flatMap;
    }
}
