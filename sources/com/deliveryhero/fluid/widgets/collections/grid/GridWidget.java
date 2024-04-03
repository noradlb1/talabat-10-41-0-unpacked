package com.deliveryhero.fluid.widgets.collections.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.CellAdapter;
import com.deliveryhero.fluid.widgets.collections.CollectionItemAnimator;
import com.deliveryhero.fluid.widgets.collections.grid.FreeSpacingLayoutManager;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y4.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R,\u0010\u0014\u001a\u00060\u000bj\u0002`\u00132\n\u0010\u0012\u001a\u00060\u000bj\u0002`\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0011\u0010!\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R \u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020+*\u00020+8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/GridWidget;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "host", "Lcom/deliveryhero/fluid/Host;", "isHorizontal", "", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Lcom/deliveryhero/fluid/Host;ZLandroid/util/AttributeSet;I)V", "cellAdapter", "Lcom/deliveryhero/fluid/widgets/collections/CellAdapter;", "Lcom/deliveryhero/fluid/widgets/collections/grid/GridCell;", "cellLayoutManager", "Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager;", "value", "Lcom/deliveryhero/fluid/values/PixelInt;", "cellSpacing", "getCellSpacing", "()I", "setCellSpacing", "(I)V", "", "cells", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "firstVisiblePosition", "getFirstVisiblePosition", "lastVisiblePosition", "getLastVisiblePosition", "scrollHandler", "Lkotlin/Function0;", "", "getScrollHandler", "()Lkotlin/jvm/functions/Function0;", "setScrollHandler", "(Lkotlin/jvm/functions/Function0;)V", "densityScaled", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "getDensityScaled", "(Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;)Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
public final class GridWidget extends RecyclerView {
    @NotNull
    private final CellAdapter<GridCell> cellAdapter;
    @NotNull
    private final FreeSpacingLayoutManager cellLayoutManager;
    private int cellSpacing;
    @NotNull
    private Function0<Unit> scrollHandler;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridWidget(Context context, Host host, boolean z11, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, host, z11, (i12 & 8) != 0 ? null : attributeSet, (i12 & 16) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: cellLayoutManager$lambda-0  reason: not valid java name */
    public static final FreeSpacingLayoutManager.ItemSize m8203cellLayoutManager$lambda0(GridWidget gridWidget, int i11) {
        Intrinsics.checkNotNullParameter(gridWidget, "this$0");
        GridCell gridCell = gridWidget.getCells().get(i11);
        return new FreeSpacingLayoutManager.ItemSize(gridWidget.getDensityScaled(gridCell.getWidth()), gridWidget.getDensityScaled(gridCell.getHeight()));
    }

    private final Cell.Size getDensityScaled(Cell.Size size) {
        if (size instanceof Cell.Size.Relative) {
            return Cell.Size.Relative.m8196boximpl(Cell.Size.Relative.m8197constructorimpl(((Cell.Size.Relative) size).m8202unboximpl()));
        }
        if (size instanceof Cell.Size.Absolute) {
            LogicalPixel r42 = ((Cell.Size.Absolute) size).m8195unboximpl();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return Cell.Size.Absolute.m8189boximpl(Cell.Size.Absolute.m8190constructorimpl(new LogicalPixel((int) TypedValue.applyDimension(1, r42.getValue(), context.getResources().getDisplayMetrics()))));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getCellSpacing() {
        return this.cellSpacing;
    }

    @NotNull
    public final List<GridCell> getCells() {
        return this.cellAdapter.getCells();
    }

    public final int getFirstVisiblePosition() {
        return this.cellLayoutManager.findLastVisibleItemPosition();
    }

    public final int getLastVisiblePosition() {
        return this.cellLayoutManager.findLastVisibleItemPosition();
    }

    @NotNull
    public final Function0<Unit> getScrollHandler() {
        return this.scrollHandler;
    }

    public final void setCellSpacing(int i11) {
        this.cellSpacing = i11;
        this.cellLayoutManager.setItemSpacing(i11);
    }

    public final void setCells(@NotNull List<? extends GridCell> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.cellAdapter.submitList(list);
    }

    public final void setScrollHandler(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.scrollHandler = function0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridWidget(@NotNull Context context, @NotNull Host host, boolean z11, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        CellAdapter<GridCell> cellAdapter2 = new CellAdapter<>(host);
        this.cellAdapter = cellAdapter2;
        FreeSpacingLayoutManager freeSpacingLayoutManager = new FreeSpacingLayoutManager(z11, this, new a(this));
        this.cellLayoutManager = freeSpacingLayoutManager;
        this.scrollHandler = GridWidget$scrollHandler$1.INSTANCE;
        addOnScrollListener(new RecyclerView.OnScrollListener(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ GridWidget f30239a;

            {
                this.f30239a = r1;
            }

            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i11 == 0) {
                    this.f30239a.getScrollHandler().invoke();
                }
            }
        });
        setAdapter(cellAdapter2);
        setLayoutManager(freeSpacingLayoutManager);
        setItemAnimator(new CollectionItemAnimator());
    }
}
