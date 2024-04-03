package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_HuaweiWatchCoreLibApiFactory implements Factory<HuaweiWatchCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_HuaweiWatchCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_HuaweiWatchCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_HuaweiWatchCoreLibApiFactory(coreLibsModule, provider);
    }

    public static HuaweiWatchCoreLibApi huaweiWatchCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (HuaweiWatchCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.huaweiWatchCoreLibApi(contextCoreLibApi));
    }

    public HuaweiWatchCoreLibApi get() {
        return huaweiWatchCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
