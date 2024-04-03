package com.talabat.feature.cancellationpolicy.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/di/HelpCenterFeatureComponent;", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "Factory", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {NetworkCoreLibApi.class, ConfigurationLocalCoreLibApi.class, TrackingCoreLibApi.class, FeatureFlagCoreLibApi.class, DispatcherCoreLibApi.class}, modules = {HelpCenterFeatureModule.class})
public interface HelpCenterFeatureComponent extends HelpCenterFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/di/HelpCenterFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/cancellationpolicy/di/HelpCenterFeatureComponent;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        HelpCenterFeatureComponent create(@NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi);
    }
}
