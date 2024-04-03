package com.checkout.frames.utils.constants;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.R;
import com.checkout.frames.model.font.Font;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/checkout/frames/utils/constants/ErrorConstants;", "", "()V", "color", "", "errorMessageTopPadding", "", "font", "Lcom/checkout/frames/model/font/Font;", "getFont", "()Lcom/checkout/frames/model/font/Font;", "fontSize", "leadingIconEndPadding", "leadingIconId", "getLeadingIconId", "()I", "leadingIconSize", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ErrorConstants {
    public static final int $stable = 0;
    @NotNull
    public static final ErrorConstants INSTANCE = new ErrorConstants();
    public static final long color = 4289538110L;
    public static final int errorMessageTopPadding = 8;
    @NotNull
    private static final Font font = Font.SansSerif.INSTANCE;
    public static final int fontSize = 13;
    public static final int leadingIconEndPadding = 8;
    @DrawableRes
    private static final int leadingIconId = R.drawable.cko_ic_error;
    public static final int leadingIconSize = 15;

    private ErrorConstants() {
    }

    @NotNull
    public final Font getFont() {
        return font;
    }

    public final int getLeadingIconId() {
        return leadingIconId;
    }
}
