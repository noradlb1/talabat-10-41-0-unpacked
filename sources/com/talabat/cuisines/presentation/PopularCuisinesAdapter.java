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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017H\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000b¨\u0006!"}, d2 = {"Lcom/talabat/cuisines/presentation/PopularCuisinesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "()V", "allCuisines", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "getAllCuisines$com_talabat_Components_cuisines_cuisines", "()Ljava/util/List;", "setAllCuisines$com_talabat_Components_cuisines_cuisines", "(Ljava/util/List;)V", "value", "Lcom/talabat/cuisines/presentation/ItemContainer;", "allCuisinesWithPopular", "getAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines", "setAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines", "showListOfCuisines", "getShowListOfCuisines$com_talabat_Components_cuisines_cuisines", "setShowListOfCuisines$com_talabat_Components_cuisines_cuisines", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PopularCuisinesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    @NotNull
    private List<SelectableCuisine> allCuisines = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private List<ItemContainer> allCuisinesWithPopular = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private List<ItemContainer> showListOfCuisines = CollectionsKt__CollectionsKt.emptyList();

    @NotNull
    public final List<SelectableCuisine> getAllCuisines$com_talabat_Components_cuisines_cuisines() {
        return this.allCuisines;
    }

    @NotNull
    public final List<ItemContainer> getAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines() {
        return this.allCuisinesWithPopular;
    }

    @NotNull
    public Filter getFilter() {
        return new PopularCuisinesAdapter$getFilter$1(this, this.allCuisines);
    }

    public int getItemCount() {
        return this.showListOfCuisines.size();
    }

    public int getItemViewType(int i11) {
        Object item = this.showListOfCuisines.get(i11).getItem();
        if (item instanceof HEADERTYPE) {
            return 0;
        }
        if (item instanceof SelectableCuisine) {
            return 1;
        }
        String simpleName = this.showListOfCuisines.get(i11).getItem().getClass().getSimpleName();
        throw new UnsupportedOperationException("Unknown type, cannot bind " + simpleName);
    }

    @NotNull
    public final List<ItemContainer> getShowListOfCuisines$com_talabat_Components_cuisines_cuisines() {
        return this.showListOfCuisines;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object item = this.showListOfCuisines.get(i11).getItem();
        if (item instanceof HEADERTYPE) {
            ((HeaderViewHolder) viewHolder).bind(this.showListOfCuisines.get(i11));
        } else if (item instanceof SelectableCuisine) {
            ((CuisineHolder) viewHolder).bind((SelectableCuisine) this.showListOfCuisines.get(i11).getItem());
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisines_header, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new HeaderViewHolder(inflate);
        } else if (i11 != 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisines_header, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "view");
            return new HeaderViewHolder(inflate2);
        } else {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisine_multiple_selection, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new CuisineMultipleSelectionViewHolder(inflate3, (Function1) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public final void setAllCuisines$com_talabat_Components_cuisines_cuisines(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.allCuisines = list;
    }

    public final void setAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines(@NotNull List<ItemContainer> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.allCuisinesWithPopular = list;
        this.showListOfCuisines = list;
        notifyDataSetChanged();
    }

    public final void setShowListOfCuisines$com_talabat_Components_cuisines_cuisines(@NotNull List<ItemContainer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.showListOfCuisines = list;
    }
}
