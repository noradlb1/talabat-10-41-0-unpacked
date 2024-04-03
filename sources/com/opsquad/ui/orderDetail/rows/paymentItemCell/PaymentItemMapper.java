package com.opsquad.ui.orderDetail.rows.paymentItemCell;

import com.opsquad.features.orderDetails.models.responses.OrderDetailResponse;
import com.opsquad.ui.orderDetail.model.enums.FontStyle;
import com.opsquad.ui.orderDetail.model.enums.PaymentItemStyle;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.FloatKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002JJ\u0010\r\u001a\u00020\u000e*\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\nH\u0002J$\u0010\u0015\u001a\u00020\u000e*\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\u0016\u001a\u00020\u000e*\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0017"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/paymentItemCell/PaymentItemMapper;", "", "()V", "buildPaymentContent", "Ljava/util/ArrayList;", "Lcom/opsquad/ui/orderDetail/rows/paymentItemCell/PaymentItemDisplayModel;", "Lkotlin/collections/ArrayList;", "orderDetailResponse", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "hasValidValue", "", "itemValue", "", "addPaymentInfoItem", "", "itemName", "style", "Lcom/opsquad/ui/orderDetail/model/enums/PaymentItemStyle;", "fontStyle", "Lcom/opsquad/ui/orderDetail/model/enums/FontStyle;", "isMandatory", "gemsPaymentItems", "talabatPaymentItems", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentItemMapper {
    public static /* synthetic */ void a(PaymentItemMapper paymentItemMapper, ArrayList arrayList, String str, String str2, PaymentItemStyle paymentItemStyle, FontStyle fontStyle, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            paymentItemStyle = PaymentItemStyle.REGULAR;
        }
        PaymentItemStyle paymentItemStyle2 = paymentItemStyle;
        if ((i11 & 8) != 0) {
            fontStyle = FontStyle.NORMAL;
        }
        FontStyle fontStyle2 = fontStyle;
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        paymentItemMapper.addPaymentInfoItem(arrayList, str, str2, paymentItemStyle2, fontStyle2, z11);
    }

    private final void addPaymentInfoItem(ArrayList<PaymentItemDisplayModel> arrayList, String str, String str2, PaymentItemStyle paymentItemStyle, FontStyle fontStyle, boolean z11) {
        if (z11 || hasValidValue(str2)) {
            arrayList.add(new PaymentItemDisplayModel(str, str2, paymentItemStyle, fontStyle));
        }
    }

    private final void gemsPaymentItems(ArrayList<PaymentItemDisplayModel> arrayList, OrderDetailResponse orderDetailResponse) {
        if (!FloatKt.isZero$default(orderDetailResponse.getGemDiscoundOrderAmount(), 0.0d, 1, (Object) null) && orderDetailResponse.isGemOrder()) {
            a(this, arrayList, String.valueOf(R.string.saving_amount), String.valueOf(orderDetailResponse.getGemDiscoundOrderAmount()), (PaymentItemStyle) null, (FontStyle) null, false, 28, (Object) null);
        }
    }

    private final boolean hasValidValue(String str) {
        try {
            return Float.parseFloat(str) > 0.0f;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    private final void talabatPaymentItems(ArrayList<PaymentItemDisplayModel> arrayList, OrderDetailResponse orderDetailResponse) {
        if (!FloatKt.isZero$default(orderDetailResponse.getTalabatCharges(), 0.0d, 1, (Object) null)) {
            a(this, arrayList, String.valueOf(R.string.talabat_charges), String.valueOf(orderDetailResponse.getTalabatCharges()), (PaymentItemStyle) null, (FontStyle) null, false, 28, (Object) null);
            return;
        }
        String valueOf = String.valueOf(R.string.delivery_fee);
        String alterDeliveryText = orderDetailResponse.getAlterDeliveryText();
        if (alterDeliveryText != null && (!StringsKt__StringsJVMKt.isBlank(alterDeliveryText))) {
            valueOf = alterDeliveryText;
        }
        a(this, arrayList, valueOf, String.valueOf(orderDetailResponse.getDeliveryCharges()), (PaymentItemStyle) null, (FontStyle) null, true, 12, (Object) null);
    }

    @NotNull
    public final ArrayList<PaymentItemDisplayModel> buildPaymentContent(@NotNull OrderDetailResponse orderDetailResponse) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(orderDetailResponse, "orderDetailResponse");
        ArrayList<PaymentItemDisplayModel> arrayList = new ArrayList<>();
        a(this, arrayList, String.valueOf(R.string.subtotal), String.valueOf(orderDetailResponse.getSubTotal()), (PaymentItemStyle) null, (FontStyle) null, false, 28, (Object) null);
        gemsPaymentItems(arrayList, orderDetailResponse);
        String valueOf = String.valueOf(R.string.voucher_discount);
        String valueOf2 = String.valueOf(orderDetailResponse.getVoucherDiscount());
        PaymentItemStyle paymentItemStyle = PaymentItemStyle.NEGATIVE;
        a(this, arrayList, valueOf, valueOf2, paymentItemStyle, (FontStyle) null, false, 24, (Object) null);
        a(this, arrayList, String.valueOf(R.string.discount), String.valueOf(orderDetailResponse.getCouponDiscount()), paymentItemStyle, (FontStyle) null, false, 24, (Object) null);
        a(this, arrayList, String.valueOf(R.string.municipality_tax), String.valueOf(orderDetailResponse.getMunicipalityTax()), (PaymentItemStyle) null, (FontStyle) null, false, 28, (Object) null);
        a(this, arrayList, String.valueOf(R.string.tourist_tax), String.valueOf(orderDetailResponse.getTouristTax()), (PaymentItemStyle) null, (FontStyle) null, false, 28, (Object) null);
        talabatPaymentItems(arrayList, orderDetailResponse);
        String valueOf3 = String.valueOf(R.string.total);
        String valueOf4 = String.valueOf(orderDetailResponse.getGrandTotal());
        FontStyle fontStyle = FontStyle.BOLD;
        a(this, arrayList, valueOf3, valueOf4, (PaymentItemStyle) null, fontStyle, false, 20, (Object) null);
        String valueOf5 = String.valueOf(R.string.payment_method);
        String paymentMethod = orderDetailResponse.getPaymentMethod();
        if (paymentMethod == null) {
            str = "";
        } else {
            str = paymentMethod;
        }
        a(this, arrayList, valueOf5, str, (PaymentItemStyle) null, fontStyle, true, 4, (Object) null);
        String valueOf6 = String.valueOf(R.string.delivery_time);
        String deliveryTime = orderDetailResponse.getDeliveryTime();
        if (deliveryTime == null) {
            str2 = "";
        } else {
            str2 = deliveryTime;
        }
        a(this, arrayList, valueOf6, str2, (PaymentItemStyle) null, fontStyle, true, 4, (Object) null);
        return arrayList;
    }
}
