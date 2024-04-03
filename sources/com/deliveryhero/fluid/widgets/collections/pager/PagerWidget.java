package com.deliveryhero.fluid.widgets.collections.pager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorWidget;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/PagerWidget;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerBaseWidget;", "context", "Landroid/content/Context;", "host", "Lcom/deliveryhero/fluid/Host;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Lcom/deliveryhero/fluid/Host;Landroid/util/AttributeSet;I)V", "value", "", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "cells", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "indicator", "Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorWidget;", "getIndicator", "()Lcom/deliveryhero/fluid/widgets/collections/pager/indicators/PagerDotsIndicatorWidget;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
public class PagerWidget extends PagerBaseWidget {
    @NotNull
    private final PagerDotsIndicatorWidget indicator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerWidget(Context context, Host host, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, host, (i12 & 4) != 0 ? null : attributeSet, (i12 & 8) != 0 ? 0 : i11);
    }

    @NotNull
    public final List<PagerCell> getCells() {
        return getAdapter().getCells();
    }

    @NotNull
    public final PagerDotsIndicatorWidget getIndicator() {
        return this.indicator;
    }

    public final void setCells(@NotNull List<PagerCell> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        getAdapter().submitList(list);
        setPagesHeight(list);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerWidget(@NotNull Context context, @NotNull Host host, @Nullable AttributeSet attributeSet, int i11) {
        super(context, host, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        PagerDotsIndicatorWidget pagerDotsIndicatorWidget = new PagerDotsIndicatorWidget(context, (Boolean) null, 2, (DefaultConstructorMarker) null);
        this.indicator = pagerDotsIndicatorWidget;
        getInternalPager().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PagerWidget f30263a;

            {
                this.f30263a = r1;
            }

            public void onPageSelected(int i11) {
                this.f30263a.getScrollHandler().invoke();
            }
        });
        addView(pagerDotsIndicatorWidget, new LinearLayout.LayoutParams(-2, -2));
        pagerDotsIndicatorWidget.init(getInternalPager());
    }
}
