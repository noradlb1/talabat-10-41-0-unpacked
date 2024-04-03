package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate;", "", "()V", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextFieldDelegate {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ5\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016JK\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J1\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0)H\u0001¢\u0006\u0002\b*J<\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0)2\b\u0010/\u001a\u0004\u0018\u00010%H\u0003JX\u00100\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u00103\u001a\u0002042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0)2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u000b0)H\u0001ø\u0001\u0001¢\u0006\u0002\b7JX\u00108\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u00103\u001a\u0002042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0)2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u000b0)H\u0001ø\u0001\u0001¢\u0006\u0002\b9JI\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0012\u001a\u00020=2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0)H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006@"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate$Companion;", "", "()V", "applyCompositionDecoration", "Landroidx/compose/ui/text/input/TransformedText;", "compositionRange", "Landroidx/compose/ui/text/TextRange;", "transformed", "applyCompositionDecoration-72CqOWE", "(JLandroidx/compose/ui/text/input/TransformedText;)Landroidx/compose/ui/text/input/TransformedText;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "selectionPaint", "Landroidx/compose/ui/graphics/Paint;", "draw$foundation_release", "layout", "Lkotlin/Triple;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevResultText", "layout-_EkL_-Y$foundation_release", "(Landroidx/compose/foundation/text/TextDelegate;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Lkotlin/Triple;", "onBlur", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "editProcessor", "Landroidx/compose/ui/text/input/EditProcessor;", "onValueChange", "Lkotlin/Function1;", "onBlur$foundation_release", "onEditCommand", "ops", "", "Landroidx/compose/ui/text/input/EditCommand;", "session", "onFocus", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "onFocus$foundation_release", "restartInput", "restartInput$foundation_release", "setCursorOffset", "position", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setCursorOffset-ULxng0E$foundation_release", "(JLandroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/ui/text/input/EditProcessor;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/jvm/functions/Function1;)V", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: layout-_EkL_-Y$foundation_release$default  reason: not valid java name */
        public static /* synthetic */ Triple m908layout_EkL_Y$foundation_release$default(Companion companion, TextDelegate textDelegate, long j11, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                textLayoutResult = null;
            }
            return companion.m910layout_EkL_Y$foundation_release(textDelegate, j11, layoutDirection, textLayoutResult);
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final void onEditCommand(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
            TextFieldValue apply = editProcessor.apply(list);
            if (textInputSession != null) {
                textInputSession.updateState((TextFieldValue) null, apply);
            }
            function1.invoke(apply);
        }

        @NotNull
        /* renamed from: applyCompositionDecoration-72CqOWE  reason: not valid java name */
        public final TransformedText m909applyCompositionDecoration72CqOWE(long j11, @NotNull TransformedText transformedText) {
            Intrinsics.checkNotNullParameter(transformedText, "transformed");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedText.getText());
            builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (DefaultConstructorMarker) null), transformedText.getOffsetMapping().originalToTransformed(TextRange.m5038getStartimpl(j11)), transformedText.getOffsetMapping().originalToTransformed(TextRange.m5033getEndimpl(j11)));
            return new TransformedText(builder.toAnnotatedString(), transformedText.getOffsetMapping());
        }

        @JvmStatic
        public final void draw$foundation_release(@NotNull Canvas canvas, @NotNull TextFieldValue textFieldValue, @NotNull OffsetMapping offsetMapping, @NotNull TextLayoutResult textLayoutResult, @NotNull Paint paint) {
            int originalToTransformed;
            int originalToTransformed2;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
            Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
            Intrinsics.checkNotNullParameter(paint, "selectionPaint");
            if (!TextRange.m5032getCollapsedimpl(textFieldValue.m5234getSelectiond9O1mEE()) && (originalToTransformed = offsetMapping.originalToTransformed(TextRange.m5036getMinimpl(textFieldValue.m5234getSelectiond9O1mEE()))) != (originalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m5035getMaximpl(textFieldValue.m5234getSelectiond9O1mEE())))) {
                canvas.drawPath(textLayoutResult.getPathForRange(originalToTransformed, originalToTransformed2), paint);
            }
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }

        @JvmStatic
        @NotNull
        /* renamed from: layout-_EkL_-Y$foundation_release  reason: not valid java name */
        public final Triple<Integer, Integer, TextLayoutResult> m910layout_EkL_Y$foundation_release(@NotNull TextDelegate textDelegate, long j11, @NotNull LayoutDirection layoutDirection, @Nullable TextLayoutResult textLayoutResult) {
            Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            TextLayoutResult r22 = textDelegate.m902layoutNN6EwU(j11, layoutDirection, textLayoutResult);
            return new Triple<>(Integer.valueOf(IntSize.m5638getWidthimpl(r22.m5014getSizeYbymL2g())), Integer.valueOf(IntSize.m5637getHeightimpl(r22.m5014getSizeYbymL2g())), r22);
        }

        @JvmStatic
        public final void onBlur$foundation_release(@NotNull TextInputSession textInputSession, @NotNull EditProcessor editProcessor, @NotNull Function1<? super TextFieldValue, Unit> function1) {
            Intrinsics.checkNotNullParameter(textInputSession, "textInputSession");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            function1.invoke(TextFieldValue.m5229copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, 0, (TextRange) null, 3, (Object) null));
            textInputSession.dispose();
        }

        @JvmStatic
        @NotNull
        public final TextInputSession onFocus$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue textFieldValue, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull Function1<? super TextFieldValue, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
            Intrinsics.checkNotNullParameter(textInputService, "textInputService");
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
            return restartInput$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
        }

        @JvmStatic
        @NotNull
        public final TextInputSession restartInput$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue textFieldValue, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull Function1<? super TextFieldValue, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
            Intrinsics.checkNotNullParameter(textInputService, "textInputService");
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T startInput = textInputService.startInput(textFieldValue, imeOptions, new TextFieldDelegate$Companion$restartInput$1(editProcessor, function1, objectRef), function12);
            objectRef.element = startInput;
            return startInput;
        }

        @JvmStatic
        /* renamed from: setCursorOffset-ULxng0E$foundation_release  reason: not valid java name */
        public final void m911setCursorOffsetULxng0E$foundation_release(long j11, @NotNull TextLayoutResultProxy textLayoutResultProxy, @NotNull EditProcessor editProcessor, @NotNull OffsetMapping offsetMapping, @NotNull Function1<? super TextFieldValue, Unit> function1) {
            Intrinsics.checkNotNullParameter(textLayoutResultProxy, "textLayoutResult");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            function1.invoke(TextFieldValue.m5229copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, TextRangeKt.TextRange(offsetMapping.transformedToOriginal(TextLayoutResultProxy.m932getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, j11, false, 2, (Object) null))), (TextRange) null, 5, (Object) null));
        }
    }

    @JvmStatic
    public static final void draw$foundation_release(@NotNull Canvas canvas, @NotNull TextFieldValue textFieldValue, @NotNull OffsetMapping offsetMapping, @NotNull TextLayoutResult textLayoutResult, @NotNull Paint paint) {
        Companion.draw$foundation_release(canvas, textFieldValue, offsetMapping, textLayoutResult, paint);
    }

    @JvmStatic
    @NotNull
    /* renamed from: layout-_EkL_-Y$foundation_release  reason: not valid java name */
    public static final Triple<Integer, Integer, TextLayoutResult> m906layout_EkL_Y$foundation_release(@NotNull TextDelegate textDelegate, long j11, @NotNull LayoutDirection layoutDirection, @Nullable TextLayoutResult textLayoutResult) {
        return Companion.m910layout_EkL_Y$foundation_release(textDelegate, j11, layoutDirection, textLayoutResult);
    }

    @JvmStatic
    public static final void onBlur$foundation_release(@NotNull TextInputSession textInputSession, @NotNull EditProcessor editProcessor, @NotNull Function1<? super TextFieldValue, Unit> function1) {
        Companion.onBlur$foundation_release(textInputSession, editProcessor, function1);
    }

    @JvmStatic
    private static final void onEditCommand(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
        Companion.onEditCommand(list, editProcessor, function1, textInputSession);
    }

    @JvmStatic
    @NotNull
    public static final TextInputSession onFocus$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue textFieldValue, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull Function1<? super TextFieldValue, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
        return Companion.onFocus$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
    }

    @JvmStatic
    @NotNull
    public static final TextInputSession restartInput$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue textFieldValue, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull Function1<? super TextFieldValue, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
        return Companion.restartInput$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
    }

    @JvmStatic
    /* renamed from: setCursorOffset-ULxng0E$foundation_release  reason: not valid java name */
    public static final void m907setCursorOffsetULxng0E$foundation_release(long j11, @NotNull TextLayoutResultProxy textLayoutResultProxy, @NotNull EditProcessor editProcessor, @NotNull OffsetMapping offsetMapping, @NotNull Function1<? super TextFieldValue, Unit> function1) {
        Companion.m911setCursorOffsetULxng0E$foundation_release(j11, textLayoutResultProxy, editProcessor, offsetMapping, function1);
    }
}
