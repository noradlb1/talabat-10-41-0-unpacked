package com.talabat.trackorder.presentation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tracking.deeplink.IDeepLinkPresenter;
import tracking.deeplink.di.OrderTrackingDeeplinksPresenterProvider;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ltracking/deeplink/IDeepLinkPresenter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingFlutterActivity$deeplinkPresenter$2 extends Lambda implements Function0<IDeepLinkPresenter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderTrackingFlutterActivity f12136g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderTrackingFlutterActivity$deeplinkPresenter$2(OrderTrackingFlutterActivity orderTrackingFlutterActivity) {
        super(0);
        this.f12136g = orderTrackingFlutterActivity;
    }

    @NotNull
    public final IDeepLinkPresenter invoke() {
        OrderTrackingDeeplinksPresenterProvider orderTrackingDeeplinksPresenterProvider = OrderTrackingDeeplinksPresenterProvider.INSTANCE;
        OrderTrackingFlutterActivity orderTrackingFlutterActivity = this.f12136g;
        return orderTrackingDeeplinksPresenterProvider.providesDeeplinkPresenter(orderTrackingFlutterActivity, orderTrackingFlutterActivity);
    }
}
