package com.talabat.feature.pharmacy.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PharmacyPrescriptionBaseUrl_Factory implements Factory<PharmacyPrescriptionBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PharmacyPrescriptionBaseUrl_Factory INSTANCE = new PharmacyPrescriptionBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static PharmacyPrescriptionBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PharmacyPrescriptionBaseUrl newInstance() {
        return new PharmacyPrescriptionBaseUrl();
    }

    public PharmacyPrescriptionBaseUrl get() {
        return newInstance();
    }
}
