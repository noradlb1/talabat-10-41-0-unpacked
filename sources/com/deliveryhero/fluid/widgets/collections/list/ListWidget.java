package com.deliveryhero.fluid.widgets.collections.list;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.widgets.collections.CellAdapter;
import com.deliveryhero.fluid.widgets.collections.ChildVisibilityNotifier;
import com.deliveryhero.fluid.widgets.collections.CollectionItemAnimator;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0007H\u0014R,\u0010\u000b\u001a\u00060\u0007j\u0002`\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/list/ListWidget;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/deliveryhero/fluid/values/PixelInt;", "cellSpacing", "getCellSpacing", "()I", "setCellSpacing", "(I)V", "cellSpacingDecorator", "Lcom/deliveryhero/fluid/widgets/collections/list/CellSpacingDecorator;", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "cells", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "childVisibilityNotifier", "Lcom/deliveryhero/fluid/widgets/collections/ChildVisibilityNotifier;", "getAdapter", "Lcom/deliveryhero/fluid/widgets/collections/CellAdapter;", "getLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "init", "", "host", "Lcom/deliveryhero/fluid/Host;", "onWindowVisibilityChanged", "visibility", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ListWidget extends RecyclerView {
    @NotNull
    private final CellSpacingDecorator cellSpacingDecorator;
    @NotNull
    private final ChildVisibilityNotifier childVisibilityNotifier;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ListWidget(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ListWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListWidget(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final int getCellSpacing() {
        return this.cellSpacingDecorator.getSpacing();
    }

    @NotNull
    public final List<ListCell> getCells() {
        return getAdapter().getCells();
    }

    public final void init(@NotNull Host host) {
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        setLayoutManager(new LinearLayoutManager(getContext()));
        setItemAnimator(new CollectionItemAnimator());
        new SingleScrollDirectionEnforcer().apply(this);
        this.childVisibilityNotifier.apply(this);
        setAdapter(new CellAdapter(host));
        addItemDecoration(this.cellSpacingDecorator);
    }

    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        this.childVisibilityNotifier.onRootVisibilityChanged(i11);
    }

    public final void setCellSpacing(int i11) {
        if (this.cellSpacingDecorator.getSpacing() != i11) {
            this.cellSpacingDecorator.setSpacing(i11);
            invalidateItemDecorations();
        }
    }

    public final void setCells(@NotNull List<ListCell> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        getAdapter().submitList(list);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ListWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.childVisibilityNotifier = new ChildVisibilityNotifier();
        this.cellSpacingDecorator = new CellSpacingDecorator();
    }

    @NotNull
    public CellAdapter<ListCell> getAdapter() {
        RecyclerView.Adapter adapter = super.getAdapter();
        if (adapter != null) {
            return (CellAdapter) adapter;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.deliveryhero.fluid.widgets.collections.CellAdapter<com.deliveryhero.fluid.widgets.collections.list.ListCell>");
    }

    @NotNull
    public LinearLayoutManager getLayoutManager() {
        RecyclerView.LayoutManager layoutManager = super.getLayoutManager();
        if (layoutManager != null) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
