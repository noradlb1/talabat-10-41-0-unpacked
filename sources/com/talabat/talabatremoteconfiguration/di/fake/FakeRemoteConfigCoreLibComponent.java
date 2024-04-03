package com.talabat.talabatremoteconfiguration.di.fake;

import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/di/fake/FakeRemoteConfigCoreLibComponent;", "Lcom/talabat/talabatremoteconfiguration/di/RemoteConfigCoreLibApi;", "Factory", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(modules = {FakeRemoteConfigCoreLibModule.class})
public interface FakeRemoteConfigCoreLibComponent extends RemoteConfigCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/di/fake/FakeRemoteConfigCoreLibComponent$Factory;", "", "create", "Lcom/talabat/talabatremoteconfiguration/di/fake/FakeRemoteConfigCoreLibComponent;", "fwf", "Lcom/talabat/core/fwf/domain/IFunWithFlags;", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        FakeRemoteConfigCoreLibComponent create(@NotNull @BindsInstance @Named("TestFwf") IFunWithFlags iFunWithFlags);
    }
}
