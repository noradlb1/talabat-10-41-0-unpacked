package com.checkout.frames.mapper;

import androidx.compose.runtime.MutableState;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/checkout/frames/mapper/ButtonStyleToInternalStateMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/view/InternalButtonState;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonStyleToInternalStateMapper implements Mapper<ButtonStyle, InternalButtonState> {
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelMapper;

    public ButtonStyleToInternalStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
        this.textLabelMapper = mapper;
    }

    @NotNull
    public InternalButtonState map(@NotNull ButtonStyle buttonStyle) {
        Intrinsics.checkNotNullParameter(buttonStyle, "from");
        return new InternalButtonState((MutableState) null, this.textLabelMapper.map(buttonStyle.getTextStyle()), 1, (DefaultConstructorMarker) null);
    }
}
