package uv;

import android.view.View;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.ApplyVoucherPageView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherPageView f24131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f24132c;

    public /* synthetic */ c(ApplyVoucherPageView applyVoucherPageView, VoucherDisplayModel voucherDisplayModel) {
        this.f24131b = applyVoucherPageView;
        this.f24132c = voucherDisplayModel;
    }

    public final void onClick(View view) {
        ApplyVoucherPageView.m5783setListeners$lambda2(this.f24131b, this.f24132c, view);
    }
}
