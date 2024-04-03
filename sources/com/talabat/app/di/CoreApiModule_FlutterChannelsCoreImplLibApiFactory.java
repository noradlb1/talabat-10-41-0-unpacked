package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreImplLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FlutterChannelsCoreImplLibApiFactory implements Factory<Api> {
    private final Provider<FlutterChannelsCoreImplLibApi> flutterChannelsCoreImplLibApiProvider;

    public CoreApiModule_FlutterChannelsCoreImplLibApiFactory(Provider<FlutterChannelsCoreImplLibApi> provider) {
        this.flutterChannelsCoreImplLibApiProvider = provider;
    }

    public static CoreApiModule_FlutterChannelsCoreImplLibApiFactory create(Provider<FlutterChannelsCoreImplLibApi> provider) {
        return new CoreApiModule_FlutterChannelsCoreImplLibApiFactory(provider);
    }

    public static Api flutterChannelsCoreImplLibApi(FlutterChannelsCoreImplLibApi flutterChannelsCoreImplLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.flutterChannelsCoreImplLibApi(flutterChannelsCoreImplLibApi));
    }

    public Api get() {
        return flutterChannelsCoreImplLibApi(this.flutterChannelsCoreImplLibApiProvider.get());
    }
}
