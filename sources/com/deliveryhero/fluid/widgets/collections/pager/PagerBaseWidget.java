package com.deliveryhero.fluid.widgets.collections.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.utils.ContextUtilsKt;
import com.deliveryhero.fluid.widgets.collections.CellAdapter;
import com.deliveryhero.fluid.widgets.collections.VisibilityObserver;
import com.facebook.internal.NativeProtocol;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0016J\u0016\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\nJ!\u0010:\u001a\u00020(2\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<\"\u00020=H\u0002¢\u0006\u0002\u0010>J\u0014\u0010?\u001a\u00020(2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0AR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0019\u001a\u00060\nj\u0002`\u00182\n\u0010\u0017\u001a\u00060\nj\u0002`\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR \u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/PagerBaseWidget;", "Landroid/widget/LinearLayout;", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver;", "context", "Landroid/content/Context;", "host", "Lcom/deliveryhero/fluid/Host;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Lcom/deliveryhero/fluid/Host;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/deliveryhero/fluid/widgets/collections/CellAdapter;", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "getAdapter", "()Lcom/deliveryhero/fluid/widgets/collections/CellAdapter;", "autoScroller", "Lcom/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller;", "getAutoScroller", "()Lcom/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller;", "setAutoScroller", "(Lcom/deliveryhero/fluid/widgets/collections/pager/PagerAutoScroller;)V", "value", "Lcom/deliveryhero/fluid/values/PixelInt;", "cellSpacing", "getCellSpacing", "()I", "setCellSpacing", "(I)V", "firstVisiblePosition", "getFirstVisiblePosition", "internalPager", "Landroidx/viewpager2/widget/ViewPager2;", "getInternalPager", "()Landroidx/viewpager2/widget/ViewPager2;", "lastVisiblePosition", "getLastVisiblePosition", "scrollHandler", "Lkotlin/Function0;", "", "getScrollHandler", "()Lkotlin/jvm/functions/Function0;", "setScrollHandler", "(Lkotlin/jvm/functions/Function0;)V", "addView", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "onViewAppearedOnScreen", "reason", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver$Reason;", "onViewDisappearedFromScreen", "setAutoScroll", "enabled", "", "delayMillis", "setPageTransformer", "transformers", "", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "([Landroidx/viewpager2/widget/ViewPager2$PageTransformer;)V", "setPagesHeight", "cells", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PagerBaseWidget extends LinearLayout implements VisibilityObserver {
    @NotNull
    private final CellAdapter<PagerCell> adapter;
    @Nullable
    private PagerAutoScroller autoScroller;
    private int cellSpacing;
    @NotNull
    private final ViewPager2 internalPager;
    @NotNull
    private Function0<Unit> scrollHandler;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerBaseWidget(Context context, Host host, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, host, (i12 & 4) != 0 ? null : attributeSet, (i12 & 8) != 0 ? 0 : i11);
    }

    private final void setPageTransformer(ViewPager2.PageTransformer... pageTransformerArr) {
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        for (ViewPager2.PageTransformer addTransformer : pageTransformerArr) {
            compositePageTransformer.addTransformer(addTransformer);
        }
        this.internalPager.setPageTransformer(compositePageTransformer);
    }

    public final void addView(@NotNull View view, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        super.addView(view, layoutParams);
    }

    @NotNull
    public final CellAdapter<PagerCell> getAdapter() {
        return this.adapter;
    }

    @Nullable
    public final PagerAutoScroller getAutoScroller() {
        return this.autoScroller;
    }

    public final int getCellSpacing() {
        return this.cellSpacing;
    }

    public final int getFirstVisiblePosition() {
        return this.internalPager.getCurrentItem();
    }

    @NotNull
    public final ViewPager2 getInternalPager() {
        return this.internalPager;
    }

    public final int getLastVisiblePosition() {
        return this.internalPager.getCurrentItem();
    }

    @NotNull
    public final Function0<Unit> getScrollHandler() {
        return this.scrollHandler;
    }

    public void onViewAppearedOnScreen(@NotNull VisibilityObserver.Reason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        PagerAutoScroller pagerAutoScroller = this.autoScroller;
        if (pagerAutoScroller != null) {
            pagerAutoScroller.startScrolling();
        }
    }

    public void onViewDisappearedFromScreen(@NotNull VisibilityObserver.Reason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        PagerAutoScroller pagerAutoScroller = this.autoScroller;
        if (pagerAutoScroller != null) {
            pagerAutoScroller.stopScrolling();
        }
    }

    public final void setAutoScroll(boolean z11, int i11) {
        PagerAutoScroller pagerAutoScroller;
        if (z11) {
            pagerAutoScroller = new PagerAutoScroller(this, (long) i11);
            pagerAutoScroller.enable();
        } else {
            PagerAutoScroller pagerAutoScroller2 = this.autoScroller;
            if (pagerAutoScroller2 != null) {
                pagerAutoScroller2.disable();
            }
            pagerAutoScroller = null;
        }
        this.autoScroller = pagerAutoScroller;
    }

    public final void setAutoScroller(@Nullable PagerAutoScroller pagerAutoScroller) {
        this.autoScroller = pagerAutoScroller;
    }

    public final void setCellSpacing(int i11) {
        this.cellSpacing = i11;
        setPageTransformer(new MarginPageTransformer(i11));
    }

    public final void setPagesHeight(@NotNull List<PagerCell> list) {
        Float f11;
        float f12;
        Intrinsics.checkNotNullParameter(list, ComponentMapper.CELLS);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            f11 = null;
        } else {
            float value = ((PagerCell) it.next()).m8216getHeightG78lpEE().getValue();
            while (it.hasNext()) {
                value = Math.max(value, ((PagerCell) it.next()).m8216getHeightG78lpEE().getValue());
            }
            f11 = Float.valueOf(value);
        }
        if (f11 != null) {
            f12 = f11.floatValue();
        } else {
            f12 = 0.0f;
        }
        ViewPager2 viewPager2 = this.internalPager;
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        if (layoutParams != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            layoutParams.height = ContextUtilsKt.dpToPx(f12, context);
            viewPager2.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setScrollHandler(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.scrollHandler = function0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerBaseWidget(@NotNull Context context, @NotNull Host host, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.internalPager = viewPager2;
        CellAdapter<PagerCell> cellAdapter = new CellAdapter<>(host);
        this.adapter = cellAdapter;
        this.scrollHandler = PagerBaseWidget$scrollHandler$1.INSTANCE;
        setOrientation(1);
        setGravity(1);
        addView(viewPager2, new LinearLayout.LayoutParams(-1, 0));
        viewPager2.setAdapter(cellAdapter);
    }
}
