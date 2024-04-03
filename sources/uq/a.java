package uq;

import android.animation.ValueAnimator;
import android.view.View;
import com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewHolder f62951a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f62952b;

    public /* synthetic */ a(GemSwimlanesViewHolder gemSwimlanesViewHolder, View view) {
        this.f62951a = gemSwimlanesViewHolder;
        this.f62952b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        GemSwimlanesViewHolder.m10538animateLayoutChanges$lambda2(this.f62951a, this.f62952b, valueAnimator);
    }
}
