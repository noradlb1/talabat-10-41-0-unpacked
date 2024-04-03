package com.checkout.frames.style.theme.paymentform;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.mapper.theme.BillingFormStyleMapper;
import com.checkout.frames.mapper.theme.PaymentDetailsStyleMapper;
import com.checkout.frames.mapper.theme.PaymentFormMapper;
import com.checkout.frames.style.screen.PaymentFormStyle;
import com.checkout.frames.style.theme.PaymentFormTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/style/theme/paymentform/PaymentFormStyleProvider;", "", "()V", "provide", "Lcom/checkout/frames/style/screen/PaymentFormStyle;", "theme", "Lcom/checkout/frames/style/theme/PaymentFormTheme;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormStyleProvider {
    public static final int $stable = 0;
    @NotNull
    public static final PaymentFormStyleProvider INSTANCE = new PaymentFormStyleProvider();

    private PaymentFormStyleProvider() {
    }

    @NotNull
    public final PaymentFormStyle provide(@NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormTheme, "theme");
        return new PaymentFormMapper(new PaymentDetailsStyleMapper(), new BillingFormStyleMapper()).map(paymentFormTheme);
    }
}
