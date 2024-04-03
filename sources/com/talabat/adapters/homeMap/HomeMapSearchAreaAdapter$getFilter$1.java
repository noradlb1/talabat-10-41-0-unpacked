package com.talabat.adapters.homeMap;

import android.widget.Filter;
import datamodels.AreaExpandableListViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, d2 = {"com/talabat/adapters/homeMap/HomeMapSearchAreaAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapSearchAreaAdapter$getFilter$1 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeMapSearchAreaAdapter f55293a;

    public HomeMapSearchAreaAdapter$getFilter$1(HomeMapSearchAreaAdapter homeMapSearchAreaAdapter) {
        this.f55293a = homeMapSearchAreaAdapter;
    }

    @NotNull
    public Filter.FilterResults performFiltering(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "constraint");
        Filter.FilterResults filterResults = new Filter.FilterResults();
        ArrayList<AreaExpandableListViewModel> filerData = this.f55293a.filerData(charSequence.toString());
        filterResults.values = filerData;
        filterResults.count = filerData.size();
        return filterResults;
    }

    public void publishResults(@NotNull CharSequence charSequence, @NotNull Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "constraint");
        Intrinsics.checkNotNullParameter(filterResults, "results");
        if (filterResults.count > 0) {
            HomeMapSearchAreaAdapter homeMapSearchAreaAdapter = this.f55293a;
            Object obj = filterResults.values;
            if (obj != null) {
                homeMapSearchAreaAdapter.setDisplayData((ArrayList) obj);
                charSequence.length();
                this.f55293a.notifyDataSetChanged();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<datamodels.AreaExpandableListViewModel>{ kotlin.collections.TypeAliasesKt.ArrayList<datamodels.AreaExpandableListViewModel> }");
        }
    }
}
