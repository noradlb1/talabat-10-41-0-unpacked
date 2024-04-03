package com.talabat.authentication.aaa.di;

import com.talabat.authentication.aaa.AaaApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class AaaModule_AaaApiFactory implements Factory<AaaApi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AaaModule_AaaApiFactory INSTANCE = new AaaModule_AaaApiFactory();

        private InstanceHolder() {
        }
    }

    public static AaaApi aaaApi() {
        return (AaaApi) Preconditions.checkNotNullFromProvides(AaaModule.INSTANCE.aaaApi());
    }

    public static AaaModule_AaaApiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public AaaApi get() {
        return aaaApi();
    }
}
