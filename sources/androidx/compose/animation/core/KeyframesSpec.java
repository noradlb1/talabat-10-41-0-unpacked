package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0014\u0015B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\b\b\u0001\u0010\u0010*\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframeEntity", "KeyframesSpecConfig", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {
    @NotNull
    private final KeyframesSpecConfig<T> config;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f*\u00028\u00012\u0006\u0010\u0017\u001a\u00020\u0005H\u0004¢\u0006\u0002\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00028\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "T", "", "()V", "delayMillis", "", "getDelayMillis", "()I", "setDelayMillis", "(I)V", "durationMillis", "getDurationMillis", "setDurationMillis", "keyframes", "", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "getKeyframes$animation_core_release", "()Ljava/util/Map;", "equals", "", "other", "hashCode", "at", "timeStamp", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "with", "", "easing", "Landroidx/compose/animation/core/Easing;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KeyframesSpecConfig<T> {
        public static final int $stable = 8;
        private int delayMillis;
        private int durationMillis = 300;
        @NotNull
        private final Map<Integer, KeyframeEntity<T>> keyframes = new LinkedHashMap();

        @NotNull
        public final KeyframeEntity<T> at(T t11, int i11) {
            KeyframeEntity<T> keyframeEntity = new KeyframeEntity<>(t11, (Easing) null, 2, (DefaultConstructorMarker) null);
            this.keyframes.put(Integer.valueOf(i11), keyframeEntity);
            return keyframeEntity;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof KeyframesSpecConfig) {
                KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpecConfig) obj;
                if (this.delayMillis == keyframesSpecConfig.delayMillis && this.durationMillis == keyframesSpecConfig.durationMillis && Intrinsics.areEqual((Object) this.keyframes, (Object) keyframesSpecConfig.keyframes)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int getDelayMillis() {
            return this.delayMillis;
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        @NotNull
        public final Map<Integer, KeyframeEntity<T>> getKeyframes$animation_core_release() {
            return this.keyframes;
        }

        public int hashCode() {
            return (((this.durationMillis * 31) + this.delayMillis) * 31) + this.keyframes.hashCode();
        }

        public final void setDelayMillis(int i11) {
            this.delayMillis = i11;
        }

        public final void setDurationMillis(int i11) {
            this.durationMillis = i11;
        }

        public final void with(@NotNull KeyframeEntity<T> keyframeEntity, @NotNull Easing easing) {
            Intrinsics.checkNotNullParameter(keyframeEntity, "<this>");
            Intrinsics.checkNotNullParameter(easing, "easing");
            keyframeEntity.setEasing$animation_core_release(easing);
        }
    }

    public KeyframesSpec(@NotNull KeyframesSpecConfig<T> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.config = keyframesSpecConfig;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof KeyframesSpec) || !Intrinsics.areEqual((Object) this.config, (Object) ((KeyframesSpec) obj).config)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J7\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00050\u0014\"\b\b\u0002\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00150\u0018H\u0000¢\u0006\u0002\b\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "T", "", "value", "easing", "Landroidx/compose/animation/core/Easing;", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;)V", "getEasing$animation_core_release", "()Landroidx/compose/animation/core/Easing;", "setEasing$animation_core_release", "(Landroidx/compose/animation/core/Easing;)V", "getValue$animation_core_release", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toPair", "Lkotlin/Pair;", "V", "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "toPair$animation_core_release", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KeyframeEntity<T> {
        public static final int $stable = 8;
        @NotNull
        private Easing easing;
        private final T value;

        public KeyframeEntity(T t11, @NotNull Easing easing2) {
            Intrinsics.checkNotNullParameter(easing2, "easing");
            this.value = t11;
            this.easing = easing2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof KeyframeEntity) {
                KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
                return Intrinsics.areEqual((Object) keyframeEntity.value, (Object) this.value) && Intrinsics.areEqual((Object) keyframeEntity.easing, (Object) this.easing);
            }
        }

        @NotNull
        public final Easing getEasing$animation_core_release() {
            return this.easing;
        }

        public final T getValue$animation_core_release() {
            return this.value;
        }

        public int hashCode() {
            T t11 = this.value;
            return ((t11 != null ? t11.hashCode() : 0) * 31) + this.easing.hashCode();
        }

        public final void setEasing$animation_core_release(@NotNull Easing easing2) {
            Intrinsics.checkNotNullParameter(easing2, "<set-?>");
            this.easing = easing2;
        }

        @NotNull
        public final <V extends AnimationVector> Pair<V, Easing> toPair$animation_core_release(@NotNull Function1<? super T, ? extends V> function1) {
            Intrinsics.checkNotNullParameter(function1, "convertToVector");
            return TuplesKt.to(function1.invoke(this.value), this.easing);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ KeyframeEntity(Object obj, Easing easing2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i11 & 2) != 0 ? EasingKt.getLinearEasing() : easing2);
        }
    }

    @NotNull
    public <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        Map<Integer, KeyframeEntity<T>> keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(keyframes$animation_core_release.size()));
        for (Map.Entry entry : keyframes$animation_core_release.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((KeyframeEntity) entry.getValue()).toPair$animation_core_release(twoWayConverter.getConvertToVector()));
        }
        return new VectorizedKeyframesSpec<>(linkedHashMap, this.config.getDurationMillis(), this.config.getDelayMillis());
    }
}
