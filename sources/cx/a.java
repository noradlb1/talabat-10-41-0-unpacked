package cx;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.status.ui.activity.CheckUserAllowedToOrderActivity;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderActivity f13808a;

    public /* synthetic */ a(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity) {
        this.f13808a = checkUserAllowedToOrderActivity;
    }

    public final void onChanged(Object obj) {
        CheckUserAllowedToOrderActivity.m5894observeViewModel$lambda0(this.f13808a, (Boolean) obj);
    }
}
