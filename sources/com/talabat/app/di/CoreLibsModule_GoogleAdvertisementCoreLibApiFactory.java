package com.talabat.app.di;

import com.talabat.core.advertisement.google.domain.GoogleAdvertisementCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_GoogleAdvertisementCoreLibApiFactory implements Factory<GoogleAdvertisementCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_GoogleAdvertisementCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_GoogleAdvertisementCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_GoogleAdvertisementCoreLibApiFactory(coreLibsModule, provider);
    }

    public static GoogleAdvertisementCoreLibApi googleAdvertisementCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (GoogleAdvertisementCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.googleAdvertisementCoreLibApi(contextCoreLibApi));
    }

    public GoogleAdvertisementCoreLibApi get() {
        return googleAdvertisementCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
