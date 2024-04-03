package com.talabat.core.flutter.channels.impl.data.ordertrackingdependencies;

import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipStatusListener;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/core/flutter/channels/impl/data/ordertrackingdependencies/OrderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1", "Lcom/talabat/talabatcommon/views/ridersTip/bottomSheet/RiderTipStatusListener;", "riderTippedSuccessfully", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1 implements RiderTipStatusListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f55925b;

    public OrderTrackingDependenciesChannelCallbackImpl$showRiderTipBottomSheet$successListener$1(Function0<Unit> function0) {
        this.f55925b = function0;
    }

    public void riderTippedSuccessfully() {
        LogManager.debug("riderTippedSuccessfully");
        this.f55925b.invoke();
    }
}
