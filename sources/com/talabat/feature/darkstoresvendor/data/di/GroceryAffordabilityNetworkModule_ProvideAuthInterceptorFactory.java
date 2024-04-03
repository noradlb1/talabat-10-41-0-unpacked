package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstoresvendor.data.di.GroceryAffordability"})
public final class GroceryAffordabilityNetworkModule_ProvideAuthInterceptorFactory implements Factory<Interceptor> {
    private final GroceryAffordabilityNetworkModule module;
    private final Provider<SecretProvider> secretProvider;

    public GroceryAffordabilityNetworkModule_ProvideAuthInterceptorFactory(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<SecretProvider> provider) {
        this.module = groceryAffordabilityNetworkModule;
        this.secretProvider = provider;
    }

    public static GroceryAffordabilityNetworkModule_ProvideAuthInterceptorFactory create(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<SecretProvider> provider) {
        return new GroceryAffordabilityNetworkModule_ProvideAuthInterceptorFactory(groceryAffordabilityNetworkModule, provider);
    }

    public static Interceptor provideAuthInterceptor(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, SecretProvider secretProvider2) {
        return (Interceptor) Preconditions.checkNotNullFromProvides(groceryAffordabilityNetworkModule.provideAuthInterceptor(secretProvider2));
    }

    public Interceptor get() {
        return provideAuthInterceptor(this.module, this.secretProvider.get());
    }
}
