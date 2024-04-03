package com.talabat.busypopup;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BusyPopupBottomSheet_MembersInjector implements MembersInjector<BusyPopupBottomSheet> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public BusyPopupBottomSheet_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2) {
        this.talabatFeatureFlagProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<BusyPopupBottomSheet> create(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2) {
        return new BusyPopupBottomSheet_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.busypopup.BusyPopupBottomSheet.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(BusyPopupBottomSheet busyPopupBottomSheet, LocationConfigurationRepository locationConfigurationRepository) {
        busyPopupBottomSheet.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.busypopup.BusyPopupBottomSheet.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(BusyPopupBottomSheet busyPopupBottomSheet, ITalabatFeatureFlag iTalabatFeatureFlag) {
        busyPopupBottomSheet.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(BusyPopupBottomSheet busyPopupBottomSheet) {
        injectTalabatFeatureFlag(busyPopupBottomSheet, this.talabatFeatureFlagProvider.get());
        injectLocationConfigurationRepository(busyPopupBottomSheet, this.locationConfigurationRepositoryProvider.get());
    }
}
