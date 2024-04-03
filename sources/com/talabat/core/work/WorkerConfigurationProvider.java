package com.talabat.core.work;

import androidx.work.Configuration;
import androidx.work.DelegatingWorkerFactory;
import androidx.work.WorkerFactory;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001a\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0019\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/core/work/WorkerConfigurationProvider;", "Landroidx/work/Configuration$Provider;", "workerFactories", "", "Landroidx/work/WorkerFactory;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Set;)V", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "com_talabat_core_work_work"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WorkerConfigurationProvider implements Configuration.Provider {
    @NotNull
    private final Set<WorkerFactory> workerFactories;

    @Inject
    public WorkerConfigurationProvider(@NotNull Set<WorkerFactory> set) {
        Intrinsics.checkNotNullParameter(set, "workerFactories");
        this.workerFactories = set;
    }

    @NotNull
    public Configuration getWorkManagerConfiguration() {
        DelegatingWorkerFactory delegatingWorkerFactory = new DelegatingWorkerFactory();
        for (WorkerFactory addFactory : this.workerFactories) {
            delegatingWorkerFactory.addFactory(addFactory);
        }
        Configuration build = new Configuration.Builder().setMinimumLoggingLevel(4).setWorkerFactory(delegatingWorkerFactory).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ory)\n            .build()");
        return build;
    }
}
