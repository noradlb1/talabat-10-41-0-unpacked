package com.talabat.sdsquad.ui.cuisines.adapters;

import android.widget.Filter;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, d2 = {"com/talabat/sdsquad/ui/cuisines/adapters/CuisinesAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "charSequence", "", "publishResults", "", "filterResults", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesAdapter$getFilter$1 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CuisinesAdapter f61329a;

    public CuisinesAdapter$getFilter$1(CuisinesAdapter cuisinesAdapter) {
        this.f61329a = cuisinesAdapter;
    }

    @NotNull
    public Filter.FilterResults performFiltering(@NotNull CharSequence charSequence) {
        boolean z11;
        List list;
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        String obj = charSequence.toString();
        CuisinesAdapter cuisinesAdapter = this.f61329a;
        if (obj.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            list = this.f61329a.mCuisineList;
        } else {
            ArrayList arrayList = new ArrayList();
            for (CuisineDisplayModel cuisineDisplayModel : this.f61329a.mCuisineList) {
                String lowerCase = cuisineDisplayModel.getName().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                String lowerCase2 = obj.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    arrayList.add(cuisineDisplayModel);
                }
            }
            list = arrayList;
        }
        cuisinesAdapter.mFilteredCuisineList = list;
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = this.f61329a.mFilteredCuisineList;
        return filterResults;
    }

    public void publishResults(@NotNull CharSequence charSequence, @NotNull Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(filterResults, "filterResults");
        CuisinesAdapter cuisinesAdapter = this.f61329a;
        Object obj = filterResults.values;
        if (obj != null) {
            cuisinesAdapter.mFilteredCuisineList = (List) obj;
            this.f61329a.notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel>");
    }
}
