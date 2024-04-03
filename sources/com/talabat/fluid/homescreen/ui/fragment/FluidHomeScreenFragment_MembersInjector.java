package com.talabat.fluid.homescreen.ui.fragment;

import com.google.gson.Gson;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignCacheUseCase;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class FluidHomeScreenFragment_MembersInjector implements MembersInjector<FluidHomeScreenFragment> {
    private final Provider<VoucherCampaignCacheUseCase> campaignCacheUseCaseProvider;
    private final Provider<CampaignMigratorSharedPreferences> campaignMigratorSharedPreferencesProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<HomeScreenPerformanceObservability> homeScreenPerformanceObservabilityProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public FluidHomeScreenFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<IObservabilityManager> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4, Provider<VoucherCampaignCacheUseCase> provider5, Provider<CampaignMigratorSharedPreferences> provider6, Provider<Gson> provider7, Provider<IScreenTracker> provider8, Provider<CustomerRepository> provider9, Provider<DeepLinkNavigator> provider10, Provider<HomeScreenPerformanceObservability> provider11) {
        this.configurationLocalRepositoryProvider = provider;
        this.observabilityManagerProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
        this.talabatTrackerProvider = provider4;
        this.campaignCacheUseCaseProvider = provider5;
        this.campaignMigratorSharedPreferencesProvider = provider6;
        this.gsonProvider = provider7;
        this.screenTrackerProvider = provider8;
        this.customerRepositoryProvider = provider9;
        this.deepLinkNavigatorProvider = provider10;
        this.homeScreenPerformanceObservabilityProvider = provider11;
    }

    public static MembersInjector<FluidHomeScreenFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<IObservabilityManager> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4, Provider<VoucherCampaignCacheUseCase> provider5, Provider<CampaignMigratorSharedPreferences> provider6, Provider<Gson> provider7, Provider<IScreenTracker> provider8, Provider<CustomerRepository> provider9, Provider<DeepLinkNavigator> provider10, Provider<HomeScreenPerformanceObservability> provider11) {
        return new FluidHomeScreenFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.campaignCacheUseCase")
    public static void injectCampaignCacheUseCase(FluidHomeScreenFragment fluidHomeScreenFragment, VoucherCampaignCacheUseCase voucherCampaignCacheUseCase) {
        fluidHomeScreenFragment.campaignCacheUseCase = voucherCampaignCacheUseCase;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.campaignMigratorSharedPreferences")
    public static void injectCampaignMigratorSharedPreferences(FluidHomeScreenFragment fluidHomeScreenFragment, CampaignMigratorSharedPreferences campaignMigratorSharedPreferences) {
        fluidHomeScreenFragment.campaignMigratorSharedPreferences = campaignMigratorSharedPreferences;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(FluidHomeScreenFragment fluidHomeScreenFragment, ConfigurationLocalRepository configurationLocalRepository) {
        fluidHomeScreenFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.customerRepository")
    public static void injectCustomerRepository(FluidHomeScreenFragment fluidHomeScreenFragment, CustomerRepository customerRepository) {
        fluidHomeScreenFragment.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(FluidHomeScreenFragment fluidHomeScreenFragment, DeepLinkNavigator deepLinkNavigator) {
        fluidHomeScreenFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.gson")
    public static void injectGson(FluidHomeScreenFragment fluidHomeScreenFragment, Gson gson) {
        fluidHomeScreenFragment.gson = gson;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.homeScreenPerformanceObservability")
    public static void injectHomeScreenPerformanceObservability(FluidHomeScreenFragment fluidHomeScreenFragment, HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
        fluidHomeScreenFragment.homeScreenPerformanceObservability = homeScreenPerformanceObservability;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.observabilityManager")
    public static void injectObservabilityManager(FluidHomeScreenFragment fluidHomeScreenFragment, IObservabilityManager iObservabilityManager) {
        fluidHomeScreenFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.screenTracker")
    public static void injectScreenTracker(FluidHomeScreenFragment fluidHomeScreenFragment, IScreenTracker iScreenTracker) {
        fluidHomeScreenFragment.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(FluidHomeScreenFragment fluidHomeScreenFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        fluidHomeScreenFragment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.fluid.homescreen.ui.fragment.FluidHomeScreenFragment.talabatTracker")
    public static void injectTalabatTracker(FluidHomeScreenFragment fluidHomeScreenFragment, TalabatTracker talabatTracker) {
        fluidHomeScreenFragment.talabatTracker = talabatTracker;
    }

    public void injectMembers(FluidHomeScreenFragment fluidHomeScreenFragment) {
        injectConfigurationLocalRepository(fluidHomeScreenFragment, this.configurationLocalRepositoryProvider.get());
        injectObservabilityManager(fluidHomeScreenFragment, this.observabilityManagerProvider.get());
        injectTalabatFeatureFlag(fluidHomeScreenFragment, this.talabatFeatureFlagProvider.get());
        injectTalabatTracker(fluidHomeScreenFragment, this.talabatTrackerProvider.get());
        injectCampaignCacheUseCase(fluidHomeScreenFragment, this.campaignCacheUseCaseProvider.get());
        injectCampaignMigratorSharedPreferences(fluidHomeScreenFragment, this.campaignMigratorSharedPreferencesProvider.get());
        injectGson(fluidHomeScreenFragment, this.gsonProvider.get());
        injectScreenTracker(fluidHomeScreenFragment, this.screenTrackerProvider.get());
        injectCustomerRepository(fluidHomeScreenFragment, this.customerRepositoryProvider.get());
        injectDeepLinkNavigator(fluidHomeScreenFragment, this.deepLinkNavigatorProvider.get());
        injectHomeScreenPerformanceObservability(fluidHomeScreenFragment, this.homeScreenPerformanceObservabilityProvider.get());
    }
}
