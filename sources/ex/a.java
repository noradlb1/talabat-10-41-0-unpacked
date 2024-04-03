package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.TitleDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14009a;

    public /* synthetic */ a(UserVerificationFragment userVerificationFragment) {
        this.f14009a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5912observeSecondaryTitle$lambda12(this.f14009a, (TitleDisplayModel) obj);
    }
}
