package com.talabat.talabatlife.ui.vendorList.views;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "populate", "", "model", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "clickListener", "Landroid/view/View$OnClickListener;", "area", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VendorsListViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void populate(@NotNull VendorDisplayModel vendorDisplayModel, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
    }

    public void populate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "area");
    }
}
