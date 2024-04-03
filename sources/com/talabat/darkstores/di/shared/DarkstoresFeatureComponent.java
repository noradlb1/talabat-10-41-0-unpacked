package com.talabat.darkstores.di.shared;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.darkstores.data.Environment;
import com.talabat.darkstores.di.DarkstoresApiModule;
import com.talabat.darkstores.di.DarkstoresDatabaseModule;
import com.talabat.darkstores.di.DarkstoresFeatureModule;
import com.talabat.darkstores.di.DarkstoresNetworkModule;
import com.talabat.darkstores.di.DarkstoresSchedulersModule;
import com.talabat.darkstores.di.DarkstoresUserDataModule;
import com.talabat.darkstores.di.LibScope;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, ContextCoreLibApi.class, DarkstoresCartApi.class, DeepLinkCoreLibApi.class, DispatcherCoreLibApi.class, NavigationCoreLibApi.class, ParserCoreLibApi.class}, modules = {DarkstoresApiModule.class, DarkstoresNetworkModule.class, DarkstoresDatabaseModule.class, DarkstoresFeatureModule.class, DarkstoresSchedulersModule.class, DarkstoresUserDataModule.class})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/di/shared/DarkstoresFeatureComponent;", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "Factory", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public interface DarkstoresFeatureComponent extends DarkstoresFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/di/shared/DarkstoresFeatureComponent$Factory;", "", "create", "Lcom/talabat/darkstores/di/shared/DarkstoresFeatureComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "darkstoresCartApi", "Lcom/talabat/feature/darkstorescart/data/di/DarkstoresCartApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "environment", "Lcom/talabat/darkstores/data/Environment;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkstoresFeatureComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DarkstoresCartApi darkstoresCartApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull @BindsInstance Environment environment, @NotNull ParserCoreLibApi parserCoreLibApi);
    }
}
