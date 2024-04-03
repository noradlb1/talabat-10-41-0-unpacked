package com.talabat.darkstores.di;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.Environment;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresEnvironmentModule;", "", "()V", "provideEnvironment", "Lcom/talabat/darkstores/data/Environment;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresEnvironmentModule {
    @NotNull
    public static final DarkstoresEnvironmentModule INSTANCE = new DarkstoresEnvironmentModule();

    private DarkstoresEnvironmentModule() {
    }

    @NotNull
    @LibScope
    @Provides
    public final Environment provideEnvironment(@NotNull ConfigurationParameters configurationParameters) {
        Intrinsics.checkNotNullParameter(configurationParameters, "configurationParameters");
        return configurationParameters.getEnvironment();
    }
}
