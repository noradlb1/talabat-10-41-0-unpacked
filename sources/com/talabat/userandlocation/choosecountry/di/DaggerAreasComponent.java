package com.talabat.userandlocation.choosecountry.di;

import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.userandlocation.choosecountry.di.AreasComponent;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.RequestAreasToCacheUseCaseImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerAreasComponent {

    public static final class AreasComponentImpl implements AreasComponent {
        private final AreasComponentImpl areasComponentImpl;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;

        private AreasComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2) {
            this.areasComponentImpl = this;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private RequestAreasToCacheUseCaseImpl requestAreasToCacheUseCaseImpl() {
            return new RequestAreasToCacheUseCaseImpl((MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        public RequestAreasToCacheUseCase getRequestAreasToCacheUseCase() {
            return requestAreasToCacheUseCaseImpl();
        }
    }

    public static final class Factory implements AreasComponent.Factory {
        private Factory() {
        }

        public AreasComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            return new AreasComponentImpl(featureFlagCoreLibApi, mutableConfigurationRemoteCoreLibApi);
        }
    }

    private DaggerAreasComponent() {
    }

    public static AreasComponent.Factory factory() {
        return new Factory();
    }
}
