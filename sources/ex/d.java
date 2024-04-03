package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.TitleDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14012a;

    public /* synthetic */ d(UserVerificationFragment userVerificationFragment) {
        this.f14012a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5913observeTitle$lambda11(this.f14012a, (TitleDisplayModel) obj);
    }
}
