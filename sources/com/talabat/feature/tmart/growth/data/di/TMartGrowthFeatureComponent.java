package com.talabat.feature.tmart.growth.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthFeatureComponent;", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthFeatureApi;", "Factory", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {SecretCoreLibApi.class, ContextCoreLibApi.class, DispatcherCoreLibApi.class, NetworkCoreLibApi.class}, modules = {TMartGrowthFeatureModule.class})
public interface TMartGrowthFeatureComponent extends TMartGrowthFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthFeatureComponent;", "secretCoreLibApi", "Lcom/talabat/authentication/aaa/di/SecretCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TMartGrowthFeatureComponent create(@NotNull SecretCoreLibApi secretCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull NetworkCoreLibApi networkCoreLibApi);
    }
}
