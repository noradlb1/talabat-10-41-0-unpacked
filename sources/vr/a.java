package vr;

import android.view.View;
import com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherBottomSheetView f62964b;

    public /* synthetic */ a(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView) {
        this.f62964b = redeemVoucherBottomSheetView;
    }

    public final void onClick(View view) {
        RedeemVoucherBottomSheetView.m10619updateNotLoggedInState$lambda2(this.f62964b, view);
    }
}
