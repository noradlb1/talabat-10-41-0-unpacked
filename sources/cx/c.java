package cx;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.status.ui.activity.CheckUserAllowedToOrderActivity;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderActivity f13810a;

    public /* synthetic */ c(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity) {
        this.f13810a = checkUserAllowedToOrderActivity;
    }

    public final void onChanged(Object obj) {
        CheckUserAllowedToOrderActivity.m5896observeViewModel$lambda2(this.f13810a, (Boolean) obj);
    }
}
