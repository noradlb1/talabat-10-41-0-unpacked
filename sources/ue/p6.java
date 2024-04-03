package ue;

import android.animation.ValueAnimator;
import android.view.View;
import com.talabat.GroceryDetailsViewScreen;

public final /* synthetic */ class p6 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f57692a;

    public /* synthetic */ p6(View view) {
        this.f57692a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        GroceryDetailsViewScreen.m9422expand$lambda26(this.f57692a, valueAnimator);
    }
}
