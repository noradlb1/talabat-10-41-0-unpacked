package com.talabat.darkstores.data.mission.control;

import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceRemoteConfigurationsKeys;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.darkstores.model.SearchConfig;
import com.talabat.darkstores.data.search.model.SearchResultsRequest;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapper;
import com.talabat.darkstores.domain.model.MissionControlProducts;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import gi.a;
import gi.b;
import gi.c;
import gi.d;
import gi.e;
import gi.f;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ4\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J2\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0007J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0014J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/MissionControlProductRepository;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "remoteConfigDataSource", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "missionControlProductApi", "Lcom/talabat/darkstores/data/mission/control/MissionControlProductApi;", "mapMissionControlResponse", "Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapper;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/mission/control/MissionControlProductApi;Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapper;Lio/reactivex/Scheduler;)V", "baseRequest", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest;", "createBaseSearchRequestWithVendorId", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "limit", "", "offset", "categoryId", "getConfig", "getDeprecatedMissionControlProducts", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "missionCode", "getMissionControlProducts", "Lcom/talabat/darkstores/domain/model/MissionControlProducts;", "swimlaneId", "pageNumber", "filterCategoryId", "trackIfEmptyResponse", "", "vendorId", "response", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProductRepository {
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
    private final MissionControlProductsResponseToDomainMapper mapMissionControlResponse;
    @NotNull
    private final MissionControlProductApi missionControlProductApi;
    @NotNull
    private final IRemoteConfigurationDataSource remoteConfigDataSource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/MissionControlProductRepository$Companion;", "", "()V", "BRAND", "", "DEFAULT_FILTER_VARIANT", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public MissionControlProductRepository(@NotNull ConfigurationParameters configurationParameters2, @NotNull IRemoteConfigurationDataSource iRemoteConfigurationDataSource, @NotNull DarkstoresRepo darkstoresRepo2, @NotNull MissionControlProductApi missionControlProductApi2, @NotNull MissionControlProductsResponseToDomainMapper missionControlProductsResponseToDomainMapper, @IoScheduler @NotNull Scheduler scheduler) {
        ConfigurationParameters configurationParameters3 = configurationParameters2;
        IRemoteConfigurationDataSource iRemoteConfigurationDataSource2 = iRemoteConfigurationDataSource;
        DarkstoresRepo darkstoresRepo3 = darkstoresRepo2;
        MissionControlProductApi missionControlProductApi3 = missionControlProductApi2;
        MissionControlProductsResponseToDomainMapper missionControlProductsResponseToDomainMapper2 = missionControlProductsResponseToDomainMapper;
        Scheduler scheduler2 = scheduler;
        Intrinsics.checkNotNullParameter(configurationParameters3, "configurationParameters");
        Intrinsics.checkNotNullParameter(iRemoteConfigurationDataSource2, "remoteConfigDataSource");
        Intrinsics.checkNotNullParameter(darkstoresRepo3, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(missionControlProductApi3, "missionControlProductApi");
        Intrinsics.checkNotNullParameter(missionControlProductsResponseToDomainMapper2, "mapMissionControlResponse");
        Intrinsics.checkNotNullParameter(scheduler2, "ioScheduler");
        this.configurationParameters = configurationParameters3;
        this.remoteConfigDataSource = iRemoteConfigurationDataSource2;
        this.darkstoresRepo = darkstoresRepo3;
        this.missionControlProductApi = missionControlProductApi3;
        this.mapMissionControlResponse = missionControlProductsResponseToDomainMapper2;
        this.ioScheduler = scheduler2;
        this.baseRequest = new SearchResultsRequest("talabat", getConfig(), configurationParameters2.getCountryCode(), !configurationParameters2.isMigrated(), configurationParameters2.getLanguageCode(), (List) null, (SearchResultsRequest.Filters) null, (Integer) null, (Integer) null, (String) null, configurationParameters2.getCustomerId(), (String) null, 3040, (DefaultConstructorMarker) null);
    }

    private final Single<Pair<SearchResultsRequest, String>> createBaseSearchRequestWithVendorId(int i11, int i12, String str) {
        Single<R> map = this.darkstoresRepo.getVendor().map(new f(this, str, i11, i12));
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresRepo.getVendor…or.vendorId\n            }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: createBaseSearchRequestWithVendorId$lambda-4  reason: not valid java name */
    public static final Pair m9720createBaseSearchRequestWithVendorId$lambda4(MissionControlProductRepository missionControlProductRepository, String str, int i11, int i12, Vendor vendor) {
        MissionControlProductRepository missionControlProductRepository2 = missionControlProductRepository;
        Intrinsics.checkNotNullParameter(missionControlProductRepository2, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return TuplesKt.to(SearchResultsRequest.copy$default(missionControlProductRepository2.baseRequest, (String) null, (String) null, (String) null, false, (String) null, (List) null, new SearchResultsRequest.Filters(CollectionsKt__CollectionsKt.listOfNotNull(str), 2), Integer.valueOf(i11), Integer.valueOf(i12), (String) null, (String) null, vendor.getVendorCode(), 1599, (Object) null), vendor.getVendorId());
    }

    private final String getConfig() {
        return ((SearchConfig) this.remoteConfigDataSource.getRemoteConfiguration(QCommerceRemoteConfigurationsKeys.DARKSTORES_SEARCH_CONFIG, new SearchConfig((String) null, 1, (DefaultConstructorMarker) null), SearchConfig.class)).getSearchConfiguration();
    }

    public static /* synthetic */ Single getDeprecatedMissionControlProducts$default(MissionControlProductRepository missionControlProductRepository, String str, int i11, int i12, String str2, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            str2 = null;
        }
        return missionControlProductRepository.getDeprecatedMissionControlProducts(str, i11, i12, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeprecatedMissionControlProducts$lambda-0  reason: not valid java name */
    public static final Pair m9721getDeprecatedMissionControlProducts$lambda0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        String str = (String) pair.component2();
        List listOf = CollectionsKt__CollectionsJVMKt.listOf(new SearchResultsRequest.Vendor(str));
        return TuplesKt.to(SearchResultsRequest.copy$default((SearchResultsRequest) pair.component1(), (String) null, (String) null, (String) null, false, (String) null, listOf, (SearchResultsRequest.Filters) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, 4063, (Object) null), str);
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeprecatedMissionControlProducts$lambda-2  reason: not valid java name */
    public static final SingleSource m9722getDeprecatedMissionControlProducts$lambda2(MissionControlProductRepository missionControlProductRepository, String str, Pair pair) {
        Intrinsics.checkNotNullParameter(missionControlProductRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$missionCode");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return missionControlProductRepository.missionControlProductApi.getMissionControlProducts(missionControlProductRepository.configurationParameters.getCountryCode(), str, (SearchResultsRequest) pair.component1()).doOnSuccess(new a(missionControlProductRepository, (String) pair.component2(), str)).subscribeOn(missionControlProductRepository.ioScheduler);
    }

    /* access modifiers changed from: private */
    /* renamed from: getDeprecatedMissionControlProducts$lambda-2$lambda-1  reason: not valid java name */
    public static final void m9723getDeprecatedMissionControlProducts$lambda2$lambda1(MissionControlProductRepository missionControlProductRepository, String str, String str2, SearchResultsResponse searchResultsResponse) {
        Intrinsics.checkNotNullParameter(missionControlProductRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$vendorId");
        Intrinsics.checkNotNullParameter(str2, "$missionCode");
        Intrinsics.checkNotNullExpressionValue(searchResultsResponse, "response");
        missionControlProductRepository.trackIfEmptyResponse(str, str2, searchResultsResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getMissionControlProducts$lambda-3  reason: not valid java name */
    public static final SingleSource m9724getMissionControlProducts$lambda3(MissionControlProductRepository missionControlProductRepository, String str, int i11, String str2, Vendor vendor) {
        Intrinsics.checkNotNullParameter(missionControlProductRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$swimlaneId");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return missionControlProductRepository.missionControlProductApi.getMissionControlProducts(missionControlProductRepository.configurationParameters.getCountryCode(), str, vendor.getVendorId(), missionControlProductRepository.configurationParameters.getBranchId(), !missionControlProductRepository.configurationParameters.isMigrated(), i11, str2);
    }

    private final void trackIfEmptyResponse(String str, String str2, SearchResultsResponse searchResultsResponse) {
        if (searchResultsResponse.getItemCounts().getReturned() <= 0) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresEmptySearchResults(str, str2);
        }
    }

    @NotNull
    @Deprecated(message = "To be replaced with getMissionControlProducts")
    public final Single<SearchResultsResponse> getDeprecatedMissionControlProducts(@NotNull String str, int i11, int i12, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "missionCode");
        Single<R> flatMap = createBaseSearchRequestWithVendorId(i11, i12, str2).map(new b()).flatMap(new c(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "createBaseSearchRequestW…oScheduler)\n            }");
        return flatMap;
    }

    @NotNull
    public final Single<MissionControlProducts> getMissionControlProducts(@NotNull String str, int i11, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Single<R> subscribeOn = this.darkstoresRepo.getVendor().flatMap(new d(this, str, i11, str2)).map(new e(this.mapMissionControlResponse)).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "darkstoresRepo.getVendor….subscribeOn(ioScheduler)");
        return subscribeOn;
    }
}
