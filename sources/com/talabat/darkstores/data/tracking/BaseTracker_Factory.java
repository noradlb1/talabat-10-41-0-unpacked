package com.talabat.darkstores.data.tracking;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;
import tracking.gtm.ITalabatFirebase;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class BaseTracker_Factory implements Factory<BaseTracker> {
    private final Provider<Context> contextProvider;
    private final Provider<ITalabatFirebase> firebaseProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<LocationTrackingProvider> locationTrackingProvider;
    private final Provider<StoreInfoTrackingProvider> storeInfoTrackingProvider;

    public BaseTracker_Factory(Provider<Context> provider, Provider<ITalabatFirebase> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4, Provider<Scheduler> provider5) {
        this.contextProvider = provider;
        this.firebaseProvider = provider2;
        this.storeInfoTrackingProvider = provider3;
        this.locationTrackingProvider = provider4;
        this.ioSchedulerProvider = provider5;
    }

    public static BaseTracker_Factory create(Provider<Context> provider, Provider<ITalabatFirebase> provider2, Provider<StoreInfoTrackingProvider> provider3, Provider<LocationTrackingProvider> provider4, Provider<Scheduler> provider5) {
        return new BaseTracker_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BaseTracker newInstance(Context context, ITalabatFirebase iTalabatFirebase, StoreInfoTrackingProvider storeInfoTrackingProvider2, LocationTrackingProvider locationTrackingProvider2, Scheduler scheduler) {
        return new BaseTracker(context, iTalabatFirebase, storeInfoTrackingProvider2, locationTrackingProvider2, scheduler);
    }

    public BaseTracker get() {
        return newInstance(this.contextProvider.get(), this.firebaseProvider.get(), this.storeInfoTrackingProvider.get(), this.locationTrackingProvider.get(), this.ioSchedulerProvider.get());
    }
}
