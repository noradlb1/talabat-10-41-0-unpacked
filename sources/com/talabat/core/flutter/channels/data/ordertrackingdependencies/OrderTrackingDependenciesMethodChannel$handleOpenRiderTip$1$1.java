package com.talabat.core.flutter.channels.data.ordertrackingdependencies;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingDependenciesMethodChannel$handleOpenRiderTip$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderTrackingDependenciesMethodChannel f55898g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderTrackingDependenciesMethodChannel$handleOpenRiderTip$1$1(OrderTrackingDependenciesMethodChannel orderTrackingDependenciesMethodChannel) {
        super(0);
        this.f55898g = orderTrackingDependenciesMethodChannel;
    }

    public final void invoke() {
        this.f55898g.refreshOrderTrackingScreen();
    }
}
