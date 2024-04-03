package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class l implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14020a;

    public /* synthetic */ l(UserVerificationFragment userVerificationFragment) {
        this.f14020a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5914observeValidationErrorDialogMessage$lambda2(this.f14020a, (String) obj);
    }
}
