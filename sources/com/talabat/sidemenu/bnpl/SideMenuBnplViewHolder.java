package com.talabat.sidemenu.bnpl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.TalabatFormatter;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.talabat.sidemenu.SideMenuHeader;
import com.talabat.splash.core.extension.ViewKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/sidemenu/bnpl/SideMenuBnplViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "amount", "", "", "formattedCurrency", "bnplOverdueAmount", "hideOverdueTag", "", "populate", "data", "Lcom/talabat/sidemenu/SideMenuHeader;", "showOverdueTag", "overdueAmount", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuBnplViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuBnplViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    private final String amount(float f11) {
        String string = this.itemView.getContext().getString(R.string.bnpl_payment_overdue, new Object[]{formattedCurrency(f11)});
        Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri…urrency(amount)\n        )");
        return string;
    }

    private final String formattedCurrency(float f11) {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormatt…rrency(bnplOverdueAmount)");
        return formattedCurrency;
    }

    public final void hideOverdueTag() {
        ((DSTag) this.itemView.findViewById(R.id.bnpl_overdue_tag)).setVisibility(4);
    }

    public final void populate(@NotNull SideMenuHeader sideMenuHeader) {
        Intrinsics.checkNotNullParameter(sideMenuHeader, "data");
        ((ImageView) this.itemView.findViewById(R.id.side_menu_header_icon)).setImageResource(sideMenuHeader.getIconDrawableId(true));
        ((TextView) this.itemView.findViewById(R.id.side_menu_header_title)).setText(sideMenuHeader.getTitle());
        this.itemView.setTag(sideMenuHeader.getTitle());
    }

    public final void showOverdueTag(float f11) {
        View view = this.itemView;
        int i11 = R.id.bnpl_overdue_tag;
        DSTag dSTag = (DSTag) view.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(dSTag, "itemView.bnpl_overdue_tag");
        ViewKt.visible(dSTag);
        ((DSTag) this.itemView.findViewById(i11)).setTitle(amount(f11));
    }
}
