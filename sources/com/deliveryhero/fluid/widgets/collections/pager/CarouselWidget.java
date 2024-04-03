package com.deliveryhero.fluid.widgets.collections.pager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;
import c5.b;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorWidget;
import com.deliveryhero.fluid.widgets.utils.LayoutParamsUtilsKt;
import com.deliveryhero.fluid.widgets.utils.WidgetUtilsKt;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselWidget;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerBaseWidget;", "context", "Landroid/content/Context;", "host", "Lcom/deliveryhero/fluid/Host;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Lcom/deliveryhero/fluid/Host;Landroid/util/AttributeSet;I)V", "value", "Lcom/deliveryhero/fluid/values/Size;", "carouselPadding", "getCarouselPadding", "()Lcom/deliveryhero/fluid/values/Size;", "setCarouselPadding", "(Lcom/deliveryhero/fluid/values/Size;)V", "", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "cells", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "indicator", "Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorWidget;", "getIndicator", "()Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorWidget;", "setWidgetPadding", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
public class CarouselWidget extends PagerBaseWidget {
    @Nullable
    private Size carouselPadding;
    @NotNull
    private final PagerDotsIndicatorWidget indicator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselWidget(Context context, Host host, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, host, (i12 & 4) != 0 ? null : attributeSet, (i12 & 8) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    public final void setWidgetPadding(Size size) {
        ViewGroup viewGroup;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.post(new b(size, this, viewGroup));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setWidgetPadding$lambda-1  reason: not valid java name */
    public static final void m8211setWidgetPadding$lambda1(Size size, CarouselWidget carouselWidget, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(size, "$value");
        Intrinsics.checkNotNullParameter(carouselWidget, "this$0");
        Context context = carouselWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int width = (viewGroup.getWidth() - LayoutParamsUtilsKt.toLayoutSize(size, context, viewGroup.getMeasuredWidth())) / 2;
        WidgetUtilsKt.updatePaddings(carouselWidget.getInternalPager(), width, 0, width, 0);
        carouselWidget.getInternalPager().setCurrentItem(1, false);
    }

    @Nullable
    public final Size getCarouselPadding() {
        return this.carouselPadding;
    }

    @NotNull
    public List<PagerCell> getCells() {
        return getAdapter().getCells();
    }

    @NotNull
    public final PagerDotsIndicatorWidget getIndicator() {
        return this.indicator;
    }

    public final void setCarouselPadding(@Nullable Size size) {
        this.carouselPadding = size;
        if (size != null && (size instanceof Size.Relative)) {
            if (ViewCompat.isAttachedToWindow(this)) {
                setWidgetPadding(size);
            } else {
                addOnAttachStateChangeListener(new CarouselWidget$special$$inlined$doOnAttach$1(this, this, size));
            }
        }
    }

    public void setCells(@NotNull List<PagerCell> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        if (!list.isEmpty()) {
            getAdapter().submitList(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(CollectionsKt___CollectionsKt.last(list)), list), CollectionsKt___CollectionsKt.first(list)));
            setPagesHeight(list);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselWidget(@NotNull Context context, @NotNull Host host, @Nullable AttributeSet attributeSet, int i11) {
        super(context, host, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        PagerDotsIndicatorWidget pagerDotsIndicatorWidget = new PagerDotsIndicatorWidget(context, Boolean.TRUE);
        this.indicator = pagerDotsIndicatorWidget;
        getInternalPager().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CarouselWidget f30256a;
            private int currentPosition;

            {
                this.f30256a = r1;
            }

            public void onPageScrollStateChanged(int i11) {
                if (i11 == 0) {
                    int size = this.f30256a.getCells().size();
                    int i12 = this.currentPosition;
                    if (i12 == 0) {
                        this.f30256a.getInternalPager().setCurrentItem(size - 2, false);
                    } else if (i12 == size - 1) {
                        this.f30256a.getInternalPager().setCurrentItem(1, false);
                    }
                }
            }

            public void onPageSelected(int i11) {
                this.currentPosition = i11;
                this.f30256a.getScrollHandler().invoke();
            }
        });
        getInternalPager().setOverScrollMode(2);
        getInternalPager().setOffscreenPageLimit(3);
        getInternalPager().setClipChildren(false);
        getInternalPager().setClipToPadding(false);
        addView(pagerDotsIndicatorWidget, new LinearLayout.LayoutParams(-2, -2));
        pagerDotsIndicatorWidget.init(getInternalPager());
    }
}
