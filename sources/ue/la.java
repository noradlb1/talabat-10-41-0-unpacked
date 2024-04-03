package ue;

import android.content.DialogInterface;
import com.talabat.LoginScreen;

public final /* synthetic */ class la implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen f57635b;

    public /* synthetic */ la(LoginScreen loginScreen) {
        this.f57635b = loginScreen;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f57635b.lambda$showInvalidCredentialsForMobileLoginError$29(dialogInterface, i11);
    }
}
