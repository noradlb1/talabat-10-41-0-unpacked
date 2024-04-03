package com.checkout.frames.mapper;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/mapper/InputComponentStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "textLabelStyleMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "inputFieldStyleMapper", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "(Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputComponentStyleToViewStyleMapper implements Mapper<InputComponentStyle, InputComponentViewStyle> {
    @NotNull
    private final Mapper<ContainerStyle, Modifier> containerMapper;
    @NotNull
    private final Mapper<InputFieldStyle, InputFieldViewStyle> inputFieldStyleMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelStyleMapper;

    public InputComponentStyleToViewStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<InputFieldStyle, InputFieldViewStyle> mapper2, @NotNull Mapper<ContainerStyle, Modifier> mapper3) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputFieldStyleMapper");
        Intrinsics.checkNotNullParameter(mapper3, "containerMapper");
        this.textLabelStyleMapper = mapper;
        this.inputFieldStyleMapper = mapper2;
        this.containerMapper = mapper3;
    }

    @NotNull
    public InputComponentViewStyle map(@NotNull InputComponentStyle inputComponentStyle) {
        TextLabelViewStyle textLabelViewStyle;
        TextLabelViewStyle textLabelViewStyle2;
        TextLabelViewStyle textLabelViewStyle3;
        TextLabelViewStyle textLabelViewStyle4;
        Intrinsics.checkNotNullParameter(inputComponentStyle, "from");
        TextLabelStyle titleStyle = inputComponentStyle.getTitleStyle();
        if (titleStyle == null || (textLabelViewStyle = this.textLabelStyleMapper.map(titleStyle)) == null) {
            textLabelViewStyle = new TextLabelViewStyle((Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1) null, (TextStyle) null, false, 65535, (DefaultConstructorMarker) null);
        }
        TextLabelViewStyle textLabelViewStyle5 = textLabelViewStyle;
        TextLabelStyle subtitleStyle = inputComponentStyle.getSubtitleStyle();
        if (subtitleStyle == null || (textLabelViewStyle2 = this.textLabelStyleMapper.map(subtitleStyle)) == null) {
            textLabelViewStyle2 = new TextLabelViewStyle((Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1) null, (TextStyle) null, false, 65535, (DefaultConstructorMarker) null);
        }
        TextLabelViewStyle textLabelViewStyle6 = textLabelViewStyle2;
        TextLabelStyle infoStyle = inputComponentStyle.getInfoStyle();
        if (infoStyle == null || (textLabelViewStyle3 = this.textLabelStyleMapper.map(infoStyle)) == null) {
            textLabelViewStyle3 = new TextLabelViewStyle((Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1) null, (TextStyle) null, false, 65535, (DefaultConstructorMarker) null);
        }
        TextLabelViewStyle textLabelViewStyle7 = textLabelViewStyle3;
        TextLabelStyle errorMessageStyle = inputComponentStyle.getErrorMessageStyle();
        if (errorMessageStyle == null || (textLabelViewStyle4 = this.textLabelStyleMapper.map(errorMessageStyle)) == null) {
            textLabelViewStyle4 = new TextLabelViewStyle((Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1) null, (TextStyle) null, false, 65535, (DefaultConstructorMarker) null);
        }
        return new InputComponentViewStyle(textLabelViewStyle5, textLabelViewStyle6, textLabelViewStyle7, this.inputFieldStyleMapper.map(inputComponentStyle.getInputFieldStyle()), textLabelViewStyle4, SizeKt.fillMaxWidth$default(this.containerMapper.map(inputComponentStyle.getContainerStyle()), 0.0f, 1, (Object) null), inputComponentStyle.isInputFieldOptional());
    }
}
