package com.checkout.frames.style.component.p003default;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.utils.constants.AddressSummaryConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultAddressSummaryComponentStyle;", "", "()V", "light", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "isOptional", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultAddressSummaryComponentStyle  reason: invalid package */
public final class DefaultAddressSummaryComponentStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultAddressSummaryComponentStyle INSTANCE = new DefaultAddressSummaryComponentStyle();

    private DefaultAddressSummaryComponentStyle() {
    }

    public static /* synthetic */ AddressSummaryComponentStyle light$default(DefaultAddressSummaryComponentStyle defaultAddressSummaryComponentStyle, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return defaultAddressSummaryComponentStyle.light(z11);
    }

    @NotNull
    @JvmOverloads
    public final AddressSummaryComponentStyle light() {
        return light$default(this, false, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final AddressSummaryComponentStyle light(boolean z11) {
        TextLabelStyle textLabelStyle;
        DefaultTextLabelStyle defaultTextLabelStyle = DefaultTextLabelStyle.INSTANCE;
        TextLabelStyle title$default = DefaultTextLabelStyle.title$default(defaultTextLabelStyle, (String) null, Integer.valueOf(R.string.cko_billing_address), 0, (Font) null, (FontWeight) null, 0, (Padding) null, 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 2045, (Object) null);
        if (z11) {
            textLabelStyle = null;
        } else {
            textLabelStyle = DefaultTextLabelStyle.subtitle$default(defaultTextLabelStyle, (String) null, Integer.valueOf(R.string.cko_billing_address_info), 0, (Font) null, 0, (Padding) null, 0, (Integer) null, 253, (Object) null);
        }
        TextLabelStyle textLabelStyle2 = textLabelStyle;
        DefaultButtonStyle defaultButtonStyle = DefaultButtonStyle.INSTANCE;
        DefaultButtonStyle defaultButtonStyle2 = defaultButtonStyle;
        Integer valueOf = Integer.valueOf(R.string.cko_add_billing_address);
        DefaultImageStyle defaultImageStyle = DefaultImageStyle.INSTANCE;
        ImageStyle buttonTrailingImageStyle$default = DefaultImageStyle.buttonTrailingImageStyle$default(defaultImageStyle, 0, (Long) null, (Integer) null, (Integer) null, (Padding) null, 31, (Object) null);
        Margin margin = r0;
        Margin margin2 = new Margin(8, 24, 0, 0, 12, (DefaultConstructorMarker) null);
        ButtonStyle lightOutline$default = DefaultButtonStyle.lightOutline$default(defaultButtonStyle, (String) null, valueOf, 0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Padding) null, (ImageStyle) null, buttonTrailingImageStyle$default, margin, (FontWeight) null, 10237, (Object) null);
        AddressSummaryConstants addressSummaryConstants = AddressSummaryConstants.INSTANCE;
        TextLabelStyle text$default = DefaultTextLabelStyle.text$default(defaultTextLabelStyle, (String) null, (Integer) null, 0, (Font) null, 0, addressSummaryConstants.getAddressSummaryTextPadding(), 0, 24, 95, (Object) null);
        DividerStyle dividerStyle = new DividerStyle(0, addressSummaryConstants.getDividerColor(), (Margin) null, 5, (DefaultConstructorMarker) null);
        int i11 = R.string.cko_edit_billing_address;
        ImageStyle buttonTrailingImageStyle$default2 = DefaultImageStyle.buttonTrailingImageStyle$default(defaultImageStyle, 0, (Long) null, (Integer) null, (Integer) null, (Padding) null, 31, (Object) null);
        CornerRadius cornerRadius = r0;
        CornerRadius cornerRadius2 = new CornerRadius(0, 0, 8, 8, 3, (DefaultConstructorMarker) null);
        ButtonStyle lightSolid$default = DefaultButtonStyle.lightSolid$default(defaultButtonStyle2, (String) null, Integer.valueOf(i11), 0, 0, 0, 0, (Shape) null, cornerRadius, (Padding) null, (ImageStyle) null, buttonTrailingImageStyle$default2, (Margin) null, (FontWeight) null, 7037, (Object) null);
        Shape shape = Shape.RoundCorner;
        CornerRadius cornerRadius3 = new CornerRadius(8);
        return new AddressSummaryComponentStyle(title$default, textLabelStyle2, lightOutline$default, new AddressSummarySectionStyle(text$default, dividerStyle, lightSolid$default, new ContainerStyle(0, shape, cornerRadius3, new BorderStroke(1, 4287269514L), (Integer) null, (Integer) null, (Padding) null, new Margin(8, 24, 0, 0, 12, (DefaultConstructorMarker) null), 113, (DefaultConstructorMarker) null)), (ContainerStyle) null, z11, 16, (DefaultConstructorMarker) null);
    }
}
