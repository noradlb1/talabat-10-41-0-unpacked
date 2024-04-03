package com.talabat.feature.tmart.growth.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import tracking.gtm.ITalabatFirebase;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthTrackingModule_ProvideFirebaseTrackingFactory implements Factory<ITalabatFirebase> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TMartGrowthTrackingModule_ProvideFirebaseTrackingFactory INSTANCE = new TMartGrowthTrackingModule_ProvideFirebaseTrackingFactory();

        private InstanceHolder() {
        }
    }

    public static TMartGrowthTrackingModule_ProvideFirebaseTrackingFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ITalabatFirebase provideFirebaseTracking() {
        return (ITalabatFirebase) Preconditions.checkNotNullFromProvides(TMartGrowthTrackingModule.INSTANCE.provideFirebaseTracking());
    }

    public ITalabatFirebase get() {
        return provideFirebaseTracking();
    }
}
