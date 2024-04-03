package com.opsquad.ui.orderDetail.rows.paymentItemCell;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.opsquad.R;
import com.opsquad.ui.orderDetail.model.enums.FontStyle;
import com.opsquad.ui.orderDetail.model.enums.PaymentItemStyle;
import com.opsquad.ui.orderDetail.rows.BaseRowViewHolder;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.views.TalabatPriceTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/paymentItemCell/PaymentItemViewHolder;", "Lcom/opsquad/ui/orderDetail/rows/BaseRowViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bindView", "", "model", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/paymentItemCell/PaymentItemDisplayModel;", "setFontStyle", "fontStyle", "Lcom/opsquad/ui/orderDetail/model/enums/FontStyle;", "setStyle", "paymentItemStyle", "Lcom/opsquad/ui/orderDetail/model/enums/PaymentItemStyle;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentItemViewHolder extends BaseRowViewHolder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaymentItemStyle.values().length];
            iArr[PaymentItemStyle.NEGATIVE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FontStyle.values().length];
            iArr2[FontStyle.BOLD.ordinal()] = 1;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentItemViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.opsquad.R.layout.payment_item_cell
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …item_cell, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opsquad.ui.orderDetail.rows.paymentItemCell.PaymentItemViewHolder.<init>(android.view.ViewGroup):void");
    }

    private final void setFontStyle(FontStyle fontStyle) {
        if (WhenMappings.$EnumSwitchMapping$1[fontStyle.ordinal()] == 1) {
            ((TextView) this.itemView.findViewById(R.id.payment_label)).setTypeface(Typeface.DEFAULT_BOLD);
            ((TalabatPriceTextView) this.itemView.findViewById(R.id.payment_value)).setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    private final void setStyle(PaymentItemStyle paymentItemStyle) {
        if (WhenMappings.$EnumSwitchMapping$0[paymentItemStyle.ordinal()] == 1) {
            ((TextView) this.itemView.findViewById(R.id.payment_label)).setTextColor(-65536);
            ((TalabatPriceTextView) this.itemView.findViewById(R.id.payment_value)).setTextColor(-65536);
        }
    }

    public void bindView(@NotNull RowDisplayModel rowDisplayModel) {
        Intrinsics.checkNotNullParameter(rowDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        bindView((PaymentItemDisplayModel) rowDisplayModel);
    }

    public final void bindView(@NotNull PaymentItemDisplayModel paymentItemDisplayModel) {
        Intrinsics.checkNotNullParameter(paymentItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        String title = paymentItemDisplayModel.getTitle();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        ((TextView) this.itemView.findViewById(R.id.payment_label)).setText(StringUtils.localized(title, context));
        ((TalabatPriceTextView) this.itemView.findViewById(R.id.payment_value)).setText(paymentItemDisplayModel.getValue());
        setStyle(paymentItemDisplayModel.getTheme());
        setFontStyle(paymentItemDisplayModel.getFont());
    }
}
