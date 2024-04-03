package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/di/DarkstoresScheduledDeliveryComponent;", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/DarkstoresScheduledDeliveryFeatureApi;", "Factory", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, DispatcherCoreLibApi.class, ExperimentCoreLibApi.class, NetworkCoreLibApi.class}, modules = {DarkstoresScheduledDeliveryDataModule.class, DarkstoresScheduledDeliveryDomainModule.class, DarkstoresScheduledDeliveryNetworkModule.class})
public interface DarkstoresScheduledDeliveryComponent extends DarkstoresScheduledDeliveryFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/di/DarkstoresScheduledDeliveryComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/di/DarkstoresScheduledDeliveryComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkstoresScheduledDeliveryComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi);
    }
}
