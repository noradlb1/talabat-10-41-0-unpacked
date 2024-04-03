package uy;

import android.content.DialogInterface;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24139b;

    public /* synthetic */ a(Function0 function0) {
        this.f24139b = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        WalletCardManagementFragment.m6045showAlertDialog$lambda11$lambda9(this.f24139b, dialogInterface, i11);
    }
}
