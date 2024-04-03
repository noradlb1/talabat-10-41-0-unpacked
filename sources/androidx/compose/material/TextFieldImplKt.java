package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aW\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", "border", "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final float HorizontalIconPadding = Dp.m5478constructorimpl((float) 12);
    @NotNull
    private static final Modifier IconDefaultSizeModifier;
    @NotNull
    public static final String LabelId = "Label";
    @NotNull
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    @NotNull
    public static final String PlaceholderId = "Hint";
    @NotNull
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = Dp.m5478constructorimpl((float) 16);
    @NotNull
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    static {
        float f11 = (float) 48;
        IconDefaultSizeModifier = SizeKt.m542defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m5478constructorimpl(f11), Dp.m5478constructorimpl(f11));
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void CommonDecorationBox(@NotNull TextFieldType textFieldType, @NotNull String str, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull VisualTransformation visualTransformation, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, boolean z11, boolean z12, boolean z13, @NotNull InteractionSource interactionSource, @NotNull PaddingValues paddingValues, @NotNull TextFieldColors textFieldColors, @Nullable Function2<? super Composer, ? super Integer, Unit> function26, @Nullable Composer composer, int i11, int i12, int i13) {
        int i14;
        int i15;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Composer composer2;
        boolean z14;
        boolean z15;
        boolean z16;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        InputPhase inputPhase;
        TextFieldType textFieldType2 = textFieldType;
        String str2 = str;
        Function2<? super Composer, ? super Integer, Unit> function211 = function2;
        VisualTransformation visualTransformation2 = visualTransformation;
        Function2<? super Composer, ? super Integer, Unit> function212 = function22;
        InteractionSource interactionSource2 = interactionSource;
        PaddingValues paddingValues2 = paddingValues;
        TextFieldColors textFieldColors2 = textFieldColors;
        int i16 = i11;
        int i17 = i12;
        int i18 = i13;
        Intrinsics.checkNotNullParameter(textFieldType2, "type");
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(function211, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation2, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(paddingValues2, "contentPadding");
        Intrinsics.checkNotNullParameter(textFieldColors2, "colors");
        Composer startRestartGroup = composer.startRestartGroup(-712568069);
        if ((i18 & 1) != 0) {
            i14 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i14 = (startRestartGroup.changed((Object) textFieldType2) ? 4 : 2) | i16;
        } else {
            i14 = i16;
        }
        int i19 = 32;
        if ((i18 & 2) != 0) {
            i14 |= 48;
        } else if ((i16 & 112) == 0) {
            i14 |= startRestartGroup.changed((Object) str2) ? 32 : 16;
        }
        int i21 = 256;
        if ((i18 & 4) != 0) {
            i14 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i16 & 896) == 0) {
            i14 |= startRestartGroup.changed((Object) function211) ? 256 : 128;
        }
        int i22 = 2048;
        if ((i18 & 8) != 0) {
            i14 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i16 & 7168) == 0) {
            i14 |= startRestartGroup.changed((Object) visualTransformation2) ? 2048 : 1024;
        }
        int i23 = 16384;
        if ((i18 & 16) != 0) {
            i14 |= CpioConstants.C_ISBLK;
        } else if ((i16 & 57344) == 0) {
            i14 |= startRestartGroup.changed((Object) function212) ? 16384 : 8192;
        }
        int i24 = i18 & 32;
        if (i24 != 0) {
            i14 |= 196608;
            Function2<? super Composer, ? super Integer, Unit> function213 = function23;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function214 = function23;
            if ((i16 & Opcodes.ASM7) == 0) {
                i14 |= startRestartGroup.changed((Object) function214) ? 131072 : 65536;
            }
        }
        int i25 = i18 & 64;
        if (i25 != 0) {
            i14 |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function215 = function24;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function216 = function24;
            if ((i16 & 3670016) == 0) {
                i14 |= startRestartGroup.changed((Object) function216) ? 1048576 : 524288;
            }
        }
        int i26 = i18 & 128;
        if (i26 != 0) {
            i14 |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function217 = function25;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function218 = function25;
            if ((i16 & 29360128) == 0) {
                i14 |= startRestartGroup.changed((Object) function218) ? 8388608 : 4194304;
            }
        }
        int i27 = i18 & 256;
        if (i27 != 0) {
            i14 |= 100663296;
            boolean z17 = z11;
        } else {
            boolean z18 = z11;
            if ((i16 & 234881024) == 0) {
                i14 |= startRestartGroup.changed(z18) ? 67108864 : 33554432;
            }
        }
        int i28 = i18 & 512;
        if (i28 != 0) {
            i14 |= 805306368;
            boolean z19 = z12;
        } else {
            int i29 = i16 & 1879048192;
            boolean z21 = z12;
            if (i29 == 0) {
                i14 |= startRestartGroup.changed(z21) ? 536870912 : 268435456;
            }
        }
        int i31 = i14;
        int i32 = i18 & 1024;
        if (i32 != 0) {
            i15 = i17 | 6;
            boolean z22 = z13;
        } else {
            boolean z23 = z13;
            if ((i17 & 14) == 0) {
                i15 = i17 | (startRestartGroup.changed(z23) ? 4 : 2);
            } else {
                i15 = i17;
            }
        }
        if ((i18 & 2048) != 0) {
            i15 |= 48;
        } else if ((i17 & 112) == 0) {
            if (!startRestartGroup.changed((Object) interactionSource2)) {
                i19 = 16;
            }
            i15 |= i19;
        }
        int i33 = i15;
        if ((i18 & 4096) != 0) {
            i33 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i17 & 896) == 0) {
            if (!startRestartGroup.changed((Object) paddingValues2)) {
                i21 = 128;
            }
            i33 |= i21;
        }
        if ((i18 & 8192) != 0) {
            i33 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i17 & 7168) == 0) {
            if (!startRestartGroup.changed((Object) textFieldColors2)) {
                i22 = 1024;
            }
            i33 |= i22;
        }
        int i34 = i18 & 16384;
        if (i34 != 0) {
            i33 |= CpioConstants.C_ISBLK;
            Function2<? super Composer, ? super Integer, Unit> function219 = function26;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function220 = function26;
            if ((i17 & 57344) == 0) {
                if (!startRestartGroup.changed((Object) function220)) {
                    i23 = 8192;
                }
                i33 |= i23;
            }
        }
        if ((i31 & 1533916891) == 306783378 && (46811 & i33) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function210 = function23;
            function29 = function24;
            function28 = function25;
            z16 = z11;
            z15 = z12;
            z14 = z13;
            function27 = function26;
            composer2 = startRestartGroup;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function221 = i24 != 0 ? null : function23;
            Function2<? super Composer, ? super Integer, Unit> function222 = i25 != 0 ? null : function24;
            Function2<? super Composer, ? super Integer, Unit> function223 = i26 != 0 ? null : function25;
            boolean z24 = i27 != 0 ? false : z11;
            boolean z25 = i28 != 0 ? true : z12;
            boolean z26 = i32 != 0 ? false : z13;
            Function2<? super Composer, ? super Integer, Unit> function224 = i34 != 0 ? null : function26;
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed((Object) str2) | startRestartGroup.changed((Object) visualTransformation2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = visualTransformation2.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            String text = ((TransformedText) rememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource2, startRestartGroup, (i33 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
            }
            InputPhase inputPhase2 = inputPhase;
            Composer composer3 = startRestartGroup;
            TextFieldImplKt$CommonDecorationBox$labelColor$1 textFieldImplKt$CommonDecorationBox$labelColor$1 = r0;
            TextFieldImplKt$CommonDecorationBox$labelColor$1 textFieldImplKt$CommonDecorationBox$labelColor$12 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z25, z26, interactionSource, i31, i33);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(composer3, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            long r42 = subtitle1.m5056getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            TextStyle textStyle = caption;
            boolean z27 = (Color.m2920equalsimpl0(r42, companion.m2955getUnspecified0d7_KjU()) && !Color.m2920equalsimpl0(textStyle.m5056getColor0d7_KjU(), companion.m2955getUnspecified0d7_KjU())) || (!Color.m2920equalsimpl0(subtitle1.m5056getColor0d7_KjU(), companion.m2955getUnspecified0d7_KjU()) && Color.m2920equalsimpl0(textStyle.m5056getColor0d7_KjU(), companion.m2955getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            composer3.startReplaceableGroup(2129141006);
            long r12 = materialTheme.getTypography(composer3, 6).getCaption().m5056getColor0d7_KjU();
            if (z27) {
                if (!(r12 != companion.m2955getUnspecified0d7_KjU())) {
                    r12 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composer3, 0)).m2929unboximpl();
                }
            }
            long j11 = r12;
            composer3.endReplaceableGroup();
            long r02 = materialTheme.getTypography(composer3, 6).getSubtitle1().m5056getColor0d7_KjU();
            if (z27) {
                if (!(r02 != companion.m2955getUnspecified0d7_KjU())) {
                    r02 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composer3, 0)).m2929unboximpl();
                }
            }
            long j12 = r02;
            boolean z28 = function212 != null;
            TextFieldImplKt$CommonDecorationBox$labelColor$1 textFieldImplKt$CommonDecorationBox$labelColor$13 = textFieldImplKt$CommonDecorationBox$labelColor$1;
            TextFieldImplKt$CommonDecorationBox$3 textFieldImplKt$CommonDecorationBox$3 = r0;
            TextFieldImplKt$CommonDecorationBox$3 textFieldImplKt$CommonDecorationBox$32 = new TextFieldImplKt$CommonDecorationBox$3(function22, function221, text, z26, i33, textFieldColors, z25, interactionSource, i31, function222, function223, textFieldType, function2, z24, paddingValues, z27, function224);
            composer2 = composer3;
            textFieldTransitionScope.m1459TransitionDTcfvLk(inputPhase2, j11, j12, textFieldImplKt$CommonDecorationBox$labelColor$13, z28, ComposableLambdaKt.composableLambda(composer2, 341865432, true, textFieldImplKt$CommonDecorationBox$3), composer2, 1769472);
            function210 = function221;
            function29 = function222;
            function28 = function223;
            z16 = z24;
            z15 = z25;
            z14 = z26;
            function27 = function224;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            TextFieldImplKt$CommonDecorationBox$4 textFieldImplKt$CommonDecorationBox$4 = r0;
            TextFieldImplKt$CommonDecorationBox$4 textFieldImplKt$CommonDecorationBox$42 = new TextFieldImplKt$CommonDecorationBox$4(textFieldType, str, function2, visualTransformation, function22, function210, function29, function28, z16, z15, z14, interactionSource, paddingValues, textFieldColors, function27, i11, i12, i13);
            endRestartGroup.updateScope(textFieldImplKt$CommonDecorationBox$4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableOpenTarget(index = 0)
    /* renamed from: Decoration-euL9pac  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1446DecorationeuL9pac(long r15, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r17, @org.jetbrains.annotations.Nullable java.lang.Float r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r6 = r19
            r7 = r21
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -399493340(0xffffffffe8303724, float:-3.3286147E24)
            r1 = r20
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            r0 = r22 & 1
            if (r0 == 0) goto L_0x001a
            r0 = r7 | 6
            r9 = r15
            goto L_0x002b
        L_0x001a:
            r0 = r7 & 14
            r9 = r15
            if (r0 != 0) goto L_0x002a
            boolean r0 = r8.changed((long) r9)
            if (r0 == 0) goto L_0x0027
            r0 = 4
            goto L_0x0028
        L_0x0027:
            r0 = 2
        L_0x0028:
            r0 = r0 | r7
            goto L_0x002b
        L_0x002a:
            r0 = r7
        L_0x002b:
            r1 = r22 & 2
            if (r1 == 0) goto L_0x0032
            r0 = r0 | 48
            goto L_0x0045
        L_0x0032:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0045
            r2 = r17
            boolean r3 = r8.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0041
            r3 = 32
            goto L_0x0043
        L_0x0041:
            r3 = 16
        L_0x0043:
            r0 = r0 | r3
            goto L_0x0047
        L_0x0045:
            r2 = r17
        L_0x0047:
            r3 = r22 & 4
            if (r3 == 0) goto L_0x004e
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r4 = r7 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0061
            r4 = r18
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005d
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r0 = r0 | r5
            goto L_0x0063
        L_0x0061:
            r4 = r18
        L_0x0063:
            r5 = r22 & 8
            if (r5 == 0) goto L_0x006a
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r5 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007a
            boolean r5 = r8.changed((java.lang.Object) r6)
            if (r5 == 0) goto L_0x0077
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r0 = r0 | r5
        L_0x007a:
            r11 = r0
            r0 = r11 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r0 != r5) goto L_0x008d
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            r8.skipToGroupEnd()
            r3 = r2
            goto L_0x00d0
        L_0x008d:
            r0 = 0
            if (r1 == 0) goto L_0x0092
            r12 = r0
            goto L_0x0093
        L_0x0092:
            r12 = r2
        L_0x0093:
            if (r3 == 0) goto L_0x0097
            r13 = r0
            goto L_0x0098
        L_0x0097:
            r13 = r4
        L_0x0098:
            androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1 r14 = new androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
            r0 = r14
            r1 = r15
            r3 = r13
            r4 = r19
            r5 = r11
            r0.<init>(r1, r3, r4, r5)
            r0 = 494684590(0x1d7c49ae, float:3.3390014E-21)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r0, r1, r14)
            if (r12 == 0) goto L_0x00bd
            r1 = -2009952864(0xffffffff88328da0, float:-5.3731406E-34)
            r8.startReplaceableGroup(r1)
            int r1 = r11 >> 3
            r1 = r1 & 14
            r1 = r1 | 48
            androidx.compose.material.TextKt.ProvideTextStyle(r12, r0, r8, r1)
            goto L_0x00cb
        L_0x00bd:
            r1 = -2009952812(0xffffffff88328dd4, float:-5.3731645E-34)
            r8.startReplaceableGroup(r1)
            r1 = 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.invoke(r8, r1)
        L_0x00cb:
            r8.endReplaceableGroup()
            r3 = r12
            r4 = r13
        L_0x00d0:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x00d7
            goto L_0x00e7
        L_0x00d7:
            androidx.compose.material.TextFieldImplKt$Decoration$1 r11 = new androidx.compose.material.TextFieldImplKt$Decoration$1
            r0 = r11
            r1 = r15
            r5 = r19
            r6 = r21
            r7 = r22
            r0.<init>(r1, r3, r4, r5, r6, r7)
            r8.updateScope(r11)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m1446DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    @NotNull
    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    @Nullable
    public static final Object getLayoutId(@NotNull IntrinsicMeasurable intrinsicMeasurable) {
        LayoutIdParentData layoutIdParentData;
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof LayoutIdParentData) {
            layoutIdParentData = (LayoutIdParentData) parentData;
        } else {
            layoutIdParentData = null;
        }
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final int widthOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
