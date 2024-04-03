package com.talabat.flutter.groceryhome.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/flutter/groceryhome/di/GroceryHomeComponent;", "", "inject", "", "activity", "Lcom/talabat/flutter/groceryhome/presentation/activity/GroceryHomeFlutterActivity;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DarkstoresFeatureApi.class, ActiveCartsApi.class, FeatureFlagCoreLibApi.class, ExperimentCoreLibApi.class, DispatcherCoreLibApi.class, ConfigurationLocalCoreLibApi.class, NavigationCoreLibApi.class}, modules = {GroceryHomeModule.class, GroceryHomeApiModule.class})
public interface GroceryHomeComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/flutter/groceryhome/di/GroceryHomeComponent$Factory;", "", "create", "Lcom/talabat/flutter/groceryhome/di/GroceryHomeComponent;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "activeCartsApi", "Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        GroceryHomeComponent create(@NotNull DarkstoresFeatureApi darkstoresFeatureApi, @NotNull ActiveCartsApi activeCartsApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi);
    }

    void inject(@NotNull GroceryHomeFlutterActivity groceryHomeFlutterActivity);
}
