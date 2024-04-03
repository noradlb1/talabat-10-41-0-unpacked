package com.talabat.di.ratedelivery;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.di.ratedelivery.RateDeliveryFragmentComponent;
import com.talabat.fragments.RateDeliveryFragment;
import com.talabat.fragments.RateDeliveryFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRateDeliveryFragmentComponent {

    public static final class Factory implements RateDeliveryFragmentComponent.Factory {
        private Factory() {
        }

        public RateDeliveryFragmentComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new RateDeliveryFragmentComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class RateDeliveryFragmentComponentImpl implements RateDeliveryFragmentComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final RateDeliveryFragmentComponentImpl rateDeliveryFragmentComponentImpl;

        private RateDeliveryFragmentComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.rateDeliveryFragmentComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RateDeliveryFragment injectRateDeliveryFragment(RateDeliveryFragment rateDeliveryFragment) {
            RateDeliveryFragment_MembersInjector.injectTalabatFeatureFlag(rateDeliveryFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return rateDeliveryFragment;
        }

        public void inject(RateDeliveryFragment rateDeliveryFragment) {
            injectRateDeliveryFragment(rateDeliveryFragment);
        }
    }

    private DaggerRateDeliveryFragmentComponent() {
    }

    public static RateDeliveryFragmentComponent.Factory factory() {
        return new Factory();
    }
}
