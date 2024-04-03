package com.talabat.feature.tpro.presentation.payment;

import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/payment/SubscriptionPaymentDeeplinkBuilder;", "", "()V", "build", "", "planId", "subscriptionCode", "strategy", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentDeeplinkBuilder {
    public static /* synthetic */ String build$default(SubscriptionPaymentDeeplinkBuilder subscriptionPaymentDeeplinkBuilder, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return subscriptionPaymentDeeplinkBuilder.build(str, str2, str3);
    }

    @NotNull
    public final String build(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        StringBuilder sb2 = new StringBuilder("talabat://?s=subscription/payment");
        if (str3 == null) {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append("?planId=" + str);
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            sb2.append("&subscriptionCode=" + str2);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "routeBuilder.toString()");
        return sb3;
    }
}
