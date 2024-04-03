package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.data.discovery.model.Location;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLandingRequest;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLandingRequestV2;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.mapper.ModelMapper;
import dj.c0;
import dj.d0;
import dj.e0;
import dj.f0;
import dj.g0;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCaseImpl;", "Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCase;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "ioScheduler", "Lio/reactivex/Scheduler;", "vendorLandingRepository", "Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;", "vendorLandingToFeedsMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "Lcom/talabat/darkstores/data/discovery/model/FeedMultiListData;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "applyDiscountsAndCampaigns", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "isVendorLightningOptimizationEnabledUseCase", "Lcom/talabat/darkstores/feature/home/usecase/IsVendorLightningOptimizationEnabledUseCase;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lio/reactivex/Scheduler;Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;Lcom/talabat/darkstores/feature/home/usecase/IsVendorLightningOptimizationEnabledUseCase;)V", "feedRequestObservable", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest;", "kotlin.jvm.PlatformType", "getFeedMultiListData", "pageType", "Lcom/talabat/darkstores/data/discovery/model/FeedEndpointRequest$PageType;", "getFeedsFromVendorLanding", "feedEndpointRequestSingle", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingFeedUseCaseImpl implements VendorLandingFeedUseCase {
    @NotNull
    private final ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaigns;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final Single<FeedEndpointRequest> feedRequestObservable;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final IsVendorLightningOptimizationEnabledUseCase isVendorLightningOptimizationEnabledUseCase;
    @NotNull
    private final VendorLandingRepository vendorLandingRepository;
    @NotNull
    private final ModelMapper<VendorLanding, FeedMultiListData> vendorLandingToFeedsMapper;

    @Inject
    public VendorLandingFeedUseCaseImpl(@NotNull ConfigurationParameters configurationParameters2, @IoScheduler @NotNull Scheduler scheduler, @NotNull VendorLandingRepository vendorLandingRepository2, @NotNull ModelMapper<VendorLanding, FeedMultiListData> modelMapper, @NotNull DarkstoresRepo darkstoresRepo, @NotNull ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase, @NotNull IsVendorLightningOptimizationEnabledUseCase isVendorLightningOptimizationEnabledUseCase2) {
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(vendorLandingRepository2, "vendorLandingRepository");
        Intrinsics.checkNotNullParameter(modelMapper, "vendorLandingToFeedsMapper");
        Intrinsics.checkNotNullParameter(darkstoresRepo, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(applyDiscountsAndCampaignsUseCase, "applyDiscountsAndCampaigns");
        Intrinsics.checkNotNullParameter(isVendorLightningOptimizationEnabledUseCase2, "isVendorLightningOptimizationEnabledUseCase");
        this.configurationParameters = configurationParameters2;
        this.ioScheduler = scheduler;
        this.vendorLandingRepository = vendorLandingRepository2;
        this.vendorLandingToFeedsMapper = modelMapper;
        this.applyDiscountsAndCampaigns = applyDiscountsAndCampaignsUseCase;
        this.isVendorLightningOptimizationEnabledUseCase = isVendorLightningOptimizationEnabledUseCase2;
        Single<R> map = darkstoresRepo.getVendor().map(new e0(this));
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresRepo.getVendor…d\n            )\n        }");
        this.feedRequestObservable = SingleExtensionsKt.cacheButRetryOnError(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: feedRequestObservable$lambda-0  reason: not valid java name */
    public static final FeedEndpointRequest m9969feedRequestObservable$lambda0(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl, Vendor vendor) {
        VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl2 = vendorLandingFeedUseCaseImpl;
        Intrinsics.checkNotNullParameter(vendorLandingFeedUseCaseImpl2, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        FeedEndpointRequest.Platform platform = FeedEndpointRequest.Platform.android;
        String vendorId = vendor.getVendorId();
        String valueOf = String.valueOf(vendorLandingFeedUseCaseImpl2.configurationParameters.getBranchId());
        Location location = r1;
        Location location2 = new Location(vendorLandingFeedUseCaseImpl2.configurationParameters.getLocation(), (String) null, (String) null, 6, (DefaultConstructorMarker) null);
        return new FeedEndpointRequest((String) null, (String) null, (Boolean) null, vendorLandingFeedUseCaseImpl2.configurationParameters.getCountryCode(), vendorLandingFeedUseCaseImpl2.configurationParameters.getLanguageCode(), (String) null, "talabat", vendorId, valueOf, vendorLandingFeedUseCaseImpl2.configurationParameters.getCustomerId(), (String) null, (String) null, "dark_stores-config-1", (Integer) null, (Integer) null, location, (List) null, (List) null, platform, (FeedEndpointRequest.VerticalTypes) null, (FeedEndpointRequest.ExpeditionTypes) null, Boolean.TRUE, (String) null, (Boolean) null, (FeedEndpointRequest.PageType) null, 0, 0, 0, false, Integer.valueOf(vendorLandingFeedUseCaseImpl2.configurationParameters.getChainId()), (String) null, (String) null, -539268057, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getFeedMultiListData$lambda-1  reason: not valid java name */
    public static final FeedMultiListData m9970getFeedMultiListData$lambda1(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl, VendorLanding vendorLanding) {
        Intrinsics.checkNotNullParameter(vendorLandingFeedUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorLanding, "it");
        return vendorLandingFeedUseCaseImpl.vendorLandingToFeedsMapper.apply(vendorLanding);
    }

    /* access modifiers changed from: private */
    /* renamed from: getFeedMultiListData$lambda-2  reason: not valid java name */
    public static final SingleSource m9971getFeedMultiListData$lambda2(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl, FeedMultiListData feedMultiListData) {
        Intrinsics.checkNotNullParameter(vendorLandingFeedUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(feedMultiListData, "it");
        return vendorLandingFeedUseCaseImpl.applyDiscountsAndCampaigns.invoke(feedMultiListData);
    }

    private final Single<FeedMultiListData> getFeedsFromVendorLanding(Single<FeedEndpointRequest> single) {
        Single<R> map = single.flatMap(new f0(this)).subscribeOn(this.ioScheduler).map(new g0(this));
        Intrinsics.checkNotNullExpressionValue(map, "feedEndpointRequestSingl…edsMapper.apply(it)\n    }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getFeedsFromVendorLanding$lambda-3  reason: not valid java name */
    public static final SingleSource m9972getFeedsFromVendorLanding$lambda3(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl, FeedEndpointRequest feedEndpointRequest) {
        Intrinsics.checkNotNullParameter(vendorLandingFeedUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(feedEndpointRequest, "it");
        String countryCode = vendorLandingFeedUseCaseImpl.configurationParameters.getCountryCode();
        String vendorId = feedEndpointRequest.getVendorId();
        String branchId = feedEndpointRequest.getBranchId();
        if (branchId == null) {
            branchId = "";
        }
        return vendorLandingFeedUseCaseImpl.vendorLandingRepository.getVendorLandingResponse(new VendorLandingRequest(countryCode, vendorId, branchId, !vendorLandingFeedUseCaseImpl.configurationParameters.isMigrated()));
    }

    /* access modifiers changed from: private */
    /* renamed from: getFeedsFromVendorLanding$lambda-4  reason: not valid java name */
    public static final FeedMultiListData m9973getFeedsFromVendorLanding$lambda4(VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl, VendorLanding vendorLanding) {
        Intrinsics.checkNotNullParameter(vendorLandingFeedUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorLanding, "it");
        return vendorLandingFeedUseCaseImpl.vendorLandingToFeedsMapper.apply(vendorLanding);
    }

    @NotNull
    public Single<FeedMultiListData> getFeedMultiListData(@Nullable FeedEndpointRequest.PageType pageType) {
        if (this.isVendorLightningOptimizationEnabledUseCase.invoke()) {
            Single<R> map = this.vendorLandingRepository.getVendorLandingResponseV2(new VendorLandingRequestV2(this.configurationParameters.getCountryCode(), this.configurationParameters.getVendorCode(), this.configurationParameters.getRestaurant().isDarkStore, String.valueOf(this.configurationParameters.getLocation().getLatitude()), String.valueOf(this.configurationParameters.getLocation().getLongitude()))).subscribeOn(this.ioScheduler).map(new c0(this));
            Intrinsics.checkNotNullExpressionValue(map, "vendorLandingRepository.…ply(it)\n                }");
            return map;
        }
        Single<R> flatMap = getFeedsFromVendorLanding(this.feedRequestObservable).flatMap(new d0(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "getFeedsFromVendorLandin…mpaigns(it)\n            }");
        return flatMap;
    }
}
