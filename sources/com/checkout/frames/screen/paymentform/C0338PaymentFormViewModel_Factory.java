package com.checkout.frames.screen.paymentform;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.screen.paymentform.PaymentFormViewModel_Factory  reason: case insensitive filesystem */
public final class C0338PaymentFormViewModel_Factory implements Factory<PaymentFormViewModel> {

    /* renamed from: com.checkout.frames.screen.paymentform.PaymentFormViewModel_Factory$InstanceHolder */
    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C0338PaymentFormViewModel_Factory INSTANCE = new C0338PaymentFormViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static C0338PaymentFormViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PaymentFormViewModel newInstance() {
        return new PaymentFormViewModel();
    }

    public PaymentFormViewModel get() {
        return newInstance();
    }
}
