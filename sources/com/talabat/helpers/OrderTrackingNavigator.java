package com.talabat.helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.talabat.trackorder.presentation.OrderTrackingFlutterActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpers/OrderTrackingNavigator;", "", "()V", "navigateToNewOrderTracking", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "addFlags", "", "flags", "", "(Landroid/content/Context;Landroid/os/Bundle;ZLjava/lang/Integer;)V", "navigateToOrderTracking", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingNavigator {
    @NotNull
    public static final OrderTrackingNavigator INSTANCE = new OrderTrackingNavigator();

    private OrderTrackingNavigator() {
    }

    @JvmStatic
    public static final void navigateToOrderTracking(@NotNull Context context, @NotNull Bundle bundle, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        INSTANCE.navigateToNewOrderTracking(context, bundle, z11, (Integer) null);
    }

    public final void navigateToNewOrderTracking(@NotNull Context context, @NotNull Bundle bundle, boolean z11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent intent = new Intent(context, OrderTrackingFlutterActivity.class);
        intent.putExtras(bundle);
        if (z11) {
            if (num != null) {
                intent.addFlags(num.intValue());
            } else {
                intent.addFlags(268468224);
            }
        }
        context.startActivity(intent);
    }

    @JvmStatic
    public static final void navigateToOrderTracking(@NotNull Context context, @NotNull Bundle bundle, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        INSTANCE.navigateToNewOrderTracking(context, bundle, true, Integer.valueOf(i11));
    }
}
