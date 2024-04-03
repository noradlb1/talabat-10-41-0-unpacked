package com.talabat.feature.activecarts.data.repository;

import buisnessmodels.Cart;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import com.visa.checkout.PurchaseInfo;
import datamodels.Restaurant;
import el.a;
import el.b;
import el.c;
import el.d;
import el.e;
import el.f;
import el.g;
import el.h;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/activecarts/data/repository/ActiveCartInfoRepositoryImpl;", "Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "cart", "Lbuisnessmodels/Cart;", "darkstoresRepository", "Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "darkstoresCartListRepository", "Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "(Lbuisnessmodels/Cart;Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;)V", "getFoodCart", "Lio/reactivex/Maybe;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "getQCommerceCart", "getQCommerceCartList", "", "invalidateQCommerceCartListCache", "", "com_talabat_feature_active-carts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveCartInfoRepositoryImpl implements ActiveCartRepository {
    @NotNull
    private final Cart cart;
    @NotNull
    private final DarkstoresCartListRepository darkstoresCartListRepository;
    @NotNull
    private final DarkstoresRepository darkstoresRepository;

    @Inject
    public ActiveCartInfoRepositoryImpl(@NotNull Cart cart2, @NotNull DarkstoresRepository darkstoresRepository2, @NotNull DarkstoresCartListRepository darkstoresCartListRepository2) {
        Intrinsics.checkNotNullParameter(cart2, "cart");
        Intrinsics.checkNotNullParameter(darkstoresRepository2, "darkstoresRepository");
        Intrinsics.checkNotNullParameter(darkstoresCartListRepository2, "darkstoresCartListRepository");
        this.cart = cart2;
        this.darkstoresRepository = darkstoresRepository2;
        this.darkstoresCartListRepository = darkstoresCartListRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getFoodCart$lambda-0  reason: not valid java name */
    public static final Cart m10113getFoodCart$lambda0(ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl) {
        Intrinsics.checkNotNullParameter(activeCartInfoRepositoryImpl, "this$0");
        return activeCartInfoRepositoryImpl.cart;
    }

    /* access modifiers changed from: private */
    /* renamed from: getFoodCart$lambda-1  reason: not valid java name */
    public static final boolean m10114getFoodCart$lambda1(Cart cart2) {
        Intrinsics.checkNotNullParameter(cart2, "cart");
        if (!cart2.hasItems() || cart2.getRestaurant() == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: getFoodCart$lambda-2  reason: not valid java name */
    public static final ActiveCartInfo m10115getFoodCart$lambda2(Cart cart2) {
        Intrinsics.checkNotNullParameter(cart2, "cart");
        int cartCount = cart2.getCartCount();
        Restaurant restaurant = cart2.getRestaurant();
        Intrinsics.checkNotNullExpressionValue(restaurant, "cart.restaurant");
        return new ActiveCartInfo.FoodCart(cartCount, restaurant, (double) cart2.getCartSubTotal());
    }

    /* access modifiers changed from: private */
    /* renamed from: getQCommerceCart$lambda-3  reason: not valid java name */
    public static final boolean m10116getQCommerceCart$lambda3(ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl, Integer num) {
        Intrinsics.checkNotNullParameter(activeCartInfoRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(num, "itemCount");
        if (num.intValue() <= 0 || activeCartInfoRepositoryImpl.darkstoresRepository.isDarkstoresCartClearedFromCheckout()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: getQCommerceCart$lambda-4  reason: not valid java name */
    public static final boolean m10117getQCommerceCart$lambda4(Double d11) {
        Intrinsics.checkNotNullParameter(d11, PurchaseInfo.TOTAL);
        if (d11.doubleValue() > 0.0d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: getQCommerceCart$lambda-5  reason: not valid java name */
    public static final ActiveCartInfo m10118getQCommerceCart$lambda5(ActiveCartInfoRepositoryImpl activeCartInfoRepositoryImpl, Integer num, Restaurant restaurant, Double d11) {
        Intrinsics.checkNotNullParameter(activeCartInfoRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(num, "itemCount");
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        Intrinsics.checkNotNullParameter(d11, "subtotal");
        return new ActiveCartInfo.QcommerceCart(num.intValue(), restaurant, d11.doubleValue(), activeCartInfoRepositoryImpl.darkstoresRepository.getCartId());
    }

    /* access modifiers changed from: private */
    /* renamed from: getQCommerceCartList$lambda-6  reason: not valid java name */
    public static final boolean m10119getQCommerceCartList$lambda6(List list) {
        Intrinsics.checkNotNullParameter(list, "cartInfoList");
        return !list.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: getQCommerceCartList$lambda-8  reason: not valid java name */
    public static final List m10120getQCommerceCartList$lambda8(List list) {
        Intrinsics.checkNotNullParameter(list, "cartInfoList");
        Iterable<CartInfo> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (CartInfo cartInfo : iterable) {
            arrayList.add(new ActiveCartInfo.QcommerceCart(cartInfo.getItemCount(), cartInfo.getRestaurant(), (double) cartInfo.getTotalPrice(), cartInfo.getCartId()));
        }
        return arrayList;
    }

    @NotNull
    public Maybe<ActiveCartInfo> getFoodCart() {
        Maybe<ActiveCartInfo> map = Single.fromCallable(new c(this)).filter(new d()).map(new e());
        Intrinsics.checkNotNullExpressionValue(map, "fromCallable { cart }\n  …)\n            )\n        }");
        return map;
    }

    @NotNull
    public Maybe<ActiveCartInfo> getQCommerceCart() {
        Maybe<ActiveCartInfo> zip = Maybe.zip(this.darkstoresRepository.getCartItemCount().filter(new f(this)), this.darkstoresRepository.getCartVendor(), this.darkstoresRepository.getCartTotalValue().filter(new g()), new h(this));
        Intrinsics.checkNotNullExpressionValue(zip, "zip(\n        darkstoresR…tCartId()\n        )\n    }");
        return zip;
    }

    @NotNull
    public Maybe<List<ActiveCartInfo>> getQCommerceCartList() {
        Maybe<R> map = this.darkstoresCartListRepository.getCartInfoList().filter(new a()).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresCartListReposi…)\n            }\n        }");
        return map;
    }

    public void invalidateQCommerceCartListCache() {
        this.darkstoresCartListRepository.invalidateCartInfoListCache();
    }
}
