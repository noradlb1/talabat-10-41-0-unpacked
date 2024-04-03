package com.afollestad.materialdialogs.bottomsheets;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/afollestad/materialdialogs/bottomsheets/GridItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "adapter", "Lcom/afollestad/materialdialogs/bottomsheets/GridIconDialogAdapter;", "(Landroid/view/View;Lcom/afollestad/materialdialogs/bottomsheets/GridIconDialogAdapter;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "onClick", "", "view", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class GridItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final GridIconDialogAdapter<?> adapter;
    @NotNull
    private final ImageView iconView;
    @NotNull
    private final TextView titleView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridItemViewHolder(@NotNull View view, @NotNull GridIconDialogAdapter<?> gridIconDialogAdapter) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(gridIconDialogAdapter, "adapter");
        this.adapter = gridIconDialogAdapter;
        view.setOnClickListener(this);
        View findViewById = view.findViewById(R.id.md_grid_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.md_grid_icon)");
        this.iconView = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.md_grid_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.md_grid_title)");
        this.titleView = (TextView) findViewById2;
    }

    @NotNull
    public final ImageView getIconView() {
        return this.iconView;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.titleView;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.adapter.itemClicked(getAdapterPosition());
    }
}
