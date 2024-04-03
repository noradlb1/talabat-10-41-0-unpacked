package com.integration.wallet;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/integration/wallet/WalletIntegrationAppTracker;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletIntegrationAppTracker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ.\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b¨\u0006\u000f"}, d2 = {"Lcom/integration/wallet/WalletIntegrationAppTracker$Companion;", "", "()V", "onWalletTopUpAttempted", "", "context", "Landroid/content/Context;", "screenName", "", "screenType", "amount", "onWalletTopUpClicked", "onWalletTopUpFailure", "errorMessage", "onWalletTopUpSuccess", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onWalletTopUpAttempted(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            Intrinsics.checkNotNullParameter(str3, "amount");
            AppTracker.onWalletTopupAttempted(context, str, str2, str3);
        }

        public final void onWalletTopUpClicked(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            AppTracker.onWalletTopupClicked(context, str, str2);
        }

        public final void onWalletTopUpFailure(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            Intrinsics.checkNotNullParameter(str3, "amount");
            Intrinsics.checkNotNullParameter(str4, "errorMessage");
            AppTracker.onWalletTopupFailed(context, str, str2, str3, str4);
        }

        public final void onWalletTopUpSuccess(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            Intrinsics.checkNotNullParameter(str3, "amount");
            Intrinsics.checkNotNullParameter(str4, "errorMessage");
            AppTracker.onWalletTopupSuccess(context, str, str2, str3, str4);
        }
    }
}
