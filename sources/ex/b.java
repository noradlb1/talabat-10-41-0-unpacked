package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14010a;

    public /* synthetic */ b(UserVerificationFragment userVerificationFragment) {
        this.f14010a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5906observeEditFields$lambda7(this.f14010a, (EditFieldDisplayModel) obj);
    }
}
