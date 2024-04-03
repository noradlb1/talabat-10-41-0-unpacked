package com.talabat.core.work.di;

import androidx.work.Configuration;
import androidx.work.WorkerFactory;
import com.talabat.core.work.WorkerConfigurationProvider;
import com.talabat.core.work.WorkerConfigurationProvider_Factory;
import com.talabat.core.work.di.WorkCoreLibComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerWorkCoreLibComponent {

    public static final class Factory implements WorkCoreLibComponent.Factory {
        private Factory() {
        }

        public WorkCoreLibComponent create(Set<WorkerFactory> set) {
            Preconditions.checkNotNull(set);
            return new WorkCoreLibComponentImpl(set);
        }
    }

    public static final class WorkCoreLibComponentImpl implements WorkCoreLibComponent {
        private Provider<Configuration.Provider> configurationProvider;
        private final WorkCoreLibComponentImpl workCoreLibComponentImpl;
        private Provider<WorkerConfigurationProvider> workerConfigurationProvider;
        private Provider<Set<WorkerFactory>> workerFactoriesProvider;

        private WorkCoreLibComponentImpl(Set<WorkerFactory> set) {
            this.workCoreLibComponentImpl = this;
            initialize(set);
        }

        private void initialize(Set<WorkerFactory> set) {
            dagger.internal.Factory<T> create = InstanceFactory.create(set);
            this.workerFactoriesProvider = create;
            WorkerConfigurationProvider_Factory create2 = WorkerConfigurationProvider_Factory.create(create);
            this.workerConfigurationProvider = create2;
            this.configurationProvider = SingleCheck.provider(create2);
        }

        public Configuration.Provider getConfigurationProvider() {
            return this.configurationProvider.get();
        }
    }

    private DaggerWorkCoreLibComponent() {
    }

    public static WorkCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
