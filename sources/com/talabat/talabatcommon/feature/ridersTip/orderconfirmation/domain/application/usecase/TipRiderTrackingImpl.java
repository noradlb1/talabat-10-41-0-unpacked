package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J2\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J*\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/TipRiderTrackingImpl;", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/TipRiderTracking;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tipRiderClicked", "", "orderStatus", "", "orderId", "tipValue", "paymentMethod", "source", "tipRiderCompleted", "tipRiderFailure", "errorMessage", "tipRiderOpened", "tipClickOrigin", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TipRiderTrackingImpl implements TipRiderTracking {
    @NotNull
    private final Context context;

    public TipRiderTrackingImpl(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public void tipRiderClicked(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str2, "orderId");
        Intrinsics.checkNotNullParameter(str3, "tipValue");
        Intrinsics.checkNotNullParameter(str4, "paymentMethod");
        Intrinsics.checkNotNullParameter(str5, "source");
        AppTracker.onTipRiderClicked(this.context, str, str2, str3, str4, str5);
    }

    public void tipRiderCompleted(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str2, "orderId");
        Intrinsics.checkNotNullParameter(str3, "tipValue");
        Intrinsics.checkNotNullParameter(str4, "paymentMethod");
        Intrinsics.checkNotNullParameter(str5, "source");
        AppTracker.onTipRiderCompleted(this.context, str, str2, str3, str4, str5);
    }

    public void tipRiderFailure(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str2, "orderId");
        Intrinsics.checkNotNullParameter(str3, "errorMessage");
        Intrinsics.checkNotNullParameter(str4, "paymentMethod");
        AppTracker.onTipRiderFailure(this.context, str, str2, str3, str4);
    }

    public void tipRiderOpened(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "orderId");
        Intrinsics.checkNotNullParameter(str3, "tipClickOrigin");
        AppTracker.onTipRiderOpened(this.context, str, str2, str3);
    }
}
