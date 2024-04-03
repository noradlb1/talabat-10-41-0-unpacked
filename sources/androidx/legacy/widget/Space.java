package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public class Space extends View {
    @Deprecated
    public Space(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int getDefaultSize2(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i11, size);
        }
        if (mode != 1073741824) {
            return i11;
        }
        return size;
    }

    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Deprecated
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i11), getDefaultSize2(getSuggestedMinimumHeight(), i12));
    }

    @Deprecated
    public Space(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }
}
