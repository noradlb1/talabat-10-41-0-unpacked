package com.talabat.feature.tpro.presentation.savings;

import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TProSavingsCancellationBottomSheetFragment_MembersInjector implements MembersInjector<TProSavingsCancellationBottomSheetFragment> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public TProSavingsCancellationBottomSheetFragment_MembersInjector(Provider<LocationConfigurationRepository> provider) {
        this.locationConfigurationRepositoryProvider = provider;
    }

    public static MembersInjector<TProSavingsCancellationBottomSheetFragment> create(Provider<LocationConfigurationRepository> provider) {
        return new TProSavingsCancellationBottomSheetFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.savings.TProSavingsCancellationBottomSheetFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment, LocationConfigurationRepository locationConfigurationRepository) {
        tProSavingsCancellationBottomSheetFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment) {
        injectLocationConfigurationRepository(tProSavingsCancellationBottomSheetFragment, this.locationConfigurationRepositoryProvider.get());
    }
}
