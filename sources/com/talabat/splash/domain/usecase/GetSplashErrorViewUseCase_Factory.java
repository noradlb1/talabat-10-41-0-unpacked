package com.talabat.splash.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetSplashErrorViewUseCase_Factory implements Factory<GetSplashErrorViewUseCase> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GetSplashErrorViewUseCase_Factory INSTANCE = new GetSplashErrorViewUseCase_Factory();

        private InstanceHolder() {
        }
    }

    public static GetSplashErrorViewUseCase_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GetSplashErrorViewUseCase newInstance() {
        return new GetSplashErrorViewUseCase();
    }

    public GetSplashErrorViewUseCase get() {
        return newInstance();
    }
}
