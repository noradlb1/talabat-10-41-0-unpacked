package com.talabat.talabatlife.ui.cuisine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.cuisine.CuisineViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cuisineClickLister", "Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder$OnCuisineClicked;", "(Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder$OnCuisineClicked;)V", "cuisineList", "", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCuisineList", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final CuisineViewHolder.OnCuisineClicked cuisineClickLister;
    @NotNull
    private List<CuisineDisplayModel> cuisineList = CollectionsKt__CollectionsKt.emptyList();

    public CuisineAdapter(@NotNull CuisineViewHolder.OnCuisineClicked onCuisineClicked) {
        Intrinsics.checkNotNullParameter(onCuisineClicked, "cuisineClickLister");
        this.cuisineClickLister = onCuisineClicked;
    }

    public int getItemCount() {
        return this.cuisineList.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((CuisineViewHolder) viewHolder).bind(this.cuisineList.get(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tdine_cuisine, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CuisineViewHolder(inflate, this.cuisineClickLister);
    }

    public final void setCuisineList(@NotNull List<CuisineDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "cuisineList");
        this.cuisineList = list;
        notifyDataSetChanged();
    }
}
