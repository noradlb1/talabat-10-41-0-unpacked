package com.talabat.growth.ui.loyalty.dashboard;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "categoryName", "categoryId", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment$Companion$CHANNEL_NAME$1 extends Lambda implements Function2<String, String, String> {
    public static final LoyaltyDashboardFragment$Companion$CHANNEL_NAME$1 INSTANCE = new LoyaltyDashboardFragment$Companion$CHANNEL_NAME$1();

    public LoyaltyDashboardFragment$Companion$CHANNEL_NAME$1() {
        super(2);
    }

    @NotNull
    public final String invoke(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(str2, "categoryId");
        return str + "^" + str2;
    }
}
