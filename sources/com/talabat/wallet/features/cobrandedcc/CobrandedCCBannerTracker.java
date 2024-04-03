package com.talabat.wallet.features.cobrandedcc;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerTracker;", "", "trackBannerClicked", "", "isApplicationPending", "", "trackBannerShown", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CobrandedCCBannerTracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void trackBannerClicked$default(CobrandedCCBannerTracker cobrandedCCBannerTracker, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                cobrandedCCBannerTracker.trackBannerClicked(z11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackBannerClicked");
        }

        public static /* synthetic */ void trackBannerShown$default(CobrandedCCBannerTracker cobrandedCCBannerTracker, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                cobrandedCCBannerTracker.trackBannerShown(z11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackBannerShown");
        }
    }

    void trackBannerClicked(boolean z11);

    void trackBannerShown(boolean z11);
}
