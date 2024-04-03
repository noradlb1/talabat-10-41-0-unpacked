package com.designsystem.ds_navigation_bar;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"DSNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "subtitle", "leadingIconButton", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "trailingContainer", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "animationBehavior", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lcom/designsystem/ds_icon_button/DSIconButtonModel;Lkotlin/jvm/functions/Function2;Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSNavigationBar(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r19, @org.jetbrains.annotations.Nullable java.lang.String r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.NotNull com.designsystem.ds_icon_button.DSIconButtonModel r22, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, @org.jetbrains.annotations.Nullable com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour r24, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r10 = r22
            r11 = r26
            java.lang.String r0 = "leadingIconButton"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1676737040(0xffffffff9c0f05f0, float:-4.7322405E-22)
            r1 = r25
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r27 & 1
            if (r0 == 0) goto L_0x001c
            r1 = r11 | 6
            r2 = r1
            r1 = r19
            goto L_0x0030
        L_0x001c:
            r1 = r11 & 14
            if (r1 != 0) goto L_0x002d
            r1 = r19
            boolean r2 = r12.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r11
            goto L_0x0030
        L_0x002d:
            r1 = r19
            r2 = r11
        L_0x0030:
            r3 = r27 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004a
            r4 = r20
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r2 = r2 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r20
        L_0x004c:
            r5 = r27 & 4
            if (r5 == 0) goto L_0x0053
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0066
            r6 = r21
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r7
            goto L_0x0068
        L_0x0066:
            r6 = r21
        L_0x0068:
            r7 = r27 & 8
            if (r7 == 0) goto L_0x006f
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006f:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007f
            boolean r7 = r12.changed((java.lang.Object) r10)
            if (r7 == 0) goto L_0x007c
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r7
        L_0x007f:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x009a
            r7 = r27 & 16
            if (r7 != 0) goto L_0x0094
            r7 = r23
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r7 = r23
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r2 = r2 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r23
        L_0x009c:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b6
            r8 = r27 & 32
            if (r8 != 0) goto L_0x00b0
            r8 = r24
            boolean r9 = r12.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b2
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r8 = r24
        L_0x00b2:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r2 = r2 | r9
            goto L_0x00b8
        L_0x00b6:
            r8 = r24
        L_0x00b8:
            r9 = 374491(0x5b6db, float:5.24774E-40)
            r9 = r9 & r2
            r13 = 74898(0x12492, float:1.04954E-40)
            r9 = r9 ^ r13
            if (r9 != 0) goto L_0x00d2
            boolean r9 = r12.getSkipping()
            if (r9 != 0) goto L_0x00c9
            goto L_0x00d2
        L_0x00c9:
            r12.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r5 = r7
            r6 = r8
            goto L_0x016a
        L_0x00d2:
            r9 = r11 & 1
            r13 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 1
            if (r9 == 0) goto L_0x0106
            boolean r9 = r12.getDefaultsInvalid()
            if (r9 == 0) goto L_0x00e4
            goto L_0x0106
        L_0x00e4:
            r12.skipCurrentGroup()
            r0 = r27 & 16
            if (r0 == 0) goto L_0x00ec
            r2 = r2 & r14
        L_0x00ec:
            r0 = r27 & 32
            if (r0 == 0) goto L_0x00fc
            r0 = r2 & r13
            r13 = r1
            r14 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r8 = r0
            goto L_0x0132
        L_0x00fc:
            r13 = r1
        L_0x00fd:
            r14 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r8 = r2
            goto L_0x0132
        L_0x0106:
            r12.startDefaults()
            if (r0 == 0) goto L_0x010e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x010f
        L_0x010e:
            r0 = r1
        L_0x010f:
            r1 = 0
            if (r3 == 0) goto L_0x0113
            r4 = r1
        L_0x0113:
            if (r5 == 0) goto L_0x0116
            r6 = r1
        L_0x0116:
            r3 = r27 & 16
            if (r3 == 0) goto L_0x0122
            com.designsystem.ds_navigation_bar.ComposableSingletons$DSNavigationBarKt r3 = com.designsystem.ds_navigation_bar.ComposableSingletons$DSNavigationBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m8497getLambda1$marshmallow_release()
            r2 = r2 & r14
            r7 = r3
        L_0x0122:
            r3 = r27 & 32
            if (r3 == 0) goto L_0x012d
            com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorFixed r3 = new com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorFixed
            r3.<init>(r1, r15, r1)
            r2 = r2 & r13
            r8 = r3
        L_0x012d:
            r12.endDefaults()
            r13 = r0
            goto L_0x00fd
        L_0x0132:
            androidx.lifecycle.LiveData r0 = r18.getBackgroundOpacity()
            r1 = 8
            androidx.compose.runtime.State r2 = androidx.compose.runtime.livedata.LiveDataAdapterKt.observeAsState(r0, r12, r1)
            androidx.lifecycle.LiveData r0 = r18.getElevationOpacity()
            androidx.compose.runtime.State r3 = androidx.compose.runtime.livedata.LiveDataAdapterKt.observeAsState(r0, r12, r1)
            com.designsystem.ds_navigation_bar.DSNavigationBarKt$DSNavigationBar$1 r9 = new com.designsystem.ds_navigation_bar.DSNavigationBarKt$DSNavigationBar$1
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r14
            r4 = r16
            r5 = r13
            r6 = r22
            r7 = r18
            r10 = r9
            r9 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = -819892841(0xffffffffcf216d97, float:-2.70831386E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r15, r10)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r12, r1)
            r1 = r13
            r2 = r14
            r3 = r16
            r5 = r17
            r6 = r18
        L_0x016a:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x0171
            goto L_0x0180
        L_0x0171:
            com.designsystem.ds_navigation_bar.DSNavigationBarKt$DSNavigationBar$2 r10 = new com.designsystem.ds_navigation_bar.DSNavigationBarKt$DSNavigationBar$2
            r0 = r10
            r4 = r22
            r7 = r26
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_navigation_bar.DSNavigationBarKt.DSNavigationBar(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, com.designsystem.ds_icon_button.DSIconButtonModel, kotlin.jvm.functions.Function2, com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour, androidx.compose.runtime.Composer, int, int):void");
    }
}
