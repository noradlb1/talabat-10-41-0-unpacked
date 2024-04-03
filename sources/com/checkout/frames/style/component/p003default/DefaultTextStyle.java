package com.checkout.frames.style.component.p003default;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.TextAlign;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.utils.constants.PlaceHolderConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultTextStyle;", "", "()V", "placeHolder", "Lcom/checkout/frames/style/component/base/TextStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultTextStyle  reason: invalid package */
public final class DefaultTextStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultTextStyle INSTANCE = new DefaultTextStyle();

    private DefaultTextStyle() {
    }

    @NotNull
    public final TextStyle placeHolder() {
        return new TextStyle(16, 4285690482L, (TextAlign) null, PlaceHolderConstants.INSTANCE.getFont(), (FontStyle) null, (FontWeight) null, 1, (Integer) null, (Integer) null, 436, (DefaultConstructorMarker) null);
    }
}
