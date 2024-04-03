package com.talabat.feature.foodcart2.data;

import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FoodCartRepository_Factory implements Factory<FoodCartRepository> {
    private final Provider<FoodCartFlutterDataSource> flutterDataSourceProvider;

    public FoodCartRepository_Factory(Provider<FoodCartFlutterDataSource> provider) {
        this.flutterDataSourceProvider = provider;
    }

    public static FoodCartRepository_Factory create(Provider<FoodCartFlutterDataSource> provider) {
        return new FoodCartRepository_Factory(provider);
    }

    public static FoodCartRepository newInstance(FoodCartFlutterDataSource foodCartFlutterDataSource) {
        return new FoodCartRepository(foodCartFlutterDataSource);
    }

    public FoodCartRepository get() {
        return newInstance(this.flutterDataSourceProvider.get());
    }
}
