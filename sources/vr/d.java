package vr;

import android.view.View;
import com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetView;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherBottomSheetView f62968b;

    public /* synthetic */ d(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView) {
        this.f62968b = redeemVoucherBottomSheetView;
    }

    public final void onClick(View view) {
        RedeemVoucherBottomSheetView.m10618updateLoggedInState$lambda4(this.f62968b, view);
    }
}
