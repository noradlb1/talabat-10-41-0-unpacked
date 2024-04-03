package com.talabat.core.featureflag.data.fake;

import com.talabat.core.featureflag.data.datasource.IFeatureFlagDataSource;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.featureflag.data.di.LocalData"})
public final class FakeFeatureFlagCoreLibModule_ProvideTalabatFeatureFlagFactory implements Factory<ITalabatFeatureFlag> {
    private final Provider<IFeatureFlagDataSource> localFeatureFlagDataSourceProvider;

    public FakeFeatureFlagCoreLibModule_ProvideTalabatFeatureFlagFactory(Provider<IFeatureFlagDataSource> provider) {
        this.localFeatureFlagDataSourceProvider = provider;
    }

    public static FakeFeatureFlagCoreLibModule_ProvideTalabatFeatureFlagFactory create(Provider<IFeatureFlagDataSource> provider) {
        return new FakeFeatureFlagCoreLibModule_ProvideTalabatFeatureFlagFactory(provider);
    }

    public static ITalabatFeatureFlag provideTalabatFeatureFlag(IFeatureFlagDataSource iFeatureFlagDataSource) {
        return (ITalabatFeatureFlag) Preconditions.checkNotNullFromProvides(FakeFeatureFlagCoreLibModule.INSTANCE.provideTalabatFeatureFlag(iFeatureFlagDataSource));
    }

    public ITalabatFeatureFlag get() {
        return provideTalabatFeatureFlag(this.localFeatureFlagDataSourceProvider.get());
    }
}
