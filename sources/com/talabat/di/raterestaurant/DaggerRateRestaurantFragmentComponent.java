package com.talabat.di.raterestaurant;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.di.raterestaurant.RateRestaurantFragmentComponent;
import com.talabat.fragments.RateRestaurantFragment;
import com.talabat.fragments.RateRestaurantFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRateRestaurantFragmentComponent {

    public static final class Factory implements RateRestaurantFragmentComponent.Factory {
        private Factory() {
        }

        public RateRestaurantFragmentComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new RateRestaurantFragmentComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class RateRestaurantFragmentComponentImpl implements RateRestaurantFragmentComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final RateRestaurantFragmentComponentImpl rateRestaurantFragmentComponentImpl;

        private RateRestaurantFragmentComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.rateRestaurantFragmentComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RateRestaurantFragment injectRateRestaurantFragment(RateRestaurantFragment rateRestaurantFragment) {
            RateRestaurantFragment_MembersInjector.injectTalabatFeatureFlag(rateRestaurantFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return rateRestaurantFragment;
        }

        public void inject(RateRestaurantFragment rateRestaurantFragment) {
            injectRateRestaurantFragment(rateRestaurantFragment);
        }
    }

    private DaggerRateRestaurantFragmentComponent() {
    }

    public static RateRestaurantFragmentComponent.Factory factory() {
        return new Factory();
    }
}
