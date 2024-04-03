package com.designsystem.ds_fixed_footer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u0006\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"DSFixedFooter", "", "modifier", "Landroidx/compose/ui/Modifier;", "isElevated", "", "topContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSFixedFooter(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r15, boolean r16, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r17, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r6 = r18
            r7 = r20
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 1477581265(0x581219d1, float:6.4255831E14)
            r1 = r19
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            r0 = r21 & 1
            if (r0 == 0) goto L_0x001b
            r1 = r7 | 6
            r2 = r1
            r1 = r15
            goto L_0x002d
        L_0x001b:
            r1 = r7 & 14
            if (r1 != 0) goto L_0x002b
            r1 = r15
            boolean r2 = r8.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r7
            goto L_0x002d
        L_0x002b:
            r1 = r15
            r2 = r7
        L_0x002d:
            r3 = r21 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r16
            boolean r5 = r8.changed((boolean) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r16
        L_0x0049:
            r5 = r21 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r9 = r7 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0063
            r9 = r17
            boolean r10 = r8.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x005f
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r10
            goto L_0x0065
        L_0x0063:
            r9 = r17
        L_0x0065:
            r10 = r21 & 8
            if (r10 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x006c:
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007c
            boolean r10 = r8.changed((java.lang.Object) r6)
            if (r10 == 0) goto L_0x0079
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r10
        L_0x007c:
            r10 = r2
            r2 = r10 & 5851(0x16db, float:8.199E-42)
            r2 = r2 ^ 1170(0x492, float:1.64E-42)
            if (r2 != 0) goto L_0x0090
            boolean r2 = r8.getSkipping()
            if (r2 != 0) goto L_0x008a
            goto L_0x0090
        L_0x008a:
            r8.skipToGroupEnd()
            r2 = r4
            r3 = r9
            goto L_0x00b9
        L_0x0090:
            if (r0 == 0) goto L_0x0096
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r11 = r0
            goto L_0x0097
        L_0x0096:
            r11 = r1
        L_0x0097:
            r12 = 1
            if (r3 == 0) goto L_0x009c
            r13 = r12
            goto L_0x009d
        L_0x009c:
            r13 = r4
        L_0x009d:
            if (r5 == 0) goto L_0x00a1
            r0 = 0
            r9 = r0
        L_0x00a1:
            com.designsystem.ds_fixed_footer.DSFixedFooterKt$DSFixedFooter$1 r14 = new com.designsystem.ds_fixed_footer.DSFixedFooterKt$DSFixedFooter$1
            r0 = r14
            r1 = r11
            r2 = r13
            r3 = r9
            r4 = r10
            r5 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = -819896305(0xffffffffcf21600f, float:-2.70742707E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r0, r12, r14)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r8, r1)
            r1 = r11
        L_0x00b9:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x00c0
            goto L_0x00cf
        L_0x00c0:
            com.designsystem.ds_fixed_footer.DSFixedFooterKt$DSFixedFooter$2 r9 = new com.designsystem.ds_fixed_footer.DSFixedFooterKt$DSFixedFooter$2
            r0 = r9
            r4 = r18
            r5 = r20
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.updateScope(r9)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_fixed_footer.DSFixedFooterKt.DSFixedFooter(androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
