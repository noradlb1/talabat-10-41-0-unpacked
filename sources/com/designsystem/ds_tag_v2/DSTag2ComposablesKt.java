package com.designsystem.ds_tag_v2;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001aA\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u001c*\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010 \u001a\u00020!*\u00020\nH\u0003¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Tag2IconTestTag", "", "Tag2LabelTestTag", "DSTag2Background", "", "modifier", "Landroidx/compose/ui/Modifier;", "priority", "Lcom/designsystem/ds_tag_v2/DSTagPriority;", "size", "Lcom/designsystem/ds_tag_v2/DSTagSize;", "color", "Lcom/designsystem/ds_tag_v2/DSTagColor;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lcom/designsystem/ds_tag_v2/DSTagPriority;Lcom/designsystem/ds_tag_v2/DSTagSize;Lcom/designsystem/ds_tag_v2/DSTagColor;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DSTag2Surface", "label", "icon", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/designsystem/ds_tag_v2/DSTagPriority;Lcom/designsystem/ds_tag_v2/DSTagSize;Lcom/designsystem/ds_tag_v2/DSTagColor;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "getBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "(Lcom/designsystem/ds_tag_v2/DSTagColor;Lcom/designsystem/ds_tag_v2/DSTagPriority;Landroidx/compose/runtime/Composer;I)J", "getPaddingHorizontal", "Landroidx/compose/ui/unit/Dp;", "(Lcom/designsystem/ds_tag_v2/DSTagSize;Landroidx/compose/runtime/Composer;I)F", "getPaddingVertical", "getTextOrIconColor", "getTextStyle", "Landroidx/compose/ui/text/TextStyle;", "(Lcom/designsystem/ds_tag_v2/DSTagSize;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTag2ComposablesKt {
    @NotNull
    public static final String Tag2IconTestTag = "Tag2IconTestTag";
    @NotNull
    public static final String Tag2LabelTestTag = "Tag2LabelTestTag";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DSTagSize.values().length];
            iArr[DSTagSize.Medium.ordinal()] = 1;
            iArr[DSTagSize.Small.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DSTagColor.values().length];
            iArr2[DSTagColor.Pink.ordinal()] = 1;
            iArr2[DSTagColor.Blue.ordinal()] = 2;
            iArr2[DSTagColor.Orange.ordinal()] = 3;
            iArr2[DSTagColor.Yellow.ordinal()] = 4;
            iArr2[DSTagColor.Red.ordinal()] = 5;
            iArr2[DSTagColor.Green.ordinal()] = 6;
            iArr2[DSTagColor.Grey.ordinal()] = 7;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void DSTag2Background(Modifier modifier, DSTagPriority dSTagPriority, DSTagSize dSTagSize, DSTagColor dSTagColor, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        DSTagPriority dSTagPriority2 = dSTagPriority;
        DSTagSize dSTagSize2 = dSTagSize;
        DSTagColor dSTagColor2 = dSTagColor;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i18 = i11;
        Composer startRestartGroup = composer.startRestartGroup(2138160067);
        if ((i18 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i12 = i17 | i18;
        } else {
            Modifier modifier2 = modifier;
            i12 = i18;
        }
        if ((i18 & 112) == 0) {
            if (startRestartGroup.changed((Object) dSTagPriority2)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        }
        if ((i18 & 896) == 0) {
            if (startRestartGroup.changed((Object) dSTagSize2)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        }
        if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed((Object) dSTagColor2)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        }
        if ((57344 & i18) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i13 = 16384;
            } else {
                i13 = 8192;
            }
            i12 |= i13;
        }
        if (((46811 & i12) ^ 9362) != 0 || !startRestartGroup.getSkipping()) {
            long backgroundColor = getBackgroundColor(dSTagColor2, dSTagPriority2, startRestartGroup, ((i12 >> 9) & 14) | (i12 & 112));
            int i19 = (i12 & 14) | 1572864;
            SurfaceKt.m1384SurfaceFjzlyU(modifier, RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8848getDsXxxsD9Ej5fM()), backgroundColor, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819892639, true, new DSTag2ComposablesKt$DSTag2Background$1(dSTagSize2, i12, function32)), startRestartGroup, i19, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSTag2ComposablesKt$DSTag2Background$2(modifier, dSTagPriority, dSTagSize, dSTagColor, function3, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSTag2Surface(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull com.designsystem.ds_tag_v2.DSTagPriority r18, @org.jetbrains.annotations.NotNull com.designsystem.ds_tag_v2.DSTagSize r19, @org.jetbrains.annotations.NotNull com.designsystem.ds_tag_v2.DSTagColor r20, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r23
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "priority"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "size"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "color"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 544355773(0x207235bd, float:2.0515978E-19)
            r1 = r22
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r24 & 1
            if (r0 == 0) goto L_0x0035
            r0 = r12 | 6
            goto L_0x0045
        L_0x0035:
            r0 = r12 & 14
            if (r0 != 0) goto L_0x0044
            boolean r0 = r13.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0041
            r0 = 4
            goto L_0x0042
        L_0x0041:
            r0 = 2
        L_0x0042:
            r0 = r0 | r12
            goto L_0x0045
        L_0x0044:
            r0 = r12
        L_0x0045:
            r1 = r24 & 2
            if (r1 == 0) goto L_0x004c
            r0 = r0 | 48
            goto L_0x005c
        L_0x004c:
            r1 = r12 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x005c
            boolean r1 = r13.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0059
            r1 = 32
            goto L_0x005b
        L_0x0059:
            r1 = 16
        L_0x005b:
            r0 = r0 | r1
        L_0x005c:
            r1 = r24 & 4
            if (r1 == 0) goto L_0x0063
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0073
        L_0x0063:
            r1 = r12 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0073
            boolean r1 = r13.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x0070
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r0 = r0 | r1
        L_0x0073:
            r1 = r24 & 8
            if (r1 == 0) goto L_0x007a
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x007a:
            r1 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x008a
            boolean r1 = r13.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0087
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r1
        L_0x008a:
            r1 = r24 & 16
            if (r1 == 0) goto L_0x0091
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x0091:
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r12
            if (r1 != 0) goto L_0x00a3
            boolean r1 = r13.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x00a0
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r0 = r0 | r1
        L_0x00a3:
            r1 = r24 & 32
            if (r1 == 0) goto L_0x00ab
            r2 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r2
            goto L_0x00bf
        L_0x00ab:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r12
            if (r2 != 0) goto L_0x00bf
            r2 = r21
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00bb
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r0 = r0 | r3
            goto L_0x00c1
        L_0x00bf:
            r2 = r21
        L_0x00c1:
            r14 = r0
            r0 = 374491(0x5b6db, float:5.24774E-40)
            r0 = r0 & r14
            r3 = 74898(0x12492, float:1.04954E-40)
            r0 = r0 ^ r3
            if (r0 != 0) goto L_0x00d8
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00d8
        L_0x00d3:
            r13.skipToGroupEnd()
            r6 = r2
            goto L_0x0118
        L_0x00d8:
            if (r1 == 0) goto L_0x00dd
            r0 = 0
            r15 = r0
            goto L_0x00de
        L_0x00dd:
            r15 = r2
        L_0x00de:
            if (r15 == 0) goto L_0x00e2
            com.designsystem.ds_tag_v2.DSTagSize r0 = com.designsystem.ds_tag_v2.DSTagSize.Small
        L_0x00e2:
            com.designsystem.ds_tag_v2.DSTag2ComposablesKt$DSTag2Surface$2 r6 = new com.designsystem.ds_tag_v2.DSTag2ComposablesKt$DSTag2Surface$2
            r0 = r6
            r1 = r15
            r2 = r19
            r3 = r14
            r4 = r20
            r5 = r18
            r7 = r6
            r6 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = -819895725(0xffffffffcf216253, float:-2.70757555E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r7)
            r0 = r14 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            int r1 = r14 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r0 | r1
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r13
            DSTag2Background(r0, r1, r2, r3, r4, r5, r6)
            r6 = r15
        L_0x0118:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x011f
            goto L_0x0136
        L_0x011f:
            com.designsystem.ds_tag_v2.DSTag2ComposablesKt$DSTag2Surface$3 r14 = new com.designsystem.ds_tag_v2.DSTag2ComposablesKt$DSTag2Surface$3
            r0 = r14
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r13.updateScope(r14)
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_tag_v2.DSTag2ComposablesKt.DSTag2Surface(androidx.compose.ui.Modifier, java.lang.String, com.designsystem.ds_tag_v2.DSTagPriority, com.designsystem.ds_tag_v2.DSTagSize, com.designsystem.ds_tag_v2.DSTagColor, java.lang.Integer, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    private static final long getBackgroundColor(DSTagColor dSTagColor, DSTagPriority dSTagPriority, Composer composer, int i11) {
        TagColor tagColor;
        composer.startReplaceableGroup(202077922);
        switch (WhenMappings.$EnumSwitchMapping$1[dSTagColor.ordinal()]) {
            case 1:
                composer.startReplaceableGroup(202078042);
                DSTheme dSTheme = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme.getColors(composer, 0).m8785getDsPink200d7_KjU(), dSTheme.getColors(composer, 0).m8788getDsPink500d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 2:
                composer.startReplaceableGroup(202078128);
                DSTheme dSTheme2 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme2.getColors(composer, 0).m8740getDsBlue200d7_KjU(), dSTheme2.getColors(composer, 0).m8745getDsBlue700d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 3:
                composer.startReplaceableGroup(202078216);
                DSTheme dSTheme3 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme3.getColors(composer, 0).m8776getDsOrange200d7_KjU(), dSTheme3.getColors(composer, 0).m8780getDsOrange600d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 4:
                composer.startReplaceableGroup(202078308);
                DSTheme dSTheme4 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme4.getColors(composer, 0).m8821getDsYellow200d7_KjU(), dSTheme4.getColors(composer, 0).m8824getDsYellow500d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 5:
                composer.startReplaceableGroup(202078397);
                DSTheme dSTheme5 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme5.getColors(composer, 0).m8802getDsRed200d7_KjU(), dSTheme5.getColors(composer, 0).m8805getDsRed500d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 6:
                composer.startReplaceableGroup(202078482);
                DSTheme dSTheme6 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme6.getColors(composer, 0).m8752getDsGreen200d7_KjU(), dSTheme6.getColors(composer, 0).m8755getDsGreen500d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 7:
                composer.startReplaceableGroup(202078570);
                DSTheme dSTheme7 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme7.getColors(composer, 0).m8762getDsNeutral200d7_KjU(), dSTheme7.getColors(composer, 0).m8770getDsNeutral600d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            default:
                composer.startReplaceableGroup(202074767);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
        }
        long r62 = tagColor.m8634getColorvNxB06k(dSTagPriority);
        composer.endReplaceableGroup();
        return r62;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final float getPaddingHorizontal(DSTagSize dSTagSize, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(-910044227);
        int i12 = WhenMappings.$EnumSwitchMapping$0[dSTagSize.ordinal()];
        if (i12 == 1) {
            composer.startReplaceableGroup(-910044116);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8846getDsXxsD9Ej5fM();
            composer.endReplaceableGroup();
        } else if (i12 == 2) {
            composer.startReplaceableGroup(-910044068);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8848getDsXxxsD9Ej5fM();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-910046961);
            composer.endReplaceableGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        return f11;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final float getPaddingVertical(DSTagSize dSTagSize, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(1954217705);
        int i12 = WhenMappings.$EnumSwitchMapping$0[dSTagSize.ordinal()];
        if (i12 == 1) {
            composer.startReplaceableGroup(1954217814);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8848getDsXxxsD9Ej5fM();
            composer.endReplaceableGroup();
        } else if (i12 == 2) {
            composer.startReplaceableGroup(1954217863);
            f11 = DSTheme.INSTANCE.getDimens(composer, 0).m8849getDsZeroD9Ej5fM();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1954215165);
            composer.endReplaceableGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        return f11;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final long getTextOrIconColor(DSTagColor dSTagColor, DSTagPriority dSTagPriority, Composer composer, int i11) {
        TagColor tagColor;
        composer.startReplaceableGroup(1242096886);
        switch (WhenMappings.$EnumSwitchMapping$1[dSTagColor.ordinal()]) {
            case 1:
                composer.startReplaceableGroup(1242097006);
                DSTheme dSTheme = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme.getColors(composer, 0).m8790getDsPink700d7_KjU(), dSTheme.getColors(composer, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 2:
                composer.startReplaceableGroup(1242097091);
                DSTheme dSTheme2 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme2.getColors(composer, 0).m8745getDsBlue700d7_KjU(), dSTheme2.getColors(composer, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 3:
                composer.startReplaceableGroup(1242097178);
                DSTheme dSTheme3 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme3.getColors(composer, 0).m8782getDsOrange800d7_KjU(), dSTheme3.getColors(composer, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 4:
                composer.startReplaceableGroup(1242097267);
                DSTheme dSTheme4 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme4.getColors(composer, 0).m8772getDsNeutral70V20d7_KjU(), dSTheme4.getColors(composer, 0).m8773getDsNeutral800d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 5:
                composer.startReplaceableGroup(1242097360);
                DSTheme dSTheme5 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme5.getColors(composer, 0).m8807getDsRed700d7_KjU(), dSTheme5.getColors(composer, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 6:
                composer.startReplaceableGroup(1242097445);
                DSTheme dSTheme6 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme6.getColors(composer, 0).m8757getDsGreen700d7_KjU(), dSTheme6.getColors(composer, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            case 7:
                composer.startReplaceableGroup(1242097531);
                DSTheme dSTheme7 = DSTheme.INSTANCE;
                tagColor = new TagColor(dSTheme7.getColors(composer, 0).m8773getDsNeutral800d7_KjU(), dSTheme7.getColors(composer, 0).m8819getDsWhite0d7_KjU(), (DefaultConstructorMarker) null);
                composer.endReplaceableGroup();
                break;
            default:
                composer.startReplaceableGroup(1242092970);
                composer.endReplaceableGroup();
                throw new NoWhenBranchMatchedException();
        }
        long r62 = tagColor.m8634getColorvNxB06k(dSTagPriority);
        composer.endReplaceableGroup();
        return r62;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final TextStyle getTextStyle(DSTagSize dSTagSize, Composer composer, int i11) {
        TextStyle textStyle;
        composer.startReplaceableGroup(1689435633);
        int i12 = WhenMappings.$EnumSwitchMapping$0[dSTagSize.ordinal()];
        if (i12 == 1) {
            composer.startReplaceableGroup(1689435747);
            textStyle = DSTheme.INSTANCE.getTypography(composer, 0).getDsSubheadingSmall();
            composer.endReplaceableGroup();
        } else if (i12 == 2) {
            composer.startReplaceableGroup(1689435811);
            textStyle = DSTheme.INSTANCE.getTypography(composer, 0).getDsSubheadingXSmall();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1689432704);
            composer.endReplaceableGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.endReplaceableGroup();
        return textStyle;
    }
}
