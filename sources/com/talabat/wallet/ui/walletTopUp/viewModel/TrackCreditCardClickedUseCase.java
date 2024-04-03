package com.talabat.wallet.ui.walletTopUp.viewModel;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/viewModel/TrackCreditCardClickedUseCase;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "trackCreditCardClickedEvent", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackCreditCardClickedUseCase {
    @NotNull
    private final TalabatTracker talabatTracker;

    public TrackCreditCardClickedUseCase(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public final void trackCreditCardClickedEvent() {
        this.talabatTracker.track(new WalletTopUpCreditCardSelectionEvent());
    }
}
