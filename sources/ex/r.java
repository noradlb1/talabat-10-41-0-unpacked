package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class r implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14026a;

    public /* synthetic */ r(UserVerificationFragment userVerificationFragment) {
        this.f14026a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5903observeEditFields$lambda4(this.f14026a, (EditFieldDisplayModel) obj);
    }
}
