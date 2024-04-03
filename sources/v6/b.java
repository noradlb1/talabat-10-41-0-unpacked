package v6;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.WebDialog;

public final /* synthetic */ class b implements WebDialog.OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookDialogFragment f34741a;

    public /* synthetic */ b(FacebookDialogFragment facebookDialogFragment) {
        this.f34741a = facebookDialogFragment;
    }

    public final void onComplete(Bundle bundle, FacebookException facebookException) {
        FacebookDialogFragment.m8947initDialog$lambda0(this.f34741a, bundle, facebookException);
    }
}
