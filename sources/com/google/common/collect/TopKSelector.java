package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* renamed from: k  reason: collision with root package name */
    private final int f44642k;
    @CheckForNull
    private T threshold;

    private TopKSelector(Comparator<? super T> comparator2, int i11) {
        boolean z11;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2, "comparator");
        this.f44642k = i11;
        boolean z12 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "k (%s) must be >= 0", i11);
        Preconditions.checkArgument(i11 > 1073741823 ? false : z12, "k (%s) must be <= Integer.MAX_VALUE / 2", i11);
        this.buffer = new Object[IntMath.checkedMultiply(i11, 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i11) {
        return greatest(i11, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i11) {
        return least(i11, Ordering.natural());
    }

    private int partition(int i11, int i12, int i13) {
        T uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i13]);
        T[] tArr = this.buffer;
        tArr[i13] = tArr[i12];
        int i14 = i11;
        while (i11 < i12) {
            if (this.comparator.compare(NullnessCasts.uncheckedCastNullableTToT(this.buffer[i11]), uncheckedCastNullableTToT) < 0) {
                swap(i14, i11);
                i14++;
            }
            i11++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i12] = tArr2[i14];
        tArr2[i14] = uncheckedCastNullableTToT;
        return i14;
    }

    private void swap(int i11, int i12) {
        T[] tArr = this.buffer;
        T t11 = tArr[i11];
        tArr[i11] = tArr[i12];
        tArr[i12] = t11;
    }

    private void trim() {
        int i11 = (this.f44642k * 2) - 1;
        int log2 = IntMath.log2(i11 + 0, RoundingMode.CEILING) * 3;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i12 < i11) {
                int partition = partition(i12, i11, ((i12 + i11) + 1) >>> 1);
                int i15 = this.f44642k;
                if (partition <= i15) {
                    if (partition >= i15) {
                        break;
                    }
                    i12 = Math.max(partition, i12 + 1);
                    i14 = partition;
                } else {
                    i11 = partition - 1;
                }
                i13++;
                if (i13 >= log2) {
                    Arrays.sort(this.buffer, i12, i11 + 1, this.comparator);
                    break;
                }
            } else {
                break;
            }
        }
        this.bufferSize = this.f44642k;
        this.threshold = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i14]);
        while (true) {
            i14++;
            if (i14 >= this.f44642k) {
                return;
            }
            if (this.comparator.compare(NullnessCasts.uncheckedCastNullableTToT(this.buffer[i14]), NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = this.buffer[i14];
            }
        }
    }

    public void offer(@ParametricNullness T t11) {
        int i11 = this.f44642k;
        if (i11 != 0) {
            int i12 = this.bufferSize;
            if (i12 == 0) {
                this.buffer[0] = t11;
                this.threshold = t11;
                this.bufferSize = 1;
            } else if (i12 < i11) {
                T[] tArr = this.buffer;
                this.bufferSize = i12 + 1;
                tArr[i12] = t11;
                if (this.comparator.compare(t11, NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                    this.threshold = t11;
                }
            } else if (this.comparator.compare(t11, NullnessCasts.uncheckedCastNullableTToT(this.threshold)) < 0) {
                T[] tArr2 = this.buffer;
                int i13 = this.bufferSize;
                int i14 = i13 + 1;
                this.bufferSize = i14;
                tArr2[i13] = t11;
                if (i14 == this.f44642k * 2) {
                    trim();
                }
            }
        }
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public List<T> topK() {
        T[] tArr = this.buffer;
        Arrays.sort(tArr, 0, this.bufferSize, this.comparator);
        int i11 = this.bufferSize;
        int i12 = this.f44642k;
        if (i11 > i12) {
            T[] tArr2 = this.buffer;
            Arrays.fill(tArr2, i12, tArr2.length, (Object) null);
            int i13 = this.f44642k;
            this.bufferSize = i13;
            this.threshold = this.buffer[i13 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.bufferSize)));
    }

    public static <T> TopKSelector<T> greatest(int i11, Comparator<? super T> comparator2) {
        return new TopKSelector<>(Ordering.from(comparator2).reverse(), i11);
    }

    public static <T> TopKSelector<T> least(int i11, Comparator<? super T> comparator2) {
        return new TopKSelector<>(comparator2, i11);
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }
}
