package com.talabat.feature.foodcart2.data.di;

import com.talabat.feature.foodcart2.data.FoodCartRepository;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSource;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/feature/foodcart2/data/di/FoodCartFeatureModule;", "", "foodCartDataSource", "Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSource;", "impl", "Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSourceImpl;", "foodCartRepository", "Lcom/talabat/feature/foodcart2/domain/IFoodCartRepository;", "Lcom/talabat/feature/foodcart2/data/FoodCartRepository;", "com_talabat_feature_foodcart2_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FoodCartFeatureModule {
    @NotNull
    @Binds
    FoodCartFlutterDataSource foodCartDataSource(@NotNull FoodCartFlutterDataSourceImpl foodCartFlutterDataSourceImpl);

    @NotNull
    @Binds
    IFoodCartRepository foodCartRepository(@NotNull FoodCartRepository foodCartRepository);
}
