package com.talabat.feature.darkstorescart.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorescart.data.local.CartDao;
import com.talabat.feature.darkstorescart.data.local.CartLocalDataSource;
import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import dagger.Reusable;
import gm.a;
import gm.b;
import gm.c;
import gm.d;
import gm.e;
import gm.f;
import gm.g;
import gm.h;
import gm.i;
import gm.j;
import gm.k;
import gm.l;
import gm.m;
import gm.n;
import gm.o;
import gm.p;
import gm.q;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u000bJ\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020\u000bJ\b\u0010)\u001a\u00020 H\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010+\u001a\u00020 H\u0002J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0.0-J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0.0$J\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0.0-J\u0006\u00101\u001a\u00020 J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150$J\u0018\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0-J\f\u00104\u001a\b\u0012\u0004\u0012\u00020 0$J\f\u00105\u001a\b\u0012\u0004\u0012\u00020706J\u0006\u00108\u001a\u000209J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130-J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010+\u001a\u00020 H\u0002J\u0014\u0010<\u001a\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e0.J\u000e\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020 J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000b0-J\u0006\u0010A\u001a\u00020\u000bJ\u000e\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020 J\u000e\u0010D\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020 J\u0016\u0010E\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010F\u001a\u000207J\u0006\u0010G\u001a\u00020\u000bJ\u0006\u0010H\u001a\u00020\u000bJ\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e0.2\u0006\u0010J\u001a\u00020\u0010J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001e0.2\u0006\u0010J\u001a\u00020\u0010J\u000e\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u000209J\u0014\u0010N\u001a\u00020%*\u00020\u00152\u0006\u0010+\u001a\u00020 H\u0002J\f\u0010O\u001a\u00020\u0015*\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R4\u0010\r\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011 \f*\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00130\u00130\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006P"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "", "cartDao", "Lcom/talabat/feature/darkstorescart/data/local/CartDao;", "cartLocalDataSource", "Lcom/talabat/feature/darkstorescart/data/local/CartLocalDataSource;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/feature/darkstorescart/data/local/CartDao;Lcom/talabat/feature/darkstorescart/data/local/CartLocalDataSource;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "cartQuantityChangedSubject", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "cartResponseSubject", "Lio/reactivex/subjects/BehaviorSubject;", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "", "navigateToCheckoutSubject", "Lcom/talabat/feature/darkstorescart/data/model/CheckoutParams;", "value", "Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", "selectedVendor", "getSelectedVendor", "()Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", "setSelectedVendor", "(Lcom/talabat/feature/darkstorescart/data/model/CartVendor;)V", "addProductToCart", "Lio/reactivex/Completable;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "globalVendorId", "", "clearCart", "clearCartId", "clearCartIfDifferentVendor", "Lio/reactivex/Maybe;", "Lcom/talabat/feature/darkstorescart/data/model/CartInfo;", "cartInfo", "vendorId", "clearCartInfo", "createAndCacheCartId", "createCartInfo", "cartId", "getAllInStockProducts", "Lio/reactivex/Observable;", "", "getAllInStockProductsAsMaybe", "getAllOutOfStockProducts", "getCartId", "getCartOwner", "getCartResponse", "getCartVendorJson", "getInStockProductCount", "Lio/reactivex/Single;", "", "getLastModifiedTime", "", "getNavigateToCheckoutActions", "getOrCreateCartInfo", "insertCartProducts", "products", "navigateToCheckout", "specialRequest", "observeCartQuantityUpdatedChanges", "refreshCart", "removeProductFromCart", "productId", "saveCartId", "setProductCount", "count", "updateCartSyncFailure", "updateCartSyncStarted", "updateCartSyncSuccess", "cartResponse", "updateCartSyncSuccessV2", "updateLastModifiedTime", "time", "toCartInfo", "toVendor", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class DarkstoresCartRepository {
    @NotNull
    private final CartDao cartDao;
    @NotNull
    private final CartLocalDataSource cartLocalDataSource;
    @NotNull
    private final PublishSubject<Unit> cartQuantityChangedSubject;
    @NotNull
    private final BehaviorSubject<Pair<CartResponse, Boolean>> cartResponseSubject;
    @NotNull
    private final PublishSubject<CheckoutParams> navigateToCheckoutSubject;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public DarkstoresCartRepository(@NotNull CartDao cartDao2, @NotNull CartLocalDataSource cartLocalDataSource2, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(cartDao2, "cartDao");
        Intrinsics.checkNotNullParameter(cartLocalDataSource2, "cartLocalDataSource");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.cartDao = cartDao2;
        this.cartLocalDataSource = cartLocalDataSource2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Unit>()");
        this.cartQuantityChangedSubject = create;
        BehaviorSubject<Pair<CartResponse, Boolean>> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Pair<CartResponse, Boolean>>()");
        this.cartResponseSubject = create2;
        PublishSubject<CheckoutParams> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<CheckoutParams>()");
        this.navigateToCheckoutSubject = create3;
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-4  reason: not valid java name */
    public static final String m10166addProductToCart$lambda4(DarkstoresCartRepository darkstoresCartRepository) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        return darkstoresCartRepository.getCartId();
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-5  reason: not valid java name */
    public static final MaybeSource m10167addProductToCart$lambda5(DarkstoresCartRepository darkstoresCartRepository, String str) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        return darkstoresCartRepository.getOrCreateCartInfo(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-6  reason: not valid java name */
    public static final MaybeSource m10168addProductToCart$lambda6(DarkstoresCartRepository darkstoresCartRepository, String str, CartInfo cartInfo) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$globalVendorId");
        Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
        return darkstoresCartRepository.clearCartIfDifferentVendor(cartInfo, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-7  reason: not valid java name */
    public static final Unit m10169addProductToCart$lambda7(DarkstoresCartRepository darkstoresCartRepository, Product product, CartInfo cartInfo) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
        darkstoresCartRepository.cartDao.addProduct(product, cartInfo);
        darkstoresCartRepository.cartDao.updateProductToolTipAlertText(product.getId(), (String) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-8  reason: not valid java name */
    public static final void m10170addProductToCart$lambda8(DarkstoresCartRepository darkstoresCartRepository) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        darkstoresCartRepository.cartQuantityChangedSubject.onNext(Unit.INSTANCE);
    }

    private final Maybe<CartInfo> clearCartIfDifferentVendor(CartInfo cartInfo, String str) {
        if (!Intrinsics.areEqual((Object) cartInfo.getGlobalVendorId(), (Object) str)) {
            Maybe<CartInfo> flatMap = Maybe.fromCallable(new a(this, cartInfo)).flatMap(new i(this));
            Intrinsics.checkNotNullExpressionValue(flatMap, "{\n            Maybe\n    …acheCartId()) }\n        }");
            return flatMap;
        }
        Maybe<CartInfo> just = Maybe.just(cartInfo);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Maybe.just(cartInfo)\n        }");
        return just;
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCartIfDifferentVendor$lambda-16  reason: not valid java name */
    public static final Unit m10171clearCartIfDifferentVendor$lambda16(DarkstoresCartRepository darkstoresCartRepository, CartInfo cartInfo) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(cartInfo, "$cartInfo");
        darkstoresCartRepository.cartLocalDataSource.clearCartId();
        darkstoresCartRepository.cartDao.clearCart(cartInfo.getCartId());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCartIfDifferentVendor$lambda-17  reason: not valid java name */
    public static final MaybeSource m10172clearCartIfDifferentVendor$lambda17(DarkstoresCartRepository darkstoresCartRepository, Unit unit) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(unit, "it");
        return darkstoresCartRepository.createCartInfo(darkstoresCartRepository.createAndCacheCartId());
    }

    private final String createAndCacheCartId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()\n            .toString()");
        this.cartLocalDataSource.saveCartId(uuid);
        return uuid;
    }

    private final Maybe<CartInfo> createCartInfo(String str) {
        Maybe<CartInfo> map = Maybe.fromCallable(new j(new DarkstoresCartRepository$createCartInfo$1(this.cartLocalDataSource))).map(new k(this, str));
        Intrinsics.checkNotNullExpressionValue(map, "fromCallable(cartLocalDa…rtCartInfo)\n            }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: createCartInfo$lambda-18  reason: not valid java name */
    public static final CartVendor m10173createCartInfo$lambda18(KMutableProperty0 kMutableProperty0) {
        Intrinsics.checkNotNullParameter(kMutableProperty0, "$tmp0");
        return (CartVendor) kMutableProperty0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: createCartInfo$lambda-20  reason: not valid java name */
    public static final CartInfo m10174createCartInfo$lambda20(DarkstoresCartRepository darkstoresCartRepository, String str, CartVendor cartVendor) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$cartId");
        Intrinsics.checkNotNullParameter(cartVendor, "selectedVendor");
        CartInfo cartInfo = darkstoresCartRepository.toCartInfo(cartVendor, str);
        darkstoresCartRepository.cartDao.insertCartInfo(cartInfo);
        return cartInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartOwner$lambda-13  reason: not valid java name */
    public static final String m10175getCartOwner$lambda13(DarkstoresCartRepository darkstoresCartRepository) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        return darkstoresCartRepository.cartLocalDataSource.getCartId();
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartOwner$lambda-14  reason: not valid java name */
    public static final MaybeSource m10176getCartOwner$lambda14(DarkstoresCartRepository darkstoresCartRepository, String str) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        return darkstoresCartRepository.cartDao.getCartInfo(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartOwner$lambda-15  reason: not valid java name */
    public static final CartVendor m10177getCartOwner$lambda15(DarkstoresCartRepository darkstoresCartRepository, CartInfo cartInfo) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
        return darkstoresCartRepository.toVendor(cartInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartVendorJson$lambda-0  reason: not valid java name */
    public static final String m10178getCartVendorJson$lambda0(CartInfo cartInfo) {
        Intrinsics.checkNotNullParameter(cartInfo, CustomerInfoLocalDataSourceImpl.KEY);
        return cartInfo.getRestaurantJson();
    }

    private final Maybe<CartInfo> getOrCreateCartInfo(String str) {
        Maybe<CartInfo> switchIfEmpty = this.cartDao.getCartInfo(str).switchIfEmpty(createCartInfo(str));
        Intrinsics.checkNotNullExpressionValue(switchIfEmpty, "cartDao.getCartInfo(cart…y(createCartInfo(cartId))");
        return switchIfEmpty;
    }

    /* access modifiers changed from: private */
    /* renamed from: removeProductFromCart$lambda-10  reason: not valid java name */
    public static final MaybeSource m10179removeProductFromCart$lambda10(DarkstoresCartRepository darkstoresCartRepository, String str) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        return darkstoresCartRepository.getOrCreateCartInfo(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: removeProductFromCart$lambda-11  reason: not valid java name */
    public static final Unit m10180removeProductFromCart$lambda11(DarkstoresCartRepository darkstoresCartRepository, String str, CartInfo cartInfo) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productId");
        Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
        darkstoresCartRepository.cartDao.removeProduct(str, cartInfo);
        darkstoresCartRepository.cartDao.updateProductToolTipAlertText(str, (String) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: removeProductFromCart$lambda-12  reason: not valid java name */
    public static final void m10181removeProductFromCart$lambda12(DarkstoresCartRepository darkstoresCartRepository) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        darkstoresCartRepository.cartQuantityChangedSubject.onNext(Unit.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: removeProductFromCart$lambda-9  reason: not valid java name */
    public static final String m10182removeProductFromCart$lambda9(DarkstoresCartRepository darkstoresCartRepository) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "this$0");
        return darkstoresCartRepository.getCartId();
    }

    private final CartInfo toCartInfo(CartVendor cartVendor, String str) {
        return new CartInfo(str, cartVendor.getGlobalId(), cartVendor.getName(), cartVendor.getBranchId(), cartVendor.getRestaurantJson());
    }

    private final CartVendor toVendor(CartInfo cartInfo) {
        return new CartVendor(cartInfo.getGlobalVendorId(), cartInfo.getBranchId(), cartInfo.getVendorName(), cartInfo.getRestaurantJson());
    }

    @NotNull
    public final Completable addProductToCart(@NotNull Product product, @NotNull String str) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(str, "globalVendorId");
        Completable doOnComplete = Single.fromCallable(new d(this)).flatMapMaybe(new e(this)).flatMap(new f(this, str)).map(new g(this, product)).ignoreElement().doOnComplete(new h(this));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "fromCallable { getCartId…gedSubject.onNext(Unit) }");
        return doOnComplete;
    }

    public final void clearCart() {
        this.cartDao.clearCart(getCartId());
        clearCartId();
    }

    public final void clearCartId() {
        this.cartLocalDataSource.clearCartId();
    }

    public final void clearCartInfo() {
        this.cartDao.clearCartInfo();
    }

    @NotNull
    public final Observable<List<Product>> getAllInStockProducts() {
        Observable<List<Product>> subscribeOn = this.cartDao.selectAllObservable(false).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartDao.selectAllObserva…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public final Maybe<List<Product>> getAllInStockProductsAsMaybe() {
        Maybe<List<Product>> subscribeOn = CartDao.DefaultImpls.selectAllMaybe$default(this.cartDao, false, 1, (Object) null).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartDao.selectAllMaybe()…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public final Observable<List<Product>> getAllOutOfStockProducts() {
        Observable<List<Product>> subscribeOn = this.cartDao.selectAllObservable(true).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartDao.selectAllObserva…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public final String getCartId() {
        String cartId = this.cartLocalDataSource.getCartId();
        return cartId == null ? createAndCacheCartId() : cartId;
    }

    @NotNull
    public final Maybe<CartVendor> getCartOwner() {
        Maybe<CartVendor> subscribeOn = Maybe.fromCallable(new q(this)).flatMap(new b(this)).map(new c(this)).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "fromCallable { cartLocal…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public final Observable<Pair<CartResponse, Boolean>> getCartResponse() {
        Observable<Pair<CartResponse, Boolean>> subscribeOn = this.cartResponseSubject.hide().subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartResponseSubject.hide…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public final Maybe<String> getCartVendorJson() {
        Maybe<R> subscribeOn = this.cartDao.getCartInfo(getCartId()).map(new l()).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartDao.getCartInfo(getC…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @NotNull
    public final Single<Integer> getInStockProductCount() {
        Single<Integer> subscribeOn = CartDao.DefaultImpls.selectTotalProductsCountAsSingle$default(this.cartDao, false, 1, (Object) null).subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartDao.selectTotalProdu…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    public final long getLastModifiedTime() {
        return this.cartLocalDataSource.getCartLAstModifiedTime();
    }

    @NotNull
    public final Observable<CheckoutParams> getNavigateToCheckoutActions() {
        Observable<CheckoutParams> subscribeOn = this.navigateToCheckoutSubject.hide().subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "navigateToCheckoutSubjec…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    @Nullable
    public final CartVendor getSelectedVendor() {
        return this.cartLocalDataSource.getSelectedVendor();
    }

    public final void insertCartProducts(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "products");
        this.cartDao.insertProducts(list);
    }

    public final void navigateToCheckout(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        this.navigateToCheckoutSubject.onNext(new CheckoutParams(str));
    }

    @NotNull
    public final Observable<Unit> observeCartQuantityUpdatedChanges() {
        Observable<Unit> subscribeOn = this.cartQuantityChangedSubject.hide().subscribeOn(this.rxSchedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartQuantityChangedSubje…rxSchedulersFactory.io())");
        return subscribeOn;
    }

    public final void refreshCart() {
        this.cartQuantityChangedSubject.onNext(Unit.INSTANCE);
    }

    @NotNull
    public final Completable removeProductFromCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Completable doOnComplete = Single.fromCallable(new m(this)).flatMapMaybe(new n(this)).map(new o(this, str)).ignoreElement().doOnComplete(new p(this));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "fromCallable { getCartId…gedSubject.onNext(Unit) }");
        return doOnComplete;
    }

    public final void saveCartId(@NotNull String str) {
        CartInfo cartInfo;
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        this.cartLocalDataSource.saveCartId(str);
        CartVendor selectedVendor = this.cartLocalDataSource.getSelectedVendor();
        if (selectedVendor != null && (cartInfo = toCartInfo(selectedVendor, str)) != null) {
            this.cartDao.insertCartInfo(cartInfo);
        }
    }

    public final void setProductCount(@NotNull Product product, int i11) {
        CartInfo cartInfo;
        Intrinsics.checkNotNullParameter(product, "product");
        CartVendor selectedVendor = getSelectedVendor();
        if (selectedVendor != null && (cartInfo = toCartInfo(selectedVendor, getCartId())) != null) {
            this.cartDao.setProductCount(product, i11, cartInfo);
        }
    }

    public final void setSelectedVendor(@Nullable CartVendor cartVendor) {
        this.cartLocalDataSource.setSelectedVendor(cartVendor);
    }

    public final void updateCartSyncFailure() {
        CartResponse cartResponse;
        this.cartDao.updateAllSyncFailure();
        Pair value = this.cartResponseSubject.getValue();
        if (value != null && (cartResponse = (CartResponse) value.getFirst()) != null) {
            this.cartResponseSubject.onNext(TuplesKt.to(cartResponse, Boolean.FALSE));
        }
    }

    public final void updateCartSyncStarted() {
        CartResponse cartResponse;
        Pair value = this.cartResponseSubject.getValue();
        if (value != null && (cartResponse = (CartResponse) value.getFirst()) != null) {
            this.cartResponseSubject.onNext(TuplesKt.to(cartResponse, Boolean.TRUE));
        }
    }

    @NotNull
    public final List<Product> updateCartSyncSuccess(@NotNull CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "cartResponse");
        List<Product> updateAllSyncSuccess = this.cartDao.updateAllSyncSuccess(cartResponse.getItems());
        this.cartResponseSubject.onNext(TuplesKt.to(cartResponse, Boolean.FALSE));
        return updateAllSyncSuccess;
    }

    @NotNull
    public final List<Product> updateCartSyncSuccessV2(@NotNull CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "cartResponse");
        List<Product> updateAllSyncSuccessV2 = this.cartDao.updateAllSyncSuccessV2(cartResponse.getItems());
        this.cartResponseSubject.onNext(TuplesKt.to(cartResponse, Boolean.FALSE));
        return updateAllSyncSuccessV2;
    }

    public final void updateLastModifiedTime(long j11) {
        this.cartLocalDataSource.saveCartLastModifiedTime(j11);
    }
}
