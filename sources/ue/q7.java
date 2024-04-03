package ue;

import android.animation.ValueAnimator;
import com.talabat.GroceryMenuScreen;

public final /* synthetic */ class q7 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen f57706a;

    public /* synthetic */ q7(GroceryMenuScreen groceryMenuScreen) {
        this.f57706a = groceryMenuScreen;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f57706a.lambda$increaseCollapsingToolbarSize$13(valueAnimator);
    }
}
