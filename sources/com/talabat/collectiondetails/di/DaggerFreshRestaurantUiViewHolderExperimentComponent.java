package com.talabat.collectiondetails.di;

import com.talabat.collectiondetails.di.FreshRestaurantUiViewHolderExperimentComponent;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment_MembersInjector;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFreshRestaurantUiViewHolderExperimentComponent {

    public static final class Factory implements FreshRestaurantUiViewHolderExperimentComponent.Factory {
        private Factory() {
        }

        public FreshRestaurantUiViewHolderExperimentComponent create(TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new FreshRestaurantUiViewHolderExperimentComponentImpl(trackingCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class FreshRestaurantUiViewHolderExperimentComponentImpl implements FreshRestaurantUiViewHolderExperimentComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FreshRestaurantUiViewHolderExperimentComponentImpl freshRestaurantUiViewHolderExperimentComponentImpl;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private FreshRestaurantUiViewHolderExperimentComponentImpl(TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.freshRestaurantUiViewHolderExperimentComponentImpl = this;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private FreshRestaurantUiViewHolderExperiment injectFreshRestaurantUiViewHolderExperiment(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment) {
            FreshRestaurantUiViewHolderExperiment_MembersInjector.injectTracker(freshRestaurantUiViewHolderExperiment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            FreshRestaurantUiViewHolderExperiment_MembersInjector.injectTalabatFeatureFlag(freshRestaurantUiViewHolderExperiment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            return freshRestaurantUiViewHolderExperiment;
        }

        public void inject(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment) {
            injectFreshRestaurantUiViewHolderExperiment(freshRestaurantUiViewHolderExperiment);
        }
    }

    private DaggerFreshRestaurantUiViewHolderExperimentComponent() {
    }

    public static FreshRestaurantUiViewHolderExperimentComponent.Factory factory() {
        return new Factory();
    }
}
