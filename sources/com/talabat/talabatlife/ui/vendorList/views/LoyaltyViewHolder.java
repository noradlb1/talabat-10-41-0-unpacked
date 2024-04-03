package com.talabat.talabatlife.ui.vendorList.views;

import android.view.View;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/LoyaltyViewHolder;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "clickListener", "Landroid/view/View$OnClickListener;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyViewHolder extends VendorsListViewHolder {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoyaltyViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.talabat.talabatlife.R.layout.reward_point_widget
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …nt_widget, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.vendorList.views.LoyaltyViewHolder.<init>(android.view.ViewGroup):void");
    }

    public void populate(@NotNull VendorDisplayModel vendorDisplayModel, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.itemView.setOnClickListener(onClickListener);
    }
}
