package v6;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.WebDialog;

public final /* synthetic */ class c implements WebDialog.OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookDialogFragment f34742a;

    public /* synthetic */ c(FacebookDialogFragment facebookDialogFragment) {
        this.f34742a = facebookDialogFragment;
    }

    public final void onComplete(Bundle bundle, FacebookException facebookException) {
        FacebookDialogFragment.m8948initDialog$lambda1(this.f34742a, bundle, facebookException);
    }
}
