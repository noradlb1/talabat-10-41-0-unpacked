package com.checkout.frames.utils.constants;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/utils/constants/PaymentButtonConstants;", "", "()V", "buttonMargin", "Lcom/checkout/frames/model/Margin;", "getButtonMargin", "()Lcom/checkout/frames/model/Margin;", "containerColor", "", "getContainerColor", "()J", "contentColor", "getContentColor", "contentPadding", "Lcom/checkout/frames/model/Padding;", "getContentPadding", "()Lcom/checkout/frames/model/Padding;", "disabledContainerColor", "getDisabledContainerColor", "disabledContentColor", "getDisabledContentColor", "fontWeight", "Lcom/checkout/frames/model/font/FontWeight;", "getFontWeight", "()Lcom/checkout/frames/model/font/FontWeight;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentButtonConstants {
    public static final int $stable = 0;
    @NotNull
    public static final PaymentButtonConstants INSTANCE = new PaymentButtonConstants();
    @NotNull
    private static final Margin buttonMargin = new Margin(12, 24, 0, 0, 12, (DefaultConstructorMarker) null);
    private static final long containerColor = 4278935536L;
    private static final long contentColor = 4294967295L;
    @NotNull
    private static final Padding contentPadding = new Padding(18);
    private static final long disabledContainerColor = 4293980400L;
    private static final long disabledContentColor = 4284703587L;
    @NotNull
    private static final FontWeight fontWeight = FontWeight.SemiBold;

    private PaymentButtonConstants() {
    }

    @NotNull
    public final Margin getButtonMargin() {
        return buttonMargin;
    }

    public final long getContainerColor() {
        return containerColor;
    }

    public final long getContentColor() {
        return contentColor;
    }

    @NotNull
    public final Padding getContentPadding() {
        return contentPadding;
    }

    public final long getDisabledContainerColor() {
        return disabledContainerColor;
    }

    public final long getDisabledContentColor() {
        return disabledContentColor;
    }

    @NotNull
    public final FontWeight getFontWeight() {
        return fontWeight;
    }
}
