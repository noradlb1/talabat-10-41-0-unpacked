package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.runtime.Stable;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u00022\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0007\u001a4\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001aK\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0019\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0015H\u0007\u001a9\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001c\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010!\u001a2\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020#\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010$\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020&H\u0007\u001a9\u0010'\u001a\u0004\u0018\u0001H(\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010(*\u00020)*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0*2\b\u0010+\u001a\u0004\u0018\u0001H\u0002H\u0002¢\u0006\u0002\u0010,\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"infiniteRepeatable", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "T", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "infiniteRepeatable-9IiC70o", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "keyframes", "Landroidx/compose/animation/core/KeyframesSpec;", "init", "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "Lkotlin/ExtensionFunctionType;", "repeatable", "Landroidx/compose/animation/core/RepeatableSpec;", "iterations", "", "repeatable-91I0pcU", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/RepeatableSpec;", "snap", "Landroidx/compose/animation/core/SnapSpec;", "delayMillis", "spring", "Landroidx/compose/animation/core/SpringSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "tween", "Landroidx/compose/animation/core/TweenSpec;", "durationMillis", "easing", "Landroidx/compose/animation/core/Easing;", "convert", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnimationSpecKt {
    /* access modifiers changed from: private */
    public static final <T, V extends AnimationVector> V convert(TwoWayConverter<T, V> twoWayConverter, T t11) {
        if (t11 == null) {
            return null;
        }
        return (AnimationVector) twoWayConverter.getConvertToVector().invoke(t11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the infinite repeatable function that accepts start offset.")
    @Stable
    public static final /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode) {
        Intrinsics.checkNotNullParameter(durationBasedAnimationSpec, Param.ANIMATION);
        Intrinsics.checkNotNullParameter(repeatMode, Param.REPEAT_MODE);
        return new InfiniteRepeatableSpec(durationBasedAnimationSpec, repeatMode, StartOffset.m131constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InfiniteRepeatableSpec infiniteRepeatable$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        return infiniteRepeatable(durationBasedAnimationSpec, repeatMode);
    }

    @NotNull
    @Stable
    /* renamed from: infiniteRepeatable-9IiC70o  reason: not valid java name */
    public static final <T> InfiniteRepeatableSpec<T> m109infiniteRepeatable9IiC70o(@NotNull DurationBasedAnimationSpec<T> durationBasedAnimationSpec, @NotNull RepeatMode repeatMode, long j11) {
        Intrinsics.checkNotNullParameter(durationBasedAnimationSpec, Param.ANIMATION);
        Intrinsics.checkNotNullParameter(repeatMode, Param.REPEAT_MODE);
        return new InfiniteRepeatableSpec((DurationBasedAnimationSpec) durationBasedAnimationSpec, repeatMode, j11, (DefaultConstructorMarker) null);
    }

    /* renamed from: infiniteRepeatable-9IiC70o$default  reason: not valid java name */
    public static /* synthetic */ InfiniteRepeatableSpec m110infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i11 & 4) != 0) {
            j11 = StartOffset.m131constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null);
        }
        return m109infiniteRepeatable9IiC70o(durationBasedAnimationSpec, repeatMode, j11);
    }

    @NotNull
    @Stable
    public static final <T> KeyframesSpec<T> keyframes(@NotNull Function1<? super KeyframesSpec.KeyframesSpecConfig<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        function1.invoke(keyframesSpecConfig);
        return new KeyframesSpec<>(keyframesSpecConfig);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the repeatable function that accepts start offset.")
    @Stable
    public static final /* synthetic */ RepeatableSpec repeatable(int i11, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode) {
        Intrinsics.checkNotNullParameter(durationBasedAnimationSpec, Param.ANIMATION);
        Intrinsics.checkNotNullParameter(repeatMode, Param.REPEAT_MODE);
        return new RepeatableSpec(i11, durationBasedAnimationSpec, repeatMode, StartOffset.m131constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RepeatableSpec repeatable$default(int i11, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        return repeatable(i11, durationBasedAnimationSpec, repeatMode);
    }

    @NotNull
    @Stable
    /* renamed from: repeatable-91I0pcU  reason: not valid java name */
    public static final <T> RepeatableSpec<T> m111repeatable91I0pcU(int i11, @NotNull DurationBasedAnimationSpec<T> durationBasedAnimationSpec, @NotNull RepeatMode repeatMode, long j11) {
        Intrinsics.checkNotNullParameter(durationBasedAnimationSpec, Param.ANIMATION);
        Intrinsics.checkNotNullParameter(repeatMode, Param.REPEAT_MODE);
        return new RepeatableSpec(i11, (DurationBasedAnimationSpec) durationBasedAnimationSpec, repeatMode, j11, (DefaultConstructorMarker) null);
    }

    /* renamed from: repeatable-91I0pcU$default  reason: not valid java name */
    public static /* synthetic */ RepeatableSpec m112repeatable91I0pcU$default(int i11, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i12 & 8) != 0) {
            j11 = StartOffset.m131constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null);
        }
        return m111repeatable91I0pcU(i11, durationBasedAnimationSpec, repeatMode, j11);
    }

    @NotNull
    @Stable
    public static final <T> SnapSpec<T> snap(int i11) {
        return new SnapSpec<>(i11);
    }

    public static /* synthetic */ SnapSpec snap$default(int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return snap(i11);
    }

    @NotNull
    @Stable
    public static final <T> SpringSpec<T> spring(float f11, float f12, @Nullable T t11) {
        return new SpringSpec<>(f11, f12, t11);
    }

    public static /* synthetic */ SpringSpec spring$default(float f11, float f12, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 1500.0f;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        return spring(f11, f12, obj);
    }

    @NotNull
    @Stable
    public static final <T> TweenSpec<T> tween(int i11, int i12, @NotNull Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new TweenSpec<>(i11, i12, easing);
    }

    public static /* synthetic */ TweenSpec tween$default(int i11, int i12, Easing easing, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 300;
        }
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        if ((i13 & 4) != 0) {
            easing = EasingKt.getFastOutSlowInEasing();
        }
        return tween(i11, i12, easing);
    }
}
