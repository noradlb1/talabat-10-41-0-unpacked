package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.features.loyalty.GetPointsSummary;
import com.talabat.growth.features.loyalty.IsUserRewardsEnabled;
import com.talabat.growth.features.loyalty.network.GetPointsService;
import com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewardsSharedPreferences;
import com.talabat.growth.features.matketPlace.FilterBurnItems;
import com.talabat.growth.features.matketPlace.GetMarketPlaceItems;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceApi;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0017"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModelBuilder$Companion;", "", "()V", "getGetMarketPlaceItems", "Lcom/talabat/growth/features/matketPlace/GetMarketPlaceItems;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getGetPointsSummary", "Lcom/talabat/growth/features/loyalty/GetPointsSummary;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getIsUserRewardsEnabled", "Lcom/talabat/growth/features/loyalty/IsUserRewardsEnabled;", "getLoyaltyDashboardViewModel", "Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModel;", "context", "Landroid/content/Context;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GetMarketPlaceItems getGetMarketPlaceItems(NetworkHandler networkHandler, CoroutineScope coroutineScope, LocationConfigurationRepository locationConfigurationRepository) {
            return new GetMarketPlaceItems(networkHandler, new MarketPlaceService((MarketPlaceApi) null, 1, (DefaultConstructorMarker) null), locationConfigurationRepository, coroutineScope, Dispatchers.getMain(), (RemoteConfiguration) null, 32, (DefaultConstructorMarker) null);
        }

        private final GetPointsSummary getGetPointsSummary(NetworkHandler networkHandler, CoroutineScope coroutineScope, ConfigurationLocalRepository configurationLocalRepository) {
            return new GetPointsSummary(networkHandler, new GetPointsService(new TalabatAPIBuilder()), configurationLocalRepository, coroutineScope, Dispatchers.getMain());
        }

        private final IsUserRewardsEnabled getIsUserRewardsEnabled(NetworkHandler networkHandler, ConfigurationLocalRepository configurationLocalRepository, CoroutineScope coroutineScope) {
            return new IsUserRewardsEnabled(networkHandler, new GetPointsService(new TalabatAPIBuilder()), configurationLocalRepository, coroutineScope, Dispatchers.getMain());
        }

        @NotNull
        public final LoyaltyDashboardViewModel getLoyaltyDashboardViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
            Context context2 = context;
            CoroutineScope coroutineScope2 = coroutineScope;
            ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
            LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
            ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlagRepo");
            Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
            Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
            NetworkHandler networkHandler = new NetworkHandler(context2);
            GetPointsSummary getPointsSummary = getGetPointsSummary(networkHandler, coroutineScope2, configurationLocalRepository2);
            GetMarketPlaceItems getMarketPlaceItems = getGetMarketPlaceItems(networkHandler, coroutineScope2, locationConfigurationRepository2);
            IsUserRewardsEnabled isUserRewardsEnabled = getIsUserRewardsEnabled(networkHandler, configurationLocalRepository2, coroutineScope2);
            IsUserRewardsSharedPreferences isUserRewardsSharedPreferences = new IsUserRewardsSharedPreferences(context2);
            FilterBurnItems filterBurnItems = new FilterBurnItems(coroutineScope2, Dispatchers.getMain(), iTalabatFeatureFlag2);
            BurnOptionDetailsNavigator burnOptionDetailsNavigator = new BurnOptionDetailsNavigator(coroutineScope2, Dispatchers.getMain(), (RemoteConfiguration) null, 4, (DefaultConstructorMarker) null);
            return new LoyaltyDashboardViewModel(getPointsSummary, getMarketPlaceItems, GrowthTracker.INSTANCE, isUserRewardsEnabled, iTalabatFeatureFlag, isUserRewardsSharedPreferences, filterBurnItems, burnOptionDetailsNavigator);
        }
    }
}
