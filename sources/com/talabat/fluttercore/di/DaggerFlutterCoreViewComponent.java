package com.talabat.fluttercore.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.fluttercore.di.FlutterCoreViewComponent;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFlutterCoreViewComponent {

    public static final class Factory implements FlutterCoreViewComponent.Factory {
        private Factory() {
        }

        public FlutterCoreViewComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new FlutterCoreViewComponentImpl(configurationRemoteCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class FlutterCoreViewComponentImpl implements FlutterCoreViewComponent {
        private final FlutterCoreViewComponentImpl flutterCoreViewComponentImpl;

        private FlutterCoreViewComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            this.flutterCoreViewComponentImpl = this;
        }

        public void inject(TalabatFlutterFragmentActivity talabatFlutterFragmentActivity) {
        }
    }

    private DaggerFlutterCoreViewComponent() {
    }

    public static FlutterCoreViewComponent.Factory factory() {
        return new Factory();
    }
}
