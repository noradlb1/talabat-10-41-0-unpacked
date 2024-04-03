package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class FeaturesModule_DarkstoresFlutterCartApiFactory implements Factory<DarkstoresFlutterCartApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;
    private final Provider<DarkstoresCartApi> darkstoresCartApiProvider;

    public FeaturesModule_DarkstoresFlutterCartApiFactory(Provider<Map<Class<?>, Api>> provider, Provider<DarkstoresCartApi> provider2) {
        this.coreApisProvider = provider;
        this.darkstoresCartApiProvider = provider2;
    }

    public static FeaturesModule_DarkstoresFlutterCartApiFactory create(Provider<Map<Class<?>, Api>> provider, Provider<DarkstoresCartApi> provider2) {
        return new FeaturesModule_DarkstoresFlutterCartApiFactory(provider, provider2);
    }

    public static DarkstoresFlutterCartApi darkstoresFlutterCartApi(Map<Class<?>, Api> map, DarkstoresCartApi darkstoresCartApi) {
        return (DarkstoresFlutterCartApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresFlutterCartApi(map, darkstoresCartApi));
    }

    public DarkstoresFlutterCartApi get() {
        return darkstoresFlutterCartApi(this.coreApisProvider.get(), this.darkstoresCartApiProvider.get());
    }
}
