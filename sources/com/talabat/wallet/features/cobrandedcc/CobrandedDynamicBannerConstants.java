package com.talabat.wallet.features.cobrandedcc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/features/cobrandedcc/CobrandedDynamicBannerConstants;", "", "()V", "COBRANDED_DEEPLINK_EVENT", "", "COBRANDED_DEEPLINK_FAILED_EVENT", "COBRANDED_DYNAMIC_SHOWN_EVENT", "COBRANDED_STATIC_SHOWN_EVENT", "EVENT_NAME", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CobrandedDynamicBannerConstants {
    @NotNull
    public static final String COBRANDED_DEEPLINK_EVENT = "WalletDashboardCCBannerDeeplink";
    @NotNull
    public static final String COBRANDED_DEEPLINK_FAILED_EVENT = "WalletDashboardCCBannerDeeplinkFailed";
    @NotNull
    public static final String COBRANDED_DYNAMIC_SHOWN_EVENT = "CoBrandedDynamicBannerShown";
    @NotNull
    public static final String COBRANDED_STATIC_SHOWN_EVENT = "CoBrandedDynamicBannerShown";
    @NotNull
    public static final String EVENT_NAME = "Wallet Dashboard Screen";
    @NotNull
    public static final CobrandedDynamicBannerConstants INSTANCE = new CobrandedDynamicBannerConstants();

    private CobrandedDynamicBannerConstants() {
    }
}
