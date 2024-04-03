package com.talabat.feature.darkstorescartlist.data.mapper;

import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.mapper.ModelMapper;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0002¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/mapper/CartInfoResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartInfo;", "()V", "apply", "source", "isValid", "", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartInfoResponseMapper implements ModelMapper<CartInfoResponse, CartInfo> {
    private final boolean isValid(CartInfoResponse cartInfoResponse) {
        if (cartInfoResponse.getCartId() == null || cartInfoResponse.getItemCount() == null || cartInfoResponse.getItemCount().intValue() <= 0 || cartInfoResponse.getTotalPrice() == null || cartInfoResponse.getGlobalVendorId() == null || cartInfoResponse.getRestaurant() == null) {
            return false;
        }
        return true;
    }

    @Nullable
    public CartInfo apply(@NotNull CartInfoResponse cartInfoResponse) {
        Intrinsics.checkNotNullParameter(cartInfoResponse, "source");
        if (!isValid(cartInfoResponse)) {
            return null;
        }
        String cartId = cartInfoResponse.getCartId();
        Intrinsics.checkNotNull(cartId);
        Integer itemCount = cartInfoResponse.getItemCount();
        Intrinsics.checkNotNull(itemCount);
        int intValue = itemCount.intValue();
        Float totalPrice = cartInfoResponse.getTotalPrice();
        Intrinsics.checkNotNull(totalPrice);
        float floatValue = totalPrice.floatValue();
        String globalVendorId = cartInfoResponse.getGlobalVendorId();
        Intrinsics.checkNotNull(globalVendorId);
        Restaurant restaurant = cartInfoResponse.getRestaurant();
        Intrinsics.checkNotNull(restaurant);
        return new CartInfo(cartId, intValue, floatValue, globalVendorId, restaurant);
    }
}
