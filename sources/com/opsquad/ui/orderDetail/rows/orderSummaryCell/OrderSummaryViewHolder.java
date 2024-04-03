package com.opsquad.ui.orderDetail.rows.orderSummaryCell;

import android.view.View;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.opsquad.R;
import com.opsquad.ui.orderDetail.rows.BaseRowViewHolder;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u000f"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/orderSummaryCell/OrderSummaryViewHolder;", "Lcom/opsquad/ui/orderDetail/rows/BaseRowViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bindView", "", "model", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/orderSummaryCell/OrderSummaryDisplayModel;", "fillItemChoices", "itemChoices", "", "fillSpecialRequest", "specialRequestString", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderSummaryViewHolder extends BaseRowViewHolder {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OrderSummaryViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.opsquad.R.layout.item_summary_cell
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …mary_cell, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opsquad.ui.orderDetail.rows.orderSummaryCell.OrderSummaryViewHolder.<init>(android.view.ViewGroup):void");
    }

    private final void fillItemChoices(String str) {
        boolean z11;
        View view = this.itemView;
        int i11 = R.id.item_choices_name;
        ((TextView) view.findViewById(i11)).setText(str);
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            TextView textView = (TextView) this.itemView.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.item_choices_name");
            ViewKt.invisible(textView);
            return;
        }
        TextView textView2 = (TextView) this.itemView.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(textView2, "itemView.item_choices_name");
        ViewKt.visible(textView2);
    }

    private final void fillSpecialRequest(String str) {
        boolean z11;
        View view = this.itemView;
        int i11 = R.id.item_special_request;
        ((TextView) view.findViewById(i11)).setText(str);
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            TextView textView = (TextView) this.itemView.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.item_special_request");
            ViewKt.invisible(textView);
            return;
        }
        TextView textView2 = (TextView) this.itemView.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(textView2, "itemView.item_special_request");
        ViewKt.visible(textView2);
    }

    public void bindView(@NotNull RowDisplayModel rowDisplayModel) {
        Intrinsics.checkNotNullParameter(rowDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        bindView((OrderSummaryDisplayModel) rowDisplayModel);
    }

    public final void bindView(@NotNull OrderSummaryDisplayModel orderSummaryDisplayModel) {
        Intrinsics.checkNotNullParameter(orderSummaryDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        ((TextView) this.itemView.findViewById(R.id.item_name)).setText(orderSummaryDisplayModel.getOrderDescription());
        ((TextView) this.itemView.findViewById(R.id.item_quantity)).setText(orderSummaryDisplayModel.getOrderQuantity());
        ((TextView) this.itemView.findViewById(R.id.item_price)).setText(orderSummaryDisplayModel.getOrderPrice());
        fillItemChoices(orderSummaryDisplayModel.getItemChoices());
        fillSpecialRequest(orderSummaryDisplayModel.getSpecialRequest());
    }
}
