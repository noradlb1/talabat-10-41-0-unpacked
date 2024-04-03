package com.talabat.feature.subscriptions.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeGetTProOrderStatusUseCase_Factory implements Factory<FakeGetTProOrderStatusUseCase> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeGetTProOrderStatusUseCase_Factory INSTANCE = new FakeGetTProOrderStatusUseCase_Factory();

        private InstanceHolder() {
        }
    }

    public static FakeGetTProOrderStatusUseCase_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FakeGetTProOrderStatusUseCase newInstance() {
        return new FakeGetTProOrderStatusUseCase();
    }

    public FakeGetTProOrderStatusUseCase get() {
        return newInstance();
    }
}
