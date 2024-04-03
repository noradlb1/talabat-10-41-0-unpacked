package androidx.preference.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.preference.R;

@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PreferenceImageView extends ImageView {
    private int mMaxHeight;
    private int mMaxWidth;

    public PreferenceImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i11);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i11 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i12);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i12 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i11, i12);
    }

    public void setMaxHeight(int i11) {
        this.mMaxHeight = i11;
        super.setMaxHeight(i11);
    }

    public void setMaxWidth(int i11) {
        this.mMaxWidth = i11;
        super.setMaxWidth(i11);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceImageView, i11, 0);
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceImageView_maxWidth, Integer.MAX_VALUE));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceImageView_maxHeight, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }
}
