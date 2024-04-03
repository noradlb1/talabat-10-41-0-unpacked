package com.talabat.talabatlife.ui.vendorList.views;

import android.widget.Filter;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014¨\u0006\t"}, d2 = {"com/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "charSequence", "", "publishResults", "", "filterResults", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLocationFilterAdapter$getFilter$1 extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorLocationFilterAdapter f12099a;

    public VendorLocationFilterAdapter$getFilter$1(VendorLocationFilterAdapter vendorLocationFilterAdapter) {
        this.f12099a = vendorLocationFilterAdapter;
    }

    @NotNull
    public Filter.FilterResults performFiltering(@NotNull CharSequence charSequence) {
        boolean z11;
        List<VendorLocationFilterDisplayModel> list;
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        String obj = charSequence.toString();
        VendorLocationFilterAdapter vendorLocationFilterAdapter = this.f12099a;
        if (obj.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            list = this.f12099a.getDataItems();
        } else {
            list = this.f12099a.getFilteringResult(obj);
        }
        vendorLocationFilterAdapter.setFilteredDataItems(list);
        this.f12099a.selectedPosition = -1;
        this.f12099a.getSelectedItem().clear();
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = this.f12099a.getFilteredDataItems();
        return filterResults;
    }

    public void publishResults(@NotNull CharSequence charSequence, @NotNull Filter.FilterResults filterResults) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(filterResults, "filterResults");
        VendorLocationFilterAdapter vendorLocationFilterAdapter = this.f12099a;
        Object obj = filterResults.values;
        if (obj != null) {
            vendorLocationFilterAdapter.setFilteredDataItems(TypeIntrinsics.asMutableList(obj));
            this.f12099a.notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel>");
    }
}
