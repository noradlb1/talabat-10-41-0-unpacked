package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a©\u0001\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a8\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\rH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "MaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "MinWidth", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final PaddingValues DialogPadding;
    /* access modifiers changed from: private */
    @NotNull
    public static final PaddingValues IconPadding;
    /* access modifiers changed from: private */
    public static final float MaxWidth = Dp.m5478constructorimpl((float) 560);
    /* access modifiers changed from: private */
    public static final float MinWidth = Dp.m5478constructorimpl((float) 280);
    /* access modifiers changed from: private */
    @NotNull
    public static final PaddingValues TextPadding;
    /* access modifiers changed from: private */
    @NotNull
    public static final PaddingValues TitlePadding;

    static {
        float f11 = (float) 24;
        DialogPadding = PaddingKt.m479PaddingValues0680j_4(Dp.m5478constructorimpl(f11));
        float f12 = (float) 16;
        IconPadding = PaddingKt.m483PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5478constructorimpl(f12), 7, (Object) null);
        TitlePadding = PaddingKt.m483PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5478constructorimpl(f12), 7, (Object) null);
        TextPadding = PaddingKt.m483PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5478constructorimpl(f11), 7, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0130  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: AlertDialogContent-4hvqGtA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1493AlertDialogContent4hvqGtA(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.Shape r31, long r32, float r34, long r35, long r37, long r39, long r41, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r43, int r44, int r45, int r46) {
        /*
            r14 = r26
            r15 = r31
            r13 = r44
            r11 = r46
            java.lang.String r0 = "buttons"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "shape"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            r1 = r43
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0022
            r1 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0031
            boolean r1 = r12.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x002e
            r1 = 4
            goto L_0x002f
        L_0x002e:
            r1 = 2
        L_0x002f:
            r1 = r1 | r13
            goto L_0x0032
        L_0x0031:
            r1 = r13
        L_0x0032:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0039
            r1 = r1 | 48
            goto L_0x004c
        L_0x0039:
            r7 = r13 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004c
            r7 = r27
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0048
            r8 = 32
            goto L_0x004a
        L_0x0048:
            r8 = 16
        L_0x004a:
            r1 = r1 | r8
            goto L_0x004e
        L_0x004c:
            r7 = r27
        L_0x004e:
            r8 = r11 & 4
            if (r8 == 0) goto L_0x0057
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r28
            goto L_0x0069
        L_0x0057:
            r8 = r13 & 896(0x380, float:1.256E-42)
            r9 = r28
            if (r8 != 0) goto L_0x0069
            boolean r8 = r12.changed((java.lang.Object) r9)
            if (r8 == 0) goto L_0x0066
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r8
        L_0x0069:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x0072
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r10 = r29
            goto L_0x0084
        L_0x0072:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            r10 = r29
            if (r8 != 0) goto L_0x0084
            boolean r8 = r12.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x0081
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r8
        L_0x0084:
            r8 = r11 & 16
            r16 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x008e
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008e:
            r8 = r13 & r16
            if (r8 != 0) goto L_0x00a2
            r8 = r30
            boolean r17 = r12.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x009d
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r1 = r1 | r17
            goto L_0x00a4
        L_0x00a2:
            r8 = r30
        L_0x00a4:
            r17 = r11 & 32
            if (r17 == 0) goto L_0x00ad
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00aa:
            r1 = r1 | r17
            goto L_0x00bf
        L_0x00ad:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00bf
            boolean r17 = r12.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x00bc
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00aa
        L_0x00bc:
            r17 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00aa
        L_0x00bf:
            r17 = r11 & 64
            if (r17 == 0) goto L_0x00cc
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r18 = r1
            r0 = r32
            goto L_0x00e6
        L_0x00cc:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            r43 = r1
            r0 = r32
            if (r17 != 0) goto L_0x00e4
            boolean r18 = r12.changed((long) r0)
            if (r18 == 0) goto L_0x00df
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r18 = r43 | r18
            goto L_0x00e6
        L_0x00e4:
            r18 = r43
        L_0x00e6:
            r2 = r11 & 128(0x80, float:1.794E-43)
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            if (r2 == 0) goto L_0x00ef
            r18 = r18 | r19
            goto L_0x0104
        L_0x00ef:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x0104
            r2 = r34
            boolean r20 = r12.changed((float) r2)
            if (r20 == 0) goto L_0x00ff
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r18 = r18 | r20
            goto L_0x0106
        L_0x0104:
            r2 = r34
        L_0x0106:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0111
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r18 | r3
            r14 = r35
            goto L_0x0125
        L_0x0111:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r13
            r14 = r35
            if (r3 != 0) goto L_0x0125
            boolean r3 = r12.changed((long) r14)
            if (r3 == 0) goto L_0x0121
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r3 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r18 = r18 | r3
        L_0x0125:
            r3 = r11 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0130
            r3 = 805306368(0x30000000, float:4.656613E-10)
            r18 = r18 | r3
            r14 = r37
            goto L_0x0144
        L_0x0130:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r13
            r14 = r37
            if (r3 != 0) goto L_0x0144
            boolean r3 = r12.changed((long) r14)
            if (r3 == 0) goto L_0x0140
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0142
        L_0x0140:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0142:
            r18 = r18 | r3
        L_0x0144:
            r3 = r18
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x014f
            r5 = r45 | 6
            r14 = r39
            goto L_0x0165
        L_0x014f:
            r5 = r45 & 14
            r14 = r39
            if (r5 != 0) goto L_0x0163
            boolean r5 = r12.changed((long) r14)
            if (r5 == 0) goto L_0x015e
            r20 = 4
            goto L_0x0160
        L_0x015e:
            r20 = 2
        L_0x0160:
            r5 = r45 | r20
            goto L_0x0165
        L_0x0163:
            r5 = r45
        L_0x0165:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x016e
            r5 = r5 | 48
            r14 = r41
            goto L_0x0181
        L_0x016e:
            r6 = r45 & 112(0x70, float:1.57E-43)
            r14 = r41
            if (r6 != 0) goto L_0x0181
            boolean r6 = r12.changed((long) r14)
            if (r6 == 0) goto L_0x017d
            r18 = 32
            goto L_0x017f
        L_0x017d:
            r18 = 16
        L_0x017f:
            r5 = r5 | r18
        L_0x0181:
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r3
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r0) goto L_0x019e
            r0 = r5 & 91
            r1 = 18
            if (r0 != r1) goto L_0x019e
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x0197
            goto L_0x019e
        L_0x0197:
            r12.skipToGroupEnd()
            r2 = r7
            r15 = r12
            goto L_0x0212
        L_0x019e:
            if (r4 == 0) goto L_0x01a5
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r18 = r0
            goto L_0x01a7
        L_0x01a5:
            r18 = r7
        L_0x01a7:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b5
            java.lang.String r0 = "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:38)"
            r1 = 1522575799(0x5ac0a9b7, float:2.71148995E16)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r3, r5, r0)
        L_0x01b5:
            r20 = 0
            r17 = 0
            r22 = 0
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$1 r7 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
            r0 = r7
            r1 = r28
            r2 = r29
            r23 = r3
            r3 = r30
            r4 = r37
            r6 = r23
            r14 = r7
            r7 = r39
            r9 = r41
            r15 = r12
            r11 = r35
            r13 = r26
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r13)
            r0 = -2126308228(0xffffffff81431c7c, float:-3.583628E-38)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r1, r14)
            int r0 = r23 >> 3
            r0 = r0 & 14
            r0 = r0 | r19
            int r1 = r23 >> 12
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            int r1 = r23 >> 9
            r1 = r1 & r16
            r11 = r0 | r1
            r12 = 104(0x68, float:1.46E-43)
            r0 = r18
            r1 = r31
            r2 = r32
            r4 = r20
            r6 = r34
            r7 = r17
            r8 = r22
            r10 = r15
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0210
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0210:
            r2 = r18
        L_0x0212:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x0219
            goto L_0x0246
        L_0x0219:
            androidx.compose.material3.AlertDialogKt$AlertDialogContent$2 r15 = new androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
            r0 = r15
            r1 = r26
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r9 = r34
            r10 = r35
            r12 = r37
            r24 = r14
            r25 = r15
            r14 = r39
            r16 = r41
            r18 = r44
            r19 = r45
            r20 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14, r16, r18, r19, r20)
            r0 = r24
            r1 = r25
            r0.updateScope(r1)
        L_0x0246:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.m1493AlertDialogContent4hvqGtA(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m1494AlertDialogFlowRowixp7dh8(float f11, float f12, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(586821353);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(f11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(f12)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if ((i12 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i12, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:127)");
            }
            AlertDialogKt$AlertDialogFlowRow$1 alertDialogKt$AlertDialogFlowRow$1 = new AlertDialogKt$AlertDialogFlowRow$1(f11, f12);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            int i16 = ((((i12 >> 6) & 14) << 9) & 7168) | 6;
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
            Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r72, alertDialogKt$AlertDialogFlowRow$1, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion2.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i16 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i16 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f11, f12, function2, i11));
        }
    }
}
