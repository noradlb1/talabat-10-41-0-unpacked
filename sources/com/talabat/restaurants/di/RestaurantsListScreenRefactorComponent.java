package com.talabat.restaurants.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/di/RestaurantsListScreenRefactorComponent;", "", "inject", "", "target", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, ExperimentCoreLibApi.class, FeatureFlagCoreLibApi.class, ObservabilityCoreLibApi.class, NavigationCoreLibApi.class, DeepLinkCoreLibApi.class})
public interface RestaurantsListScreenRefactorComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/restaurants/di/RestaurantsListScreenRefactorComponent$Factory;", "", "create", "Lcom/talabat/restaurants/di/RestaurantsListScreenRefactorComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "navigatorCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        RestaurantsListScreenRefactorComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi);
    }

    void inject(@NotNull RestaurantsListScreenRefactor restaurantsListScreenRefactor);
}
