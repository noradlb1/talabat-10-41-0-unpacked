package com.checkout.frames.mapper.theme;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.screen.BillingFormStyle;
import com.checkout.frames.style.screen.PaymentDetailsStyle;
import com.checkout.frames.style.screen.PaymentFormStyle;
import com.checkout.frames.style.theme.PaymentFormTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0001\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/checkout/frames/mapper/theme/PaymentFormMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/theme/PaymentFormTheme;", "Lcom/checkout/frames/style/screen/PaymentFormStyle;", "paymentDetailsStyleMapper", "Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "billingFormStyleMapper", "Lcom/checkout/frames/style/screen/BillingFormStyle;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormMapper implements Mapper<PaymentFormTheme, PaymentFormStyle> {
    @NotNull
    private final Mapper<PaymentFormTheme, BillingFormStyle> billingFormStyleMapper;
    @NotNull
    private final Mapper<PaymentFormTheme, PaymentDetailsStyle> paymentDetailsStyleMapper;

    public PaymentFormMapper(@NotNull Mapper<PaymentFormTheme, PaymentDetailsStyle> mapper, @NotNull Mapper<PaymentFormTheme, BillingFormStyle> mapper2) {
        Intrinsics.checkNotNullParameter(mapper, "paymentDetailsStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "billingFormStyleMapper");
        this.paymentDetailsStyleMapper = mapper;
        this.billingFormStyleMapper = mapper2;
    }

    @NotNull
    public PaymentFormStyle map(@NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormTheme, "from");
        return new PaymentFormStyle(this.paymentDetailsStyleMapper.map(paymentFormTheme), this.billingFormStyleMapper.map(paymentFormTheme));
    }
}
