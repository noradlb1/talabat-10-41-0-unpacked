package com.talabat.observabilityNew.performance;

import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PerformanceAttributesProvider_MembersInjector implements MembersInjector<PerformanceAttributesProvider> {
    private final Provider<TalabatPerseusRepository> talabatPerseusRepositoryProvider;

    public PerformanceAttributesProvider_MembersInjector(Provider<TalabatPerseusRepository> provider) {
        this.talabatPerseusRepositoryProvider = provider;
    }

    public static MembersInjector<PerformanceAttributesProvider> create(Provider<TalabatPerseusRepository> provider) {
        return new PerformanceAttributesProvider_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.observabilityNew.performance.PerformanceAttributesProvider.talabatPerseusRepository")
    public static void injectTalabatPerseusRepository(PerformanceAttributesProvider performanceAttributesProvider, TalabatPerseusRepository talabatPerseusRepository) {
        performanceAttributesProvider.talabatPerseusRepository = talabatPerseusRepository;
    }

    public void injectMembers(PerformanceAttributesProvider performanceAttributesProvider) {
        injectTalabatPerseusRepository(performanceAttributesProvider, this.talabatPerseusRepositoryProvider.get());
    }
}
