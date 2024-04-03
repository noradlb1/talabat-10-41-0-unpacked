package com.talabat.feature.activecarts.presentation.viewmodel;

import android.app.Activity;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.cart.CartScreen;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.model.BasketType;
import com.talabat.feature.darkstores.domain.model.DarkstoreNavigationType;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel;
import datamodels.Restaurant;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0017J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/activecarts/presentation/viewmodel/BasketListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;", "activity", "Landroid/app/Activity;", "activeCartsMethodCallHandler", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "darkstoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "(Landroid/app/Activity;Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;Lcom/talabat/core/navigation/domain/Navigator;)V", "navigateToFoodBasket", "", "navigateToQcommerceBasket", "restaurant", "Ldatamodels/Restaurant;", "onCleared", "setUpChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpFoodCartChannel", "com_talabat_feature_active-carts_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketListViewModel extends ViewModel implements ActiveCartsMethodCallHandler.MethodHandlerCallback {
    @NotNull
    private final ActiveCartsMethodCallHandler activeCartsMethodCallHandler;
    @NotNull
    private final Activity activity;
    @NotNull
    private final DarkstoresNavigator darkstoresNavigator;
    @NotNull
    private final Navigator navigator;

    @Inject
    public BasketListViewModel(@NotNull Activity activity2, @NotNull ActiveCartsMethodCallHandler activeCartsMethodCallHandler2, @NotNull DarkstoresNavigator darkstoresNavigator2, @NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(activeCartsMethodCallHandler2, "activeCartsMethodCallHandler");
        Intrinsics.checkNotNullParameter(darkstoresNavigator2, "darkstoresNavigator");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        this.activity = activity2;
        this.activeCartsMethodCallHandler = activeCartsMethodCallHandler2;
        this.darkstoresNavigator = darkstoresNavigator2;
        this.navigator = navigator2;
    }

    private final void setUpFoodCartChannel(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor(), "com.talabat.flutter/vendor-cart").setMethodCallHandler(new CartMethodChannel(this.activity));
    }

    public void navigateToFoodBasket() {
        Navigator.DefaultImpls.navigateTo$default(this.navigator, this.activity, new CartScreen((Void) null, 1, (DefaultConstructorMarker) null), (Function1) null, 4, (Object) null);
        this.activity.finish();
    }

    public void navigateToQcommerceBasket(@NotNull Restaurant restaurant) {
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(this.darkstoresNavigator, this.activity, restaurant2, Integer.valueOf(DarkstoreNavigationType.CART.getType()), (String) null, (String) null, (String) null, false, (String) null, (String) null, "basket_list", (String) null, (DarkstoresTrackingData) null, 3568, (Object) null);
        this.activity.finish();
    }

    @VisibleForTesting(otherwise = 4)
    public void onCleared() {
        super.onCleared();
        this.activeCartsMethodCallHandler.terminate();
    }

    public final void setUpChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        this.activeCartsMethodCallHandler.setUp(flutterEngine, this, SetsKt__SetsKt.setOf(BasketType.FOOD, BasketType.QCOMMERCE));
        setUpFoodCartChannel(flutterEngine);
    }
}
