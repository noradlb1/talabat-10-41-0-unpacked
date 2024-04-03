package com.talabat.authentication.natives.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeJwtTokenManager_Factory implements Factory<FakeJwtTokenManager> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeJwtTokenManager_Factory INSTANCE = new FakeJwtTokenManager_Factory();

        private InstanceHolder() {
        }
    }

    public static FakeJwtTokenManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FakeJwtTokenManager newInstance() {
        return new FakeJwtTokenManager();
    }

    public FakeJwtTokenManager get() {
        return newInstance();
    }
}
