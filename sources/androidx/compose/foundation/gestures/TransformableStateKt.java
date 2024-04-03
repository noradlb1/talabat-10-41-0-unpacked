package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import o.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003ø\u0001\u0000\u001a]\u0010\f\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a5\u0010\u000e\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0019\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\bH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001d\u0010\u001c\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animatePanBy", "offset", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateZoomBy", "zoomFactor", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zoomBy", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TransformableStateKt {
    @NotNull
    public static final TransformableState TransformableState(@NotNull Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "onTransformation");
        return new DefaultTransformableState(function3);
    }

    @Nullable
    /* renamed from: animatePanBy-ubNVwUQ  reason: not valid java name */
    public static final Object m363animatePanByubNVwUQ(@NotNull TransformableState transformableState, long j11, @NotNull AnimationSpec<Offset> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.Companion.m2692getZeroF1C5BW0();
        Object a11 = e.a(transformableState, (MutatePriority) null, new TransformableStateKt$animatePanBy$2(longRef, j11, animationSpec, (Continuation<? super TransformableStateKt$animatePanBy$2>) null), continuation, 1, (Object) null);
        if (a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return a11;
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: animatePanBy-ubNVwUQ$default  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object m364animatePanByubNVwUQ$default(androidx.compose.foundation.gestures.TransformableState r6, long r7, androidx.compose.animation.core.AnimationSpec r9, kotlin.coroutines.Continuation r10, int r11, java.lang.Object r12) {
        /*
            r11 = r11 & 2
            if (r11 == 0) goto L_0x0010
            androidx.compose.animation.core.SpringSpec r9 = new androidx.compose.animation.core.SpringSpec
            r1 = 0
            r2 = 1128792064(0x43480000, float:200.0)
            r3 = 0
            r4 = 5
            r5 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0010:
            java.lang.Object r6 = m363animatePanByubNVwUQ(r6, r7, r9, r10)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableStateKt.m364animatePanByubNVwUQ$default(androidx.compose.foundation.gestures.TransformableState, long, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation, int, java.lang.Object):java.lang.Object");
    }

    @Nullable
    public static final Object animateRotateBy(@NotNull TransformableState transformableState, float f11, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = e.a(transformableState, (MutatePriority) null, new TransformableStateKt$animateRotateBy$2(new Ref.FloatRef(), f11, animationSpec, (Continuation<? super TransformableStateKt$animateRotateBy$2>) null), continuation, 1, (Object) null);
        if (a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return a11;
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object animateRotateBy$default(androidx.compose.foundation.gestures.TransformableState r6, float r7, androidx.compose.animation.core.AnimationSpec r8, kotlin.coroutines.Continuation r9, int r10, java.lang.Object r11) {
        /*
            r10 = r10 & 2
            if (r10 == 0) goto L_0x0010
            androidx.compose.animation.core.SpringSpec r8 = new androidx.compose.animation.core.SpringSpec
            r1 = 0
            r2 = 1128792064(0x43480000, float:200.0)
            r3 = 0
            r4 = 5
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0010:
            java.lang.Object r6 = animateRotateBy(r6, r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableStateKt.animateRotateBy$default(androidx.compose.foundation.gestures.TransformableState, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation, int, java.lang.Object):java.lang.Object");
    }

    @Nullable
    public static final Object animateZoomBy(@NotNull TransformableState transformableState, float f11, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        boolean z11;
        if (f11 > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = 1.0f;
            Object a11 = e.a(transformableState, (MutatePriority) null, new TransformableStateKt$animateZoomBy$3(floatRef, f11, animationSpec, (Continuation<? super TransformableStateKt$animateZoomBy$3>) null), continuation, 1, (Object) null);
            if (a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return a11;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("zoom value should be greater than 0".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.animation.core.SpringSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object animateZoomBy$default(androidx.compose.foundation.gestures.TransformableState r6, float r7, androidx.compose.animation.core.AnimationSpec r8, kotlin.coroutines.Continuation r9, int r10, java.lang.Object r11) {
        /*
            r10 = r10 & 2
            if (r10 == 0) goto L_0x0010
            androidx.compose.animation.core.SpringSpec r8 = new androidx.compose.animation.core.SpringSpec
            r1 = 0
            r2 = 1128792064(0x43480000, float:200.0)
            r3 = 0
            r4 = 5
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0010:
            java.lang.Object r6 = animateZoomBy(r6, r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableStateKt.animateZoomBy$default(androidx.compose.foundation.gestures.TransformableState, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation, int, java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: panBy-d-4ec7I  reason: not valid java name */
    public static final Object m365panByd4ec7I(@NotNull TransformableState transformableState, long j11, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = e.a(transformableState, (MutatePriority) null, new TransformableStateKt$panBy$2(j11, (Continuation<? super TransformableStateKt$panBy$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    @NotNull
    @Composable
    public static final TransformableState rememberTransformableState(@NotNull Function3<? super Float, ? super Offset, ? super Float, Unit> function3, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function3, "onTransformation");
        composer.startReplaceableGroup(1681419281);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i11, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:114)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composer, i11 & 14);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TransformableState(new TransformableStateKt$rememberTransformableState$1$1(rememberUpdatedState));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TransformableState transformableState = (TransformableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transformableState;
    }

    @Nullable
    public static final Object rotateBy(@NotNull TransformableState transformableState, float f11, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = e.a(transformableState, (MutatePriority) null, new TransformableStateKt$rotateBy$2(f11, (Continuation<? super TransformableStateKt$rotateBy$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    @Nullable
    public static final Object stopTransformation(@NotNull TransformableState transformableState, @NotNull MutatePriority mutatePriority, @NotNull Continuation<? super Unit> continuation) {
        Object transform = transformableState.transform(mutatePriority, new TransformableStateKt$stopTransformation$2((Continuation<? super TransformableStateKt$stopTransformation$2>) null), continuation);
        return transform == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    @Nullable
    public static final Object zoomBy(@NotNull TransformableState transformableState, float f11, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = e.a(transformableState, (MutatePriority) null, new TransformableStateKt$zoomBy$2(f11, (Continuation<? super TransformableStateKt$zoomBy$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }
}
