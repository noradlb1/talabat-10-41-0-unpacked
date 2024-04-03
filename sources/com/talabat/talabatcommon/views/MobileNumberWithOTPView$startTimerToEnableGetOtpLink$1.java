package com.talabat.talabatcommon.views;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"com/talabat/talabatcommon/views/MobileNumberWithOTPView$startTimerToEnableGetOtpLink$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MobileNumberWithOTPView$startTimerToEnableGetOtpLink$1 extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MobileNumberWithOTPView f11708a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileNumberWithOTPView$startTimerToEnableGetOtpLink$1(MobileNumberWithOTPView mobileNumberWithOTPView, long j11) {
        super(j11, 1000);
        this.f11708a = mobileNumberWithOTPView;
    }

    public void onFinish() {
        this.f11708a.getTxtGetOTP().setEnabled(true);
        this.f11708a.getTxtGetOTP().setText(ViewKt.getString(this.f11708a, R.string.get_otp));
    }

    @SuppressLint({"SetTextI18n"})
    public void onTick(long j11) {
        this.f11708a.getTxtGetOTP().setText(this.f11708a.getFormattedTime(j11));
    }
}
