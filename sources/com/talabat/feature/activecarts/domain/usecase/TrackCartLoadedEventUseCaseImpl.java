package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.activecarts.domain.tracking.CartLoadedEvent;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0017\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/TrackCartLoadedEventUseCaseImpl;", "Lcom/talabat/feature/activecarts/domain/usecase/TrackCartLoadedEventUseCase;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "getCartId", "", "activeCartInfo", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "getChainId", "", "(Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;)Ljava/lang/Integer;", "getShopType", "invoke", "", "carts", "", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackCartLoadedEventUseCaseImpl implements TrackCartLoadedEventUseCase {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public TrackCartLoadedEventUseCaseImpl(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    private final String getCartId(ActiveCartInfo activeCartInfo) {
        if (activeCartInfo instanceof ActiveCartInfo.QcommerceCart) {
            return ((ActiveCartInfo.QcommerceCart) activeCartInfo).getCartId();
        }
        return null;
    }

    private final Integer getChainId(ActiveCartInfo activeCartInfo) {
        Restaurant restaurant;
        if (activeCartInfo instanceof ActiveCartInfo.FoodCart) {
            restaurant = ((ActiveCartInfo.FoodCart) activeCartInfo).getRestaurant();
        } else if (activeCartInfo instanceof ActiveCartInfo.QcommerceCart) {
            restaurant = ((ActiveCartInfo.QcommerceCart) activeCartInfo).getRestaurant();
        } else {
            restaurant = null;
        }
        if (restaurant != null) {
            return Integer.valueOf(restaurant.f13872id);
        }
        return null;
    }

    private final String getShopType(ActiveCartInfo activeCartInfo) {
        Restaurant restaurant;
        if (activeCartInfo instanceof ActiveCartInfo.FoodCart) {
            restaurant = ((ActiveCartInfo.FoodCart) activeCartInfo).getRestaurant();
        } else if (activeCartInfo instanceof ActiveCartInfo.QcommerceCart) {
            restaurant = ((ActiveCartInfo.QcommerceCart) activeCartInfo).getRestaurant();
        } else {
            restaurant = null;
        }
        if (restaurant != null) {
            return restaurant.getShopType();
        }
        return null;
    }

    public void invoke(@NotNull List<? extends ActiveCartInfo> list) {
        List<? extends ActiveCartInfo> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "carts");
        if (!list2.isEmpty()) {
            TalabatTracker talabatTracker2 = this.talabatTracker;
            int size = list.size();
            Iterable<ActiveCartInfo> iterable = list2;
            ArrayList arrayList = new ArrayList();
            for (ActiveCartInfo chainId : iterable) {
                Integer chainId2 = getChainId(chainId);
                if (chainId2 != null) {
                    arrayList.add(chainId2);
                }
            }
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            for (ActiveCartInfo shopType : iterable) {
                String shopType2 = getShopType(shopType);
                if (shopType2 != null) {
                    arrayList2.add(shopType2);
                }
            }
            String joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            ArrayList arrayList3 = new ArrayList();
            for (ActiveCartInfo cartId : iterable) {
                String cartId2 = getCartId(cartId);
                if (cartId2 != null) {
                    arrayList3.add(cartId2);
                }
            }
            talabatTracker2.track(new CartLoadedEvent("Home Screen", "home", size, "home", joinToString$default, joinToString$default2, CollectionsKt___CollectionsKt.joinToString$default(arrayList3, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        }
    }
}
