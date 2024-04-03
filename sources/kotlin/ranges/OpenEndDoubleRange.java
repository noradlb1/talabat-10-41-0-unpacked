package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "(DD)V", "_endExclusive", "_start", "getEndExclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    private final double _endExclusive;
    private final double _start;

    public OpenEndDoubleRange(double d11, double d12) {
        this._start = d11;
        this._endExclusive = d12;
    }

    private final boolean lessThanOrEquals(double d11, double d12) {
        return d11 <= d12;
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).doubleValue());
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        if (!(obj instanceof OpenEndDoubleRange)) {
            return false;
        }
        if (!isEmpty() || !((OpenEndDoubleRange) obj).isEmpty()) {
            OpenEndDoubleRange openEndDoubleRange = (OpenEndDoubleRange) obj;
            if (this._start == openEndDoubleRange._start) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return false;
            }
            if (this._endExclusive == openEndDoubleRange._endExclusive) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this._start).hashCode() * 31) + Double.valueOf(this._endExclusive).hashCode();
    }

    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    @NotNull
    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }

    public boolean contains(double d11) {
        return d11 >= this._start && d11 < this._endExclusive;
    }

    @NotNull
    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    @NotNull
    public Double getStart() {
        return Double.valueOf(this._start);
    }
}
