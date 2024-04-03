package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public void c(ConstraintLayout constraintLayout) {
        b(constraintLayout);
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.f11098f = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public void setElevation(float f11) {
        super.setElevation(f11);
        a();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        a();
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f11124v.setWidth(0);
        layoutParams.f11124v.setHeight(0);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
