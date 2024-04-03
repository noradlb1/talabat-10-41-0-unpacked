package com.talabat.trackorder.presentation.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.trackorder.presentation.OrderTrackingFlutterActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/trackorder/presentation/di/OrderTrackingComponent;", "", "inject", "", "activity", "Lcom/talabat/trackorder/presentation/OrderTrackingFlutterActivity;", "Factory", "com_talabat_feature_trackorder_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {TrackingCoreLibApi.class, ObservabilityCoreLibApi.class, ExperimentCoreLibApi.class, NavigationCoreLibApi.class, DeepLinkCoreLibApi.class, HelpCenterFeatureApi.class, FeatureFlagCoreLibApi.class})
public interface OrderTrackingComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/trackorder/presentation/di/OrderTrackingComponent$Factory;", "", "create", "Lcom/talabat/trackorder/presentation/di/OrderTrackingComponent;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "com_talabat_feature_trackorder_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        OrderTrackingComponent create(@NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull HelpCenterFeatureApi helpCenterFeatureApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi);
    }

    void inject(@NotNull OrderTrackingFlutterActivity orderTrackingFlutterActivity);
}
