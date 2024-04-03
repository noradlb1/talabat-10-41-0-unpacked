package com.talabat.trackorder.presentation;

import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipStatusListener;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/trackorder/presentation/OrderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipStatusListener;", "riderTippedSuccessfully", "", "com_talabat_feature_trackorder_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1 implements RiderTipStatusListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderTrackingFlutterActivity f12138b;

    public OrderTrackingFlutterActivity$showRiderTipBottomSheet$successListener$1(OrderTrackingFlutterActivity orderTrackingFlutterActivity) {
        this.f12138b = orderTrackingFlutterActivity;
    }

    public void riderTippedSuccessfully() {
        LogManager.debug("OrderTrackingFlutterActivity.riderTippedSuccessfully");
        MethodChannel access$getOrderTrackingMethodChannel$p = this.f12138b.orderTrackingMethodChannel;
        if (access$getOrderTrackingMethodChannel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderTrackingMethodChannel");
            access$getOrderTrackingMethodChannel$p = null;
        }
        access$getOrderTrackingMethodChannel$p.invokeMethod("refreshOtp", "");
    }
}
