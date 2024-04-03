package com.checkout.frames.utils.constants;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.Padding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/checkout/frames/utils/constants/ButtonStyleConstants;", "", "()V", "colorTransparent", "", "getColorTransparent", "()J", "outlineContentPadding", "Lcom/checkout/frames/model/Padding;", "getOutlineContentPadding", "()Lcom/checkout/frames/model/Padding;", "outlineStrokeColor", "getOutlineStrokeColor", "solidContentPadding", "getSolidContentPadding", "trailingIconHeight", "", "trailingIconPadding", "getTrailingIconPadding", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonStyleConstants {
    public static final int $stable = 0;
    @NotNull
    public static final ButtonStyleConstants INSTANCE = new ButtonStyleConstants();
    private static final long colorTransparent = 0;
    @NotNull
    private static final Padding outlineContentPadding = new Padding(8, 8, 16, 16);
    private static final long outlineStrokeColor = 4286618109L;
    @NotNull
    private static final Padding solidContentPadding = new Padding(14, 16, 24, 24);
    public static final int trailingIconHeight = 12;
    @NotNull
    private static final Padding trailingIconPadding = new Padding(0, 0, 12, 0, 11, (DefaultConstructorMarker) null);

    private ButtonStyleConstants() {
    }

    public final long getColorTransparent() {
        return colorTransparent;
    }

    @NotNull
    public final Padding getOutlineContentPadding() {
        return outlineContentPadding;
    }

    public final long getOutlineStrokeColor() {
        return outlineStrokeColor;
    }

    @NotNull
    public final Padding getSolidContentPadding() {
        return solidContentPadding;
    }

    @NotNull
    public final Padding getTrailingIconPadding() {
        return trailingIconPadding;
    }
}
