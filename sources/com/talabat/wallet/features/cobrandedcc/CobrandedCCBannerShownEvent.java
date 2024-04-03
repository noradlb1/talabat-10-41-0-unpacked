package com.talabat.wallet.features.cobrandedcc;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerShownEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "isApplicationPending", "", "(Z)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CobrandedCCBannerShownEvent extends TalabatEvent {
    @NotNull
    private static final String BANNER_NAME_KEY = "bannerName";
    @NotNull
    private static final String BANNER_NAME_VALUE = "co_branded_card";
    @NotNull
    private static final String BANNER_PENDING_NAME_VALUE = "co_branded_card_pending_application";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FEATURE_NAME = "co_branded_card";
    @NotNull
    private static final String SCREEN_NAME_VALUE = "Wallet Dashboard Screen";
    @NotNull
    private static final String SCREEN_TYPE_VALUE = "wallet";
    private final boolean isApplicationPending;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerShownEvent$Companion;", "", "()V", "BANNER_NAME_KEY", "", "BANNER_NAME_VALUE", "BANNER_PENDING_NAME_VALUE", "FEATURE_NAME", "SCREEN_NAME_VALUE", "SCREEN_TYPE_VALUE", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CobrandedCCBannerShownEvent(boolean z11) {
        this.isApplicationPending = z11;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("screenName", "Wallet Dashboard Screen");
        pairArr[1] = TuplesKt.to("screenType", "wallet");
        if (this.isApplicationPending) {
            str = BANNER_PENDING_NAME_VALUE;
        } else {
            str = "co_branded_card";
        }
        pairArr[2] = TuplesKt.to("bannerName", str);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "co_branded_card";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "banner_store_shown";
    }
}
