package com.talabat.sidemenu;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.talabatlife.ui.tLifeWidget.TLifeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/sidemenu/SideMenuTLifeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "hideView", "", "populate", "setFreeCoffee", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTLifeViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTLifeViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public final void hideView() {
        ((ConstraintLayout) this.itemView.findViewById(R.id.side_menu_tlife_header_view)).setVisibility(8);
    }

    public final void populate() {
        ((ConstraintLayout) this.itemView.findViewById(R.id.side_menu_tlife_header_view)).setVisibility(0);
    }

    public final void setFreeCoffee() {
        ((ConstraintLayout) this.itemView.findViewById(R.id.side_menu_tlife_header_view)).setVisibility(0);
        ((TLifeView) this.itemView.findViewById(R.id.t_life_sidemenu_widget)).setFreeCoffeeMode();
    }
}
