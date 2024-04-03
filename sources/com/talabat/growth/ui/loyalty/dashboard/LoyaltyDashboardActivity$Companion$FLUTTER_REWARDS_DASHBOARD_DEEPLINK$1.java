package com.talabat.growth.ui.loyalty.dashboard;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardActivity$Companion$FLUTTER_REWARDS_DASHBOARD_DEEPLINK$1 extends Lambda implements Function1<String, String> {
    public static final LoyaltyDashboardActivity$Companion$FLUTTER_REWARDS_DASHBOARD_DEEPLINK$1 INSTANCE = new LoyaltyDashboardActivity$Companion$FLUTTER_REWARDS_DASHBOARD_DEEPLINK$1();

    public LoyaltyDashboardActivity$Companion$FLUTTER_REWARDS_DASHBOARD_DEEPLINK$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return "talabat://?s=rewards/dashboard?eventOrigin=" + str;
    }
}
