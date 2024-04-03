package com.designsystem.ds_list_item_v2.composables;

import androidx.annotation.DrawableRes;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material.IconKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aG\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u001f\u001a5\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"ListItemBackground", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ListItemBottomText", "descriptor", "", "descriptorColor", "", "isEnabled", "", "(Ljava/lang/String;Ljava/lang/Integer;ZLandroidx/compose/runtime/Composer;I)V", "ListItemLeadingIcon", "leadingIcon", "(Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZLandroidx/compose/runtime/Composer;II)V", "ListItemLeadingImage", "leadingImage", "imageCornerRadius", "Landroidx/compose/ui/unit/Dp;", "ListItemLeadingImage-942rkJo", "(Landroidx/compose/ui/Modifier;Ljava/lang/Integer;FZLandroidx/compose/runtime/Composer;II)V", "ListItemLeadingWidget", "ListItemLeadingWidget-hGBTI10", "(Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Ljava/lang/Integer;FZLandroidx/compose/runtime/Composer;II)V", "ListItemTopText", "label", "secondaryLabel", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "calculateTrailingContainerMaxWidth", "containerWidth", "calculateTrailingContainerMaxWidth-Kz89ssw", "(FLjava/lang/Integer;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)F", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt {
    @Composable
    public static final void ListItemBackground(@NotNull Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Modifier modifier2 = modifier;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i15 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer startRestartGroup = composer.startRestartGroup(412407078);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if ((i15 & 112) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            long r72 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU();
            SurfaceKt.m1384SurfaceFjzlyU(SizeKt.fillMaxWidth$default(SizeKt.wrapContentHeight$default(modifier2, (Alignment.Vertical) null, false, 3, (Object) null), 0.0f, 1, (Object) null), (Shape) null, r72, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819892347, true, new CommonListItemComposablesKt$ListItemBackground$1(function22, i12)), startRestartGroup, 1572864, 58);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CommonListItemComposablesKt$ListItemBackground$2(modifier2, function22, i15));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ListItemBottomText(@org.jetbrains.annotations.Nullable java.lang.String r27, @org.jetbrains.annotations.Nullable @androidx.annotation.ColorRes java.lang.Integer r28, boolean r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31) {
        /*
            r2 = r27
            r3 = r28
            r0 = r29
            r13 = r31
            r1 = -1858794174(0xffffffff91350d42, float:-1.4282468E-28)
            r4 = r30
            androidx.compose.runtime.Composer r14 = r4.startRestartGroup(r1)
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0020
            boolean r1 = r14.changed((java.lang.Object) r2)
            if (r1 == 0) goto L_0x001d
            r1 = 4
            goto L_0x001e
        L_0x001d:
            r1 = 2
        L_0x001e:
            r1 = r1 | r13
            goto L_0x0021
        L_0x0020:
            r1 = r13
        L_0x0021:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0031
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002e
            r4 = 32
            goto L_0x0030
        L_0x002e:
            r4 = 16
        L_0x0030:
            r1 = r1 | r4
        L_0x0031:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0041
            boolean r4 = r14.changed((boolean) r0)
            if (r4 == 0) goto L_0x003e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0040
        L_0x003e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0040:
            r1 = r1 | r4
        L_0x0041:
            r12 = r1
            r1 = r12 & 731(0x2db, float:1.024E-42)
            r1 = r1 ^ 146(0x92, float:2.05E-43)
            if (r1 != 0) goto L_0x0053
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x004f
            goto L_0x0053
        L_0x004f:
            r14.skipToGroupEnd()
            goto L_0x005e
        L_0x0053:
            if (r2 != 0) goto L_0x0062
            r1 = -1788040546(0xffffffff956caa9e, float:-4.7794414E-26)
            r14.startReplaceableGroup(r1)
            r14.endReplaceableGroup()
        L_0x005e:
            r26 = r14
            goto L_0x010b
        L_0x0062:
            r1 = -1858794045(0xffffffff91350dc3, float:-1.4282623E-28)
            r14.startReplaceableGroup(r1)
            r4 = 0
            if (r0 != 0) goto L_0x0081
            r1 = 2096359950(0x7cf3ea0e, float:1.01318026E37)
            r14.startReplaceableGroup(r1)
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r1 = r1.getColors(r14, r4)
            long r5 = r1.m8764getDsNeutral350d7_KjU()
            r14.endReplaceableGroup()
        L_0x007e:
            r24 = r5
            goto L_0x00b7
        L_0x0081:
            if (r3 == 0) goto L_0x00a3
            r1 = 2096360035(0x7cf3ea63, float:1.01318565E37)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r1 = r14.consume(r1)
            android.content.Context r1 = (android.content.Context) r1
            int r5 = r28.intValue()
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r5)
            long r5 = androidx.compose.ui.graphics.ColorKt.Color((int) r1)
            r14.endReplaceableGroup()
            goto L_0x007e
        L_0x00a3:
            r1 = 2096360133(0x7cf3eac5, float:1.01319186E37)
            r14.startReplaceableGroup(r1)
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r1 = r1.getColors(r14, r4)
            long r5 = r1.m8771getDsNeutral700d7_KjU()
            r14.endReplaceableGroup()
            goto L_0x007e
        L_0x00b7:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r6 = r5.getDimens(r14, r4)
            float r6 = r6.m8848getDsXxxsD9Ej5fM()
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r1, r6)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r6, r14, r4)
            com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt$ListItemBottomText$1$1 r6 = com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt$ListItemBottomText$1$1.INSTANCE
            r7 = 1
            r8 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r4, r6, r7, r8)
            com.designsystem.ds_theme.DSTypography r4 = r5.getTypography(r14, r4)
            androidx.compose.ui.text.TextStyle r19 = r4.getDsBody1Compact()
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r15 = r4.m5403getEllipsisgIe3tQ8()
            r4 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r16 = 0
            r20 = r12
            r12 = r16
            r16 = 0
            r26 = r14
            r13 = r16
            r16 = 0
            r17 = 2
            r18 = 0
            r21 = r20 & 14
            r22 = 3136(0xc40, float:4.394E-42)
            r23 = 22520(0x57f8, float:3.1557E-41)
            r0 = r27
            r2 = r24
            r20 = r26
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r26.endReplaceableGroup()
        L_0x010b:
            androidx.compose.runtime.ScopeUpdateScope r0 = r26.endRestartGroup()
            if (r0 != 0) goto L_0x0112
            goto L_0x0122
        L_0x0112:
            com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt$ListItemBottomText$2 r1 = new com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt$ListItemBottomText$2
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r31
            r1.<init>(r2, r3, r4, r5)
            r0.updateScope(r1)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt.ListItemBottomText(java.lang.String, java.lang.Integer, boolean, androidx.compose.runtime.Composer, int):void");
    }

    @Composable
    public static final void ListItemLeadingIcon(@Nullable Modifier modifier, @Nullable @DrawableRes Integer num, boolean z11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        long j11;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1876424152);
        int i17 = i12 & 1;
        if (i17 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) num)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                modifier = Modifier.Companion;
            }
            if (num == null) {
                startRestartGroup.startReplaceableGroup(1960397773);
            } else {
                startRestartGroup.startReplaceableGroup(-1876424012);
                Painter painterResource = PainterResources_androidKt.painterResource(num.intValue(), startRestartGroup, 0);
                DSTheme dSTheme = DSTheme.INSTANCE;
                Modifier semantics$default = SemanticsModifierKt.semantics$default(SizeKt.m558size3ABfNKs(modifier, dSTheme.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM()), false, CommonListItemComposablesKt$ListItemLeadingIcon$1$1.INSTANCE, 1, (Object) null);
                if (z11) {
                    startRestartGroup.startReplaceableGroup(-1872572723);
                    j11 = dSTheme.getColors(startRestartGroup, 0).m8760getDsNeutral1000d7_KjU();
                } else {
                    startRestartGroup.startReplaceableGroup(-1872572690);
                    j11 = dSTheme.getColors(startRestartGroup, 0).m8764getDsNeutral350d7_KjU();
                }
                startRestartGroup.endReplaceableGroup();
                IconKt.m1278Iconww6aTOc(painterResource, "", semantics$default, j11, startRestartGroup, 56, 0);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CommonListItemComposablesKt$ListItemLeadingIcon$2(modifier2, num, z11, i11, i12));
        }
    }

    @Composable
    /* renamed from: ListItemLeadingImage-942rkJo  reason: not valid java name */
    public static final void m8487ListItemLeadingImage942rkJo(@Nullable Modifier modifier, @Nullable @DrawableRes Integer num, float f11, boolean z11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        Modifier modifier3;
        float f12;
        int i14;
        int i15;
        int i16;
        int i17;
        Integer num2 = num;
        boolean z12 = z11;
        int i18 = i11;
        Composer startRestartGroup = composer.startRestartGroup(1969117346);
        int i19 = i12 & 1;
        if (i19 != 0) {
            i13 = i18 | 6;
            modifier2 = modifier;
        } else if ((i18 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed((Object) modifier2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i13 = i17 | i18;
        } else {
            modifier2 = modifier;
            i13 = i18;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i18 & 112) == 0) {
            if (startRestartGroup.changed((Object) num2)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i13 |= i16;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
            float f13 = f11;
        } else {
            float f14 = f11;
            if ((i18 & 896) == 0) {
                if (startRestartGroup.changed(f14)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i13 |= i15;
            }
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i13 |= i14;
        }
        if (((i13 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            if (i19 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (num2 == null) {
                startRestartGroup.startReplaceableGroup(913100884);
            } else {
                startRestartGroup.startReplaceableGroup(1969117517);
                Painter painterResource = PainterResources_androidKt.painterResource(num.intValue(), startRestartGroup, 0);
                ContentScale crop = ContentScale.Companion.getCrop();
                DSTheme dSTheme = DSTheme.INSTANCE;
                Modifier semantics$default = SemanticsModifierKt.semantics$default(ClipKt.clip(SizeKt.m558size3ABfNKs(modifier3, dSTheme.getDimens(startRestartGroup, 0).m8845getDsXxlD9Ej5fM()), RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(f11)), false, CommonListItemComposablesKt$ListItemLeadingImage$1$1.INSTANCE, 1, (Object) null);
                if (z12) {
                    f12 = 1.0f;
                } else {
                    f12 = 0.3f;
                }
                ImageKt.Image(painterResource, "", semantics$default, (Alignment) null, crop, f12, (ColorFilter) null, startRestartGroup, 56, 72);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CommonListItemComposablesKt$ListItemLeadingImage$2(modifier3, num, f11, z11, i11, i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: ListItemLeadingWidget-hGBTI10  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8488ListItemLeadingWidgethGBTI10(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r18, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r19, float r20, boolean r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r6 = r18
            r14 = r19
            r15 = r23
            r0 = 341390231(0x14593397, float:1.09658746E-26)
            r1 = r22
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = r24 & 1
            r1 = 2
            if (r0 == 0) goto L_0x001a
            r2 = r15 | 6
            r3 = r2
            r2 = r17
            goto L_0x002e
        L_0x001a:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x002b
            r2 = r17
            boolean r3 = r5.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = r1
        L_0x0029:
            r3 = r3 | r15
            goto L_0x002e
        L_0x002b:
            r2 = r17
            r3 = r15
        L_0x002e:
            r4 = r24 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0045
        L_0x0035:
            r4 = r15 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0045
            boolean r4 = r5.changed((java.lang.Object) r6)
            if (r4 == 0) goto L_0x0042
            r4 = 32
            goto L_0x0044
        L_0x0042:
            r4 = 16
        L_0x0044:
            r3 = r3 | r4
        L_0x0045:
            r4 = r24 & 4
            if (r4 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x004c:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005c
            boolean r4 = r5.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0059
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r3 = r3 | r4
        L_0x005c:
            r4 = r24 & 8
            if (r4 == 0) goto L_0x0063
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0076
        L_0x0063:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0076
            r4 = r20
            boolean r7 = r5.changed((float) r4)
            if (r7 == 0) goto L_0x0072
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0074
        L_0x0072:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0074:
            r3 = r3 | r7
            goto L_0x0078
        L_0x0076:
            r4 = r20
        L_0x0078:
            r7 = r24 & 16
            if (r7 == 0) goto L_0x0081
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r13 = r21
            goto L_0x0095
        L_0x0081:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r15
            r13 = r21
            if (r7 != 0) goto L_0x0095
            boolean r7 = r5.changed((boolean) r13)
            if (r7 == 0) goto L_0x0092
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r3 = r3 | r7
        L_0x0095:
            r7 = 46811(0xb6db, float:6.5596E-41)
            r7 = r7 & r3
            r7 = r7 ^ 9362(0x2492, float:1.3119E-41)
            if (r7 != 0) goto L_0x00ab
            boolean r7 = r5.getSkipping()
            if (r7 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            r5.skipToGroupEnd()
            r1 = r2
            r7 = r5
            goto L_0x0125
        L_0x00ab:
            if (r0 == 0) goto L_0x00b2
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r16 = r0
            goto L_0x00b4
        L_0x00b2:
            r16 = r2
        L_0x00b4:
            java.lang.Integer[] r0 = new java.lang.Integer[r1]
            r1 = 0
            r0[r1] = r6
            r1 = 1
            r0[r1] = r14
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.listOfNotNull((T[]) r0)
            r0.size()
            if (r14 == 0) goto L_0x00eb
            r0 = 341390590(0x145934fe, float:1.0966151E-26)
            r5.startReplaceableGroup(r0)
            r0 = r3 & 14
            int r1 = r3 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r12 = r0 | r1
            r0 = 0
            r7 = r16
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r5
            r13 = r0
            m8487ListItemLeadingImage942rkJo(r7, r8, r9, r10, r11, r12, r13)
            r5.endReplaceableGroup()
            goto L_0x00f4
        L_0x00eb:
            r0 = 341390738(0x14593592, float:1.0966265E-26)
            r5.startReplaceableGroup(r0)
            r5.endReplaceableGroup()
        L_0x00f4:
            if (r6 == 0) goto L_0x0119
            r0 = 341390769(0x145935b1, float:1.0966289E-26)
            r5.startReplaceableGroup(r0)
            r0 = r3 & 14
            r1 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r3 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r7 = r0 | r1
            r8 = 0
            r0 = r16
            r1 = r18
            r2 = r21
            r3 = r5
            r4 = r7
            r7 = r5
            r5 = r8
            ListItemLeadingIcon(r0, r1, r2, r3, r4, r5)
            r7.endReplaceableGroup()
            goto L_0x0123
        L_0x0119:
            r7 = r5
            r0 = 341390884(0x14593624, float:1.09663776E-26)
            r7.startReplaceableGroup(r0)
            r7.endReplaceableGroup()
        L_0x0123:
            r1 = r16
        L_0x0125:
            androidx.compose.runtime.ScopeUpdateScope r8 = r7.endRestartGroup()
            if (r8 != 0) goto L_0x012c
            goto L_0x0141
        L_0x012c:
            com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt$ListItemLeadingWidget$2 r9 = new com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt$ListItemLeadingWidget$2
            r0 = r9
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt.m8488ListItemLeadingWidgethGBTI10(androidx.compose.ui.Modifier, java.lang.Integer, java.lang.Integer, float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: finally extract failed */
    @Composable
    public static final void ListItemTopText(@NotNull String str, @Nullable String str2, boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        long j11;
        long j12;
        AnnotatedString annotatedString;
        int i13;
        int i14;
        int i15;
        String str3 = str;
        String str4 = str2;
        boolean z12 = z11;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(str3, "label");
        Composer startRestartGroup = composer.startRestartGroup(207717032);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) str3)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) str4)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if (((i12 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if (z12) {
                startRestartGroup.startReplaceableGroup(207717179);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8760getDsNeutral1000d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(207717212);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8764getDsNeutral350d7_KjU();
            }
            startRestartGroup.endReplaceableGroup();
            long j13 = j11;
            if (z12) {
                startRestartGroup.startReplaceableGroup(207717284);
                j12 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8771getDsNeutral700d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(207717316);
                j12 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8764getDsNeutral350d7_KjU();
            }
            startRestartGroup.endReplaceableGroup();
            long j14 = j12;
            if (str4 == null) {
                startRestartGroup.startReplaceableGroup(207717382);
                startRestartGroup.endReplaceableGroup();
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                builder.append(str3);
                annotatedString = builder.toAnnotatedString();
            } else {
                startRestartGroup.startReplaceableGroup(207717442);
                AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                builder2.append(str3);
                builder2.append(" ");
                int pushStyle = builder2.pushStyle(TextStyle.m5046copyHL5avdY$default(DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsBody1Compact(), j14, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null).toSpanStyle());
                try {
                    builder2.append(str4);
                    Unit unit = Unit.INSTANCE;
                    builder2.pop(pushStyle);
                    annotatedString = builder2.toAnnotatedString();
                    startRestartGroup.endReplaceableGroup();
                } catch (Throwable th2) {
                    builder2.pop(pushStyle);
                    throw th2;
                }
            }
            AnnotatedString annotatedString2 = annotatedString;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, CommonListItemComposablesKt$ListItemTopText$1.INSTANCE, 1, (Object) null);
            TextStyle dsSubheading2 = DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsSubheading2();
            TextKt.m1460Text4IGK_g(annotatedString2, semantics$default, j13, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 2, (Map<String, InlineTextContent>) null, (Function1<? super TextLayoutResult, Unit>) null, dsSubheading2, startRestartGroup, 0, 3136, 55288);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CommonListItemComposablesKt$ListItemTopText$2(str3, str4, z12, i16));
        }
    }

    @Composable
    /* renamed from: calculateTrailingContainerMaxWidth-Kz89ssw  reason: not valid java name */
    public static final float m8489calculateTrailingContainerMaxWidthKz89ssw(float f11, @Nullable @DrawableRes Integer num, @Nullable @DrawableRes Integer num2, @Nullable Composer composer, int i11, int i12) {
        float f12;
        composer.startReplaceableGroup(-306301660);
        if ((i12 & 2) != 0) {
            num = null;
        }
        if ((i12 & 4) != 0) {
            num2 = null;
        }
        float r12 = Dp.m5478constructorimpl(f11 / ((float) 2));
        if (num != null) {
            composer.startReplaceableGroup(-306301410);
            DSTheme dSTheme = DSTheme.INSTANCE;
            f12 = Dp.m5478constructorimpl(dSTheme.getDimens(composer, 0).m8841getDsMD9Ej5fM() + dSTheme.getDimens(composer, 0).m8846getDsXxsD9Ej5fM());
            composer.endReplaceableGroup();
        } else if (num2 != null) {
            composer.startReplaceableGroup(-306301312);
            DSTheme dSTheme2 = DSTheme.INSTANCE;
            f12 = Dp.m5478constructorimpl(dSTheme2.getDimens(composer, 0).m8845getDsXxlD9Ej5fM() + dSTheme2.getDimens(composer, 0).m8846getDsXxsD9Ej5fM());
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-306301228);
            composer.endReplaceableGroup();
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        float r13 = Dp.m5478constructorimpl(r12 - f12);
        composer.endReplaceableGroup();
        return r13;
    }
}
