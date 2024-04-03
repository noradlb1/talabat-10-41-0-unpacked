package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004BK\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010*\u001a\u00020+H\u0016R&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n8F@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n8F@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@PX\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR&\u0010$\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u0001@@X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Landroidx/compose/animation/core/AnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)V", "<set-?>", "getFinishedTimeNanos", "()J", "setFinishedTimeNanos$animation_core_release", "(J)V", "()Z", "setRunning$animation_core_release", "(Z)V", "getLastFrameTimeNanos", "setLastFrameTimeNanos$animation_core_release", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "()Ljava/lang/Object;", "setValue$animation_core_release", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core_release", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimationState<T, V extends AnimationVector> implements State<T> {
    public static final int $stable = 0;
    private long finishedTimeNanos;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    @NotNull
    private final TwoWayConverter<T, V> typeConverter;
    @NotNull
    private final MutableState value$delegate;
    @NotNull
    private V velocityVector;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r5 = androidx.compose.animation.core.AnimationVectorsKt.copy(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AnimationState(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.TwoWayConverter<T, V> r3, T r4, @org.jetbrains.annotations.Nullable V r5, long r6, long r8, boolean r10) {
        /*
            r2 = this;
            java.lang.String r0 = "typeConverter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            r2.typeConverter = r3
            r0 = 0
            r1 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r0, r1, r0)
            r2.value$delegate = r0
            if (r5 == 0) goto L_0x001a
            androidx.compose.animation.core.AnimationVector r5 = androidx.compose.animation.core.AnimationVectorsKt.copy(r5)
            if (r5 != 0) goto L_0x001e
        L_0x001a:
            androidx.compose.animation.core.AnimationVector r5 = androidx.compose.animation.core.AnimationStateKt.createZeroVectorFrom(r3, r4)
        L_0x001e:
            r2.velocityVector = r5
            r2.lastFrameTimeNanos = r6
            r2.finishedTimeNanos = r8
            r2.isRunning = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimationState.<init>(androidx.compose.animation.core.TwoWayConverter, java.lang.Object, androidx.compose.animation.core.AnimationVector, long, long, boolean):void");
    }

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    @NotNull
    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public T getValue() {
        return this.value$delegate.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    @NotNull
    public final V getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setFinishedTimeNanos$animation_core_release(long j11) {
        this.finishedTimeNanos = j11;
    }

    public final void setLastFrameTimeNanos$animation_core_release(long j11) {
        this.lastFrameTimeNanos = j11;
    }

    public final void setRunning$animation_core_release(boolean z11) {
        this.isRunning = z11;
    }

    public void setValue$animation_core_release(T t11) {
        this.value$delegate.setValue(t11);
    }

    public final void setVelocityVector$animation_core_release(@NotNull V v11) {
        Intrinsics.checkNotNullParameter(v11, "<set-?>");
        this.velocityVector = v11;
    }

    @NotNull
    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnimationState(TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector, long j11, long j12, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(twoWayConverter, obj, (i11 & 4) != 0 ? null : animationVector, (i11 & 8) != 0 ? Long.MIN_VALUE : j11, (i11 & 16) != 0 ? Long.MIN_VALUE : j12, (i11 & 32) != 0 ? false : z11);
    }
}
