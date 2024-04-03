package cs;

import android.animation.ValueAnimator;
import com.talabat.home.HomeScreenActivity;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f61803a;

    public /* synthetic */ e(HomeScreenActivity homeScreenActivity) {
        this.f61803a = homeScreenActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HomeScreenActivity.m10644transitionHeaderColour$lambda50(this.f61803a, valueAnimator);
    }
}
