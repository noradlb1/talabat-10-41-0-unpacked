package com.talabat.darkstores.domain.basket;

import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/domain/basket/IsBasketUpsellBottomSheetShownUseCaseImpl;", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellBottomSheetShownUseCase;", "basketUpsellRepository", "Lcom/talabat/darkstores/domain/basket/BasketUpsellRepository;", "(Lcom/talabat/darkstores/domain/basket/BasketUpsellRepository;)V", "invoke", "", "cartId", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsBasketUpsellBottomSheetShownUseCaseImpl implements IsBasketUpsellBottomSheetShownUseCase {
    @NotNull
    private final BasketUpsellRepository basketUpsellRepository;

    @Inject
    public IsBasketUpsellBottomSheetShownUseCaseImpl(@NotNull BasketUpsellRepository basketUpsellRepository2) {
        Intrinsics.checkNotNullParameter(basketUpsellRepository2, "basketUpsellRepository");
        this.basketUpsellRepository = basketUpsellRepository2;
    }

    public boolean invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        return this.basketUpsellRepository.isBasketUpsellBottomSheetShownForCart(str);
    }
}
