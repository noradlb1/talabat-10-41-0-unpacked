package com.talabat.adapters.homeMap;

import android.widget.Filter;
import com.talabat.adapters.homeMap.GooglePlaceSearchAdapter;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\t"}, d2 = {"com/talabat/adapters/homeMap/GooglePlaceSearchAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GooglePlaceSearchAdapter$getFilter$1 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GooglePlaceSearchAdapter f55292a;

    public GooglePlaceSearchAdapter$getFilter$1(GooglePlaceSearchAdapter googlePlaceSearchAdapter) {
        this.f55292a = googlePlaceSearchAdapter;
    }

    @NotNull
    public Filter.FilterResults performFiltering(@Nullable CharSequence charSequence) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null) {
            GooglePlaceSearchAdapter googlePlaceSearchAdapter = this.f55292a;
            ArrayList access$findPlaces = googlePlaceSearchAdapter.findPlaces(googlePlaceSearchAdapter.getContext(), charSequence.toString());
            filterResults.values = access$findPlaces;
            filterResults.count = access$findPlaces.size();
        }
        return filterResults;
    }

    public void publishResults(@NotNull CharSequence charSequence, @Nullable Filter.FilterResults filterResults) {
        GooglePlaceSearchAdapter.onItemClickListener listener;
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(charSequence, "constraint");
        if (filterResults == null || filterResults.count <= 0) {
            GooglePlaceSearchAdapter.onItemClickListener listener2 = this.f55292a.getListener();
            if (listener2 != null) {
                listener2.onSearchResultAvail(false);
            }
            String obj = charSequence.toString();
            if (!TalabatUtils.isNullOrEmpty(obj) && !Intrinsics.areEqual((Object) obj, (Object) "null") && (listener = this.f55292a.getListener()) != null) {
                int length = obj.length() - 1;
                int i12 = 0;
                boolean z12 = false;
                while (i12 <= length) {
                    if (!z12) {
                        i11 = i12;
                    } else {
                        i11 = length;
                    }
                    if (Intrinsics.compare((int) obj.charAt(i11), 32) <= 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z12) {
                        if (!z11) {
                            z12 = true;
                        } else {
                            i12++;
                        }
                    } else if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                }
                listener.onScheduleRequest(obj.subSequence(i12, length + 1).toString());
                return;
            }
            return;
        }
        GooglePlaceSearchAdapter googlePlaceSearchAdapter = this.f55292a;
        Object obj2 = filterResults.values;
        if (obj2 != null) {
            googlePlaceSearchAdapter.setPlaceSearchResultList((ArrayList) obj2);
            GooglePlaceSearchAdapter.onItemClickListener listener3 = this.f55292a.getListener();
            if (listener3 != null) {
                listener3.onSearchResultAvail(true);
            }
            this.f55292a.notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<JsonModels.Response.PlacesSuggestionResponse>{ kotlin.collections.TypeAliasesKt.ArrayList<JsonModels.Response.PlacesSuggestionResponse> }");
    }
}
