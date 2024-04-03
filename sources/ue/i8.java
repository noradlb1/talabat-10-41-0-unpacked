package ue;

import android.animation.ValueAnimator;
import com.talabat.HomeScreenMap;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class i8 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57578a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57579b;

    public /* synthetic */ i8(HomeScreenMap homeScreenMap, Ref.ObjectRef objectRef) {
        this.f57578a = homeScreenMap;
        this.f57579b = objectRef;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HomeScreenMap.m9460animtLocationBtn$lambda23(this.f57578a, this.f57579b, valueAnimator);
    }
}
