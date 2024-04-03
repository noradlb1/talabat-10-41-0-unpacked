package com.talabat.restaurants.v2.ui.fragments;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class VendorsListFragment_MembersInjector implements MembersInjector<VendorsListFragment> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public VendorsListFragment_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2) {
        this.talabatFeatureFlagProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<VendorsListFragment> create(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2) {
        return new VendorsListFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.restaurants.v2.ui.fragments.VendorsListFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(VendorsListFragment vendorsListFragment, LocationConfigurationRepository locationConfigurationRepository) {
        vendorsListFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.restaurants.v2.ui.fragments.VendorsListFragment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(VendorsListFragment vendorsListFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        vendorsListFragment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(VendorsListFragment vendorsListFragment) {
        injectTalabatFeatureFlag(vendorsListFragment, this.talabatFeatureFlagProvider.get());
        injectLocationConfigurationRepository(vendorsListFragment, this.locationConfigurationRepositoryProvider.get());
    }
}
