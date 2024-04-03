package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a=\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "rememberLazyNearestItemsRangeState", "Landroidx/compose/runtime/State;", "firstVisibleItemIndex", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyNearestItemsRangeKt {
    /* access modifiers changed from: private */
    public static final IntRange calculateNearestItemsRange(int i11, int i12, int i13) {
        int i14 = (i11 / i12) * i12;
        return RangesKt___RangesKt.until(Math.max(i14 - i13, 0), i14 + i12 + i13);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1} */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b1, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00b3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.foundation.ExperimentalFoundationApi
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.State<kotlin.ranges.IntRange> rememberLazyNearestItemsRangeState(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Integer> r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Integer> r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Integer> r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12) {
        /*
            java.lang.String r0 = "firstVisibleItemIndex"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "slidingWindowSize"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "extraItemCount"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 429733345(0x199d35e1, float:1.6255181E-23)
            r11.startReplaceableGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0021
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.lazy.layout.rememberLazyNearestItemsRangeState (LazyNearestItemsRange.kt:41)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
        L_0x0021:
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r12)
            boolean r12 = r11.changed((java.lang.Object) r8)
            boolean r0 = r11.changed((java.lang.Object) r9)
            r12 = r12 | r0
            boolean r0 = r11.changed((java.lang.Object) r10)
            r12 = r12 | r0
            java.lang.Object r0 = r11.rememberedValue()
            r1 = 2
            if (r12 != 0) goto L_0x0044
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r0 != r12) goto L_0x007f
        L_0x0044:
            androidx.compose.runtime.snapshots.Snapshot$Companion r12 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.snapshots.Snapshot r12 = r12.createNonObservableSnapshot()
            androidx.compose.runtime.snapshots.Snapshot r0 = r12.makeCurrent()     // Catch:{ all -> 0x00dd }
            java.lang.Object r2 = r8.invoke()     // Catch:{ all -> 0x00d8 }
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00d8 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00d8 }
            java.lang.Object r3 = r9.invoke()     // Catch:{ all -> 0x00d8 }
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x00d8 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00d8 }
            java.lang.Object r4 = r10.invoke()     // Catch:{ all -> 0x00d8 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ all -> 0x00d8 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00d8 }
            kotlin.ranges.IntRange r2 = calculateNearestItemsRange(r2, r3, r4)     // Catch:{ all -> 0x00d8 }
            r3 = 0
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r3, r1, r3)     // Catch:{ all -> 0x00d8 }
            r12.restoreCurrent(r0)     // Catch:{ all -> 0x00dd }
            r12.dispose()
            r11.updateRememberedValue(r2)
            r0 = r2
        L_0x007f:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            r12 = 4
            java.lang.Object[] r2 = new java.lang.Object[r12]
            r3 = 0
            r2[r3] = r8
            r4 = 1
            r2[r4] = r9
            r2[r1] = r10
            r1 = 3
            r2[r1] = r0
            r1 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r11.startReplaceableGroup(r1)
            r1 = r3
        L_0x0099:
            if (r3 >= r12) goto L_0x00a5
            r4 = r2[r3]
            boolean r4 = r11.changed((java.lang.Object) r4)
            r1 = r1 | r4
            int r3 = r3 + 1
            goto L_0x0099
        L_0x00a5:
            java.lang.Object r12 = r11.rememberedValue()
            if (r1 != 0) goto L_0x00b3
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r12 != r1) goto L_0x00c1
        L_0x00b3:
            androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1 r12 = new androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1
            r7 = 0
            r2 = r12
            r3 = r8
            r4 = r9
            r5 = r10
            r6 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r11.updateRememberedValue(r12)
        L_0x00c1:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r8 = 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r12, (androidx.compose.runtime.Composer) r11, (int) r8)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00d4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00d4:
            r11.endReplaceableGroup()
            return r0
        L_0x00d8:
            r8 = move-exception
            r12.restoreCurrent(r0)     // Catch:{ all -> 0x00dd }
            throw r8     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r8 = move-exception
            r12.dispose()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }
}
