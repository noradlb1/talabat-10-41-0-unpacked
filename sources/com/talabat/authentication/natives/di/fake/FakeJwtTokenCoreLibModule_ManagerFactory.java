package com.talabat.authentication.natives.di.fake;

import com.talabat.authentication.JwtTokenManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FakeJwtTokenCoreLibModule_ManagerFactory implements Factory<JwtTokenManager> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeJwtTokenCoreLibModule_ManagerFactory INSTANCE = new FakeJwtTokenCoreLibModule_ManagerFactory();

        private InstanceHolder() {
        }
    }

    public static FakeJwtTokenCoreLibModule_ManagerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static JwtTokenManager manager() {
        return (JwtTokenManager) Preconditions.checkNotNullFromProvides(FakeJwtTokenCoreLibModule.INSTANCE.manager());
    }

    public JwtTokenManager get() {
        return manager();
    }
}
