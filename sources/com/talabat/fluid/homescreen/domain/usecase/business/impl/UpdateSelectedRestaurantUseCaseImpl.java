package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import com.facebook.internal.NativeProtocol;
import com.talabat.fluid.homescreen.domain.usecase.business.UpdateSelectedRestaurantUseCase;
import com.talabat.fluid.homescreen.presentation.mapper.BannerAdItemMapper;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001c\u0010\u000e\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0016R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/UpdateSelectedRestaurantUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/UpdateSelectedRestaurantUseCase;", "updateRestaurant", "Lkotlin/Function1;", "Ldatamodels/Restaurant;", "Lkotlin/ParameterName;", "name", "restaurant", "", "(Lkotlin/jvm/functions/Function1;)V", "getRestaurant", "params", "", "", "updateSelectedVendor", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateSelectedRestaurantUseCaseImpl implements UpdateSelectedRestaurantUseCase {
    @NotNull
    private final Function1<Restaurant, Unit> updateRestaurant;

    public UpdateSelectedRestaurantUseCaseImpl(@NotNull Function1<? super Restaurant, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "updateRestaurant");
        this.updateRestaurant = function1;
    }

    private final Restaurant getRestaurant(Map<String, String> map) {
        int i11;
        int i12;
        boolean z11;
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Restaurant restaurant = new Restaurant();
        String str = map.get("chainId");
        int i13 = -1;
        if (str == null || (intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) == null) {
            i11 = -1;
        } else {
            i11 = intOrNull3.intValue();
        }
        restaurant.f13872id = i11;
        String str2 = map.get("chainName");
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        restaurant.f13873name = str2;
        String str4 = map.get("shopId");
        if (!(str4 == null || (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str4)) == null)) {
            i13 = intOrNull2.intValue();
        }
        restaurant.branchId = i13;
        String str5 = map.get("shopName");
        if (str5 != null) {
            str3 = str5;
        }
        restaurant.branchName = str3;
        String str6 = map.get("verticalId");
        boolean z12 = false;
        if (str6 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str6)) == null) {
            i12 = 0;
        } else {
            i12 = intOrNull.intValue();
        }
        restaurant.shopType = i12;
        String str7 = map.get("isDarkStore");
        if (str7 != null) {
            z11 = Boolean.parseBoolean(str7);
        } else {
            z11 = false;
        }
        restaurant.isDarkStore = z11;
        String str8 = map.get(BannerAdItemMapper.KEY_IS_GRL_ENABLED);
        if (str8 != null) {
            z12 = Boolean.parseBoolean(str8);
        }
        restaurant.isGlrEnabled = z12;
        return restaurant;
    }

    public void updateSelectedVendor(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        this.updateRestaurant.invoke(getRestaurant(map));
    }
}
