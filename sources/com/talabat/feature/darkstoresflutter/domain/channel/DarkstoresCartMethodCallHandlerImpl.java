package com.talabat.feature.darkstoresflutter.domain.channel;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandler;
import com.talabat.feature.darkstoresflutter.domain.usecase.AddItemToCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.ClearCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.RefreshCartUseCase;
import com.talabat.feature.darkstoresflutter.domain.usecase.RemoveItemFromCartUseCase;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mm.b;
import mm.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010\t\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u000f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler;", "addItemToCart", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/AddItemToCartUseCase;", "removeFromCart", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/RemoveItemFromCartUseCase;", "clearCart", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/ClearCartUseCase;", "refreshCart", "Lcom/talabat/feature/darkstoresflutter/domain/usecase/RefreshCartUseCase;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "(Lcom/talabat/feature/darkstoresflutter/domain/usecase/AddItemToCartUseCase;Lcom/talabat/feature/darkstoresflutter/domain/usecase/RemoveItemFromCartUseCase;Lcom/talabat/feature/darkstoresflutter/domain/usecase/ClearCartUseCase;Lcom/talabat/feature/darkstoresflutter/domain/usecase/RefreshCartUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain$annotations", "()V", "getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain", "()Lio/reactivex/disposables/CompositeDisposable;", "methodHandlerCallback", "Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler$MethodHandlerCallback;", "getMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain$annotations", "getMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain", "()Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler$MethodHandlerCallback;", "setMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain", "(Lcom/talabat/feature/darkstoresflutter/domain/channel/DarkstoresCartMethodCallHandler$MethodHandlerCallback;)V", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodCall", "performAction", "action", "Lio/reactivex/Completable;", "removeItemFromCart", "setUpWithEngine", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "terminate", "com_talabat_feature_darkstores-flutter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCartMethodCallHandlerImpl implements MethodChannel.MethodCallHandler, DarkstoresCartMethodCallHandler {
    @NotNull
    private final AddItemToCartUseCase addItemToCart;
    @NotNull
    private final ClearCartUseCase clearCart;
    @NotNull
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public DarkstoresCartMethodCallHandler.MethodHandlerCallback methodHandlerCallback;
    @NotNull
    private final RefreshCartUseCase refreshCart;
    @NotNull
    private final RemoveItemFromCartUseCase removeFromCart;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;

    @Inject
    public DarkstoresCartMethodCallHandlerImpl(@NotNull AddItemToCartUseCase addItemToCartUseCase, @NotNull RemoveItemFromCartUseCase removeItemFromCartUseCase, @NotNull ClearCartUseCase clearCartUseCase, @NotNull RefreshCartUseCase refreshCartUseCase, @NotNull RxSchedulersFactory rxSchedulersFactory2) {
        Intrinsics.checkNotNullParameter(addItemToCartUseCase, "addItemToCart");
        Intrinsics.checkNotNullParameter(removeItemFromCartUseCase, "removeFromCart");
        Intrinsics.checkNotNullParameter(clearCartUseCase, "clearCart");
        Intrinsics.checkNotNullParameter(refreshCartUseCase, "refreshCart");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        this.addItemToCart = addItemToCartUseCase;
        this.removeFromCart = removeItemFromCartUseCase;
        this.clearCart = clearCartUseCase;
        this.refreshCart = refreshCartUseCase;
        this.rxSchedulersFactory = rxSchedulersFactory2;
    }

    private final void addItemToCart(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        Map map = (Map) methodCall.argument("item");
        Completable completable = null;
        if (!(map == null || (str = (String) methodCall.argument("vendorId")) == null)) {
            AddItemToCartUseCase addItemToCartUseCase = this.addItemToCart;
            Intrinsics.checkNotNullExpressionValue(str, "vendorId");
            completable = addItemToCartUseCase.invoke(map, str);
        }
        performAction(completable, result);
    }

    private final void clearCart(MethodChannel.Result result) {
        performAction(this.clearCart.invoke(), result);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain$annotations() {
    }

    private final void performAction(Completable completable, MethodChannel.Result result) {
        Completable subscribeOn;
        Completable observeOn;
        Disposable subscribe;
        if (completable == null || (subscribeOn = completable.subscribeOn(this.rxSchedulersFactory.io())) == null || (observeOn = subscribeOn.observeOn(this.rxSchedulersFactory.main())) == null || (subscribe = observeOn.subscribe(new b(result), new c(result))) == null) {
            result.success(Boolean.FALSE);
        } else {
            this.compositeDisposable.add(subscribe);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: performAction$lambda-3  reason: not valid java name */
    public static final void m10206performAction$lambda3(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: performAction$lambda-4  reason: not valid java name */
    public static final void m10207performAction$lambda4(MethodChannel.Result result, Throwable th2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.FALSE);
    }

    private final void refreshCart(MethodChannel.Result result) {
        performAction(this.refreshCart.invoke(), result);
    }

    private final void removeItemFromCart(MethodCall methodCall, MethodChannel.Result result) {
        Completable completable;
        String str = (String) methodCall.argument("itemId");
        if (str != null) {
            completable = this.removeFromCart.invoke(str);
        } else {
            completable = null;
        }
        performAction(completable, result);
    }

    @NotNull
    public final CompositeDisposable getCompositeDisposable$com_talabat_feature_darkstores_flutter_domain_domain() {
        return this.compositeDisposable;
    }

    @NotNull
    public final DarkstoresCartMethodCallHandler.MethodHandlerCallback getMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain() {
        DarkstoresCartMethodCallHandler.MethodHandlerCallback methodHandlerCallback2 = this.methodHandlerCallback;
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
            switch (str.hashCode()) {
                case -1387815781:
                    if (str.equals("refreshCart")) {
                        refreshCart(result);
                        return;
                    }
                    break;
                case -1271417075:
                    if (str.equals("clearCart")) {
                        clearCart(result);
                        return;
                    }
                    break;
                case 2016339137:
                    if (str.equals("removeItemFromCart")) {
                        removeItemFromCart(methodCall, result);
                        return;
                    }
                    break;
                case 2042926255:
                    if (str.equals("addItemToCart")) {
                        addItemToCart(methodCall, result);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    public final void setMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain(@NotNull DarkstoresCartMethodCallHandler.MethodHandlerCallback methodHandlerCallback2) {
        Intrinsics.checkNotNullParameter(methodHandlerCallback2, "<set-?>");
        this.methodHandlerCallback = methodHandlerCallback2;
    }

    public void setUpWithEngine(@NotNull FlutterEngine flutterEngine, @NotNull DarkstoresCartMethodCallHandler.MethodHandlerCallback methodHandlerCallback2) {
        Intrinsics.checkNotNullParameter(flutterEngine, "engine");
        Intrinsics.checkNotNullParameter(methodHandlerCallback2, "methodHandlerCallback");
        new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.DARKSTORES_CART_CHANNEL).setMethodCallHandler(this);
        setMethodHandlerCallback$com_talabat_feature_darkstores_flutter_domain_domain(methodHandlerCallback2);
    }

    public void terminate() {
        this.compositeDisposable.clear();
    }
}
