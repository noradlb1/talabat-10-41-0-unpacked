package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.UiScheduler"})
public final class DarkstoresSchedulersModule_ProvideMainSchedulerFactory implements Factory<Scheduler> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresSchedulersModule_ProvideMainSchedulerFactory INSTANCE = new DarkstoresSchedulersModule_ProvideMainSchedulerFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresSchedulersModule_ProvideMainSchedulerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Scheduler provideMainScheduler() {
        return (Scheduler) Preconditions.checkNotNullFromProvides(DarkstoresSchedulersModule.INSTANCE.provideMainScheduler());
    }

    public Scheduler get() {
        return provideMainScheduler();
    }
}
