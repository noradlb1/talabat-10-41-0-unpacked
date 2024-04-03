package com.talabat.cuisines.presentation.bottomsheet;

import android.widget.Filter;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.presentation.CuisineSearchFilter;
import com.talabat.cuisines.presentation.ItemContainer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/talabat/cuisines/presentation/bottomsheet/PopularCuisinesDSBottomSheetAdapter$getFilter$1", "Lcom/talabat/cuisines/presentation/CuisineSearchFilter;", "publishResults", "", "constraint", "", "results", "Landroid/widget/Filter$FilterResults;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopularCuisinesDSBottomSheetAdapter$getFilter$1 extends CuisineSearchFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopularCuisinesDSBottomSheetAdapter f56092a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PopularCuisinesDSBottomSheetAdapter$getFilter$1(PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter, List<SelectableCuisine> list) {
        super(list);
        this.f56092a = popularCuisinesDSBottomSheetAdapter;
    }

    public void publishResults(@Nullable CharSequence charSequence, @Nullable Filter.FilterResults filterResults) {
        boolean z11;
        Object obj;
        if (charSequence == null || charSequence.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter = this.f56092a;
            popularCuisinesDSBottomSheetAdapter.submitNewList(popularCuisinesDSBottomSheetAdapter.getAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines());
            return;
        }
        PopularCuisinesDSBottomSheetAdapter popularCuisinesDSBottomSheetAdapter2 = this.f56092a;
        if (filterResults != null) {
            obj = filterResults.values;
        } else {
            obj = null;
        }
        if (obj != null) {
            Iterable<SelectableCuisine> iterable = (List) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (SelectableCuisine itemContainer : iterable) {
                arrayList.add(new ItemContainer(itemContainer));
            }
            popularCuisinesDSBottomSheetAdapter2.submitNewList(arrayList);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.cuisines.domain.SelectableCuisine>");
    }
}
