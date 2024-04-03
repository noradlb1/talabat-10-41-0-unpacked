package com.talabat.darkstores.data.dynamicPricing.remote;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class DeliveryDetailsRepo_Factory implements Factory<DeliveryDetailsRepo> {
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<Scheduler> ioSchedulerProvider;

    public DeliveryDetailsRepo_Factory(Provider<DarkstoresRepo> provider, Provider<Scheduler> provider2) {
        this.darkstoresRepoProvider = provider;
        this.ioSchedulerProvider = provider2;
    }

    public static DeliveryDetailsRepo_Factory create(Provider<DarkstoresRepo> provider, Provider<Scheduler> provider2) {
        return new DeliveryDetailsRepo_Factory(provider, provider2);
    }

    public static DeliveryDetailsRepo newInstance(DarkstoresRepo darkstoresRepo, Scheduler scheduler) {
        return new DeliveryDetailsRepo(darkstoresRepo, scheduler);
    }

    public DeliveryDetailsRepo get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.ioSchedulerProvider.get());
    }
}
