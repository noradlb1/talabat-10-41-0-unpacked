package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class s implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14027a;

    public /* synthetic */ s(UserVerificationFragment userVerificationFragment) {
        this.f14027a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5904observeEditFields$lambda5(this.f14027a, (EditFieldDisplayModel) obj);
    }
}
