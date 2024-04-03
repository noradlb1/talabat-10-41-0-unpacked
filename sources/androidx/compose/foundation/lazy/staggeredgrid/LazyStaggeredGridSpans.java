package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans;", "", "()V", "anchor", "", "spans", "", "ensureCapacity", "", "capacity", "newOffset", "ensureValidIndex", "requestedIndex", "findNextItemIndex", "item", "target", "findPreviousItemIndex", "getSpan", "lowerBound", "reset", "setSpan", "span", "upperBound", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridSpans {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;
    @NotNull
    private int[] spans = new int[16];

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans$Companion;", "", "()V", "MaxCapacity", "", "Unset", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void a(LazyStaggeredGridSpans lazyStaggeredGridSpans, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        lazyStaggeredGridSpans.ensureCapacity(i11, i12);
    }

    private final void ensureCapacity(int i11, int i12) {
        boolean z11;
        if (i11 <= 131072) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int[] iArr = this.spans;
            if (iArr.length < i11) {
                int length = iArr.length;
                while (length < i11) {
                    length *= 2;
                }
                this.spans = ArraysKt___ArraysJvmKt.copyInto$default(this.spans, new int[length], i12, 0, 0, 12, (Object) null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Requested span capacity " + i11 + " is larger than max supported: 131072!").toString());
    }

    public final void ensureValidIndex(int i11) {
        boolean z11;
        int i12 = this.anchor;
        int i13 = i11 - i12;
        if (i13 < 0 || i13 >= 131072) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            a(this, i13 + 1, 0, 2, (Object) null);
            return;
        }
        int max = Math.max(i11 - (this.spans.length / 2), 0);
        this.anchor = max;
        int i14 = max - i12;
        if (i14 >= 0) {
            int[] iArr = this.spans;
            if (i14 < iArr.length) {
                int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, 0, i14, iArr.length);
            }
            int[] iArr2 = this.spans;
            ArraysKt___ArraysJvmKt.fill(iArr2, 0, Math.max(0, iArr2.length - i14), this.spans.length);
            return;
        }
        int i15 = -i14;
        int[] iArr3 = this.spans;
        if (iArr3.length + i15 < 131072) {
            ensureCapacity(iArr3.length + i15 + 1, i15);
            return;
        }
        if (i15 < iArr3.length) {
            int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(iArr3, iArr3, i15, 0, iArr3.length - i15);
        }
        int[] iArr4 = this.spans;
        ArraysKt___ArraysJvmKt.fill(iArr4, 0, 0, Math.min(iArr4.length, i15));
    }

    public final int findNextItemIndex(int i11, int i12) {
        int upperBound = upperBound();
        for (int i13 = i11 + 1; i13 < upperBound; i13++) {
            int span = getSpan(i13);
            if (span == i12 || span == -1) {
                return i13;
            }
        }
        return upperBound();
    }

    public final int findPreviousItemIndex(int i11, int i12) {
        while (true) {
            i11--;
            if (-1 >= i11) {
                return -1;
            }
            int span = getSpan(i11);
            if (span == i12 || span == -1) {
                return i11;
            }
        }
        return i11;
    }

    public final int getSpan(int i11) {
        if (i11 < lowerBound() || i11 >= upperBound()) {
            return -1;
        }
        return this.spans[i11 - this.anchor] - 1;
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void reset() {
        ArraysKt___ArraysJvmKt.fill$default(this.spans, 0, 0, 0, 6, (Object) null);
    }

    public final void setSpan(int i11, int i12) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ensureValidIndex(i11);
            this.spans[i11 - this.anchor] = i12 + 1;
            return;
        }
        throw new IllegalArgumentException("Negative spans are not supported".toString());
    }

    public final int upperBound() {
        return this.anchor + this.spans.length;
    }
}
