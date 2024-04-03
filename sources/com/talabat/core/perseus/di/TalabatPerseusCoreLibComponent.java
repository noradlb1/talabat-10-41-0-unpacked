package com.talabat.core.perseus.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/perseus/di/TalabatPerseusCoreLibComponent;", "Lcom/talabat/core/perseus/domain/TalabatPerseusCoreLibApi;", "Factory", "com_talabat_core_perseus_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationRemoteCoreLibApi.class, ContextCoreLibApi.class, DispatcherCoreLibApi.class}, modules = {TalabatPerseusModule.class})
public interface TalabatPerseusCoreLibComponent extends TalabatPerseusCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/core/perseus/di/TalabatPerseusCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/perseus/di/TalabatPerseusCoreLibComponent;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "com_talabat_core_perseus_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TalabatPerseusCoreLibComponent create(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi);
    }
}
