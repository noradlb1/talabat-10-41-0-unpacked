package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/authentication/natives/Backoff;", "", "delay", "", "Exponential", "Linear", "Lcom/talabat/authentication/natives/Backoff$Linear;", "Lcom/talabat/authentication/natives/Backoff$Exponential;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Backoff {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/authentication/natives/Backoff$Linear;", "Lcom/talabat/authentication/natives/Backoff;", "delay", "", "(J)V", "getDelay", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Linear implements Backoff {
        private final long delay;

        public Linear(long j11) {
            this.delay = j11;
        }

        public static /* synthetic */ Linear copy$default(Linear linear, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = linear.delay;
            }
            return linear.copy(j11);
        }

        public final long component1() {
            return this.delay;
        }

        @NotNull
        public final Linear copy(long j11) {
            return new Linear(j11);
        }

        public long delay() {
            return this.delay;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Linear) && this.delay == ((Linear) obj).delay;
        }

        public final long getDelay() {
            return this.delay;
        }

        public int hashCode() {
            return a.a(this.delay);
        }

        @NotNull
        public String toString() {
            long j11 = this.delay;
            return "Linear(delay=" + j11 + ")";
        }
    }

    long delay();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/talabat/authentication/natives/Backoff$Exponential;", "Lcom/talabat/authentication/natives/Backoff;", "delay", "", "maxDelay", "factor", "", "(JJD)V", "getDelay", "()J", "setDelay", "(J)V", "getFactor", "()D", "getMaxDelay", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Exponential implements Backoff {
        private long delay;
        private final double factor;
        private final long maxDelay;

        public Exponential() {
            this(0, 0, 0.0d, 7, (DefaultConstructorMarker) null);
        }

        public Exponential(long j11, long j12, double d11) {
            this.delay = j11;
            this.maxDelay = j12;
            this.factor = d11;
        }

        public static /* synthetic */ Exponential copy$default(Exponential exponential, long j11, long j12, double d11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = exponential.delay;
            }
            long j13 = j11;
            if ((i11 & 2) != 0) {
                j12 = exponential.maxDelay;
            }
            long j14 = j12;
            if ((i11 & 4) != 0) {
                d11 = exponential.factor;
            }
            return exponential.copy(j13, j14, d11);
        }

        public final long component1() {
            return this.delay;
        }

        public final long component2() {
            return this.maxDelay;
        }

        public final double component3() {
            return this.factor;
        }

        @NotNull
        public final Exponential copy(long j11, long j12, double d11) {
            return new Exponential(j11, j12, d11);
        }

        public long delay() {
            long coerceAtMost = RangesKt___RangesKt.coerceAtMost((long) (((double) this.delay) * this.factor), this.maxDelay);
            this.delay = coerceAtMost;
            return coerceAtMost;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Exponential)) {
                return false;
            }
            Exponential exponential = (Exponential) obj;
            return this.delay == exponential.delay && this.maxDelay == exponential.maxDelay && Intrinsics.areEqual((Object) Double.valueOf(this.factor), (Object) Double.valueOf(exponential.factor));
        }

        public final long getDelay() {
            return this.delay;
        }

        public final double getFactor() {
            return this.factor;
        }

        public final long getMaxDelay() {
            return this.maxDelay;
        }

        public int hashCode() {
            return (((a.a(this.delay) * 31) + a.a(this.maxDelay)) * 31) + Double.doubleToLongBits(this.factor);
        }

        public final void setDelay(long j11) {
            this.delay = j11;
        }

        @NotNull
        public String toString() {
            long j11 = this.delay;
            long j12 = this.maxDelay;
            double d11 = this.factor;
            return "Exponential(delay=" + j11 + ", maxDelay=" + j12 + ", factor=" + d11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Exponential(long j11, long j12, double d11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 50 : j11, (i11 & 2) != 0 ? 1000 : j12, (i11 & 4) != 0 ? 2.0d : d11);
        }
    }
}
