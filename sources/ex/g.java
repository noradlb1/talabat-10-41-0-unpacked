package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.CheckBoxDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14016a;

    public /* synthetic */ g(UserVerificationFragment userVerificationFragment) {
        this.f14016a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5909observePrivacyTermsConsent$lambda9(this.f14016a, (CheckBoxDisplayModel) obj);
    }
}
