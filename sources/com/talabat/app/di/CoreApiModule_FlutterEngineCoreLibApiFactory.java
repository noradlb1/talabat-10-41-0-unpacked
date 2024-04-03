package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.engine.domain.di.FlutterEngineCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FlutterEngineCoreLibApiFactory implements Factory<Api> {
    private final Provider<FlutterEngineCoreLibApi> flutterEngineCoreLibApiProvider;

    public CoreApiModule_FlutterEngineCoreLibApiFactory(Provider<FlutterEngineCoreLibApi> provider) {
        this.flutterEngineCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FlutterEngineCoreLibApiFactory create(Provider<FlutterEngineCoreLibApi> provider) {
        return new CoreApiModule_FlutterEngineCoreLibApiFactory(provider);
    }

    public static Api flutterEngineCoreLibApi(FlutterEngineCoreLibApi flutterEngineCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.flutterEngineCoreLibApi(flutterEngineCoreLibApi));
    }

    public Api get() {
        return flutterEngineCoreLibApi(this.flutterEngineCoreLibApiProvider.get());
    }
}
