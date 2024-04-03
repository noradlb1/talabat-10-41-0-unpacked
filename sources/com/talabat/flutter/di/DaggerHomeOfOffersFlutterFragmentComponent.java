package com.talabat.flutter.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.flutter.HomeOfOffersFlutterFragment;
import com.talabat.flutter.HomeOfOffersFlutterFragment_MembersInjector;
import com.talabat.flutter.di.HomeOfOffersFlutterFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerHomeOfOffersFlutterFragmentComponent {

    public static final class Factory implements HomeOfOffersFlutterFragmentComponent.Factory {
        private Factory() {
        }

        public HomeOfOffersFlutterFragmentComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new HomeOfOffersFlutterFragmentComponentImpl(featureFlagCoreLibApi);
        }
    }

    public static final class HomeOfOffersFlutterFragmentComponentImpl implements HomeOfOffersFlutterFragmentComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HomeOfOffersFlutterFragmentComponentImpl homeOfOffersFlutterFragmentComponentImpl;

        private HomeOfOffersFlutterFragmentComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.homeOfOffersFlutterFragmentComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private HomeOfOffersFlutterFragment injectHomeOfOffersFlutterFragment(HomeOfOffersFlutterFragment homeOfOffersFlutterFragment) {
            HomeOfOffersFlutterFragment_MembersInjector.injectTalabatFeatureFlag(homeOfOffersFlutterFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return homeOfOffersFlutterFragment;
        }

        public void inject(HomeOfOffersFlutterFragment homeOfOffersFlutterFragment) {
            injectHomeOfOffersFlutterFragment(homeOfOffersFlutterFragment);
        }
    }

    private DaggerHomeOfOffersFlutterFragmentComponent() {
    }

    public static HomeOfOffersFlutterFragmentComponent.Factory factory() {
        return new Factory();
    }
}
