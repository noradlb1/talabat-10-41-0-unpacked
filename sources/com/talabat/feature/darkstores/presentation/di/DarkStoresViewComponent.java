package com.talabat.feature.darkstores.presentation.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.ui.di.ViewModelFactoryModule;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/di/DarkStoresViewComponent;", "", "inject", "", "target", "Lcom/talabat/feature/darkstores/presentation/activity/DarkStoresDeepLinkActivity;", "Factory", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, DarkstoresFeatureApi.class}, modules = {ViewModelFactoryModule.class, DarkStoresViewModelsModule.class})
public interface DarkStoresViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/di/DarkStoresViewComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstores/presentation/di/DarkStoresViewComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkStoresViewComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull DarkstoresFeatureApi darkstoresFeatureApi);
    }

    void inject(@NotNull DarkStoresDeepLinkActivity darkStoresDeepLinkActivity);
}
