package com.designsystem.ds_input_field;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a;\u0010\u0010\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0015\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\u0010#\u001aÎ\u0002\u0010$\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010'2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010'2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00142\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0006\u0010/\u001a\u00020\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00102\u001a\u0002032\u0006\u00104\u001a\u0002012\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;\u0018\u00010'2\b\b\u0002\u0010<\u001a\u00020\"2\b\b\u0002\u0010=\u001a\u00020\"H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?\u001aK\u0010@\u001a\u00020\u00012\b\b\u0001\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00062\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\b\b\u0002\u0010D\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010F\u001aE\u0010G\u001a\u00020\u00012\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\b\b\u0002\u0010D\u001a\u00020\"H\u0001¢\u0006\u0002\u0010H\u001aý\u0001\u0010I\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u00010+¢\u0006\u0002\b,2\u0006\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u001b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0013\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0013\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u0002012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\"H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010O\u001a`\u0010P\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u00104\u001a\u0002012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\u0017\u0010Q\u001a\u0013\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u00010'¢\u0006\u0002\b,H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010T\u001a\u0018\u0010U\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010V\u001a\u00020\"H\u0002\u001a\u001d\u0010W\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\bX\u001a4\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020;2\u0006\u0010V\u001a\u00020\"2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,H\u0002¢\u0006\u0002\u0010\\\u001au\u0010]\u001a\u00020\u0001*\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u0001012\u0013\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u00010+¢\u0006\u0002\b,2\u0006\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\"H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010_\u001ao\u0010`\u001a\u00020\u0001*\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u0001012\u0013\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010+¢\u0006\u0002\b,2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u00010+¢\u0006\u0002\b,2\u0006\u0010=\u001a\u00020\"H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010b\u001a&\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00190d\"\u0004\b\u0000\u0010e*\b\u0012\u0004\u0012\u0002He0fH\u0003ø\u0001\u0000¢\u0006\u0002\u0010g\u001a#\u0010h\u001a\b\u0012\u0004\u0012\u00020i0d\"\u0004\b\u0000\u0010e*\b\u0012\u0004\u0012\u0002He0fH\u0003¢\u0006\u0002\u0010g\u001a)\u0010j\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u000201H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010n\u001a$\u0010o\u001a\u00020\u000b*\u00020\u000b2\u000e\u0010p\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\u0006\u0010!\u001a\u00020\"H\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006q"}, d2 = {"CharacterCounterText", "", "charactersCount", "", "maxCharactersCount", "fontColor", "Landroidx/compose/ui/graphics/Color;", "CharacterCounterText-XO-JAsU", "(IIJLandroidx/compose/runtime/Composer;I)V", "HelperText", "modifier", "Landroidx/compose/ui/Modifier;", "helperText", "", "HelperText-XO-JAsU", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "HelperTextContainer", "containerState", "Lcom/designsystem/ds_input_field/ContainerState;", "state", "Lcom/designsystem/ds_input_field/OuterState;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/designsystem/ds_input_field/ContainerState;Lcom/designsystem/ds_input_field/OuterState;Landroidx/compose/runtime/Composer;I)V", "Hint", "text", "offset", "Landroidx/compose/ui/geometry/Offset;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "scope", "Landroidx/compose/foundation/layout/BoxScope;", "Hint-EPk0efs", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/runtime/Composer;I)V", "HintPlaceholder", "isEnabled", "", "(ZLandroidx/compose/runtime/Composer;I)V", "InputField", "hint", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "outerState", "leadingComposable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "innerTextInputPrefix", "trailingComposable", "maxLines", "inputHeight", "Landroidx/compose/ui/unit/Dp;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "containerMinHeight", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onInputTap", "inputFilter", "Landroidx/compose/ui/text/input/TextFieldValue;", "animateHint", "shouldForceInnerTextInputToLtr", "InputField-mytMHeg", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/OuterState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/ui/unit/Dp;Ljava/lang/Integer;Landroidx/compose/ui/text/input/VisualTransformation;FLandroidx/compose/ui/text/input/KeyboardType;Landroidx/compose/ui/text/input/ImeAction;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/runtime/Composer;IIII)V", "InputFieldTrailingIcon", "trailingIcon", "tint", "onTrailingIconTap", "trailingIconIsEnabled", "InputFieldTrailingIcon-8V94_ZQ", "(IJLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;II)V", "InputFieldTrailingIconContainer", "(Ljava/lang/Integer;Lcom/designsystem/ds_input_field/OuterState;ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "TextFieldDecorationBox", "innerTextInput", "hintOffset", "hintTextStyle", "onInputClick", "TextFieldDecorationBox-QRWc_DE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/text/TextStyle;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/designsystem/ds_input_field/OuterState;Lcom/designsystem/ds_input_field/ContainerState;ZLandroidx/compose/ui/unit/Dp;Ljava/lang/Integer;Ljava/lang/Integer;FLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBoxBackground", "content", "Landroidx/compose/foundation/layout/RowScope;", "TextFieldDecorationBoxBackground-jIwJxvA", "(Lcom/designsystem/ds_input_field/OuterState;Lcom/designsystem/ds_input_field/ContainerState;ZFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getContainerState", "isFocused", "getInputHeightModifier", "getInputHeightModifier-YLDhkOg", "getInputState", "Lcom/designsystem/ds_input_field/InputState;", "inputText", "(Landroidx/compose/ui/text/input/TextFieldValue;ZLkotlin/jvm/functions/Function2;)Lcom/designsystem/ds_input_field/InputState;", "TextInputWithAnimatedHint", "TextInputWithAnimatedHint-fD77gVg", "(Landroidx/compose/foundation/layout/BoxScope;Ljava/lang/String;ZLandroidx/compose/ui/unit/Dp;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/text/TextStyle;ZLandroidx/compose/runtime/Composer;I)V", "TextInputWithHint", "TextInputWithHint-UcWoP3I", "(Landroidx/compose/foundation/layout/BoxScope;Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/unit/Dp;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Composer;I)V", "animateHintOffset", "Landroidx/compose/runtime/State;", "InputState", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateLerpProgress", "", "inputFieldBorder", "borderStrokeColor", "cornerSize", "inputFieldBorder-Hht5A8o", "(Landroidx/compose/ui/Modifier;JF)Landroidx/compose/ui/Modifier;", "overrideTapListener", "onClick", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContainerState.values().length];
            iArr[ContainerState.FOCUSED.ordinal()] = 1;
            iArr[ContainerState.DISABLED.ordinal()] = 2;
            iArr[ContainerState.OUTER_STATE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Composable
    /* renamed from: CharacterCounterText-XO-JAsU  reason: not valid java name */
    public static final void m8410CharacterCounterTextXOJAsU(int i11, int i12, long j11, @Nullable Composer composer, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        int i19 = i12;
        int i21 = i13;
        Composer startRestartGroup = composer.startRestartGroup(167626061);
        if ((i21 & 14) == 0) {
            if (startRestartGroup.changed(i18)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i14 = i17 | i21;
        } else {
            i14 = i21;
        }
        if ((i21 & 112) == 0) {
            if (startRestartGroup.changed(i19)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i14 |= i16;
        }
        long j12 = j11;
        if ((i21 & 896) == 0) {
            if (startRestartGroup.changed(j12)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i14 |= i15;
        }
        if (((i14 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            Modifier testTag = TestTagKt.testTag(Modifier.Companion, InputFieldCommon.InputFieldCharacterCounterTestTag);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i18);
            sb2.append('/');
            sb2.append(i19);
            TextKt.m1461TextfLXpl1I(sb2.toString(), testTag, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 1, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(InputFieldTextStyleComposablesKt.helperTextStyle(startRestartGroup, 0), j11, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), startRestartGroup, 48, 3136, 24572);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$CharacterCounterText$1(i11, i12, j11, i13));
        }
    }

    @Composable
    /* renamed from: HelperText-XO-JAsU  reason: not valid java name */
    public static final void m8411HelperTextXOJAsU(@NotNull Modifier modifier, @NotNull String str, long j11, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        int i15;
        Modifier modifier2 = modifier;
        String str2 = str;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(str2, "helperText");
        Composer startRestartGroup = composer.startRestartGroup(1767137345);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        long j12 = j11;
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(j12)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        int i17 = i12;
        if (((i17 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            composer2 = startRestartGroup;
            int i18 = i17;
            String str3 = str;
            Modifier modifier3 = modifier;
            TextKt.m1461TextfLXpl1I(str3, modifier3, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 2, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(InputFieldTextStyleComposablesKt.helperTextStyle(startRestartGroup, 0), j11, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer2, ((i18 >> 3) & 14) | ((i18 << 3) & 112), 3136, 24572);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$HelperText$1(modifier, str, j11, i11));
        }
    }

    @Composable
    public static final void HelperTextContainer(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @NotNull ContainerState containerState, @NotNull OuterState outerState, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        float f11;
        long j11;
        Arrangement.Horizontal horizontal;
        DSTheme dSTheme;
        Modifier.Companion companion;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        String str2 = str;
        Integer num3 = num;
        Integer num4 = num2;
        ContainerState containerState2 = containerState;
        OuterState outerState2 = outerState;
        int i18 = i11;
        Intrinsics.checkNotNullParameter(containerState2, "containerState");
        Intrinsics.checkNotNullParameter(outerState2, "state");
        Composer startRestartGroup = composer.startRestartGroup(-1664956708);
        if ((i18 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i12 = i17 | i18;
        } else {
            i12 = i18;
        }
        if ((i18 & 112) == 0) {
            if (startRestartGroup.changed((Object) num3)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        }
        if ((i18 & 896) == 0) {
            if (startRestartGroup.changed((Object) num4)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        }
        if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed((Object) containerState2)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        }
        if ((57344 & i18) == 0) {
            if (startRestartGroup.changed((Object) outerState2)) {
                i13 = 16384;
            } else {
                i13 = 8192;
            }
            i12 |= i13;
        }
        int i19 = i12;
        if (((46811 & i19) ^ 9362) != 0 || !startRestartGroup.getSkipping()) {
            if (str2 == null && num4 == null) {
                startRestartGroup.startReplaceableGroup(-1664956463);
                f11 = DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8849getDsZeroD9Ej5fM();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1664956420);
                f11 = DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM();
                startRestartGroup.endReplaceableGroup();
            }
            if (WhenMappings.$EnumSwitchMapping$0[containerState.ordinal()] == 2) {
                startRestartGroup.startReplaceableGroup(-1664956288);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8764getDsNeutral350d7_KjU();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1664956254);
                j11 = outerState2.m8442getStateColorWaAFU9c(startRestartGroup, (i19 >> 12) & 14);
                startRestartGroup.endReplaceableGroup();
            }
            long j12 = j11;
            if (num3 == null || num4 == null) {
                horizontal = Arrangement.INSTANCE.getStart();
            } else {
                horizontal = Arrangement.INSTANCE.getSpaceBetween();
            }
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, (Object) null);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            Modifier r02 = PaddingKt.m489paddingqDBjuR0(fillMaxWidth$default, dSTheme2.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), f11, dSTheme2.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), dSTheme2.getDimens(startRestartGroup, 0).m8849getDsZeroD9Ej5fM());
            startRestartGroup.startReplaceableGroup(-1989997546);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, Alignment.Companion.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r02);
            DSTheme dSTheme3 = dSTheme2;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r42 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r42, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r42, density, companion3.getSetDensity());
            Updater.m2543setimpl(r42, layoutDirection, companion3.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (str2 == null) {
                startRestartGroup.startReplaceableGroup(810284108);
                startRestartGroup.endReplaceableGroup();
                companion = companion2;
                dSTheme = dSTheme3;
            } else {
                startRestartGroup.startReplaceableGroup(26138197);
                dSTheme = dSTheme3;
                companion = companion2;
                m8411HelperTextXOJAsU(e.a(rowScopeInstance, companion2, 1.0f, false, 2, (Object) null), str, j12, startRestartGroup, (i19 << 3) & 112);
                startRestartGroup.endReplaceableGroup();
            }
            if (num3 == null || num4 == null) {
                composer2 = startRestartGroup;
                composer2.startReplaceableGroup(26138579);
                composer2.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(26138370);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM()), startRestartGroup, 0);
                int i21 = i19 >> 3;
                composer2 = startRestartGroup;
                m8410CharacterCounterTextXOJAsU(num.intValue(), num2.intValue(), j12, composer2, (i21 & 14) | (i21 & 112));
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$HelperTextContainer$2(str, num, num2, containerState, outerState, i11));
        }
    }

    @Composable
    /* renamed from: Hint-EPk0efs  reason: not valid java name */
    public static final void m8412HintEPk0efs(@NotNull String str, long j11, @NotNull TextStyle textStyle, @NotNull BoxScope boxScope, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        int i15;
        int i16;
        String str2 = str;
        TextStyle textStyle2 = textStyle;
        BoxScope boxScope2 = boxScope;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(textStyle2, "textStyle");
        Intrinsics.checkNotNullParameter(boxScope2, "scope");
        Composer startRestartGroup = composer.startRestartGroup(-1875313009);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i17;
        } else {
            i12 = i17;
        }
        long j12 = j11;
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed(j12)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i17 & 896) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i17 & 7168) == 0) {
            if (startRestartGroup.changed((Object) boxScope2)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        int i18 = i12;
        if (((i18 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            int i19 = i18;
            composer2 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, OffsetKt.m470absoluteOffsetVpY3zN4(boxScope2.align(Modifier.Companion, Alignment.Companion.getTopStart()), Dp.m5478constructorimpl(Offset.m2676getXimpl(j11)), Dp.m5478constructorimpl(Offset.m2677getYimpl(j11))), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5402getClipgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, textStyle, composer2, i19 & 14, ((i19 << 9) & Opcodes.ASM7) | 3136, 22524);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$Hint$2(str, j11, textStyle, boxScope, i11));
        }
    }

    @Composable
    public static final void HintPlaceholder(boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        boolean z12 = z11;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(757223455);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if ((2 ^ (i12 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            TextKt.m1461TextfLXpl1I("", TestTagKt.testTag(Modifier.Companion, InputFieldCommon.InputFieldHintPlaceholderTestTag), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, InputFieldTextStyleComposablesKt.smallHintTextStyle(z12, startRestartGroup, i12 & 14), startRestartGroup, 54, 64, 32764);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$HintPlaceholder$1(z12, i14));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0432  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0497  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:326:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013a  */
    @androidx.compose.runtime.Composable
    /* renamed from: InputField-mytMHeg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8413InputFieldmytMHeg(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r60, @org.jetbrains.annotations.Nullable java.lang.String r61, @org.jetbrains.annotations.Nullable java.lang.String r62, @org.jetbrains.annotations.Nullable java.lang.String r63, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r64, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r65, boolean r66, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r67, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, int r71, @org.jetbrains.annotations.Nullable androidx.compose.ui.unit.Dp r72, @org.jetbrains.annotations.Nullable java.lang.Integer r73, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r74, float r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.KeyboardType r76, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeAction r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.TextFieldValue> r79, boolean r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r82, int r83, int r84, int r85, int r86) {
        /*
            r15 = r60
            r14 = r66
            r13 = r67
            r12 = r83
            r11 = r84
            r10 = r86
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "outerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1126862037(0xffffffffbcd5732b, float:-0.026055893)
            r1 = r82
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0026
            r0 = r12 | 6
            goto L_0x0036
        L_0x0026:
            r0 = r12 & 14
            if (r0 != 0) goto L_0x0035
            boolean r0 = r9.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0032
            r0 = 4
            goto L_0x0033
        L_0x0032:
            r0 = 2
        L_0x0033:
            r0 = r0 | r12
            goto L_0x0036
        L_0x0035:
            r0 = r12
        L_0x0036:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x003d
            r0 = r0 | 48
            goto L_0x0050
        L_0x003d:
            r6 = r12 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0050
            r6 = r61
            boolean r7 = r9.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x004c
            r7 = 32
            goto L_0x004e
        L_0x004c:
            r7 = 16
        L_0x004e:
            r0 = r0 | r7
            goto L_0x0052
        L_0x0050:
            r6 = r61
        L_0x0052:
            r7 = r10 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x005b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006f
        L_0x005b:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x006f
            r1 = r62
            boolean r17 = r9.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x006a
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r17 = r16
        L_0x006c:
            r0 = r0 | r17
            goto L_0x0071
        L_0x006f:
            r1 = r62
        L_0x0071:
            r17 = r10 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x007c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0090
        L_0x007c:
            r4 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0090
            r4 = r63
            boolean r21 = r9.changed((java.lang.Object) r4)
            if (r21 == 0) goto L_0x008b
            r21 = r18
            goto L_0x008d
        L_0x008b:
            r21 = r19
        L_0x008d:
            r0 = r0 | r21
            goto L_0x0092
        L_0x0090:
            r4 = r63
        L_0x0092:
            r21 = r10 & 16
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 16384(0x4000, float:2.2959E-41)
            if (r21 == 0) goto L_0x009f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r5 = r64
            goto L_0x00b5
        L_0x009f:
            r24 = 57344(0xe000, float:8.0356E-41)
            r24 = r12 & r24
            r5 = r64
            if (r24 != 0) goto L_0x00b5
            boolean r25 = r9.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00b1
            r25 = r23
            goto L_0x00b3
        L_0x00b1:
            r25 = r22
        L_0x00b3:
            r0 = r0 | r25
        L_0x00b5:
            r25 = r10 & 32
            r26 = 131072(0x20000, float:1.83671E-40)
            r27 = 65536(0x10000, float:9.18355E-41)
            r28 = 196608(0x30000, float:2.75506E-40)
            if (r25 == 0) goto L_0x00c4
            r0 = r0 | r28
            r8 = r65
            goto L_0x00d9
        L_0x00c4:
            r29 = 458752(0x70000, float:6.42848E-40)
            r29 = r12 & r29
            r8 = r65
            if (r29 != 0) goto L_0x00d9
            boolean r30 = r9.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x00d5
            r30 = r26
            goto L_0x00d7
        L_0x00d5:
            r30 = r27
        L_0x00d7:
            r0 = r0 | r30
        L_0x00d9:
            r30 = r10 & 64
            r31 = 524288(0x80000, float:7.34684E-40)
            if (r30 == 0) goto L_0x00e4
            r30 = 1572864(0x180000, float:2.204052E-39)
        L_0x00e1:
            r0 = r0 | r30
            goto L_0x00f6
        L_0x00e4:
            r30 = 3670016(0x380000, float:5.142788E-39)
            r30 = r12 & r30
            if (r30 != 0) goto L_0x00f6
            boolean r30 = r9.changed((boolean) r14)
            if (r30 == 0) goto L_0x00f3
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00f3:
            r30 = r31
            goto L_0x00e1
        L_0x00f6:
            r2 = r10 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00fe
            r2 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00fc:
            r0 = r0 | r2
            goto L_0x010f
        L_0x00fe:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x010f
            boolean r2 = r9.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x010c
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x010c:
            r2 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00fc
        L_0x010f:
            r2 = r10 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x011a
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r32
            r1 = r68
            goto L_0x012f
        L_0x011a:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r12 & r32
            r1 = r68
            if (r32 != 0) goto L_0x012f
            boolean r32 = r9.changed((java.lang.Object) r1)
            if (r32 == 0) goto L_0x012b
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012d
        L_0x012b:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012d:
            r0 = r0 | r32
        L_0x012f:
            r1 = r10 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x013a
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r32
            r4 = r69
            goto L_0x014f
        L_0x013a:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r12 & r32
            r4 = r69
            if (r32 != 0) goto L_0x014f
            boolean r32 = r9.changed((java.lang.Object) r4)
            if (r32 == 0) goto L_0x014b
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014d
        L_0x014b:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014d:
            r0 = r0 | r32
        L_0x014f:
            r32 = r0
            r0 = r10 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x015a
            r33 = r11 | 6
            r4 = r70
            goto L_0x0170
        L_0x015a:
            r33 = r11 & 14
            r4 = r70
            if (r33 != 0) goto L_0x016e
            boolean r33 = r9.changed((java.lang.Object) r4)
            if (r33 == 0) goto L_0x0169
            r33 = 4
            goto L_0x016b
        L_0x0169:
            r33 = 2
        L_0x016b:
            r33 = r11 | r33
            goto L_0x0170
        L_0x016e:
            r33 = r11
        L_0x0170:
            r4 = r10 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0177
            r33 = r33 | 48
            goto L_0x018d
        L_0x0177:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x018b
            r4 = r71
            boolean r34 = r9.changed((int) r4)
            if (r34 == 0) goto L_0x0186
            r34 = 32
            goto L_0x0188
        L_0x0186:
            r34 = 16
        L_0x0188:
            r33 = r33 | r34
            goto L_0x018d
        L_0x018b:
            r4 = r71
        L_0x018d:
            r4 = r33
            r5 = r10 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0196
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x01aa
        L_0x0196:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x01aa
            r6 = r72
            boolean r33 = r9.changed((java.lang.Object) r6)
            if (r33 == 0) goto L_0x01a5
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01a7
        L_0x01a5:
            r29 = r16
        L_0x01a7:
            r4 = r4 | r29
            goto L_0x01ac
        L_0x01aa:
            r6 = r72
        L_0x01ac:
            r6 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x01b3
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c5
        L_0x01b3:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01c5
            r8 = r73
            boolean r16 = r9.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r18 = r19
        L_0x01c2:
            r4 = r4 | r18
            goto L_0x01c7
        L_0x01c5:
            r8 = r73
        L_0x01c7:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x01e2
            r8 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r8 != 0) goto L_0x01dd
            r8 = r74
            boolean r16 = r9.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x01df
            r22 = r23
            goto L_0x01df
        L_0x01dd:
            r8 = r74
        L_0x01df:
            r4 = r4 | r22
            goto L_0x01e4
        L_0x01e2:
            r8 = r74
        L_0x01e4:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r10 & r16
            if (r16 == 0) goto L_0x01f0
            r4 = r4 | r28
            r15 = r75
            goto L_0x0205
        L_0x01f0:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r11 & r16
            r15 = r75
            if (r16 != 0) goto L_0x0205
            boolean r16 = r9.changed((float) r15)
            if (r16 == 0) goto L_0x0201
            r16 = r26
            goto L_0x0203
        L_0x0201:
            r16 = r27
        L_0x0203:
            r4 = r4 | r16
        L_0x0205:
            r16 = r10 & r27
            if (r16 == 0) goto L_0x020b
            r4 = r4 | r31
        L_0x020b:
            r18 = r10 & r26
            if (r18 == 0) goto L_0x0213
            r19 = 4194304(0x400000, float:5.877472E-39)
            r4 = r4 | r19
        L_0x0213:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r10 & r19
            if (r19 == 0) goto L_0x0220
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r22
            r8 = r78
            goto L_0x0235
        L_0x0220:
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            r22 = r11 & r22
            r8 = r78
            if (r22 != 0) goto L_0x0235
            boolean r22 = r9.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x0231
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0233
        L_0x0231:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0233:
            r4 = r4 | r22
        L_0x0235:
            r22 = r10 & r31
            if (r22 == 0) goto L_0x0240
            r23 = 805306368(0x30000000, float:4.656613E-10)
            r4 = r4 | r23
            r8 = r79
            goto L_0x0255
        L_0x0240:
            r23 = 1879048192(0x70000000, float:1.58456325E29)
            r23 = r11 & r23
            r8 = r79
            if (r23 != 0) goto L_0x0255
            boolean r23 = r9.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x0251
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0253
        L_0x0251:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0253:
            r4 = r4 | r23
        L_0x0255:
            r23 = 1048576(0x100000, float:1.469368E-39)
            r23 = r10 & r23
            if (r23 == 0) goto L_0x0260
            r26 = r85 | 6
            r8 = r80
            goto L_0x0276
        L_0x0260:
            r26 = r85 & 14
            r8 = r80
            if (r26 != 0) goto L_0x0274
            boolean r26 = r9.changed((boolean) r8)
            if (r26 == 0) goto L_0x026f
            r26 = 4
            goto L_0x0271
        L_0x026f:
            r26 = 2
        L_0x0271:
            r26 = r85 | r26
            goto L_0x0276
        L_0x0274:
            r26 = r85
        L_0x0276:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r10 & r27
            if (r27 == 0) goto L_0x0281
            r20 = r26 | 48
        L_0x027e:
            r29 = r20
            goto L_0x0297
        L_0x0281:
            r29 = r85 & 112(0x70, float:1.57E-43)
            r8 = r81
            if (r29 != 0) goto L_0x0295
            boolean r29 = r9.changed((boolean) r8)
            if (r29 == 0) goto L_0x0290
            r24 = 32
            goto L_0x0292
        L_0x0290:
            r24 = 16
        L_0x0292:
            r20 = r26 | r24
            goto L_0x027e
        L_0x0295:
            r29 = r26
        L_0x0297:
            int r8 = ~r10
            r8 = r8 & r28
            if (r8 != 0) goto L_0x02e8
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r32 & r8
            r20 = 306783378(0x12492492, float:6.3469493E-28)
            r8 = r8 ^ r20
            if (r8 != 0) goto L_0x02e8
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r4
            r20 = 306783378(0x12492492, float:6.3469493E-28)
            r8 = r8 ^ r20
            if (r8 != 0) goto L_0x02e8
            r8 = r29 & 91
            r8 = r8 ^ 18
            if (r8 != 0) goto L_0x02e8
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x02c0
            goto L_0x02e8
        L_0x02c0:
            r9.skipToGroupEnd()
            r2 = r61
            r3 = r62
            r4 = r63
            r5 = r64
            r6 = r65
            r10 = r69
            r11 = r70
            r13 = r72
            r14 = r73
            r15 = r74
            r17 = r76
            r18 = r77
            r19 = r78
            r20 = r79
            r21 = r80
            r22 = r81
            r1 = r9
            r9 = r68
            goto L_0x05d5
        L_0x02e8:
            r8 = r12 & 1
            if (r8 == 0) goto L_0x034b
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x02f4
            goto L_0x034b
        L_0x02f4:
            r9.skipCurrentGroup()
            r0 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0325
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r4
            r11 = r61
            r31 = r62
            r33 = r63
            r34 = r64
            r35 = r65
            r36 = r68
            r8 = r69
            r37 = r70
            r38 = r72
            r39 = r73
            r40 = r74
            r41 = r76
            r42 = r77
            r43 = r78
            r44 = r79
            r45 = r80
            r46 = r81
            r16 = r0
            goto L_0x03ed
        L_0x0325:
            r11 = r61
            r31 = r62
            r33 = r63
            r34 = r64
            r35 = r65
            r36 = r68
            r8 = r69
            r37 = r70
            r38 = r72
            r39 = r73
            r40 = r74
            r41 = r76
            r42 = r77
            r43 = r78
            r44 = r79
            r45 = r80
            r46 = r81
        L_0x0347:
            r16 = r4
            goto L_0x03ed
        L_0x034b:
            r9.startDefaults()
            if (r3 == 0) goto L_0x0352
            r3 = 0
            goto L_0x0354
        L_0x0352:
            r3 = r61
        L_0x0354:
            if (r7 == 0) goto L_0x0358
            r7 = 0
            goto L_0x035a
        L_0x0358:
            r7 = r62
        L_0x035a:
            if (r17 == 0) goto L_0x035e
            r8 = 0
            goto L_0x0360
        L_0x035e:
            r8 = r63
        L_0x0360:
            if (r21 == 0) goto L_0x0365
            r17 = 0
            goto L_0x0367
        L_0x0365:
            r17 = r64
        L_0x0367:
            if (r25 == 0) goto L_0x036c
            r21 = 0
            goto L_0x036e
        L_0x036c:
            r21 = r65
        L_0x036e:
            if (r2 == 0) goto L_0x0372
            r2 = 0
            goto L_0x0374
        L_0x0372:
            r2 = r68
        L_0x0374:
            if (r1 == 0) goto L_0x0378
            r1 = 0
            goto L_0x037a
        L_0x0378:
            r1 = r69
        L_0x037a:
            if (r0 == 0) goto L_0x037e
            r0 = 0
            goto L_0x0380
        L_0x037e:
            r0 = r70
        L_0x0380:
            if (r5 == 0) goto L_0x0384
            r5 = 0
            goto L_0x0386
        L_0x0384:
            r5 = r72
        L_0x0386:
            if (r6 == 0) goto L_0x038a
            r6 = 0
            goto L_0x038c
        L_0x038a:
            r6 = r73
        L_0x038c:
            r11 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x039c
            androidx.compose.ui.text.input.VisualTransformation$Companion r11 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r11 = r11.getNone()
            r25 = -57345(0xffffffffffff1fff, float:NaN)
            r4 = r4 & r25
            goto L_0x039e
        L_0x039c:
            r11 = r74
        L_0x039e:
            if (r16 == 0) goto L_0x03a3
            r16 = 0
            goto L_0x03a5
        L_0x03a3:
            r16 = r76
        L_0x03a5:
            if (r18 == 0) goto L_0x03aa
            r18 = 0
            goto L_0x03ac
        L_0x03aa:
            r18 = r77
        L_0x03ac:
            if (r19 == 0) goto L_0x03b1
            r19 = 0
            goto L_0x03b3
        L_0x03b1:
            r19 = r78
        L_0x03b3:
            if (r22 == 0) goto L_0x03b8
            r22 = 0
            goto L_0x03ba
        L_0x03b8:
            r22 = r79
        L_0x03ba:
            if (r23 == 0) goto L_0x03bf
            r23 = 1
            goto L_0x03c1
        L_0x03bf:
            r23 = r80
        L_0x03c1:
            if (r27 == 0) goto L_0x03c6
            r25 = 0
            goto L_0x03c8
        L_0x03c6:
            r25 = r81
        L_0x03c8:
            r9.endDefaults()
            r37 = r0
            r36 = r2
            r38 = r5
            r39 = r6
            r31 = r7
            r33 = r8
            r40 = r11
            r41 = r16
            r34 = r17
            r42 = r18
            r43 = r19
            r35 = r21
            r44 = r22
            r45 = r23
            r46 = r25
            r8 = r1
            r11 = r3
            goto L_0x0347
        L_0x03ed:
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r9.startReplaceableGroup(r0)
            java.lang.Object r1 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r2.getEmpty()
            if (r1 != r3) goto L_0x0406
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r1)
        L_0x0406:
            r9.endReplaceableGroup()
            r7 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = (androidx.compose.foundation.interaction.MutableInteractionSource) r7
            r1 = 6
            androidx.compose.runtime.State r1 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r7, r9, r1)
            java.lang.Object r1 = r1.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r9.startReplaceableGroup(r3)
            boolean r3 = r9.changed((java.lang.Object) r11)
            java.lang.Object r4 = r9.rememberedValue()
            if (r3 != 0) goto L_0x0436
            java.lang.Object r3 = r2.getEmpty()
            if (r4 != r3) goto L_0x0432
            goto L_0x0436
        L_0x0432:
            r3 = r4
            r4 = 2
            r5 = 0
            goto L_0x0461
        L_0x0436:
            androidx.compose.ui.text.input.TextFieldValue r3 = new androidx.compose.ui.text.input.TextFieldValue
            if (r11 == 0) goto L_0x043d
            r48 = r11
            goto L_0x0441
        L_0x043d:
            java.lang.String r4 = ""
            r48 = r4
        L_0x0441:
            if (r11 != 0) goto L_0x0445
            r4 = 0
            goto L_0x0449
        L_0x0445:
            int r4 = r11.length()
        L_0x0449:
            long r49 = androidx.compose.ui.text.TextRangeKt.TextRange(r4)
            r51 = 0
            r52 = 4
            r53 = 0
            r47 = r3
            r47.<init>((java.lang.String) r48, (long) r49, (androidx.compose.ui.text.TextRange) r51, (int) r52, (kotlin.jvm.internal.DefaultConstructorMarker) r53)
            r4 = 2
            r5 = 0
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r5, r4, r5)
            r9.updateRememberedValue(r3)
        L_0x0461:
            r9.endReplaceableGroup()
            r17 = r3
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            r9.startReplaceableGroup(r0)
            java.lang.Object r3 = r9.rememberedValue()
            java.lang.Object r6 = r2.getEmpty()
            if (r3 != r6) goto L_0x0485
            androidx.compose.ui.text.input.TextFieldValue r3 = m8419InputField_mytMHeg$lambda2(r17)
            r6 = 0
            com.designsystem.ds_input_field.InputState r3 = getInputState(r3, r6, r8)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r5, r4, r5)
            r9.updateRememberedValue(r3)
        L_0x0485:
            r9.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r9.startReplaceableGroup(r0)
            java.lang.Object r6 = r9.rememberedValue()
            java.lang.Object r0 = r2.getEmpty()
            if (r6 != r0) goto L_0x04a2
            com.designsystem.ds_input_field.ContainerState r0 = getContainerState(r14, r1)
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r5, r4, r5)
            r9.updateRememberedValue(r6)
        L_0x04a2:
            r9.endReplaceableGroup()
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r9.startReplaceableGroup(r0)
            java.lang.Object r0 = r9.rememberedValue()
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x04ce
            if (r11 == 0) goto L_0x04bb
            r0 = r11
            goto L_0x04bd
        L_0x04bb:
            java.lang.String r0 = ""
        L_0x04bd:
            int r0 = r0.length()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 2
            r4 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r4, r2, r4)
            r9.updateRememberedValue(r0)
        L_0x04ce:
            r9.endReplaceableGroup()
            r18 = r0
            androidx.compose.runtime.MutableState r18 = (androidx.compose.runtime.MutableState) r18
            com.designsystem.ds_input_field.InputState r0 = m8421InputField_mytMHeg$lambda5(r3)
            java.lang.String r2 = "HelperTextTransitionLabel"
            r4 = 48
            r5 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r2, (androidx.compose.runtime.Composer) r9, (int) r4, (int) r5)
            androidx.compose.runtime.State r2 = animateLerpProgress(r0, r9, r5)
            androidx.compose.runtime.State r30 = animateHintOffset(r0, r9, r5)
            int r0 = r32 >> 18
            r0 = r0 & 14
            androidx.compose.ui.text.TextStyle r4 = com.designsystem.ds_input_field.InputFieldTextStyleComposablesKt.bigHintTextStyle(r14, r9, r0)
            androidx.compose.ui.text.TextStyle r0 = com.designsystem.ds_input_field.InputFieldTextStyleComposablesKt.smallHintTextStyle(r14, r9, r0)
            float r2 = m8417InputField_mytMHeg$lambda13(r2)
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.ui.text.TextStyleKt.lerp(r4, r0, r2)
            if (r45 == 0) goto L_0x050b
            androidx.compose.ui.text.input.TextFieldValue r0 = m8419InputField_mytMHeg$lambda2(r17)
            com.designsystem.ds_input_field.InputState r0 = getInputState(r0, r1, r8)
            m8422InputField_mytMHeg$lambda6(r3, r0)
        L_0x050b:
            com.designsystem.ds_input_field.ContainerState r0 = getContainerState(r14, r1)
            m8424InputField_mytMHeg$lambda9(r6, r0)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = new androidx.compose.foundation.text.selection.TextSelectionColors
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r2 = 0
            com.designsystem.ds_theme.DSColors r3 = r1.getColors(r9, r2)
            long r3 = r3.m8793getDsPrimary1000d7_KjU()
            com.designsystem.ds_theme.DSColors r1 = r1.getColors(r9, r2)
            long r47 = r1.m8793getDsPrimary1000d7_KjU()
            r49 = 1041865114(0x3e19999a, float:0.15)
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 14
            r54 = 0
            long r1 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r47, r49, r50, r51, r52, r53, r54)
            r5 = 0
            r76 = r0
            r77 = r3
            r79 = r1
            r81 = r5
            r76.<init>(r77, r79, r81)
            r5 = 1
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r5]
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r0 = r1.provides(r0)
            r1 = 0
            r4[r1] = r0
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1 r3 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1
            r0 = r3
            r1 = r60
            r2 = r66
            r55 = r3
            r3 = r43
            r56 = r4
            r4 = r32
            r20 = r5
            r5 = r71
            r32 = r6
            r6 = r35
            r21 = r7
            r7 = r17
            r47 = r8
            r8 = r42
            r57 = r9
            r9 = r41
            r10 = r44
            r48 = r11
            r11 = r39
            r12 = r34
            r13 = r18
            r14 = r40
            r15 = r21
            r17 = r33
            r18 = r19
            r19 = r31
            r20 = r37
            r21 = r47
            r22 = r36
            r23 = r67
            r24 = r38
            r25 = r75
            r26 = r45
            r27 = r46
            r28 = r29
            r29 = r30
            r30 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r0 = -819889483(0xffffffffcf217ab5, float:-2.7091735E9)
            r2 = r55
            r1 = r57
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            r2 = 56
            r3 = r56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r1, (int) r2)
            r3 = r31
            r4 = r33
            r5 = r34
            r9 = r36
            r11 = r37
            r13 = r38
            r14 = r39
            r15 = r40
            r17 = r41
            r18 = r42
            r19 = r43
            r20 = r44
            r21 = r45
            r22 = r46
            r10 = r47
            r2 = r48
        L_0x05d5:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 != 0) goto L_0x05dc
            goto L_0x05ff
        L_0x05dc:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$2 r8 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$2
            r0 = r8
            r1 = r60
            r7 = r66
            r58 = r8
            r8 = r67
            r59 = r12
            r12 = r71
            r16 = r75
            r23 = r83
            r24 = r84
            r25 = r85
            r26 = r86
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r1 = r58
            r0 = r59
            r0.updateScope(r1)
        L_0x05ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.OuterState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, androidx.compose.ui.unit.Dp, java.lang.Integer, androidx.compose.ui.text.input.VisualTransformation, float, androidx.compose.ui.text.input.KeyboardType, androidx.compose.ui.text.input.ImeAction, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, boolean, boolean, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: InputFieldTrailingIcon-8V94_ZQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8414InputFieldTrailingIcon8V94_ZQ(@androidx.annotation.DrawableRes int r25, long r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r28, boolean r29, boolean r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r1 = r25
            r6 = r30
            r7 = r32
            r0 = -595036482(0xffffffffdc8876be, float:-3.07289242E17)
            r2 = r31
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r33 & 1
            if (r2 == 0) goto L_0x0016
            r2 = r7 | 6
            goto L_0x0026
        L_0x0016:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0025
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x0022
            r2 = 4
            goto L_0x0023
        L_0x0022:
            r2 = 2
        L_0x0023:
            r2 = r2 | r7
            goto L_0x0026
        L_0x0025:
            r2 = r7
        L_0x0026:
            r3 = r33 & 2
            if (r3 == 0) goto L_0x002d
            r2 = r2 | 48
            goto L_0x0040
        L_0x002d:
            r3 = r7 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0040
            r3 = r26
            boolean r5 = r0.changed((long) r3)
            if (r5 == 0) goto L_0x003c
            r5 = 32
            goto L_0x003e
        L_0x003c:
            r5 = 16
        L_0x003e:
            r2 = r2 | r5
            goto L_0x0042
        L_0x0040:
            r3 = r26
        L_0x0042:
            r5 = r33 & 4
            if (r5 == 0) goto L_0x0049
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r8 = r7 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005c
            r8 = r28
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0058
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r2 = r2 | r9
            goto L_0x005e
        L_0x005c:
            r8 = r28
        L_0x005e:
            r9 = r33 & 8
            if (r9 == 0) goto L_0x0065
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0065:
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0078
            r10 = r29
            boolean r11 = r0.changed((boolean) r10)
            if (r11 == 0) goto L_0x0074
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r2 = r2 | r11
            goto L_0x007a
        L_0x0078:
            r10 = r29
        L_0x007a:
            r11 = r33 & 16
            if (r11 == 0) goto L_0x0081
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0093
        L_0x0081:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r7
            if (r11 != 0) goto L_0x0093
            boolean r11 = r0.changed((boolean) r6)
            if (r11 == 0) goto L_0x0090
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x0090:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r2 = r2 | r11
        L_0x0093:
            r11 = 46811(0xb6db, float:6.5596E-41)
            r11 = r11 & r2
            r11 = r11 ^ 9362(0x2492, float:1.3119E-41)
            if (r11 != 0) goto L_0x00a8
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r0.skipToGroupEnd()
            r5 = r10
            goto L_0x0135
        L_0x00a8:
            r11 = 0
            if (r5 == 0) goto L_0x00ad
            r5 = r11
            goto L_0x00ae
        L_0x00ad:
            r5 = r8
        L_0x00ae:
            r8 = 0
            if (r9 == 0) goto L_0x00b3
            r15 = r8
            goto L_0x00b4
        L_0x00b3:
            r15 = r10
        L_0x00b4:
            r9 = r2 & 14
            androidx.compose.ui.graphics.painter.Painter r9 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r0, r9)
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            com.designsystem.ds_theme.DSTheme r12 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r12 = r12.getDimens(r0, r8)
            float r12 = r12.m8840getDsLD9Ej5fM()
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r10, r12)
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIcon$1 r12 = com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIcon$1.INSTANCE
            r13 = 1
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r8, r12, r13, r11)
            androidx.compose.foundation.interaction.MutableInteractionSource r17 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r15)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r30)
            r11 = -3686095(0xffffffffffc7c131, float:NaN)
            r0.startReplaceableGroup(r11)
            boolean r8 = r0.changed((java.lang.Object) r8)
            boolean r10 = r0.changed((java.lang.Object) r10)
            r8 = r8 | r10
            boolean r10 = r0.changed((java.lang.Object) r5)
            r8 = r8 | r10
            java.lang.Object r10 = r0.rememberedValue()
            if (r8 != 0) goto L_0x0107
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x010f
        L_0x0107:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIcon$2$1 r10 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIcon$2$1
            r10.<init>(r15, r6, r5)
            r0.updateRememberedValue(r10)
        L_0x010f:
            r0.endReplaceableGroup()
            r22 = r10
            kotlin.jvm.functions.Function0 r22 = (kotlin.jvm.functions.Function0) r22
            r23 = 28
            r24 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            java.lang.String r11 = ""
            int r2 = r2 << 6
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r14 = r2 | 56
            r2 = 0
            r8 = r9
            r9 = r11
            r11 = r26
            r13 = r0
            r16 = r15
            r15 = r2
            androidx.compose.material.IconKt.m1278Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r8, (java.lang.String) r9, (androidx.compose.ui.Modifier) r10, (long) r11, (androidx.compose.runtime.Composer) r13, (int) r14, (int) r15)
            r8 = r5
            r5 = r16
        L_0x0135:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x013c
            goto L_0x0150
        L_0x013c:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIcon$3 r10 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIcon$3
            r0 = r10
            r1 = r25
            r2 = r26
            r4 = r8
            r6 = r30
            r7 = r32
            r8 = r33
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8414InputFieldTrailingIcon8V94_ZQ(int, long, kotlin.jvm.functions.Function0, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void InputFieldTrailingIconContainer(@org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r16, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r17, boolean r18, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r19, boolean r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r2 = r17
            r12 = r18
            r13 = r22
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -717559624(0xffffffffd53ae8b8, float:-1.28442926E13)
            r1 = r21
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x001e
            r3 = r13 | 6
            r4 = r3
            r3 = r16
            goto L_0x0032
        L_0x001e:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x002f
            r3 = r16
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r13
            goto L_0x0032
        L_0x002f:
            r3 = r16
            r4 = r13
        L_0x0032:
            r5 = r23 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x0049
        L_0x0039:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r4 = r4 | r5
        L_0x0049:
            r5 = r23 & 4
            if (r5 == 0) goto L_0x0050
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x0050:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0060
            boolean r5 = r0.changed((boolean) r12)
            if (r5 == 0) goto L_0x005d
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r4 = r4 | r5
        L_0x0060:
            r5 = r23 & 8
            if (r5 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007a
            r6 = r19
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0076
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r7
            goto L_0x007c
        L_0x007a:
            r6 = r19
        L_0x007c:
            r7 = r23 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x0086
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r9 = r13 & r8
            if (r9 != 0) goto L_0x0099
            r9 = r20
            boolean r10 = r0.changed((boolean) r9)
            if (r10 == 0) goto L_0x0095
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r10
            goto L_0x009b
        L_0x0099:
            r9 = r20
        L_0x009b:
            r10 = 46811(0xb6db, float:6.5596E-41)
            r10 = r10 & r4
            r10 = r10 ^ 9362(0x2492, float:1.3119E-41)
            if (r10 != 0) goto L_0x00b2
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x00aa
            goto L_0x00b2
        L_0x00aa:
            r0.skipToGroupEnd()
            r1 = r3
            r4 = r6
            r5 = r9
            goto L_0x013a
        L_0x00b2:
            r10 = 0
            if (r1 == 0) goto L_0x00b7
            r1 = r10
            goto L_0x00b8
        L_0x00b7:
            r1 = r3
        L_0x00b8:
            if (r5 == 0) goto L_0x00bc
            r14 = r10
            goto L_0x00bd
        L_0x00bc:
            r14 = r6
        L_0x00bd:
            r3 = 0
            if (r7 == 0) goto L_0x00c2
            r15 = r3
            goto L_0x00c3
        L_0x00c2:
            r15 = r9
        L_0x00c3:
            java.lang.Integer r5 = r17.getStateIcon()
            if (r5 != 0) goto L_0x00cb
            r5 = r1
            goto L_0x00cf
        L_0x00cb:
            java.lang.Integer r5 = r17.getStateIcon()
        L_0x00cf:
            if (r12 == 0) goto L_0x00e3
            r6 = -717559233(0xffffffffd53aea3f, float:-1.28447026E13)
            r0.startReplaceableGroup(r6)
            int r6 = r4 >> 3
            r6 = r6 & 14
            long r6 = r2.m8441getIconStateColorWaAFU9c(r0, r6)
            r0.endReplaceableGroup()
            goto L_0x00f6
        L_0x00e3:
            r6 = -717559186(0xffffffffd53aea6e, float:-1.28447519E13)
            r0.startReplaceableGroup(r6)
            com.designsystem.ds_theme.DSTheme r6 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r6 = r6.getColors(r0, r3)
            long r6 = r6.m8764getDsNeutral350d7_KjU()
            r0.endReplaceableGroup()
        L_0x00f6:
            if (r5 != 0) goto L_0x00ff
            r3 = -769496115(0xffffffffd2226bcd, float:-1.74398325E11)
            r0.startReplaceableGroup(r3)
            goto L_0x0135
        L_0x00ff:
            r9 = -717559116(0xffffffffd53aeab4, float:-1.28448253E13)
            r0.startReplaceableGroup(r9)
            r5.intValue()
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            com.designsystem.ds_theme.DSTheme r10 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r10 = r10.getDimens(r0, r3)
            float r10 = r10.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r9, r10)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r9, r0, r3)
            int r3 = r5.intValue()
            int r5 = r4 >> 3
            r9 = r5 & 896(0x380, float:1.256E-42)
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r9
            int r4 = r4 << 6
            r4 = r4 & r8
            r10 = r5 | r4
            r11 = 0
            r4 = r6
            r6 = r14
            r7 = r15
            r8 = r18
            r9 = r0
            m8414InputFieldTrailingIcon8V94_ZQ(r3, r4, r6, r7, r8, r9, r10, r11)
        L_0x0135:
            r0.endReplaceableGroup()
            r4 = r14
            r5 = r15
        L_0x013a:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0141
            goto L_0x0152
        L_0x0141:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIconContainer$2 r9 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputFieldTrailingIconContainer$2
            r0 = r9
            r2 = r17
            r3 = r18
            r6 = r22
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt.InputFieldTrailingIconContainer(java.lang.Integer, com.designsystem.ds_input_field.OuterState, boolean, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: InputField_mytMHeg$lambda-11  reason: not valid java name */
    public static final int m8415InputField_mytMHeg$lambda11(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: InputField_mytMHeg$lambda-12  reason: not valid java name */
    public static final void m8416InputField_mytMHeg$lambda12(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    /* renamed from: InputField_mytMHeg$lambda-13  reason: not valid java name */
    private static final float m8417InputField_mytMHeg$lambda13(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: InputField_mytMHeg$lambda-14  reason: not valid java name */
    public static final long m8418InputField_mytMHeg$lambda14(State<Offset> state) {
        return state.getValue().m2686unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: InputField_mytMHeg$lambda-2  reason: not valid java name */
    public static final TextFieldValue m8419InputField_mytMHeg$lambda2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: InputField_mytMHeg$lambda-3  reason: not valid java name */
    public static final void m8420InputField_mytMHeg$lambda3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* renamed from: InputField_mytMHeg$lambda-5  reason: not valid java name */
    private static final InputState m8421InputField_mytMHeg$lambda5(MutableState<InputState> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: InputField_mytMHeg$lambda-6  reason: not valid java name */
    private static final void m8422InputField_mytMHeg$lambda6(MutableState<InputState> mutableState, InputState inputState) {
        mutableState.setValue(inputState);
    }

    /* access modifiers changed from: private */
    /* renamed from: InputField_mytMHeg$lambda-8  reason: not valid java name */
    public static final ContainerState m8423InputField_mytMHeg$lambda8(MutableState<ContainerState> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: InputField_mytMHeg$lambda-9  reason: not valid java name */
    private static final void m8424InputField_mytMHeg$lambda9(MutableState<ContainerState> mutableState, ContainerState containerState) {
        mutableState.setValue(containerState);
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0145  */
    @androidx.compose.runtime.Composable
    /* renamed from: TextFieldDecorationBox-QRWc_DE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8425TextFieldDecorationBoxQRWc_DE(@org.jetbrains.annotations.Nullable java.lang.String r34, @org.jetbrains.annotations.Nullable java.lang.String r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, long r37, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.TextStyle r39, @org.jetbrains.annotations.Nullable java.lang.String r40, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r44, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.ContainerState r45, boolean r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.unit.Dp r47, @org.jetbrains.annotations.Nullable java.lang.Integer r48, @org.jetbrains.annotations.Nullable java.lang.Integer r49, float r50, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r51, boolean r52, boolean r53, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r54, int r55, int r56, int r57) {
        /*
            r15 = r36
            r14 = r39
            r13 = r44
            r11 = r45
            r12 = r55
            r10 = r56
            r9 = r57
            java.lang.String r0 = "innerTextInput"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "hintTextStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "containerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -713993294(0xffffffffd57153b2, float:-1.65838607E13)
            r1 = r54
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            r0 = r9 & 1
            if (r0 == 0) goto L_0x0034
            r0 = r12 | 6
            r7 = r34
            goto L_0x0046
        L_0x0034:
            r0 = r12 & 14
            r7 = r34
            if (r0 != 0) goto L_0x0045
            boolean r0 = r8.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0042
            r0 = 4
            goto L_0x0043
        L_0x0042:
            r0 = 2
        L_0x0043:
            r0 = r0 | r12
            goto L_0x0046
        L_0x0045:
            r0 = r12
        L_0x0046:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x004d
            r0 = r0 | 48
            goto L_0x0061
        L_0x004d:
            r6 = r12 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0061
            r6 = r35
            boolean r16 = r8.changed((java.lang.Object) r6)
            if (r16 == 0) goto L_0x005c
            r16 = 32
            goto L_0x005e
        L_0x005c:
            r16 = 16
        L_0x005e:
            r0 = r0 | r16
            goto L_0x0063
        L_0x0061:
            r6 = r35
        L_0x0063:
            r16 = r9 & 4
            r17 = 256(0x100, float:3.59E-43)
            r18 = 128(0x80, float:1.794E-43)
            if (r16 == 0) goto L_0x006e
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x007e
        L_0x006e:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x007e
            boolean r1 = r8.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x007b
            r1 = r17
            goto L_0x007d
        L_0x007b:
            r1 = r18
        L_0x007d:
            r0 = r0 | r1
        L_0x007e:
            r1 = r9 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x008b
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r6 = r37
            goto L_0x009d
        L_0x008b:
            r1 = r12 & 7168(0x1c00, float:1.0045E-41)
            r6 = r37
            if (r1 != 0) goto L_0x009d
            boolean r1 = r8.changed((long) r6)
            if (r1 == 0) goto L_0x009a
            r1 = r16
            goto L_0x009c
        L_0x009a:
            r1 = r19
        L_0x009c:
            r0 = r0 | r1
        L_0x009d:
            r1 = r9 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r1 == 0) goto L_0x00ab
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00bb
        L_0x00ab:
            r1 = r12 & r22
            if (r1 != 0) goto L_0x00bb
            boolean r1 = r8.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x00b8
            r1 = r20
            goto L_0x00ba
        L_0x00b8:
            r1 = r21
        L_0x00ba:
            r0 = r0 | r1
        L_0x00bb:
            r1 = r9 & 32
            r23 = 131072(0x20000, float:1.83671E-40)
            r24 = 65536(0x10000, float:9.18355E-41)
            r25 = 196608(0x30000, float:2.75506E-40)
            if (r1 == 0) goto L_0x00ca
            r0 = r0 | r25
            r2 = r40
            goto L_0x00df
        L_0x00ca:
            r26 = 458752(0x70000, float:6.42848E-40)
            r26 = r12 & r26
            r2 = r40
            if (r26 != 0) goto L_0x00df
            boolean r27 = r8.changed((java.lang.Object) r2)
            if (r27 == 0) goto L_0x00db
            r27 = r23
            goto L_0x00dd
        L_0x00db:
            r27 = r24
        L_0x00dd:
            r0 = r0 | r27
        L_0x00df:
            r27 = r9 & 64
            if (r27 == 0) goto L_0x00ea
            r27 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r27
            r15 = r41
            goto L_0x00ff
        L_0x00ea:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r12 & r27
            r15 = r41
            if (r27 != 0) goto L_0x00ff
            boolean r27 = r8.changed((java.lang.Object) r15)
            if (r27 == 0) goto L_0x00fb
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fd
        L_0x00fb:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00fd:
            r0 = r0 | r27
        L_0x00ff:
            r4 = r9 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0107
            r4 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r4
            goto L_0x011c
        L_0x0107:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r12
            if (r4 != 0) goto L_0x011c
            r4 = r42
            boolean r28 = r8.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x0117
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0119
        L_0x0117:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0119:
            r0 = r0 | r28
            goto L_0x011e
        L_0x011c:
            r4 = r42
        L_0x011e:
            r5 = r9 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0126
            r5 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r5
            goto L_0x013b
        L_0x0126:
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r12
            if (r5 != 0) goto L_0x013b
            r5 = r43
            boolean r29 = r8.changed((java.lang.Object) r5)
            if (r29 == 0) goto L_0x0136
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0138
        L_0x0136:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0138:
            r0 = r0 | r29
            goto L_0x013d
        L_0x013b:
            r5 = r43
        L_0x013d:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0145
            r2 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0143:
            r0 = r0 | r2
            goto L_0x0156
        L_0x0145:
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x0156
            boolean r2 = r8.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0153
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0143
        L_0x0153:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0143
        L_0x0156:
            r29 = r0
            r0 = r9 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x015f
            r0 = r10 | 6
            goto L_0x0172
        L_0x015f:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0171
            boolean r0 = r8.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x016c
            r26 = 4
            goto L_0x016e
        L_0x016c:
            r26 = 2
        L_0x016e:
            r0 = r10 | r26
            goto L_0x0172
        L_0x0171:
            r0 = r10
        L_0x0172:
            r2 = r9 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0179
            r0 = r0 | 48
            goto L_0x018d
        L_0x0179:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x018d
            r2 = r46
            boolean r26 = r8.changed((boolean) r2)
            if (r26 == 0) goto L_0x0188
            r27 = 32
            goto L_0x018a
        L_0x0188:
            r27 = 16
        L_0x018a:
            r0 = r0 | r27
            goto L_0x018f
        L_0x018d:
            r2 = r46
        L_0x018f:
            r2 = r9 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0196
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01a8
        L_0x0196:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x01a8
            r2 = r47
            boolean r26 = r8.changed((java.lang.Object) r2)
            if (r26 == 0) goto L_0x01a3
            goto L_0x01a5
        L_0x01a3:
            r17 = r18
        L_0x01a5:
            r0 = r0 | r17
            goto L_0x01aa
        L_0x01a8:
            r2 = r47
        L_0x01aa:
            r2 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x01b1
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c3
        L_0x01b1:
            r4 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x01c3
            r4 = r48
            boolean r17 = r8.changed((java.lang.Object) r4)
            if (r17 == 0) goto L_0x01be
            goto L_0x01c0
        L_0x01be:
            r16 = r19
        L_0x01c0:
            r0 = r0 | r16
            goto L_0x01c5
        L_0x01c3:
            r4 = r48
        L_0x01c5:
            r4 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x01ce
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r5 = r49
            goto L_0x01df
        L_0x01ce:
            r16 = r10 & r22
            r5 = r49
            if (r16 != 0) goto L_0x01df
            boolean r16 = r8.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x01db
            goto L_0x01dd
        L_0x01db:
            r20 = r21
        L_0x01dd:
            r0 = r0 | r20
        L_0x01df:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r9 & r16
            if (r16 == 0) goto L_0x01eb
            r0 = r0 | r25
            r15 = r50
            goto L_0x0200
        L_0x01eb:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r10 & r16
            r15 = r50
            if (r16 != 0) goto L_0x0200
            boolean r16 = r8.changed((float) r15)
            if (r16 == 0) goto L_0x01fc
            r16 = r23
            goto L_0x01fe
        L_0x01fc:
            r16 = r24
        L_0x01fe:
            r0 = r0 | r16
        L_0x0200:
            r16 = r9 & r24
            if (r16 == 0) goto L_0x020b
            r17 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r17
            r5 = r51
            goto L_0x0220
        L_0x020b:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r10 & r17
            r5 = r51
            if (r17 != 0) goto L_0x0220
            boolean r17 = r8.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x021c
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x021e
        L_0x021c:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x021e:
            r0 = r0 | r17
        L_0x0220:
            r17 = r9 & r23
            if (r17 == 0) goto L_0x022b
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r17
            r15 = r52
            goto L_0x0240
        L_0x022b:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r10 & r17
            r15 = r52
            if (r17 != 0) goto L_0x0240
            boolean r17 = r8.changed((boolean) r15)
            if (r17 == 0) goto L_0x023c
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x023e
        L_0x023c:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x023e:
            r0 = r0 | r17
        L_0x0240:
            r17 = 262144(0x40000, float:3.67342E-40)
            r17 = r9 & r17
            if (r17 == 0) goto L_0x024d
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r15 = r53
            goto L_0x0262
        L_0x024d:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r10 & r17
            r15 = r53
            if (r17 != 0) goto L_0x0262
            boolean r17 = r8.changed((boolean) r15)
            if (r17 == 0) goto L_0x025e
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0260
        L_0x025e:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0260:
            r0 = r0 | r17
        L_0x0262:
            r17 = r0
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r29 & r0
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r0 = r0 ^ r18
            if (r0 != 0) goto L_0x0293
            r0 = 191739611(0xb6db6db, float:4.5782105E-32)
            r0 = r17 & r0
            r18 = 38347922(0x2492492, float:1.4777643E-37)
            r0 = r0 ^ r18
            if (r0 != 0) goto L_0x0293
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0283
            goto L_0x0293
        L_0x0283:
            r8.skipToGroupEnd()
            r2 = r35
            r7 = r40
            r15 = r48
            r16 = r49
            r18 = r5
            r9 = r8
            goto L_0x03e0
        L_0x0293:
            r0 = 0
            if (r3 == 0) goto L_0x0299
            r18 = r0
            goto L_0x029b
        L_0x0299:
            r18 = r35
        L_0x029b:
            if (r1 == 0) goto L_0x02a0
            r19 = r0
            goto L_0x02a2
        L_0x02a0:
            r19 = r40
        L_0x02a2:
            if (r2 == 0) goto L_0x02a7
            r20 = r0
            goto L_0x02a9
        L_0x02a7:
            r20 = r48
        L_0x02a9:
            if (r4 == 0) goto L_0x02ae
            r21 = r0
            goto L_0x02b0
        L_0x02ae:
            r21 = r49
        L_0x02b0:
            if (r16 == 0) goto L_0x02b5
            r23 = r0
            goto L_0x02b7
        L_0x02b5:
            r23 = r5
        L_0x02b7:
            r0 = -1113031299(0xffffffffbda87d7d, float:-0.0822706)
            r8.startReplaceableGroup(r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r1 = r1.getTop()
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getStart()
            r3 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r1, r2, r8, r3)
            r2 = 1376089335(0x520574f7, float:1.43298249E11)
            r8.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r8.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r8.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r4.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r6 = r8.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x02ff
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02ff:
            r8.startReusableNode()
            boolean r6 = r8.getInserting()
            if (r6 == 0) goto L_0x030c
            r8.createNode(r5)
            goto L_0x030f
        L_0x030c:
            r8.useNode()
        L_0x030f:
            r8.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r8)
            kotlin.jvm.functions.Function2 r6 = r4.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            kotlin.jvm.functions.Function2 r1 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            r8.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r8, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r0)
            r0 = 276693241(0x107e00f9, float:5.0093417E-29)
            r8.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.ColumnScopeInstance r3 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$TextFieldDecorationBox$1$1 r7 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$TextFieldDecorationBox$1$1
            r0 = r7
            r1 = r43
            r2 = r29
            r4 = r41
            r5 = r52
            r6 = r19
            r30 = r7
            r7 = r46
            r31 = r8
            r8 = r47
            r9 = r42
            r10 = r36
            r11 = r37
            r13 = r39
            r14 = r53
            r15 = r17
            r16 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16)
            r0 = -819900730(0xffffffffcf214ec6, float:-2.70629427E9)
            r1 = 1
            r2 = r30
            r9 = r31
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r0, r1, r2)
            int r0 = r29 >> 27
            r0 = r0 & 14
            r0 = r0 | r25
            int r1 = r17 << 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r10 = r17 >> 6
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r10 & r22
            r7 = r0 | r1
            r8 = 0
            r0 = r44
            r1 = r45
            r2 = r46
            r3 = r50
            r4 = r23
            r6 = r9
            m8426TextFieldDecorationBoxBackgroundjIwJxvA(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            int r0 = r29 >> 3
            r0 = r0 & 14
            r1 = r10 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r17 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r29 >> 15
            r1 = r1 & r22
            r6 = r0 | r1
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r45
            r4 = r44
            r5 = r9
            HelperTextContainer(r0, r1, r2, r3, r4, r5, r6)
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            r2 = r18
            r7 = r19
            r15 = r20
            r16 = r21
            r18 = r23
        L_0x03e0:
            androidx.compose.runtime.ScopeUpdateScope r14 = r9.endRestartGroup()
            if (r14 != 0) goto L_0x03e7
            goto L_0x041a
        L_0x03e7:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$TextFieldDecorationBox$2 r13 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$TextFieldDecorationBox$2
            r0 = r13
            r1 = r34
            r3 = r36
            r4 = r37
            r6 = r39
            r8 = r41
            r9 = r42
            r10 = r43
            r11 = r44
            r12 = r45
            r32 = r13
            r13 = r46
            r33 = r14
            r14 = r47
            r17 = r50
            r19 = r52
            r20 = r53
            r21 = r55
            r22 = r56
            r23 = r57
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r1 = r32
            r0 = r33
            r0.updateScope(r1)
        L_0x041a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8425TextFieldDecorationBoxQRWc_DE(java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, long, androidx.compose.ui.text.TextStyle, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, com.designsystem.ds_input_field.OuterState, com.designsystem.ds_input_field.ContainerState, boolean, androidx.compose.ui.unit.Dp, java.lang.Integer, java.lang.Integer, float, kotlin.jvm.functions.Function0, boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cf  */
    @androidx.compose.runtime.Composable
    /* renamed from: TextFieldDecorationBoxBackground-jIwJxvA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8426TextFieldDecorationBoxBackgroundjIwJxvA(@org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r17, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.ContainerState r18, boolean r19, float r20, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r21, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r6 = r22
            r7 = r24
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "containerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -1789985140(0xffffffff954efe8c, float:-4.180217E-26)
            r5 = r23
            androidx.compose.runtime.Composer r0 = r5.startRestartGroup(r0)
            r5 = r25 & 1
            r8 = 2
            if (r5 == 0) goto L_0x002c
            r5 = r7 | 6
            goto L_0x003c
        L_0x002c:
            r5 = r7 & 14
            if (r5 != 0) goto L_0x003b
            boolean r5 = r0.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0038
            r5 = 4
            goto L_0x0039
        L_0x0038:
            r5 = r8
        L_0x0039:
            r5 = r5 | r7
            goto L_0x003c
        L_0x003b:
            r5 = r7
        L_0x003c:
            r9 = r25 & 2
            if (r9 == 0) goto L_0x0043
            r5 = r5 | 48
            goto L_0x0053
        L_0x0043:
            r9 = r7 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0053
            boolean r9 = r0.changed((java.lang.Object) r2)
            if (r9 == 0) goto L_0x0050
            r9 = 32
            goto L_0x0052
        L_0x0050:
            r9 = 16
        L_0x0052:
            r5 = r5 | r9
        L_0x0053:
            r9 = r25 & 4
            if (r9 == 0) goto L_0x005a
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x005a:
            r9 = r7 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x006a
            boolean r9 = r0.changed((boolean) r3)
            if (r9 == 0) goto L_0x0067
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r5 = r5 | r9
        L_0x006a:
            r9 = r25 & 8
            if (r9 == 0) goto L_0x0071
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r9 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0081
            boolean r9 = r0.changed((float) r4)
            if (r9 == 0) goto L_0x007e
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r5 = r5 | r9
        L_0x0081:
            r9 = r25 & 16
            if (r9 == 0) goto L_0x0088
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0088:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r7
            if (r10 != 0) goto L_0x009d
            r10 = r21
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0099
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r5 = r5 | r11
            goto L_0x009f
        L_0x009d:
            r10 = r21
        L_0x009f:
            r11 = r25 & 32
            if (r11 == 0) goto L_0x00a7
            r11 = 196608(0x30000, float:2.75506E-40)
        L_0x00a5:
            r5 = r5 | r11
            goto L_0x00b8
        L_0x00a7:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r7
            if (r11 != 0) goto L_0x00b8
            boolean r11 = r0.changed((java.lang.Object) r6)
            if (r11 == 0) goto L_0x00b5
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a5
        L_0x00b5:
            r11 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a5
        L_0x00b8:
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r5
            r12 = 74898(0x12492, float:1.04954E-40)
            r11 = r11 ^ r12
            if (r11 != 0) goto L_0x00cf
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x00c9
            goto L_0x00cf
        L_0x00c9:
            r0.skipToGroupEnd()
        L_0x00cc:
            r5 = r10
            goto L_0x0273
        L_0x00cf:
            if (r9 == 0) goto L_0x00d2
            r10 = 0
        L_0x00d2:
            r9 = 0
            if (r3 == 0) goto L_0x00e9
            r12 = -1789984861(0xffffffff954effa3, float:-4.180303E-26)
            r0.startReplaceableGroup(r12)
            com.designsystem.ds_theme.DSTheme r12 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r12 = r12.getColors(r0, r9)
            long r12 = r12.m8774getDsNeutralWhite0d7_KjU()
            r0.endReplaceableGroup()
            goto L_0x00fc
        L_0x00e9:
            r12 = -1789984810(0xffffffff954effd6, float:-4.1803188E-26)
            r0.startReplaceableGroup(r12)
            com.designsystem.ds_theme.DSTheme r12 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r12 = r12.getColors(r0, r9)
            long r12 = r12.m8765getDsNeutral40d7_KjU()
            r0.endReplaceableGroup()
        L_0x00fc:
            int[] r14 = com.designsystem.ds_input_field.InputFieldCommonComposablesKt.WhenMappings.$EnumSwitchMapping$0
            int r15 = r18.ordinal()
            r14 = r14[r15]
            r15 = 1
            if (r14 == r15) goto L_0x013f
            if (r14 == r8) goto L_0x012b
            r15 = 3
            if (r14 != r15) goto L_0x011c
            r14 = -1789984547(0xffffffff954f00dd, float:-4.1803998E-26)
            r0.startReplaceableGroup(r14)
            r14 = r5 & 14
            long r14 = r1.m8442getStateColorWaAFU9c(r0, r14)
            r0.endReplaceableGroup()
            goto L_0x0152
        L_0x011c:
            r1 = -1789998338(0xffffffff954ecafe, float:-4.17615E-26)
            r0.startReplaceableGroup(r1)
            r0.endReplaceableGroup()
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x012b:
            r14 = -1789984603(0xffffffff954f00a5, float:-4.1803826E-26)
            r0.startReplaceableGroup(r14)
            com.designsystem.ds_theme.DSTheme r14 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r14 = r14.getColors(r0, r9)
            long r14 = r14.m8759getDsNeutral100d7_KjU()
            r0.endReplaceableGroup()
            goto L_0x0152
        L_0x013f:
            r14 = -1789984666(0xffffffff954f0066, float:-4.180363E-26)
            r0.startReplaceableGroup(r14)
            com.designsystem.ds_theme.DSTheme r14 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r14 = r14.getColors(r0, r9)
            long r14 = r14.m8793getDsPrimary1000d7_KjU()
            r0.endReplaceableGroup()
        L_0x0152:
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = overrideTapListener(r8, r10, r3)
            com.designsystem.ds_theme.DSTheme r11 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r16 = r11.getDimens(r0, r9)
            float r9 = r16.m8846getDsXxsD9Ej5fM()
            androidx.compose.ui.Modifier r8 = m8439inputFieldBorderHht5A8o(r8, r14, r9)
            r9 = 0
            r14 = 0
            r15 = 2
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m546heightInVpY3zN4$default(r8, r4, r9, r15, r14)
            r9 = 0
            com.designsystem.ds_theme.DSDimens r14 = r11.getDimens(r0, r9)
            float r14 = r14.m8846getDsXxsD9Ej5fM()
            androidx.compose.foundation.shape.RoundedCornerShape r14 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r14)
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r8, r12, r14)
            com.designsystem.ds_theme.DSDimens r12 = r11.getDimens(r0, r9)
            float r12 = r12.m8842getDsSD9Ej5fM()
            com.designsystem.ds_theme.DSDimens r9 = r11.getDimens(r0, r9)
            float r9 = r9.m8846getDsXxsD9Ej5fM()
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m487paddingVpY3zN4(r8, r12, r9)
            java.lang.String r9 = "InputFieldDecorationBoxTestTag"
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.platform.TestTagKt.testTag(r8, r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getCenterVertically()
            int r5 = r5 >> 6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r11 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r11)
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r11 = r11.getStart()
            int r12 = r5 >> 3
            r13 = r12 & 14
            r12 = r12 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r11, r9, r0, r12)
            int r11 = r5 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            int r11 = r11 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x01f0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01f0:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x01fd
            r0.createNode(r15)
            goto L_0x0200
        L_0x01fd:
            r0.useNode()
        L_0x0200:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r9, r15)
            kotlin.jvm.functions.Function2 r9 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r12, r9)
            kotlin.jvm.functions.Function2 r9 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r13, r9)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            int r9 = r11 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.invoke(r1, r0, r9)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r1 = r11 >> 9
            r1 = r1 & 14
            r8 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r8)
            r1 = r1 & 11
            r8 = 2
            r1 = r1 ^ r8
            if (r1 != 0) goto L_0x0253
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x024f
            goto L_0x0253
        L_0x024f:
            r0.skipToGroupEnd()
            goto L_0x0262
        L_0x0253:
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r5 = r5 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.invoke(r1, r0, r5)
        L_0x0262:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x00cc
        L_0x0273:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x027a
            goto L_0x0291
        L_0x027a:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$TextFieldDecorationBoxBackground$1 r10 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$TextFieldDecorationBoxBackground$1
            r0 = r10
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r6 = r22
            r7 = r24
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x0291:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8426TextFieldDecorationBoxBackgroundjIwJxvA(com.designsystem.ds_input_field.OuterState, com.designsystem.ds_input_field.ContainerState, boolean, float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: TextInputWithAnimatedHint-fD77gVg  reason: not valid java name */
    public static final void m8427TextInputWithAnimatedHintfD77gVg(BoxScope boxScope, String str, boolean z11, Dp dp2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long j11, TextStyle textStyle, boolean z12, Composer composer, int i11) {
        int i12;
        LayoutDirection layoutDirection;
        String str2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        String str3 = str;
        boolean z13 = z11;
        Dp dp3 = dp2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        boolean z14 = z12;
        int i23 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1203392532);
        if ((i23 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxScope)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i12 = i22 | i23;
        } else {
            BoxScope boxScope2 = boxScope;
            i12 = i23;
        }
        if ((i23 & 112) == 0) {
            if (startRestartGroup.changed((Object) str3)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i12 |= i21;
        }
        if ((i23 & 896) == 0) {
            if (startRestartGroup.changed(z13)) {
                i19 = 256;
            } else {
                i19 = 128;
            }
            i12 |= i19;
        }
        if ((i23 & 7168) == 0) {
            if (startRestartGroup.changed((Object) dp3)) {
                i18 = 2048;
            } else {
                i18 = 1024;
            }
            i12 |= i18;
        }
        if ((57344 & i23) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i12 |= i17;
        }
        if ((458752 & i23) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i16 = 131072;
            } else {
                i16 = 65536;
            }
            i12 |= i16;
        }
        if ((3670016 & i23) == 0) {
            if (startRestartGroup.changed(j11)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i12 |= i15;
        } else {
            long j12 = j11;
        }
        TextStyle textStyle2 = textStyle;
        if ((29360128 & i23) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i14 = 8388608;
            } else {
                i14 = 4194304;
            }
            i12 |= i14;
        }
        if ((234881024 & i23) == 0) {
            if (startRestartGroup.changed(z14)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i12 |= i13;
        }
        if (((191739611 & i12) ^ 38347922) != 0 || !startRestartGroup.getSkipping()) {
            if (z14) {
                startRestartGroup.startReplaceableGroup(-1203392148);
                startRestartGroup.endReplaceableGroup();
                layoutDirection = LayoutDirection.Ltr;
            } else {
                startRestartGroup.startReplaceableGroup(-1203392118);
                layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.startReplaceableGroup(-1113031299);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r82, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion2.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection2, companion2.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(276693241);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (str3 == null) {
                startRestartGroup.startReplaceableGroup(-1329518062);
            } else {
                startRestartGroup.startReplaceableGroup(-1705455665);
                HintPlaceholder(z13, startRestartGroup, (i12 >> 6) & 14);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalLayoutDirection().provides(layoutDirection)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819902045, true, new InputFieldCommonComposablesKt$TextInputWithAnimatedHint$1$2(dp3, function23, i12, function24)), startRestartGroup, 56);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (str3 != null) {
                str2 = str3;
            } else {
                str2 = "";
            }
            int i24 = i12 >> 15;
            long j13 = j11;
            TextStyle textStyle3 = textStyle;
            BoxScope boxScope3 = boxScope;
            Composer composer2 = startRestartGroup;
            m8412HintEPk0efs(str2, j13, textStyle3, boxScope3, composer2, (i24 & 896) | (i24 & 112) | ((i12 << 9) & 7168));
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$TextInputWithAnimatedHint$2(boxScope, str, z11, dp2, function2, function22, j11, textStyle, z12, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: TextInputWithHint-UcWoP3I  reason: not valid java name */
    public static final void m8428TextInputWithHintUcWoP3I(BoxScope boxScope, String str, String str2, boolean z11, Dp dp2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z12, Composer composer, int i11) {
        int i12;
        LayoutDirection layoutDirection;
        String str3;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        String str4 = str;
        String str5 = str2;
        boolean z13 = z11;
        Dp dp3 = dp2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        boolean z14 = z12;
        int i22 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-2131033770);
        if ((i22 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxScope)) {
                i21 = 4;
            } else {
                i21 = 2;
            }
            i12 = i21 | i22;
        } else {
            BoxScope boxScope2 = boxScope;
            i12 = i22;
        }
        if ((i22 & 112) == 0) {
            if (startRestartGroup.changed((Object) str4)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i12 |= i19;
        }
        if ((i22 & 896) == 0) {
            if (startRestartGroup.changed((Object) str5)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i12 |= i18;
        }
        if ((i22 & 7168) == 0) {
            if (startRestartGroup.changed(z13)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i12 |= i17;
        }
        if ((57344 & i22) == 0) {
            if (startRestartGroup.changed((Object) dp3)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i12 |= i16;
        }
        if ((458752 & i22) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i12 |= i15;
        }
        if ((3670016 & i22) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i12 |= i14;
        }
        if ((29360128 & i22) == 0) {
            if (startRestartGroup.changed(z14)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i12 |= i13;
        }
        if (((23967451 & i12) ^ 4793490) != 0 || !startRestartGroup.getSkipping()) {
            if (z14) {
                startRestartGroup.startReplaceableGroup(-2131033429);
                startRestartGroup.endReplaceableGroup();
                layoutDirection = LayoutDirection.Ltr;
            } else {
                startRestartGroup.startReplaceableGroup(-2131033399);
                layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                startRestartGroup.endReplaceableGroup();
            }
            boolean z15 = true;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalLayoutDirection().provides(layoutDirection)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819899227, true, new InputFieldCommonComposablesKt$TextInputWithHint$1(dp3, function23, i12, function24)), startRestartGroup, 56);
            if (!(str4 == null || str.length() == 0)) {
                z15 = false;
            }
            if (z15) {
                startRestartGroup.startReplaceableGroup(-2131033119);
                if (str5 != null) {
                    str3 = str5;
                } else {
                    str3 = "";
                }
                m8412HintEPk0efs(str3, Offset.Companion.m2692getZeroF1C5BW0(), InputFieldTextStyleComposablesKt.bigHintTextStyle(z13, startRestartGroup, (i12 >> 9) & 14), boxScope, startRestartGroup, (i12 << 9) & 7168);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-2131032977);
                startRestartGroup.endReplaceableGroup();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldCommonComposablesKt$TextInputWithHint$2(boxScope, str, str2, z11, dp2, function2, function22, z12, i11));
        }
    }

    @Composable
    private static final <InputState> State<Offset> animateHintOffset(Transition<InputState> transition, Composer composer, int i11) {
        long j11;
        long j12;
        composer.startReplaceableGroup(-1954678086);
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        InputFieldCommonComposablesKt$animateHintOffset$1 inputFieldCommonComposablesKt$animateHintOffset$1 = InputFieldCommonComposablesKt$animateHintOffset$1.INSTANCE;
        int i12 = (i11 & 14) | 3136;
        composer.startReplaceableGroup(1847721878);
        InputState currentState = transition.getCurrentState();
        composer.startReplaceableGroup(1050291899);
        InputState inputstate = InputState.UNFOCUSED_EMPTY;
        if (currentState != inputstate) {
            composer.startReplaceableGroup(1050291995);
            DSTheme dSTheme = DSTheme.INSTANCE;
            j11 = androidx.compose.ui.geometry.OffsetKt.Offset(dSTheme.getDimens(composer, 0).m8849getDsZeroD9Ej5fM(), dSTheme.getDimens(composer, 0).m8849getDsZeroD9Ej5fM());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1050292097);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            j11 = androidx.compose.ui.geometry.OffsetKt.Offset(dSTheme2.getDimens(composer, 0).m8849getDsZeroD9Ej5fM(), dSTheme2.getDimens(composer, 0).m8846getDsXxsD9Ej5fM());
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        Offset r92 = Offset.m2665boximpl(j11);
        InputState targetState = transition.getTargetState();
        composer.startReplaceableGroup(1050291899);
        if (targetState != inputstate) {
            composer.startReplaceableGroup(1050291995);
            DSTheme dSTheme3 = DSTheme.INSTANCE;
            j12 = androidx.compose.ui.geometry.OffsetKt.Offset(dSTheme3.getDimens(composer, 0).m8849getDsZeroD9Ej5fM(), dSTheme3.getDimens(composer, 0).m8849getDsZeroD9Ej5fM());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1050292097);
            DSTheme dSTheme4 = DSTheme.INSTANCE;
            j12 = androidx.compose.ui.geometry.OffsetKt.Offset(dSTheme4.getDimens(composer, 0).m8849getDsZeroD9Ej5fM(), dSTheme4.getDimens(composer, 0).m8846getDsXxsD9Ej5fM());
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        State<Offset> createTransitionAnimation = TransitionKt.createTransitionAnimation(transition, r92, Offset.m2665boximpl(j12), (FiniteAnimationSpec) inputFieldCommonComposablesKt$animateHintOffset$1.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), vectorConverter, InputFieldCommon.HintOffsetAnimationLabel, composer, (i12 & 14) | ((i12 << 9) & 57344) | ((i12 << 6) & Opcodes.ASM7));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    @Composable
    private static final <InputState> State<Float> animateLerpProgress(Transition<InputState> transition, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(-73570738);
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        InputFieldCommonComposablesKt$animateLerpProgress$1 inputFieldCommonComposablesKt$animateLerpProgress$1 = InputFieldCommonComposablesKt$animateLerpProgress$1.INSTANCE;
        int i12 = (i11 & 14) | 3136;
        composer.startReplaceableGroup(1847721878);
        InputState currentState = transition.getCurrentState();
        composer.startReplaceableGroup(845355345);
        InputState inputstate = InputState.UNFOCUSED_EMPTY;
        float f12 = 1.0f;
        if (currentState != inputstate) {
            f11 = 1.0f;
        } else {
            f11 = 0.0f;
        }
        composer.endReplaceableGroup();
        Float valueOf = Float.valueOf(f11);
        InputState targetState = transition.getTargetState();
        composer.startReplaceableGroup(845355345);
        if (targetState == inputstate) {
            f12 = 0.0f;
        }
        composer.endReplaceableGroup();
        State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation(transition, valueOf, Float.valueOf(f12), (FiniteAnimationSpec) inputFieldCommonComposablesKt$animateLerpProgress$1.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), vectorConverter, InputFieldCommon.LerpProgressAnimationLabel, composer, ((i12 << 6) & Opcodes.ASM7) | (i12 & 14) | ((i12 << 9) & 57344));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    private static final ContainerState getContainerState(boolean z11, boolean z12) {
        if (!z11) {
            return ContainerState.DISABLED;
        }
        if (z12) {
            return ContainerState.FOCUSED;
        }
        return ContainerState.OUTER_STATE;
    }

    /* access modifiers changed from: private */
    /* renamed from: getInputHeightModifier-YLDhkOg  reason: not valid java name */
    public static final Modifier m8438getInputHeightModifierYLDhkOg(Dp dp2) {
        if (dp2 != null) {
            return SizeKt.m544height3ABfNKs(Modifier.Companion, dp2.m5492unboximpl());
        }
        return Modifier.Companion;
    }

    private static final InputState getInputState(TextFieldValue textFieldValue, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2) {
        boolean z12;
        if (z11) {
            return InputState.FOCUSED;
        }
        if (textFieldValue.getText().length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12 || function2 != null) {
            return InputState.UNFOCUSED_NOT_EMPTY;
        }
        return InputState.UNFOCUSED_EMPTY;
    }

    @NotNull
    @Stable
    /* renamed from: inputFieldBorder-Hht5A8o  reason: not valid java name */
    public static final Modifier m8439inputFieldBorderHht5A8o(@NotNull Modifier modifier, long j11, float f11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$inputFieldBorder");
        return BorderKt.border(modifier, BorderStrokeKt.m191BorderStrokecXLIe8U(InputFieldCommon.INSTANCE.m8407getInputFieldBorderStrokeD9Ej5fM(), j11), RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(f11));
    }

    @Stable
    private static final Modifier overrideTapListener(Modifier modifier, Function0<Unit> function0, boolean z11) {
        if (function0 == null) {
            return modifier;
        }
        return modifier.then(ClickableKt.m194clickableO2vRcR0$default(modifier, InteractionSourceKt.MutableInteractionSource(), (Indication) null, false, (String) null, Role.m4904boximpl(Role.Companion.m4911getButtono7Vup1c()), new InputFieldCommonComposablesKt$overrideTapListener$1(z11, function0), 12, (Object) null));
    }
}
