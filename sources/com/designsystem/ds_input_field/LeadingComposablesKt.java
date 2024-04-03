package com.designsystem.ds_input_field;

import androidx.annotation.DrawableRes;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u00012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\t\u001a!\u0010\n\u001a\u00020\u00012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\t\u001a3\u0010\f\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"CountryFlagImage", "", "countryImage", "", "isEnabled", "", "(IZLandroidx/compose/runtime/Composer;I)V", "InputFieldLeadingIcon", "leadingIcon", "(Ljava/lang/Integer;ZLandroidx/compose/runtime/Composer;II)V", "InputFieldLeadingImage", "leadingImage", "PhoneInputLeadingComposable", "onCountrySelectionTap", "Lkotlin/Function0;", "(Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "getIconTint", "Landroidx/compose/ui/graphics/Color;", "(ZLandroidx/compose/runtime/Composer;I)J", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LeadingComposablesKt {
    @Composable
    public static final void CountryFlagImage(@DrawableRes int i11, boolean z11, @Nullable Composer composer, int i12) {
        int i13;
        float f11;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1392242334);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            Painter painterResource = PainterResources_androidKt.painterResource(i11, startRestartGroup, i13 & 14);
            ContentScale crop = ContentScale.Companion.getCrop();
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(ClipKt.clip(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM())), false, LeadingComposablesKt$CountryFlagImage$1.INSTANCE, 1, (Object) null);
            if (z11) {
                f11 = 1.0f;
            } else {
                f11 = 0.3f;
            }
            ImageKt.Image(painterResource, "", semantics$default, (Alignment) null, crop, f11, (ColorFilter) null, startRestartGroup, 56, 72);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LeadingComposablesKt$CountryFlagImage$2(i11, z11, i12));
        }
    }

    @Composable
    public static final void InputFieldLeadingIcon(@Nullable @DrawableRes Integer num, boolean z11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Integer num2;
        Integer num3;
        int i14;
        int i15;
        boolean z12 = z11;
        int i16 = i11;
        int i17 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-1122696354);
        int i18 = i17 & 1;
        if (i18 != 0) {
            i13 = i16 | 6;
            num2 = num;
        } else if ((i16 & 14) == 0) {
            num2 = num;
            if (startRestartGroup.changed((Object) num2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i16;
        } else {
            num2 = num;
            i13 = i16;
        }
        if ((i17 & 2) != 0) {
            i13 |= 48;
        } else if ((i16 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                num3 = null;
            } else {
                num3 = num2;
            }
            if (num3 == null) {
                startRestartGroup.startReplaceableGroup(-443845040);
            } else {
                startRestartGroup.startReplaceableGroup(-1122696239);
                num3.intValue();
                Painter painterResource = PainterResources_androidKt.painterResource(num3.intValue(), startRestartGroup, i13 & 14);
                long iconTint = getIconTint(z12, startRestartGroup, (i13 >> 3) & 14);
                Modifier.Companion companion = Modifier.Companion;
                DSTheme dSTheme = DSTheme.INSTANCE;
                IconKt.m1278Iconww6aTOc(painterResource, "", TestTagKt.testTag(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), InputFieldLeadingComposables.InputFieldLeadingIconTestTag), iconTint, startRestartGroup, 56, 0);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM()), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            num3 = num2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LeadingComposablesKt$InputFieldLeadingIcon$2(num3, z12, i16, i17));
        }
    }

    @Composable
    public static final void InputFieldLeadingImage(@Nullable @DrawableRes Integer num, boolean z11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Integer num2;
        Integer num3;
        Integer num4;
        float f11;
        int i14;
        int i15;
        boolean z12 = z11;
        int i16 = i11;
        int i17 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-435074096);
        int i18 = i17 & 1;
        if (i18 != 0) {
            i13 = i16 | 6;
            num2 = num;
        } else if ((i16 & 14) == 0) {
            num2 = num;
            if (startRestartGroup.changed((Object) num2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i16;
        } else {
            num2 = num;
            i13 = i16;
        }
        if ((i17 & 2) != 0) {
            i13 |= 48;
        } else if ((i16 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                num3 = null;
            } else {
                num3 = num2;
            }
            if (num3 == null) {
                startRestartGroup.startReplaceableGroup(-602391429);
                startRestartGroup.endReplaceableGroup();
                num4 = num3;
            } else {
                startRestartGroup.startReplaceableGroup(-435073978);
                num3.intValue();
                Painter painterResource = PainterResources_androidKt.painterResource(num3.intValue(), startRestartGroup, i13 & 14);
                if (z12) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.3f;
                }
                Modifier.Companion companion = Modifier.Companion;
                DSTheme dSTheme = DSTheme.INSTANCE;
                num4 = num3;
                ImageKt.Image(painterResource, "", TestTagKt.testTag(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), InputFieldLeadingComposables.InputFieldLeadingImageTestTag), (Alignment) null, (ContentScale) null, f11, (ColorFilter) null, startRestartGroup, 56, 88);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM()), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            num2 = num4;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LeadingComposablesKt$InputFieldLeadingImage$2(num2, z12, i16, i17));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PhoneInputLeadingComposable(@org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r24, boolean r25, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r9 = r25
            r10 = r28
            r0 = -751504666(0xffffffffd334f2e6, float:-7.7716927E11)
            r1 = r27
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r29 & 1
            if (r0 == 0) goto L_0x0017
            r1 = r10 | 6
            r2 = r1
            r1 = r24
            goto L_0x002b
        L_0x0017:
            r1 = r10 & 14
            if (r1 != 0) goto L_0x0028
            r1 = r24
            boolean r2 = r15.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r10
            goto L_0x002b
        L_0x0028:
            r1 = r24
            r2 = r10
        L_0x002b:
            r3 = r29 & 2
            if (r3 == 0) goto L_0x0032
            r2 = r2 | 48
            goto L_0x0042
        L_0x0032:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0042
            boolean r3 = r15.changed((boolean) r9)
            if (r3 == 0) goto L_0x003f
            r3 = 32
            goto L_0x0041
        L_0x003f:
            r3 = 16
        L_0x0041:
            r2 = r2 | r3
        L_0x0042:
            r3 = r29 & 4
            if (r3 == 0) goto L_0x0049
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r4 = r10 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005c
            r4 = r26
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0058
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r2 = r2 | r5
            goto L_0x005e
        L_0x005c:
            r4 = r26
        L_0x005e:
            r11 = r2
            r2 = r11 & 731(0x2db, float:1.024E-42)
            r2 = r2 ^ 146(0x92, float:2.05E-43)
            if (r2 != 0) goto L_0x0075
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x006c
            goto L_0x0075
        L_0x006c:
            r15.skipToGroupEnd()
            r23 = r1
            r3 = r4
            r1 = r15
            goto L_0x0203
        L_0x0075:
            r2 = 0
            if (r0 == 0) goto L_0x007b
            r23 = r2
            goto L_0x007d
        L_0x007b:
            r23 = r1
        L_0x007d:
            if (r3 == 0) goto L_0x0081
            r13 = r2
            goto L_0x0082
        L_0x0081:
            r13 = r4
        L_0x0082:
            if (r23 != 0) goto L_0x0087
            int r0 = com.designsystem.marshmallow.R.drawable.ds_country
            goto L_0x008b
        L_0x0087:
            int r0 = r23.intValue()
        L_0x008b:
            r12 = r0
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r14 = r0.getCenterVertically()
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r15.startReplaceableGroup(r0)
            boolean r0 = r15.changed((java.lang.Object) r13)
            java.lang.Object r3 = r15.rememberedValue()
            if (r0 != 0) goto L_0x00b3
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x00bb
        L_0x00b3:
            com.designsystem.ds_input_field.LeadingComposablesKt$PhoneInputLeadingComposable$1$1 r3 = new com.designsystem.ds_input_field.LeadingComposablesKt$PhoneInputLeadingComposable$1$1
            r3.<init>(r13)
            r15.updateRememberedValue(r3)
        L_0x00bb:
            r15.endReplaceableGroup()
            r6 = r3
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r7 = 24
            r16 = 0
            r0 = r8
            r3 = r25
            r10 = r8
            r8 = r16
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r15.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = r1.getStart()
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r14, r15, r8)
            r2 = 1376089335(0x520574f7, float:1.43298249E11)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r15.consume(r2)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r3 = r15.consume(r3)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r4.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r6 = r15.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x010f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x010f:
            r15.startReusableNode()
            boolean r6 = r15.getInserting()
            if (r6 == 0) goto L_0x011c
            r15.createNode(r5)
            goto L_0x011f
        L_0x011c:
            r15.useNode()
        L_0x011f:
            r15.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r15)
            kotlin.jvm.functions.Function2 r6 = r4.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            kotlin.jvm.functions.Function2 r1 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            kotlin.jvm.functions.Function2 r1 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            r15.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r0.invoke(r1, r15, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r0)
            r0 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r15.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r0 = r11 & 112(0x70, float:1.57E-43)
            CountryFlagImage(r12, r9, r15, r0)
            com.designsystem.ds_theme.DSTheme r0 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r1 = r0.getDimens(r15, r8)
            float r1 = r1.m8848getDsXxxsD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r10, r1)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r15, r8)
            int r1 = com.designsystem.marshmallow.R.drawable.ds_chevron_down
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r15, r8)
            int r2 = r11 >> 3
            r2 = r2 & 14
            long r4 = getIconTint(r9, r15, r2)
            com.designsystem.ds_theme.DSDimens r2 = r0.getDimens(r15, r8)
            float r2 = r2.m8840getDsLD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r10, r2)
            java.lang.String r3 = "PhoneInputChevronIconTestTag"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.platform.TestTagKt.testTag(r2, r3)
            java.lang.String r2 = ""
            r7 = 56
            r11 = 0
            r6 = r15
            r14 = r8
            r8 = r11
            androidx.compose.material.IconKt.m1278Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (long) r4, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            com.designsystem.ds_theme.DSDimens r1 = r0.getDimens(r15, r14)
            float r1 = r1.m8846getDsXxsD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r10, r1)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r15, r14)
            com.designsystem.ds_theme.DSColors r1 = r0.getColors(r15, r14)
            long r1 = r1.m8759getDsNeutral100d7_KjU()
            com.designsystem.ds_input_field.InputFieldLeadingComposables r3 = com.designsystem.ds_input_field.InputFieldLeadingComposables.INSTANCE
            float r3 = r3.m8440getPhoneInputDividerWidthD9Ej5fM()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r10, r3)
            com.designsystem.ds_theme.DSDimens r4 = r0.getDimens(r15, r14)
            float r4 = r4.m8845getDsXxlD9Ej5fM()
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r3, r4)
            r12 = 0
            r3 = 0
            r17 = 0
            r18 = 0
            com.designsystem.ds_input_field.ComposableSingletons$LeadingComposablesKt r5 = com.designsystem.ds_input_field.ComposableSingletons$LeadingComposablesKt.INSTANCE
            kotlin.jvm.functions.Function2 r19 = r5.m8368getLambda1$marshmallow_release()
            r21 = 0
            r22 = 58
            r5 = r13
            r6 = r14
            r13 = r1
            r1 = r15
            r15 = r3
            r20 = r1
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22)
            com.designsystem.ds_theme.DSDimens r0 = r0.getDimens(r1, r6)
            float r0 = r0.m8844getDsXsD9Ej5fM()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r10, r0)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r6)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r3 = r5
        L_0x0203:
            androidx.compose.runtime.ScopeUpdateScope r6 = r1.endRestartGroup()
            if (r6 != 0) goto L_0x020a
            goto L_0x021b
        L_0x020a:
            com.designsystem.ds_input_field.LeadingComposablesKt$PhoneInputLeadingComposable$3 r7 = new com.designsystem.ds_input_field.LeadingComposablesKt$PhoneInputLeadingComposable$3
            r0 = r7
            r1 = r23
            r2 = r25
            r4 = r28
            r5 = r29
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x021b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.LeadingComposablesKt.PhoneInputLeadingComposable(java.lang.Integer, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    private static final long getIconTint(boolean z11, Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(2021886880);
        if (z11) {
            composer.startReplaceableGroup(2021886951);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8760getDsNeutral1000d7_KjU();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(2021887000);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8764getDsNeutral350d7_KjU();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return j11;
    }
}
