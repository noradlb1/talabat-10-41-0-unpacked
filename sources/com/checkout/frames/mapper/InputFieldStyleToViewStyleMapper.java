package com.checkout.frames.mapper;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.InputFieldColors;
import com.checkout.frames.style.component.base.CursorStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.extensions.InputFieldIndicatorStyleExtensionsKt;
import com.checkout.frames.utils.extensions.ShapeExtensionsKt;
import com.checkout.frames.utils.extensions.TextStyleExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J2\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0002¢\u0006\u0002\u0010#J \u0010$\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/checkout/frames/mapper/InputFieldStyleToViewStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "textLabelStyleMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "provideBorderShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorStyle", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "provideColors", "Lcom/checkout/frames/model/InputFieldColors;", "style", "provideFocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "provideFocusedBorderThickness-u2uoSUM", "(Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;)F", "provideModifier", "Landroidx/compose/ui/Modifier;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "providePlaceholder", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "placeholderText", "", "placeholderTextId", "", "placeholderStyle", "Lcom/checkout/frames/style/component/base/TextStyle;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/checkout/frames/style/component/base/TextStyle;)Lkotlin/jvm/functions/Function2;", "provideUnfocusedBorderThickness", "provideUnfocusedBorderThickness-u2uoSUM", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputFieldStyleToViewStyleMapper implements Mapper<InputFieldStyle, InputFieldViewStyle> {
    /* access modifiers changed from: private */
    @NotNull
    public final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelStyleMapper;

    public InputFieldStyleToViewStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
        this.textLabelStyleMapper = mapper;
    }

    private final Shape provideBorderShape(InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return null;
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            InputFieldIndicatorStyle.Border border = (InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle;
            return ShapeExtensionsKt.toComposeShape(border.getShape(), border.getCornerRadius());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final InputFieldColors provideColors(InputFieldStyle inputFieldStyle) {
        Color color;
        Color color2;
        Color color3;
        Color color4;
        Color r32 = Color.m2909boximpl(ColorKt.Color(inputFieldStyle.getTextStyle().getColor()));
        Color r42 = Color.m2909boximpl(ColorKt.Color(inputFieldStyle.getPlaceholderStyle().getColor()));
        Color r52 = Color.m2909boximpl(ColorKt.Color(InputFieldIndicatorStyleExtensionsKt.focusedIndicatorColor(inputFieldStyle.getIndicatorStyle())));
        Color r62 = Color.m2909boximpl(ColorKt.Color(InputFieldIndicatorStyleExtensionsKt.unfocusedIndicatorColor(inputFieldStyle.getIndicatorStyle())));
        Color r72 = Color.m2909boximpl(ColorKt.Color(InputFieldIndicatorStyleExtensionsKt.disabledIndicatorColor(inputFieldStyle.getIndicatorStyle())));
        Color r82 = Color.m2909boximpl(ColorKt.Color(InputFieldIndicatorStyleExtensionsKt.errorIndicatorColor(inputFieldStyle.getIndicatorStyle())));
        long Color = ColorKt.Color(inputFieldStyle.getContainerStyle().getColor());
        CursorStyle cursorStyle = inputFieldStyle.getCursorStyle();
        if (cursorStyle != null) {
            color = Color.m2909boximpl(ColorKt.Color(cursorStyle.getCursorColor()));
        } else {
            color = null;
        }
        CursorStyle cursorStyle2 = inputFieldStyle.getCursorStyle();
        if (cursorStyle2 != null) {
            color2 = Color.m2909boximpl(ColorKt.Color(cursorStyle2.getErrorCursorColor()));
        } else {
            color2 = null;
        }
        CursorStyle cursorStyle3 = inputFieldStyle.getCursorStyle();
        if (cursorStyle3 != null) {
            color3 = Color.m2909boximpl(ColorKt.Color(cursorStyle3.getCursorHandleColor()));
        } else {
            color3 = null;
        }
        CursorStyle cursorStyle4 = inputFieldStyle.getCursorStyle();
        if (cursorStyle4 != null) {
            color4 = Color.m2909boximpl(ColorKt.Color(cursorStyle4.getCursorHighlightColor()));
        } else {
            color4 = null;
        }
        return new InputFieldColors(r32, r42, r52, r62, r72, r82, Color, color, color2, color3, color4, (DefaultConstructorMarker) null);
    }

    /* renamed from: provideFocusedBorderThickness-u2uoSUM  reason: not valid java name */
    private final float m9236provideFocusedBorderThicknessu2uoSUM(InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return Dp.m5478constructorimpl((float) ((InputFieldIndicatorStyle.Underline) inputFieldIndicatorStyle).getFocusedUnderlineThickness());
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            return Dp.m5478constructorimpl((float) ((InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle).getFocusedBorderThickness());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0046, code lost:
        if (r1 == null) goto L_0x0048;
     */
    @android.annotation.SuppressLint({"ModifierFactoryExtensionFunction"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.Modifier provideModifier(com.checkout.frames.style.component.base.ContainerStyle r8) {
        /*
            r7 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r2.m2954getTransparent0d7_KjU()
            r4 = 0
            r5 = 2
            r6 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r1, r2, r4, r5, r6)
            r0.element = r1
            java.lang.Integer r1 = r8.getHeight()
            if (r1 == 0) goto L_0x002f
            int r1 = r1.intValue()
            T r2 = r0.element
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r2, r1)
            r0.element = r1
        L_0x002f:
            java.lang.Integer r1 = r8.getWidth()
            if (r1 == 0) goto L_0x0048
            int r1 = r1.intValue()
            T r2 = r0.element
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r2, r1)
            if (r1 != 0) goto L_0x0053
        L_0x0048:
            T r1 = r0.element
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 1
            r3 = 0
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r4, r2, r3)
        L_0x0053:
            r0.element = r1
            com.checkout.frames.model.Margin r1 = r8.getMargin()
            if (r1 == 0) goto L_0x0089
            T r2 = r0.element
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            int r3 = r1.getStart()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            int r4 = r1.getTop()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            int r5 = r1.getEnd()
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r5)
            int r1 = r1.getBottom()
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m489paddingqDBjuR0(r2, r3, r4, r5, r1)
            r0.element = r1
        L_0x0089:
            com.checkout.frames.model.Padding r8 = r8.getPadding()
            if (r8 == 0) goto L_0x00bd
            T r1 = r0.element
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            int r2 = r8.getStart()
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r2)
            int r3 = r8.getTop()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            int r4 = r8.getEnd()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            int r8 = r8.getBottom()
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r8)
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m489paddingqDBjuR0(r1, r2, r3, r4, r8)
            r0.element = r8
        L_0x00bd:
            T r8 = r0.element
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.InputFieldStyleToViewStyleMapper.provideModifier(com.checkout.frames.style.component.base.ContainerStyle):androidx.compose.ui.Modifier");
    }

    private final Function2<Composer, Integer, Unit> providePlaceholder(String str, Integer num, TextStyle textStyle) {
        return ComposableLambdaKt.composableLambdaInstance(304486901, true, new InputFieldStyleToViewStyleMapper$providePlaceholder$1(this, str, num, textStyle));
    }

    /* renamed from: provideUnfocusedBorderThickness-u2uoSUM  reason: not valid java name */
    private final float m9237provideUnfocusedBorderThicknessu2uoSUM(InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return Dp.m5478constructorimpl((float) ((InputFieldIndicatorStyle.Underline) inputFieldIndicatorStyle).getUnfocusedUnderlineThickness());
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            return Dp.m5478constructorimpl((float) ((InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle).getUnfocusedBorderThickness());
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public InputFieldViewStyle map(@NotNull InputFieldStyle inputFieldStyle) {
        Intrinsics.checkNotNullParameter(inputFieldStyle, "from");
        Modifier provideModifier = provideModifier(inputFieldStyle.getContainerStyle());
        androidx.compose.ui.text.TextStyle composeTextStyle = TextStyleExtensionsKt.toComposeTextStyle(inputFieldStyle.getTextStyle());
        int maxLines = inputFieldStyle.getTextStyle().getMaxLines();
        return new InputFieldViewStyle(provideModifier, false, false, composeTextStyle, providePlaceholder(inputFieldStyle.getPlaceholderText(), inputFieldStyle.getPlaceholderTextId(), inputFieldStyle.getPlaceholderStyle()), (VisualTransformation) null, inputFieldStyle.getKeyboardOptions(), (KeyboardActions) null, false, maxLines, (MutableInteractionSource) null, ShapeExtensionsKt.toComposeShape(inputFieldStyle.getContainerStyle().getShape(), inputFieldStyle.getContainerStyle().getCornerRadius()), provideBorderShape(inputFieldStyle.getIndicatorStyle()), provideColors(inputFieldStyle), m9236provideFocusedBorderThicknessu2uoSUM(inputFieldStyle.getIndicatorStyle()), m9237provideUnfocusedBorderThicknessu2uoSUM(inputFieldStyle.getIndicatorStyle()), false, 66982, (DefaultConstructorMarker) null);
    }
}
