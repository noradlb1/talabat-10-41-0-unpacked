package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14011a;

    public /* synthetic */ c(UserVerificationFragment userVerificationFragment) {
        this.f14011a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5907observeEditFields$lambda8(this.f14011a, (EditFieldDisplayModel) obj);
    }
}
