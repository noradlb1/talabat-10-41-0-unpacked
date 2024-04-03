package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.DismissScreenModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class m implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14021a;

    public /* synthetic */ m(UserVerificationFragment userVerificationFragment) {
        this.f14021a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5902observeDismissScreen$lambda18(this.f14021a, (DismissScreenModel) obj);
    }
}
