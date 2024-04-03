package com.talabat.feature.darkstorestooltip;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresTooltipRepositoryImpl_Factory implements Factory<DarkstoresTooltipRepositoryImpl> {
    private final Provider<DarkstoresTooltipDataSource> dataSourceProvider;

    public DarkstoresTooltipRepositoryImpl_Factory(Provider<DarkstoresTooltipDataSource> provider) {
        this.dataSourceProvider = provider;
    }

    public static DarkstoresTooltipRepositoryImpl_Factory create(Provider<DarkstoresTooltipDataSource> provider) {
        return new DarkstoresTooltipRepositoryImpl_Factory(provider);
    }

    public static DarkstoresTooltipRepositoryImpl newInstance(DarkstoresTooltipDataSource darkstoresTooltipDataSource) {
        return new DarkstoresTooltipRepositoryImpl(darkstoresTooltipDataSource);
    }

    public DarkstoresTooltipRepositoryImpl get() {
        return newInstance(this.dataSourceProvider.get());
    }
}
