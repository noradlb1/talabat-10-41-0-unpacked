package com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters.viewholders.DishViewHolder;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters.viewholders.SearchHeaderViewHolder;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/adapters/GlobalSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "mResultList", "", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchDisplayModel;", "mVendorClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setResultList", "resultList", "setVendorClickListener", "clickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private List<GlobalSearchDisplayModel> mResultList = CollectionsKt__CollectionsKt.emptyList();
    @Nullable
    private VendorViewHolder.VendorClickListener mVendorClickListener;

    public int getItemCount() {
        return this.mResultList.size();
    }

    public int getItemViewType(int i11) {
        return this.mResultList.get(i11).getType().ordinal();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof SearchHeaderViewHolder) {
            ((SearchHeaderViewHolder) viewHolder).bind(Integer.valueOf(this.mResultList.get(i11).getItemCount()));
        } else if (viewHolder instanceof VendorViewHolder) {
            VendorDisplayModel vendorDisplayModel = this.mResultList.get(i11).getVendorDisplayModel();
            Intrinsics.checkNotNull(vendorDisplayModel);
            ((VendorViewHolder) viewHolder).bind(vendorDisplayModel);
        } else {
            DishDisplayModel dishDisplayModel = this.mResultList.get(i11).getDishDisplayModel();
            Intrinsics.checkNotNull(dishDisplayModel);
            ((DishViewHolder) viewHolder).bind(dishDisplayModel);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        GlobalSearchCellType globalSearchCellType = GlobalSearchCellType.DishHeader;
        if (i11 == globalSearchCellType.ordinal()) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_search_header, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SearchHeaderViewHolder(inflate, globalSearchCellType);
        }
        GlobalSearchCellType globalSearchCellType2 = GlobalSearchCellType.VendorHeader;
        if (i11 == globalSearchCellType2.ordinal()) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_search_header, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "view");
            return new SearchHeaderViewHolder(inflate2, globalSearchCellType2);
        } else if (i11 == GlobalSearchCellType.Dish.ordinal()) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dish, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new DishViewHolder(inflate3);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_clean, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "view");
            return new VendorViewHolder(inflate4, this.mVendorClickListener);
        }
    }

    public final void setResultList(@NotNull List<GlobalSearchDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "resultList");
        this.mResultList = list;
        notifyDataSetChanged();
    }

    public final void setVendorClickListener(@NotNull VendorViewHolder.VendorClickListener vendorClickListener) {
        Intrinsics.checkNotNullParameter(vendorClickListener, "clickListener");
        this.mVendorClickListener = vendorClickListener;
    }
}
