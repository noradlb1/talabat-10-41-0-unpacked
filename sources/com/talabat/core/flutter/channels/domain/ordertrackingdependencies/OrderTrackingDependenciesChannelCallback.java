package com.talabat.core.flutter.channels.domain.ordertrackingdependencies;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/ordertrackingdependencies/OrderTrackingDependenciesChannelCallback;", "", "openProPaymentScreen", "", "deeplink", "", "activity", "Landroid/app/Activity;", "openQCommerceDeeplink", "openRiderChat", "orderId", "openRiderTip", "onSuccess", "Lkotlin/Function0;", "openRiderTipInfo", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OrderTrackingDependenciesChannelCallback {
    void openProPaymentScreen(@NotNull String str, @NotNull Activity activity);

    void openQCommerceDeeplink(@NotNull String str, @NotNull Activity activity);

    void openRiderChat(@NotNull String str, @NotNull Activity activity);

    void openRiderTip(@NotNull String str, @NotNull Activity activity, @NotNull Function0<Unit> function0);

    void openRiderTipInfo(@NotNull String str, @NotNull Activity activity);
}
