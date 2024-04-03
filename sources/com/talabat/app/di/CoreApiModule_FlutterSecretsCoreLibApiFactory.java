package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.flutter.secrets.domain.FlutterSecretsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FlutterSecretsCoreLibApiFactory implements Factory<Api> {
    private final Provider<FlutterSecretsCoreLibApi> flutterSecretsCoreLibApiProvider;

    public CoreApiModule_FlutterSecretsCoreLibApiFactory(Provider<FlutterSecretsCoreLibApi> provider) {
        this.flutterSecretsCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FlutterSecretsCoreLibApiFactory create(Provider<FlutterSecretsCoreLibApi> provider) {
        return new CoreApiModule_FlutterSecretsCoreLibApiFactory(provider);
    }

    public static Api flutterSecretsCoreLibApi(FlutterSecretsCoreLibApi flutterSecretsCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.flutterSecretsCoreLibApi(flutterSecretsCoreLibApi));
    }

    public Api get() {
        return flutterSecretsCoreLibApi(this.flutterSecretsCoreLibApiProvider.get());
    }
}
