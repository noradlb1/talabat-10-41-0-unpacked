package com.checkout.frames.style.component.p003default;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.CursorStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultCountryComponentStyle;", "", "()V", "light", "Lcom/checkout/frames/style/component/CountryComponentStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultCountryComponentStyle  reason: invalid package */
public final class DefaultCountryComponentStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultCountryComponentStyle INSTANCE = new DefaultCountryComponentStyle();

    private DefaultCountryComponentStyle() {
    }

    @NotNull
    public final CountryComponentStyle light() {
        DefaultLightStyle defaultLightStyle = DefaultLightStyle.INSTANCE;
        return new CountryComponentStyle(InputComponentStyle.copy$default(DefaultLightStyle.inputComponentStyle$default(defaultLightStyle, (String) null, Integer.valueOf(R.string.cko_country_picker_screen_title), (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, false, (KeyboardOptions) null, 7677, (Object) null), (TextLabelStyle) null, (TextLabelStyle) null, (TextLabelStyle) null, InputFieldStyle.copy$default(DefaultLightStyle.inputFieldStyle$default(defaultLightStyle, false, (KeyboardOptions) null, 3, (Object) null), (TextStyle) null, (String) null, (Integer) null, (TextStyle) null, (ContainerStyle) null, new InputFieldIndicatorStyle.Border((Shape) null, (CornerRadius) null, 0, 0, 4287269514L, 4287269514L, 4287269514L, 0, Opcodes.D2L, (DefaultConstructorMarker) null), (ImageStyle) null, new ImageStyle(Integer.valueOf(R.drawable.cko_ic_caret_right), (Long) null, (Integer) null, (Integer) null, (Padding) null, 30, (DefaultConstructorMarker) null), (CursorStyle) null, (KeyboardOptions) null, 863, (Object) null), (TextLabelStyle) null, (ContainerStyle) null, false, 119, (Object) null));
    }
}
