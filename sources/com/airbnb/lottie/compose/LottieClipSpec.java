package com.airbnb.lottie.compose;

import androidx.compose.runtime.internal.StabilityInferred;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H ¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H ¢\u0006\u0002\b\t\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec;", "", "()V", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "Frame", "Marker", "Markers", "Progress", "Lcom/airbnb/lottie/compose/LottieClipSpec$Frame;", "Lcom/airbnb/lottie/compose/LottieClipSpec$Progress;", "Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "Lcom/airbnb/lottie/compose/LottieClipSpec$Marker;", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class LottieClipSpec {
    public static final int $stable = 0;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J0\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006!"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Frame;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "min", "", "max", "maxInclusive", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "actualMaxFrame", "Ljava/lang/Integer;", "getMax", "()Ljava/lang/Integer;", "getMaxInclusive", "()Z", "getMin", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/airbnb/lottie/compose/LottieClipSpec$Frame;", "equals", "other", "", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "toString", "", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Frame extends LottieClipSpec {
        public static final int $stable = 0;
        @Nullable
        private final Integer actualMaxFrame;
        @Nullable
        private final Integer max;
        private final boolean maxInclusive;
        @Nullable
        private final Integer min;

        public Frame() {
            this((Integer) null, (Integer) null, false, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Frame(Integer num, Integer num2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2, (i11 & 4) != 0 ? true : z11);
        }

        public static /* synthetic */ Frame copy$default(Frame frame, Integer num, Integer num2, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = frame.min;
            }
            if ((i11 & 2) != 0) {
                num2 = frame.max;
            }
            if ((i11 & 4) != 0) {
                z11 = frame.maxInclusive;
            }
            return frame.copy(num, num2, z11);
        }

        @Nullable
        public final Integer component1() {
            return this.min;
        }

        @Nullable
        public final Integer component2() {
            return this.max;
        }

        public final boolean component3() {
            return this.maxInclusive;
        }

        @NotNull
        public final Frame copy(@Nullable Integer num, @Nullable Integer num2, boolean z11) {
            return new Frame(num, num2, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Frame)) {
                return false;
            }
            Frame frame = (Frame) obj;
            return Intrinsics.areEqual((Object) this.min, (Object) frame.min) && Intrinsics.areEqual((Object) this.max, (Object) frame.max) && this.maxInclusive == frame.maxInclusive;
        }

        @Nullable
        public final Integer getMax() {
            return this.max;
        }

        public final boolean getMaxInclusive() {
            return this.maxInclusive;
        }

        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            Integer num = this.actualMaxFrame;
            if (num == null) {
                return 1.0f;
            }
            return RangesKt___RangesKt.coerceIn(((float) num.intValue()) / lottieComposition.getEndFrame(), 0.0f, 1.0f);
        }

        @Nullable
        public final Integer getMin() {
            return this.min;
        }

        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            Integer num = this.min;
            if (num == null) {
                return 0.0f;
            }
            return RangesKt___RangesKt.coerceIn(((float) num.intValue()) / lottieComposition.getEndFrame(), 0.0f, 1.0f);
        }

        public int hashCode() {
            Integer num = this.min;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.max;
            if (num2 != null) {
                i11 = num2.hashCode();
            }
            int i12 = (hashCode + i11) * 31;
            boolean z11 = this.maxInclusive;
            if (z11) {
                z11 = true;
            }
            return i12 + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            return "Frame(min=" + this.min + ", max=" + this.max + ", maxInclusive=" + this.maxInclusive + ')';
        }

        public Frame(@Nullable Integer num, @Nullable Integer num2, boolean z11) {
            super((DefaultConstructorMarker) null);
            this.min = num;
            this.max = num2;
            this.maxInclusive = z11;
            if (num2 == null) {
                num2 = null;
            } else if (!z11) {
                num2 = Integer.valueOf(num2.intValue() - 1);
            }
            this.actualMaxFrame = num2;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Marker;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "marker", "", "(Ljava/lang/String;)V", "getMarker", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "", "toString", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Marker extends LottieClipSpec {
        public static final int $stable = 0;
        @NotNull
        private final String marker;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Marker(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "marker");
            this.marker = str;
        }

        public static /* synthetic */ Marker copy$default(Marker marker2, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = marker2.marker;
            }
            return marker2.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.marker;
        }

        @NotNull
        public final Marker copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "marker");
            return new Marker(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Marker) && Intrinsics.areEqual((Object) this.marker, (Object) ((Marker) obj).marker);
        }

        @NotNull
        public final String getMarker() {
            return this.marker;
        }

        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            com.airbnb.lottie.model.Marker marker2 = lottieComposition.getMarker(this.marker);
            if (marker2 == null) {
                return 1.0f;
            }
            return RangesKt___RangesKt.coerceIn((marker2.startFrame + marker2.durationFrames) / lottieComposition.getEndFrame(), 0.0f, 1.0f);
        }

        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            float f11;
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            com.airbnb.lottie.model.Marker marker2 = lottieComposition.getMarker(this.marker);
            if (marker2 == null) {
                f11 = 0.0f;
            } else {
                f11 = marker2.startFrame;
            }
            return RangesKt___RangesKt.coerceIn(f11 / lottieComposition.getEndFrame(), 0.0f, 1.0f);
        }

        public int hashCode() {
            return this.marker.hashCode();
        }

        @NotNull
        public String toString() {
            return "Marker(marker=" + this.marker + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0010¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0010¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "min", "", "max", "maxInclusive", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getMax", "()Ljava/lang/String;", "getMaxInclusive", "()Z", "getMin", "component1", "component2", "component3", "copy", "equals", "other", "", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "", "toString", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Markers extends LottieClipSpec {
        public static final int $stable = 0;
        @Nullable
        private final String max;
        private final boolean maxInclusive;
        @Nullable
        private final String min;

        public Markers() {
            this((String) null, (String) null, false, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Markers(String str, String str2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? true : z11);
        }

        public static /* synthetic */ Markers copy$default(Markers markers, String str, String str2, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = markers.min;
            }
            if ((i11 & 2) != 0) {
                str2 = markers.max;
            }
            if ((i11 & 4) != 0) {
                z11 = markers.maxInclusive;
            }
            return markers.copy(str, str2, z11);
        }

        @Nullable
        public final String component1() {
            return this.min;
        }

        @Nullable
        public final String component2() {
            return this.max;
        }

        public final boolean component3() {
            return this.maxInclusive;
        }

        @NotNull
        public final Markers copy(@Nullable String str, @Nullable String str2, boolean z11) {
            return new Markers(str, str2, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Markers)) {
                return false;
            }
            Markers markers = (Markers) obj;
            return Intrinsics.areEqual((Object) this.min, (Object) markers.min) && Intrinsics.areEqual((Object) this.max, (Object) markers.max) && this.maxInclusive == markers.maxInclusive;
        }

        @Nullable
        public final String getMax() {
            return this.max;
        }

        public final boolean getMaxInclusive() {
            return this.maxInclusive;
        }

        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            int i11;
            float f11;
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            String str = this.max;
            if (str == null) {
                return 1.0f;
            }
            if (this.maxInclusive) {
                i11 = 0;
            } else {
                i11 = -1;
            }
            com.airbnb.lottie.model.Marker marker = lottieComposition.getMarker(str);
            if (marker == null) {
                f11 = 0.0f;
            } else {
                f11 = marker.startFrame + ((float) i11);
            }
            return RangesKt___RangesKt.coerceIn(f11 / lottieComposition.getEndFrame(), 0.0f, 1.0f);
        }

        @Nullable
        public final String getMin() {
            return this.min;
        }

        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            float f11;
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            String str = this.min;
            if (str == null) {
                return 0.0f;
            }
            com.airbnb.lottie.model.Marker marker = lottieComposition.getMarker(str);
            if (marker == null) {
                f11 = 0.0f;
            } else {
                f11 = marker.startFrame;
            }
            return RangesKt___RangesKt.coerceIn(f11 / lottieComposition.getEndFrame(), 0.0f, 1.0f);
        }

        public int hashCode() {
            String str = this.min;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.max;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            int i12 = (hashCode + i11) * 31;
            boolean z11 = this.maxInclusive;
            if (z11) {
                z11 = true;
            }
            return i12 + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            return "Markers(min=" + this.min + ", max=" + this.max + ", maxInclusive=" + this.maxInclusive + ')';
        }

        public Markers(@Nullable String str, @Nullable String str2, boolean z11) {
            super((DefaultConstructorMarker) null);
            this.min = str;
            this.max = str2;
            this.maxInclusive = z11;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Progress;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "min", "", "max", "(FF)V", "getMax", "()F", "getMin", "component1", "component2", "copy", "equals", "", "other", "", "getMaxProgress", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "", "toString", "", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Progress extends LottieClipSpec {
        public static final int $stable = 0;
        private final float max;
        private final float min;

        public Progress() {
            this(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Progress(float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 1.0f : f12);
        }

        public static /* synthetic */ Progress copy$default(Progress progress, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = progress.min;
            }
            if ((i11 & 2) != 0) {
                f12 = progress.max;
            }
            return progress.copy(f11, f12);
        }

        public final float component1() {
            return this.min;
        }

        public final float component2() {
            return this.max;
        }

        @NotNull
        public final Progress copy(float f11, float f12) {
            return new Progress(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.min), (Object) Float.valueOf(progress.min)) && Intrinsics.areEqual((Object) Float.valueOf(this.max), (Object) Float.valueOf(progress.max));
        }

        public final float getMax() {
            return this.max;
        }

        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition) {
            Intrinsics.checkNotNullParameter(lottieComposition, "composition");
            return this.min;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.min) * 31) + Float.floatToIntBits(this.max);
        }

        @NotNull
        public String toString() {
            return "Progress(min=" + this.min + ", max=" + this.max + ')';
        }

        public Progress(float f11, float f12) {
            super((DefaultConstructorMarker) null);
            this.min = f11;
            this.max = f12;
        }
    }

    private LottieClipSpec() {
    }

    public /* synthetic */ LottieClipSpec(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition);

    public abstract float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition);
}
