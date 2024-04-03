package com.talabat.talabatremoteconfiguration.di.fake;

import com.talabat.core.fwf.domain.IFunWithFlags;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.datasource.fake.FakeRemoteConfigurationDataSource;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/di/fake/FakeRemoteConfigCoreLibModule;", "", "()V", "remoteConfigurationDataSource", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "fwf", "Lcom/talabat/core/fwf/domain/IFunWithFlags;", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FakeRemoteConfigCoreLibModule {
    @NotNull
    public static final FakeRemoteConfigCoreLibModule INSTANCE = new FakeRemoteConfigCoreLibModule();

    private FakeRemoteConfigCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final IRemoteConfigurationDataSource remoteConfigurationDataSource(@NotNull @Named("TestFwf") IFunWithFlags iFunWithFlags) {
        Intrinsics.checkNotNullParameter(iFunWithFlags, "fwf");
        return new FakeRemoteConfigurationDataSource(iFunWithFlags);
    }
}
