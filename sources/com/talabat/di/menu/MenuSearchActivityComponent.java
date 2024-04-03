package com.talabat.di.menu;

import com.talabat.MenuSearchActivity;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.di.cart.CartUtilityModule;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/menu/MenuSearchActivityComponent;", "", "inject", "", "target", "Lcom/talabat/MenuSearchActivity;", "Factory", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationRemoteCoreLibApi.class, ExperimentCoreLibApi.class, FoodCartFeatureApi.class}, modules = {CartUtilityModule.class})
public interface MenuSearchActivityComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/di/menu/MenuSearchActivityComponent$Factory;", "", "create", "Lcom/talabat/di/menu/MenuSearchActivityComponent;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "foodCartFeatureApi", "Lcom/talabat/feature/foodcart2/domain/di/FoodCartFeatureApi;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        MenuSearchActivityComponent create(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull FoodCartFeatureApi foodCartFeatureApi);
    }

    void inject(@NotNull MenuSearchActivity menuSearchActivity);
}
