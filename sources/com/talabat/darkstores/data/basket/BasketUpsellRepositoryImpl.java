package com.talabat.darkstores.data.basket;

import com.talabat.darkstores.data.basket.local.BasketUpsellLocalDataSource;
import com.talabat.darkstores.domain.basket.BasketUpsellRepository;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/basket/BasketUpsellRepositoryImpl;", "Lcom/talabat/darkstores/domain/basket/BasketUpsellRepository;", "basketUpsellLocalDataSource", "Lcom/talabat/darkstores/data/basket/local/BasketUpsellLocalDataSource;", "(Lcom/talabat/darkstores/data/basket/local/BasketUpsellLocalDataSource;)V", "isBasketUpsellBottomSheetShownForCart", "", "cartId", "", "setBasketUpsellBottomSheetShownForCart", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketUpsellRepositoryImpl implements BasketUpsellRepository {
    @NotNull
    private final BasketUpsellLocalDataSource basketUpsellLocalDataSource;

    @Inject
    public BasketUpsellRepositoryImpl(@NotNull BasketUpsellLocalDataSource basketUpsellLocalDataSource2) {
        Intrinsics.checkNotNullParameter(basketUpsellLocalDataSource2, "basketUpsellLocalDataSource");
        this.basketUpsellLocalDataSource = basketUpsellLocalDataSource2;
    }

    public boolean isBasketUpsellBottomSheetShownForCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        return this.basketUpsellLocalDataSource.isBasketUpsellBottomSheetShownForCart(str);
    }

    public void setBasketUpsellBottomSheetShownForCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        this.basketUpsellLocalDataSource.setBasketUpsellBottomSheetShownForCart(str);
    }
}
