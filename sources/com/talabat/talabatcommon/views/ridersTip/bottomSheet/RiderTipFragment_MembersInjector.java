package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RiderTipFragment_MembersInjector implements MembersInjector<RiderTipFragment> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public RiderTipFragment_MembersInjector(Provider<LocationConfigurationRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.locationConfigurationRepositoryProvider = provider;
        this.featureFlagRepositoryProvider = provider2;
    }

    public static MembersInjector<RiderTipFragment> create(Provider<LocationConfigurationRepository> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new RiderTipFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipFragment.featureFlagRepository")
    public static void injectFeatureFlagRepository(RiderTipFragment riderTipFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        riderTipFragment.featureFlagRepository = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(RiderTipFragment riderTipFragment, LocationConfigurationRepository locationConfigurationRepository) {
        riderTipFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(RiderTipFragment riderTipFragment) {
        injectLocationConfigurationRepository(riderTipFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlagRepository(riderTipFragment, this.featureFlagRepositoryProvider.get());
    }
}
