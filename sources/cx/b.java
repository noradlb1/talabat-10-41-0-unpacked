package cx;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.UserVerificationDisplayModel;
import com.talabat.userandlocation.compliance.status.ui.activity.CheckUserAllowedToOrderActivity;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderActivity f13809a;

    public /* synthetic */ b(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity) {
        this.f13809a = checkUserAllowedToOrderActivity;
    }

    public final void onChanged(Object obj) {
        CheckUserAllowedToOrderActivity.m5895observeViewModel$lambda1(this.f13809a, (UserVerificationDisplayModel) obj);
    }
}
