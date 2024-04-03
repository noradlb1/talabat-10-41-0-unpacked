package vr;

import android.view.View;
import com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView;
import com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherBottomSheetView f62966b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherBottomSheetDisplayModel f62967c;

    public /* synthetic */ c(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView, RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel) {
        this.f62966b = redeemVoucherBottomSheetView;
        this.f62967c = redeemVoucherBottomSheetDisplayModel;
    }

    public final void onClick(View view) {
        RedeemVoucherBottomSheetView.m10617updateLoggedInState$lambda3(this.f62966b, this.f62967c, view);
    }
}
