package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14019a;

    public /* synthetic */ k(UserVerificationFragment userVerificationFragment) {
        this.f14019a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5908observeLoadingDialog$lambda1(this.f14019a, (Boolean) obj);
    }
}
