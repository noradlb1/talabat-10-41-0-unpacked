package com.talabat.app.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_FlutterSecretsCoreLibApiFactory implements Factory<FlutterSecretsCoreLibApi> {
    private final CoreLibsModule module;
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;

    public CoreLibsModule_FlutterSecretsCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<SecretCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.secretCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_FlutterSecretsCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<SecretCoreLibApi> provider) {
        return new CoreLibsModule_FlutterSecretsCoreLibApiFactory(coreLibsModule, provider);
    }

    public static FlutterSecretsCoreLibApi flutterSecretsCoreLibApi(CoreLibsModule coreLibsModule, SecretCoreLibApi secretCoreLibApi) {
        return (FlutterSecretsCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.flutterSecretsCoreLibApi(secretCoreLibApi));
    }

    public FlutterSecretsCoreLibApi get() {
        return flutterSecretsCoreLibApi(this.module, this.secretCoreLibApiProvider.get());
    }
}
