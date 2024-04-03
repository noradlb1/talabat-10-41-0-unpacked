package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import tracking.gtm.ITalabatFirebase;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideTalabatFirebaseFactory implements Factory<ITalabatFirebase> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApplicationModule_ProvideTalabatFirebaseFactory INSTANCE = new DarkstoresApplicationModule_ProvideTalabatFirebaseFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApplicationModule_ProvideTalabatFirebaseFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ITalabatFirebase provideTalabatFirebase() {
        return (ITalabatFirebase) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideTalabatFirebase());
    }

    public ITalabatFirebase get() {
        return provideTalabatFirebase();
    }
}
