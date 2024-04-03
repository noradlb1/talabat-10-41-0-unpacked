package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.d;
import m.e;
import m.f;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ-\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "getDelayMillis", "()I", "getDurationMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "value", "(Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    @NotNull
    private final Map<Integer, Pair<V, Easing>> keyframes;
    private V valueVector;
    private V velocityVector;

    public VectorizedKeyframesSpec(@NotNull Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int i11, int i12) {
        Intrinsics.checkNotNullParameter(map, "keyframes");
        this.keyframes = map;
        this.durationMillis = i11;
        this.delayMillis = i12;
    }

    private final void init(V v11) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v11);
            this.velocityVector = AnimationVectorsKt.newInstance(v11);
        }
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return e.a(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return d.a(this, animationVector, animationVector2, animationVector3);
    }

    @NotNull
    public V getValueFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        int access$clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j11 / 1000000);
        if (this.keyframes.containsKey(Integer.valueOf(access$clampPlayTime))) {
            return (AnimationVector) ((Pair) MapsKt__MapsKt.getValue(this.keyframes, Integer.valueOf(access$clampPlayTime))).getFirst();
        }
        if (access$clampPlayTime >= getDurationMillis()) {
            return v12;
        }
        if (access$clampPlayTime <= 0) {
            return v11;
        }
        int durationMillis2 = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i11 = 0;
        V v14 = v11;
        int i12 = 0;
        for (Map.Entry next : this.keyframes.entrySet()) {
            int intValue = ((Number) next.getKey()).intValue();
            Pair pair = (Pair) next.getValue();
            if (access$clampPlayTime > intValue && intValue >= i12) {
                v14 = (AnimationVector) pair.getFirst();
                linearEasing = (Easing) pair.getSecond();
                i12 = intValue;
            } else if (access$clampPlayTime < intValue && intValue <= durationMillis2) {
                v12 = (AnimationVector) pair.getFirst();
                durationMillis2 = intValue;
            }
        }
        float transform = linearEasing.transform(((float) (access$clampPlayTime - i12)) / ((float) (durationMillis2 - i12)));
        init(v11);
        int size$animation_core_release = v14.getSize$animation_core_release();
        while (true) {
            V v15 = null;
            if (i11 >= size$animation_core_release) {
                break;
            }
            V v16 = this.valueVector;
            if (v16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            } else {
                v15 = v16;
            }
            v15.set$animation_core_release(i11, VectorConvertersKt.lerp(v14.get$animation_core_release(i11), v12.get$animation_core_release(i11), transform));
            i11++;
        }
        V v17 = this.valueVector;
        if (v17 != null) {
            return v17;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @NotNull
    public V getVelocityFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        long access$clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j11 / 1000000);
        if (access$clampPlayTime <= 0) {
            return v13;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, access$clampPlayTime - 1, v11, v12, v13);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, access$clampPlayTime, v11, v12, v13);
        init(v11);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        int i11 = 0;
        while (true) {
            V v14 = null;
            if (i11 >= size$animation_core_release) {
                break;
            }
            V v15 = this.velocityVector;
            if (v15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            } else {
                v14 = v15;
            }
            v14.set$animation_core_release(i11, (valueFromMillis.get$animation_core_release(i11) - valueFromMillis2.get$animation_core_release(i11)) * 1000.0f);
            i11++;
        }
        V v16 = this.velocityVector;
        if (v16 != null) {
            return v16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    public /* synthetic */ boolean isInfinite() {
        return f.a(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i11, (i13 & 4) != 0 ? 0 : i12);
    }
}
