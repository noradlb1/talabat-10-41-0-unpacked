package x0;

import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;

public final /* synthetic */ class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f11631a;

    public /* synthetic */ a(String str) {
        this.f11631a = str;
    }

    public final float getInterpolation(float f11) {
        return Transition.lambda$getInterpolator$0(this.f11631a, f11);
    }
}
