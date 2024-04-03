package com.checkout.frames.style.component.p003default;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultCardNumberComponentStyle;", "", "()V", "light", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultCardNumberComponentStyle  reason: invalid package */
public final class DefaultCardNumberComponentStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultCardNumberComponentStyle INSTANCE = new DefaultCardNumberComponentStyle();

    private DefaultCardNumberComponentStyle() {
    }

    @NotNull
    public final CardNumberComponentStyle light() {
        return new CardNumberComponentStyle(DefaultLightStyle.inputComponentStyle$default(DefaultLightStyle.INSTANCE, (String) null, Integer.valueOf(R.string.cko_card_number_title), (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, true, (Padding) null, new Margin(0, 24, 0, 0, 13, (DefaultConstructorMarker) null), false, (KeyboardOptions) null, 6909, (Object) null), 0, 2, (DefaultConstructorMarker) null);
    }
}
