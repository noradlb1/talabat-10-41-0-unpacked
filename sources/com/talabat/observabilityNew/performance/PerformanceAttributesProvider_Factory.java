package com.talabat.observabilityNew.performance;

import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PerformanceAttributesProvider_Factory implements Factory<PerformanceAttributesProvider> {
    private final Provider<TalabatPerseusRepository> talabatPerseusRepositoryProvider;

    public PerformanceAttributesProvider_Factory(Provider<TalabatPerseusRepository> provider) {
        this.talabatPerseusRepositoryProvider = provider;
    }

    public static PerformanceAttributesProvider_Factory create(Provider<TalabatPerseusRepository> provider) {
        return new PerformanceAttributesProvider_Factory(provider);
    }

    public static PerformanceAttributesProvider newInstance() {
        return new PerformanceAttributesProvider();
    }

    public PerformanceAttributesProvider get() {
        PerformanceAttributesProvider newInstance = newInstance();
        PerformanceAttributesProvider_MembersInjector.injectTalabatPerseusRepository(newInstance, this.talabatPerseusRepositoryProvider.get());
        return newInstance;
    }
}
