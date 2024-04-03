package sv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ApplyVouchersView f24106a;

    public /* synthetic */ a(ApplyVouchersView applyVouchersView) {
        this.f24106a = applyVouchersView;
    }

    public final void onChanged(Object obj) {
        ApplyVouchersView.m5778unApplyAllVouchersObserver$lambda0(this.f24106a, (Boolean) obj);
    }
}
