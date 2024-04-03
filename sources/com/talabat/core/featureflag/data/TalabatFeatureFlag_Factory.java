package com.talabat.core.featureflag.data;

import com.talabat.core.featureflag.data.datasource.IFeatureFlagDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TalabatFeatureFlag_Factory implements Factory<TalabatFeatureFlag> {
    private final Provider<IFeatureFlagDataSource> featureFlagDataSourceProvider;

    public TalabatFeatureFlag_Factory(Provider<IFeatureFlagDataSource> provider) {
        this.featureFlagDataSourceProvider = provider;
    }

    public static TalabatFeatureFlag_Factory create(Provider<IFeatureFlagDataSource> provider) {
        return new TalabatFeatureFlag_Factory(provider);
    }

    public static TalabatFeatureFlag newInstance(IFeatureFlagDataSource iFeatureFlagDataSource) {
        return new TalabatFeatureFlag(iFeatureFlagDataSource);
    }

    public TalabatFeatureFlag get() {
        return newInstance(this.featureFlagDataSourceProvider.get());
    }
}
