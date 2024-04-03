package com.opsquad.ui.orderDetail.rows.vendorInfoCell;

import android.graphics.Typeface;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.opsquad.R;
import com.opsquad.ui.orderDetail.model.enums.OrderStatusStyle;
import com.opsquad.ui.orderDetail.rows.BaseRowViewHolder;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.talabat.talabatcommon.views.TalabatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/vendorInfoCell/VendorInfoViewHolder;", "Lcom/opsquad/ui/orderDetail/rows/BaseRowViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bindView", "", "model", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/vendorInfoCell/VendorInfoRowDisplayModel;", "setStyle", "paymentItemStyle", "Lcom/opsquad/ui/orderDetail/model/enums/OrderStatusStyle;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoViewHolder extends BaseRowViewHolder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrderStatusStyle.values().length];
            iArr[OrderStatusStyle.POSITIVE.ordinal()] = 1;
            iArr[OrderStatusStyle.NEGATIVE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VendorInfoViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.opsquad.R.layout.vendor_info_cell
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …info_cell, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opsquad.ui.orderDetail.rows.vendorInfoCell.VendorInfoViewHolder.<init>(android.view.ViewGroup):void");
    }

    private final void setStyle() {
        ((TextView) this.itemView.findViewById(R.id.order_details_restaurant_name)).setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void bindView(@NotNull RowDisplayModel rowDisplayModel) {
        Intrinsics.checkNotNullParameter(rowDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        bindView((VendorInfoRowDisplayModel) rowDisplayModel);
    }

    private final void setStyle(OrderStatusStyle orderStatusStyle) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[orderStatusStyle.ordinal()];
        if (i11 == 1) {
            ((TextView) this.itemView.findViewById(R.id.order_details_status)).setTextColor(-16711936);
        } else if (i11 == 2) {
            ((TextView) this.itemView.findViewById(R.id.order_details_status)).setTextColor(-65536);
        }
    }

    public final void bindView(@NotNull VendorInfoRowDisplayModel vendorInfoRowDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorInfoRowDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ((TextView) this.itemView.findViewById(R.id.order_details_restaurant_name)).setText(vendorInfoRowDisplayModel.getVendorName());
        ((TextView) this.itemView.findViewById(R.id.order_time)).setText(vendorInfoRowDisplayModel.getOrderTime());
        ((TextView) this.itemView.findViewById(R.id.order_details_orderId)).setText(vendorInfoRowDisplayModel.getOrderID());
        ((TextView) this.itemView.findViewById(R.id.order_details_status)).setText(vendorInfoRowDisplayModel.getOrderStatus());
        ((TalabatImageView) this.itemView.findViewById(R.id.rest_logo_ImageView)).setImageUrl(vendorInfoRowDisplayModel.getRestaurantLogoUrl());
        setStyle(vendorInfoRowDisplayModel.getOrderStatusStyle());
        setStyle();
    }
}
