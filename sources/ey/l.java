package ey;

import android.content.DialogInterface;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;

public final /* synthetic */ class l implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsScreen f14048b;

    public /* synthetic */ l(WalletManageCreditCardsScreen walletManageCreditCardsScreen) {
        this.f14048b = walletManageCreditCardsScreen;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        WalletManageCreditCardsScreen.m5991setDeleteIconListener$lambda11$lambda10(this.f14048b, dialogInterface, i11);
    }
}
