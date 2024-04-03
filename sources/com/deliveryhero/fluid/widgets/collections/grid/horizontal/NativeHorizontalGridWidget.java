package com.deliveryhero.fluid.widgets.collections.grid.horizontal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.widgets.collections.CellAdapter;
import com.deliveryhero.fluid.widgets.collections.CollectionItemAnimator;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z4.b;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000201H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a\u00060\tj\u0002`\u000f2\n\u0010\u000e\u001a\u00060\tj\u0002`\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R \u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "host", "Lcom/deliveryhero/fluid/Host;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Lcom/deliveryhero/fluid/Host;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/deliveryhero/fluid/widgets/collections/CellAdapter;", "Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridCell;", "value", "Lcom/deliveryhero/fluid/values/PixelInt;", "cellSpacing", "getCellSpacing", "()I", "setCellSpacing", "(I)V", "", "cells", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "firstVisiblePosition", "getFirstVisiblePosition", "lastVisiblePosition", "getLastVisiblePosition", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rowsCount", "getRowsCount", "setRowsCount", "scrollHandler", "Lkotlin/Function0;", "", "getScrollHandler", "()Lkotlin/jvm/functions/Function0;", "setScrollHandler", "(Lkotlin/jvm/functions/Function0;)V", "spacingDecoration", "Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridSpacingDecoration;", "setClipChildren", "clipChildren", "", "setClipToPadding", "clipToPadding", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
public final class NativeHorizontalGridWidget extends FrameLayout {
    @NotNull
    private final CellAdapter<NativeHorizontalGridCell> adapter;
    private int cellSpacing;
    @NotNull
    private final StaggeredGridLayoutManager layoutManager;
    @NotNull
    private final RecyclerView recyclerView;
    private int rowsCount;
    @NotNull
    private Function0<Unit> scrollHandler;
    @NotNull
    private final NativeHorizontalGridSpacingDecoration spacingDecoration;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NativeHorizontalGridWidget(Context context, Host host, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, host, (i12 & 4) != 0 ? null : attributeSet, (i12 & 8) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_cells_$lambda-0  reason: not valid java name */
    public static final void m8205_set_cells_$lambda0() {
    }

    public final int getCellSpacing() {
        return this.cellSpacing;
    }

    @NotNull
    public final List<NativeHorizontalGridCell> getCells() {
        return this.adapter.getCells();
    }

    public final int getFirstVisiblePosition() {
        int[] findFirstVisibleItemPositions = this.layoutManager.findFirstVisibleItemPositions((int[]) null);
        Intrinsics.checkNotNullExpressionValue(findFirstVisibleItemPositions, "layoutManager.findFirstVisibleItemPositions(null)");
        Integer minOrNull = ArraysKt___ArraysKt.minOrNull(findFirstVisibleItemPositions);
        if (minOrNull != null) {
            return minOrNull.intValue();
        }
        return -1;
    }

    public final int getLastVisiblePosition() {
        int[] findLastVisibleItemPositions = this.layoutManager.findLastVisibleItemPositions((int[]) null);
        Intrinsics.checkNotNullExpressionValue(findLastVisibleItemPositions, "layoutManager.findLastVisibleItemPositions(null)");
        Integer maxOrNull = ArraysKt___ArraysKt.maxOrNull(findLastVisibleItemPositions);
        if (maxOrNull != null) {
            return maxOrNull.intValue();
        }
        return -1;
    }

    public final int getRowsCount() {
        return this.rowsCount;
    }

    @NotNull
    public final Function0<Unit> getScrollHandler() {
        return this.scrollHandler;
    }

    public final void setCellSpacing(int i11) {
        this.cellSpacing = i11;
        this.spacingDecoration.setVerticalSpacing(i11);
        this.spacingDecoration.setHorizontalSpacing(i11);
        this.recyclerView.invalidateItemDecorations();
    }

    public final void setCells(@NotNull List<NativeHorizontalGridCell> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.adapter.submitList(list, new b());
    }

    public void setClipChildren(boolean z11) {
        super.setClipChildren(z11);
        this.recyclerView.setClipChildren(z11);
    }

    public void setClipToPadding(boolean z11) {
        super.setClipToPadding(z11);
        this.recyclerView.setClipToPadding(z11);
    }

    public final void setRowsCount(int i11) {
        this.rowsCount = i11;
        this.layoutManager.setSpanCount(i11);
    }

    public final void setScrollHandler(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.scrollHandler = function0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeHorizontalGridWidget(@NotNull Context context, @NotNull Host host, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        RecyclerView recyclerView2 = new RecyclerView(context);
        this.recyclerView = recyclerView2;
        CellAdapter<NativeHorizontalGridCell> cellAdapter = new CellAdapter<>(host);
        this.adapter = cellAdapter;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
        this.layoutManager = staggeredGridLayoutManager;
        NativeHorizontalGridSpacingDecoration nativeHorizontalGridSpacingDecoration = new NativeHorizontalGridSpacingDecoration(0, 0, 3, (DefaultConstructorMarker) null);
        this.spacingDecoration = nativeHorizontalGridSpacingDecoration;
        this.scrollHandler = NativeHorizontalGridWidget$scrollHandler$1.INSTANCE;
        this.rowsCount = staggeredGridLayoutManager.getSpanCount();
        addView(recyclerView2, -1, -1);
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeHorizontalGridWidget f30244a;

            {
                this.f30244a = r1;
            }

            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i11 == 0) {
                    this.f30244a.getScrollHandler().invoke();
                }
            }
        });
        recyclerView2.setAdapter(cellAdapter);
        recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        recyclerView2.setItemAnimator(new CollectionItemAnimator());
        recyclerView2.addItemDecoration(nativeHorizontalGridSpacingDecoration);
    }
}
