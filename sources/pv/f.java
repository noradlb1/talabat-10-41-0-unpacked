package pv;

import android.widget.RadioGroup;
import com.talabat.talabatcommon.views.ridersTip.bottomSheet.RiderTipFragment;

public final /* synthetic */ class f implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RiderTipFragment f24050b;

    public /* synthetic */ f(RiderTipFragment riderTipFragment) {
        this.f24050b = riderTipFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        RiderTipFragment.m5776initTipsRadioGroupList$lambda25$lambda24(this.f24050b, radioGroup, i11);
    }
}
