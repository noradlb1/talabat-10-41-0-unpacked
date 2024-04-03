package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
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
public final class FeaturesModule_DarkstoresCartListApiFactory implements Factory<DarkstoresCartListApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_DarkstoresCartListApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_DarkstoresCartListApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_DarkstoresCartListApiFactory(provider);
    }

    public static DarkstoresCartListApi darkstoresCartListApi(Map<Class<?>, Api> map) {
        return (DarkstoresCartListApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresCartListApi(map));
    }

    public DarkstoresCartListApi get() {
        return darkstoresCartListApi(this.coreApisProvider.get());
    }
}
