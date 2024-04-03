package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Immutable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\bø\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, (int[]) null);
    /* access modifiers changed from: private */
    @Nullable
    public final int[] belowBound;
    /* access modifiers changed from: private */
    public final int lowerBound;
    /* access modifiers changed from: private */
    public final long lowerSet;
    /* access modifiers changed from: private */
    public final long upperSet;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    private SnapshotIdSet(long j11, long j12, int i11, int[] iArr) {
        this.upperSet = j11;
        this.lowerSet = j12;
        this.lowerBound = i11;
        this.belowBound = iArr;
    }

    @NotNull
    public final SnapshotIdSet and(@NotNull SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        SnapshotIdSet snapshotIdSet2 = snapshotIdSet;
        Intrinsics.checkNotNullParameter(snapshotIdSet2, "bits");
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (Intrinsics.areEqual((Object) snapshotIdSet2, (Object) snapshotIdSet3) || Intrinsics.areEqual((Object) this, (Object) snapshotIdSet3)) {
            return snapshotIdSet3;
        }
        int i11 = snapshotIdSet2.lowerBound;
        int i12 = this.lowerBound;
        if (i11 == i12 && snapshotIdSet2.belowBound == (iArr = this.belowBound)) {
            long j11 = this.upperSet;
            long j12 = snapshotIdSet2.upperSet;
            long j13 = this.lowerSet;
            long j14 = snapshotIdSet2.lowerSet;
            long j15 = j13 & j14;
            if ((j11 & j12) == 0 && j15 == 0 && iArr == null) {
                return snapshotIdSet3;
            }
            return new SnapshotIdSet(j12 & j11, j13 & j14, i12, iArr);
        } else if (this.belowBound == null) {
            Iterator it = iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (snapshotIdSet2.get(intValue)) {
                    snapshotIdSet3 = snapshotIdSet3.set(intValue);
                }
            }
            return snapshotIdSet3;
        } else {
            Iterator it2 = snapshotIdSet.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Number) it2.next()).intValue();
                if (get(intValue2)) {
                    snapshotIdSet3 = snapshotIdSet3.set(intValue2);
                }
            }
            return snapshotIdSet3;
        }
    }

    @NotNull
    public final SnapshotIdSet andNot(@NotNull SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "bits");
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        int i11 = snapshotIdSet.lowerBound;
        int i12 = this.lowerBound;
        if (i11 == i12 && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet & (~snapshotIdSet.upperSet), this.lowerSet & (~snapshotIdSet.lowerSet), i12, iArr);
        }
        Iterator it = snapshotIdSet.iterator();
        SnapshotIdSet snapshotIdSet3 = this;
        while (it.hasNext()) {
            snapshotIdSet3 = snapshotIdSet3.clear(((Number) it.next()).intValue());
        }
        return snapshotIdSet3;
    }

    @NotNull
    public final SnapshotIdSet clear(int i11) {
        int[] iArr;
        int binarySearch;
        int i12 = i11;
        int i13 = this.lowerBound;
        int i14 = i12 - i13;
        if (i14 >= 0 && i14 < 64) {
            long j11 = 1 << i14;
            long j12 = this.lowerSet;
            if ((j12 & j11) != 0) {
                return new SnapshotIdSet(this.upperSet, j12 & (~j11), i13, this.belowBound);
            }
        } else if (i14 >= 64 && i14 < 128) {
            long j13 = 1 << (i14 - 64);
            long j14 = this.upperSet;
            if ((j14 & j13) != 0) {
                return new SnapshotIdSet(j14 & (~j13), this.lowerSet, i13, this.belowBound);
            }
        } else if (i14 < 0 && (iArr = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(iArr, i12)) >= 0) {
            int length = iArr.length - 1;
            if (length == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, (int[]) null);
            }
            int[] iArr2 = new int[length];
            if (binarySearch > 0) {
                int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, binarySearch);
            }
            if (binarySearch < length) {
                int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, binarySearch, binarySearch + 1, length + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final void fastForEach(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int[] access$getBelowBound$p = this.belowBound;
        if (access$getBelowBound$p != null) {
            for (int valueOf : access$getBelowBound$p) {
                function1.invoke(Integer.valueOf(valueOf));
            }
        }
        if (this.lowerSet != 0) {
            for (int i11 = 0; i11 < 64; i11++) {
                if ((this.lowerSet & (1 << i11)) != 0) {
                    function1.invoke(Integer.valueOf(this.lowerBound + i11));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i12 = 0; i12 < 64; i12++) {
                if ((this.upperSet & (1 << i12)) != 0) {
                    function1.invoke(Integer.valueOf(i12 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final boolean get(int i11) {
        int[] iArr;
        int i12 = i11 - this.lowerBound;
        boolean z11 = true;
        if (i12 < 0 || i12 >= 64) {
            if (i12 < 64 || i12 >= 128) {
                if (i12 > 0 || (iArr = this.belowBound) == null) {
                    return false;
                }
                if (SnapshotIdSetKt.binarySearch(iArr, i11) < 0) {
                    z11 = false;
                }
                return z11;
            } else if (((1 << (i12 - 64)) & this.upperSet) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (((1 << i12) & this.lowerSet) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @NotNull
    public Iterator<Integer> iterator() {
        return SequencesKt__SequenceBuilderKt.sequence(new SnapshotIdSet$iterator$1(this, (Continuation<? super SnapshotIdSet$iterator$1>) null)).iterator();
    }

    public final int lowest(int i11) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j11 = this.lowerSet;
        if (j11 != 0) {
            return this.lowerBound + SnapshotIdSetKt.lowestBitOf(j11);
        }
        long j12 = this.upperSet;
        if (j12 != 0) {
            return this.lowerBound + 64 + SnapshotIdSetKt.lowestBitOf(j12);
        }
        return i11;
    }

    @NotNull
    public final SnapshotIdSet or(@NotNull SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "bits");
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet;
        }
        int i11 = snapshotIdSet.lowerBound;
        int i12 = this.lowerBound;
        if (i11 == i12 && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet | snapshotIdSet.upperSet, this.lowerSet | snapshotIdSet.lowerSet, i12, iArr);
        }
        if (this.belowBound == null) {
            Iterator it = iterator();
            while (it.hasNext()) {
                snapshotIdSet = snapshotIdSet.set(((Number) it.next()).intValue());
            }
            return snapshotIdSet;
        }
        Iterator it2 = snapshotIdSet.iterator();
        SnapshotIdSet snapshotIdSet3 = this;
        while (it2.hasNext()) {
            snapshotIdSet3 = snapshotIdSet3.set(((Number) it2.next()).intValue());
        }
        return snapshotIdSet3;
    }

    @NotNull
    public final SnapshotIdSet set(int i11) {
        int i12;
        int[] iArr;
        int i13 = i11;
        int i14 = this.lowerBound;
        int i15 = i13 - i14;
        long j11 = 0;
        if (i15 >= 0 && i15 < 64) {
            long j12 = 1 << i15;
            long j13 = this.lowerSet;
            if ((j13 & j12) == 0) {
                return new SnapshotIdSet(this.upperSet, j13 | j12, i14, this.belowBound);
            }
        } else if (i15 >= 64 && i15 < 128) {
            long j14 = 1 << (i15 - 64);
            long j15 = this.upperSet;
            if ((j15 & j14) == 0) {
                return new SnapshotIdSet(j15 | j14, this.lowerSet, i14, this.belowBound);
            }
        } else if (i15 < 128) {
            int[] iArr2 = this.belowBound;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i14, new int[]{i13});
            }
            int binarySearch = SnapshotIdSetKt.binarySearch(iArr2, i13);
            if (binarySearch < 0) {
                int i16 = -(binarySearch + 1);
                int length = iArr2.length + 1;
                int[] iArr3 = new int[length];
                int[] unused = ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr3, 0, 0, i16);
                int[] unused2 = ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr3, i16 + 1, i16, length - 1);
                iArr3[i16] = i13;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr3);
            }
        } else if (!get(i11)) {
            long j16 = this.upperSet;
            long j17 = this.lowerSet;
            int i17 = this.lowerBound;
            int i18 = ((i13 + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j18 = j17;
            long j19 = j16;
            while (true) {
                if (i17 >= i18) {
                    i12 = i17;
                    break;
                }
                if (j18 != j11) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr4 = this.belowBound;
                        if (iArr4 != null) {
                            for (int valueOf : iArr4) {
                                arrayList.add(Integer.valueOf(valueOf));
                            }
                        }
                    }
                    for (int i19 = 0; i19 < 64; i19++) {
                        if (((1 << i19) & j18) != 0) {
                            arrayList.add(Integer.valueOf(i19 + i17));
                        }
                    }
                    j11 = 0;
                }
                if (j19 == j11) {
                    i12 = i18;
                    j18 = j11;
                    break;
                }
                i17 += 64;
                j18 = j19;
                j19 = j11;
            }
            if (arrayList == null || (iArr = CollectionsKt___CollectionsKt.toIntArray(arrayList)) == null) {
                iArr = this.belowBound;
            }
            return new SnapshotIdSet(j19, j18, i12, iArr).set(i13);
        }
        return this;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        sb2.append(ListUtilsKt.fastJoinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
