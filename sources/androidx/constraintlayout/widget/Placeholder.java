package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.bytebuddy.description.type.TypeDescription;

public class Placeholder extends View {
    private View mContent = null;
    private int mContentId = -1;
    private int mEmptyVisibility = 4;

    public Placeholder(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private void init(AttributeSet attributeSet) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.mContentId = obtainStyledAttributes.getResourceId(index, this.mContentId);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.mEmptyVisibility = obtainStyledAttributes.getInt(index, this.mEmptyVisibility);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(TypeDescription.Generic.OfWildcardType.SYMBOL, 0, 1, rect);
            canvas.drawText(TypeDescription.Generic.OfWildcardType.SYMBOL, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i11) {
        View findViewById;
        if (this.mContentId != i11) {
            View view = this.mContent;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).f11112j = false;
                this.mContent = null;
            }
            this.mContentId = i11;
            if (i11 != -1 && (findViewById = ((View) getParent()).findViewById(i11)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i11) {
        this.mEmptyVisibility = i11;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.mContent != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
            layoutParams2.f11124v.setVisibility(0);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = layoutParams.f11124v.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            if (horizontalDimensionBehaviour != dimensionBehaviour) {
                layoutParams.f11124v.setWidth(layoutParams2.f11124v.getWidth());
            }
            if (layoutParams.f11124v.getVerticalDimensionBehaviour() != dimensionBehaviour) {
                layoutParams.f11124v.setHeight(layoutParams2.f11124v.getHeight());
            }
            layoutParams2.f11124v.setVisibility(8);
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.mContentId == -1 && !isInEditMode()) {
            setVisibility(this.mEmptyVisibility);
        }
        View findViewById = constraintLayout.findViewById(this.mContentId);
        this.mContent = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f11112j = true;
            this.mContent.setVisibility(0);
            setVisibility(0);
        }
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }
}
