package com.talabat.app.di;

import androidx.work.WorkerFactory;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_SendWorkerFactoryFactory implements Factory<Set<WorkerFactory>> {
    private final Provider<ConfigurationRemoteCoreLibApi> configurationRemoteCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_SendWorkerFactoryFactory(CoreLibsModule coreLibsModule, Provider<ConfigurationRemoteCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.configurationRemoteCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_SendWorkerFactoryFactory create(CoreLibsModule coreLibsModule, Provider<ConfigurationRemoteCoreLibApi> provider) {
        return new CoreLibsModule_SendWorkerFactoryFactory(coreLibsModule, provider);
    }

    public static Set<WorkerFactory> sendWorkerFactory(CoreLibsModule coreLibsModule, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
        return (Set) Preconditions.checkNotNullFromProvides(coreLibsModule.sendWorkerFactory(configurationRemoteCoreLibApi));
    }

    public Set<WorkerFactory> get() {
        return sendWorkerFactory(this.module, this.configurationRemoteCoreLibApiProvider.get());
    }
}
