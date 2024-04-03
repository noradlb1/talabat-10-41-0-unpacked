package com.checkout.frames.style.component.p003default;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.utils.constants.PaymentButtonConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultPayButtonComponentStyle;", "", "()V", "light", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultPayButtonComponentStyle  reason: invalid package */
public final class DefaultPayButtonComponentStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultPayButtonComponentStyle INSTANCE = new DefaultPayButtonComponentStyle();

    private DefaultPayButtonComponentStyle() {
    }

    @NotNull
    public final PayButtonComponentStyle light() {
        DefaultButtonStyle defaultButtonStyle = DefaultButtonStyle.INSTANCE;
        int i11 = R.string.cko_pay;
        PaymentButtonConstants paymentButtonConstants = PaymentButtonConstants.INSTANCE;
        long contentColor = paymentButtonConstants.getContentColor();
        long containerColor = paymentButtonConstants.getContainerColor();
        long disabledContentColor = paymentButtonConstants.getDisabledContentColor();
        long disabledContainerColor = paymentButtonConstants.getDisabledContainerColor();
        Padding contentPadding = paymentButtonConstants.getContentPadding();
        FontWeight fontWeight = paymentButtonConstants.getFontWeight();
        return new PayButtonComponentStyle(DefaultButtonStyle.lightSolid$default(defaultButtonStyle, (String) null, Integer.valueOf(i11), contentColor, containerColor, disabledContentColor, disabledContainerColor, (Shape) null, (CornerRadius) null, contentPadding, (ImageStyle) null, (ImageStyle) null, paymentButtonConstants.getButtonMargin(), fontWeight, 1729, (Object) null));
    }
}
