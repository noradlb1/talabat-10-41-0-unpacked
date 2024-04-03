package com.talabat.homescreen.orderstatus.presentation.observability;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/observability/OrderStatusUpdateTracker;", "", "()V", "EVENT_TYPE", "", "trackStatus", "", "from", "Lcom/talabat/homescreen/orderstatus/presentation/observability/OrderStatusUpdateTracker$From;", "statusCode", "", "orderId", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "trackStatusDisplayed", "status", "From", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusUpdateTracker {
    @NotNull
    private static final String EVENT_TYPE = "OrderStatusWidgetUpdated";
    @NotNull
    public static final OrderStatusUpdateTracker INSTANCE = new OrderStatusUpdateTracker();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/observability/OrderStatusUpdateTracker$From;", "", "(Ljava/lang/String;I)V", "Component", "Refresh", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum From {
        Component,
        Refresh
    }

    private OrderStatusUpdateTracker() {
    }

    public final void trackStatus(@NotNull From from, int i11, @NotNull String str, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        String name2 = from.name();
        iObservabilityManager.trackEvent("From: " + name2, EVENT_TYPE, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("statusCode", String.valueOf(i11)), TuplesKt.to("orderId", str)));
    }

    public final void trackStatusDisplayed(@NotNull String str, @NotNull String str2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "orderId");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        iObservabilityManager.trackEvent("UiUpdated", EVENT_TYPE, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("status", str), TuplesKt.to("orderId", str2)));
    }
}
