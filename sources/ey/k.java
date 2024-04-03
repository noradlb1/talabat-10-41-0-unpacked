package ey;

import android.content.DialogInterface;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;
import java.util.List;

public final /* synthetic */ class k implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsScreen f14046b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f14047c;

    public /* synthetic */ k(WalletManageCreditCardsScreen walletManageCreditCardsScreen, List list) {
        this.f14046b = walletManageCreditCardsScreen;
        this.f14047c = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        WalletManageCreditCardsScreen.m5992setDeleteIconListener$lambda11$lambda9(this.f14046b, this.f14047c, dialogInterface, i11);
    }
}
