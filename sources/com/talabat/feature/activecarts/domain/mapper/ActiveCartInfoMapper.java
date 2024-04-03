package com.talabat.feature.activecarts.domain.mapper;

import com.talabat.feature.activecarts.domain.model.BasketType;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.mapper.ModelMapper;
import com.visa.checkout.PurchaseInfo;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J@\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/activecarts/domain/mapper/ActiveCartInfoMapper;", "Lcom/talabat/mapper/ModelMapper;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "", "", "", "()V", "apply", "source", "mapActiveCart", "", "restaurant", "Ldatamodels/Restaurant;", "itemCount", "", "subtotal", "", "basketType", "Lcom/talabat/feature/activecarts/domain/model/BasketType;", "cartId", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveCartInfoMapper implements ModelMapper<ActiveCartInfo, Map<String, ? extends Object>> {
    public static /* synthetic */ Map a(ActiveCartInfoMapper activeCartInfoMapper, Restaurant restaurant, int i11, double d11, BasketType basketType, String str, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            str = null;
        }
        return activeCartInfoMapper.mapActiveCart(restaurant, i11, d11, basketType, str);
    }

    private final Map<String, Object> mapActiveCart(Restaurant restaurant, int i11, double d11, BasketType basketType, String str) {
        Map<String, Object> mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("vendorId", Integer.valueOf(restaurant.f13872id)), TuplesKt.to("vendorName", restaurant.f13873name), TuplesKt.to("itemCount", Integer.valueOf(i11)), TuplesKt.to(PurchaseInfo.TOTAL, Double.valueOf(d11)), TuplesKt.to("vendorLogoImageUrl", restaurant.getLogo()), TuplesKt.to("shopType", restaurant.getShopType()), TuplesKt.to("basketType", basketType.getValue()));
        if (str != null) {
            mutableMapOf.put(FoodCartFlutterDataSourceImpl.cartIdKey, str);
        }
        return mutableMapOf;
    }

    @Nullable
    public Map<String, Object> apply(@NotNull ActiveCartInfo activeCartInfo) {
        Intrinsics.checkNotNullParameter(activeCartInfo, "source");
        if (activeCartInfo instanceof ActiveCartInfo.FoodCart) {
            ActiveCartInfo.FoodCart foodCart = (ActiveCartInfo.FoodCart) activeCartInfo;
            return a(this, foodCart.getRestaurant(), foodCart.getItemCount(), foodCart.getSubtotal(), BasketType.FOOD, (String) null, 16, (Object) null);
        } else if (!(activeCartInfo instanceof ActiveCartInfo.QcommerceCart)) {
            return null;
        } else {
            ActiveCartInfo.QcommerceCart qcommerceCart = (ActiveCartInfo.QcommerceCart) activeCartInfo;
            return mapActiveCart(qcommerceCart.getRestaurant(), qcommerceCart.getItemCount(), qcommerceCart.getSubtotal(), BasketType.QCOMMERCE, qcommerceCart.getCartId());
        }
    }
}
