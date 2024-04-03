package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aò\u0001\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*2\u0006\u0010+\u001a\u00020,2\u0013\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u0002032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0011\u0010<\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*H\u0001¢\u0006\u0002\u0010=\u001a<\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0011\u0010C\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u0012\u0010F\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0000\u001a\u0012\u0010I\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0013\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0019\u001a\u00020\u001aX\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    @NotNull
    public static final String ContainerId = "Container";
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
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = Dp.m5478constructorimpl((float) 4);
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

    /* JADX WARNING: Removed duplicated region for block: B:163:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CommonDecorationBox(@org.jetbrains.annotations.NotNull androidx.compose.material3.TextFieldType r39, @org.jetbrains.annotations.NotNull java.lang.String r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.VisualTransformation r42, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, boolean r48, boolean r49, boolean r50, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r51, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.PaddingValues r52, @org.jetbrains.annotations.NotNull androidx.compose.material3.TextFieldColors r53, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r15 = r39
            r14 = r40
            r13 = r41
            r12 = r42
            r11 = r43
            r10 = r51
            r9 = r52
            r8 = r53
            r7 = r54
            r6 = r56
            r5 = r57
            r4 = r58
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 4948732(0x4b82fc, float:6.93465E-39)
            r1 = r55
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            r1 = r4 & 1
            r16 = 2
            if (r1 == 0) goto L_0x0052
            r1 = r6 | 6
            goto L_0x0063
        L_0x0052:
            r1 = r6 & 14
            if (r1 != 0) goto L_0x0062
            boolean r1 = r3.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x005e
            r1 = 4
            goto L_0x0060
        L_0x005e:
            r1 = r16
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0063
        L_0x0062:
            r1 = r6
        L_0x0063:
            r17 = r4 & 2
            r18 = 32
            r19 = 16
            if (r17 == 0) goto L_0x006e
            r1 = r1 | 48
            goto L_0x007f
        L_0x006e:
            r17 = r6 & 112(0x70, float:1.57E-43)
            if (r17 != 0) goto L_0x007f
            boolean r17 = r3.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x007b
            r17 = r18
            goto L_0x007d
        L_0x007b:
            r17 = r19
        L_0x007d:
            r1 = r1 | r17
        L_0x007f:
            r17 = r4 & 4
            r20 = 256(0x100, float:3.59E-43)
            r21 = 128(0x80, float:1.794E-43)
            if (r17 == 0) goto L_0x008a
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x009a
        L_0x008a:
            r2 = r6 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x009a
            boolean r2 = r3.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0097
            r2 = r20
            goto L_0x0099
        L_0x0097:
            r2 = r21
        L_0x0099:
            r1 = r1 | r2
        L_0x009a:
            r2 = r4 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r22 = 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x00a5
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00b5
        L_0x00a5:
            r2 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x00b5
            boolean r2 = r3.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x00b2
            r2 = r17
            goto L_0x00b4
        L_0x00b2:
            r2 = r22
        L_0x00b4:
            r1 = r1 | r2
        L_0x00b5:
            r2 = r4 & 16
            r23 = 16384(0x4000, float:2.2959E-41)
            r24 = 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x00c0
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00d2
        L_0x00c0:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r6
            if (r2 != 0) goto L_0x00d2
            boolean r2 = r3.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x00cf
            r2 = r23
            goto L_0x00d1
        L_0x00cf:
            r2 = r24
        L_0x00d1:
            r1 = r1 | r2
        L_0x00d2:
            r2 = r4 & 32
            if (r2 == 0) goto L_0x00dd
            r25 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r25
            r0 = r44
            goto L_0x00f2
        L_0x00dd:
            r25 = 458752(0x70000, float:6.42848E-40)
            r25 = r6 & r25
            r0 = r44
            if (r25 != 0) goto L_0x00f2
            boolean r26 = r3.changed((java.lang.Object) r0)
            if (r26 == 0) goto L_0x00ee
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00f0
        L_0x00ee:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00f0:
            r1 = r1 | r26
        L_0x00f2:
            r26 = r4 & 64
            if (r26 == 0) goto L_0x00fd
            r27 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r27
            r0 = r45
            goto L_0x0112
        L_0x00fd:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r6 & r27
            r0 = r45
            if (r27 != 0) goto L_0x0112
            boolean r27 = r3.changed((java.lang.Object) r0)
            if (r27 == 0) goto L_0x010e
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0110
        L_0x010e:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x0110:
            r1 = r1 | r27
        L_0x0112:
            r0 = r4 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x011d
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r27
            r13 = r46
            goto L_0x0132
        L_0x011d:
            r27 = 29360128(0x1c00000, float:7.052966E-38)
            r27 = r6 & r27
            r13 = r46
            if (r27 != 0) goto L_0x0132
            boolean r27 = r3.changed((java.lang.Object) r13)
            if (r27 == 0) goto L_0x012e
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0130
        L_0x012e:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x0130:
            r1 = r1 | r27
        L_0x0132:
            r13 = r4 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x013d
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r27
            r15 = r47
            goto L_0x0152
        L_0x013d:
            r27 = 234881024(0xe000000, float:1.5777218E-30)
            r27 = r6 & r27
            r15 = r47
            if (r27 != 0) goto L_0x0152
            boolean r27 = r3.changed((java.lang.Object) r15)
            if (r27 == 0) goto L_0x014e
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0150
        L_0x014e:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0150:
            r1 = r1 | r27
        L_0x0152:
            r15 = r4 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x015d
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r27
            r6 = r48
            goto L_0x0172
        L_0x015d:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r6 & r27
            r6 = r48
            if (r27 != 0) goto L_0x0172
            boolean r27 = r3.changed((boolean) r6)
            if (r27 == 0) goto L_0x016e
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0170
        L_0x016e:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0170:
            r1 = r1 | r27
        L_0x0172:
            r6 = r4 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x017b
            r16 = r5 | 6
            r11 = r49
            goto L_0x018e
        L_0x017b:
            r27 = r5 & 14
            r11 = r49
            if (r27 != 0) goto L_0x018c
            boolean r27 = r3.changed((boolean) r11)
            if (r27 == 0) goto L_0x0189
            r16 = 4
        L_0x0189:
            r16 = r5 | r16
            goto L_0x018e
        L_0x018c:
            r16 = r5
        L_0x018e:
            r11 = r4 & 2048(0x800, float:2.87E-42)
            if (r11 == 0) goto L_0x0195
            r16 = r16 | 48
            goto L_0x01a6
        L_0x0195:
            r27 = r5 & 112(0x70, float:1.57E-43)
            r12 = r50
            if (r27 != 0) goto L_0x01a6
            boolean r27 = r3.changed((boolean) r12)
            if (r27 == 0) goto L_0x01a2
            goto L_0x01a4
        L_0x01a2:
            r18 = r19
        L_0x01a4:
            r16 = r16 | r18
        L_0x01a6:
            r12 = r16
            r14 = r4 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x01af
            r12 = r12 | 384(0x180, float:5.38E-43)
            goto L_0x01be
        L_0x01af:
            r14 = r5 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x01be
            boolean r14 = r3.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r20 = r21
        L_0x01bc:
            r12 = r12 | r20
        L_0x01be:
            r14 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x01c5
            r12 = r12 | 3072(0xc00, float:4.305E-42)
            goto L_0x01d4
        L_0x01c5:
            r14 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01d4
            boolean r14 = r3.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r17 = r22
        L_0x01d2:
            r12 = r12 | r17
        L_0x01d4:
            r14 = r4 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01db
            r12 = r12 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01ec
        L_0x01db:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x01ec
            boolean r14 = r3.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x01e8
            goto L_0x01ea
        L_0x01e8:
            r23 = r24
        L_0x01ea:
            r12 = r12 | r23
        L_0x01ec:
            r14 = 32768(0x8000, float:4.5918E-41)
            r14 = r14 & r4
            if (r14 == 0) goto L_0x01f6
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x01f4:
            r12 = r12 | r14
            goto L_0x0207
        L_0x01f6:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x0207
            boolean r14 = r3.changed((java.lang.Object) r7)
            if (r14 == 0) goto L_0x0204
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f4
        L_0x0204:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x01f4
        L_0x0207:
            r14 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r14 = r14 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r14 != r4) goto L_0x0234
            r4 = 374491(0x5b6db, float:5.24774E-40)
            r4 = r4 & r12
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r14) goto L_0x0234
            boolean r4 = r3.getSkipping()
            if (r4 != 0) goto L_0x0220
            goto L_0x0234
        L_0x0220:
            r3.skipToGroupEnd()
            r6 = r44
            r7 = r45
            r8 = r46
            r9 = r47
            r10 = r48
            r11 = r49
            r27 = r50
            r12 = r3
            goto L_0x041b
        L_0x0234:
            r4 = 0
            if (r2 == 0) goto L_0x023a
            r20 = r4
            goto L_0x023c
        L_0x023a:
            r20 = r44
        L_0x023c:
            if (r26 == 0) goto L_0x0241
            r21 = r4
            goto L_0x0243
        L_0x0241:
            r21 = r45
        L_0x0243:
            if (r0 == 0) goto L_0x0248
            r22 = r4
            goto L_0x024a
        L_0x0248:
            r22 = r46
        L_0x024a:
            if (r13 == 0) goto L_0x024f
            r23 = r4
            goto L_0x0251
        L_0x024f:
            r23 = r47
        L_0x0251:
            if (r15 == 0) goto L_0x0256
            r24 = 0
            goto L_0x0258
        L_0x0256:
            r24 = r48
        L_0x0258:
            if (r6 == 0) goto L_0x025d
            r26 = 1
            goto L_0x025f
        L_0x025d:
            r26 = r49
        L_0x025f:
            if (r11 == 0) goto L_0x0264
            r27 = 0
            goto L_0x0266
        L_0x0264:
            r27 = r50
        L_0x0266:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0274
            java.lang.String r2 = "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:62)"
            r4 = 4948732(0x4b82fc, float:6.93465E-39)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r12, r2)
        L_0x0274:
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r2)
            r14 = r40
            boolean r2 = r3.changed((java.lang.Object) r14)
            r13 = r42
            boolean r4 = r3.changed((java.lang.Object) r13)
            r2 = r2 | r4
            java.lang.Object r4 = r3.rememberedValue()
            if (r2 != 0) goto L_0x0295
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x02b2
        L_0x0295:
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            r4 = 0
            r6 = 0
            r11 = 6
            r16 = 0
            r44 = r2
            r45 = r40
            r46 = r4
            r47 = r6
            r48 = r11
            r49 = r16
            r44.<init>(r45, r46, r47, r48, r49)
            androidx.compose.ui.text.input.TransformedText r4 = r13.filter(r2)
            r3.updateRememberedValue(r4)
        L_0x02b2:
            r3.endReplaceableGroup()
            androidx.compose.ui.text.input.TransformedText r4 = (androidx.compose.ui.text.input.TransformedText) r4
            androidx.compose.ui.text.AnnotatedString r2 = r4.getText()
            java.lang.String r4 = r2.getText()
            int r2 = r12 >> 6
            r2 = r2 & 14
            androidx.compose.runtime.State r2 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r10, r3, r2)
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x02d7
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.Focused
        L_0x02d5:
            r11 = r2
            goto L_0x02e8
        L_0x02d7:
            int r2 = r4.length()
            if (r2 != 0) goto L_0x02df
            r2 = 1
            goto L_0x02e0
        L_0x02df:
            r2 = 0
        L_0x02e0:
            if (r2 == 0) goto L_0x02e5
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.UnfocusedEmpty
            goto L_0x02d5
        L_0x02e5:
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.UnfocusedNotEmpty
            goto L_0x02d5
        L_0x02e8:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1 r6 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
            r44 = r6
            r45 = r53
            r46 = r26
            r47 = r27
            r48 = r51
            r49 = r12
            r44.<init>(r45, r46, r47, r48, r49)
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r15 = 6
            androidx.compose.material3.Typography r16 = r2.getTypography(r3, r15)
            androidx.compose.ui.text.TextStyle r17 = r16.getBodyLarge()
            androidx.compose.ui.text.TextStyle r18 = r16.getBodySmall()
            r55 = r1
            long r0 = r17.m5056getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r16 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r16.m2955getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m2920equalsimpl0(r0, r7)
            if (r0 == 0) goto L_0x0328
            long r0 = r18.m5056getColor0d7_KjU()
            long r7 = r16.m2955getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m2920equalsimpl0(r0, r7)
            if (r0 == 0) goto L_0x0344
        L_0x0328:
            long r0 = r17.m5056getColor0d7_KjU()
            long r7 = r16.m2955getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m2920equalsimpl0(r0, r7)
            if (r0 != 0) goto L_0x0347
            long r0 = r18.m5056getColor0d7_KjU()
            long r7 = r16.m2955getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m2920equalsimpl0(r0, r7)
            if (r0 == 0) goto L_0x0347
        L_0x0344:
            r17 = 1
            goto L_0x0349
        L_0x0347:
            r17 = 0
        L_0x0349:
            androidx.compose.material3.TextFieldTransitionScope r25 = androidx.compose.material3.TextFieldTransitionScope.INSTANCE
            r0 = -646388305(0xffffffffd978e5af, float:-4.37864588E15)
            r3.startReplaceableGroup(r0)
            androidx.compose.material3.Typography r0 = r2.getTypography(r3, r15)
            androidx.compose.ui.text.TextStyle r0 = r0.getBodySmall()
            long r0 = r0.m5056getColor0d7_KjU()
            if (r17 == 0) goto L_0x037c
            long r7 = r16.m2955getUnspecified0d7_KjU()
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0369
            r7 = 1
            goto L_0x036a
        L_0x0369:
            r7 = 0
        L_0x036a:
            if (r7 == 0) goto L_0x036d
            goto L_0x037c
        L_0x036d:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r6.invoke(r11, r3, r1)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m2929unboximpl()
        L_0x037c:
            r28 = r0
            r3.endReplaceableGroup()
            androidx.compose.material3.Typography r0 = r2.getTypography(r3, r15)
            androidx.compose.ui.text.TextStyle r0 = r0.getBodyLarge()
            long r0 = r0.m5056getColor0d7_KjU()
            if (r17 == 0) goto L_0x03ad
            long r7 = r16.m2955getUnspecified0d7_KjU()
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0399
            r2 = 1
            goto L_0x039a
        L_0x0399:
            r2 = 0
        L_0x039a:
            if (r2 == 0) goto L_0x039d
            goto L_0x03ad
        L_0x039d:
            r2 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r6.invoke(r11, r3, r0)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m2929unboximpl()
            goto L_0x03ae
        L_0x03ad:
            r2 = 0
        L_0x03ae:
            r30 = r0
            if (r43 == 0) goto L_0x03b5
            r32 = 1
            goto L_0x03b7
        L_0x03b5:
            r32 = r2
        L_0x03b7:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3 r15 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3
            r0 = r15
            r16 = r55
            r1 = r43
            r2 = r20
            r8 = r3
            r3 = r4
            r4 = r27
            r5 = r12
            r33 = r6
            r6 = r53
            r7 = r26
            r12 = r8
            r8 = r51
            r9 = r21
            r10 = r22
            r34 = r11
            r11 = r23
            r13 = r12
            r12 = r39
            r35 = r13
            r13 = r41
            r14 = r24
            r36 = r15
            r15 = r52
            r19 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = 1915872767(0x7231e5ff, float:3.5236413E30)
            r12 = r35
            r1 = r36
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r2, r1)
            r11 = 1769472(0x1b0000, float:2.479558E-39)
            r1 = r25
            r2 = r34
            r3 = r28
            r5 = r30
            r7 = r33
            r8 = r32
            r10 = r12
            r1.m1936TransitionDTcfvLk(r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x040f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x040f:
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r26
        L_0x041b:
            androidx.compose.runtime.ScopeUpdateScope r15 = r12.endRestartGroup()
            if (r15 != 0) goto L_0x0422
            goto L_0x044d
        L_0x0422:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4 r14 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4
            r0 = r14
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r42
            r5 = r43
            r12 = r27
            r13 = r51
            r37 = r14
            r14 = r52
            r38 = r15
            r15 = r53
            r16 = r54
            r17 = r56
            r18 = r57
            r19 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1 = r37
            r0 = r38
            r0.updateScope(r1)
        L_0x044d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    /* renamed from: Decoration-KTwxG1Y  reason: not valid java name */
    public static final void m1923DecorationKTwxG1Y(long j11, @Nullable TextStyle textStyle, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1520066345);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(j11)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        int i17 = i12 & 2;
        if (i17 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) textStyle)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if ((i13 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                textStyle = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, i13, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:236)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1449369305, true, new TextFieldImplKt$Decoration$contentWithColor$1(j11, function2, i13));
            if (textStyle != null) {
                startRestartGroup.startReplaceableGroup(1830466317);
                TextKt.ProvideTextStyle(textStyle, composableLambda, startRestartGroup, ((i13 >> 3) & 14) | 48);
            } else {
                startRestartGroup.startReplaceableGroup(1830466369);
                composableLambda.invoke(startRestartGroup, 6);
            }
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        TextStyle textStyle2 = textStyle;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j11, textStyle2, function2, i11, i12));
        }
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

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
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
