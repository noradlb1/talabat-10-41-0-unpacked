package com.checkout.frames.style.screen.p004default;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.CursorStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.component.p003default.DefaultLightStyle;
import com.checkout.frames.style.component.p003default.DefaultTextLabelStyle;
import com.checkout.frames.style.screen.CountryPickerStyle;
import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/checkout/frames/style/screen/default/DefaultCountryPickerStyle;", "", "()V", "light", "Lcom/checkout/frames/style/screen/CountryPickerStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.screen.default.DefaultCountryPickerStyle  reason: invalid package */
public final class DefaultCountryPickerStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultCountryPickerStyle INSTANCE = new DefaultCountryPickerStyle();

    private DefaultCountryPickerStyle() {
    }

    @NotNull
    public final CountryPickerStyle light() {
        DefaultLightStyle defaultLightStyle = DefaultLightStyle.INSTANCE;
        TextLabelStyle screenTitleTextLabelStyle = defaultLightStyle.screenTitleTextLabelStyle(new Padding(14, 16, 0, 0));
        InputFieldStyle inputFieldStyle$default = DefaultLightStyle.inputFieldStyle$default(defaultLightStyle, true, (KeyboardOptions) null, 2, (Object) null);
        InputFieldIndicatorStyle.Border border = new InputFieldIndicatorStyle.Border((Shape) null, (CornerRadius) null, 1, 0, CountryPickerScreenConstants.focusedBorderColor, 4287269514L, 0, 0, 203, (DefaultConstructorMarker) null);
        ContainerStyle containerStyle = new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, new Margin(0, 16, 16, 16, 1, (DefaultConstructorMarker) null), 127, (DefaultConstructorMarker) null);
        int i11 = R.string.cko_search_county_placeholder;
        return new CountryPickerStyle(screenTitleTextLabelStyle, InputFieldStyle.copy$default(inputFieldStyle$default, (TextStyle) null, (String) null, Integer.valueOf(i11), (TextStyle) null, containerStyle, border, new ImageStyle((Integer) null, (Long) null, (Integer) null, (Integer) null, (Padding) null, 31, (DefaultConstructorMarker) null), new ImageStyle((Integer) null, (Long) null, (Integer) null, (Integer) null, (Padding) null, 31, (DefaultConstructorMarker) null), (CursorStyle) null, (KeyboardOptions) null, 779, (Object) null), DefaultTextLabelStyle.title$default(DefaultTextLabelStyle.INSTANCE, (String) null, (Integer) null, 16, (Font) null, (FontWeight) null, CountryPickerScreenConstants.searchItemFontColor, new Padding(16, 16, 24, 24), 0, (Integer) null, (ImageStyle) null, (ImageStyle) null, 1947, (Object) null), (ContainerStyle) null, false, 24, (DefaultConstructorMarker) null);
    }
}
