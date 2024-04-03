package uv;

import android.view.View;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.ApplyVoucherPageView;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherPageView f24133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f24134c;

    public /* synthetic */ d(ApplyVoucherPageView applyVoucherPageView, VoucherDisplayModel voucherDisplayModel) {
        this.f24133b = applyVoucherPageView;
        this.f24134c = voucherDisplayModel;
    }

    public final void onClick(View view) {
        ApplyVoucherPageView.m5784setListeners$lambda3(this.f24133b, this.f24134c, view);
    }
}
