package com.talabat.cuisines.presentation.bottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.cuisines.R;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.presentation.CuisineHolder;
import datamodels.Cuisine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0016\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/talabat/cuisines/presentation/bottomsheet/CuisinesDSBottomSheetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "()V", "value", "", "allCuisines", "getAllCuisines$com_talabat_Components_cuisines_cuisines", "()Ljava/util/List;", "setAllCuisines$com_talabat_Components_cuisines_cuisines", "(Ljava/util/List;)V", "getFilter", "Landroid/widget/Filter;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitNewList", "list", "DiffCallback", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetAdapter extends ListAdapter<SelectableCuisine, RecyclerView.ViewHolder> implements Filterable {
    @NotNull
    private List<SelectableCuisine> allCuisines = CollectionsKt__CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/cuisines/presentation/bottomsheet/CuisinesDSBottomSheetAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<SelectableCuisine> {
        public boolean areContentsTheSame(@NotNull SelectableCuisine selectableCuisine, @NotNull SelectableCuisine selectableCuisine2) {
            Intrinsics.checkNotNullParameter(selectableCuisine, "oldItem");
            Intrinsics.checkNotNullParameter(selectableCuisine2, "newItem");
            return Intrinsics.areEqual((Object) selectableCuisine, (Object) selectableCuisine2);
        }

        public boolean areItemsTheSame(@NotNull SelectableCuisine selectableCuisine, @NotNull SelectableCuisine selectableCuisine2) {
            Intrinsics.checkNotNullParameter(selectableCuisine, "oldItem");
            Intrinsics.checkNotNullParameter(selectableCuisine2, "newItem");
            return selectableCuisine.getCuisine().f13848id == selectableCuisine2.getCuisine().f13848id;
        }
    }

    public CuisinesDSBottomSheetAdapter() {
        super(new DiffCallback());
    }

    /* access modifiers changed from: private */
    public final void submitNewList(List<SelectableCuisine> list) {
        Iterable<SelectableCuisine> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SelectableCuisine copy$default : iterable) {
            arrayList.add(SelectableCuisine.copy$default(copy$default, (Cuisine) null, false, false, 7, (Object) null));
        }
        submitList(arrayList);
    }

    @NotNull
    public final List<SelectableCuisine> getAllCuisines$com_talabat_Components_cuisines_cuisines() {
        return this.allCuisines;
    }

    @NotNull
    public Filter getFilter() {
        return new CuisinesDSBottomSheetAdapter$getFilter$1(this, this.allCuisines);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object item = getItem(i11);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        ((CuisineHolder) viewHolder).bind((SelectableCuisine) item);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisine_ds_bottom_sheet, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CuisineDSBottomSheetViewHolder(inflate, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    public final void setAllCuisines$com_talabat_Components_cuisines_cuisines(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.allCuisines = list;
        submitNewList(list);
    }
}
