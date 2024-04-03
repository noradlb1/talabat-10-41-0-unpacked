package com.talabat.darkstores.data.basket.local;

import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/basket/local/BasketUpsellLocalDataSourceImpl;", "Lcom/talabat/darkstores/data/basket/local/BasketUpsellLocalDataSource;", "()V", "cartForWhichBottomSheetShown", "", "", "isBasketUpsellBottomSheetShownForCart", "", "cartId", "setBasketUpsellBottomSheetShownForCart", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketUpsellLocalDataSourceImpl implements BasketUpsellLocalDataSource {
    @NotNull
    public static final BasketUpsellLocalDataSourceImpl INSTANCE = new BasketUpsellLocalDataSourceImpl();
    @NotNull
    private static Set<String> cartForWhichBottomSheetShown = SetsKt__SetsKt.emptySet();

    private BasketUpsellLocalDataSourceImpl() {
    }

    public boolean isBasketUpsellBottomSheetShownForCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        return cartForWhichBottomSheetShown.contains(str);
    }

    public void setBasketUpsellBottomSheetShownForCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Set<String> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(cartForWhichBottomSheetShown);
        mutableSet.add(str);
        cartForWhichBottomSheetShown = mutableSet;
    }
}
