package com.talabat.cuisines.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.cuisines.R;
import com.talabat.cuisines.domain.SelectableCuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0014\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/cuisines/presentation/CuisinesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "()V", "mCuisineList", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "getMCuisineList$com_talabat_Components_cuisines_cuisines", "()Ljava/util/List;", "setMCuisineList$com_talabat_Components_cuisines_cuisines", "(Ljava/util/List;)V", "mFilteredCuisineList", "getMFilteredCuisineList$com_talabat_Components_cuisines_cuisines", "setMFilteredCuisineList$com_talabat_Components_cuisines_cuisines", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCuisineList", "cuisineList", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CuisinesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    @NotNull
    private List<SelectableCuisine> mCuisineList = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private List<SelectableCuisine> mFilteredCuisineList = CollectionsKt__CollectionsKt.emptyList();

    @NotNull
    public Filter getFilter() {
        return new CuisinesAdapter$getFilter$1(this, this.mCuisineList);
    }

    public int getItemCount() {
        return this.mFilteredCuisineList.size();
    }

    @NotNull
    public final List<SelectableCuisine> getMCuisineList$com_talabat_Components_cuisines_cuisines() {
        return this.mCuisineList;
    }

    @NotNull
    public final List<SelectableCuisine> getMFilteredCuisineList$com_talabat_Components_cuisines_cuisines() {
        return this.mFilteredCuisineList;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((CuisineHolder) viewHolder).bind(this.mFilteredCuisineList.get(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisine_multiple_selection, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CuisineMultipleSelectionViewHolder(inflate, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    public final void setCuisineList(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "cuisineList");
        this.mCuisineList = list;
        this.mFilteredCuisineList = list;
        notifyDataSetChanged();
    }

    public final void setMCuisineList$com_talabat_Components_cuisines_cuisines(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mCuisineList = list;
    }

    public final void setMFilteredCuisineList$com_talabat_Components_cuisines_cuisines(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mFilteredCuisineList = list;
    }
}
