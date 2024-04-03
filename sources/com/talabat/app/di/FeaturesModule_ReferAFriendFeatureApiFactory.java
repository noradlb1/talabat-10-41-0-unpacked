package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
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
public final class FeaturesModule_ReferAFriendFeatureApiFactory implements Factory<ReferAFriendFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_ReferAFriendFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_ReferAFriendFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_ReferAFriendFeatureApiFactory(provider);
    }

    public static ReferAFriendFeatureApi referAFriendFeatureApi(Map<Class<?>, Api> map) {
        return (ReferAFriendFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.referAFriendFeatureApi(map));
    }

    public ReferAFriendFeatureApi get() {
        return referAFriendFeatureApi(this.coreApisProvider.get());
    }
}
