package com.talabat.app.di;

import androidx.work.WorkerFactory;
import com.talabat.core.work.di.WorkCoreLibApi;
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
public final class CoreLibsModule_WorkCoreLibApiFactory implements Factory<WorkCoreLibApi> {
    private final CoreLibsModule module;
    private final Provider<Set<WorkerFactory>> workerFactoriesProvider;

    public CoreLibsModule_WorkCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<Set<WorkerFactory>> provider) {
        this.module = coreLibsModule;
        this.workerFactoriesProvider = provider;
    }

    public static CoreLibsModule_WorkCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<Set<WorkerFactory>> provider) {
        return new CoreLibsModule_WorkCoreLibApiFactory(coreLibsModule, provider);
    }

    public static WorkCoreLibApi workCoreLibApi(CoreLibsModule coreLibsModule, Set<WorkerFactory> set) {
        return (WorkCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.workCoreLibApi(set));
    }

    public WorkCoreLibApi get() {
        return workCoreLibApi(this.module, this.workerFactoriesProvider.get());
    }
}
