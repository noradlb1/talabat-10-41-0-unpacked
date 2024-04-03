package com.talabat.app.di;

import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_AaaCoreLibApiFactory implements Factory<AaaCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_AaaCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static AaaCoreLibApi aaaCoreLibApi(CoreLibsModule coreLibsModule) {
        return (AaaCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.aaaCoreLibApi());
    }

    public static CoreLibsModule_AaaCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_AaaCoreLibApiFactory(coreLibsModule);
    }

    public AaaCoreLibApi get() {
        return aaaCoreLibApi(this.module);
    }
}
