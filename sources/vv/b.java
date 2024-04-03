package vv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.vouchers.lifecycle.BasketLifecycleVoucherView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasketLifecycleVoucherView f24147a;

    public /* synthetic */ b(BasketLifecycleVoucherView basketLifecycleVoucherView) {
        this.f24147a = basketLifecycleVoucherView;
    }

    public final void onChanged(Object obj) {
        BasketLifecycleVoucherView.m5786setupUi$lambda3$lambda2$lambda0(this.f24147a, (String) obj);
    }
}
