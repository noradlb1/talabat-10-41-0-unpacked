package ue;

import android.content.DialogInterface;
import com.talabat.LoginScreen;

public final /* synthetic */ class ka implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen f57610b;

    public /* synthetic */ ka(LoginScreen loginScreen) {
        this.f57610b = loginScreen;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f57610b.lambda$showInvalidCredentialsForMobileLoginError$28(dialogInterface, i11);
    }
}
