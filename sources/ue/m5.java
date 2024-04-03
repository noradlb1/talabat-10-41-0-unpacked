package ue;

import android.animation.ValueAnimator;
import com.talabat.ChooseSavedAddressScreen;

public final /* synthetic */ class m5 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressScreen f57648a;

    public /* synthetic */ m5(ChooseSavedAddressScreen chooseSavedAddressScreen) {
        this.f57648a = chooseSavedAddressScreen;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ChooseSavedAddressScreen.m9410animateSlideTo$lambda4(this.f57648a, valueAnimator);
    }
}
