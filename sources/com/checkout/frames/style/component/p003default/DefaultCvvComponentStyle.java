package com.checkout.frames.style.component.p003default;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.style.component.CvvComponentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultCvvComponentStyle;", "", "()V", "light", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultCvvComponentStyle  reason: invalid package */
public final class DefaultCvvComponentStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultCvvComponentStyle INSTANCE = new DefaultCvvComponentStyle();

    private DefaultCvvComponentStyle() {
    }

    @NotNull
    public final CvvComponentStyle light() {
        return new CvvComponentStyle(DefaultLightStyle.inputComponentStyle$default(DefaultLightStyle.INSTANCE, (String) null, Integer.valueOf(R.string.cko_cvv_component_title), (String) null, Integer.valueOf(R.string.cko_cvv_component_subtitle), (String) null, (Integer) null, (String) null, (Integer) null, false, (Padding) null, new Margin(0, 24, 0, 0, 13, (DefaultConstructorMarker) null), false, (KeyboardOptions) null, 7157, (Object) null));
    }
}
