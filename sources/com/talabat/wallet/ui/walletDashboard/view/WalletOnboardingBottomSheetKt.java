package com.talabat.wallet.ui.walletDashboard.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\t"}, d2 = {"getBody", "Lcom/talabat/wallet/ui/walletDashboard/view/WalletOnboardingFragment;", "withTopUp", "", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet;", "showWalletOnboardingBottomSheet", "", "Landroidx/fragment/app/Fragment;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WalletOnboardingBottomSheetKt {
    private static final WalletOnboardingFragment getBody(boolean z11, BottomSheet bottomSheet) {
        return new WalletOnboardingFragment(z11, bottomSheet);
    }

    public static final void showWalletOnboardingBottomSheet(@NotNull Fragment fragment, boolean z11) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        DSBottomSheet findDSBottomSheet = DSFragmentManagerExtensionsKt.findDSBottomSheet(parentFragmentManager, WalletOnboardingFragment.TAG);
        if (findDSBottomSheet == null) {
            findDSBottomSheet = new DSBottomSheet();
        }
        findDSBottomSheet.setBody(getBody(z11, findDSBottomSheet));
        findDSBottomSheet.show(fragment.getParentFragmentManager(), WalletOnboardingFragment.TAG);
    }
}
