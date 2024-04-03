package com.deliveryhero.fluid.widgets.collections.pager.indicators;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import d5.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020#J\f\u0010'\u001a\u00020#*\u00020(H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006)"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorWidget;", "Lcom/google/android/material/tabs/TabLayout;", "context", "Landroid/content/Context;", "isCarousel", "", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "activeColor", "Lcom/deliveryhero/fluid/values/Color;", "getActiveColor", "()Lcom/deliveryhero/fluid/values/Color;", "setActiveColor", "(Lcom/deliveryhero/fluid/values/Color;)V", "inActiveColor", "getInActiveColor", "setInActiveColor", "Ljava/lang/Boolean;", "pagerCount", "", "getPagerCount", "()I", "setPagerCount", "(I)V", "size", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "getSize", "()Lcom/deliveryhero/fluid/values/LogicalPixel;", "setSize", "(Lcom/deliveryhero/fluid/values/LogicalPixel;)V", "spacing", "getSpacing", "setSpacing", "createDotBackground", "Landroid/graphics/drawable/StateListDrawable;", "init", "", "pager", "Landroidx/viewpager2/widget/ViewPager2;", "refresh", "applyProps", "Lcom/google/android/material/tabs/TabLayout$Tab;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PagerDotsIndicatorWidget extends TabLayout {
    @NotNull
    private Color activeColor;
    @NotNull
    private Color inActiveColor;
    @Nullable
    private final Boolean isCarousel;
    private int pagerCount;
    @NotNull
    private LogicalPixel size;
    @NotNull
    private LogicalPixel spacing;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerDotsIndicatorWidget(@NotNull Context context, @Nullable Boolean bool) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isCarousel = bool;
        Color.Companion companion = Color.Companion;
        this.activeColor = companion.getOPAQUE_BLACK();
        this.inActiveColor = companion.getOPAQUE_WHITE();
        LogicalPixel.Companion companion2 = LogicalPixel.Companion;
        this.size = companion2.getZERO();
        this.spacing = companion2.getZERO();
    }

    private final void applyProps(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        if (customView != null) {
            ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
            if (layoutParams != null) {
                LogicalPixel logicalPixel = this.size;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                layoutParams.width = (int) TypedValue.applyDimension(1, logicalPixel.getValue(), context.getResources().getDisplayMetrics());
                LogicalPixel logicalPixel2 = this.size;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                layoutParams.height = (int) TypedValue.applyDimension(1, logicalPixel2.getValue(), context2.getResources().getDisplayMetrics());
                customView.setLayoutParams(layoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        View customView2 = tab.getCustomView();
        if (customView2 != null) {
            customView2.setBackground(createDotBackground());
        }
        TabLayout.TabView tabView = tab.view;
        LogicalPixel logicalPixel3 = this.spacing;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        tabView.setPadding((int) TypedValue.applyDimension(1, logicalPixel3.getValue(), context3.getResources().getDisplayMetrics()), 0, 0, 0);
    }

    private final StateListDrawable createDotBackground() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(this.activeColor.getArgb());
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
        shapeDrawable2.getPaint().setColor(this.inActiveColor.getArgb());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, shapeDrawable);
        stateListDrawable.addState(new int[0], shapeDrawable2);
        return stateListDrawable;
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1  reason: not valid java name */
    public static final void m8218init$lambda1(PagerDotsIndicatorWidget pagerDotsIndicatorWidget, ViewPager2 viewPager2, TabLayout.Tab tab, int i11) {
        Integer num;
        Intrinsics.checkNotNullParameter(pagerDotsIndicatorWidget, "this$0");
        Intrinsics.checkNotNullParameter(viewPager2, "$pager");
        Intrinsics.checkNotNullParameter(tab, "tab");
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            num = Integer.valueOf(adapter.getItemCount());
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        pagerDotsIndicatorWidget.pagerCount = num.intValue();
        View view = new View(pagerDotsIndicatorWidget.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        tab.setCustomView(view);
        if ((i11 != 0 && i11 != pagerDotsIndicatorWidget.pagerCount - 1) || Intrinsics.areEqual((Object) pagerDotsIndicatorWidget.isCarousel, (Object) Boolean.FALSE)) {
            pagerDotsIndicatorWidget.applyProps(tab);
        }
    }

    @NotNull
    public final Color getActiveColor() {
        return this.activeColor;
    }

    @NotNull
    public final Color getInActiveColor() {
        return this.inActiveColor;
    }

    public final int getPagerCount() {
        return this.pagerCount;
    }

    @NotNull
    public final LogicalPixel getSize() {
        return this.size;
    }

    @NotNull
    public final LogicalPixel getSpacing() {
        return this.spacing;
    }

    public final void init(@NotNull ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "pager");
        setTabRippleColor((ColorStateList) null);
        setSelectedTabIndicator((Drawable) null);
        setTabGravity(1);
        new TabLayoutMediator(this, viewPager2, new a(this, viewPager2)).attach();
    }

    public final void refresh() {
        if (Intrinsics.areEqual((Object) this.isCarousel, (Object) Boolean.TRUE)) {
            int tabCount = getTabCount() - 1;
            for (int i11 = 1; i11 < tabCount; i11++) {
                TabLayout.Tab tabAt = getTabAt(i11);
                if (tabAt != null) {
                    applyProps(tabAt);
                }
            }
        } else {
            int tabCount2 = getTabCount();
            for (int i12 = 0; i12 < tabCount2; i12++) {
                TabLayout.Tab tabAt2 = getTabAt(i12);
                if (tabAt2 != null) {
                    applyProps(tabAt2);
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            LogicalPixel logicalPixel = this.size;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            layoutParams.height = (int) TypedValue.applyDimension(1, logicalPixel.getValue(), context.getResources().getDisplayMetrics());
            setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setActiveColor(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.activeColor = color;
    }

    public final void setInActiveColor(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.inActiveColor = color;
    }

    public final void setPagerCount(int i11) {
        this.pagerCount = i11;
    }

    public final void setSize(@NotNull LogicalPixel logicalPixel) {
        Intrinsics.checkNotNullParameter(logicalPixel, "<set-?>");
        this.size = logicalPixel;
    }

    public final void setSpacing(@NotNull LogicalPixel logicalPixel) {
        Intrinsics.checkNotNullParameter(logicalPixel, "<set-?>");
        this.spacing = logicalPixel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerDotsIndicatorWidget(Context context, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? Boolean.FALSE : bool);
    }
}
