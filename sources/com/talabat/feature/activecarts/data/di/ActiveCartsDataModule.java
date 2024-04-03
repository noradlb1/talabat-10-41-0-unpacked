package com.talabat.feature.activecarts.data.di;

import buisnessmodels.Cart;
import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/feature/activecarts/data/di/ActiveCartsDataModule;", "", "()V", "provideActiveCartRepository", "Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "impl", "Lcom/talabat/feature/activecarts/data/repository/ActiveCartInfoRepositoryImpl;", "provideCart", "Lbuisnessmodels/Cart;", "com_talabat_feature_active-carts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class ActiveCartsDataModule {
    @NotNull
    @Reusable
    @Provides
    public final ActiveCartRepository provideActiveCartRepository(@NotNull ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl) {
        Intrinsics.checkNotNullParameter(activeCartInfoRepositoryImpl, "impl");
        return activeCartInfoRepositoryImpl;
    }

    @NotNull
    @Provides
    public final Cart provideCart() {
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }
}
