package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import m.f;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(Landroidx/compose/animation/core/Animations;)V", "endVelocityVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    @NotNull
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatAnimationSpec(@NotNull Animations animations) {
        Intrinsics.checkNotNullParameter(animations, "anims");
        this.anims = animations;
    }

    public long getDurationNanos(@NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        Iterator it = RangesKt___RangesKt.until(0, v11.getSize$animation_core_release()).iterator();
        long j11 = 0;
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            j11 = Math.max(j11, this.anims.get(nextInt).getDurationNanos(v11.get$animation_core_release(nextInt), v12.get$animation_core_release(nextInt), v13.get$animation_core_release(nextInt)));
        }
        return j11;
    }

    @NotNull
    public V getEndVelocity(@NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        if (this.endVelocityVector == null) {
            this.endVelocityVector = AnimationVectorsKt.newInstance(v13);
        }
        V v14 = this.endVelocityVector;
        if (v14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            v14 = null;
        }
        int size$animation_core_release = v14.getSize$animation_core_release();
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            V v15 = this.endVelocityVector;
            if (v15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                v15 = null;
            }
            v15.set$animation_core_release(i11, this.anims.get(i11).getEndVelocity(v11.get$animation_core_release(i11), v12.get$animation_core_release(i11), v13.get$animation_core_release(i11)));
        }
        V v16 = this.endVelocityVector;
        if (v16 != null) {
            return v16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        return null;
    }

    @NotNull
    public V getValueFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        V v14 = v11;
        V v15 = v12;
        V v16 = v13;
        Intrinsics.checkNotNullParameter(v14, "initialValue");
        Intrinsics.checkNotNullParameter(v15, "targetValue");
        Intrinsics.checkNotNullParameter(v16, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v11);
        }
        V v17 = this.valueVector;
        if (v17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v17 = null;
        }
        int size$animation_core_release = v17.getSize$animation_core_release();
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            V v18 = this.valueVector;
            if (v18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v18 = null;
            }
            v18.set$animation_core_release(i11, this.anims.get(i11).getValueFromNanos(j11, v14.get$animation_core_release(i11), v15.get$animation_core_release(i11), v16.get$animation_core_release(i11)));
        }
        V v19 = this.valueVector;
        if (v19 != null) {
            return v19;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @NotNull
    public V getVelocityFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        V v14 = v11;
        V v15 = v12;
        V v16 = v13;
        Intrinsics.checkNotNullParameter(v14, "initialValue");
        Intrinsics.checkNotNullParameter(v15, "targetValue");
        Intrinsics.checkNotNullParameter(v16, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(v13);
        }
        V v17 = this.velocityVector;
        if (v17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v17 = null;
        }
        int size$animation_core_release = v17.getSize$animation_core_release();
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            V v18 = this.velocityVector;
            if (v18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v18 = null;
            }
            v18.set$animation_core_release(i11, this.anims.get(i11).getVelocityFromNanos(j11, v14.get$animation_core_release(i11), v15.get$animation_core_release(i11), v16.get$animation_core_release(i11)));
        }
        V v19 = this.velocityVector;
        if (v19 != null) {
            return v19;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    public /* synthetic */ boolean isInfinite() {
        return f.a(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VectorizedFloatAnimationSpec(@NotNull final FloatAnimationSpec floatAnimationSpec) {
        this((Animations) new Animations() {
            @NotNull
            public FloatAnimationSpec get(int i11) {
                return floatAnimationSpec;
            }
        });
        Intrinsics.checkNotNullParameter(floatAnimationSpec, "anim");
    }
}
