package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class t implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14028a;

    public /* synthetic */ t(UserVerificationFragment userVerificationFragment) {
        this.f14028a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5905observeEditFields$lambda6(this.f14028a, (EditFieldDisplayModel) obj);
    }
}
