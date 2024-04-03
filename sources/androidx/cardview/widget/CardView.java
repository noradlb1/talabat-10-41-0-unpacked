package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.cardview.R;

public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        IMPL = cardViewApi21Impl;
        cardViewApi21Impl.initStatic();
    }

    public CardView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void onMeasure(int i11, int i12) {
        CardViewImpl cardViewImpl = IMPL;
        if (!(cardViewImpl instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i11);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(i11)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i12);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i12 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(i12)), mode2);
            }
            super.onMeasure(i11, i12);
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void setCardBackgroundColor(@ColorInt int i11) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i11));
    }

    public void setCardElevation(float f11) {
        IMPL.setElevation(this.mCardViewDelegate, f11);
    }

    public void setContentPadding(@Px int i11, @Px int i12, @Px int i13, @Px int i14) {
        this.mContentPadding.set(i11, i12, i13, i14);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f11) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f11);
    }

    public void setMinimumHeight(int i11) {
        this.mUserSetMinHeight = i11;
        super.setMinimumHeight(i11);
    }

    public void setMinimumWidth(int i11) {
        this.mUserSetMinWidth = i11;
        super.setMinimumWidth(i11);
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
    }

    public void setPaddingRelative(int i11, int i12, int i13, int i14) {
    }

    public void setPreventCornerOverlap(boolean z11) {
        if (z11 != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z11;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f11) {
        IMPL.setRadius(this.mCardViewDelegate, f11);
    }

    public void setUseCompatPadding(boolean z11) {
        if (this.mCompatPadding != z11) {
            this.mCompatPadding = z11;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int i12;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        AnonymousClass1 r32 = new CardViewDelegate() {
            private Drawable mCardBackground;

            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            public View getCardView() {
                return CardView.this;
            }

            public boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            public boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public void setMinWidthHeightInternal(int i11, int i12) {
                CardView cardView = CardView.this;
                if (i11 > cardView.mUserSetMinWidth) {
                    CardView.super.setMinimumWidth(i11);
                }
                CardView cardView2 = CardView.this;
                if (i12 > cardView2.mUserSetMinHeight) {
                    CardView.super.setMinimumHeight(i12);
                }
            }

            public void setShadowPadding(int i11, int i12, int i13, int i14) {
                CardView.this.mShadowBounds.set(i11, i12, i13, i14);
                CardView cardView = CardView.this;
                Rect rect = cardView.mContentPadding;
                CardView.super.setPadding(i11 + rect.left, i12 + rect.top, i13 + rect.right, i14 + rect.bottom);
            }
        };
        this.mCardViewDelegate = r32;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i11, R.style.CardView);
        int i13 = R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            valueOf = obtainStyledAttributes.getColorStateList(i13);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i12 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i12 = getResources().getColor(R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i12);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f11 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(r32, context, colorStateList, dimension, dimension2, f11);
    }
}
