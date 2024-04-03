package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FlutterBindingCoreLibApiFactory implements Factory<Api> {
    private final Provider<FlutterBindingCoreLibApi> flutterBindingCoreLibApiProvider;

    public CoreApiModule_FlutterBindingCoreLibApiFactory(Provider<FlutterBindingCoreLibApi> provider) {
        this.flutterBindingCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FlutterBindingCoreLibApiFactory create(Provider<FlutterBindingCoreLibApi> provider) {
        return new CoreApiModule_FlutterBindingCoreLibApiFactory(provider);
    }

    public static Api flutterBindingCoreLibApi(FlutterBindingCoreLibApi flutterBindingCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.flutterBindingCoreLibApi(flutterBindingCoreLibApi));
    }

    public Api get() {
        return flutterBindingCoreLibApi(this.flutterBindingCoreLibApiProvider.get());
    }
}
