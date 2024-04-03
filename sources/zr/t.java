package zr;

import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.OnAttributionChangedListener;
import com.talabat.helpers.TalabatApplication;

public final /* synthetic */ class t implements OnAttributionChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TalabatApplication f63118a;

    public /* synthetic */ t(TalabatApplication talabatApplication) {
        this.f63118a = talabatApplication;
    }

    public final void onAttributionChanged(AdjustAttribution adjustAttribution) {
        TalabatApplication.m10626createAdjust$lambda7(this.f63118a, adjustAttribution);
    }
}
