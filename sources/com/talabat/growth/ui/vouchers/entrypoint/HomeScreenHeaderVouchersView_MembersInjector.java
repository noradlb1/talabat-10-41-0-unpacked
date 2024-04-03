package com.talabat.growth.ui.vouchers.entrypoint;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class HomeScreenHeaderVouchersView_MembersInjector implements MembersInjector<HomeScreenHeaderVouchersView> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<VoucherEntryPointViewModelFactory> factoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;

    public HomeScreenHeaderVouchersView_MembersInjector(Provider<CoroutineDispatchersFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ConfigurationLocalRepository> provider4, Provider<Navigator> provider5, Provider<VoucherEntryPointViewModelFactory> provider6) {
        this.coroutineDispatchersFactoryProvider = provider;
        this.featureFlagRepoProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.configurationLocalRepositoryProvider = provider4;
        this.navigatorProvider = provider5;
        this.factoryProvider = provider6;
    }

    public static MembersInjector<HomeScreenHeaderVouchersView> create(Provider<CoroutineDispatchersFactory> provider, Provider<ITalabatFeatureFlag> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ConfigurationLocalRepository> provider4, Provider<Navigator> provider5, Provider<VoucherEntryPointViewModelFactory> provider6) {
        return new HomeScreenHeaderVouchersView_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, ConfigurationLocalRepository configurationLocalRepository) {
        homeScreenHeaderVouchersView.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        homeScreenHeaderVouchersView.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView.factory")
    public static void injectFactory(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory) {
        homeScreenHeaderVouchersView.factory = voucherEntryPointViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView.featureFlagRepo")
    public static void injectFeatureFlagRepo(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        homeScreenHeaderVouchersView.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, LocationConfigurationRepository locationConfigurationRepository) {
        homeScreenHeaderVouchersView.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView.navigator")
    public static void injectNavigator(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView, Navigator navigator) {
        homeScreenHeaderVouchersView.navigator = navigator;
    }

    public void injectMembers(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        injectCoroutineDispatchersFactory(homeScreenHeaderVouchersView, this.coroutineDispatchersFactoryProvider.get());
        injectFeatureFlagRepo(homeScreenHeaderVouchersView, this.featureFlagRepoProvider.get());
        injectLocationConfigurationRepository(homeScreenHeaderVouchersView, this.locationConfigurationRepositoryProvider.get());
        injectConfigurationLocalRepository(homeScreenHeaderVouchersView, this.configurationLocalRepositoryProvider.get());
        injectNavigator(homeScreenHeaderVouchersView, this.navigatorProvider.get());
        injectFactory(homeScreenHeaderVouchersView, this.factoryProvider.get());
    }
}
