package com.talabat.feature.tpro.presentation.helperview.mov;

import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Named;
import javax.inject.Provider;

@QualifierMetadata({"javax.inject.Named"})
@DaggerGenerated
public final class TProVendorMovView_MembersInjector implements MembersInjector<TProVendorMovView> {
    private final Provider<Boolean> isNfvFlagEnabledProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<VendorMovViewModelFactory> viewModelFactoryProvider;

    public TProVendorMovView_MembersInjector(Provider<LocationConfigurationRepository> provider, Provider<Boolean> provider2, Provider<VendorMovViewModelFactory> provider3) {
        this.locationConfigurationRepositoryProvider = provider;
        this.isNfvFlagEnabledProvider = provider2;
        this.viewModelFactoryProvider = provider3;
    }

    public static MembersInjector<TProVendorMovView> create(Provider<LocationConfigurationRepository> provider, Provider<Boolean> provider2, Provider<VendorMovViewModelFactory> provider3) {
        return new TProVendorMovView_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView.isNfvFlagEnabled")
    @Named("isTproNfvEnabled")
    public static void injectIsNfvFlagEnabled(TProVendorMovView tProVendorMovView, Provider<Boolean> provider) {
        tProVendorMovView.isNfvFlagEnabled = provider;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(TProVendorMovView tProVendorMovView, LocationConfigurationRepository locationConfigurationRepository) {
        tProVendorMovView.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView.viewModelFactory")
    public static void injectViewModelFactory(TProVendorMovView tProVendorMovView, VendorMovViewModelFactory vendorMovViewModelFactory) {
        tProVendorMovView.viewModelFactory = vendorMovViewModelFactory;
    }

    public void injectMembers(TProVendorMovView tProVendorMovView) {
        injectLocationConfigurationRepository(tProVendorMovView, this.locationConfigurationRepositoryProvider.get());
        injectIsNfvFlagEnabled(tProVendorMovView, this.isNfvFlagEnabledProvider);
        injectViewModelFactory(tProVendorMovView, this.viewModelFactoryProvider.get());
    }
}
