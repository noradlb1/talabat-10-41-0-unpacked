package com.opsquad.ui.orderDetail.rows.paymentItemCell;

import com.opsquad.ui.orderDetail.model.enums.FontStyle;
import com.opsquad.ui.orderDetail.model.enums.PaymentItemStyle;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/paymentItemCell/PaymentItemDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "title", "", "value", "theme", "Lcom/opsquad/ui/orderDetail/model/enums/PaymentItemStyle;", "font", "Lcom/opsquad/ui/orderDetail/model/enums/FontStyle;", "(Ljava/lang/String;Ljava/lang/String;Lcom/opsquad/ui/orderDetail/model/enums/PaymentItemStyle;Lcom/opsquad/ui/orderDetail/model/enums/FontStyle;)V", "getFont", "()Lcom/opsquad/ui/orderDetail/model/enums/FontStyle;", "setFont", "(Lcom/opsquad/ui/orderDetail/model/enums/FontStyle;)V", "getTheme", "()Lcom/opsquad/ui/orderDetail/model/enums/PaymentItemStyle;", "setTheme", "(Lcom/opsquad/ui/orderDetail/model/enums/PaymentItemStyle;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getValue", "setValue", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentItemDisplayModel extends RowDisplayModel {
    @NotNull
    private FontStyle font;
    @NotNull
    private PaymentItemStyle theme;
    @NotNull
    private String title;
    @NotNull
    private String value;

    public PaymentItemDisplayModel() {
        this((String) null, (String) null, (PaymentItemStyle) null, (FontStyle) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentItemDisplayModel(String str, String str2, PaymentItemStyle paymentItemStyle, FontStyle fontStyle, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? PaymentItemStyle.REGULAR : paymentItemStyle, (i11 & 8) != 0 ? FontStyle.NORMAL : fontStyle);
    }

    @NotNull
    public final FontStyle getFont() {
        return this.font;
    }

    @NotNull
    public final PaymentItemStyle getTheme() {
        return this.theme;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final void setFont(@NotNull FontStyle fontStyle) {
        Intrinsics.checkNotNullParameter(fontStyle, "<set-?>");
        this.font = fontStyle;
    }

    public final void setTheme(@NotNull PaymentItemStyle paymentItemStyle) {
        Intrinsics.checkNotNullParameter(paymentItemStyle, "<set-?>");
        this.theme = paymentItemStyle;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public PaymentItemDisplayModel(@NotNull String str, @NotNull String str2, @NotNull PaymentItemStyle paymentItemStyle, @NotNull FontStyle fontStyle) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(paymentItemStyle, "theme");
        Intrinsics.checkNotNullParameter(fontStyle, "font");
        this.title = str;
        this.value = str2;
        this.theme = paymentItemStyle;
        this.font = fontStyle;
    }
}
