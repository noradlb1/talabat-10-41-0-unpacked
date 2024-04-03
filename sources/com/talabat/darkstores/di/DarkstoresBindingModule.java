package com.talabat.darkstores.di;

import com.talabat.darkstores.domain.banner.IsFlutterBannerProductListingEnabledUseCase;
import com.talabat.darkstores.domain.banner.IsFlutterBannerProductListingEnabledUseCaseImpl;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCaseImpl;
import com.talabat.darkstores.domain.common.IsFlutterVLPEnabledUseCase;
import com.talabat.darkstores.domain.common.IsFlutterVLPEnabledUseCaseImpl;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapper;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapperImpl;
import com.talabat.darkstores.domain.products.CheckFlutterCategoryProductsEnabledUseCase;
import com.talabat.darkstores.domain.products.CheckFlutterCategoryProductsEnabledUseCaseImpl;
import com.talabat.darkstores.domain.swimlanes.CheckFlutterSwimlanesSearchResultEnabledUseCase;
import com.talabat.darkstores.domain.swimlanes.CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl;
import com.talabat.darkstores.domain.voucher.IsVoucherBottomSheetNavigationEnabledUseCase;
import com.talabat.darkstores.domain.voucher.IsVoucherBottomSheetNavigationEnabledUseCaseImpl;
import com.talabat.darkstores.feature.cart.views.CartProgressContract;
import com.talabat.darkstores.feature.cart.views.CartProgressViewPresenter;
import com.talabat.darkstores.feature.categories.subcategories.sort.GetSortOnPLPEnabledUseCase;
import com.talabat.darkstores.feature.categories.subcategories.sort.GetSortOnPLPEnabledUseCaseImpl;
import com.talabat.darkstores.feature.home.VendorLandingFeedUseCase;
import com.talabat.darkstores.feature.home.VendorLandingFeedUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCaseImpl;
import com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCase;
import com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCaseImpl;
import com.talabat.darkstores.feature.main.usecase.GenerateVoucherUseCase;
import com.talabat.darkstores.feature.main.usecase.GenerateVoucherUseCaseImpl;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactory;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactoryImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH'J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020!H'J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020$H'J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020'H'J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020*H'J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020-H'J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0004\u001a\u000200H'J\u0010\u00101\u001a\u0002022\u0006\u0010\u0004\u001a\u000203H'J\u0010\u00104\u001a\u0002052\u0006\u0010\u0004\u001a\u000206H'J\u0010\u00107\u001a\u0002082\u0006\u0010\u0004\u001a\u000209H'J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0004\u001a\u00020<H'J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020?H'J\u0010\u0010@\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020BH'J\u0010\u0010C\u001a\u00020D2\u0006\u0010\u0004\u001a\u00020EH'J\u0010\u0010F\u001a\u00020G2\u0006\u0010\u0004\u001a\u00020HH'¨\u0006I"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresBindingModule;", "", "bindApplyDiscountsAndCampaignsUseCase", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "impl", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCaseImpl;", "bindBuildBannerCampaignProductListingNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;", "Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCaseImpl;", "bindBuildCartNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;", "Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCaseImpl;", "bindBuildCategoryProductsNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;", "Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCaseImpl;", "bindBuildDeliveryFeeTierNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildDeliveryFeeTierNavigationUseCase;", "Lcom/talabat/darkstores/domain/common/BuildDeliveryFeeTierNavigationUseCaseImpl;", "bindBuildLifestyleSearchResultNavigationActionUseCaseImpl", "Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCase;", "Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCaseImpl;", "bindBuildSwimlanesSearchResultNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;", "Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCaseImpl;", "bindBuildTalabatAiNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCase;", "Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCaseImpl;", "bindCartProgressViewPresenter", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "presenter", "Lcom/talabat/darkstores/feature/cart/views/CartProgressViewPresenter;", "bindCheckFlutterCategoryProductsEnabledUseCase", "Lcom/talabat/darkstores/domain/products/CheckFlutterCategoryProductsEnabledUseCase;", "Lcom/talabat/darkstores/domain/products/CheckFlutterCategoryProductsEnabledUseCaseImpl;", "bindCheckFlutterSwimlanesSearchResultEnabledUseCase", "Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCase;", "Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl;", "bindGenerateVoucherUseCase", "Lcom/talabat/darkstores/feature/main/usecase/GenerateVoucherUseCase;", "Lcom/talabat/darkstores/feature/main/usecase/GenerateVoucherUseCaseImpl;", "bindGetSortOnPLPEnabledUseCase", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/GetSortOnPLPEnabledUseCase;", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/GetSortOnPLPEnabledUseCaseImpl;", "bindGetVendorLightningOptimizationExpVariantUseCase", "Lcom/talabat/darkstores/feature/home/usecase/GetVendorLightningOptimizationExpVariantUseCase;", "Lcom/talabat/darkstores/feature/home/usecase/GetVendorLightningOptimizationExpVariantUseCaseImpl;", "bindIsFlutterBannerProductListingEnabledUseCase", "Lcom/talabat/darkstores/domain/banner/IsFlutterBannerProductListingEnabledUseCase;", "Lcom/talabat/darkstores/domain/banner/IsFlutterBannerProductListingEnabledUseCaseImpl;", "bindIsFlutterVLPEnabledUseCase", "Lcom/talabat/darkstores/domain/common/IsFlutterVLPEnabledUseCase;", "Lcom/talabat/darkstores/domain/common/IsFlutterVLPEnabledUseCaseImpl;", "bindIsVLPLoadTimeTrackingEnabledUseCase", "Lcom/talabat/darkstores/feature/home/usecase/IsVLPLoadTimeTrackingEnabledUseCase;", "Lcom/talabat/darkstores/feature/home/usecase/IsVLPLoadTimeTrackingEnabledUseCaseImpl;", "bindIsVendorLightningOptimizationEnabledUseCase", "Lcom/talabat/darkstores/feature/home/usecase/IsVendorLightningOptimizationEnabledUseCase;", "Lcom/talabat/darkstores/feature/home/usecase/IsVendorLightningOptimizationEnabledUseCaseImpl;", "bindIsVoucherBottomSheetNavigationEnabledUseCase", "Lcom/talabat/darkstores/domain/voucher/IsVoucherBottomSheetNavigationEnabledUseCase;", "Lcom/talabat/darkstores/domain/voucher/IsVoucherBottomSheetNavigationEnabledUseCaseImpl;", "bindPagingSourceFactory", "Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactory;", "Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactoryImpl;", "bindSearchResultsResponseToDomainMapper", "Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapper;", "Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapperImpl;", "bindShouldShowTalabatAiEntryPointUseCase", "Lcom/talabat/darkstores/feature/home/usecase/ShouldShowTalabatAiEntryPointUseCase;", "Lcom/talabat/darkstores/feature/home/usecase/ShouldShowTalabatAiEntryPointUseCaseImpl;", "bindVendorLandingFeeUseCase", "Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCase;", "Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCaseImpl;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresBindingModule {
    @NotNull
    @Binds
    ApplyDiscountsAndCampaignsUseCase bindApplyDiscountsAndCampaignsUseCase(@NotNull ApplyDiscountsAndCampaignsUseCaseImpl applyDiscountsAndCampaignsUseCaseImpl);

    @NotNull
    @Binds
    BuildBannerCampaignProductListingNavigationUseCase bindBuildBannerCampaignProductListingNavigationUseCase(@NotNull BuildBannerCampaignProductListingNavigationUseCaseImpl buildBannerCampaignProductListingNavigationUseCaseImpl);

    @NotNull
    @Binds
    BuildCartNavigationActionUseCase bindBuildCartNavigationActionUseCase(@NotNull BuildCartNavigationActionUseCaseImpl buildCartNavigationActionUseCaseImpl);

    @NotNull
    @Binds
    BuildCategoryProductsNavigationActionUseCase bindBuildCategoryProductsNavigationActionUseCase(@NotNull BuildCategoryProductsNavigationActionUseCaseImpl buildCategoryProductsNavigationActionUseCaseImpl);

    @NotNull
    @Binds
    BuildDeliveryFeeTierNavigationUseCase bindBuildDeliveryFeeTierNavigationUseCase(@NotNull BuildDeliveryFeeTierNavigationUseCaseImpl buildDeliveryFeeTierNavigationUseCaseImpl);

    @NotNull
    @Binds
    BuildLifestyleSearchResultNavigationActionUseCase bindBuildLifestyleSearchResultNavigationActionUseCaseImpl(@NotNull BuildLifestyleSearchResultNavigationActionUseCaseImpl buildLifestyleSearchResultNavigationActionUseCaseImpl);

    @NotNull
    @Binds
    BuildSwimlanesSearchResultNavigationActionUseCase bindBuildSwimlanesSearchResultNavigationActionUseCase(@NotNull BuildSwimlanesSearchResultNavigationActionUseCaseImpl buildSwimlanesSearchResultNavigationActionUseCaseImpl);

    @NotNull
    @Binds
    BuildTalabatAiNavigationActionUseCase bindBuildTalabatAiNavigationActionUseCase(@NotNull BuildTalabatAiNavigationActionUseCaseImpl buildTalabatAiNavigationActionUseCaseImpl);

    @NotNull
    @Binds
    CartProgressContract.Presenter bindCartProgressViewPresenter(@NotNull CartProgressViewPresenter cartProgressViewPresenter);

    @NotNull
    @Binds
    CheckFlutterCategoryProductsEnabledUseCase bindCheckFlutterCategoryProductsEnabledUseCase(@NotNull CheckFlutterCategoryProductsEnabledUseCaseImpl checkFlutterCategoryProductsEnabledUseCaseImpl);

    @NotNull
    @Binds
    CheckFlutterSwimlanesSearchResultEnabledUseCase bindCheckFlutterSwimlanesSearchResultEnabledUseCase(@NotNull CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl checkFlutterSwimlanesSearchResultEnabledUseCaseImpl);

    @NotNull
    @Binds
    GenerateVoucherUseCase bindGenerateVoucherUseCase(@NotNull GenerateVoucherUseCaseImpl generateVoucherUseCaseImpl);

    @NotNull
    @Binds
    GetSortOnPLPEnabledUseCase bindGetSortOnPLPEnabledUseCase(@NotNull GetSortOnPLPEnabledUseCaseImpl getSortOnPLPEnabledUseCaseImpl);

    @NotNull
    @Binds
    GetVendorLightningOptimizationExpVariantUseCase bindGetVendorLightningOptimizationExpVariantUseCase(@NotNull GetVendorLightningOptimizationExpVariantUseCaseImpl getVendorLightningOptimizationExpVariantUseCaseImpl);

    @NotNull
    @Binds
    IsFlutterBannerProductListingEnabledUseCase bindIsFlutterBannerProductListingEnabledUseCase(@NotNull IsFlutterBannerProductListingEnabledUseCaseImpl isFlutterBannerProductListingEnabledUseCaseImpl);

    @NotNull
    @Binds
    IsFlutterVLPEnabledUseCase bindIsFlutterVLPEnabledUseCase(@NotNull IsFlutterVLPEnabledUseCaseImpl isFlutterVLPEnabledUseCaseImpl);

    @NotNull
    @Binds
    IsVLPLoadTimeTrackingEnabledUseCase bindIsVLPLoadTimeTrackingEnabledUseCase(@NotNull IsVLPLoadTimeTrackingEnabledUseCaseImpl isVLPLoadTimeTrackingEnabledUseCaseImpl);

    @NotNull
    @Binds
    IsVendorLightningOptimizationEnabledUseCase bindIsVendorLightningOptimizationEnabledUseCase(@NotNull IsVendorLightningOptimizationEnabledUseCaseImpl isVendorLightningOptimizationEnabledUseCaseImpl);

    @NotNull
    @Binds
    IsVoucherBottomSheetNavigationEnabledUseCase bindIsVoucherBottomSheetNavigationEnabledUseCase(@NotNull IsVoucherBottomSheetNavigationEnabledUseCaseImpl isVoucherBottomSheetNavigationEnabledUseCaseImpl);

    @NotNull
    @Binds
    PagingSourceFactory bindPagingSourceFactory(@NotNull PagingSourceFactoryImpl pagingSourceFactoryImpl);

    @NotNull
    @Binds
    MissionControlProductsResponseToDomainMapper bindSearchResultsResponseToDomainMapper(@NotNull MissionControlProductsResponseToDomainMapperImpl missionControlProductsResponseToDomainMapperImpl);

    @NotNull
    @Binds
    ShouldShowTalabatAiEntryPointUseCase bindShouldShowTalabatAiEntryPointUseCase(@NotNull ShouldShowTalabatAiEntryPointUseCaseImpl shouldShowTalabatAiEntryPointUseCaseImpl);

    @NotNull
    @Binds
    VendorLandingFeedUseCase bindVendorLandingFeeUseCase(@NotNull VendorLandingFeedUseCaseImpl vendorLandingFeedUseCaseImpl);
}
