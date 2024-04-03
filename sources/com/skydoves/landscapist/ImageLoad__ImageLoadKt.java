package com.skydoves.landscapist;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001az\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2&\u0010\f\u001a\"\u0012\u0013\u0012\u00110\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a=\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"ImageLoad", "", "T", "", "recomposeKey", "executeImageRequest", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/skydoves/landscapist/ImageLoadState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/ParameterName;", "name", "imageState", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "executeImageLoading", "executeImageLoading$ImageLoad__ImageLoadKt", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "landscapist_release"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "com/skydoves/landscapist/ImageLoad")
final /* synthetic */ class ImageLoad__ImageLoadKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void ImageLoad(@org.jetbrains.annotations.Nullable T r14, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.skydoves.landscapist.ImageLoadState>>, ? extends java.lang.Object> r15, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r16, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super com.skydoves.landscapist.ImageLoadState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r17, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r1 = r14
            r2 = r15
            r4 = r17
            r5 = r19
            java.lang.String r0 = "executeImageRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -798462092(0xffffffffd0686f74, float:-1.55984732E10)
            r3 = r18
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r20 & 1
            r6 = 2
            if (r3 == 0) goto L_0x0021
            r3 = r5 | 6
            goto L_0x0031
        L_0x0021:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x0030
            boolean r3 = r0.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x002d
            r3 = 4
            goto L_0x002e
        L_0x002d:
            r3 = r6
        L_0x002e:
            r3 = r3 | r5
            goto L_0x0031
        L_0x0030:
            r3 = r5
        L_0x0031:
            r7 = r20 & 2
            if (r7 == 0) goto L_0x0038
            r3 = r3 | 48
            goto L_0x0048
        L_0x0038:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0048
            boolean r7 = r0.changed((java.lang.Object) r15)
            if (r7 == 0) goto L_0x0045
            r7 = 32
            goto L_0x0047
        L_0x0045:
            r7 = 16
        L_0x0047:
            r3 = r3 | r7
        L_0x0048:
            r7 = r20 & 4
            if (r7 == 0) goto L_0x004f
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0062
            r8 = r16
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005e
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r9
            goto L_0x0064
        L_0x0062:
            r8 = r16
        L_0x0064:
            r9 = r20 & 8
            if (r9 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x006b:
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007b
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0078
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r9
        L_0x007b:
            r9 = r3 & 5851(0x16db, float:8.199E-42)
            r9 = r9 ^ 1170(0x492, float:1.64E-42)
            if (r9 != 0) goto L_0x008d
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            r0.skipToGroupEnd()
            r3 = r8
            goto L_0x00e4
        L_0x008d:
            if (r7 == 0) goto L_0x0093
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r13 = r7
            goto L_0x0094
        L_0x0093:
            r13 = r8
        L_0x0094:
            r7 = r3 & 8
            r8 = r3 & 14
            r7 = r7 | r8
            r8 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r8)
            boolean r8 = r0.changed((java.lang.Object) r14)
            java.lang.Object r9 = r0.rememberedValue()
            r10 = 0
            if (r8 != 0) goto L_0x00b2
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x00bb
        L_0x00b2:
            com.skydoves.landscapist.ImageLoadState$None r8 = com.skydoves.landscapist.ImageLoadState.None.INSTANCE
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r10, r6, r10)
            r0.updateRememberedValue(r9)
        L_0x00bb:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$1 r6 = new com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$1
            r6.<init>(r15, r9, r10)
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6, (androidx.compose.runtime.Composer) r0, (int) r7)
            r7 = 0
            r8 = 0
            com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$2 r6 = new com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$2
            r6.<init>(r4, r3, r9)
            r9 = -819892339(0xffffffffcf216f8d, float:-2.70844237E9)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r9, r10, r6)
            int r3 = r3 >> 6
            r3 = r3 & 14
            r11 = r3 | 3072(0xc00, float:4.305E-42)
            r12 = 6
            r6 = r13
            r10 = r0
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r6, r7, r8, r9, r10, r11, r12)
            r3 = r13
        L_0x00e4:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x00eb
            goto L_0x00fc
        L_0x00eb:
            com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$3 r8 = new com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$3
            r0 = r8
            r1 = r14
            r2 = r15
            r4 = r17
            r5 = r19
            r6 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.landscapist.ImageLoad__ImageLoadKt.ImageLoad(java.lang.Object, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ImageLoad$lambda-1$ImageLoad__ImageLoadKt  reason: not valid java name */
    public static final ImageLoadState m9395ImageLoad$lambda1$ImageLoad__ImageLoadKt(MutableState<ImageLoadState> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ImageLoad$lambda-2$ImageLoad__ImageLoadKt  reason: not valid java name */
    public static final void m9396ImageLoad$lambda2$ImageLoad__ImageLoadKt(MutableState<ImageLoadState> mutableState, ImageLoadState imageLoadState) {
        mutableState.setValue(imageLoadState);
    }

    /* access modifiers changed from: private */
    public static final Object executeImageLoading$ImageLoad__ImageLoadKt(Function1<? super Continuation<? super Flow<? extends ImageLoadState>>, ? extends Object> function1, Continuation<? super Flow<? extends ImageLoadState>> continuation) {
        return FlowKt.flowOn(FlowKt.distinctUntilChanged(FlowKt.m7822catch(FlowKt.flow(new ImageLoad__ImageLoadKt$executeImageLoading$2(function1, (Continuation<? super ImageLoad__ImageLoadKt$executeImageLoading$2>) null)), new ImageLoad__ImageLoadKt$executeImageLoading$3((Continuation<? super ImageLoad__ImageLoadKt$executeImageLoading$3>) null))), Dispatchers.getIO());
    }
}
