package com.talabat.talabatlife.ui.vendorList.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorList.model.FilterType;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "addItemImageType", "", "vendorLocationFilterDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "bind", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLocationFilterViewHolder extends RecyclerView.ViewHolder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FilterType.values().length];
            iArr[FilterType.CURRENT_LOCATION_FILTER.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorLocationFilterViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    private final void addItemImageType(VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel) {
        if (WhenMappings.$EnumSwitchMapping$0[vendorLocationFilterDisplayModel.getFilterType().ordinal()] == 1) {
            ((ImageView) this.itemView.findViewById(R.id.location_icon)).setImageResource(com.talabat.talabatcommon.R.drawable.ic_m_location);
        } else {
            ((ImageView) this.itemView.findViewById(R.id.location_icon)).setImageResource(R.drawable.ic_vendor_branch);
        }
    }

    public final void bind(@NotNull VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterDisplayModel, "vendorLocationFilterDisplayModel");
        String areaName = vendorLocationFilterDisplayModel.getAreaName();
        String cityName = vendorLocationFilterDisplayModel.getCityName();
        addItemImageType(vendorLocationFilterDisplayModel);
        ((TextView) this.itemView.findViewById(R.id.area_name)).setText(areaName);
        ((TextView) this.itemView.findViewById(R.id.city_name)).setText(cityName);
    }
}
