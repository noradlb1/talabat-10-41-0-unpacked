package com.talabat.feature.darkstorescartlist.data.remote;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RestaurantJsonAdapter_Factory implements Factory<RestaurantJsonAdapter> {
    private final Provider<Gson> gsonProvider;

    public RestaurantJsonAdapter_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static RestaurantJsonAdapter_Factory create(Provider<Gson> provider) {
        return new RestaurantJsonAdapter_Factory(provider);
    }

    public static RestaurantJsonAdapter newInstance(Gson gson) {
        return new RestaurantJsonAdapter(gson);
    }

    public RestaurantJsonAdapter get() {
        return newInstance(this.gsonProvider.get());
    }
}
