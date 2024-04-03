package com.designsystem.ds_list_item_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"DSMenuListItem", "", "title", "", "value", "", "modifier", "Landroidx/compose/ui/Modifier;", "description", "onChanged", "Lkotlin/Function1;", "(Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "MenuItemDescription", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSMenuListItemKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSMenuListItem(@org.jetbrains.annotations.NotNull java.lang.String r15, boolean r16, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, @org.jetbrains.annotations.Nullable java.lang.String r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r7 = r15
            r8 = r19
            r9 = r21
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 310734096(0x12856d10, float:8.420366E-28)
            r1 = r20
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r22 & 1
            if (r0 == 0) goto L_0x001f
            r0 = r9 | 6
            goto L_0x002f
        L_0x001f:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x002e
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002b
            r0 = 4
            goto L_0x002c
        L_0x002b:
            r0 = 2
        L_0x002c:
            r0 = r0 | r9
            goto L_0x002f
        L_0x002e:
            r0 = r9
        L_0x002f:
            r1 = r22 & 2
            if (r1 == 0) goto L_0x0038
            r0 = r0 | 48
            r11 = r16
            goto L_0x004a
        L_0x0038:
            r1 = r9 & 112(0x70, float:1.57E-43)
            r11 = r16
            if (r1 != 0) goto L_0x004a
            boolean r1 = r10.changed((boolean) r11)
            if (r1 == 0) goto L_0x0047
            r1 = 32
            goto L_0x0049
        L_0x0047:
            r1 = 16
        L_0x0049:
            r0 = r0 | r1
        L_0x004a:
            r1 = r22 & 4
            if (r1 == 0) goto L_0x0051
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0064
            r2 = r17
            boolean r3 = r10.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0060
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r0 = r0 | r3
            goto L_0x0066
        L_0x0064:
            r2 = r17
        L_0x0066:
            r3 = r22 & 8
            if (r3 == 0) goto L_0x006d
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0080
            r4 = r18
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x007c
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r0 = r0 | r5
            goto L_0x0082
        L_0x0080:
            r4 = r18
        L_0x0082:
            r5 = r22 & 16
            if (r5 == 0) goto L_0x0089
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0089:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r9
            if (r5 != 0) goto L_0x009b
            boolean r5 = r10.changed((java.lang.Object) r8)
            if (r5 == 0) goto L_0x0098
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r0 = r0 | r5
        L_0x009b:
            r5 = r0
            r0 = 46811(0xb6db, float:6.5596E-41)
            r0 = r0 & r5
            r0 = r0 ^ 9362(0x2492, float:1.3119E-41)
            if (r0 != 0) goto L_0x00b0
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00ab
            goto L_0x00b0
        L_0x00ab:
            r10.skipToGroupEnd()
            r3 = r2
            goto L_0x00d8
        L_0x00b0:
            if (r1 == 0) goto L_0x00b6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r12 = r0
            goto L_0x00b7
        L_0x00b6:
            r12 = r2
        L_0x00b7:
            if (r3 == 0) goto L_0x00bc
            r0 = 0
            r13 = r0
            goto L_0x00bd
        L_0x00bc:
            r13 = r4
        L_0x00bd:
            com.designsystem.ds_list_item_v2.DSMenuListItemKt$DSMenuListItem$1 r14 = new com.designsystem.ds_list_item_v2.DSMenuListItemKt$DSMenuListItem$1
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r19
            r4 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = -819895096(0xffffffffcf2164c8, float:-2.70773658E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r0, r1, r14)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r10, r1)
            r3 = r12
            r4 = r13
        L_0x00d8:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x00df
            goto L_0x00f1
        L_0x00df:
            com.designsystem.ds_list_item_v2.DSMenuListItemKt$DSMenuListItem$2 r12 = new com.designsystem.ds_list_item_v2.DSMenuListItemKt$DSMenuListItem$2
            r0 = r12
            r1 = r15
            r2 = r16
            r5 = r19
            r6 = r21
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r10.updateScope(r12)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.DSMenuListItemKt.DSMenuListItem(java.lang.String, boolean, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MenuItemDescription(@org.jetbrains.annotations.Nullable java.lang.String r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27) {
        /*
            r0 = r25
            r13 = r27
            r1 = 979606036(0x3a639a14, float:8.682322E-4)
            r2 = r26
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r1)
            r1 = r13 & 14
            r2 = 2
            if (r1 != 0) goto L_0x001d
            boolean r1 = r14.changed((java.lang.Object) r0)
            if (r1 == 0) goto L_0x001a
            r1 = 4
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            r1 = r1 | r13
            goto L_0x001e
        L_0x001d:
            r1 = r13
        L_0x001e:
            r1 = r1 & 11
            r1 = r1 ^ r2
            if (r1 != 0) goto L_0x002e
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            r14.skipToGroupEnd()
            goto L_0x0039
        L_0x002e:
            if (r0 != 0) goto L_0x003c
            r1 = 303018246(0x120fb106, float:4.534104E-28)
            r14.startReplaceableGroup(r1)
            r14.endReplaceableGroup()
        L_0x0039:
            r24 = r14
            goto L_0x0081
        L_0x003c:
            r1 = 979606107(0x3a639a5b, float:8.6823636E-4)
            r14.startReplaceableGroup(r1)
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r2 = 0
            com.designsystem.ds_theme.DSTypography r3 = r1.getTypography(r14, r2)
            androidx.compose.ui.text.TextStyle r19 = r3.getDsBody1()
            androidx.compose.ui.text.style.TextOverflow$Companion r3 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r15 = r3.m5403getEllipsisgIe3tQ8()
            com.designsystem.ds_theme.DSColors r1 = r1.getColors(r14, r2)
            long r2 = r1.m8771getDsNeutral700d7_KjU()
            r1 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r24 = r14
            r13 = r16
            r16 = 0
            r17 = 1
            r18 = 0
            r21 = 0
            r22 = 3136(0xc40, float:4.394E-42)
            r23 = 22522(0x57fa, float:3.156E-41)
            r0 = r25
            r20 = r24
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r24.endReplaceableGroup()
        L_0x0081:
            androidx.compose.runtime.ScopeUpdateScope r0 = r24.endRestartGroup()
            if (r0 != 0) goto L_0x0088
            goto L_0x0094
        L_0x0088:
            com.designsystem.ds_list_item_v2.DSMenuListItemKt$MenuItemDescription$2 r1 = new com.designsystem.ds_list_item_v2.DSMenuListItemKt$MenuItemDescription$2
            r2 = r25
            r3 = r27
            r1.<init>(r2, r3)
            r0.updateScope(r1)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.DSMenuListItemKt.MenuItemDescription(java.lang.String, androidx.compose.runtime.Composer, int):void");
    }
}
