package com.rd;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.TextUtilsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.rd.IndicatorManager;
import com.rd.animation.data.Value;
import com.rd.animation.type.AnimationType;
import com.rd.draw.controller.DrawController;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.PositionSavedState;
import com.rd.draw.data.RtlMode;
import com.rd.utils.CoordinatesUtils;
import com.rd.utils.DensityUtils;
import com.rd.utils.IdUtils;

public class PageIndicatorView extends View implements ViewPager.OnPageChangeListener, IndicatorManager.Listener, ViewPager.OnAdapterChangeListener, View.OnTouchListener {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private Runnable idleRunnable = new Runnable() {
        public void run() {
            PageIndicatorView.this.manager.indicator().setIdle(true);
            PageIndicatorView.this.hideWithAnimation();
        }
    };
    private boolean isInteractionEnabled;
    /* access modifiers changed from: private */
    public IndicatorManager manager;
    private DataSetObserver setObserver;
    private ViewPager viewPager;

    /* renamed from: com.rd.PageIndicatorView$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52886a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.rd.draw.data.RtlMode[] r0 = com.rd.draw.data.RtlMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52886a = r0
                com.rd.draw.data.RtlMode r1 = com.rd.draw.data.RtlMode.On     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52886a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.rd.draw.data.RtlMode r1 = com.rd.draw.data.RtlMode.Off     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f52886a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.rd.draw.data.RtlMode r1 = com.rd.draw.data.RtlMode.Auto     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.PageIndicatorView.AnonymousClass3.<clinit>():void");
        }
    }

    public PageIndicatorView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private int adjustPosition(int i11) {
        int count = this.manager.indicator().getCount() - 1;
        if (i11 < 0) {
            return 0;
        }
        if (i11 > count) {
            return count;
        }
        return i11;
    }

    private void displayWithAnimation() {
        animate().cancel();
        animate().alpha(1.0f).setDuration(250);
    }

    private void findViewPager(@Nullable ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup) && ((ViewGroup) viewParent).getChildCount() > 0) {
            ViewPager findViewPager = findViewPager((ViewGroup) viewParent, this.manager.indicator().getViewPagerId());
            if (findViewPager != null) {
                setViewPager(findViewPager);
            } else {
                findViewPager(viewParent.getParent());
            }
        }
    }

    /* access modifiers changed from: private */
    public void hideWithAnimation() {
        animate().cancel();
        animate().alpha(0.0f).setDuration(250);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        setupId();
        initIndicatorManager(attributeSet);
        if (this.manager.indicator().isFadeOnIdle()) {
            startIdleRunnable();
        }
    }

    private void initIndicatorManager(@Nullable AttributeSet attributeSet) {
        IndicatorManager indicatorManager = new IndicatorManager(this);
        this.manager = indicatorManager;
        indicatorManager.drawer().initAttributes(getContext(), attributeSet);
        Indicator indicator = this.manager.indicator();
        indicator.setPaddingLeft(getPaddingLeft());
        indicator.setPaddingTop(getPaddingTop());
        indicator.setPaddingRight(getPaddingRight());
        indicator.setPaddingBottom(getPaddingBottom());
        this.isInteractionEnabled = indicator.isInteractiveAnimation();
    }

    private boolean isRtl() {
        int i11 = AnonymousClass3.f52886a[this.manager.indicator().getRtlMode().ordinal()];
        if (i11 == 1) {
            return true;
        }
        if (i11 != 3) {
            return false;
        }
        if (TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1) {
            return true;
        }
        return false;
    }

