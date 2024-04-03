package ex;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.TitleDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;

public final /* synthetic */ class p implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f14024a;

    public /* synthetic */ p(UserVerificationFragment userVerificationFragment) {
        this.f14024a = userVerificationFragment;
    }

    public final void onChanged(Object obj) {
        UserVerificationFragment.m5911observeScreenTitle$lambda19(this.f14024a, (TitleDisplayModel) obj);
    }
}
