package com.talabat.wallet.features.cobrandedcc;

import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerTrackerImpl;", "Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "trackBannerClicked", "", "isApplicationPending", "", "trackBannerShown", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CobrandedCCBannerTrackerImpl implements CobrandedCCBannerTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    public CobrandedCCBannerTrackerImpl(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void trackBannerClicked(boolean z11) {
        this.talabatTracker.track(new CobrandedCCBannerClickedEvent(z11));
    }

    public void trackBannerShown(boolean z11) {
        this.talabatTracker.track(new CobrandedCCBannerShownEvent(z11));
    }
}
