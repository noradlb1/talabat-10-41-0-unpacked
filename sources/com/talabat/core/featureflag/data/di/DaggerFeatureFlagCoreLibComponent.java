package com.talabat.core.featureflag.data.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.data.TalabatFeatureFlag;
import com.talabat.core.featureflag.data.TalabatFeatureFlag_Factory;
import com.talabat.core.featureflag.data.datasource.impl.FwfFeatureFlagDataSource;
import com.talabat.core.featureflag.data.datasource.impl.FwfFeatureFlagDataSource_Factory;
import com.talabat.core.featureflag.data.di.FeatureFlagCoreLibComponent;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFeatureFlagCoreLibComponent {

    public static final class Factory implements FeatureFlagCoreLibComponent.Factory {
        private Factory() {
        }

        public FeatureFlagCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new FeatureFlagCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    public static final class FeatureFlagCoreLibComponentImpl implements FeatureFlagCoreLibComponent {
        private final FeatureFlagCoreLibComponentImpl featureFlagCoreLibComponentImpl;
        private Provider<FwfFeatureFlagDataSource> fwfFeatureFlagDataSourceProvider;
        private Provider<ITalabatFeatureFlag> provideTalabatFeatureFlagProvider;
        private Provider<TalabatFeatureFlag> talabatFeatureFlagProvider;

        private FeatureFlagCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.featureFlagCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            FwfFeatureFlagDataSource_Factory create = FwfFeatureFlagDataSource_Factory.create(FunWithFlagsModule_ProvideFunWithFlagsFactory.create());
            this.fwfFeatureFlagDataSourceProvider = create;
            TalabatFeatureFlag_Factory create2 = TalabatFeatureFlag_Factory.create(create);
            this.talabatFeatureFlagProvider = create2;
            this.provideTalabatFeatureFlagProvider = SingleCheck.provider(create2);
        }

        public ITalabatFeatureFlag getTalabatFeatureFlag() {
            return this.provideTalabatFeatureFlagProvider.get();
        }
    }

    private DaggerFeatureFlagCoreLibComponent() {
    }

    public static FeatureFlagCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
