package com.talabat.flutter.groceryhome.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import service.ApiHandler;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GroceryHomeApiModule_ProvideApiHandlerFactory implements Factory<ApiHandler> {
    private final GroceryHomeApiModule module;

    public GroceryHomeApiModule_ProvideApiHandlerFactory(GroceryHomeApiModule groceryHomeApiModule) {
        this.module = groceryHomeApiModule;
    }

    public static GroceryHomeApiModule_ProvideApiHandlerFactory create(GroceryHomeApiModule groceryHomeApiModule) {
        return new GroceryHomeApiModule_ProvideApiHandlerFactory(groceryHomeApiModule);
    }

    public static ApiHandler provideApiHandler(GroceryHomeApiModule groceryHomeApiModule) {
        return (ApiHandler) Preconditions.checkNotNullFromProvides(groceryHomeApiModule.provideApiHandler());
    }

    public ApiHandler get() {
        return provideApiHandler(this.module);
    }
}
