package com.talabat.darkstores.feature.home.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.LoopingPagerAdapter;
import ej.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 B2\u00020\u0001:\u0002BCB\u0013\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b=\u0010AJ:\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0004J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0014\u0010-\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010(R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010(R\u0016\u0010\u001a\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0011\u00108\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006D"}, d2 = {"Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "heightMeasureSpec", "widthMeasureSpec", "width", "Lkotlin/Function2;", "", "callSuper", "wrap", "position", "getRealListPosition", "onMeasure", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "b", "item", "setCurrentItem", "getCurrentItem", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "setAdapter", "resumeAutoScroll", "pauseAutoScroll", "toTheRight", "getSelectingIndicatorPosition", "reset", "Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager$IndicatorPageChangeListener;", "callback", "setIndicatorPageChangeListener", "infinite", "Z", "autoScroll", "wrapContent", "", "aspectRatio", "F", "interval", "I", "previousPosition", "currentPagePosition", "autoScrollResumed", "Landroid/os/Handler;", "autoScrollHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "autoScrollRunnable", "Ljava/lang/Runnable;", "indicatorPageChangeListener", "Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager$IndicatorPageChangeListener;", "previousScrollState", "scrollState", "getIndicatorPosition", "()I", "indicatorPosition", "getIndicatorCount", "indicatorCount", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "IndicatorPageChangeListener", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public class LoopingViewPager extends ViewPager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_INTERVAL = 5000;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private float aspectRatio;
    private boolean autoScroll;
    /* access modifiers changed from: private */
    @NotNull
    public final Handler autoScrollHandler;
    /* access modifiers changed from: private */
    public boolean autoScrollResumed;
    /* access modifiers changed from: private */
    @NotNull
    public final Runnable autoScrollRunnable;
    /* access modifiers changed from: private */
    public int currentPagePosition;
    /* access modifiers changed from: private */
    @Nullable
    public IndicatorPageChangeListener indicatorPageChangeListener;
    /* access modifiers changed from: private */
    public boolean infinite;
    /* access modifiers changed from: private */
    public int interval;
    /* access modifiers changed from: private */
    public int previousPosition;
    /* access modifiers changed from: private */
    public int previousScrollState;
    /* access modifiers changed from: private */
    public int scrollState;
    /* access modifiers changed from: private */
    public boolean toTheRight;
    private boolean wrapContent;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager$Companion;", "", "()V", "DEFAULT_INTERVAL", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/home/banner/LoopingViewPager$IndicatorPageChangeListener;", "", "onIndicatorPageChange", "", "newIndicatorPosition", "", "onIndicatorProgress", "selectingPosition", "progress", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IndicatorPageChangeListener {
        void onIndicatorPageChange(int i11);

        void onIndicatorProgress(int i11, float f11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopingViewPager(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        this.infinite = true;
        this.wrapContent = true;
        this.interval = 5000;
        this.autoScrollHandler = new Handler(Looper.getMainLooper());
        this.autoScrollRunnable = new b(this);
        this.toTheRight = true;
        b();
    }

    /* access modifiers changed from: private */
    /* renamed from: autoScrollRunnable$lambda-1  reason: not valid java name */
    public static final void m9975autoScrollRunnable$lambda1(LoopingViewPager loopingViewPager) {
        Intrinsics.checkNotNullParameter(loopingViewPager, "this$0");
        PagerAdapter adapter = loopingViewPager.getAdapter();
        if (adapter != null && loopingViewPager.autoScroll && adapter.getCount() >= 2) {
            if (loopingViewPager.infinite || adapter.getCount() - 1 != loopingViewPager.currentPagePosition) {
                loopingViewPager.currentPagePosition++;
            } else {
                loopingViewPager.currentPagePosition = 0;
            }
            loopingViewPager.setCurrentItem(loopingViewPager.currentPagePosition, true);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final int getRealListPosition(int i11) {
        PagerAdapter adapter = getAdapter();
        if (adapter == null || !this.infinite) {
            return i11;
        }
        if (i11 == 0) {
            return (adapter.getCount() - 1) - 2;
        }
        if (i11 > adapter.getCount() - 2) {
            return 0;
        }
        return i11 - 1;
    }

    private final int wrap(int i11, int i12, int i13, Function2<? super Integer, ? super Integer, Unit> function2) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            return i11;
        }
        function2.invoke(Integer.valueOf(i12), Integer.valueOf(i11));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((i13 - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int childCount = getChildCount();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            childAt.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i14) {
                i14 = measuredHeight;
            }
        }
        return View.MeasureSpec.makeMeasureSpec(i14 + getPaddingTop() + getPaddingBottom(), 1073741824);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void b() {
        addOnPageChangeListener(new LoopingViewPager$init$1(this));
        if (this.infinite) {
            setCurrentItem(1, false);
        }
    }

    public int getCurrentItem() {
        return getRealListPosition(super.getCurrentItem());
    }

    public final int getIndicatorCount() {
        LoopingPagerAdapter loopingPagerAdapter;
        PagerAdapter adapter = getAdapter();
        if (adapter instanceof LoopingPagerAdapter) {
            loopingPagerAdapter = (LoopingPagerAdapter) adapter;
        } else {
            loopingPagerAdapter = null;
        }
        if (loopingPagerAdapter != null) {
            return loopingPagerAdapter.getListCount();
        }
        PagerAdapter adapter2 = getAdapter();
        if (adapter2 != null) {
            return adapter2.getCount();
        }
        return 0;
    }

    public final int getIndicatorPosition() {
        LoopingPagerAdapter loopingPagerAdapter;
        int i11;
        if (!this.infinite) {
            return this.currentPagePosition;
        }
        PagerAdapter adapter = getAdapter();
        if (adapter instanceof LoopingPagerAdapter) {
            loopingPagerAdapter = (LoopingPagerAdapter) adapter;
        } else {
            loopingPagerAdapter = null;
        }
        if (loopingPagerAdapter == null) {
            return this.currentPagePosition;
        }
        int i12 = this.currentPagePosition;
        if (i12 == 0) {
            i11 = loopingPagerAdapter.getListCount();
        } else if (i12 == loopingPagerAdapter.getLastItemPosition() + 1) {
            return 0;
        } else {
            i11 = this.currentPagePosition;
        }
        return i11 - 1;
    }

    public final int getSelectingIndicatorPosition(boolean z11) {
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i11;
        int i12;
        LoopingPagerAdapter loopingPagerAdapter;
        int i13;
        int i14 = this.scrollState;
        if (i14 == 2) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (i14 == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (this.previousScrollState == 2) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (i14 == 1) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z12 || z13) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z14 || !z15) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z16 || z17) {
            return getIndicatorPosition();
        }
        if (z11) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        if (this.infinite) {
            PagerAdapter adapter = getAdapter();
            if (adapter instanceof LoopingPagerAdapter) {
                loopingPagerAdapter = (LoopingPagerAdapter) adapter;
            } else {
                loopingPagerAdapter = null;
            }
            if (loopingPagerAdapter == null) {
                i12 = this.currentPagePosition;
            } else {
                int i15 = this.currentPagePosition;
                if (i15 == 1 && !z11) {
                    i13 = loopingPagerAdapter.getLastItemPosition();
                } else if (i15 == loopingPagerAdapter.getLastItemPosition() && z11) {
                    return 0;
                } else {
                    i13 = this.currentPagePosition + i11;
                }
                return i13 - 1;
            }
        } else {
            i12 = this.currentPagePosition;
        }
        return i12 + i11;
    }

    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void onMeasure(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        if (this.aspectRatio > 0.0f) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(MathKt__MathJVMKt.roundToInt(((float) View.MeasureSpec.getSize(i11)) / this.aspectRatio), 1073741824));
            return;
        }
        if (this.wrapContent) {
            i12 = wrap(i12, i11, size, new LoopingViewPager$onMeasure$1(this));
        }
        super.onMeasure(i11, i12);
    }

    public final void pauseAutoScroll() {
        this.autoScrollResumed = false;
        this.autoScrollHandler.removeCallbacks(this.autoScrollRunnable);
    }

    public final void reset() {
        int i11 = 0;
        if (this.infinite) {
            setCurrentItem(1, false);
            i11 = 1;
        } else {
            setCurrentItem(0, false);
        }
        this.currentPagePosition = i11;
    }

    public final void resumeAutoScroll() {
        this.autoScrollResumed = true;
        this.autoScrollHandler.postDelayed(this.autoScrollRunnable, (long) this.interval);
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        if (this.infinite) {
            setCurrentItem(1, false);
        }
    }

    public void setCurrentItem(int i11) {
        super.setCurrentItem(i11 + 1);
    }

    public final void setIndicatorPageChangeListener(@Nullable IndicatorPageChangeListener indicatorPageChangeListener2) {
        this.indicatorPageChangeListener = indicatorPageChangeListener2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopingViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.infinite = true;
        this.wrapContent = true;
        this.interval = 5000;
        this.autoScrollHandler = new Handler(Looper.getMainLooper());
        this.autoScrollRunnable = new b(this);
        this.toTheRight = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.LoopingViewPager, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…e.LoopingViewPager, 0, 0)");
        try {
            this.infinite = obtainStyledAttributes.getBoolean(R.styleable.LoopingViewPager_isInfinite, false);
            this.autoScroll = obtainStyledAttributes.getBoolean(R.styleable.LoopingViewPager_autoScroll, false);
            this.wrapContent = obtainStyledAttributes.getBoolean(R.styleable.LoopingViewPager_wrap_content, true);
            this.interval = obtainStyledAttributes.getInt(R.styleable.LoopingViewPager_scrollInterval, 5000);
            this.aspectRatio = obtainStyledAttributes.getFloat(R.styleable.LoopingViewPager_viewpagerAspectRatio, 0.0f);
            this.autoScrollResumed = this.autoScroll;
            obtainStyledAttributes.recycle();
            b();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
