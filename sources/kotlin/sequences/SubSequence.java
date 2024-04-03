package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    /* access modifiers changed from: private */
    public final int endIndex;
    /* access modifiers changed from: private */
    @NotNull
    public final Sequence<T> sequence;
    /* access modifiers changed from: private */
    public final int startIndex;

    public SubSequence(@NotNull Sequence<? extends T> sequence2, int i11, int i12) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(sequence2, "sequence");
        this.sequence = sequence2;
        this.startIndex = i11;
        this.endIndex = i12;
        boolean z13 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i12 >= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (!(i12 < i11 ? false : z13)) {
                    throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i12 + " < " + i11).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i12).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i11).toString());
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @NotNull
    public Sequence<T> drop(int i11) {
        return i11 >= getCount() ? SequencesKt__SequencesKt.emptySequence() : new SubSequence(this.sequence, this.startIndex + i11, this.endIndex);
    }

    @NotNull
    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }

    @NotNull
    public Sequence<T> take(int i11) {
        if (i11 >= getCount()) {
            return this;
        }
        Sequence<T> sequence2 = this.sequence;
        int i12 = this.startIndex;
        return new SubSequence(sequence2, i12, i11 + i12);
    }
}
