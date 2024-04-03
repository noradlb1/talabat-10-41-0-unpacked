package com.talabat.feature.walletcobrandedcc.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.home.useraccount.tracking.UserAccountTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/tracking/AccountBadgeLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "()V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "com_talabat_feature_wallet-cobranded-cc_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountBadgeLoadedEvent extends TalabatEvent {
    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to(UserAccountTracker.KEY_BADGE_TYPE, "Account notification"), TuplesKt.to("screenType", "account page"), TuplesKt.to("screenName", "account page"));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "wallet_cobranded_cc";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "badge_loaded";
    }
}
