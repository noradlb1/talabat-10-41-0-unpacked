package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet, i11, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i11, int i12) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i11, i12);
        int i13 = R.styleable.PopupWindow_overlapAnchor;
        if (obtainStyledAttributes.hasValue(i13)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(i13, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z11) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z11;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z11);
        }
    }

    public void showAsDropDown(View view, int i11, int i12) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12);
    }

    public void update(View view, int i11, int i12, int i13, int i14) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i12 -= view.getHeight();
        }
        super.update(view, i11, i12, i13, i14);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        super(context, attributeSet, i11, i12);
        init(context, attributeSet, i11, i12);
    }

    public void showAsDropDown(View view, int i11, int i12, int i13) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12, i13);
    }
}
