package com.checkout.frames.mapper;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/checkout/frames/mapper/InputComponentStyleToStateMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/component/base/InputComponentState;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "inputFieldStateMapper", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/view/InputFieldState;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputComponentStyleToStateMapper implements Mapper<InputComponentStyle, InputComponentState> {
    @NotNull
    private final Mapper<InputFieldStyle, InputFieldState> inputFieldStateMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelMapper;

    public InputComponentStyleToStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper, @NotNull Mapper<InputFieldStyle, InputFieldState> mapper2) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputFieldStateMapper");
        this.textLabelMapper = mapper;
        this.inputFieldStateMapper = mapper2;
    }

    @NotNull
    public InputComponentState map(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "from");
        return new InputComponentState(this.inputFieldStateMapper.map(inputComponentStyle.getInputFieldStyle()), this.textLabelMapper.map(inputComponentStyle.getTitleStyle()), this.textLabelMapper.map(inputComponentStyle.getSubtitleStyle()), this.textLabelMapper.map(inputComponentStyle.getInfoStyle()), this.textLabelMapper.map(inputComponentStyle.getErrorMessageStyle()), inputComponentStyle.isInputFieldOptional());
    }
}
