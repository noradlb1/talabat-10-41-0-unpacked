package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_FacebookLoginCoreLibApiFactory implements Factory<FacebookLoginCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_FacebookLoginCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_FacebookLoginCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_FacebookLoginCoreLibApiFactory(coreLibsModule, provider);
    }

    public static FacebookLoginCoreLibApi facebookLoginCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (FacebookLoginCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.facebookLoginCoreLibApi(contextCoreLibApi));
    }

    public FacebookLoginCoreLibApi get() {
        return facebookLoginCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
