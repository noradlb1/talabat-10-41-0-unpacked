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
import com.talabat.cuisines.presentation.HEADERTYPE;
import com.talabat.cuisines.presentation.HeaderViewHolder;
import com.talabat.cuisines.presentation.ItemContainer;
import datamodels.Cuisine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0016\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006 "}, d2 = {"Lcom/talabat/cuisines/presentation/bottomsheet/PopularCuisinesDSBottomSheetAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/cuisines/presentation/ItemContainer;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "()V", "allCuisines", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "getAllCuisines$com_talabat_Components_cuisines_cuisines", "()Ljava/util/List;", "setAllCuisines$com_talabat_Components_cuisines_cuisines", "(Ljava/util/List;)V", "value", "allCuisinesWithPopular", "getAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines", "setAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines", "getFilter", "Landroid/widget/Filter;", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitNewList", "list", "DiffCallback", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopularCuisinesDSBottomSheetAdapter extends ListAdapter<ItemContainer, RecyclerView.ViewHolder> implements Filterable {
    @NotNull
    private List<SelectableCuisine> allCuisines = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private List<ItemContainer> allCuisinesWithPopular = CollectionsKt__CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/cuisines/presentation/bottomsheet/PopularCuisinesDSBottomSheetAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/cuisines/presentation/ItemContainer;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<ItemContainer> {
        public boolean areContentsTheSame(@NotNull ItemContainer itemContainer, @NotNull ItemContainer itemContainer2) {
            Intrinsics.checkNotNullParameter(itemContainer, "oldItem");
            Intrinsics.checkNotNullParameter(itemContainer2, "newItem");
            return Intrinsics.areEqual((Object) itemContainer, (Object) itemContainer2);
        }

        public boolean areItemsTheSame(@NotNull ItemContainer itemContainer, @NotNull ItemContainer itemContainer2) {
            Intrinsics.checkNotNullParameter(itemContainer, "oldItem");
            Intrinsics.checkNotNullParameter(itemContainer2, "newItem");
            if (!(itemContainer.getItem() instanceof SelectableCuisine) || !(itemContainer2.getItem() instanceof SelectableCuisine)) {
                return Intrinsics.areEqual((Object) itemContainer, (Object) itemContainer2);
            }
            return ((SelectableCuisine) itemContainer.getItem()).getCuisine().f13848id == ((SelectableCuisine) itemContainer2.getItem()).getCuisine().f13848id && ((SelectableCuisine) itemContainer.getItem()).isPopular() == ((SelectableCuisine) itemContainer2.getItem()).isPopular();
        }
    }

    public PopularCuisinesDSBottomSheetAdapter() {
        super(new DiffCallback());
    }

    /* access modifiers changed from: private */
    public final void submitNewList(List<ItemContainer> list) {
        ItemContainer itemContainer;
        Iterable<ItemContainer> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ItemContainer itemContainer2 : iterable) {
            if (itemContainer2.getItem() instanceof SelectableCuisine) {
                itemContainer = new ItemContainer(SelectableCuisine.copy$default((SelectableCuisine) itemContainer2.getItem(), (Cuisine) null, false, false, 7, (Object) null));
            } else {
                itemContainer = new ItemContainer(itemContainer2.getItem());
            }
            arrayList.add(itemContainer);
        }
        submitList(arrayList);
    }

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
        return new PopularCuisinesDSBottomSheetAdapter$getFilter$1(this, this.allCuisines);
    }

    public int getItemViewType(int i11) {
        Object item = ((ItemContainer) getItem(i11)).getItem();
        if (item instanceof HEADERTYPE) {
            return 0;
        }
        if (item instanceof SelectableCuisine) {
            return 1;
        }
        String simpleName = ((ItemContainer) getItem(i11)).getItem().getClass().getSimpleName();
        throw new UnsupportedOperationException("Unknown type, cannot bind " + simpleName);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object item = ((ItemContainer) getItem(i11)).getItem();
        if (item instanceof HEADERTYPE) {
            Object item2 = getItem(i11);
            Intrinsics.checkNotNullExpressionValue(item2, "getItem(position)");
            ((HeaderViewHolder) viewHolder).bind((ItemContainer) item2);
        } else if (item instanceof SelectableCuisine) {
            ((CuisineHolder) viewHolder).bind((SelectableCuisine) ((ItemContainer) getItem(i11)).getItem());
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisine_ds_bottom_sheet, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new CuisineDSBottomSheetViewHolder(inflate, (Function1) null, 2, (DefaultConstructorMarker) null);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisines_header_ds_bottom_sheet, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "view");
        return new HeaderViewHolder(inflate2);
    }

    public final void setAllCuisines$com_talabat_Components_cuisines_cuisines(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.allCuisines = list;
    }

    public final void setAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines(@NotNull List<ItemContainer> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.allCuisinesWithPopular = list;
        submitNewList(list);
    }
}
