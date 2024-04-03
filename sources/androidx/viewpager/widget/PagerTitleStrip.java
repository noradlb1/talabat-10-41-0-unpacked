package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS = {16842804, 16842901, 16842904, 16842927};
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = {16843660};
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;

        public PageListener() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.updateAdapter(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f11 = pagerTitleStrip2.mLastKnownPositionOffset;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f11, true);
        }

        public void onPageScrollStateChanged(int i11) {
            this.mScrollState = i11;
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            if (f11 > 0.5f) {
                i11++;
            }
            PagerTitleStrip.this.updateTextPositions(i11, f11, false);
        }

        public void onPageSelected(int i11) {
            if (this.mScrollState == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f11 = pagerTitleStrip2.mLastKnownPositionOffset;
                if (f11 < 0.0f) {
                    f11 = 0.0f;
                }
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f11, true);
            }
        }
    }

    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        public SingleLineAllCapsTransform(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    public void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.mPageListener);
            viewPager.addOnAdapterChangeListener(this.mPageListener);
            this.mPager = viewPager;
            WeakReference<PagerAdapter> weakReference = this.mWatchingAdapter;
            if (weakReference != null) {
                pagerAdapter = weakReference.get();
            } else {
                pagerAdapter = null;
            }
            updateAdapter(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            updateAdapter(viewPager.getAdapter(), (PagerAdapter) null);
            this.mPager.setInternalPageChangeListener((ViewPager.OnPageChangeListener) null);
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = null;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (this.mPager != null) {
            float f11 = this.mLastKnownPositionOffset;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f11, true);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i11);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, (int) (((float) size) * 0.2f), -2);
            this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
            this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
            this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i12) == 1073741824) {
                i13 = View.MeasureSpec.getSize(i12);
            } else {
                i13 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i13, i12, this.mCurrText.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    public void setGravity(int i11) {
        this.mGravity = i11;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        int i11 = ((int) (f11 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = i11;
        int i12 = (i11 << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(i12);
        this.mNextText.setTextColor(i12);
    }

    public void setTextColor(@ColorInt int i11) {
        this.mTextColor = i11;
        this.mCurrText.setTextColor(i11);
        int i12 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(i12);
        this.mNextText.setTextColor(i12);
    }

    public void setTextSize(int i11, float f11) {
        this.mPrevText.setTextSize(i11, f11);
        this.mCurrText.setTextSize(i11, f11);
        this.mNextText.setTextSize(i11, f11);
    }

    public void setTextSpacing(int i11) {
        this.mScaledTextSpacing = i11;
        requestLayout();
    }

    public void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public void updateText(int i11, PagerAdapter pagerAdapter) {
        int i12;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i12 = pagerAdapter.getCount();
        } else {
            i12 = 0;
        }
        this.mUpdatingText = true;
        CharSequence charSequence3 = null;
        if (i11 < 1 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.getPageTitle(i11 - 1);
        }
        this.mPrevText.setText(charSequence);
        TextView textView = this.mCurrText;
        if (pagerAdapter == null || i11 >= i12) {
            charSequence2 = null;
        } else {
            charSequence2 = pagerAdapter.getPageTitle(i11);
        }
        textView.setText(charSequence2);
        int i13 = i11 + 1;
        if (i13 < i12 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i13);
        }
        this.mNextText.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mLastKnownCurrentPage = i11;
        if (!this.mUpdatingPositions) {
            updateTextPositions(i11, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    public void updateTextPositions(int i11, float f11, boolean z11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i11;
        float f12 = f11;
        if (i16 != this.mLastKnownCurrentPage) {
            updateText(i16, this.mPager.getAdapter());
        } else if (!z11 && f12 == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int i17 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i18 = paddingRight + i17;
        int i19 = (width - (paddingLeft + i17)) - i18;
        float f13 = 0.5f + f12;
        if (f13 > 1.0f) {
            f13 -= 1.0f;
        }
        int i21 = ((width - i18) - ((int) (((float) i19) * f13))) - i17;
        int i22 = measuredWidth2 + i21;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i23 = max - baseline;
        int i24 = max - baseline2;
        int i25 = max - baseline3;
        int i26 = measuredWidth3;
        int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i23, this.mCurrText.getMeasuredHeight() + i24), this.mNextText.getMeasuredHeight() + i25);
        int i27 = this.mGravity & 112;
        if (i27 == 16) {
            i15 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i27 != 80) {
            i14 = i23 + paddingTop;
            i12 = i24 + paddingTop;
            i13 = paddingTop + i25;
            TextView textView = this.mCurrText;
            textView.layout(i21, i12, i22, textView.getMeasuredHeight() + i12);
            int min = Math.min(paddingLeft, (i21 - this.mScaledTextSpacing) - measuredWidth);
            TextView textView2 = this.mPrevText;
            textView2.layout(min, i14, measuredWidth + min, textView2.getMeasuredHeight() + i14);
            int max3 = Math.max((width - paddingRight) - i26, i22 + this.mScaledTextSpacing);
            TextView textView3 = this.mNextText;
            textView3.layout(max3, i13, max3 + i26, textView3.getMeasuredHeight() + i13);
            this.mLastKnownPositionOffset = f11;
            this.mUpdatingPositions = false;
        } else {
            i15 = (height - paddingBottom) - max2;
        }
        i14 = i23 + i15;
        i12 = i24 + i15;
        i13 = i15 + i25;
        TextView textView4 = this.mCurrText;
        textView4.layout(i21, i12, i22, textView4.getMeasuredHeight() + i12);
        int min2 = Math.min(paddingLeft, (i21 - this.mScaledTextSpacing) - measuredWidth);
        TextView textView22 = this.mPrevText;
        textView22.layout(min2, i14, measuredWidth + min2, textView22.getMeasuredHeight() + i14);
        int max32 = Math.max((width - paddingRight) - i26, i22 + this.mScaledTextSpacing);
        TextView textView32 = this.mNextText;
        textView32.layout(max32, i13, max32 + i26, textView32.getMeasuredHeight() + i13);
        this.mLastKnownPositionOffset = f11;
        this.mUpdatingPositions = false;
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        boolean z11 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z11 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z11) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
