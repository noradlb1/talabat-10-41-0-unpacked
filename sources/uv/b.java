package uv;

import android.view.View;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.ApplyVoucherPageView;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherPageView f24129b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f24130c;

    public /* synthetic */ b(ApplyVoucherPageView applyVoucherPageView, VoucherDisplayModel voucherDisplayModel) {
        this.f24129b = applyVoucherPageView;
        this.f24130c = voucherDisplayModel;
    }

    public final void onClick(View view) {
        ApplyVoucherPageView.m5782setListeners$lambda1(this.f24129b, this.f24130c, view);
    }
}
