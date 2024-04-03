package com.talabat.feature.activecarts.domain.channel;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.model.BasketType;
import com.talabat.feature.activecarts.domain.usecase.GetCartListUseCase;
import com.talabat.feature.activecarts.domain.usecase.GetQCommerceCartListUseCase;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import datamodels.Restaurant;
import fl.a;
import fl.b;
import fl.c;
import fl.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J&\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010'\u001a\u00020\u001cH\u0016R*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandlerImpl;", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getBasketList", "Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCase;", "getQCommerceCartList", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCase;Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "basketTypes", "", "Lcom/talabat/feature/activecarts/domain/model/BasketType;", "getBasketTypes$com_talabat_feature_active_carts_domain_domain$annotations", "()V", "getBasketTypes$com_talabat_feature_active_carts_domain_domain", "()Ljava/util/Set;", "setBasketTypes$com_talabat_feature_active_carts_domain_domain", "(Ljava/util/Set;)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "methodHandlerCallback", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;", "getMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain$annotations", "getMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain", "()Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;", "setMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain", "(Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;)V", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "navigateToFoodBasket", "navigateToQcommerceBasket", "onMethodCall", "setUp", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "terminate", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveCartsMethodCallHandlerImpl implements ActiveCartsMethodCallHandler, MethodChannel.MethodCallHandler {
    public Set<? extends BasketType> basketTypes;
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    private final GetCartListUseCase getBasketList;
    @NotNull
    private final GetQCommerceCartListUseCase getQCommerceCartList;
    public ActiveCartsMethodCallHandler.MethodHandlerCallback methodHandlerCallback;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public ActiveCartsMethodCallHandlerImpl(@NotNull GetCartListUseCase getCartListUseCase, @NotNull GetQCommerceCartListUseCase getQCommerceCartListUseCase, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(getCartListUseCase, "getBasketList");
        Intrinsics.checkNotNullParameter(getQCommerceCartListUseCase, "getQCommerceCartList");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.getBasketList = getCartListUseCase;
        this.getQCommerceCartList = getQCommerceCartListUseCase;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    private final void getBasketList(MethodCall methodCall, MethodChannel.Result result) {
        Boolean bool = (Boolean) methodCall.argument("forceRequest");
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        Disposable subscribe = this.getBasketList.invoke(getBasketTypes$com_talabat_feature_active_carts_domain_domain(), bool.booleanValue()).subscribeOn(this.rxSchedulersFactory.io()).observeOn(this.rxSchedulersFactory.main()).subscribe(new a(result), new b(result));
        Intrinsics.checkNotNullExpressionValue(subscribe, "getBasketList(basketType…s, result::dispatchError)");
        DisposableKt.addTo(subscribe, this.disposable);
    }

    @VisibleForTesting
    public static /* synthetic */ void getBasketTypes$com_talabat_feature_active_carts_domain_domain$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain$annotations() {
    }

    private final void navigateToFoodBasket(MethodChannel.Result result) {
        getMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain().navigateToFoodBasket();
        result.success(Unit.INSTANCE);
    }

    private final void navigateToQcommerceBasket(MethodCall methodCall, MethodChannel.Result result) {
        Disposable subscribe = this.getQCommerceCartList.invoke().subscribeOn(this.rxSchedulersFactory.io()).map(new c(methodCall)).toSingle().observeOn(this.rxSchedulersFactory.main()).subscribe(new d(this, result), new b(result));
        Intrinsics.checkNotNullExpressionValue(subscribe, "getQCommerceCartList()\n …spatchError\n            )");
        DisposableKt.addTo(subscribe, this.disposable);
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToQcommerceBasket$lambda-1  reason: not valid java name */
    public static final Restaurant m10121navigateToQcommerceBasket$lambda1(MethodCall methodCall, List list) {
        Object obj;
        ActiveCartInfo.QcommerceCart qcommerceCart;
        boolean z11;
        Intrinsics.checkNotNullParameter(methodCall, "$call");
        Intrinsics.checkNotNullParameter(list, "cartList");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ActiveCartInfo activeCartInfo = (ActiveCartInfo) obj;
            if (!(activeCartInfo instanceof ActiveCartInfo.QcommerceCart) || !Intrinsics.areEqual((Object) ((ActiveCartInfo.QcommerceCart) activeCartInfo).getCartId(), methodCall.argument(FoodCartFlutterDataSourceImpl.cartIdKey))) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        if (obj instanceof ActiveCartInfo.QcommerceCart) {
            qcommerceCart = (ActiveCartInfo.QcommerceCart) obj;
        } else {
            qcommerceCart = null;
        }
        if (qcommerceCart != null) {
            return qcommerceCart.getRestaurant();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToQcommerceBasket$lambda-2  reason: not valid java name */
    public static final void m10122navigateToQcommerceBasket$lambda2(ActiveCartsMethodCallHandlerImpl activeCartsMethodCallHandlerImpl, MethodChannel.Result result, Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(activeCartsMethodCallHandlerImpl, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        ActiveCartsMethodCallHandler.MethodHandlerCallback methodHandlerCallback$com_talabat_feature_active_carts_domain_domain = activeCartsMethodCallHandlerImpl.getMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain();
        Intrinsics.checkNotNullExpressionValue(restaurant, "restaurant");
        methodHandlerCallback$com_talabat_feature_active_carts_domain_domain.navigateToQcommerceBasket(restaurant);
        result.success(Unit.INSTANCE);
    }

    @NotNull
    public final Set<BasketType> getBasketTypes$com_talabat_feature_active_carts_domain_domain() {
        Set<? extends BasketType> set = this.basketTypes;
        if (set != null) {
            return set;
        }
        Intrinsics.throwUninitializedPropertyAccessException("basketTypes");
        return null;
    }

    @NotNull
    public final ActiveCartsMethodCallHandler.MethodHandlerCallback getMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain() {
        ActiveCartsMethodCallHandler.MethodHandlerCallback methodHandlerCallback2 = this.methodHandlerCallback;
        if (methodHandlerCallback2 != null) {
            return methodHandlerCallback2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("methodHandlerCallback");
        return null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1141180240) {
                if (hashCode != 243212774) {
                    if (hashCode == 428753786 && str.equals("getBasketList")) {
                        getBasketList(methodCall, result);
                        return;
                    }
                } else if (str.equals("navigateToQCommerceBasket")) {
                    navigateToQcommerceBasket(methodCall, result);
                    return;
                }
            } else if (str.equals("navigateToFoodBasket")) {
                navigateToFoodBasket(result);
                return;
            }
        }
        result.notImplemented();
    }

    public final void setBasketTypes$com_talabat_feature_active_carts_domain_domain(@NotNull Set<? extends BasketType> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.basketTypes = set;
    }

    public final void setMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain(@NotNull ActiveCartsMethodCallHandler.MethodHandlerCallback methodHandlerCallback2) {
        Intrinsics.checkNotNullParameter(methodHandlerCallback2, "<set-?>");
        this.methodHandlerCallback = methodHandlerCallback2;
    }

    public void setUp(@NotNull FlutterEngine flutterEngine, @NotNull ActiveCartsMethodCallHandler.MethodHandlerCallback methodHandlerCallback2, @NotNull Set<? extends BasketType> set) {
        Intrinsics.checkNotNullParameter(flutterEngine, "engine");
        Intrinsics.checkNotNullParameter(methodHandlerCallback2, "methodHandlerCallback");
        Intrinsics.checkNotNullParameter(set, "basketTypes");
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/basket-listing").setMethodCallHandler(this);
        setMethodHandlerCallback$com_talabat_feature_active_carts_domain_domain(methodHandlerCallback2);
        setBasketTypes$com_talabat_feature_active_carts_domain_domain(set);
    }

    public void terminate() {
        this.disposable.dispose();
    }
}
