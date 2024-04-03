package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u001a-\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00142\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190\nH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"SwipeToDismiss", "", "state", "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", "from", "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwipeToDismissKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismiss(@org.jetbrains.annotations.NotNull androidx.compose.material.DismissState r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, @org.jetbrains.annotations.Nullable java.util.Set<? extends androidx.compose.material.DismissDirection> r23, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.material.DismissDirection, ? extends androidx.compose.material.ThresholdConfig> r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r7 = r21
            r8 = r25
            r9 = r26
            r10 = r28
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "background"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dismissContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 634380143(0x25cfdf6f, float:3.606018E-16)
            r1 = r27
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r29 & 1
            r1 = 4
            r2 = 2
            if (r0 == 0) goto L_0x0029
            r0 = r10 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r15.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0035
            r0 = r1
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            r0 = r0 | r10
            goto L_0x0039
        L_0x0038:
            r0 = r10
        L_0x0039:
            r3 = r29 & 2
            if (r3 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0053
        L_0x0040:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0053
            r4 = r22
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004f
            r5 = 32
            goto L_0x0051
        L_0x004f:
            r5 = 16
        L_0x0051:
            r0 = r0 | r5
            goto L_0x0055
        L_0x0053:
            r4 = r22
        L_0x0055:
            r5 = r29 & 4
            if (r5 == 0) goto L_0x005b
            r0 = r0 | 128(0x80, float:1.794E-43)
        L_0x005b:
            r6 = r29 & 8
            if (r6 == 0) goto L_0x0062
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0075
            r11 = r24
            boolean r12 = r15.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0071
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r0 = r0 | r12
            goto L_0x0077
        L_0x0075:
            r11 = r24
        L_0x0077:
            r12 = r29 & 16
            if (r12 == 0) goto L_0x007e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0090
        L_0x007e:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x0090
            boolean r12 = r15.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x008d
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008f
        L_0x008d:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x008f:
            r0 = r0 | r12
        L_0x0090:
            r12 = r29 & 32
            if (r12 == 0) goto L_0x0098
            r12 = 196608(0x30000, float:2.75506E-40)
        L_0x0096:
            r0 = r0 | r12
            goto L_0x00a9
        L_0x0098:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00a9
            boolean r12 = r15.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x00a6
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0096
        L_0x00a6:
            r12 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0096
        L_0x00a9:
            if (r5 != r1) goto L_0x00c5
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r0
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r12) goto L_0x00c5
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x00bb
            goto L_0x00c5
        L_0x00bb:
            r15.skipToGroupEnd()
            r3 = r23
            r2 = r4
            r4 = r11
            r1 = r15
            goto L_0x0146
        L_0x00c5:
            r15.startDefaults()
            r1 = r10 & 1
            r12 = 1
            if (r1 == 0) goto L_0x00e3
            boolean r1 = r15.getDefaultsInvalid()
            if (r1 == 0) goto L_0x00d4
            goto L_0x00e3
        L_0x00d4:
            r15.skipToGroupEnd()
            if (r5 == 0) goto L_0x00db
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00db:
            r19 = r23
            r18 = r4
        L_0x00df:
            r20 = r11
            r11 = r0
            goto L_0x0110
        L_0x00e3:
            if (r3 == 0) goto L_0x00e8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00e9
        L_0x00e8:
            r1 = r4
        L_0x00e9:
            if (r5 == 0) goto L_0x00fd
            androidx.compose.material.DismissDirection[] r2 = new androidx.compose.material.DismissDirection[r2]
            r3 = 0
            androidx.compose.material.DismissDirection r4 = androidx.compose.material.DismissDirection.EndToStart
            r2[r3] = r4
            androidx.compose.material.DismissDirection r3 = androidx.compose.material.DismissDirection.StartToEnd
            r2[r12] = r3
            java.util.Set r2 = kotlin.collections.SetsKt__SetsKt.setOf(r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00ff
        L_0x00fd:
            r2 = r23
        L_0x00ff:
            if (r6 == 0) goto L_0x010b
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1 r3 = androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1.INSTANCE
            r11 = r0
            r18 = r1
            r19 = r2
            r20 = r3
            goto L_0x0110
        L_0x010b:
            r18 = r1
            r19 = r2
            goto L_0x00df
        L_0x0110:
            r15.endDefaults()
            r13 = 0
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2 r6 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
            r0 = r6
            r1 = r19
            r2 = r20
            r3 = r11
            r4 = r21
            r5 = r25
            r14 = r6
            r6 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 338007641(0x14259659, float:8.360022E-27)
            androidx.compose.runtime.internal.ComposableLambda r14 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r12, r14)
            int r0 = r11 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r17 = 6
            r11 = r18
            r12 = r13
            r1 = 0
            r13 = r1
            r1 = r15
            r16 = r0
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r11, r12, r13, r14, r15, r16, r17)
            r2 = r18
            r3 = r19
            r4 = r20
        L_0x0146:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 != 0) goto L_0x014d
            goto L_0x0160
        L_0x014d:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3 r12 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3
            r0 = r12
            r1 = r21
            r5 = r25
            r6 = r26
            r7 = r28
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r11.updateScope(r12)
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss(androidx.compose.material.DismissState, androidx.compose.ui.Modifier, java.util.Set, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        DismissValue dismissValue3 = DismissValue.Default;
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == dismissValue3) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == dismissValue3) {
            return DismissDirection.EndToStart;
        }
        return null;
    }

    @ExperimentalMaterialApi
    @NotNull
    @Composable
    public static final DismissState rememberDismissState(@Nullable DismissValue dismissValue, @Nullable Function1<? super DismissValue, Boolean> function1, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-1753522702);
        if ((i12 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        Function1 function12 = function1;
        if ((i12 & 2) != 0) {
            function12 = SwipeToDismissKt$rememberDismissState$1.INSTANCE;
        }
        DismissState dismissState = (DismissState) RememberSaveableKt.rememberSaveable(new Object[0], DismissState.Companion.Saver(function12), (String) null, new SwipeToDismissKt$rememberDismissState$2(dismissValue, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return dismissState;
    }
}
