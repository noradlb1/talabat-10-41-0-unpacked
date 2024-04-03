package com.talabat.splash.presentation.infrastructure.device;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CommonUtils_Factory implements Factory<CommonUtils> {
    private final Provider<Gson> gsonProvider;

    public CommonUtils_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static CommonUtils_Factory create(Provider<Gson> provider) {
        return new CommonUtils_Factory(provider);
    }

    public static CommonUtils newInstance(Gson gson) {
        return new CommonUtils(gson);
    }

    public CommonUtils get() {
        return newInstance(this.gsonProvider.get());
    }
}
