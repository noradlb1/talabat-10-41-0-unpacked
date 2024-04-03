package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class DarkstoresSchedulersModule_ProvideIoSchedulerFactory implements Factory<Scheduler> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresSchedulersModule_ProvideIoSchedulerFactory INSTANCE = new DarkstoresSchedulersModule_ProvideIoSchedulerFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresSchedulersModule_ProvideIoSchedulerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Scheduler provideIoScheduler() {
        return (Scheduler) Preconditions.checkNotNullFromProvides(DarkstoresSchedulersModule.INSTANCE.provideIoScheduler());
    }

    public Scheduler get() {
        return provideIoScheduler();
    }
}
