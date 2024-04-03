package com.talabat.app.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_SecretCoreLibApiFactory implements Factory<SecretCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_SecretCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_SecretCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_SecretCoreLibApiFactory(coreLibsModule);
    }

    public static SecretCoreLibApi secretCoreLibApi(CoreLibsModule coreLibsModule) {
        return (SecretCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.secretCoreLibApi());
    }

    public SecretCoreLibApi get() {
        return secretCoreLibApi(this.module);
    }
}
