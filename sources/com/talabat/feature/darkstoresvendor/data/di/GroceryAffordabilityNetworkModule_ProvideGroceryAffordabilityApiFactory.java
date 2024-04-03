package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.feature.darkstoresvendor.data.remote.GroceryAffordabilityApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstoresvendor.data.di.GroceryAffordability"})
public final class GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityApiFactory implements Factory<GroceryAffordabilityApi> {
    private final GroceryAffordabilityNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityApiFactory(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<Retrofit> provider) {
        this.module = groceryAffordabilityNetworkModule;
        this.retrofitProvider = provider;
    }

    public static GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityApiFactory create(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<Retrofit> provider) {
        return new GroceryAffordabilityNetworkModule_ProvideGroceryAffordabilityApiFactory(groceryAffordabilityNetworkModule, provider);
    }

    public static GroceryAffordabilityApi provideGroceryAffordabilityApi(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Retrofit retrofit) {
        return (GroceryAffordabilityApi) Preconditions.checkNotNullFromProvides(groceryAffordabilityNetworkModule.provideGroceryAffordabilityApi(retrofit));
    }

    public GroceryAffordabilityApi get() {
        return provideGroceryAffordabilityApi(this.module, this.retrofitProvider.get());
    }
}
