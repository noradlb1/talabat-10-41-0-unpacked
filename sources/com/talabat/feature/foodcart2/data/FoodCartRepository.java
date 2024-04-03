package com.talabat.feature.foodcart2.data;

import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSource;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J7\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/foodcart2/data/FoodCartRepository;", "Lcom/talabat/feature/foodcart2/domain/IFoodCartRepository;", "flutterDataSource", "Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSource;", "(Lcom/talabat/feature/foodcart2/data/datasources/FoodCartFlutterDataSource;)V", "addItem", "", "item", "", "", "", "branchId", "", "deliveryMode", "(Ljava/util/Map;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCurrentCartId", "", "cartId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuantity", "menuItemId", "specialRequest", "updatedQuantity", "choices", "", "(ILjava/lang/String;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_foodcart2_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodCartRepository implements IFoodCartRepository {
    @NotNull
    private final FoodCartFlutterDataSource flutterDataSource;

    @Inject
    public FoodCartRepository(@NotNull FoodCartFlutterDataSource foodCartFlutterDataSource) {
        Intrinsics.checkNotNullParameter(foodCartFlutterDataSource, "flutterDataSource");
        this.flutterDataSource = foodCartFlutterDataSource;
    }

    @Nullable
    public Object addItem(@NotNull Map<String, ? extends Object> map, int i11, @NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object addItem = this.flutterDataSource.addItem(map, i11, str, continuation);
        return addItem == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addItem : Unit.INSTANCE;
    }

    @Nullable
    public Object clearCart(@NotNull Continuation<? super Unit> continuation) {
        Object clearCart = this.flutterDataSource.clearCart(continuation);
        return clearCart == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearCart : Unit.INSTANCE;
    }

    @Nullable
    public Object setCurrentCartId(int i11, @NotNull Continuation<? super Boolean> continuation) {
        return this.flutterDataSource.setCurrentCartId(i11, continuation);
    }

    @Nullable
    public Object updateQuantity(int i11, @NotNull String str, int i12, @NotNull List<Integer> list, @NotNull Continuation<? super Unit> continuation) {
        Object updateQuantity = this.flutterDataSource.updateQuantity(i11, str, i12, list, continuation);
        return updateQuantity == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateQuantity : Unit.INSTANCE;
    }
}