    private boolean isViewMeasured() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    private void onPageScroll(int i11, float f11) {
        boolean z11;
        Indicator indicator = this.manager.indicator();
        AnimationType animationType = indicator.getAnimationType();
        boolean isInteractiveAnimation = indicator.isInteractiveAnimation();
        if (!isViewMeasured() || !isInteractiveAnimation || animationType == AnimationType.NONE) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            Pair<Integer, Float> progress = CoordinatesUtils.getProgress(indicator, i11, f11, isRtl());
            setProgress(((Integer) progress.first).intValue(), ((Float) progress.second).floatValue());
        }
    }

    private void onPageSelect(int i11) {
        Indicator indicator = this.manager.indicator();
        boolean isViewMeasured = isViewMeasured();
        int count = indicator.getCount();
        if (isViewMeasured) {
            if (isRtl()) {
                i11 = (count - 1) - i11;
            }
            setSelection(i11);
        }
    }

    private void registerSetObserver() {
        ViewPager viewPager2;
        if (this.setObserver == null && (viewPager2 = this.viewPager) != null && viewPager2.getAdapter() != null) {
            this.setObserver = new DataSetObserver() {
                public void onChanged() {
                    PageIndicatorView.this.updateState();
                }
            };
            try {
                this.viewPager.getAdapter().registerDataSetObserver(this.setObserver);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            }
        }
    }

    private void setupId() {
        if (getId() == -1) {
            setId(IdUtils.generateViewId());
        }
    }

    private void startIdleRunnable() {
        Handler handler = HANDLER;
        handler.removeCallbacks(this.idleRunnable);
        handler.postDelayed(this.idleRunnable, this.manager.indicator().getIdleDuration());
    }

    private void stopIdleRunnable() {
        HANDLER.removeCallbacks(this.idleRunnable);
        displayWithAnimation();
    }

    private void unRegisterSetObserver() {
        ViewPager viewPager2;
        if (this.setObserver != null && (viewPager2 = this.viewPager) != null && viewPager2.getAdapter() != null) {
            try {
                this.viewPager.getAdapter().unregisterDataSetObserver(this.setObserver);
                this.setObserver = null;
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateState() {
        int i11;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            int count = this.viewPager.getAdapter().getCount();
            if (isRtl()) {
                i11 = (count - 1) - this.viewPager.getCurrentItem();
            } else {
                i11 = this.viewPager.getCurrentItem();
            }
            this.manager.indicator().setSelectedPosition(i11);
            this.manager.indicator().setSelectingPosition(i11);
            this.manager.indicator().setLastSelectedPosition(i11);
            this.manager.indicator().setCount(count);
            this.manager.animate().end();
            updateVisibility();
            requestLayout();
        }
    }

    private void updateVisibility() {
        if (this.manager.indicator().isAutoVisibility()) {
            int count = this.manager.indicator().getCount();
            int visibility = getVisibility();
            if (visibility != 0 && count > 1) {
                setVisibility(0);
            } else if (visibility != 4 && count <= 1) {
                setVisibility(4);
            }
        }
    }

    public void clearSelection() {
        Indicator indicator = this.manager.indicator();
        indicator.setInteractiveAnimation(false);
        indicator.setLastSelectedPosition(-1);
        indicator.setSelectingPosition(-1);
        indicator.setSelectedPosition(-1);
        this.manager.animate().basic();
    }

    public long getAnimationDuration() {
        return this.manager.indicator().getAnimationDuration();
    }

    public int getCount() {
        return this.manager.indicator().getCount();
    }

    public int getPadding() {
        return this.manager.indicator().getPadding();
    }

    public int getRadius() {
        return this.manager.indicator().getRadius();
    }

    public float getScaleFactor() {
        return this.manager.indicator().getScaleFactor();
    }

    public int getSelectedColor() {
        return this.manager.indicator().getSelectedColor();
    }

    public int getSelection() {
        return this.manager.indicator().getSelectedPosition();
    }

    public int getStrokeWidth() {
        return this.manager.indicator().getStroke();
    }

    public int getUnselectedColor() {
        return this.manager.indicator().getUnselectedColor();
    }

    public void onAdapterChanged(@NonNull ViewPager viewPager2, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
        DataSetObserver dataSetObserver;
        if (this.manager.indicator().isDynamicCount()) {
            if (!(pagerAdapter == null || (dataSetObserver = this.setObserver) == null)) {
                pagerAdapter.unregisterDataSetObserver(dataSetObserver);
                this.setObserver = null;
            }
            registerSetObserver();
        }
        updateState();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        findViewPager(getParent());
    }

    public void onDetachedFromWindow() {
        unRegisterSetObserver();
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        this.manager.drawer().draw(canvas);
    }

    public void onIndicatorUpdated() {
        invalidate();
    }

    public void onMeasure(int i11, int i12) {
        Pair<Integer, Integer> measureViewSize = this.manager.drawer().measureViewSize(i11, i12);
        setMeasuredDimension(((Integer) measureViewSize.first).intValue(), ((Integer) measureViewSize.second).intValue());
    }

    public void onPageScrollStateChanged(int i11) {
        if (i11 == 0) {
            this.manager.indicator().setInteractiveAnimation(this.isInteractionEnabled);
        }
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        onPageScroll(i11, f11);
    }

    public void onPageSelected(int i11) {
        onPageSelect(i11);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof PositionSavedState) {
            Indicator indicator = this.manager.indicator();
            PositionSavedState positionSavedState = (PositionSavedState) parcelable;
            indicator.setSelectedPosition(positionSavedState.getSelectedPosition());
            indicator.setSelectingPosition(positionSavedState.getSelectingPosition());
            indicator.setLastSelectedPosition(positionSavedState.getLastSelectedPosition());
            super.onRestoreInstanceState(positionSavedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Indicator indicator = this.manager.indicator();
        PositionSavedState positionSavedState = new PositionSavedState(super.onSaveInstanceState());
        positionSavedState.setSelectedPosition(indicator.getSelectedPosition());
        positionSavedState.setSelectingPosition(indicator.getSelectingPosition());
        positionSavedState.setLastSelectedPosition(indicator.getLastSelectedPosition());
        return positionSavedState;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.manager.indicator().isFadeOnIdle()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            stopIdleRunnable();
        } else if (action == 1) {
            startIdleRunnable();
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.manager.drawer().touch(motionEvent);
        return true;
    }

    public void releaseViewPager() {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
            this.viewPager.removeOnAdapterChangeListener(this);
            this.viewPager = null;
        }
    }

    public void setAnimationDuration(long j11) {
        this.manager.indicator().setAnimationDuration(j11);
    }

    public void setAnimationType(@Nullable AnimationType animationType) {
        this.manager.onValueUpdated((Value) null);
        if (animationType != null) {
            this.manager.indicator().setAnimationType(animationType);
        } else {
            this.manager.indicator().setAnimationType(AnimationType.NONE);
        }
        invalidate();
    }

    public void setAutoVisibility(boolean z11) {
        if (!z11) {
            setVisibility(0);
        }
        this.manager.indicator().setAutoVisibility(z11);
        updateVisibility();
    }

    public void setClickListener(@Nullable DrawController.ClickListener clickListener) {
        this.manager.drawer().setClickListener(clickListener);
    }

    public void setCount(int i11) {
        if (i11 >= 0 && this.manager.indicator().getCount() != i11) {
            this.manager.indicator().setCount(i11);
            updateVisibility();
            requestLayout();
        }
    }

    public void setDynamicCount(boolean z11) {
        this.manager.indicator().setDynamicCount(z11);
        if (z11) {
            registerSetObserver();
        } else {
            unRegisterSetObserver();
        }
    }

    public void setFadeOnIdle(boolean z11) {
        this.manager.indicator().setFadeOnIdle(z11);
        if (z11) {
            startIdleRunnable();
        } else {
            stopIdleRunnable();
        }
    }

    public void setIdleDuration(long j11) {
        this.manager.indicator().setIdleDuration(j11);
        if (this.manager.indicator().isFadeOnIdle()) {
            startIdleRunnable();
        } else {
            stopIdleRunnable();
        }
    }

    public void setInteractiveAnimation(boolean z11) {
        this.manager.indicator().setInteractiveAnimation(z11);
        this.isInteractionEnabled = z11;
    }

    public void setOrientation(@Nullable Orientation orientation) {
        if (orientation != null) {
            this.manager.indicator().setOrientation(orientation);
            requestLayout();
        }
    }

    public void setPadding(int i11) {
        if (i11 < 0) {
            i11 = 0;
        }
        this.manager.indicator().setPadding(DensityUtils.dpToPx(i11));
        invalidate();
    }

    public void setProgress(int i11, float f11) {
        Indicator indicator = this.manager.indicator();
        if (indicator.isInteractiveAnimation()) {
            int count = indicator.getCount();
            if (count <= 0 || i11 < 0) {
                i11 = 0;
            } else {
                int i12 = count - 1;
                if (i11 > i12) {
                    i11 = i12;
                }
            }
            if (f11 < 0.0f) {
                f11 = 0.0f;
            } else if (f11 > 1.0f) {
                f11 = 1.0f;
            }
            if (f11 == 1.0f) {
                indicator.setLastSelectedPosition(indicator.getSelectedPosition());
                indicator.setSelectedPosition(i11);
            }
            indicator.setSelectingPosition(i11);
            this.manager.animate().interactive(f11);
        }
    }

    public void setRadius(int i11) {
        if (i11 < 0) {
            i11 = 0;
        }
        this.manager.indicator().setRadius(DensityUtils.dpToPx(i11));
        invalidate();
    }

    public void setRtlMode(@Nullable RtlMode rtlMode) {
        Indicator indicator = this.manager.indicator();
        if (rtlMode == null) {
            indicator.setRtlMode(RtlMode.Off);
        } else {
            indicator.setRtlMode(rtlMode);
        }
        if (this.viewPager != null) {
            int selectedPosition = indicator.getSelectedPosition();
            if (isRtl()) {
                selectedPosition = (indicator.getCount() - 1) - selectedPosition;
            } else {
                ViewPager viewPager2 = this.viewPager;
                if (viewPager2 != null) {
                    selectedPosition = viewPager2.getCurrentItem();
                }
            }
            indicator.setLastSelectedPosition(selectedPosition);
            indicator.setSelectingPosition(selectedPosition);
            indicator.setSelectedPosition(selectedPosition);
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r3 < 0.3f) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setScaleFactor(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0008
        L_0x0006:
            r3 = r0
            goto L_0x0010
        L_0x0008:
            r0 = 1050253722(0x3e99999a, float:0.3)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0010
            goto L_0x0006
        L_0x0010:
            com.rd.IndicatorManager r0 = r2.manager
            com.rd.draw.data.Indicator r0 = r0.indicator()
            r0.setScaleFactor(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rd.PageIndicatorView.setScaleFactor(float):void");
    }

    public void setSelected(int i11) {
        Indicator indicator = this.manager.indicator();
        AnimationType animationType = indicator.getAnimationType();
        indicator.setAnimationType(AnimationType.NONE);
        setSelection(i11);
        indicator.setAnimationType(animationType);
    }

    public void setSelectedColor(int i11) {
        this.manager.indicator().setSelectedColor(i11);
        invalidate();
    }

    public void setSelection(int i11) {
        Indicator indicator = this.manager.indicator();
        int adjustPosition = adjustPosition(i11);
        if (adjustPosition != indicator.getSelectedPosition() && adjustPosition != indicator.getSelectingPosition()) {
            indicator.setInteractiveAnimation(false);
            indicator.setLastSelectedPosition(indicator.getSelectedPosition());
            indicator.setSelectingPosition(adjustPosition);
            indicator.setSelectedPosition(adjustPosition);
            this.manager.animate().basic();
        }
    }

    public void setStrokeWidth(float f11) {
        int radius = this.manager.indicator().getRadius();
        if (f11 < 0.0f) {
            f11 = 0.0f;
        } else {
            float f12 = (float) radius;
            if (f11 > f12) {
                f11 = f12;
            }
        }
        this.manager.indicator().setStroke((int) f11);
        invalidate();
    }

    public void setUnselectedColor(int i11) {
        this.manager.indicator().setUnselectedColor(i11);
        invalidate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setViewPager(@Nullable ViewPager viewPager2) {
        releaseViewPager();
        if (viewPager2 != null) {
            this.viewPager = viewPager2;
            viewPager2.addOnPageChangeListener(this);
            this.viewPager.addOnAdapterChangeListener(this);
            this.viewPager.setOnTouchListener(this);
            this.manager.indicator().setViewPagerId(this.viewPager.getId());
            setDynamicCount(this.manager.indicator().isDynamicCount());
            updateState();
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setPadding(float f11) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.manager.indicator().setPadding((int) f11);
        invalidate();
    }

    public void setRadius(float f11) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.manager.indicator().setRadius((int) f11);
        invalidate();
    }

    public void setStrokeWidth(int i11) {
        int dpToPx = DensityUtils.dpToPx(i11);
        int radius = this.manager.indicator().getRadius();
        if (dpToPx < 0) {
            dpToPx = 0;
        } else if (dpToPx > radius) {
            dpToPx = radius;
        }
        this.manager.indicator().setStroke(dpToPx);
        invalidate();
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet);
    }

    @Nullable
    private ViewPager findViewPager(@NonNull ViewGroup viewGroup, int i11) {
        View findViewById;
        if (viewGroup.getChildCount() > 0 && (findViewById = viewGroup.findViewById(i11)) != null && (findViewById instanceof ViewPager)) {
            return (ViewPager) findViewById;
        }
        return null;
    }

    @TargetApi(21)
    public PageIndicatorView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(attributeSet);
    }
}
