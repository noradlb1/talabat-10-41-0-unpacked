package com.talabat.adapters;

import android.widget.Filter;
import com.talabat.adapters.PlacesAutoCompleteAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\t"}, d2 = {"com/talabat/adapters/PlacesAutoCompleteAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlacesAutoCompleteAdapter$getFilter$1 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlacesAutoCompleteAdapter f55177a;

    public PlacesAutoCompleteAdapter$getFilter$1(PlacesAutoCompleteAdapter placesAutoCompleteAdapter) {
        this.f55177a = placesAutoCompleteAdapter;
    }

    @NotNull
    public Filter.FilterResults performFiltering(@Nullable CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null) {
            PlacesAutoCompleteAdapter placesAutoCompleteAdapter = this.f55177a;
            placesAutoCompleteAdapter.mResultList = placesAutoCompleteAdapter.getPredictions(charSequence);
            if (this.f55177a.mResultList != null) {
                filterResults.values = this.f55177a.mResultList;
                ArrayList access$getMResultList$p = this.f55177a.mResultList;
                Intrinsics.checkNotNull(access$getMResultList$p);
                filterResults.count = access$getMResultList$p.size();
            }
        }
        return filterResults;
    }

    public void publishResults(@NotNull CharSequence charSequence, @Nullable Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "constraint");
        if (filterResults == null || filterResults.count <= 0) {
            PlacesAutoCompleteAdapter.ClickListener access$getClickListener$p = this.f55177a.clickListener;
            if (access$getClickListener$p != null) {
                access$getClickListener$p.noResultFound(true);
            }
            this.f55177a.notifyDataSetChanged();
            return;
        }
        PlacesAutoCompleteAdapter.ClickListener access$getClickListener$p2 = this.f55177a.clickListener;
        if (access$getClickListener$p2 != null) {
            access$getClickListener$p2.noResultFound(false);
        }
        this.f55177a.notifyDataSetChanged();
    }
}
