package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.ButtonDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class q implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14025a;

    public /* synthetic */ q(UserVerificationFragment userVerificationFragment) {
        this.f14025a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5901observeConfirmationButton$lambda13(this.f14025a, (ButtonDisplayModel) obj);
    }
}
