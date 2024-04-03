package uy;

import android.content.DialogInterface;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24140b;

    public /* synthetic */ b(Function0 function0) {
        this.f24140b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        WalletCardManagementFragment.m6044showAlertDialog$lambda11$lambda10(this.f24140b, dialogInterface, i11);
    }
}
