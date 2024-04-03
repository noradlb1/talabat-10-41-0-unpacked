package com.talabat.fluid.homescreen.di.factory;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import buisnessmodels.Customer;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.endpoint.HomeTemplateEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase;
import com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl;
import com.talabat.fluid.homescreen.data.impl.HomeScreenTrackerImpl;
import com.talabat.fluid.homescreen.data.local.impl.FluidHomeComponentLocalDataSourceImpl;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentService;
import com.talabat.fluid.homescreen.data.remote.mapper.FluidHomeComponentRequestParamsProvider;
import com.talabat.fluid.homescreen.data.remote.mapper.TalabatProPlanIdProvider;
import com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateApi;
import com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.domain.usecase.application.StopHomeScreenTraceUseCase;
import com.talabat.fluid.homescreen.domain.usecase.application.impl.StopHomeScreenTraceUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerComponentClickedUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerSlideUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackEntryPointClicked;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackGroceryCategoriesUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroCarouselSlideUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentClickedUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentLoadUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackSecondaryBannerUseCases;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackShopClickedUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackShortCutsUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackSwimLaneUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackVoucherCodeEntryUseCase;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.FetchHomeCollectionsUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.ShowItemReplacementBottomSheetUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackBannerComponentClickedUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackBannerSlideUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackEntryPointClickedImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackGroceryCategoriesUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackHeroCarouselSlideUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackHeroComponentClickedUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackHeroComponentLoadUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackSecondaryBannerUseCasesImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackShopClickedUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackShortCutsUseCaseImp;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackSwimLaneUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.TrackVoucherCodeEntryUseCaseImpl;
import com.talabat.fluid.homescreen.domain.usecase.business.impl.UpdateSelectedRestaurantUseCaseImpl;
import com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.CollectionItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.SwimLaneItemMapper;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapper;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper;
import com.talabat.homescreen.orderstatus.domain.usecase.business.TrackOrderStatusLoadUseCase;
import com.talabat.homescreen.orderstatus.domain.usecase.business.impl.TrackOrderStatusLoadUseCaseImpl;
import com.talabat.homescreen.utils.HomeBannersTrackImpressionValidatorImpl;
import com.talabat.observability.performance.PerformanceTracker;
import d2.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<BÕ\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020,\u0012\u0006\u0010-\u001a\u00020.\u0012\u0006\u0010/\u001a\u000200\u0012\u0006\u00101\u001a\u000202\u0012\u0006\u00103\u001a\u000204¢\u0006\u0002\u00105J%\u00106\u001a\u0002H7\"\b\b\u0000\u00107*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H70:H\u0016¢\u0006\u0002\u0010;R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/talabat/fluid/homescreen/di/factory/FluidHomeScreenViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "fetchHomeCollectionsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase;", "shouldRateLastOrderUseCase", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "showItemReplacementBsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase;", "trackHeroComponentLoadUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentLoadUseCase;", "trackHeroComponentClickedUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentClickedUseCase;", "trackEntryPointClicked", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackEntryPointClicked;", "trackOrderStatusLoadUseCase", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusLoadUseCase;", "orderStatusDataMapper", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;", "trackShopClickedUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShopClickedUseCase;", "trackBannerComponentClickedUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerComponentClickedUseCase;", "trackBannerSlideUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerSlideUseCase;", "trackHeroCarouselSlideUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroCarouselSlideUseCase;", "trackVoucherCodeEntryUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackVoucherCodeEntryUseCase;", "trackShortCutsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShortCutsUseCase;", "trackSwimLaneUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSwimLaneUseCase;", "updateSelectedRestaurantUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/UpdateSelectedRestaurantUseCaseImpl;", "swimLaneItemMapper", "Lcom/talabat/fluid/homescreen/presentation/mapper/SwimLaneItemMapper;", "collectionItemMapper", "Lcom/talabat/fluid/homescreen/presentation/mapper/CollectionItemMapper;", "homeMapRedirectSetter", "Lkotlin/Function0;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "voucherCampaignCacheUseCase", "Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;", "trackSecondaryBannerUseCases", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSecondaryBannerUseCases;", "stopHomeScreenTraceUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "trackGroceryCategoriesUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackGroceryCategoriesUseCase;", "(Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase;Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentLoadUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentClickedUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackEntryPointClicked;Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusLoadUseCase;Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShopClickedUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerComponentClickedUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerSlideUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroCarouselSlideUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackVoucherCodeEntryUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShortCutsUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSwimLaneUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/UpdateSelectedRestaurantUseCaseImpl;Lcom/talabat/fluid/homescreen/presentation/mapper/SwimLaneItemMapper;Lcom/talabat/fluid/homescreen/presentation/mapper/CollectionItemMapper;Lkotlin/jvm/functions/Function0;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSecondaryBannerUseCases;Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackGroceryCategoriesUseCase;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final CollectionItemMapper collectionItemMapper;
    @NotNull
    private final FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase;
    @NotNull
    private final Function0<Unit> homeMapRedirectSetter;
    @NotNull
    private final HomeScreenPerformanceObservability homeScreenPerformanceObservability;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final OrderStatusDataMapper orderStatusDataMapper;
    @NotNull
    private final ShouldRateLastOrderUseCase shouldRateLastOrderUseCase;
    @NotNull
    private final ShowItemReplacementBottomSheetUseCase showItemReplacementBsUseCase;
    @NotNull
    private final StopHomeScreenTraceUseCase stopHomeScreenTraceUseCase;
    @NotNull
    private final SwimLaneItemMapper swimLaneItemMapper;
    @NotNull
    private final TrackBannerComponentClickedUseCase trackBannerComponentClickedUseCase;
    @NotNull
    private final TrackBannerSlideUseCase trackBannerSlideUseCase;
    @NotNull
    private final TrackEntryPointClicked trackEntryPointClicked;
    @NotNull
    private final TrackGroceryCategoriesUseCase trackGroceryCategoriesUseCase;
    @NotNull
    private final TrackHeroCarouselSlideUseCase trackHeroCarouselSlideUseCase;
    @NotNull
    private final TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase;
    @NotNull
    private final TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase;
    @NotNull
    private final TrackOrderStatusLoadUseCase trackOrderStatusLoadUseCase;
    @NotNull
    private final TrackSecondaryBannerUseCases trackSecondaryBannerUseCases;
    @NotNull
    private final TrackShopClickedUseCase trackShopClickedUseCase;
    @NotNull
    private final TrackShortCutsUseCase trackShortCutsUseCase;
    @NotNull
    private final TrackSwimLaneUseCase trackSwimLaneUseCase;
    @NotNull
    private final TrackVoucherCodeEntryUseCase trackVoucherCodeEntryUseCase;
    @NotNull
    private final UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCase;
    @NotNull
    private final VoucherCampaignCacheUseCase voucherCampaignCacheUseCase;

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J0\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0002JV\u0010%\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006-"}, d2 = {"Lcom/talabat/fluid/homescreen/di/factory/FluidHomeScreenViewModelFactory$Companion;", "", "()V", "createFetchHomeCollectionsUseCase", "Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/FetchHomeCollectionsUseCaseImpl;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "fluidHomeComponentRequestParamsProvider", "Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider;", "campaignMigratorSharedPreferences", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "createFluidHomeComponentRequestParamsProvider", "createShouldRateLastOrderUseCase", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "createTemplateProvider", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "createTrackOrderStatusLoadUseCase", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/impl/TrackOrderStatusLoadUseCaseImpl;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/data/impl/HomeScreenTrackerImpl;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "newInstance", "Lcom/talabat/fluid/homescreen/di/factory/FluidHomeScreenViewModelFactory;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "voucherCampaignCacheUseCase", "Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FetchHomeCollectionsUseCaseImpl createFetchHomeCollectionsUseCase(Context context, Gson gson, ConfigurationLocalRepository configurationLocalRepository, IObservabilityManager iObservabilityManager, FluidHomeComponentRequestParamsProvider fluidHomeComponentRequestParamsProvider, CampaignMigratorSharedPreferences campaignMigratorSharedPreferences, ParseConfig parseConfig, HomeScreenPerformanceObservability homeScreenPerformanceObservability, ITalabatFeatureFlag iTalabatFeatureFlag) {
            HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = homeScreenPerformanceObservability;
            HomeScreenPerformanceObservability homeScreenPerformanceObservability3 = homeScreenPerformanceObservability;
            return new FetchHomeCollectionsUseCaseImpl(new HomeConfigurationRepositoryImpl(campaignMigratorSharedPreferences, createTemplateProvider(context, configurationLocalRepository, iObservabilityManager, parseConfig, homeScreenPerformanceObservability3), new FluidHomeComponentLocalDataSourceImpl(context, gson), Dispatchers.getIO(), homeScreenPerformanceObservability3, (FluidHomeComponentService) null, iObservabilityManager, parseConfig, new ComponentMapper(parseConfig.getLogger(), homeScreenPerformanceObservability2), iTalabatFeatureFlag, 32, (DefaultConstructorMarker) null), fluidHomeComponentRequestParamsProvider, homeScreenPerformanceObservability2);
        }

        private final FluidHomeComponentRequestParamsProvider createFluidHomeComponentRequestParamsProvider(ITalabatFeatureFlag iTalabatFeatureFlag, ConfigurationLocalRepository configurationLocalRepository) {
            return new FluidHomeComponentRequestParamsProvider(TalabatProPlanIdProvider.INSTANCE.getPlanId$com_talabat_NewArchi_Homescreen_Homescreen(), configurationLocalRepository.selectedCountry(), FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$1.INSTANCE, FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$2.INSTANCE, FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$3.INSTANCE, new FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$4(configurationLocalRepository), new FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$5(iTalabatFeatureFlag));
        }

        private final ShouldRateLastOrderUseCase createShouldRateLastOrderUseCase(Context context) {
            return ((RatingFeatureApi) AndroidComponentsKt.apiContainer((Activity) context).getFeature(RatingFeatureApi.class)).getShouldRateLastOrderUseCase();
        }

        private final ReadableTemplateSource createTemplateProvider(Context context, ConfigurationLocalRepository configurationLocalRepository, IObservabilityManager iObservabilityManager, ParseConfig parseConfig, HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
            return new FluidHomeTemplateRemoteDataSource(homeScreenPerformanceObservability, parseConfig, (FluidHomeTemplateApi) new TalabatAPIBuilder().createApi(new HomeTemplateEndPointProvider((String) null, 1, (DefaultConstructorMarker) null).getBaseUrl(), FluidHomeTemplateApi.class), configurationLocalRepository, iObservabilityManager, context, IntegrationGlobalDataModel.Companion.selectedLanguage(), (Function0) null, (Function0) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
        }

        private final TrackOrderStatusLoadUseCaseImpl createTrackOrderStatusLoadUseCase(HomeScreenTrackerImpl homeScreenTrackerImpl, Function0<? extends Customer> function0, LocationDataFactory locationDataFactory) {
            return new TrackOrderStatusLoadUseCaseImpl(homeScreenTrackerImpl, function0, locationDataFactory);
        }

        @NotNull
        public final FluidHomeScreenViewModelFactory newInstance(@NotNull Context context, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager, @NotNull TalabatTracker talabatTracker, @NotNull ParseConfig parseConfig, @NotNull VoucherCampaignCacheUseCase voucherCampaignCacheUseCase, @NotNull CampaignMigratorSharedPreferences campaignMigratorSharedPreferences, @NotNull IScreenTracker iScreenTracker, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
            Context context2 = context;
            ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            TalabatTracker talabatTracker2 = talabatTracker;
            IScreenTracker iScreenTracker2 = iScreenTracker;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "talabatFeatureFlag");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
            ParseConfig parseConfig2 = parseConfig;
            Intrinsics.checkNotNullParameter(parseConfig2, "parseConfig");
            Intrinsics.checkNotNullParameter(voucherCampaignCacheUseCase, "voucherCampaignCacheUseCase");
            CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2 = campaignMigratorSharedPreferences;
            Intrinsics.checkNotNullParameter(campaignMigratorSharedPreferences2, "campaignMigratorSharedPreferences");
            Intrinsics.checkNotNullParameter(iScreenTracker2, "screenTracker");
            HomeScreenPerformanceObservability homeScreenPerformanceObservability2 = homeScreenPerformanceObservability;
            Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "homeScreenPerformanceObservability");
            Gson gson = new Gson();
            HomeScreenTrackerImpl homeScreenTrackerImpl = new HomeScreenTrackerImpl(context2, new TalabatFirebase(), talabatTracker2);
            LocationDataFactory locationDataFactory = new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null);
            FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1 fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1 = FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1.INSTANCE;
            OrderStatusDataMapper orderStatusDataMapper = r4;
            OrderStatusDataMapper orderStatusDataMapper2 = new OrderStatusDataMapper(gson);
            OrderStatusDataMapper orderStatusDataMapper3 = orderStatusDataMapper2;
            IObservabilityManager iObservabilityManager2 = iObservabilityManager;
            FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1 fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12 = fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1;
            FluidHomeComponentRequestParamsProvider createFluidHomeComponentRequestParamsProvider = createFluidHomeComponentRequestParamsProvider(iTalabatFeatureFlag2, configurationLocalRepository2);
            FetchHomeCollectionsUseCaseImpl createFetchHomeCollectionsUseCase = createFetchHomeCollectionsUseCase(context, gson, configurationLocalRepository2, iObservabilityManager2, createFluidHomeComponentRequestParamsProvider, campaignMigratorSharedPreferences2, parseConfig2, homeScreenPerformanceObservability2, iTalabatFeatureFlag2);
            LocationDataFactory locationDataFactory2 = locationDataFactory;
            FetchHomeCollectionsUseCaseImpl fetchHomeCollectionsUseCaseImpl = createFetchHomeCollectionsUseCase;
            HomeScreenTrackerImpl homeScreenTrackerImpl2 = homeScreenTrackerImpl;
            ShouldRateLastOrderUseCase createShouldRateLastOrderUseCase = createShouldRateLastOrderUseCase(context);
            TrackHeroComponentLoadUseCaseImpl trackHeroComponentLoadUseCaseImpl = r0;
            TrackHeroComponentLoadUseCaseImpl trackHeroComponentLoadUseCaseImpl2 = new TrackHeroComponentLoadUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12, locationDataFactory2);
            IScreenTracker iScreenTracker3 = iScreenTracker2;
            ShowItemReplacementBottomSheetUseCaseImpl showItemReplacementBottomSheetUseCaseImpl = r0;
            ShowItemReplacementBottomSheetUseCaseImpl showItemReplacementBottomSheetUseCaseImpl2 = new ShowItemReplacementBottomSheetUseCaseImpl(orderStatusDataMapper3);
            TrackVoucherCodeEntryUseCaseImpl trackVoucherCodeEntryUseCaseImpl = r0;
            TrackVoucherCodeEntryUseCaseImpl trackVoucherCodeEntryUseCaseImpl2 = new TrackVoucherCodeEntryUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12, locationDataFactory2);
            TrackHeroComponentClickedUseCaseImpl trackHeroComponentClickedUseCaseImpl = r0;
            TrackHeroComponentClickedUseCaseImpl trackHeroComponentClickedUseCaseImpl2 = new TrackHeroComponentClickedUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12, locationDataFactory2);
            TrackEntryPointClickedImpl trackEntryPointClickedImpl = r0;
            HomeScreenTrackerImpl homeScreenTrackerImpl3 = homeScreenTrackerImpl2;
            LocationDataFactory locationDataFactory3 = locationDataFactory2;
            TrackEntryPointClickedImpl trackEntryPointClickedImpl2 = new TrackEntryPointClickedImpl(homeScreenTrackerImpl3, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12, locationDataFactory3, iObservabilityManager2, createFluidHomeComponentRequestParamsProvider);
            TrackOrderStatusLoadUseCaseImpl createTrackOrderStatusLoadUseCase = createTrackOrderStatusLoadUseCase(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12, locationDataFactory2);
            TrackShopClickedUseCaseImpl trackShopClickedUseCaseImpl = r0;
            TrackShopClickedUseCaseImpl trackShopClickedUseCaseImpl2 = new TrackShopClickedUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12, locationDataFactory2);
            TrackBannerComponentClickedUseCaseImpl trackBannerComponentClickedUseCaseImpl = r0;
            IObservabilityManager iObservabilityManager3 = iObservabilityManager;
            FluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$1 fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13 = fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$12;
            TrackBannerComponentClickedUseCaseImpl trackBannerComponentClickedUseCaseImpl2 = new TrackBannerComponentClickedUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory2, iObservabilityManager3);
            TrackBannerSlideUseCaseImpl trackBannerSlideUseCaseImpl = r0;
            TrackBannerSlideUseCaseImpl trackBannerSlideUseCaseImpl2 = new TrackBannerSlideUseCaseImpl(homeScreenTrackerImpl3, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory3, new HomeBannersTrackImpressionValidatorImpl(), iObservabilityManager3);
            TrackHeroCarouselSlideUseCaseImpl trackHeroCarouselSlideUseCaseImpl = r0;
            TrackHeroCarouselSlideUseCaseImpl trackHeroCarouselSlideUseCaseImpl2 = new TrackHeroCarouselSlideUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory2, new HomeBannersTrackImpressionValidatorImpl());
            TrackShortCutsUseCaseImp trackShortCutsUseCaseImp = r0;
            TrackShortCutsUseCaseImp trackShortCutsUseCaseImp2 = new TrackShortCutsUseCaseImp(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory2);
            TrackSwimLaneUseCaseImpl trackSwimLaneUseCaseImpl = r0;
            TrackSwimLaneUseCaseImpl trackSwimLaneUseCaseImpl2 = new TrackSwimLaneUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory2);
            UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCaseImpl = r0;
            UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCaseImpl2 = new UpdateSelectedRestaurantUseCaseImpl(FluidHomeScreenViewModelFactory$Companion$newInstance$1.INSTANCE);
            SwimLaneItemMapper swimLaneItemMapper = r0;
            SwimLaneItemMapper swimLaneItemMapper2 = new SwimLaneItemMapper();
            CollectionItemMapper collectionItemMapper = r0;
            CollectionItemMapper collectionItemMapper2 = new CollectionItemMapper();
            TrackSecondaryBannerUseCasesImpl trackSecondaryBannerUseCasesImpl = r0;
            TrackSecondaryBannerUseCasesImpl trackSecondaryBannerUseCasesImpl2 = new TrackSecondaryBannerUseCasesImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory2, new HomeBannersTrackImpressionValidatorImpl());
            StopHomeScreenTraceUseCaseImpl stopHomeScreenTraceUseCaseImpl = r1;
            StopHomeScreenTraceUseCaseImpl stopHomeScreenTraceUseCaseImpl2 = new StopHomeScreenTraceUseCaseImpl(iScreenTracker3, PerformanceTracker.INSTANCE);
            TrackGroceryCategoriesUseCaseImpl trackGroceryCategoriesUseCaseImpl = r0;
            TrackGroceryCategoriesUseCaseImpl trackGroceryCategoriesUseCaseImpl2 = new TrackGroceryCategoriesUseCaseImpl(homeScreenTrackerImpl2, fluidHomeScreenViewModelFactory$Companion$newInstance$customerProvider$13, locationDataFactory2);
            FluidHomeScreenViewModelFactory$Companion$newInstance$2 fluidHomeScreenViewModelFactory$Companion$newInstance$2 = r1;
            FluidHomeScreenViewModelFactory$Companion$newInstance$2 fluidHomeScreenViewModelFactory$Companion$newInstance$22 = new FluidHomeScreenViewModelFactory$Companion$newInstance$2(context);
            return new FluidHomeScreenViewModelFactory(fetchHomeCollectionsUseCaseImpl, createShouldRateLastOrderUseCase, showItemReplacementBottomSheetUseCaseImpl, trackHeroComponentLoadUseCaseImpl, trackHeroComponentClickedUseCaseImpl, trackEntryPointClickedImpl, createTrackOrderStatusLoadUseCase, orderStatusDataMapper, trackShopClickedUseCaseImpl, trackBannerComponentClickedUseCaseImpl, trackBannerSlideUseCaseImpl, trackHeroCarouselSlideUseCaseImpl, trackVoucherCodeEntryUseCaseImpl, trackShortCutsUseCaseImp, trackSwimLaneUseCaseImpl, updateSelectedRestaurantUseCaseImpl, swimLaneItemMapper, collectionItemMapper, fluidHomeScreenViewModelFactory$Companion$newInstance$2, iObservabilityManager, voucherCampaignCacheUseCase, trackSecondaryBannerUseCasesImpl, stopHomeScreenTraceUseCaseImpl, homeScreenPerformanceObservability, trackGroceryCategoriesUseCaseImpl, (DefaultConstructorMarker) null);
        }
    }

    private FluidHomeScreenViewModelFactory(FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase2, ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2, ShowItemReplacementBottomSheetUseCase showItemReplacementBottomSheetUseCase, TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase2, TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase2, TrackEntryPointClicked trackEntryPointClicked2, TrackOrderStatusLoadUseCase trackOrderStatusLoadUseCase2, OrderStatusDataMapper orderStatusDataMapper2, TrackShopClickedUseCase trackShopClickedUseCase2, TrackBannerComponentClickedUseCase trackBannerComponentClickedUseCase2, TrackBannerSlideUseCase trackBannerSlideUseCase2, TrackHeroCarouselSlideUseCase trackHeroCarouselSlideUseCase2, TrackVoucherCodeEntryUseCase trackVoucherCodeEntryUseCase2, TrackShortCutsUseCase trackShortCutsUseCase2, TrackSwimLaneUseCase trackSwimLaneUseCase2, UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCaseImpl, SwimLaneItemMapper swimLaneItemMapper2, CollectionItemMapper collectionItemMapper2, Function0<Unit> function0, IObservabilityManager iObservabilityManager, VoucherCampaignCacheUseCase voucherCampaignCacheUseCase2, TrackSecondaryBannerUseCases trackSecondaryBannerUseCases2, StopHomeScreenTraceUseCase stopHomeScreenTraceUseCase2, HomeScreenPerformanceObservability homeScreenPerformanceObservability2, TrackGroceryCategoriesUseCase trackGroceryCategoriesUseCase2) {
        this.fetchHomeCollectionsUseCase = fetchHomeCollectionsUseCase2;
        this.shouldRateLastOrderUseCase = shouldRateLastOrderUseCase2;
        this.showItemReplacementBsUseCase = showItemReplacementBottomSheetUseCase;
        this.trackHeroComponentLoadUseCase = trackHeroComponentLoadUseCase2;
        this.trackHeroComponentClickedUseCase = trackHeroComponentClickedUseCase2;
        this.trackEntryPointClicked = trackEntryPointClicked2;
        this.trackOrderStatusLoadUseCase = trackOrderStatusLoadUseCase2;
        this.orderStatusDataMapper = orderStatusDataMapper2;
        this.trackShopClickedUseCase = trackShopClickedUseCase2;
        this.trackBannerComponentClickedUseCase = trackBannerComponentClickedUseCase2;
        this.trackBannerSlideUseCase = trackBannerSlideUseCase2;
        this.trackHeroCarouselSlideUseCase = trackHeroCarouselSlideUseCase2;
        this.trackVoucherCodeEntryUseCase = trackVoucherCodeEntryUseCase2;
        this.trackShortCutsUseCase = trackShortCutsUseCase2;
        this.trackSwimLaneUseCase = trackSwimLaneUseCase2;
        this.updateSelectedRestaurantUseCase = updateSelectedRestaurantUseCaseImpl;
        this.swimLaneItemMapper = swimLaneItemMapper2;
        this.collectionItemMapper = collectionItemMapper2;
        this.homeMapRedirectSetter = function0;
        this.observabilityManager = iObservabilityManager;
        this.voucherCampaignCacheUseCase = voucherCampaignCacheUseCase2;
        this.trackSecondaryBannerUseCases = trackSecondaryBannerUseCases2;
        this.stopHomeScreenTraceUseCase = stopHomeScreenTraceUseCase2;
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
        this.trackGroceryCategoriesUseCase = trackGroceryCategoriesUseCase2;
    }

    public /* synthetic */ FluidHomeScreenViewModelFactory(FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase2, ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2, ShowItemReplacementBottomSheetUseCase showItemReplacementBottomSheetUseCase, TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase2, TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase2, TrackEntryPointClicked trackEntryPointClicked2, TrackOrderStatusLoadUseCase trackOrderStatusLoadUseCase2, OrderStatusDataMapper orderStatusDataMapper2, TrackShopClickedUseCase trackShopClickedUseCase2, TrackBannerComponentClickedUseCase trackBannerComponentClickedUseCase2, TrackBannerSlideUseCase trackBannerSlideUseCase2, TrackHeroCarouselSlideUseCase trackHeroCarouselSlideUseCase2, TrackVoucherCodeEntryUseCase trackVoucherCodeEntryUseCase2, TrackShortCutsUseCase trackShortCutsUseCase2, TrackSwimLaneUseCase trackSwimLaneUseCase2, UpdateSelectedRestaurantUseCaseImpl updateSelectedRestaurantUseCaseImpl, SwimLaneItemMapper swimLaneItemMapper2, CollectionItemMapper collectionItemMapper2, Function0 function0, IObservabilityManager iObservabilityManager, VoucherCampaignCacheUseCase voucherCampaignCacheUseCase2, TrackSecondaryBannerUseCases trackSecondaryBannerUseCases2, StopHomeScreenTraceUseCase stopHomeScreenTraceUseCase2, HomeScreenPerformanceObservability homeScreenPerformanceObservability2, TrackGroceryCategoriesUseCase trackGroceryCategoriesUseCase2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fetchHomeCollectionsUseCase2, shouldRateLastOrderUseCase2, showItemReplacementBottomSheetUseCase, trackHeroComponentLoadUseCase2, trackHeroComponentClickedUseCase2, trackEntryPointClicked2, trackOrderStatusLoadUseCase2, orderStatusDataMapper2, trackShopClickedUseCase2, trackBannerComponentClickedUseCase2, trackBannerSlideUseCase2, trackHeroCarouselSlideUseCase2, trackVoucherCodeEntryUseCase2, trackShortCutsUseCase2, trackSwimLaneUseCase2, updateSelectedRestaurantUseCaseImpl, swimLaneItemMapper2, collectionItemMapper2, function0, iObservabilityManager, voucherCampaignCacheUseCase2, trackSecondaryBannerUseCases2, stopHomeScreenTraceUseCase2, homeScreenPerformanceObservability2, trackGroceryCategoriesUseCase2);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        FetchHomeCollectionsUseCase fetchHomeCollectionsUseCase2 = this.fetchHomeCollectionsUseCase;
        ShouldRateLastOrderUseCase shouldRateLastOrderUseCase2 = this.shouldRateLastOrderUseCase;
        ShowItemReplacementBottomSheetUseCase showItemReplacementBottomSheetUseCase = this.showItemReplacementBsUseCase;
        TrackHeroComponentLoadUseCase trackHeroComponentLoadUseCase2 = this.trackHeroComponentLoadUseCase;
        TrackHeroComponentClickedUseCase trackHeroComponentClickedUseCase2 = this.trackHeroComponentClickedUseCase;
        TrackEntryPointClicked trackEntryPointClicked2 = this.trackEntryPointClicked;
        TrackShopClickedUseCase trackShopClickedUseCase2 = this.trackShopClickedUseCase;
        return new FluidHomeScreenViewModel(fetchHomeCollectionsUseCase2, shouldRateLastOrderUseCase2, showItemReplacementBottomSheetUseCase, trackHeroComponentLoadUseCase2, trackHeroComponentClickedUseCase2, this.trackBannerSlideUseCase, this.trackHeroCarouselSlideUseCase, this.trackBannerComponentClickedUseCase, this.trackOrderStatusLoadUseCase, (VerticalItemViewEntityMapper) null, trackEntryPointClicked2, trackShopClickedUseCase2, this.trackShortCutsUseCase, (BannerAdItemMapper) null, this.orderStatusDataMapper, this.trackSwimLaneUseCase, this.trackVoucherCodeEntryUseCase, this.updateSelectedRestaurantUseCase, this.swimLaneItemMapper, this.collectionItemMapper, this.homeMapRedirectSetter, this.observabilityManager, this.voucherCampaignCacheUseCase, this.trackSecondaryBannerUseCases, this.stopHomeScreenTraceUseCase, this.homeScreenPerformanceObservability, this.trackGroceryCategoriesUseCase, 8704, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
