package com.deliveryhero.fluid.widgets.collections;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0019B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u001c\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u0010H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/CellAdapter;", "CellT", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/deliveryhero/fluid/widgets/collections/CellAdapter$ViewHolder;", "host", "Lcom/deliveryhero/fluid/Host;", "(Lcom/deliveryhero/fluid/Host;)V", "cells", "", "getCells", "()Ljava/util/List;", "state", "Lcom/deliveryhero/fluid/widgets/collections/CollectionState;", "getItemViewType", "", "Lcom/deliveryhero/fluid/widgets/collections/ViewType;", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CellAdapter<CellT extends Cell> extends ListAdapter<CellT, ViewHolder> {
    @NotNull
    private final Host host;
    @NotNull
    private final CollectionState state;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/CellAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "(Landroid/view/View;)V", "getRoot", "()Landroid/view/View;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final View root;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "root");
            this.root = view;
        }

        @NotNull
        public final View getRoot() {
            return this.root;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CellAdapter(@NotNull Host host2) {
        super(new AsyncDifferConfig.Builder(new CellDiffer()).setBackgroundThreadExecutor(host2.getUiConfig().getCellsDiffExecutor()).build());
        Intrinsics.checkNotNullParameter(host2, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        this.host = host2;
        this.state = host2.getCollectionState();
    }

    @NotNull
    public final List<CellT> getCells() {
        List<CellT> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        return currentList;
    }

    public int getItemViewType(int i11) {
        return this.state.getViewType(((Cell) getItem(i11)).getTemplate());
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Cell cell = (Cell) getItem(i11);
        cell.getTemplate().bindData(this.host, viewHolder.getRoot(), cell.getData());
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(this.state.getTemplate(i11).createUi(this.host));
    }
}
