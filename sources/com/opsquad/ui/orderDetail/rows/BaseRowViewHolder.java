package com.opsquad.ui.orderDetail.rows;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/BaseRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindView", "", "model", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseRowViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRowViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public abstract void bindView(@NotNull RowDisplayModel rowDisplayModel);
}
