package ue;

import android.content.DialogInterface;
import com.talabat.LoginScreen;

public final /* synthetic */ class fa implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginScreen f57529b;

    public /* synthetic */ fa(LoginScreen loginScreen) {
        this.f57529b = loginScreen;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f57529b.lambda$onLoginFailedBecauseOfTooManyRequests$25(dialogInterface, i11);
    }
}
