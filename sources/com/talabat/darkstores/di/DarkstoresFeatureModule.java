package com.talabat.darkstores.di;

import com.talabat.darkstores.data.disclaimer.DisclaimerRepositoryImpl;
import com.talabat.darkstores.data.discovery.mappers.BannerDomainToViewModelMapper;
import com.talabat.darkstores.data.discovery.mappers.SortOptionMapper;
import com.talabat.darkstores.data.discovery.mappers.SubcategorySwimlanesResultMapper;
import com.talabat.darkstores.data.discovery.mappers.VendorLandingToFeedsMapper;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import com.talabat.darkstores.data.discovery.model.NetworkSortOption;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTracker;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTrackerImpl;
import com.talabat.darkstores.data.tracking.fees.tracker.DarkstoresFeesTracker;
import com.talabat.darkstores.data.tracking.fees.tracker.IDarkstoresFeesTracker;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTracker;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTrackerImpl;
import com.talabat.darkstores.domain.naivgator.DarkstoresNavigatorImpl;
import com.talabat.darkstores.feature.campaigns.CampaignProgressSourceMapper;
import com.talabat.darkstores.feature.campaigns.CampaignProgressStateSource;
import com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCase;
import com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCaseImpl;
import com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0006\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0011H'J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00032\u0006\u0010\u0006\u001a\u00020\u0015H'J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0006\u001a\u00020\u0019H'J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u0006\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020 H'J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020#H'J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020&H'J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020)H'J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020,H'¨\u0006-"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresFeatureModule;", "", "bindBannerDomainToViewModelMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "Lcom/talabat/darkstores/model/Banner;", "impl", "Lcom/talabat/darkstores/data/discovery/mappers/BannerDomainToViewModelMapper;", "bindCampaignProgressSourceMapper", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignSource;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressSourceMapper;", "bindGroceryDeliveryFeeTierFeatureFlagUseCase", "Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;", "Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCaseImpl;", "bindSortAndFilterOptionTracker", "Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;", "Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTrackerImpl;", "bindSortOptionMapper", "Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "Lcom/talabat/darkstores/data/discovery/mappers/SortOptionMapper;", "bindSubcategoruSwimlanesResultMapper", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponse;", "Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "Lcom/talabat/darkstores/data/discovery/mappers/SubcategorySwimlanesResultMapper;", "bindVendorLandingToFeedsMapper", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "Lcom/talabat/darkstores/data/discovery/model/FeedMultiListData;", "Lcom/talabat/darkstores/data/discovery/mappers/VendorLandingToFeedsMapper;", "provideBottomSheetEventTracker", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTracker;", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTrackerImpl;", "provideDarkstoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "Lcom/talabat/darkstores/domain/naivgator/DarkstoresNavigatorImpl;", "provideDarkstoresRepository", "Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "Lcom/talabat/darkstores/data/repository/DarkstoresRepositoryImpl;", "provideDisclaimerRepository", "Lcom/talabat/feature/darkstores/domain/disclaimer/DisclaimerRepository;", "Lcom/talabat/darkstores/data/disclaimer/DisclaimerRepositoryImpl;", "providesFeesTracker", "Lcom/talabat/darkstores/data/tracking/fees/tracker/IDarkstoresFeesTracker;", "Lcom/talabat/darkstores/data/tracking/fees/tracker/DarkstoresFeesTracker;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresFeatureModule {
    @Binds
    @NotNull
    @Reusable
    ModelMapper<Banner, com.talabat.darkstores.model.Banner> bindBannerDomainToViewModelMapper(@NotNull BannerDomainToViewModelMapper bannerDomainToViewModelMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<CampaignSource, CampaignProgressStateSource> bindCampaignProgressSourceMapper(@NotNull CampaignProgressSourceMapper campaignProgressSourceMapper);

    @NotNull
    @Binds
    @Reusable
    GroceryDeliveryFeeTierFeatureFlagUseCase bindGroceryDeliveryFeeTierFeatureFlagUseCase(@NotNull GroceryDeliveryFeeTierFeatureFlagUseCaseImpl groceryDeliveryFeeTierFeatureFlagUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    SortAndFilterOptionTracker bindSortAndFilterOptionTracker(@NotNull SortAndFilterOptionTrackerImpl sortAndFilterOptionTrackerImpl);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<NetworkSortOption, SortOption> bindSortOptionMapper(@NotNull SortOptionMapper sortOptionMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse> bindSubcategoruSwimlanesResultMapper(@NotNull SubcategorySwimlanesResultMapper subcategorySwimlanesResultMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<VendorLanding, FeedMultiListData> bindVendorLandingToFeedsMapper(@NotNull VendorLandingToFeedsMapper vendorLandingToFeedsMapper);

    @NotNull
    @Binds
    @Reusable
    DarkStoreBottomSheetTracker provideBottomSheetEventTracker(@NotNull DarkStoreBottomSheetTrackerImpl darkStoreBottomSheetTrackerImpl);

    @NotNull
    @Binds
    @Reusable
    DarkstoresNavigator provideDarkstoresNavigator(@NotNull DarkstoresNavigatorImpl darkstoresNavigatorImpl);

    @NotNull
    @Binds
    @Reusable
    DarkstoresRepository provideDarkstoresRepository(@NotNull DarkstoresRepositoryImpl darkstoresRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    DisclaimerRepository provideDisclaimerRepository(@NotNull DisclaimerRepositoryImpl disclaimerRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    IDarkstoresFeesTracker providesFeesTracker(@NotNull DarkstoresFeesTracker darkstoresFeesTracker);
}
