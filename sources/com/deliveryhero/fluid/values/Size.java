package com.deliveryhero.fluid.values;

import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/values/Size;", "", "Absolute", "MatchParent", "Relative", "WrapContent", "Lcom/deliveryhero/fluid/values/Size$MatchParent;", "Lcom/deliveryhero/fluid/values/Size$WrapContent;", "Lcom/deliveryhero/fluid/values/Size$Relative;", "Lcom/deliveryhero/fluid/values/Size$Absolute;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public interface Size {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/values/Size$Absolute;", "Lcom/deliveryhero/fluid/values/Size;", "value", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "(Lcom/deliveryhero/fluid/values/LogicalPixel;)V", "getValue", "()Lcom/deliveryhero/fluid/values/LogicalPixel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    public static final class Absolute implements Size {
        @NotNull
        private final LogicalPixel value;

        public Absolute(@NotNull LogicalPixel logicalPixel) {
            boolean z11;
            Intrinsics.checkNotNullParameter(logicalPixel, "value");
            this.value = logicalPixel;
            if (logicalPixel.getValue() >= 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException("Absolute size must be positive".toString());
            }
        }

        public static /* synthetic */ Absolute copy$default(Absolute absolute, LogicalPixel logicalPixel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                logicalPixel = absolute.value;
            }
            return absolute.copy(logicalPixel);
        }

        @NotNull
        public final LogicalPixel component1() {
            return this.value;
        }

        @NotNull
        public final Absolute copy(@NotNull LogicalPixel logicalPixel) {
            Intrinsics.checkNotNullParameter(logicalPixel, "value");
            return new Absolute(logicalPixel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Absolute) && Intrinsics.areEqual((Object) this.value, (Object) ((Absolute) obj).value);
        }

        @NotNull
        public final LogicalPixel getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "Absolute(value=" + this.value + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/fluid/values/Size$MatchParent;", "Lcom/deliveryhero/fluid/values/Size;", "()V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    public static final class MatchParent implements Size {
        @NotNull
        public static final MatchParent INSTANCE = new MatchParent();

        private MatchParent() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/values/Size$Relative;", "Lcom/deliveryhero/fluid/values/Size;", "percent", "", "(I)V", "getPercent", "()I", "percentFractional", "", "getPercentFractional", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    public static final class Relative implements Size {
        private final int percent;

        public Relative(int i11) {
            this.percent = i11;
            boolean z11 = false;
            if (i11 >= 0 && i11 < 101) {
                z11 = true;
            }
            if (!z11) {
                throw new IllegalArgumentException("Percent must be in [0, 100] range".toString());
            }
        }

        public static /* synthetic */ Relative copy$default(Relative relative, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = relative.percent;
            }
            return relative.copy(i11);
        }

        public final int component1() {
            return this.percent;
        }

        @NotNull
        public final Relative copy(int i11) {
            return new Relative(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Relative) && this.percent == ((Relative) obj).percent;
        }

        public final int getPercent() {
            return this.percent;
        }

        public final float getPercentFractional() {
            return ((float) this.percent) / 100.0f;
        }

        public int hashCode() {
            return this.percent;
        }

        @NotNull
        public String toString() {
            return "Relative(percent=" + this.percent + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/fluid/values/Size$WrapContent;", "Lcom/deliveryhero/fluid/values/Size;", "()V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @CoreContract.CreatedOn(version = CoreContract.Version.V1)
    public static final class WrapContent implements Size {
        @NotNull
        public static final WrapContent INSTANCE = new WrapContent();

        private WrapContent() {
        }
    }
}
