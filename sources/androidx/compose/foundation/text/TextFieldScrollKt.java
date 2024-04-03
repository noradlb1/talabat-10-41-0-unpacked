package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b"}, d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "", "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextFieldScrollKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, int i11, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z11, int i12) {
        Rect rect;
        float f11;
        float f12;
        if (textLayoutResult == null || (rect = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(i11))) == null) {
            rect = Rect.Companion.getZero();
        }
        Rect rect2 = rect;
        int r72 = density.m5441roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (z11) {
            f11 = (((float) i12) - rect2.getLeft()) - ((float) r72);
        } else {
            f11 = rect2.getLeft();
        }
        float f13 = f11;
        if (z11) {
            f12 = ((float) i12) - rect2.getLeft();
        } else {
            f12 = rect2.getLeft() + ((float) r72);
        }
        return Rect.copy$default(rect2, f13, 0.0f, f12, 0.0f, 10, (Object) null);
    }

    @NotNull
    public static final Modifier textFieldScroll(@NotNull Modifier modifier, @NotNull TextFieldScrollerPosition textFieldScrollerPosition, @NotNull TextFieldValue textFieldValue, @NotNull VisualTransformation visualTransformation, @NotNull Function0<TextLayoutResultProxy> function0) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldScrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(function0, "textLayoutResultProvider");
        Orientation orientation = textFieldScrollerPosition.getOrientation();
        int r12 = textFieldScrollerPosition.m918getOffsetToFollow5zctL8(textFieldValue.m5234getSelectiond9O1mEE());
        textFieldScrollerPosition.m920setPreviousSelection5zctL8(textFieldValue.m5234getSelectiond9O1mEE());
        TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getAnnotatedString());
        int i11 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i11 == 1) {
            modifier2 = new VerticalScrollLayoutModifier(textFieldScrollerPosition, r12, filterWithValidation, function0);
        } else if (i11 == 2) {
            modifier2 = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, r12, filterWithValidation, function0);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return ClipKt.clipToBounds(modifier).then(modifier2);
    }

    @NotNull
    public static final Modifier textFieldScrollable(@NotNull Modifier modifier, @NotNull TextFieldScrollerPosition textFieldScrollerPosition, @Nullable MutableInteractionSource mutableInteractionSource, boolean z11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldScrollerPosition, "scrollerPosition");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1(textFieldScrollerPosition, mutableInteractionSource, z11);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new TextFieldScrollKt$textFieldScrollable$2(textFieldScrollerPosition, z11, mutableInteractionSource));
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z11);
    }
}
