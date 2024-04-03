package com.talabat.feature.darkstorescarrierbag.data;

import com.talabat.feature.darkstorescarrierbag.data.datasource.DarkstoresCarrierBagLocalDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCarrierBagRepositoryImpl_Factory implements Factory<DarkstoresCarrierBagRepositoryImpl> {
    private final Provider<DarkstoresCarrierBagLocalDataSource> dataSourceProvider;

    public DarkstoresCarrierBagRepositoryImpl_Factory(Provider<DarkstoresCarrierBagLocalDataSource> provider) {
        this.dataSourceProvider = provider;
    }

    public static DarkstoresCarrierBagRepositoryImpl_Factory create(Provider<DarkstoresCarrierBagLocalDataSource> provider) {
        return new DarkstoresCarrierBagRepositoryImpl_Factory(provider);
    }

    public static DarkstoresCarrierBagRepositoryImpl newInstance(DarkstoresCarrierBagLocalDataSource darkstoresCarrierBagLocalDataSource) {
        return new DarkstoresCarrierBagRepositoryImpl(darkstoresCarrierBagLocalDataSource);
    }

    public DarkstoresCarrierBagRepositoryImpl get() {
        return newInstance(this.dataSourceProvider.get());
    }
}
