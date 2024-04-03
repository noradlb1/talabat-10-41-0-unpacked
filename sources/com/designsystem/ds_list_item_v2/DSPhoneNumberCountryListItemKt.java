package com.designsystem.ds_list_item_v2;

import androidx.annotation.DrawableRes;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0001¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"PhoneNumberCountryFlagTestTag", "", "DSPhoneNumberCountryListItem", "", "label", "prefix", "modifier", "Landroidx/compose/ui/Modifier;", "leadingImage", "", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PhoneNumberCountryFlag", "(Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberCountryListItemKt {
    @NotNull
    public static final String PhoneNumberCountryFlagTestTag = "PhoneNumberCountryFlagTestTag";

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSPhoneNumberCountryListItem(@org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r15 = r23
            r14 = r24
            r13 = r29
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "prefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -849258169(0xffffffffcd615947, float:-2.3629528E8)
            r1 = r28
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r30 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r13 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r12.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r13
            goto L_0x0030
        L_0x002f:
            r0 = r13
        L_0x0030:
            r1 = r30 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x0047
        L_0x0037:
            r1 = r13 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0047
            boolean r1 = r12.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0044
            r1 = 32
            goto L_0x0046
        L_0x0044:
            r1 = 16
        L_0x0046:
            r0 = r0 | r1
        L_0x0047:
            r1 = r30 & 4
            if (r1 == 0) goto L_0x004e
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r2 = r13 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0061
            r2 = r25
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005d
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r0 = r0 | r3
            goto L_0x0063
        L_0x0061:
            r2 = r25
        L_0x0063:
            r3 = r30 & 8
            if (r3 == 0) goto L_0x006a
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007d
            r4 = r26
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0079
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r0 = r0 | r5
            goto L_0x007f
        L_0x007d:
            r4 = r26
        L_0x007f:
            r5 = r30 & 16
            if (r5 == 0) goto L_0x0086
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x009b
            r6 = r27
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0097
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r0 = r0 | r7
            goto L_0x009d
        L_0x009b:
            r6 = r27
        L_0x009d:
            r7 = 46811(0xb6db, float:6.5596E-41)
            r7 = r7 & r0
            r7 = r7 ^ 9362(0x2492, float:1.3119E-41)
            if (r7 != 0) goto L_0x00b5
            boolean r7 = r12.getSkipping()
            if (r7 != 0) goto L_0x00ac
            goto L_0x00b5
        L_0x00ac:
            r12.skipToGroupEnd()
            r3 = r2
            r5 = r6
            r18 = r12
            goto L_0x0120
        L_0x00b5:
            if (r1 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r16 = r1
            goto L_0x00be
        L_0x00bc:
            r16 = r2
        L_0x00be:
            r1 = 0
            if (r3 == 0) goto L_0x00c3
            r11 = r1
            goto L_0x00c4
        L_0x00c3:
            r11 = r4
        L_0x00c4:
            if (r5 == 0) goto L_0x00c9
            r17 = r1
            goto L_0x00cb
        L_0x00c9:
            r17 = r6
        L_0x00cb:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$1 r1 = new com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$1
            r1.<init>(r11, r0)
            r5 = -819895342(0xffffffffcf2163d2, float:-2.7076736E9)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r5, r7, r1)
            com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$2 r1 = new com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$2
            r1.<init>(r14, r0)
            r5 = -819896079(0xffffffffcf2160f1, float:-2.70748493E9)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r5, r7, r1)
            r18 = 0
            r1 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r0 & 14
            r1 = r1 | r5
            int r5 = r0 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r1 = r1 | r5
            r5 = 458752(0x70000, float:6.42848E-40)
            int r7 = r0 << 3
            r5 = r5 & r7
            r1 = r1 | r5
            int r0 = r0 << 12
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r5
            r19 = r1 | r0
            r20 = 6
            r21 = 2396(0x95c, float:3.358E-42)
            r0 = r23
            r1 = r16
            r5 = r17
            r7 = r11
            r22 = r11
            r11 = r18
            r18 = r12
            r13 = r19
            r14 = r20
            r15 = r21
            com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt.m8490ListItemwn8IZOc(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r3 = r16
            r4 = r22
        L_0x0120:
            androidx.compose.runtime.ScopeUpdateScope r8 = r18.endRestartGroup()
            if (r8 != 0) goto L_0x0127
            goto L_0x0138
        L_0x0127:
            com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$3 r9 = new com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$3
            r0 = r9
            r1 = r23
            r2 = r24
            r6 = r29
            r7 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.DSPhoneNumberCountryListItemKt.DSPhoneNumberCountryListItem(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void PhoneNumberCountryFlag(Modifier modifier, @DrawableRes Integer num, Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        Modifier.Companion companion;
        Modifier modifier3;
        int i14;
        int i15;
        Integer num2 = num;
        int i16 = i11;
        int i17 = i12;
        Composer startRestartGroup = composer.startRestartGroup(1781151762);
        int i18 = i17 & 1;
        if (i18 != 0) {
            i13 = i16 | 6;
            modifier2 = modifier;
        } else if ((i16 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed((Object) modifier2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i16;
        } else {
            modifier2 = modifier;
            i13 = i16;
        }
        if ((i17 & 2) != 0) {
            i13 |= 48;
        } else if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) num2)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                companion = Modifier.Companion;
            } else {
                companion = modifier2;
            }
            if (num2 == null) {
                startRestartGroup.startReplaceableGroup(-618866443);
                startRestartGroup.endReplaceableGroup();
                modifier3 = companion;
            } else {
                startRestartGroup.startReplaceableGroup(1781151884);
                Painter painterResource = PainterResources_androidKt.painterResource(num.intValue(), startRestartGroup, 0);
                ContentScale crop = ContentScale.Companion.getCrop();
                DSTheme dSTheme = DSTheme.INSTANCE;
                modifier3 = companion;
                ImageKt.Image(painterResource, "", SemanticsModifierKt.semantics$default(ClipKt.clip(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM()), RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(dSTheme.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM())), false, DSPhoneNumberCountryListItemKt$PhoneNumberCountryFlag$1$1.INSTANCE, 1, (Object) null), (Alignment) null, crop, 0.0f, (ColorFilter) null, startRestartGroup, 56, 104);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSPhoneNumberCountryListItemKt$PhoneNumberCountryFlag$2(modifier2, num2, i16, i17));
        }
    }
}
