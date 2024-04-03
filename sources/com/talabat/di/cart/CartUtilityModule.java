package com.talabat.di.cart;

import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.cart.CartUtility;
import library.talabat.mvp.cart.CartUtilityImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/di/cart/CartUtilityModule;", "", "()V", "provideCartUtility", "Llibrary/talabat/mvp/cart/CartUtility;", "foodCartRepository", "Lcom/talabat/feature/foodcart2/domain/IFoodCartRepository;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class CartUtilityModule {
    @NotNull
    public static final CartUtilityModule INSTANCE = new CartUtilityModule();

    private CartUtilityModule() {
    }

    @NotNull
    @Provides
    public final CartUtility provideCartUtility(@NotNull IFoodCartRepository iFoodCartRepository) {
        Intrinsics.checkNotNullParameter(iFoodCartRepository, "foodCartRepository");
        return new CartUtilityImpl(iFoodCartRepository, (CoroutineScope) null, 2, (DefaultConstructorMarker) null);
    }
}
