package com.talabat.feature.foodcart2.domain;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/foodcart2/domain/IFoodCartRepository;", "", "addItem", "", "item", "", "", "branchId", "", "deliveryMode", "(Ljava/util/Map;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCurrentCartId", "", "cartId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuantity", "menuItemId", "specialRequest", "updatedQuantity", "choices", "", "(ILjava/lang/String;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_foodcart2_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFoodCartRepository {
    @Nullable
    Object addItem(@NotNull Map<String, ? extends Object> map, int i11, @NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object clearCart(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object setCurrentCartId(int i11, @NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object updateQuantity(int i11, @NotNull String str, int i12, @NotNull List<Integer> list, @NotNull Continuation<? super Unit> continuation);
}
