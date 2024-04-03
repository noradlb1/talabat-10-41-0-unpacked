package com.talabat.talabatlife.ui.vendorList.views;

import android.widget.TextView;
import com.talabat.talabatlife.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorListViewHolderOutSideArea;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorsListViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "area", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListViewHolderOutSideArea extends VendorsListViewHolder {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VendorListViewHolderOutSideArea(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.talabat.talabatlife.R.layout.view_holder_vendor_outside_area
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …side_area, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.vendorList.views.VendorListViewHolderOutSideArea.<init>(android.view.ViewGroup):void");
    }

    public void populate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "area");
        ((TextView) this.itemView.findViewById(R.id.vendorOutSideAreaTextView)).setText(str);
    }
}
