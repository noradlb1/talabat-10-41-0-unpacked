package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_HuaweiWatchCoreLibApiFactory implements Factory<Api> {
    private final Provider<HuaweiWatchCoreLibApi> huaweiWatchCoreLibApiProvider;

    public CoreApiModule_HuaweiWatchCoreLibApiFactory(Provider<HuaweiWatchCoreLibApi> provider) {
        this.huaweiWatchCoreLibApiProvider = provider;
    }

    public static CoreApiModule_HuaweiWatchCoreLibApiFactory create(Provider<HuaweiWatchCoreLibApi> provider) {
        return new CoreApiModule_HuaweiWatchCoreLibApiFactory(provider);
    }

    public static Api huaweiWatchCoreLibApi(HuaweiWatchCoreLibApi huaweiWatchCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.huaweiWatchCoreLibApi(huaweiWatchCoreLibApi));
    }

    public Api get() {
        return huaweiWatchCoreLibApi(this.huaweiWatchCoreLibApiProvider.get());
    }
}
