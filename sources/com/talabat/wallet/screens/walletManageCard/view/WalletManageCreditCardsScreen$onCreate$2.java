package com.talabat.wallet.screens.walletManageCard.view;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsScreen$onCreate$2", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletManageCreditCardsScreen$onCreate$2 extends BottomSheetBehavior.BottomSheetCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsScreen f12699a;

    public WalletManageCreditCardsScreen$onCreate$2(WalletManageCreditCardsScreen walletManageCreditCardsScreen) {
        this.f12699a = walletManageCreditCardsScreen;
    }

    public void onSlide(@NotNull View view, float f11) {
        Intrinsics.checkNotNullParameter(view, "bottomSheet");
    }

    public void onStateChanged(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "bottomSheet");
        if (i11 == 1) {
            BottomSheetBehavior access$getSheetBehavior$p = this.f12699a.sheetBehavior;
            if (access$getSheetBehavior$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
                access$getSheetBehavior$p = null;
            }
            access$getSheetBehavior$p.setState(3);
        }
    }
}
