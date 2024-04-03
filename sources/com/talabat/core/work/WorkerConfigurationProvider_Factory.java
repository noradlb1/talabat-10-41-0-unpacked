package com.talabat.core.work;

import androidx.work.WorkerFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WorkerConfigurationProvider_Factory implements Factory<WorkerConfigurationProvider> {
    private final Provider<Set<WorkerFactory>> workerFactoriesProvider;

    public WorkerConfigurationProvider_Factory(Provider<Set<WorkerFactory>> provider) {
        this.workerFactoriesProvider = provider;
    }

    public static WorkerConfigurationProvider_Factory create(Provider<Set<WorkerFactory>> provider) {
        return new WorkerConfigurationProvider_Factory(provider);
    }

    public static WorkerConfigurationProvider newInstance(Set<WorkerFactory> set) {
        return new WorkerConfigurationProvider(set);
    }

    public WorkerConfigurationProvider get() {
        return newInstance(this.workerFactoriesProvider.get());
    }
}
