package com.opsquad.ui.orderDetail.rows.orderDetailheaderCell;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.opsquad.R;
import com.opsquad.ui.orderDetail.rows.BaseRowViewHolder;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/orderDetailheaderCell/OrderDetailsHeaderViewHolder;", "Lcom/opsquad/ui/orderDetail/rows/BaseRowViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bindView", "", "model", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/orderDetailheaderCell/OrderDetailHeaderDisplayModel;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsHeaderViewHolder extends BaseRowViewHolder {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OrderDetailsHeaderViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.opsquad.R.layout.header_title
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …der_title, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opsquad.ui.orderDetail.rows.orderDetailheaderCell.OrderDetailsHeaderViewHolder.<init>(android.view.ViewGroup):void");
    }

    public void bindView(@NotNull RowDisplayModel rowDisplayModel) {
        Intrinsics.checkNotNullParameter(rowDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        bindView((OrderDetailHeaderDisplayModel) rowDisplayModel);
    }

    public final void bindView(@NotNull OrderDetailHeaderDisplayModel orderDetailHeaderDisplayModel) {
        Intrinsics.checkNotNullParameter(orderDetailHeaderDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        int i11 = R.id.header_title;
        String headerTitle = orderDetailHeaderDisplayModel.getHeaderTitle();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        ((TextView) view.findViewById(i11)).setText(StringUtils.localized(headerTitle, context));
        ((TextView) this.itemView.findViewById(i11)).setTypeface(Typeface.DEFAULT_BOLD);
    }
}
