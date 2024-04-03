package com.talabat.feature.pharmacy.presentation.channel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PrescriptionMethodCallHandler_Factory implements Factory<PrescriptionMethodCallHandler> {
    private final Provider<PrescriptionChannelCallback> callbackProvider;

    public PrescriptionMethodCallHandler_Factory(Provider<PrescriptionChannelCallback> provider) {
        this.callbackProvider = provider;
    }

    public static PrescriptionMethodCallHandler_Factory create(Provider<PrescriptionChannelCallback> provider) {
        return new PrescriptionMethodCallHandler_Factory(provider);
    }

    public static PrescriptionMethodCallHandler newInstance(PrescriptionChannelCallback prescriptionChannelCallback) {
        return new PrescriptionMethodCallHandler(prescriptionChannelCallback);
    }

    public PrescriptionMethodCallHandler get() {
        return newInstance(this.callbackProvider.get());
    }
}
