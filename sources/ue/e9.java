package ue;

import android.animation.ValueAnimator;
import com.talabat.HomeScreenMap;
import com.talabat.maps.domain.FrameworkMap;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class e9 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap f57509a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57510b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57511c;

    public /* synthetic */ e9(FrameworkMap frameworkMap, HomeScreenMap homeScreenMap, Ref.ObjectRef objectRef) {
        this.f57509a = frameworkMap;
        this.f57510b = homeScreenMap;
        this.f57511c = objectRef;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HomeScreenMap.m9480setPaddingForGoogleLogo$lambda22(this.f57509a, this.f57510b, this.f57511c, valueAnimator);
    }
}
