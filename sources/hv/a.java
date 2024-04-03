package hv;

import android.view.View;
import com.talabat.talabatcommon.views.MobileNumberWithOTPView;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f14091b;

    public /* synthetic */ a(Function0 function0) {
        this.f14091b = function0;
    }

    public final void onClick(View view) {
        MobileNumberWithOTPView.m5742setOTPClickListener$lambda0(this.f14091b, view);
    }
}
