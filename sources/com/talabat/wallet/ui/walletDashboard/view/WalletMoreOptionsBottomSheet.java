package com.talabat.wallet.ui.walletDashboard.view;

import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletMoreOptionsBottomSheet;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "getBottomSheet$annotations", "()V", "getBottomSheet", "()Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "setBottomSheet", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;)V", "show", "", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletMoreOptionsBottomSheet {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final double MAX_HEIGHT_RATION = 0.6d;
    @Nullable
    private final FragmentActivity activity;
    @NotNull
    private DSBottomSheet bottomSheet;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletMoreOptionsBottomSheet$Companion;", "", "()V", "MAX_HEIGHT_RATION", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WalletMoreOptionsBottomSheet(@Nullable FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        dSBottomSheet.setMaxHeightRation(0.6d);
        this.bottomSheet = dSBottomSheet;
        dSBottomSheet.setBody(WalletMoreOptionsFragment.Companion.newInstance());
    }

    @VisibleForTesting
    public static /* synthetic */ void getBottomSheet$annotations() {
    }

    @NotNull
    public final DSBottomSheet getBottomSheet() {
        return this.bottomSheet;
    }

    public final void setBottomSheet(@NotNull DSBottomSheet dSBottomSheet) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "<set-?>");
        this.bottomSheet = dSBottomSheet;
    }

    public final void show() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            this.bottomSheet.showNow(fragmentActivity.getSupportFragmentManager(), WalletMoreOptionsFragment.TAG);
        }
    }
}
