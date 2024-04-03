package com.talabat.darkstores.data.grocery;

import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class GroceryShoppingRepository_Factory implements Factory<GroceryShoppingRepository> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<GroceryShoppingApi> groceryShoppingApiProvider;

    public GroceryShoppingRepository_Factory(Provider<GroceryShoppingApi> provider, Provider<ConfigurationParameters> provider2) {
        this.groceryShoppingApiProvider = provider;
        this.configurationParametersProvider = provider2;
    }

    public static GroceryShoppingRepository_Factory create(Provider<GroceryShoppingApi> provider, Provider<ConfigurationParameters> provider2) {
        return new GroceryShoppingRepository_Factory(provider, provider2);
    }

    public static GroceryShoppingRepository newInstance(GroceryShoppingApi groceryShoppingApi, ConfigurationParameters configurationParameters) {
        return new GroceryShoppingRepository(groceryShoppingApi, configurationParameters);
    }

    public GroceryShoppingRepository get() {
        return newInstance(this.groceryShoppingApiProvider.get(), this.configurationParametersProvider.get());
    }
}
