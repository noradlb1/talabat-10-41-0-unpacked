package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.CheckBoxDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class n implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14022a;

    public /* synthetic */ n(UserVerificationFragment userVerificationFragment) {
        this.f14022a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5910observePromotionsConsent$lambda10(this.f14022a, (CheckBoxDisplayModel) obj);
    }
}
