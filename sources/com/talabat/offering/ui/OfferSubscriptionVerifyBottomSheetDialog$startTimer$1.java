package com.talabat.offering.ui;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/offering/ui/OfferSubscriptionVerifyBottomSheetDialog$startTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferSubscriptionVerifyBottomSheetDialog$startTimer$1 extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferSubscriptionVerifyBottomSheetDialog f61169a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f61170b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferSubscriptionVerifyBottomSheetDialog$startTimer$1(long j11, OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog, TextView textView) {
        super(j11, 1000);
        this.f61169a = offerSubscriptionVerifyBottomSheetDialog;
        this.f61170b = textView;
    }

    public void onFinish() {
        DSPrimaryButton dSPrimaryButton;
        OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog = this.f61169a;
        TextView textView = this.f61170b;
        View view = offerSubscriptionVerifyBottomSheetDialog.getSubscriptionBottomSheet().getView();
        if (view != null) {
            dSPrimaryButton = (DSPrimaryButton) view.findViewById(R.id.bs_button_primary);
        } else {
            dSPrimaryButton = null;
        }
        offerSubscriptionVerifyBottomSheetDialog.handleTimerFinish(textView, dSPrimaryButton);
    }

    public void onTick(long j11) {
        this.f61169a.handleTimerTicks(j11, this.f61170b);
    }
}
