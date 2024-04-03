package com.talabat.trackorder.presentation.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.trackorder.presentation.OrderTrackingFlutterActivity;
import com.talabat.trackorder.presentation.OrderTrackingFlutterActivity_MembersInjector;
import com.talabat.trackorder.presentation.di.OrderTrackingComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerOrderTrackingComponent {

    public static final class Factory implements OrderTrackingComponent.Factory {
        private Factory() {
        }

        public OrderTrackingComponent create(ObservabilityCoreLibApi observabilityCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new OrderTrackingComponentImpl(trackingCoreLibApi, observabilityCoreLibApi, experimentCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi, helpCenterFeatureApi, featureFlagCoreLibApi);
        }
    }

    public static final class OrderTrackingComponentImpl implements OrderTrackingComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final OrderTrackingComponentImpl orderTrackingComponentImpl;

        private OrderTrackingComponentImpl(TrackingCoreLibApi trackingCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.orderTrackingComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        private OrderTrackingFlutterActivity injectOrderTrackingFlutterActivity(OrderTrackingFlutterActivity orderTrackingFlutterActivity) {
            OrderTrackingFlutterActivity_MembersInjector.injectScreenTracker(orderTrackingFlutterActivity, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            OrderTrackingFlutterActivity_MembersInjector.injectTalabatFeatureFlags(orderTrackingFlutterActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            OrderTrackingFlutterActivity_MembersInjector.injectExperiment(orderTrackingFlutterActivity, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            OrderTrackingFlutterActivity_MembersInjector.injectNavigator(orderTrackingFlutterActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            OrderTrackingFlutterActivity_MembersInjector.injectHelpCenterDeeplinkBuilder(orderTrackingFlutterActivity, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            OrderTrackingFlutterActivity_MembersInjector.injectDeepLinkNavigator(orderTrackingFlutterActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return orderTrackingFlutterActivity;
        }

        public void inject(OrderTrackingFlutterActivity orderTrackingFlutterActivity) {
            injectOrderTrackingFlutterActivity(orderTrackingFlutterActivity);
        }
    }

    private DaggerOrderTrackingComponent() {
    }

    public static OrderTrackingComponent.Factory factory() {
        return new Factory();
    }
}
