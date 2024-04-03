package com.talabat.cuisines.presentation.bottomsheet;

import android.widget.Filter;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.cuisines.presentation.CuisineSearchFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"com/talabat/cuisines/presentation/bottomsheet/CuisinesDSBottomSheetAdapter$getFilter$1", "Lcom/talabat/cuisines/presentation/CuisineSearchFilter;", "publishResults", "", "charSequence", "", "filterResults", "Landroid/widget/Filter$FilterResults;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetAdapter$getFilter$1 extends CuisineSearchFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetAdapter f56072a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetAdapter$getFilter$1(CuisinesDSBottomSheetAdapter cuisinesDSBottomSheetAdapter, List<SelectableCuisine> list) {
        super(list);
        this.f56072a = cuisinesDSBottomSheetAdapter;
    }

    public void publishResults(@NotNull CharSequence charSequence, @NotNull Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(filterResults, "filterResults");
        CuisinesDSBottomSheetAdapter cuisinesDSBottomSheetAdapter = this.f56072a;
        Object obj = filterResults.values;
        if (obj != null) {
            cuisinesDSBottomSheetAdapter.submitNewList((List) obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.cuisines.domain.SelectableCuisine>");
    }
}
