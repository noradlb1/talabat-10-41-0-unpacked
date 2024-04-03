package hv;

import android.animation.ValueAnimator;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float[] f14092a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShimmerLayout f14093b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14094c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f14095d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f14096e;

    public /* synthetic */ b(float[] fArr, ShimmerLayout shimmerLayout, int i11, int i12, int i13) {
        this.f14092a = fArr;
        this.f14093b = shimmerLayout;
        this.f14094c = i11;
        this.f14095d = i12;
        this.f14096e = i13;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ShimmerLayout.m5743_get_shimmerAnimation_$lambda0(this.f14092a, this.f14093b, this.f14094c, this.f14095d, this.f14096e, valueAnimator);
    }
}
