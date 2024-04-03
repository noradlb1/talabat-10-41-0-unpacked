package cx;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.DismissScreenModel;
import com.talabat.userandlocation.compliance.status.ui.activity.CheckUserAllowedToOrderActivity;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderActivity f13811a;

    public /* synthetic */ d(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity) {
        this.f13811a = checkUserAllowedToOrderActivity;
    }

    public final void onChanged(Object obj) {
        CheckUserAllowedToOrderActivity.m5897observeViewModel$lambda3(this.f13811a, (DismissScreenModel) obj);
    }
}
