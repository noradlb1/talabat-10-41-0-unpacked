package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/di/SwimlanesFeatureComponent;", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesFeatureApi;", "Factory", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, DispatcherCoreLibApi.class, FeatureFlagCoreLibApi.class, NetworkCoreLibApi.class, ObservabilityCoreLibApi.class}, modules = {SwimlanesFeatureModule.class})
public interface SwimlanesFeatureComponent extends SwimlanesFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/di/SwimlanesFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstores/swimlanes/data/di/SwimlanesFeatureComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SwimlanesFeatureComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi);
    }
}
