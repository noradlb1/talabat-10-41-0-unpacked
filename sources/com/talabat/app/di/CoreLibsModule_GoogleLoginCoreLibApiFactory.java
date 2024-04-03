package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_GoogleLoginCoreLibApiFactory implements Factory<GoogleLoginCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_GoogleLoginCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_GoogleLoginCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_GoogleLoginCoreLibApiFactory(coreLibsModule, provider);
    }

    public static GoogleLoginCoreLibApi googleLoginCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (GoogleLoginCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.googleLoginCoreLibApi(contextCoreLibApi));
    }

    public GoogleLoginCoreLibApi get() {
        return googleLoginCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
