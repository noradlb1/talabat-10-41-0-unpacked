package com.talabat.talabatremoteconfiguration.di;

import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.datasource.fwf.FwfRemoteConfigurationDataSource;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/di/RemoteConfigCoreLibModule;", "", "()V", "remoteConfigurationDataSource", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RemoteConfigCoreLibModule {
    @NotNull
    public static final RemoteConfigCoreLibModule INSTANCE = new RemoteConfigCoreLibModule();

    private RemoteConfigCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final IRemoteConfigurationDataSource remoteConfigurationDataSource() {
        return new FwfRemoteConfigurationDataSource(FunWithFlags.INSTANCE);
    }
}
