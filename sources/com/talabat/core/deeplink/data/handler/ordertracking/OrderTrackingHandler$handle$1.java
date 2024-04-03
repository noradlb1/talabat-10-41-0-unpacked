package com.talabat.core.deeplink.data.handler.ordertracking;

import android.content.Intent;
import com.talabat.core.navigation.domain.screen.ordertracking.OrderTrackingScreen;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingHandler$handle$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderTrackingScreen.OrderTrackingScreenData f55820g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ OrderTrackingHandler f55821h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderTrackingHandler$handle$1(OrderTrackingScreen.OrderTrackingScreenData orderTrackingScreenData, OrderTrackingHandler orderTrackingHandler) {
        super(1);
        this.f55820g = orderTrackingScreenData;
        this.f55821h = orderTrackingHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
        if (this.f55820g.getShouldClearNavigationStack()) {
            intent.putExtra("transId", this.f55820g.getTransactionId());
            intent.putExtra("shouldClearNavigationStack", true);
            AppTracker.savePurchase(this.f55821h.generatePurchaseObj(this.f55820g.isFirstOrder(), this.f55820g.getSelectedPaymentMethod(), this.f55820g.getAddToPayMethod(), this.f55820g.getTransactionId(), this.f55820g.isPurchaseEventsEnabled()));
        }
    }
}
