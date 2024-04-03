package com.talabat.cuisines.presentation;

import android.widget.Filter;
import com.talabat.cuisines.domain.SelectableCuisine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/talabat/cuisines/presentation/PopularCuisinesAdapter$getFilter$1", "Lcom/talabat/cuisines/presentation/CuisineSearchFilter;", "publishResults", "", "constraint", "", "results", "Landroid/widget/Filter$FilterResults;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopularCuisinesAdapter$getFilter$1 extends CuisineSearchFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopularCuisinesAdapter f56070a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PopularCuisinesAdapter$getFilter$1(PopularCuisinesAdapter popularCuisinesAdapter, List<SelectableCuisine> list) {
        super(list);
        this.f56070a = popularCuisinesAdapter;
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
            PopularCuisinesAdapter popularCuisinesAdapter = this.f56070a;
            popularCuisinesAdapter.setShowListOfCuisines$com_talabat_Components_cuisines_cuisines(popularCuisinesAdapter.getAllCuisinesWithPopular$com_talabat_Components_cuisines_cuisines());
            this.f56070a.notifyDataSetChanged();
            return;
        }
        PopularCuisinesAdapter popularCuisinesAdapter2 = this.f56070a;
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
            popularCuisinesAdapter2.setShowListOfCuisines$com_talabat_Components_cuisines_cuisines(arrayList);
            this.f56070a.notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.cuisines.domain.SelectableCuisine>");
    }
}
