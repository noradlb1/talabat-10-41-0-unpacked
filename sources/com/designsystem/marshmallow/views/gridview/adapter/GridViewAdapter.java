package com.designsystem.marshmallow.views.gridview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.designsystem.marshmallow.views.gridview.viewholder.GridViewHolder;
import com.designsystem.marshmallow.viewsentity.gridview.GridViewsEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/designsystem/marshmallow/views/gridview/adapter/GridViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/designsystem/marshmallow/views/gridview/viewholder/GridViewHolder;", "gridViewEntity", "Lcom/designsystem/marshmallow/viewsentity/gridview/GridViewsEntity;", "(Lcom/designsystem/marshmallow/viewsentity/gridview/GridViewsEntity;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GridViewAdapter extends RecyclerView.Adapter<GridViewHolder> {
    @NotNull
    private final GridViewsEntity gridViewEntity;

    public GridViewAdapter(@NotNull GridViewsEntity gridViewsEntity) {
        Intrinsics.checkNotNullParameter(gridViewsEntity, "gridViewEntity");
        this.gridViewEntity = gridViewsEntity;
    }

    public int getItemCount() {
        return this.gridViewEntity.getGridItems().size();
    }

    public void onBindViewHolder(@NotNull GridViewHolder gridViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(gridViewHolder, "holder");
        gridViewHolder.bind(this.gridViewEntity.getGridItems().get(i11));
    }

    @NotNull
    public GridViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_view_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…view_item, parent, false)");
        return new GridViewHolder(inflate);
    }
}
