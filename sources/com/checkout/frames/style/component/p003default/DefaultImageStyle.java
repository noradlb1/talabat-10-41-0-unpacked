package com.checkout.frames.style.component.p003default;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.Padding;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.utils.constants.ButtonStyleConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/checkout/frames/style/component/default/DefaultImageStyle;", "", "()V", "buttonTrailingImageStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "image", "", "tinColor", "", "height", "width", "padding", "Lcom/checkout/frames/model/Padding;", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/checkout/frames/model/Padding;)Lcom/checkout/frames/style/component/base/ImageStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.component.default.DefaultImageStyle  reason: invalid package */
public final class DefaultImageStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultImageStyle INSTANCE = new DefaultImageStyle();

    private DefaultImageStyle() {
    }

    public static /* synthetic */ ImageStyle buttonTrailingImageStyle$default(DefaultImageStyle defaultImageStyle, int i11, Long l11, Integer num, Integer num2, Padding padding, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = R.drawable.cko_ic_caret_right;
        }
        if ((i12 & 2) != 0) {
            l11 = 4278935536L;
        }
        Long l12 = l11;
        if ((i12 & 4) != 0) {
            num = 12;
        }
        Integer num3 = num;
        if ((i12 & 8) != 0) {
            num2 = null;
        }
        Integer num4 = num2;
        if ((i12 & 16) != 0) {
            padding = ButtonStyleConstants.INSTANCE.getTrailingIconPadding();
        }
        return defaultImageStyle.buttonTrailingImageStyle(i11, l12, num3, num4, padding);
    }

    @NotNull
    @JvmOverloads
    public final ImageStyle buttonTrailingImageStyle() {
        return buttonTrailingImageStyle$default(this, 0, (Long) null, (Integer) null, (Integer) null, (Padding) null, 31, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ImageStyle buttonTrailingImageStyle(int i11) {
        return buttonTrailingImageStyle$default(this, i11, (Long) null, (Integer) null, (Integer) null, (Padding) null, 30, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ImageStyle buttonTrailingImageStyle(int i11, @Nullable Long l11) {
        return buttonTrailingImageStyle$default(this, i11, l11, (Integer) null, (Integer) null, (Padding) null, 28, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ImageStyle buttonTrailingImageStyle(int i11, @Nullable Long l11, @Nullable Integer num) {
        return buttonTrailingImageStyle$default(this, i11, l11, num, (Integer) null, (Padding) null, 24, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ImageStyle buttonTrailingImageStyle(int i11, @Nullable Long l11, @Nullable Integer num, @Nullable Integer num2) {
        return buttonTrailingImageStyle$default(this, i11, l11, num, num2, (Padding) null, 16, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final ImageStyle buttonTrailingImageStyle(int i11, @Nullable Long l11, @Nullable Integer num, @Nullable Integer num2, @Nullable Padding padding) {
        return new ImageStyle(Integer.valueOf(i11), l11, num, num2, padding);
    }
}
