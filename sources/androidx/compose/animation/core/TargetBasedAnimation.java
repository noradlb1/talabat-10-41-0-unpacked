package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BE\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\fBE\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000eJ\u0015\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u000b\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0016\u0010\n\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0010\u0010\u001f\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006)"}, d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "isInfinite", "", "()Z", "getTargetValue", "targetValueVector", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;
    @NotNull
    private final VectorizedAnimationSpec<V> animationSpec;
    private final long durationNanos;
    @NotNull
    private final V endVelocity;
    private final T initialValue;
    @NotNull
    private final V initialValueVector;
    @NotNull
    private final V initialVelocityVector;
    private final T targetValue;
    @NotNull
    private final V targetValueVector;
    @NotNull
    private final TwoWayConverter<T, V> typeConverter;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x003b, code lost:
        r7 = androidx.compose.animation.core.AnimationVectorsKt.copy(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TargetBasedAnimation(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.VectorizedAnimationSpec<V> r3, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.TwoWayConverter<T, V> r4, T r5, T r6, @org.jetbrains.annotations.Nullable V r7) {
        /*
            r2 = this;
            java.lang.String r0 = "animationSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "typeConverter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r2.<init>()
            r2.animationSpec = r3
            r2.typeConverter = r4
            r2.initialValue = r5
            r2.targetValue = r6
            androidx.compose.animation.core.TwoWayConverter r4 = r2.getTypeConverter()
            kotlin.jvm.functions.Function1 r4 = r4.getConvertToVector()
            java.lang.Object r4 = r4.invoke(r5)
            androidx.compose.animation.core.AnimationVector r4 = (androidx.compose.animation.core.AnimationVector) r4
            r2.initialValueVector = r4
            androidx.compose.animation.core.TwoWayConverter r6 = r2.getTypeConverter()
            kotlin.jvm.functions.Function1 r6 = r6.getConvertToVector()
            java.lang.Object r0 = r2.getTargetValue()
            java.lang.Object r6 = r6.invoke(r0)
            androidx.compose.animation.core.AnimationVector r6 = (androidx.compose.animation.core.AnimationVector) r6
            r2.targetValueVector = r6
            if (r7 == 0) goto L_0x0041
            androidx.compose.animation.core.AnimationVector r7 = androidx.compose.animation.core.AnimationVectorsKt.copy(r7)
            if (r7 != 0) goto L_0x0053
        L_0x0041:
            androidx.compose.animation.core.TwoWayConverter r7 = r2.getTypeConverter()
            kotlin.jvm.functions.Function1 r7 = r7.getConvertToVector()
            java.lang.Object r5 = r7.invoke(r5)
            androidx.compose.animation.core.AnimationVector r5 = (androidx.compose.animation.core.AnimationVector) r5
            androidx.compose.animation.core.AnimationVector r7 = androidx.compose.animation.core.AnimationVectorsKt.newInstance(r5)
        L_0x0053:
            r2.initialVelocityVector = r7
            long r0 = r3.getDurationNanos(r4, r6, r7)
            r2.durationNanos = r0
            androidx.compose.animation.core.AnimationVector r3 = r3.getEndVelocity(r4, r6, r7)
            r2.endVelocity = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.TargetBasedAnimation.<init>(androidx.compose.animation.core.VectorizedAnimationSpec, androidx.compose.animation.core.TwoWayConverter, java.lang.Object, java.lang.Object, androidx.compose.animation.core.AnimationVector):void");
    }

    @NotNull
    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public T getTargetValue() {
        return this.targetValue;
    }

    @NotNull
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public T getValueFromNanos(long j11) {
        if (isFinishedFromNanos(j11)) {
            return getTargetValue();
        }
        return getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(j11, this.initialValueVector, this.targetValueVector, this.initialVelocityVector));
    }

    @NotNull
    public V getVelocityVectorFromNanos(long j11) {
        if (isFinishedFromNanos(j11)) {
            return this.endVelocity;
        }
        return this.animationSpec.getVelocityFromNanos(j11, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
    }

    public /* synthetic */ boolean isFinishedFromNanos(long j11) {
        return a.a(this, j11);
    }

    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    @NotNull
    public String toString() {
        return "TargetBasedAnimation: " + this.initialValue + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedAnimationSpec, twoWayConverter, obj, obj2, (i11 & 16) != 0 ? null : animationVector);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec2, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec2, twoWayConverter, obj, obj2, (i11 & 16) != 0 ? null : animationVector);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TargetBasedAnimation(@NotNull AnimationSpec<T> animationSpec2, @NotNull TwoWayConverter<T, V> twoWayConverter, T t11, T t12, @Nullable V v11) {
        this(animationSpec2.vectorize(twoWayConverter), twoWayConverter, t11, t12, v11);
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
    }
}
