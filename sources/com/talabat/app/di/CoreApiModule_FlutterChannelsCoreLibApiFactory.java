package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.channels.domain.di.FlutterChannelsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FlutterChannelsCoreLibApiFactory implements Factory<Api> {
    private final Provider<FlutterChannelsCoreLibApi> flutterChannelsCoreLibApiProvider;

    public CoreApiModule_FlutterChannelsCoreLibApiFactory(Provider<FlutterChannelsCoreLibApi> provider) {
        this.flutterChannelsCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FlutterChannelsCoreLibApiFactory create(Provider<FlutterChannelsCoreLibApi> provider) {
        return new CoreApiModule_FlutterChannelsCoreLibApiFactory(provider);
    }

    public static Api flutterChannelsCoreLibApi(FlutterChannelsCoreLibApi flutterChannelsCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.flutterChannelsCoreLibApi(flutterChannelsCoreLibApi));
    }

    public Api get() {
        return flutterChannelsCoreLibApi(this.flutterChannelsCoreLibApiProvider.get());
    }
}
