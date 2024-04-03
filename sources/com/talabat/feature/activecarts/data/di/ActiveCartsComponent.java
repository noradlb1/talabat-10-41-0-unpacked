package com.talabat.feature.activecarts.data.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/activecarts/data/di/ActiveCartsComponent;", "Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "Factory", "com_talabat_feature_active-carts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DarkstoresCartListApi.class, DarkstoresFeatureApi.class, DispatcherCoreLibApi.class, ExperimentCoreLibApi.class, TrackingCoreLibApi.class}, modules = {ActiveCartsDataModule.class, ActiveCartsDomainModule.class})
public interface ActiveCartsComponent extends ActiveCartsApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/activecarts/data/di/ActiveCartsComponent$Factory;", "", "create", "Lcom/talabat/feature/activecarts/data/di/ActiveCartsComponent;", "darkstoresCartListApi", "Lcom/talabat/feature/darkstorescartlist/domain/di/DarkstoresCartListApi;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_feature_active-carts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ActiveCartsComponent create(@NotNull DarkstoresCartListApi darkstoresCartListApi, @NotNull DarkstoresFeatureApi darkstoresFeatureApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }
}
