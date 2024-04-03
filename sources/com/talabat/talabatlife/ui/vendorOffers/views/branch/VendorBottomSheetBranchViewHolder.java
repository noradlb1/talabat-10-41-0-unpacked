package com.talabat.talabatlife.ui.vendorOffers.views.branch;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatcore.BaseViewHolder;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.views.branch.VendorBranchBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorBottomSheetBranchViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorBranchBase;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorBottomSheetBranchViewHolder extends BaseViewHolder<VendorBranchDisplayModel> implements VendorBranchBase {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorBottomSheetBranchViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_holder_vendor_branches_bottom_sheet);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @NotNull
    public String getDistance(@NotNull View view, double d11) {
        return VendorBranchBase.DefaultImpls.getDistance(this, view, d11);
    }

    public void setMapsOnClickListener(@NotNull View view, @NotNull VendorBranchDisplayModel vendorBranchDisplayModel) {
        VendorBranchBase.DefaultImpls.setMapsOnClickListener(this, view, vendorBranchDisplayModel);
    }

    public void populate(@NotNull VendorBranchDisplayModel vendorBranchDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorBranchDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "this");
        setMapsOnClickListener(view, vendorBranchDisplayModel);
        ((TextView) view.findViewById(R.id.vendorBranchesTitleTextView)).setText(vendorBranchDisplayModel.getName());
        ((TextView) view.findViewById(R.id.vendorBranchesSubTitleTextView)).setText(vendorBranchDisplayModel.getAddress());
        ((TextView) view.findViewById(R.id.vendorBranchesDistanceTextView)).setText(getDistance(view, vendorBranchDisplayModel.getDistanceInMeters()));
    }
}
