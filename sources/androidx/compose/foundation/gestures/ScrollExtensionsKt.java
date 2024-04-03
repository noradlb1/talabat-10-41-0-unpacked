package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "value", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ScrollExtensionsKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object animateScrollBy(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollableState r7, float r8, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationSpec<java.lang.Float> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Float> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1) r0
            int r1 = r0.f2144j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2144j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1
            r0.<init>(r10)
        L_0x0018:
            r4 = r0
            java.lang.Object r10 = r4.f2143i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f2144j
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r7 = r4.f2142h
            kotlin.jvm.internal.Ref$FloatRef r7 = (kotlin.jvm.internal.Ref.FloatRef) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            r3 = 0
            androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2 r5 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2
            r1 = 0
            r5.<init>(r8, r9, r10, r1)
            r8 = 1
            r6 = 0
            r4.f2142h = r10
            r4.f2144j = r2
            r1 = r7
            r2 = r3
            r3 = r5
            r5 = r8
            java.lang.Object r7 = o.c.a(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r7 = r10
        L_0x0057:
            float r7 = r7.element
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(androidx.compose.foundation.gestures.ScrollableState, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollBy$default(ScrollableState scrollableState, float f11, AnimationSpec animationSpec, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        return animateScrollBy(scrollableState, f11, animationSpec, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object scrollBy(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.ScrollableState r7, float r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Float> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1) r0
            int r1 = r0.f2153j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2153j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1
            r0.<init>(r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f2152i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f2153j
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r7 = r4.f2151h
            kotlin.jvm.internal.Ref$FloatRef r7 = (kotlin.jvm.internal.Ref.FloatRef) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$FloatRef r9 = new kotlin.jvm.internal.Ref$FloatRef
            r9.<init>()
            r3 = 0
            androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2 r5 = new androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2
            r1 = 0
            r5.<init>(r9, r8, r1)
            r8 = 1
            r6 = 0
            r4.f2151h = r9
            r4.f2153j = r2
            r1 = r7
            r2 = r3
            r3 = r5
            r5 = r8
            java.lang.Object r7 = o.c.a(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r7 = r9
        L_0x0057:
            float r7 = r7.element
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(androidx.compose.foundation.gestures.ScrollableState, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final Object stopScroll(@NotNull ScrollableState scrollableState, @NotNull MutatePriority mutatePriority, @NotNull Continuation<? super Unit> continuation) {
        Object scroll = scrollableState.scroll(mutatePriority, new ScrollExtensionsKt$stopScroll$2((Continuation<? super ScrollExtensionsKt$stopScroll$2>) null), continuation);
        return scroll == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopScroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopScroll(scrollableState, mutatePriority, continuation);
    }
}
