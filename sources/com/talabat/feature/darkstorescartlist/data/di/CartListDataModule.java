package com.talabat.feature.darkstorescartlist.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.feature.darkstorescartlist.data.mapper.CartInfoResponseMapper;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import com.talabat.feature.darkstorescartlist.data.repository.DarkstoresCartListRepositoryImpl;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.talabat.mapper.ModelMapper;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/di/CartListDataModule;", "", "()V", "provideCartInfoResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartInfo;", "mapper", "Lcom/talabat/feature/darkstorescartlist/data/mapper/CartInfoResponseMapper;", "provideCartListRepository", "Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "cartListRepositoryImpl", "Lcom/talabat/feature/darkstorescartlist/data/repository/DarkstoresCartListRepositoryImpl;", "provideIntegrationGlobalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class CartListDataModule {
    @NotNull
    @Provides
    public final ModelMapper<CartInfoResponse, CartInfo> provideCartInfoResponseMapper(@NotNull CartInfoResponseMapper cartInfoResponseMapper) {
        Intrinsics.checkNotNullParameter(cartInfoResponseMapper, "mapper");
        return cartInfoResponseMapper;
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresCartListRepository provideCartListRepository(@NotNull DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresCartListRepositoryImpl, "cartListRepositoryImpl");
        return darkstoresCartListRepositoryImpl;
    }

    @NotNull
    @Provides
    public final IntegrationGlobalDataModel.Companion provideIntegrationGlobalDataModel() {
        return IntegrationGlobalDataModel.Companion;
    }

    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("darkstores_preferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        return sharedPreferences;
    }
}
