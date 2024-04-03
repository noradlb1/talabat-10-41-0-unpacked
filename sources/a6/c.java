package a6;

import android.animation.ValueAnimator;
import android.view.View;
import com.designsystem.ds_bottom_sheet_v2.BottomSheetSharedTransition;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f29309a;

    public /* synthetic */ c(View view) {
        this.f29309a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        BottomSheetSharedTransition.m8264prepareHeightAnimator$lambda9$lambda6(this.f29309a, valueAnimator);
    }
}
